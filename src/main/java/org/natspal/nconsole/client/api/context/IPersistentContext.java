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
package org.natspal.nconsole.client.api.context;

import java.util.List;
import org.natspal.nconsole.client.api.IAccount;
import org.natspal.nconsole.client.api.IOperator;
import org.natspal.nconsole.client.api.IUser;
import org.natspal.nconsole.client.api.KeyType;
import org.natspal.nconsole.client.api.SimpleNKeyPair;
import org.natspal.nconsole.client.api.EntityType;
/***
 * 
 * @author Amit K Gupta
 *
 */
public interface IPersistentContext {
    
    List<IOperator> findAllOperators();
    
    IAccount createAccount(IAccount name); 
    
    IOperator createOperator(IOperator name);
    
    IOperator updateOperator(IOperator name);
    
    IUser createUser(IUser name, String accountIdKey);
    
    boolean deleteAccount(String name); 
    
    boolean deleteOperator(String name); 
    
    void deleteSeedByIdentityKey(String idKey);
    
    void deleteUserByIdKeyAndAccountIdKeyAndOperatorIdKey(String userIdKey,String accountIdKey,String operatorIdKey);
    
    void deleteAccountByIdKeyAndOperatorIdKey(String accountIdKey,String operatorIdKey);
    
    void deleteOperatorByIdKey(String operatorIdKey);
    
    IAccount findAccountByName(String name); 
    
    String findAccountIdentitySeedById(String id); 
    
    String findAccountIdentitySeedByName(String name); 
    
    String findAccountJwtByIdKeyAndOperatorIdKey(String idKey,String operatorIdKey); 
    
    String findAccountJwtByName(String accountName,String operatorName);
    
    String findAccountJwtByNameAndIssuerIdentityKey(String accountName,String operatorIdKey);
    
    String findAccountLatestSigningSeedById(String id);
    
    String findAccountLatestSigningSeedByName(String name);
    
    String[] findAccountSigningKeysById(String id);
    
    String[] findAccountSigningKeysByName(String name);
    
    IOperator findOperatorByName(String name);
    
    String findOperatorIdentitySeedById(String id);
    
    String findOperatorIdentitySeedByName(String name);
    
    String findOperatorJwtByIdKey(String idKey);
    
    String findOperatorJwtByName(String operatorName);
    
    String findOperatorJwtBySubject(String subject);
    
    String findOperatorLatestSigningSeedById(String id);
    
    
    String findOperatorLatestSigningSeedByName(String name);
    
    String[] findOperatorSigningKeysById(String id);
    
    String[] findOperatorSigningKeysByName(String name);
    
    IUser findUserByName(String name,String accountName);
    
    String findUserJwtById(String id,String accountName);
    
    String findUserJwtByIdKeyAndAccountIdKey(String userIdKey,String accountIdKey,String operatorIdKey);
    
    String findUserSeedById(String id,String accountName);
    
    String findUserSeedByName(String name,String accountName);
    
    List<IAccount> listAccountsByOperatorIdKey(String idKey);
    
    List<IUser> listUsersByAccountIdKeyAndOperatorIdKey(String accountIdKey,String operatorIdKey);
    
    SimpleNKeyPair findSigningSeedBySigningKey(String signingKey);
    
    SimpleNKeyPair findIdSeedByIdKey(String idKey);
    
    List<SimpleNKeyPair> findSigningSeedsByIdKey(String idKey);
    
    void saveSeed(String idKey, String signingKey, String seed, EntityType entityType,KeyType keyType);
    
    IAccount updateAccount(IAccount name);
    
    IUser updateUser(IUser name);
    
    
    
    

}
