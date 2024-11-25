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

import org.natspal.nconsole.client.api.IOperator;
/***
 * 
 * @author Amit K Gupta
 *
 */

public class Operator extends AbstractSecretEntity<OperatorConfig> implements IOperator<OperatorConfig> {

    
    private static final long serialVersionUID = 2518570112631589160L;

	private boolean createSystemAccount; 
    
    // --------------------------------------------
    // Constructors
    // --------------------------------------------
    
    public Operator() {
        super();
    }
    
    public Operator(boolean createSystemAccount, String jwtId
            , long issueAt, long expiry
            , String issuer, String name
            , String subject
            , OperatorConfig nats) {
        super(null, jwtId, issueAt, expiry, issuer, name, subject, nats);
        this.createSystemAccount = createSystemAccount;
        
    }
    
    public Operator(boolean createSystemAccount,String jwt, String jwtId
            , long issueAt, long expiry
            , String issuer, String name
            , String subject
            , OperatorConfig nats) {
        super(jwt, jwtId, issueAt, expiry, issuer, name, subject, nats);
        this.createSystemAccount = createSystemAccount;
        
    }



    @Override
    public boolean isCreateSystemAccount() {
        return createSystemAccount;
    }

    @Override
    public void setCreateSystemAccount(boolean createSystemAccount) {
        this.createSystemAccount = createSystemAccount;
    }
    
}
