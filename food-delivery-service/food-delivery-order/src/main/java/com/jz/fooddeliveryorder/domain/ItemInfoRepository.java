package com.jz.fooddeliveryorder.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by vagrant on 7/1/17.
 */
@RepositoryRestResource(path = "ItemInfo")
public interface ItemInfoRepository extends MongoRepository<ItemInfo, Long> {
    @RestResource(path = "ItemInfo")
    List<ItemInfo> findAllBy();

    @RestResource(path = "delete")
    void deleteAllBy();
}
