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
import java.util.Set;

import org.natspal.nconsole.client.views.Views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
/****
 * 
 * @author Amit K Gupta
 *
 */
public interface IOperatorConfig extends Serializable {


    /**
     * @return the accountServerUrl
     */
    @JsonProperty("account_server_url")
    @JsonView(Views.Jwt.class)
    public String getAccountServerUrl();

    /**
     * @param accountServerUrl the accountServerUrl to set
     */
    @JsonProperty("account_server_url")
    public void setAccountServerUrl(String accountServerUrl);

    /**
     * @return the operatorServiceUrls
     */
    @JsonProperty("operator_service_urls")
    @JsonView(Views.Jwt.class)
    public String[] getOperatorServiceUrls();

    /**
     * @param operatorServiceUrls the operatorServiceUrls to set
     */
    @JsonProperty("operator_service_urls")
    public void setOperatorServiceUrls(String[] operatorServiceUrls);

    /**
     * @return the signingKeys
     */
    @JsonProperty("signing_keys")
    @JsonView(Views.Jwt.class)
    public String[] getSigningKeys();

    /**
     * @param signingKeys the signingKeys to set
     */
    @JsonProperty("signing_keys")
    //@JsonIgnore
    public void setSigningKeys(String[] signingKeys);

    
    /**
     * @return the signingKeyList
     */
    @JsonProperty("signing_key_list")
    @JsonView(Views.Public.class)
    public Set<? extends ISigningKey> getSigningKeyList();

    /**
     * @param signingKeyList the signingKeyList to set
     */
    @JsonProperty("signing_key_list")
    //@JsonIgnore
    public void setSigningKeyList(Set<? extends ISigningKey> signingKeyList);
    
    /**
     * @return the strictSigningKeyUsage
     */
    @JsonProperty("strict_signing_key_usage")
    @JsonView(Views.Jwt.class)
    public boolean isStrictSigningKeyUsage();

    /**
     * @param strictSigningKeyUsage the strictSigningKeyUsage to set
     */
    @JsonProperty("strict_signing_key_usage")
    public void setStrictSigningKeyUsage(boolean strictSigningKeyUsage);

    /**
     * @return the systemAccount
     */
    @JsonProperty("system_account")
    @JsonView(Views.Jwt.class)
    public String getSystemAccount();

    /**
     * @param systemAccount the systemAccount to set
     */
    @JsonProperty("system_account")
    //@JsonIgnore
    public void setSystemAccount(String systemAccount);

    /**
     * @return the type
     */
    @JsonProperty("type")
    @JsonView(Views.Jwt.class)
    public EntityType getType();

    /**
     * @param type the type to set
     */
    @JsonProperty("type")
    //@JsonIgnore
    public void setType(EntityType type);

    /**
     * @return the version
     */
    @JsonProperty("version")
    @JsonView(Views.Jwt.class)
    public int getVersion();

    /**
     * @param version the version to set
     */
    @JsonProperty("version")
    //@JsonIgnore
    public void setVersion(int version);
    
    
}
