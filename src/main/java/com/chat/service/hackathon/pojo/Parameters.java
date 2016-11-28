
package com.chat.service.hackathon.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parameters {

    private List<String> product_service = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  

	public List<String> getProduct_service() {
		return product_service;
	}

	public void setProduct_service(List<String> product_service) {
		this.product_service = product_service;
	}

	public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

  
}
