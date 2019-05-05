package org.cnu.realcoding.champion.controller;

import org.cnu.realcoding.champion.domain.Champion;
import org.cnu.realcoding.champion.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @GetMapping("/RiotGames/get-summonersm")
    public Champion getChampion()
    {
        return championService.getChampionInfo();
    }
}
