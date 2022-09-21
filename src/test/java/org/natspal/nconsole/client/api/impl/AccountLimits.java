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

import org.natspal.nconsole.client.api.IAccountLimits;

/***
 * 
 * @author Amit K Gupta
 *
 */

public class AccountLimits implements IAccountLimits {
    
    private int connections  = -1;
    
    private int consumer     = 0;
    
    private int data         = -1;
    
    private long diskStorage =  0;
    
    private int exports      = -1;
    
    private int imports      = -1;
    
    private int leaf         = -1;
    
    private long memStorage  = 0;
    
    private int payload      = -1;
    
    private int streams      = 0;
    
    /***
     * 
     * Number of subscriptions
     * 
     */
    private int subscriptions  =-1;
    
    private boolean wildcards  = true;

    /**
     * @return the connections
     */
    public int getConnections() {
        return connections;
    }

    /**
     * @param connections the connections to set
     */
    public void setConnections(int connections) {
        this.connections = connections;
    }

    /**
     * @return the consumer
     */
    public int getConsumer() {
        return consumer;
    }

    /**
     * @param consumer the consumer to set
     */
    public void setConsumer(int consumer) {
        this.consumer = consumer;
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
     * @return the diskStorage
     */
    public long getDiskStorage() {
        return diskStorage;
    }

    /**
     * @param diskStorage the diskStorage to set
     */
    public void setDiskStorage(long diskStorage) {
        this.diskStorage = diskStorage;
    }

    /**
     * @return the exports
     */
    public int getExports() {
        return exports;
    }

    /**
     * @param exports the exports to set
     */
    public void setExports(int exports) {
        this.exports = exports;
    }

    /**
     * @return the imports
     */
    public int getImports() {
        return imports;
    }

    /**
     * @param imports the imports to set
     */
    public void setImports(int imports) {
        this.imports = imports;
    }

    /**
     * @return the leaf
     */
    public int getLeaf() {
        return leaf;
    }

    /**
     * @param leaf the leaf to set
     */
    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    /**
     * @return the memStorage
     */
    public long getMemStorage() {
        return memStorage;
    }

    /**
     * @param memStorage the memStorage to set
     */
    public void setMemStorage(long memStorage) {
        this.memStorage = memStorage;
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
     * @return the streams
     */
    public int getStreams() {
        return streams;
    }

    /**
     * @param streams the streams to set
     */
    public void setStreams(int streams) {
        this.streams = streams;
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
     * @return the wildcards
     */
    public boolean isWildcards() {
        return wildcards;
    }

    /**
     * @param wildcards the wildcards to set
     */
    public void setWildcards(boolean wildcards) {
        this.wildcards = wildcards;
    }
    
    
}
