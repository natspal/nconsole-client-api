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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.util.*;

import org.natspal.nconsole.client.api.EntityType;
import org.natspal.nconsole.client.api.KeyType;
import org.natspal.nconsole.client.api.impl.AuditMetadata;
import org.natspal.nconsole.client.api.impl.Operator;
import org.natspal.nconsole.client.api.impl.OperatorConfig;
import org.natspal.nconsole.client.api.impl.SigningKey;
import org.natspal.nconsole.client.exceptions.JWTDecodeException;
/**
 * 
 * @author Amit K Gupta
 *
 */

class OperatorDeserializer extends SecretEntityDeserializer<Operator> {

    private static final long serialVersionUID = 1L;
    
    OperatorDeserializer(ObjectReader reader) {
        this(null, reader);
    }

    private OperatorDeserializer(Class<?> vc, ObjectReader reader) {
        super(vc,reader);
    }

    @Override
    public Operator deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Map<String, JsonNode> tree = p.getCodec().readValue(p, new TypeReference<Map<String, JsonNode>>() {
        });
        if (tree == null) {
            throw new JWTDecodeException("Parsing the Payload's JSON resulted on a Null map");
        }

        String id = getString(tree, JsonClaims.GUID);
        
        String issuer = getString(tree, JwtClaims.ISSUER);
        String subject = getString(tree, JwtClaims.SUBJECT);
        String name = getString(tree, JwtClaims.NAME);
        
        Map<String, JsonNode> natsConfig = getMap(tree, JwtClaims.NATS);
        
        List<SigningKey> signingKeyList = new ArrayList<SigningKey>();
        
        
        List<Map<String, JsonNode>> signingKeyListMap = getListMap(natsConfig, JsonClaims.SIGNING_KEY_LIST);
        
        
        if(signingKeyListMap!=null && !signingKeyListMap.isEmpty()) {
        	
        	for(Map map: signingKeyListMap) {
        		
        		AuditMetadata auditMetadata = getObject(map, JsonClaims.AUDIT_META_DATA,AuditMetadata.class);
        		
        		String  description = getString(map, JsonClaims.SIGNING_KEY.DESCRIPTION);
        		Long    issueAt 	= getLong(map, JsonClaims.SIGNING_KEY.ISSUE_AT);
        		Long    expireAt    = getLong(map, JsonClaims.SIGNING_KEY.EXPIRE_AT);
        		String  sid 		= getString(map, JsonClaims.SIGNING_KEY.ID);
        		Boolean isDefault   = getBoolean(map, JsonClaims.SIGNING_KEY.IS_DEFAULT);
        		String  key         = getString(map, JsonClaims.SIGNING_KEY.KEY);
        		String entityType   = getString(map, JsonClaims.SIGNING_KEY.ENTITY_TYPE);
        		String keyType   = getString(map, JsonClaims.SIGNING_KEY.KEY_TYPE);
        		
        		SigningKey signingKey = new SigningKey(auditMetadata, description, issueAt, expireAt, sid, isDefault, key, EntityType.valueOf(entityType),KeyType.valueOf(keyType));
        		
        		signingKeyList.add(signingKey); 
        	}
        	
        	
        }
        
        
        String accountServerUrl = getString(natsConfig, JwtClaims.OPERATOR.ACCOUNT_SERVER_URL);
        
        String[] operatorServiceUrls = getArray(natsConfig, JwtClaims.OPERATOR.OPERATOR_SERVICE_URLS);
        
        String[] signingKeys = getArray(natsConfig, JwtClaims.SIGNING_KEYS);
        
        Boolean strictSigningKeyUsage = getBoolean(natsConfig, JwtClaims.OPERATOR.STRICT_SIGNING_KEY_USAGE);
        
        String systemAccount = getString(natsConfig, JwtClaims.OPERATOR.SYSTEM_ACCOUNT);
        
        String type = getString(natsConfig, JwtClaims.ENTITY_TYPE);
        
        int version = getInt(natsConfig, JwtClaims.VERSION);
        
        
        OperatorConfig operatorConfig = new OperatorConfig(accountServerUrl,operatorServiceUrls,signingKeys,signingKeyList,strictSigningKeyUsage.booleanValue(),systemAccount,EntityType.valueOf(type),version);
        
        Long issAt = getLong(tree, JwtClaims.ISSUED_AT);
        long issuedAt = issAt==null?0l:issAt;
        
        Long exp = getLong(tree, JwtClaims.EXPIRY);
        long expiry = exp==null?0l:exp;
        
        String jwtId = getString(tree, JwtClaims.JWT_ID);
        
        
        
        AuditMetadata auditMetadata = getObject(tree, JsonClaims.AUDIT_META_DATA,AuditMetadata.class);
        
        
        Operator operator = new Operator(true,jwtId, issuedAt,expiry,issuer, name, subject, operatorConfig);
        
        operator.setGuid(id);
        
        operator.setAuditMetadata(auditMetadata);
        
        
        return operator;
    }

    
    
}
