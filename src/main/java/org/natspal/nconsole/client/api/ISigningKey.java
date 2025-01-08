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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Amit K Gupta
 *
 */

public interface ISigningKey extends IAuditMetadata {
	
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
	@JsonProperty(value = "iat", access = JsonProperty.Access.READ_ONLY)
	public Long getIssueAt();

	/**
	 * @param issueAt the issueAt to set
	 */
	@JsonProperty("iat")
	public void setIssueAt(Long issueAt);
	
	/**
	 * @return the expiry
	 */
	@JsonProperty("exp")
	public Long getExpiry();

	/**
	 * @param expiry the expiry to set
	 */
	@JsonProperty("exp")
	public void setExpiry(Long expiry);

	/**
	 * @return the guid
	 */
	@JsonProperty("guid")
	public String getGuid();

	/**
	 * @param guid the guid to set
	 */
	@JsonProperty("guid")
	public void setGuid(String guid);

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
	@JsonProperty(value="key", access = JsonProperty.Access.READ_ONLY)
	public String getKey();

	/**
	 * @param key the key to set
	 */
	@JsonProperty("key")
	public void setKey(String key);
	
	/**
	 * @return the secret
	 */
	@JsonProperty(value = "secret", access = JsonProperty.Access.READ_ONLY)
	@JsonIgnore
	public String getSecret();

	/**
	 * @param secret the secret to set
	 */
	@JsonProperty("secret")
	public void setSecret(String secret);


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
	
	
	/**
	 * @return the keyType
	 */
	@JsonProperty("key_type")
	public KeyType getKeyType();

	/**
	 * @param keyType the keyType to set
	 */
	@JsonProperty("key_type")
	public void setKeyType(KeyType keyType);
	
	/**
	 * @return the entityGuid
	 */
	@JsonProperty(value= "entity_guid", access = JsonProperty.Access.READ_ONLY)
	public String getEntityGuid();

	/**
	 * @param entityGuid the entityGuid to set
	 */
	@JsonProperty("entity_guid")
	public void setEntityGuid(String entityGuid);
	
	/**
	 * @return the ancestorGuid
	 */
	@JsonProperty(value ="ancestor_guid", access = JsonProperty.Access.READ_ONLY)
	public String getAncestorGuid();

	/**
	 * @param ancestorGuid the ancestorGuid to set
	 */
	@JsonProperty("ancestor_guid")
	public void setAncestorGuid(String ancestorGuid);
	

}
