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

import org.natspal.nconsole.client.api.ISubscribePermission;
/**
 * 
 * @author Amit K Gupta
 *
 */

public class SubscribePermission implements ISubscribePermission {

    private String[] allow;
    private String[] deny;
    
    // --------------------------------------------
    // Constructors
    // --------------------------------------------
    
    public SubscribePermission() {
    }
    
    public SubscribePermission(String[] allow, String[] deny) {
        super();
        this.allow = allow;
        this.deny = deny;
    }
    
    
    // --------------------------------------------
    // setter getter methods
    // --------------------------------------------
    
    @Override
    public String[] getAllow() {
        return allow;
    }

    @Override
    public void setAllow(String[] allow) {
        this.allow = allow;
    }

    @Override
    public String[] getDeny() {
        return deny;
    }

    @Override
    public void setDeny(String[] deny) {
        this.deny = deny;
    }

}
