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

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
/****
 * 
 * @author Amit K Gupta
 *
 * 
 */
public interface ISecretEntity<T> extends Serializable {
	
	/**
     * @return the id
     */
    public String getId();

    /**
     * @param id the id to set
     */
    public void setId(String id);
    
    /**
    * @return the jwtId
    */
   @JsonProperty("jti")
   public String getJwtId();

   /**
    * @param jwtId the jwtId to set
    */
   @JsonProperty("jti")
   //@JsonIgnore
   public void setJwtId(String jwtId);

   /**
    * @return the issueAt
    */
   @JsonProperty("iat")
   public long getIssueAt();

   /**
    * @param issueAt the issueAt to set
    */
   @JsonProperty("iat")
   public void setIssueAt(long issueAt);
   
   /**
    * @return the expiry
    */
   @JsonProperty("exp")
   public long getExpiry();

   /**
    * @param expiry the expiry to set
    */
   @JsonProperty("exp")
   public void setExpiry(long expiry);
   
   /**
    * @return the issuer
    */
   @JsonProperty("iss")
   public String getIssuer();

   /**
    * @param issuer the issuer to set
    */
   @JsonProperty("iss")
   //@JsonIgnore
   public void setIssuer(String issuer);

   /**
    * @return the name
    */
   @JsonProperty("name")
   public String getName();

   /**
    * @param name the name to set
    */
   @JsonProperty("name")
   public void setName(String name);

   /**
    * @return the subject
    */
   @JsonProperty("sub")
   public String getSubject();

   /**
    * @param subject the subject to set
    */
   @JsonProperty("sub")
   //@JsonIgnore
   public void setSubject(String subject);

   /**
    * @return the nats
    */
   @JsonProperty("nats")
   public T getNats();

   /**
    * @param nats the nats to set
    */
   @JsonProperty("nats")
   public void setNats(T nats);
   
   /**
    * @return the jwt
    */
   @JsonProperty("jwt")
   @JsonIgnore
   public String getJwt();

   /**
    * @param jwt the jwt to set
    */
   @JsonProperty("jwt")
   @JsonIgnore
   public void setJwt(String jwt);
   
   /**
	* @param auditMetadata the auditMetadata to set
	*/
   
   @JsonProperty("audit_meta_data")
   public void setAuditMetadata(IAuditMetadata auditMetadata);
	
   /**
	* @return the auditingMetadata
	*/
   @JsonProperty("audit_meta_data")
   public IAuditMetadata getAuditMetadata();

}
