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
public interface ISubscribePermission extends Serializable {

    /**
     * @return the allowed subjects
     */
    @JsonProperty("allow")
    @JsonView(Views.Jwt.class)
    public String[] getAllow();
    
    /**
     * @param allow set the allowed subjects
     */
    @JsonProperty("allow")
    public void setAllow(String[] allow) ;
    
    /**
     * @return the denied subjects
     */
    @JsonProperty("deny")
    @JsonView(Views.Jwt.class)
    public String[] getDeny();
    
    /**
     * @param deny set the denied subjects
     */
    @JsonProperty("deny")
    public void setDeny(String[] deny) ;
    
}
