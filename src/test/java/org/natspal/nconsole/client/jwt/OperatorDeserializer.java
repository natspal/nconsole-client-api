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
import org.natspal.nconsole.client.api.impl.Operator;
import org.natspal.nconsole.client.api.impl.OperatorConfig;
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

        String issuer = getString(tree, JwtClaims.ISSUER);
        String subject = getString(tree, JwtClaims.SUBJECT);
        String name = getString(tree, JwtClaims.NAME);
        OperatorConfig natsConfig = getObject(tree, JwtClaims.NATS,OperatorConfig.class);
        Long issAt = getLong(tree, JwtClaims.ISSUED_AT);
        long issuedAt = issAt==null?0l:issAt;
        
        Long exp = getLong(tree, JwtClaims.EXPIRY);
        long expiry = exp==null?0l:exp;
        
        String jwtId = getString(tree, JwtClaims.JWT_ID);
        
        
        return new Operator(true,jwtId, issuedAt,expiry,issuer, name, subject, natsConfig);
    }

    
    
}
