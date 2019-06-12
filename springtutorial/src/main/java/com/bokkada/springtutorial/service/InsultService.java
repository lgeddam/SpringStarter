package com.bokkada.springtutorial.service;

import com.bokkada.springtutorial.pojo.InsultGreeting;

public interface InsultService {
     public abstract InsultGreeting getRandomInsult();
     public abstract InsultGreeting getDesiInsult();
     public abstract void putNewInsult(final InsultGreeting insult);
}
