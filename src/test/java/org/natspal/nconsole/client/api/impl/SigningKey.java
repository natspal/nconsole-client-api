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

import org.natspal.nconsole.client.api.EntityType;
import org.natspal.nconsole.client.api.IAuditMetadata;
import org.natspal.nconsole.client.api.ISigningKey;

/**
 * 
 * @author Amit K Gupta
 *
 */

public class SigningKey implements ISigningKey {
	
	private IAuditMetadata auditMetadata;
	
	private String description;
	
	private long issueAt;

	private long expireAt;
	
	private String id;
	
	private boolean isDefault;
	
	private String key;
	
	private EntityType entityType;
	
	// --------------------------------------------
    // Constructors
    // --------------------------------------------
	
	public SigningKey() {
		
	}
	
	public SigningKey(IAuditMetadata auditMetadata, String description, long issueAt, long expireAt, String id,
			boolean isDefault, String key, EntityType entityType) {
		super();
		this.auditMetadata = auditMetadata;
		this.description = description;
		this.issueAt = issueAt;
		this.expireAt = expireAt;
		this.id = id;
		this.isDefault = isDefault;
		this.key = key;
		this.entityType = entityType;
	}

	@Override
	public IAuditMetadata getAuditMetadata() {
		return auditMetadata;
	}

	@Override
	public void setAuditMetadata(IAuditMetadata auditMetadata) {
		this.auditMetadata = auditMetadata;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public long getIssueAt() {
		return issueAt;
	}

	@Override
	public void setIssueAt(long issueAt) {
		this.issueAt = issueAt;
	}

	@Override
	public long getExpireAt() {
		return expireAt;
	}

	@Override
	public void setExpireAt(long expireAt) {
		this.expireAt = expireAt;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean isDefault() {
		return isDefault;
	}

	@Override
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public EntityType getEntityType() {
		return entityType;
	}

	@Override
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

}
