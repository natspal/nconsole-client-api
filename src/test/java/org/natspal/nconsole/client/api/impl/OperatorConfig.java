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

import java.util.Set;

import org.natspal.nconsole.client.api.EntityType;
import org.natspal.nconsole.client.api.IOperatorConfig;
import org.natspal.nconsole.client.api.ISigningKey;

/**
 * 
 * @author Amit K Gupta
 *
 */

public class OperatorConfig implements IOperatorConfig {
    
    private static final long serialVersionUID = -9077893197601880448L;

	private String accountServerUrl;
    
    private String[] operatorServiceUrls;
    
    private String[] signingKeys;
    
    private Set<? extends ISigningKey> signingKeyList;
    
    private boolean strictSigningKeyUsage;
    
    private String systemAccount;
    
    private EntityType type = EntityType.operator;
    
    private int version;

    // --------------------------------------------
    // Constructors
    // --------------------------------------------
    
    public OperatorConfig() {
    	
    }
    
    
    public OperatorConfig(String accountServerUrl, String[] operatorServiceUrls, String[] signingKeys,
			Set<? extends ISigningKey> signingKeyList, boolean strictSigningKeyUsage, String systemAccount,
			EntityType type, int version) {
		super();
		this.accountServerUrl = accountServerUrl;
		this.operatorServiceUrls = operatorServiceUrls;
		this.signingKeys = signingKeys;
		this.signingKeyList = signingKeyList;
		this.strictSigningKeyUsage = strictSigningKeyUsage;
		this.systemAccount = systemAccount;
		this.type = type;
		this.version = version;
	}

	/**
     * @return the accountServerUrl
     */
    public String getAccountServerUrl() {
        return accountServerUrl;
    }

    /**
     * @param accountServerUrl the accountServerUrl to set
     */
    public void setAccountServerUrl(String accountServerUrl) {
        this.accountServerUrl = accountServerUrl;
    }

    /**
     * @return the operatorServiceUrls
     */
    public String[] getOperatorServiceUrls() {
        return operatorServiceUrls;
    }

    /**
     * @param operatorServiceUrls the operatorServiceUrls to set
     */
    public void setOperatorServiceUrls(String[] operatorServiceUrls) {
        this.operatorServiceUrls = operatorServiceUrls;
    }

    /**
     * @return the signingKeys
     */
    public String[] getSigningKeys() {
        return signingKeys;
    }

    /**
     * @param signingKeys the signingKeys to set
     */
    public void setSigningKeys(String[] signingKeys) {
        this.signingKeys = signingKeys;
    }

    /**
     * @return the strictSigningKeyUsage
     */
    public boolean isStrictSigningKeyUsage() {
        return strictSigningKeyUsage;
    }

    /**
     * @param strictSigningKeyUsage the strictSigningKeyUsage to set
     */
    public void setStrictSigningKeyUsage(boolean strictSigningKeyUsage) {
        this.strictSigningKeyUsage = strictSigningKeyUsage;
    }

    /**
     * @return the systemAccount
     */
    public String getSystemAccount() {
        return systemAccount;
    }

    /**
     * @param systemAccount the systemAccount to set
     */
    public void setSystemAccount(String systemAccount) {
        this.systemAccount = systemAccount;
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

	@Override
	public Set<? extends ISigningKey> getSigningKeyList() {
		return signingKeyList;
	}

	@Override
	public void setSigningKeyList(Set<? extends ISigningKey> signingKeyList) {
		this.signingKeyList = signingKeyList;
	}
    
    
}
