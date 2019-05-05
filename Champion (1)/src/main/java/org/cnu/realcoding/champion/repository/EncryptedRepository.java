package org.cnu.realcoding.champion.repository;

import org.cnu.realcoding.champion.domain.Encrypted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EncryptedRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertEncrypted(Encrypted encrypted) {
        mongoTemplate.insert(encrypted);
    }
}
