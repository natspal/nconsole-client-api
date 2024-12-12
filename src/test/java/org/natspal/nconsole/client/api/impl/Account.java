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

import org.natspal.nconsole.client.api.IAccount;

/**
 * 
 * @author Amit K Gupta
 *
 */
public class Account extends AbstractSecretEntity<AccountConfig>  implements IAccount<AccountConfig>{
    
    private static final long serialVersionUID = 3987982494302892772L;
    
    private String operatorIdKey; 
    
    private String signedBy; 
    
    // --------------------------------------------
    // Constructors
    // --------------------------------------------
    
    public Account() {
    }
    
    public Account(String operatorIdKey
            , String jwtId
            , long issueAt, long expiry
            , String issuer, String name
            , String subject, AccountConfig nats) {
        super(null, jwtId, issueAt, expiry, issuer, name, subject, nats);
        this.operatorIdKey = operatorIdKey;
    }
    
    public Account(String operatorIdKey
            ,String jwt, String jwtId
            , long issueAt, long expiry
            , String issuer, String name
            , String subject, AccountConfig nats) {
        super(jwt, jwtId, issueAt, expiry, issuer, name, subject, nats);
        this.operatorIdKey = operatorIdKey;
    }



    @Override
    public String getOperatorIdKey() {
        return operatorIdKey;
    }

    
    @Override
    public void setOperatorIdKey(String operatorId) {
        this.operatorIdKey = operatorId;
    }
    
    /**
	 * @return the signedBy
	 */
    @Override
	public String getSignedBy() {
		return signedBy;
	}

	/**
	 * @param signedBy the signedBy to set
	 */
    @Override
	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

}
