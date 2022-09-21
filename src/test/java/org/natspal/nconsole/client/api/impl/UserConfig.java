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

import org.natspal.nconsole.client.api.IPublishPermission;
import org.natspal.nconsole.client.api.ISubscribePermission;
import org.natspal.nconsole.client.api.IUserConfig;
import org.natspal.nconsole.client.api.EntityType;
/**
 * 
 * @author Amit K Gupta
 *
 */

public class UserConfig implements IUserConfig{
    
    private IPublishPermission publish;
    
    private ISubscribePermission subscribe;
    
    private int subscriptions =-1;
    
    private int data = -1;
    
    private int payload = -1;
    
    private String issuerAccount;
    
    private EntityType type= EntityType.user;
    
    private int version;
    
    public UserConfig() {
        publish = new PublishPermission();
        subscribe = new SubscribePermission();
    }
    

    public UserConfig(IPublishPermission publish, ISubscribePermission subscribe, int subscriptions, int data,
			int payload, String issuerAccount, EntityType type, int version) {
		this.publish = publish;
		this.subscribe = subscribe;
		this.subscriptions = subscriptions;
		this.data = data;
		this.payload = payload;
		this.issuerAccount = issuerAccount;
		this.type = type;
		this.version = version;
	}


	/**
     * @return the publish
     */
    public IPublishPermission getPublish() {
        return publish;
    }

    /**
     * @param publish the publish to set
     */
    public void setPublish(IPublishPermission publish) {
        this.publish = publish;
    }

    /**
     * @return the subscribe
     */
    public ISubscribePermission getSubscribe() {
        return subscribe;
    }

    /**
     * @param subscribe the subscribe to set
     */
    public void setSubscribe(ISubscribePermission subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * @return the subscriptions
     */
    public int getSubscriptions() {
        return subscriptions;
    }

    /**
     * @param subscriptions the subscriptions to set
     */
    public void setSubscriptions(int subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the payload
     */
    public int getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(int payload) {
        this.payload = payload;
    }

    /**
     * @return the issuerAccount
     */
    public String getIssuerAccount() {
        return issuerAccount;
    }

    /**
     * @param issuerAccount the issuerAccount to set
     */
    public void setIssuerAccount(String issuerAccount) {
        this.issuerAccount = issuerAccount;
    }

    /**
     * @return the type
     */
    public EntityType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EntityType type) {
        this.type = type;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }
    
   
    
}
    
    
    