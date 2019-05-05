package org.cnu.realcoding.champion.api;

import org.cnu.realcoding.champion.domain.Champion;
import org.cnu.realcoding.champion.domain.Encrypted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinalInfoAPIClient {
    @Autowired
    private RestTemplate restTemplate;

    private String requestUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/{encryptedSummonerId}?api_key={api_key}";

    public Encrypted getEncryptedId(String encryptedSummonerId){
        return restTemplate.exchange(requestUrl, HttpMethod.GET, null, Encrypted.class, encryptedSummonerId, "RGAPI-5e07066d-a299-474f-8ef2-f76c8ce022f9").getBody();
    }
}
