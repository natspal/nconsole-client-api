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

import org.natspal.nconsole.client.views.Views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
/***
 * 
 * @author Amit K Gupta
 *
 */
public interface IUserConfig extends Serializable {
    

    /**
     * @return the publish
     */
    @JsonProperty("pub")
    @JsonView(Views.Jwt.class)
    public IPublishPermission getPublish();

    /**
     * @param publish the publish to set
     */
    @JsonProperty("pub")
    public void setPublish(IPublishPermission publish);

    /**
     * @return the subscribe
     */
    @JsonProperty("sub")
    @JsonView(Views.Jwt.class)
    public ISubscribePermission getSubscribe();

    /**
     * @param subscribe the subscribe to set
     */
    @JsonProperty("sub")
    public void setSubscribe(ISubscribePermission subscribe);

    /**
     * @return the subscriptions
     */
    @JsonProperty("subs")
    @JsonView(Views.Jwt.class)
    public int getSubscriptions();

    /**
     * @param subscriptions the subscriptions to set
     */
    @JsonProperty("subs")
    public void setSubscriptions(int subscriptions);

    /**
     * @return the data
     */
    @JsonProperty("data")
    @JsonView(Views.Jwt.class)
    public int getData();

    /**
     * @param data the data to set
     */
    @JsonProperty("data")
    public void setData(int data);
    /**
     * @return the payload
     */
    @JsonProperty("payload")
    @JsonView(Views.Jwt.class)
    public int getPayload();

    /**
     * @param payload the payload to set
     */
    @JsonProperty("payload")
    public void setPayload(int payload);

    /**
     * @return the issuerAccount
     */
    @JsonProperty("issuer_account")
    @JsonView(Views.Jwt.class)
    public String getIssuerAccount();
    /**
     * @param issuerAccount the issuerAccount to set
     */
    @JsonProperty("issuer_account")
    public void setIssuerAccount(String issuerAccount);

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
    public void setVersion(int version);
    
   
    
}
    
    
    