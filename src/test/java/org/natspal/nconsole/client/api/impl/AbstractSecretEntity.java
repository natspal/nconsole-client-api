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
package org.natspal.nconsole.client.api.impl;

import org.natspal.nconsole.client.api.ISecretEntity;

/***
 * 
 * @author Amit K Gupta
 *
 * 
 */

public abstract class AbstractSecretEntity<T> extends AuditMetadata implements ISecretEntity<T> {

    private static final long serialVersionUID = -366967744484889470L;

    private String guid;
    
    private String jwt;
    
    private String jwtId;
    
    private Long issueAt;
    
    private Long expiry;
    
    private String issuer;
    
    private String name;
    
    private String subject;
    
    private T nats;
    
    // --------------------------------------------
    // Constructors
    // --------------------------------------------
    
    protected AbstractSecretEntity() {
    }
    
    protected AbstractSecretEntity(String jwt
           , String jwtId, Long issueAt, Long expiry 
           , String issuer, String name
           , String subject, T nats) {
        this.jwt = jwt;
        this.jwtId = jwtId;
        this.issueAt = issueAt;
        this.expiry = expiry;
        this.issuer = issuer;
        this.name = name;
        this.subject = subject;
        this.nats = nats;
    }
    
	/**
     * @return the guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * @param guid the guid to set
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }
    
    /**
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * @param jwt the jwt to set
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    /**
     * @return the jwtId
     */
    public String getJwtId() {
        return jwtId;
    }

    /**
     * @param jwtId the jwtId to set
     */
    public void setJwtId(String jwtId) {
        this.jwtId = jwtId;
    }

    /**
     * @return the issueAt
     */
    public Long getIssueAt() {
        return issueAt;
    }

    /**
     * @param issueAt the issueAt to set
     */
    public void setIssueAt(Long issueAt) {
        this.issueAt = issueAt;
    }

    /**
     * @return the expiry
     */
    public Long getExpiry() {
        return expiry;
    }

    /**
     * @param expiry the expiry to set
     */
    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }
    /**
     * @return the issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * @param issuer the issuer to set
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the nats
     */
    public T getNats() {
        return nats;
    }

    /**
     * @param nats the nats to set
     */
    public void setNats(T nats) {
        this.nats = nats;
    }
    
    
}
