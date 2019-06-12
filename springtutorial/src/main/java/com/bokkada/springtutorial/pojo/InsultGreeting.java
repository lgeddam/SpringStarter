package com.bokkada.springtutorial.pojo;

public class InsultGreeting {
    
    private String type;
    private String insult;
    
    public InsultGreeting() {}
    
    public InsultGreeting(final String type, final String insult) {
        this.type = type;
        this.insult =insult;
    }
    
    public String getType() {
        return type;
    }

    public String getInsult() {
        return insult;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInsult(String insult) {
        this.insult = insult;
    }

}
