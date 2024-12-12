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

/***
 * 
 * @author Amit K Gupta
 *
 */
public interface IUser<T> extends ISecretEntity<T> {

    
	/**
	 * @return the operatorGuid
	 */
	@JsonProperty("operator_guid")
	public String getOperatorGuid();

	/**
	 * @param operatorGuid the operatorGuid to set
	 */
	@JsonProperty("operator_guid")
	public void setOperatorGuid(String operatorGuid);

	/**
	 * @return the accountGuid
	 */
	@JsonProperty("account_guid")
	public String getAccountGuid();

	/**
	 * @param accountGuid the accountGuid to set
	 */
	@JsonProperty("account_guid")
	public void setAccountGuid(String accountGuid);

	/**
	 * @return the accountSigningKeyGuid
	 */
	@JsonProperty("account_signing_key_guid")
	public String getAccountSigningKeyGuid();

	/**
	 * @param accountSigningKeyGuid the accountSigningKeyGuid to set
	 */
	@JsonProperty("account_signing_key_guid")
	public void setAccountSigningKeyGuid(String accountSigningKeyGuid);
    
    
}
