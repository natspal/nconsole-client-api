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
/**
 * 
 * @author Amit K Gupta
 *
 */

public interface JwtClaims {

    //Header
    String ALGORITHM = "alg";
    String TYPE = "typ";
    

    //Payload
    String ISSUER = "iss";
    String SUBJECT = "sub";
    String NATS = "nats";
    String ISSUED_AT = "iat";
    String EXPIRY = "exp";
    String NAME = "name";
    String JWT_ID = "jti";
    
    //Account Nats config
    
    String DEFAULT_PERMISSIONS = "default_permissions";
    String IMPORTS = "imports";
    String EXPORTS = "exports";
    String PUBLISH = "pub";
    String SUBSCRIBE = "sub";
    String LIMITS = "limits";
    String SIGNING_KEYS = "signing_keys";
    String ENTITY_TYPE = "type";
    String VERSION = "version";
    
    // User Nats Config
    String ISSUER_ACCOUNT = "issuer_account";
    String PAYLOAD = "payload";
    String DATA = "data";
    String SUBSCRIPTIONS = "subs";
    
    String ALLOW = "allow";
    String DENY = "deny";
    
    
    
    
}