package com.bokkada.springtutorial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.bokkada.springtutorial.pojo.InsultGreeting;

@Service
public class InsultServiceImpl implements InsultService {
    
    private final List<String> insults;
    private final List<String> desiInsults;
    
    public InsultServiceImpl() {
        this.insults = new ArrayList<>();
        this.desiInsults = new ArrayList<>();
        this.insults.add("You, sir, are an oxygen thief!");
        this.desiInsults.add("Go to patny");
    }

    @Override
    public InsultGreeting getRandomInsult() {
      final int randomNum = ThreadLocalRandom.current().nextInt(0, insults.size());
      return new InsultGreeting("regular", insults.get(randomNum));
    }

    @Override
    public InsultGreeting getDesiInsult() {
        final int randomNum = ThreadLocalRandom.current().nextInt(0, desiInsults.size());
        return new InsultGreeting("desi",desiInsults.get(randomNum));
    }

    @Override
    public void putNewInsult(final InsultGreeting insult) {
        if(insult != null) {
            if(insult.getType().equalsIgnoreCase("desi")) {
                desiInsults.add(insult.getInsult());
            } else if(insult.getType().equalsIgnoreCase("regular")) {
                insults.add(insult.getInsult());
            } else {
                throw new RuntimeException("Invalid insult type: "+ insult.getType());
            }
        } else {
            throw new RuntimeException("Missing parameters!");
        }
    }

}
