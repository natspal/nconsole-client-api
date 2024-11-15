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

import org.natspal.nconsole.client.api.IAccountDefaultPermission;
import org.natspal.nconsole.client.api.IPublishPermission;
import org.natspal.nconsole.client.api.ISubscribePermission;
/***
 * 
 * @author Amit K Gupta
 *
 */

public class AccountDefaultPermission implements IAccountDefaultPermission {

    private IPublishPermission publish;
    
    private ISubscribePermission subscribe;
    
    // --------------------------------------------
    // Constructors
    // --------------------------------------------

    public AccountDefaultPermission() {
    }
    
    public AccountDefaultPermission(IPublishPermission publish, ISubscribePermission subscribe) {
        this.publish = publish;
        this.subscribe = subscribe;
    }
    
    // --------------------------------------------
    // setter getter methods
    // --------------------------------------------
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
}
