
package com.chat.service.hackathon.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private String source;
    private String resolvedQuery;
    private String action;
    private Boolean actionIncomplete;
    private Parameters parameters;
    private List<Object> contexts = new ArrayList<Object>();
    private Metadata metadata;
    private Fulfillment fulfillment;
    private Double score;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The resolvedQuery
     */
    public String getResolvedQuery() {
        return resolvedQuery;
    }

    /**
     * 
     * @param resolvedQuery
     *     The resolvedQuery
     */
    public void setResolvedQuery(String resolvedQuery) {
        this.resolvedQuery = resolvedQuery;
    }

    /**
     * 
     * @return
     *     The action
     */
    public String getAction() {
        return action;
    }

    /**
     * 
     * @param action
     *     The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 
     * @return
     *     The actionIncomplete
     */
    public Boolean getActionIncomplete() {
        return actionIncomplete;
    }

    /**
     * 
     * @param actionIncomplete
     *     The actionIncomplete
     */
    public void setActionIncomplete(Boolean actionIncomplete) {
        this.actionIncomplete = actionIncomplete;
    }

    /**
     * 
     * @return
     *     The parameters
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * 
     * @param parameters
     *     The parameters
     */
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     * @return
     *     The contexts
     */
    public List<Object> getContexts() {
        return contexts;
    }

    /**
     * 
     * @param contexts
     *     The contexts
     */
    public void setContexts(List<Object> contexts) {
        this.contexts = contexts;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * 
     * @return
     *     The fulfillment
     */
    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    /**
     * 
     * @param fulfillment
     *     The fulfillment
     */
    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    /**
     * 
     * @return
     *     The score
     */
    public Double getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    public void setScore(Double score) {
        this.score = score;
    }



    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

  

}
