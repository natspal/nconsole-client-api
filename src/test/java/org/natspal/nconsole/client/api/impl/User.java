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

import org.natspal.nconsole.client.api.IUser;

/**
 * 
 * @author Amit K Gupta
 *
 */

public class User extends AbstractSecretEntity<UserConfig> implements IUser<UserConfig> {

	private static final long serialVersionUID = 9189391926212810696L;
	
	private String operatorGuid;
    
	private String accountGuid;
	
	private String accountSigningKeyGuid;
	
	public User() {
	}
	
	
	
    public User(String jwt, String jwtId, long issueAt, long expiry, String issuer, String name, String subject,
            UserConfig nats) {
        super(jwt, jwtId, issueAt, expiry, issuer, name, subject, nats);
    }
    
	@Override
	public String getOperatorGuid() {
		return operatorGuid;
	}



	@Override
	public void setOperatorGuid(String operatorGuid) {
		this.operatorGuid = operatorGuid;
	}



	@Override
	public String getAccountGuid() {
		return accountGuid;
	}



	@Override
	public void setAccountGuid(String accountGuid) {
		this.accountGuid = accountGuid;
	}



	@Override
	public String getAccountSigningKeyGuid() {
		return accountSigningKeyGuid;
	}



	@Override
	public void setAccountSigningKeyGuid(String accountSigningKeyGuid) {
		this.accountSigningKeyGuid = accountSigningKeyGuid;
	}
    
    
}
