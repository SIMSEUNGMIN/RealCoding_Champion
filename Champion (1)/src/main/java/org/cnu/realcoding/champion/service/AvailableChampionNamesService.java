package org.cnu.realcoding.champion.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableChampionNamesService {
    private String[] championNames = {
            "Hide on bush"
    };

    public List<String> getChampionNames() {
        List<String> collect = Arrays.stream(championNames).collect(Collectors.toList());
        return collect;
    }

}
