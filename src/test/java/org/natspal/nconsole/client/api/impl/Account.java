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
    
    private String operatorGuid; 
    
    private String issuerGuid; 
    
    // --------------------------------------------
    // Constructors
    // --------------------------------------------
    
    public Account() {
    }
    
    public Account(String operatorGuid
            , String jwtId
            , long issueAt, long expiry
            , String issuer, String name
            , String subject, AccountConfig nats) {
        super(null, jwtId, issueAt, expiry, issuer, name, subject, nats);
        this.operatorGuid = operatorGuid;
    }
    
    public Account(String operatorGuid
            ,String jwt, String jwtId
            , long issueAt, long expiry
            , String issuer, String name
            , String subject, AccountConfig nats) {
        super(jwt, jwtId, issueAt, expiry, issuer, name, subject, nats);
        this.operatorGuid = operatorGuid;
    }



    @Override
    public String getOperatorGuid() {
        return operatorGuid;
    }

    
    @Override
    public void setOperatorGuid(String operatorGuid) {
        this.operatorGuid = operatorGuid;
    }
    
    /**
	 * @return the issuerGuid
	 */
    @Override
	public String getIssuerGuid() {
		return issuerGuid;
	}

	/**
	 * @param issuerGuid the issuerGuid to set
	 */
    @Override
	public void setIssuerGuid(String issuerGuid) {
		this.issuerGuid = issuerGuid;
	}

}
