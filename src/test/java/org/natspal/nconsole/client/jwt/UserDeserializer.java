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

import java.io.IOException;
import java.util.Map;
import org.natspal.nconsole.client.api.EntityType;
import org.natspal.nconsole.client.api.IPublishPermission;
import org.natspal.nconsole.client.api.ISubscribePermission;
import org.natspal.nconsole.client.api.impl.AuditMetadata;
import org.natspal.nconsole.client.api.impl.PublishPermission;
import org.natspal.nconsole.client.api.impl.SubscribePermission;
import org.natspal.nconsole.client.api.impl.User;
import org.natspal.nconsole.client.api.impl.UserConfig;
import org.natspal.nconsole.client.exceptions.JWTDecodeException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;
/**
 * 
 * @author Amit K Gupta
 *
 */
class UserDeserializer extends SecretEntityDeserializer<User> {

    private static final long serialVersionUID = 1L;
    
    UserDeserializer(ObjectReader reader) {
        this(null, reader);
    }

    private UserDeserializer(Class<?> vc, ObjectReader reader) {
        super(vc,reader);
    }

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
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
        
        
        Map<String, JsonNode> pubPermissionMap = getMap(natsConfig, JwtClaims.PUBLISH);
        
        Map<String, JsonNode> subPermissionMap = getMap(natsConfig, JwtClaims.SUBSCRIBE);
        
        
        String[] pubAllow = getArray(pubPermissionMap, JwtClaims.ALLOW);
        String[] pubDeny = getArray(pubPermissionMap, JwtClaims.DENY);
        
        IPublishPermission pubPermission = new PublishPermission(pubAllow,pubDeny);
        
        
       
        String[] subAllow = getArray(subPermissionMap, JwtClaims.ALLOW);
        String[] subDeny = getArray(subPermissionMap, JwtClaims.DENY);
        
        ISubscribePermission subPermission = new SubscribePermission(subAllow,subDeny);
        
        
        int subs = getInt(natsConfig, JwtClaims.SUBSCRIPTIONS);
        
        int data = getInt(natsConfig, JwtClaims.DATA);
        
        int payload = getInt(natsConfig, JwtClaims.PAYLOAD);
        
        String issuerAccount = getString(natsConfig, JwtClaims.ISSUER_ACCOUNT);
        
        String type = getString(natsConfig, JwtClaims.ENTITY_TYPE);
        EntityType entityType = type==null ? EntityType.user : EntityType.valueOf(type);
        
        int version = getInt(natsConfig, JwtClaims.VERSION);
        
        UserConfig userConfig = new UserConfig(pubPermission, subPermission,subs, data,payload, issuerAccount,entityType, version);
        
        Long issuedAt = getLong(tree, JwtClaims.ISSUED_AT);
        issuedAt = issuedAt==null? System.currentTimeMillis():issuedAt;
        
        Long exp = getLong(tree, JwtClaims.EXPIRY);
        long expiry = exp==null?0l:exp;
        
        String jwtId = getString(tree, JwtClaims.JWT_ID);
        
        AuditMetadata auditMetadata = getObject(tree, JsonClaims.AUDIT_META_DATA,AuditMetadata.class);
        
        
        User user = new User(null,jwtId, issuedAt,expiry, issuer, name, subject, userConfig);
        
        user.setGuid(id);
        
        user.setAuditMetadata(auditMetadata);

        return user;
    }

    
    
}
