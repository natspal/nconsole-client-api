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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Amit K Gupta
 *
 */

public interface ISigningKey {
	
	/**
	 * @return the auditMetadata
	 */
	@JsonProperty("audit_meta_data")
	public IAuditMetadata getAuditMetadata();

	/**
	 * @param auditMetadata the auditMetadata to set
	 */
	@JsonProperty("audit_meta_data")
	public void setAuditMetadata(IAuditMetadata auditMetadata);

	/**
	 * @return the description
	 */
	@JsonProperty("description")
	public String getDescription();

	/**
	 * @param description the description to set
	 */
	@JsonProperty("description")
	public void setDescription(String description);
	
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
	 * @return the expireAt
	 */
	@JsonProperty("exp")
	public long getExpireAt();

	/**
	 * @param expireAt the expireAt to set
	 */
	@JsonProperty("exp")
	public void setExpireAt(long expireAt);

	/**
	 * @return the id
	 */
	@JsonProperty("id")
	public String getId();

	/**
	 * @param id the id to set
	 */
	@JsonProperty("id")
	public void setId(String id);

	/**
	 * @return the isDefault
	 */
	@JsonProperty("is_default")
	public boolean isDefault();

	/**
	 * @param isDefault the isDefault to set
	 */
	@JsonProperty("is_default")
	public void setDefault(boolean isDefault);

	/**
	 * @return the key
	 */
	@JsonProperty("key")
	public String getKey();

	/**
	 * @param key the key to set
	 */
	@JsonProperty("key")
	public void setKey(String key);


	/**
	 * @return the entityType
	 */
	@JsonProperty("entity_type")
	public EntityType getEntityType();

	/**
	 * @param entityType the entityType to set
	 */
	@JsonProperty("entity_type")
	public void setEntityType(EntityType entityType);

}
