package org.cnu.realcoding.champion.service;

import org.cnu.realcoding.champion.api.ChampionAPIClient;
import org.cnu.realcoding.champion.api.FinalInfoAPIClient;
import org.cnu.realcoding.champion.domain.Champion;
import org.cnu.realcoding.champion.domain.Encrypted;
import org.cnu.realcoding.champion.repository.ChampionRepository;
import org.cnu.realcoding.champion.repository.EncryptedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ChampionService {
    @Autowired
    AvailableEncryptedNamesService availableEncryptedNamesService;
    @Autowired
    private AvailableChampionNamesService availableChampionNamesService;

    @Autowired
    private ChampionAPIClient championAPIClient;

    @Autowired
    private FinalInfoAPIClient finalInfoAPIClient;

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private EncryptedRepository encryptedRepository;

    private LinkedList<String> queue = new LinkedList();

    public List<String> getChampionNames(){
        return availableChampionNamesService.getChampionNames();
    }


    //그냥 디비에 보이드로 넣음
    public Champion getChampionInfo(){
        if(queue.isEmpty()){
            queue.addAll(this.getChampionNames());
        }

        String target = queue.pop(); //큐에서 하나 꺼냄

        Champion champion = championAPIClient.getChampionId(target); //pop해서 받은 target을 인자로 넣어서 api로 부터 해당 target(summonerName)일때의 정보를 불러옴
        availableEncryptedNamesService.setId(champion.getId()); //id가 들어감
        List<String> getList = availableEncryptedNamesService.getEncryptedNames();

        Encrypted champion1 = finalInfoAPIClient.getEncryptedId(getList.get(0));
        //id를 바탕으로 이제 검색해서 저장을 해야함.(현재 하나만 넣어놓은 상태라 일부러 get0을 함)
        //나중에 여러 개를 넣을 때는 for을 사용해서 순처적으로 넣어주면 됨.
        //밑의 코드를 사용하면 여러 개도 가능함

//        for(int i = 0; i < getList.size(); i++){
//            Encrypted champion1 = finalInfoAPIClient.getEncryptedId(getList.get(i));
//            encryptedRepository.insertEncrypted(champion1);
//            System.out.println("몽고디비에 저장 : " + champion1);
//        }

        encryptedRepository.insertEncrypted(champion1); //몽고 디비에 저장
        System.out.println("몽고디비에 저장 : " + champion1);
        return champion;

    }
}
