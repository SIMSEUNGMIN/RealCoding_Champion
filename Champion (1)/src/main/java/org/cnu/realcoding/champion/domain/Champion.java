package org.cnu.realcoding.champion.domain;

import lombok.Data;

@Data
public class Champion {
    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private long revisionDate;
    private String id;
    private String accountId;
}
