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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.natspal.nconsole.client.api.impl.Operator;
import org.natspal.nconsole.client.api.impl.OperatorConfig;
import org.natspal.nconsole.client.api.impl.SigningKey;
import org.natspal.nconsole.client.jwt.Mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

public class OperatorTest {
    
    
    ObjectMapper mapper = Mapper.getObjectMapper();
    
    String operatorJwt = "{\n"
    		+ "	 \"create_user_id\": 1234,\n"
    		+ "	 \"update_user_id\": 4567,\n"
    		+ "	 \"create_date\": 1726642150,\n"
    		+ "	 \"update_date\": 1764562150, \n"
    		+ "  \"guid\": \"gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght\",\n"
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
            + "	   \"signing_key_list\" :[{\n"
            + "    \"create_user_id\": 2452675,\n"
            + "    	\"create_date\": 1698203628000,\n"
            + "    	\"update_user_id\": 5683636,\n"
            + "    	\"update_date\": 1698303628000,\n"
            + "  	\"description\": \"Primary signing key for production environment\",\n"
            + "  	\"iat\": 1698203628000,\n"
            + "  	\"exp\": 1713763628000,\n"
            + "  	\"id\": \"key-1234567890abcdef\",\n"
            + "  	\"is_default\": true,\n"
            + "  	\"key\": \"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnw5MfVpHxQ\",\n"
            + "  	\"entity_type\": \"operator\",\n"
            + "  	\"key_type\": \"sign\",\n"
            + "  	\"reference_guid\": \"tryry-hghgg-767hgfhf-hggjgh\"\n"
            + "		}],"
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
    	
    	
    	System.out.println(operatorJwt);
        
        IOperator operator = mapper.readValue(operatorJwt, Operator.class);
        
        
        // assert 
        assertEquals("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght", operator.getGuid());
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
        
        Set<? extends ISigningKey> signingKeyList = operatorConfig.getSigningKeyList();
        
        assertEquals(1,signingKeyList.size());
        
        ISigningKey signingKey = signingKeyList.iterator().next();
        
        assertNotNull(signingKey);
        
        
        assertEquals("Primary signing key for production environment",signingKey.getDescription());
        assertEquals(1698203628000l,signingKey.getIssueAt());
        assertEquals(1713763628000l,signingKey.getExpiry());
        assertEquals("key-1234567890abcdef",signingKey.getGuid());
        assertEquals(true,signingKey.isDefault());
        assertEquals("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnw5MfVpHxQ",signingKey.getKey());
        assertEquals(EntityType.operator,signingKey.getEntityType());
        assertEquals(KeyType.sign,signingKey.getKeyType());
        assertEquals("tryry-hghgg-767hgfhf-hggjgh",signingKey.getReferenceGuid());
        
        
        
        assertEquals("OCHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM",operatorConfig.getSigningKeys()[0]);
        
        assertEquals("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7",operatorConfig.getSystemAccount());
        
        assertTrue(operatorConfig.isStrictSigningKeyUsage());
        
        assertEquals(EntityType.operator,operatorConfig.getType());
        
        assertEquals(2,operatorConfig.getVersion());
        
        assertEquals(1234,operator.getCreateUserId());
        assertEquals(4567,operator.getUpdateUserId());
        assertEquals(1726642150,operator.getCreateDate());
        assertEquals(1764562150,operator.getUpdateDate());
        
        
    }

    /**
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Test
    public void serialize() throws JsonMappingException, JsonProcessingException {
        
        //when
        
        IOperator operator = new Operator();
        
        operator.setGuid("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght");
        operator.setJwtId("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA");
        
        operator.setIssueAt(1634840614);
        
        operator.setExpiry(1726642150);
        
        operator.setIssuer("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK");
        
        operator.setName("amit");
        
        operator.setSubject("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK");
        
        
        //IAuditMetadata audit_meta_data = new AuditMetadata();
        
        operator.setCreateUserId(347347352);
        operator.setUpdateUserId(345638567);
        operator.setCreateDate(77868667);
        operator.setUpdateDate(6767676);
        
        //operator.setAuditMetadata(audit_meta_data);
        
        IOperatorConfig operatorConfig = new OperatorConfig();
        
        operatorConfig.setAccountServerUrl("nats://localhost:4222");
        
        String[] serviceUrls =  new String[] {"nats://localhost:4222"};
        
        operatorConfig.setOperatorServiceUrls(serviceUrls);
        
        String[] signingKeys =  new String[] {"OCHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM"};
        
        Set<SigningKey> signingKeyList = new HashSet<SigningKey>();
        
        SigningKey signingKey = new SigningKey("Primary signing key for production environment", 1698203628000l, 1713763628000l, "key-1234567890abcdef", true, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnw5MfVpHxQ", EntityType.operator, KeyType.sign,"dfgh-dfjgj-dfjhgjg-dfjhgfjhf");
        
        signingKey.setCreateDate(1698203628000l);
        signingKey.setUpdateDate(1654203628000l);
        signingKey.setCreateUserId(2452675);
        signingKey.setUpdateUserId(5683636);
        
        signingKey.setSecret("Should not be serialized");
        
        signingKeyList.add(signingKey);
        
        operatorConfig.setSigningKeyList(signingKeyList);
        
        operatorConfig.setSigningKeys(signingKeys);
        
        operatorConfig.setSystemAccount("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7");
        
        operatorConfig.setStrictSigningKeyUsage(true);
        
        operatorConfig.setType(EntityType.operator);
        
        operatorConfig.setVersion(2);
        
        operator.setNats(operatorConfig);
        
        
        // Check assert
        
        String operatorString = mapper.writeValueAsString(operator);
        
        DocumentContext doc = JsonPath.parse(operatorString);
        
        assertEquals("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght", doc.read("$.guid"));
        
        assertEquals("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA", doc.read("$.jti"));
        
        assertEquals(Integer.valueOf(1634840614), doc.read("$.iat"));
        
        assertEquals(Integer.valueOf(1726642150), doc.read("$.exp"));
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", doc.read("$.iss"));
        assertEquals("amit", doc.read("$.name"));
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", doc.read("$.sub"));
        
        assertEquals("nats://localhost:4222",doc.read("$.nats.account_server_url"));
        
        assertEquals("nats://localhost:4222",doc.read("$.nats.operator_service_urls[0]"));
        
        assertEquals("OCHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM",doc.read("$.nats.signing_keys[0]"));
        
        // Signing key list 
        assertEquals("Primary signing key for production environment",doc.read("$.nats.signing_key_list[0].description"));
        assertEquals(Long.valueOf(1698203628000l), doc.read("$.nats.signing_key_list[0].iat"));
        assertEquals(Long.valueOf(1713763628000l), doc.read("$.nats.signing_key_list[0].exp"));
        assertEquals("Primary signing key for production environment",doc.read("$.nats.signing_key_list[0].description"));
        assertEquals(true,doc.read("$.nats.signing_key_list[0].is_default"));
        assertEquals("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnw5MfVpHxQ",doc.read("$.nats.signing_key_list[0].key"));
        assertEquals("operator",doc.read("$.nats.signing_key_list[0].entity_type"));
        assertEquals("sign",doc.read("$.nats.signing_key_list[0].key_type"));
        try {
        	assertNull(doc.read("$.nats.signing_key_list[0].secret"));
        }catch (PathNotFoundException e) {
			assertEquals("No results for path: $['nats']['signing_key_list'][0]['secret']",e.getMessage());
		}
        assertEquals("dfgh-dfjgj-dfjhgjg-dfjhgfjhf",doc.read("$.nats.signing_key_list[0].reference_guid"));
        
        
        // Signing key audit meta data
        assertEquals(Integer.valueOf(2452675), doc.read("$.nats.signing_key_list[0].create_user_id"));
        assertEquals(Long.valueOf(1698203628000l), doc.read("$.nats.signing_key_list[0].create_date"));
        assertEquals(Integer.valueOf(5683636), doc.read("$.nats.signing_key_list[0].update_user_id"));
        assertEquals(Long.valueOf(1654203628000l), doc.read("$.nats.signing_key_list[0].update_date"));
        
        
        assertEquals("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7",doc.read("$.nats.system_account"));
        
        assertEquals(true,doc.read("$.nats.strict_signing_key_usage"));
        
        assertEquals(EntityType.operator.name(),doc.read("$.nats.type"));
        
        assertEquals(Integer.valueOf(2),doc.read("$.nats.version"));
        
        assertEquals(Integer.valueOf(347347352),doc.read("$.create_user_id"));
        assertEquals(Integer.valueOf(345638567),doc.read("$.update_user_id"));
        assertEquals(Integer.valueOf(77868667),doc.read("$.create_date"));
        assertEquals(Integer.valueOf(6767676),doc.read("$.update_date"));
        
        
    }
}
