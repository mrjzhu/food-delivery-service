package com.jz.fooddeliveryresturant.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


/**
 * Created by vagrant on 6/24/17.
 */
@RepositoryRestResource(path = "ResturantInfo")
public interface ResturantInfoRepository extends MongoRepository<ResturantInfo, Long> {


    @RestResource(path = "Resturant")
    List<ResturantInfo> findAllByName(String name);

    @RestResource(path = "Resturant")
    List<ResturantInfo> findAllBy();

    @RestResource(path = "delete")
    void deleteAllBy();
}
