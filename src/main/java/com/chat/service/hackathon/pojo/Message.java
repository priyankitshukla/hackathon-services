
package com.chat.service.hackathon.pojo;

import java.util.HashMap;
import java.util.Map;


public class Message {

    private Integer type;
    private String speech;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The speech
     */
    public String getSpeech() {
        return speech;
    }

    /**
     * 
     * @param speech
     *     The speech
     */
    public void setSpeech(String speech) {
        this.speech = speech;
    }

  

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

   

   
}
