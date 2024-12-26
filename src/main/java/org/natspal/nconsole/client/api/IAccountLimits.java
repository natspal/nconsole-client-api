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
/*****
 * 
 * @author Amit K Gupta
 *
 */
public interface IAccountLimits extends Serializable {

    /**
     * @return the connections
     */
    @JsonProperty("conn")
    @JsonView(Views.Jwt.class)
    public int getConnections();

    /**
     * @param connections the connections to set
     */
    @JsonProperty("conn")
    public void setConnections(int connections);

    /**
     * @return the consumer
     */
    @JsonProperty("consumer")
    @JsonView(Views.Jwt.class)
    public int getConsumer();

    /**
     * @param consumer the consumer to set
     */
    @JsonProperty("consumer")
    public void setConsumer(int consumer);

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
     * @return the diskStorage
     */
    @JsonProperty("disk_storage")
    @JsonView(Views.Jwt.class)
    public long getDiskStorage();

    /**
     * @param diskStorage the diskStorage to set
     */
    @JsonProperty("disk_storage")
    public void setDiskStorage(long diskStorage);

    /**
     * @return the exports
     */
    @JsonProperty("exports")
    @JsonView(Views.Jwt.class)
    public int getExports();

    /**
     * @param exports the exports to set
     */
    @JsonProperty("exports")
    public void setExports(int exports);

    /**
     * @return the imports
     */
    @JsonProperty("imports")
    @JsonView(Views.Jwt.class)
    public int getImports();

    /**
     * @param imports the imports to set
     */
    @JsonProperty("imports")
    public void setImports(int imports);

    /**
     * @return the leaf
     */
    @JsonProperty("leaf")
    @JsonView(Views.Jwt.class)
    public int getLeaf();

    /**
     * @param leaf the leaf to set
     */
    @JsonProperty("leaf")
    public void setLeaf(int leaf);

    /**
     * @return the memStorage
     */
    @JsonProperty("mem_storage")
    @JsonView(Views.Jwt.class)
    public long getMemStorage();

    /**
     * @param memStorage the memStorage to set
     */
    @JsonProperty("mem_storage")
    public void setMemStorage(long memStorage);

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
     * @return the streams
     */
    @JsonProperty("streams")
    @JsonView(Views.Jwt.class)
    public int getStreams();

    /**
     * @param streams the streams to set
     */
    @JsonProperty("streams")
    public void setStreams(int streams);

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
     * @return the wildcards
     */
    @JsonProperty("wildcards")
    @JsonView(Views.Jwt.class)
    public boolean isWildcards();

    /**
     * @param wildcards the wildcards to set
     */
    @JsonProperty("wildcards")
    public void setWildcards(boolean wildcards);
    
    
    
   
    
    
}
