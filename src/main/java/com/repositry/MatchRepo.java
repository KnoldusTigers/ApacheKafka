package com.repositry;

import com.model.MatchResultModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepo extends MongoRepository<MatchResultModel, Long> {
}
