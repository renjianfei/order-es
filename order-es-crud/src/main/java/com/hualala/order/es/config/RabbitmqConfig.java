package com.hualala.order.es.config;

import com.hualala.order.es.listener.IMqCallback;
import com.hualala.order.es.listener.impl.OrderEsCallback;
import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ben on 2/17/17.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitmqConfig {
    public static final String LISTENER_METHOD = "callback";
    //order es data
    private String orderQueryDataExchangeName;// mul_hll:service:order:query:db:exchange
    private String orderESDataQueueName;// mu_hll:service:order:query:db:queue


    @Autowired
    private IMqCallback orderEsCallback;


    //order query
    @Bean
    Queue orderEsDataQueue() {
        return new Queue(orderESDataQueueName, true);
    }

    @Bean
    FanoutExchange orderQueryDataExchange() {
        return new FanoutExchange(orderQueryDataExchangeName);
    }

    @Bean
    Binding orderEsDataBinding(@Qualifier("orderEsDataQueue") Queue queue,
                               @Qualifier("orderQueryDataExchange") FanoutExchange exchange) {

        return BindingBuilder.bind(queue).to(exchange);
    }

    //legacy db listener
    @Bean
    SimpleMessageListenerContainer orderEsDataListenerContainer(ConnectionFactory connectionFactory,
                                                                MessageListenerAdapter orderEsDataListenerAdapter) {
        return getSimpleMessageListenerContainer(connectionFactory, orderEsDataListenerAdapter, orderESDataQueueName);
    }

    @Bean
    MessageListenerAdapter orderEsDataListenerAdapter(OrderEsCallback orderEsCallback) {

        return new MessageListenerAdapter(orderEsCallback, LISTENER_METHOD);
    }


    //awk
    private SimpleMessageListenerContainer getSimpleMessageListenerContainer(ConnectionFactory connectionFactory,
                                                                             MessageListenerAdapter listenerAdapter,
                                                                             String queueName) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        container.setErrorHandler(new ConditionalRejectingErrorHandler(
                t -> t instanceof ListenerExecutionFailedException));
        return container;
    }


}
