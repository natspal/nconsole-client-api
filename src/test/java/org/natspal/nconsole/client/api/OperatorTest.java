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
package org.natspal.nconsole.client.api;
/**
 * 
 * @author Amit K Gupta
 *
 */

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.natspal.nconsole.client.api.impl.Operator;
import org.natspal.nconsole.client.api.impl.OperatorConfig;
import org.natspal.nconsole.client.jwt.Mapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class OperatorTest {
    
    
    ObjectMapper mapper = Mapper.getObjectMapper();
    
    String operatorJwt = "{\n"
            + "  \"jti\": \"S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA\",\n"
            + "  \"iat\": 1634840614,\n"
            + "  \"exp\": 1726642150,\n"
            + "  \"iss\": \"OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK\",\n"
            + "  \"name\": \"amit\",\n"
            + "  \"sub\": \"OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK\",\n"
            + "  \"nats\": {\n"
            + "    \"account_server_url\": \"nats://localhost:4222\",\n"
            + "    \"operator_service_urls\": [\n"
            + "      \"nats://localhost:4222\"\n"
            + "    ],\n"
            + "    \"signing_keys\": [\n"
            + "        \"OCHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM\" \n"
            + "    ], \n"
            + "     \"strict_signing_key_usage\": true, \n"
            + "    \"system_account\": \"ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7\",\n"
            + "    \"type\": \"operator\",\n"
            + "    \"version\": 2\n"
            + "  }\n"
            + "}";
    
    
    /**
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Test
    public void deserialize() throws JsonMappingException, JsonProcessingException {
        
        //when
        
        IOperator operator = mapper.readValue(operatorJwt, Operator.class);
        
        
        // assert 
        assertEquals("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA", operator.getJwtId());
        assertEquals(1634840614, operator.getIssueAt());
        
        assertEquals(1726642150, operator.getExpiry());
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", operator.getIssuer());
        assertEquals("amit", operator.getName());
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", operator.getSubject());
        
        IOperatorConfig operatorConfig = (IOperatorConfig)operator.getNats();
        
        assertEquals("nats://localhost:4222",operatorConfig.getAccountServerUrl());
        
        assertEquals(1,operatorConfig.getOperatorServiceUrls().length);
        
        assertEquals("nats://localhost:4222",operatorConfig.getOperatorServiceUrls()[0]);
        
        assertEquals(1,operatorConfig.getSigningKeys().length);
        
        assertEquals("OCHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM",operatorConfig.getSigningKeys()[0]);
        
        assertEquals("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7",operatorConfig.getSystemAccount());
        
        assertTrue(operatorConfig.isStrictSigningKeyUsage());
        
        assertEquals(EntityType.operator,operatorConfig.getType());
        
        assertEquals(2,operatorConfig.getVersion());
        
    }

    /**
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Test
    public void serialize() throws JsonMappingException, JsonProcessingException {
        
        //when
        
        IOperator operator = new Operator();
        
        operator.setJwtId("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA");
        
        operator.setIssueAt(1634840614);
        
        operator.setExpiry(1726642150);
        
        operator.setIssuer("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK");
        
        operator.setName("amit");
        
        operator.setSubject("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK");
        
        IOperatorConfig operatorConfig = new OperatorConfig();
        
        operatorConfig.setAccountServerUrl("nats://localhost:4222");
        
        String[] serviceUrls =  new String[] {"nats://localhost:4222"};
        
        operatorConfig.setOperatorServiceUrls(serviceUrls);
        
        String[] signingKeys =  new String[] {"OCHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM"};
        
        operatorConfig.setSigningKeys(signingKeys);
        
        operatorConfig.setSystemAccount("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7");
        
        operatorConfig.setStrictSigningKeyUsage(true);
        
        operatorConfig.setType(EntityType.operator);
        
        operatorConfig.setVersion(2);
        
        operator.setNats(operatorConfig);
        
        
        // Check assert
        
        String operatorString = mapper.writeValueAsString(operator);
        
        DocumentContext doc = JsonPath.parse(operatorString);
        
        assertEquals("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA", doc.read("$.jti"));
        
        assertEquals(new Integer(1634840614), doc.read("$.iat"));
        
        assertEquals(new Integer(1726642150), doc.read("$.exp"));
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", doc.read("$.iss"));
        assertEquals("amit", doc.read("$.name"));
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", doc.read("$.sub"));
        
        assertEquals("nats://localhost:4222",doc.read("$.nats.account_server_url"));
        
        assertEquals("nats://localhost:4222",doc.read("$.nats.operator_service_urls[0]"));
        
        assertEquals("OCHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM",doc.read("$.nats.signing_keys[0]"));
        
        assertEquals("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7",doc.read("$.nats.system_account"));
        
        assertTrue(doc.read("$.nats.strict_signing_key_usage"));
        
        assertEquals(EntityType.operator.name(),doc.read("$.nats.type"));
        
        assertEquals(new Integer(2),doc.read("$.nats.version"));
        
        
    }
}
