package com.railway.MainAdmin.repositories;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.railway.MainAdmin.models.Train;


@Repository
public interface MainAdminRepository extends MongoRepository<Train, String> {

}
