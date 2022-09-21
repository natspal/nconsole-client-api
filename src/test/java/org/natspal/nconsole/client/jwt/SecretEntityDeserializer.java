// Copyright 2022 The NATSPAL Authors
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at:
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package org.natspal.nconsole.client.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.natspal.nconsole.client.exceptions.JWTDecodeException;

/***
 * 
 * @author Amit K Gupta
 *
 * 
 */

abstract class SecretEntityDeserializer<T> extends StdDeserializer<T> {

    private static final long serialVersionUID = 1L;
    private final ObjectReader objectReader;
    
    SecretEntityDeserializer(ObjectReader reader) {
        this(null, reader);
    }

    protected SecretEntityDeserializer(Class<?> vc, ObjectReader reader) {
        super(vc);
        
        this.objectReader = reader;
    }
    
    /**
     * 
     * @param <U>
     * @param tree the json tree
     * @param claimName  the claim name
     * @param valueType the type 
     * @return return the valueType object
     * @throws JWTDecodeException
     */

    <U> U getObject(Map<String, JsonNode> tree, String claimName,Class<U> valueType) throws JWTDecodeException {
        if(tree==null) {
        	return null;
        }
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull() || !(node.isObject() || node.isTextual())) {
            return null;
        }
        if (node.isTextual() && !node.asText().isEmpty()) {
            return null;
        }

        try {
             return objectReader.treeToValue(node, valueType);
        } catch (JsonProcessingException e) {
            throw new JWTDecodeException("Couldn't map the Claim's  object", e);
        }
    }
    
    /**
     * 
     * @param <U>
     * @param tree the json tree
     * @param claimName  the claim name
     * @param valueType the type
     * @return return the list of valueType
     * @throws JWTDecodeException
     */
    
    <U> List<U> getObjectList(Map<String, JsonNode> tree, String claimName,Class<U> valueType) throws JWTDecodeException {
    	if(tree==null) {
        	return null;
        }
    	
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull() || !(node.isArray() || node.isTextual())) {
            return null;
        }
        

        List<U> list = new ArrayList<U>();
	    try {    
        	for (int i = 0; i < node.size(); i++) {
	        	list.add(objectReader.treeToValue(node.get(i), valueType));
	        }
	    } catch (JsonProcessingException e) {
	        throw new JWTDecodeException("Couldn't map the Claim's object", e);
	    }
        
        return list;
    }
    
    /**
     * 
     * @param tree the json tree
     * @param claimName the claim name
     * @return return the array of string
     * @throws JWTDecodeException
     */
    
    String[] getArray(Map<String, JsonNode> tree, String claimName) throws JWTDecodeException {
    	if(tree==null) {
        	return null;
        }
    	
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull() || !(node.isArray() || node.isTextual())) {
            return null;
        }
        if (node.isTextual() && !node.asText().isEmpty()) {
            return new String[]{node.asText()};
        }

        String[] array = new String[node.size()];
        for (int i = 0; i < node.size(); i++) {
            try {
                array[i] = objectReader.treeToValue(node.get(i), String.class);
            } catch (JsonProcessingException e) {
                throw new JWTDecodeException("Couldn't map the Claim's array contents", e);
            }
        }
        return array;
    }
    
    /**
     * 
     * @param tree json tree
     * @param claimName teh claim name
     * @return return the list of striing 
     * @throws JWTDecodeException
     */
    
    List<String> getStringOrArray(Map<String, JsonNode> tree, String claimName) throws JWTDecodeException {
    	if(tree==null) {
        	return null;
        }
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull() || !(node.isArray() || node.isTextual())) {
            return null;
        }
        if (node.isTextual() && !node.asText().isEmpty()) {
            return Collections.singletonList(node.asText());
        }

        List<String> list = new ArrayList<>(node.size());
        for (int i = 0; i < node.size(); i++) {
            try {
                list.add(objectReader.treeToValue(node.get(i), String.class));
            } catch (JsonProcessingException e) {
                throw new JWTDecodeException("Couldn't map the Claim's array contents", e);
            }
        }
        return list;
    }

    /**
     * 
     * @param tree json tree
     * @param claimName the claim name
     * @return return the integer
     */
    
    int getInt(Map<String, JsonNode> tree, String claimName) throws JWTDecodeException{
    	if(tree==null) {
        	return 0;
        }
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull()) {
            return -1;
        }
        if (!node.canConvertToInt()) {
            throw new JWTDecodeException(String.format("The claim '%s' contained a non-numeric value.", claimName));
        }
        return node.asInt();
    }
    
    /**
     * 
     * @param tree json tree
     * @param claimName the claim name
     * @return return the Long
     */
    
    Long getLong(Map<String, JsonNode> tree, String claimName) throws JWTDecodeException{
    	if(tree==null) {
        	return null;
        }
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull()) {
            return null;
        }
        if (!node.canConvertToLong()) {
            throw new JWTDecodeException(String.format("The claim '%s' contained a non long value.", claimName));
        }
        return node.asLong();
    }

    /**
     * 
     * @param tree json tree
     * @param claimName the claim name
     * @return return the string
     */
    
    String getString(Map<String, JsonNode> tree, String claimName) throws JWTDecodeException{
    	if(tree==null) {
        	return null;
        }
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull()) {
            return null;
        }
        return node.asText(null);
    }
    
    /**
     * 
     * @param tree json tree
     * @param claimName the claim name
     * @return  the json map
     */
    
    Map<String, JsonNode> getMap(Map<String, JsonNode> tree, String claimName) {
    	if(tree==null) {
        	return null;
        }
    	JsonNode node = tree.get(claimName);
        if (node == null || node.isNull()) {
            return null;
        }
        
        ObjectMapper mapper = new ObjectMapper();
        
        Map<String, JsonNode> result = mapper.convertValue(node, new TypeReference<Map<String, JsonNode>>(){});
        return result;
    }
}
