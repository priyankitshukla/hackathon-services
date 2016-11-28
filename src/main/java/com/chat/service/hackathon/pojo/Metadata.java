
package com.chat.service.hackathon.pojo;

import java.util.HashMap;
import java.util.Map;


public class Metadata {

    private String intentId;
    private String webhookUsed;
    private String intentName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The intentId
     */
    public String getIntentId() {
        return intentId;
    }

    /**
     * 
     * @param intentId
     *     The intentId
     */
    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    /**
     * 
     * @return
     *     The webhookUsed
     */
    public String getWebhookUsed() {
        return webhookUsed;
    }

    /**
     * 
     * @param webhookUsed
     *     The webhookUsed
     */
    public void setWebhookUsed(String webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    /**
     * 
     * @return
     *     The intentName
     */
    public String getIntentName() {
        return intentName;
    }

    /**
     * 
     * @param intentName
     *     The intentName
     */
    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

  
   

}
