
package com.chat.service.hackathon.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Status {

    private Integer code;
    private String errorType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The errorType
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * 
     * @param errorType
     *     The errorType
     */
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

  

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

   

}
