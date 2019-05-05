package org.cnu.realcoding.champion.repository;

import org.cnu.realcoding.champion.domain.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChampionRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertChampion(Champion champion) {
        mongoTemplate.insert(champion);
    }

}