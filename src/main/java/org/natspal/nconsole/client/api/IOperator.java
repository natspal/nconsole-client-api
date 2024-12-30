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

import org.natspal.nconsole.client.views.Views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
/****
 * 
 * @author Amit K Gupta
 *
 */
public interface IOperator<T>  extends ISecretEntity<T> {

    /**
     * @return the createSystemAccount
     */
    @JsonProperty("create_system_account")
    @JsonIgnore
    @JsonView(Views.Public.class)
    public boolean isCreateSystemAccount();

    /**
     * @param createSystemAccount the createSystemAccount to set
     */
    @JsonProperty("create_system_account")
    public void setCreateSystemAccount(boolean createSystemAccount);
   
    
    /**
	 * @return the issuerGuid
	 */
    @JsonProperty("issuer_guid")
    @JsonView(Views.Public.class)
	public String getIssuerGuid();

	/**
	 * @param issuerGuid the issuerGuid to set
	 */
    @JsonProperty("issuer_guid")
	public void setIssuerGuid(String issuerGuid);
    
}
