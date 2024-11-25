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
import java.util.List;
import java.util.Map;
import org.natspal.nconsole.client.api.EntityType;
import org.natspal.nconsole.client.api.impl.Account;
import org.natspal.nconsole.client.api.impl.AccountConfig;
import org.natspal.nconsole.client.api.impl.AccountDefaultPermission;
import org.natspal.nconsole.client.api.impl.AccountLimits;
import org.natspal.nconsole.client.api.impl.AuditMetadata;
import org.natspal.nconsole.client.api.impl.Export;
import org.natspal.nconsole.client.api.impl.Import;
import org.natspal.nconsole.client.api.impl.Operator;
import org.natspal.nconsole.client.api.impl.PublishPermission;
import org.natspal.nconsole.client.api.impl.SubscribePermission;
import org.natspal.nconsole.client.exceptions.JWTDecodeException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;

/***
 * 
 * @author Amit K Gupta
 *
 */

class AccountDeserializer extends SecretEntityDeserializer<Account> {

    private static final long serialVersionUID = 1L;
    
    AccountDeserializer(ObjectReader reader) {
        this(null, reader);
    }

    private AccountDeserializer(Class<?> vc, ObjectReader reader) {
        super(vc,reader);
    }

    @Override
    public Account deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Map<String, JsonNode> tree = p.getCodec().readValue(p, new TypeReference<Map<String, JsonNode>>() {
        });
        if (tree == null) {
            throw new JWTDecodeException("Parsing the Payload's JSON resulted on a Null map");
        }

        String operatorIdKey = getString(tree, "operator_idkey");
        
        String id = getString(tree, JsonClaims.ID);
        
        String issuer = getString(tree, JwtClaims.ISSUER);
        String subject = getString(tree, JwtClaims.SUBJECT);
        String name = getString(tree, JwtClaims.NAME);
        
        Map<String, JsonNode> natsConfig = getMap(tree, JwtClaims.NATS);
        
        // Get export & import from nats config 
        List<Export> exports = getObjectList(natsConfig, JwtClaims.EXPORTS, Export.class);
        
        List<Import> imports = getObjectList(natsConfig, JwtClaims.IMPORTS, Import.class);
        
        AccountLimits accountLImits = getObject(natsConfig, JwtClaims.LIMITS,AccountLimits.class);
        
        Map<String, JsonNode> defaultPermissionMap = getMap(natsConfig, JwtClaims.DEFAULT_PERMISSIONS);
        
        
        PublishPermission pubPermission = getObject(defaultPermissionMap, JwtClaims.PUBLISH,PublishPermission.class);
        
        SubscribePermission subPermission = getObject(defaultPermissionMap, JwtClaims.SUBSCRIBE,SubscribePermission.class);
        
        
        AccountDefaultPermission defaultPermission = new AccountDefaultPermission(pubPermission,subPermission);
        
        
        String[] signingKeys = getArray(natsConfig, JwtClaims.SIGNING_KEYS);
        
        String entityType = getString(natsConfig, JwtClaims.ENTITY_TYPE);
        
        EntityType type =   EntityType.valueOf(entityType);
        
        
        int version = getInt(natsConfig, JwtClaims.VERSION);
        
        AccountConfig accountConfig = new AccountConfig(exports,imports,defaultPermission, accountLImits, signingKeys,type, version);
        
        
        Long issAt = getLong(tree, JwtClaims.ISSUED_AT);
        long issuedAt = issAt==null?0l:issAt;
        
        Long exp = getLong(tree, JwtClaims.EXPIRY);
        long expiry = exp==null?0l:exp;
        
        String jwtId = getString(tree, JwtClaims.JWT_ID);
        
        AuditMetadata auditMetadata = getObject(tree, JsonClaims.AUDIT_META_DATA,AuditMetadata.class);
        
        
        Account account = new Account(operatorIdKey,jwtId, issuedAt,expiry, issuer, name, subject, accountConfig);
        
        account.setId(id);
        
        account.setAuditMetadata(auditMetadata);

        return account;
    }

    
    
}
