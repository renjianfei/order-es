package com.hualala.order.es.repository;

import com.hualala.order.es.mapper.TblOrderMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by ben on 6/7/17.
 */
public interface TblOrderMasterEsRepository extends ElasticsearchRepository<TblOrderMaster, Long> {

}
