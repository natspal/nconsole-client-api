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
/***
 * 
 * @author Amit K Gupta
 *
 */

public class SimpleNKeyPair implements java.io.Serializable {

    private static final long serialVersionUID = -7565189502268009837L;

    private String idKey;
    private String privateKey;
    private String publicKey;

    /**
     * Constructs a key pair from the given id key, public key and private key.
     *
     * <p>Note that this constructor only stores references to the public
     * and private key components in the generated key pair. This is safe,
     * because {@code Key} objects are immutable.
     *
     * @param idKey the identity key of entity.
     * 
     * @param publicKey the public key.
     *
     * @param privateKey the private key.
     */
    public SimpleNKeyPair(String idKey,String publicKey, String privateKey) {
        this.idKey = idKey;
    	this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    /**
     * Returns a reference to the id key component of this key pair.
     *
     * @return a reference to the id key.
     */
    public String getIdKey() {
        return idKey;
    }
    
    /**
     * Returns a reference to the public key component of this key pair.
     *
     * @return a reference to the public key.
     */
    public String getPublicKey() {
        return publicKey;
    }

     /**
     * Returns a reference to the private key component of this key pair.
     *
     * @return a reference to the private key.
     */
   public String getPrivateKey() {
        return privateKey;
    }
}