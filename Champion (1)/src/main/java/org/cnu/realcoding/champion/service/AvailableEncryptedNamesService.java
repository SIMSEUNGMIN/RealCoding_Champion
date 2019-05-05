package org.cnu.realcoding.champion.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AvailableEncryptedNamesService {
    List<String> collect = new ArrayList<String>();

    public void setId(String id) {
        collect.add(id);
    }

    public List<String> getEncryptedNames() {
        return collect;
    }
}
