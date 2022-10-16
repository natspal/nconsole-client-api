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
import org.natspal.nconsole.client.exceptions.DataAccessException;
import org.natspal.nconsole.client.api.EntityType;
/***
 * 
 * @author Amit K Gupta
 *
 */
public interface IPersistentContext {
    
    List<IOperator> findAllOperators() throws DataAccessException;
    
    IAccount createAccount(IAccount name) throws DataAccessException; 
    
    IOperator createOperator(IOperator name) throws DataAccessException;
    
    IOperator updateOperator(IOperator name) throws DataAccessException;
    
    IUser createUser(IUser name, String accountIdKey);
    
    void deleteAccountByNameAndOperatorIdKey(String name,String operatorIdKey) throws DataAccessException; 
    
    void deleteOperatorByName(String name) throws DataAccessException; 
    
    void deleteSeedByIdentityKey(String idKey) throws DataAccessException;
    
    void deleteSeedBySigningKey(String idKey) throws DataAccessException;
    
    void deleteUserByIdKeyAndAccountIdKeyAndOperatorIdKey(String userIdKey,String accountIdKey,String operatorIdKey)  throws DataAccessException;
    
    void deleteAccountByIdKeyAndOperatorIdKey(String accountIdKey,String operatorIdKey) throws DataAccessException;
    
    void deleteOperatorByIdKey(String operatorIdKey) throws DataAccessException;
    
    String findAccountIdentitySeedById(String id) throws DataAccessException; 
    
    String findAccountIdentitySeedByName(String name) throws DataAccessException; 
    
    String findAccountJwtByIdKeyAndOperatorIdKey(String idKey,String operatorIdKey) throws DataAccessException;
    
    IAccount findAccountByNameAndOperatorIdKey(String name,String operatorIdKey) throws DataAccessException;
    
    IAccount findAccountByIdKeyAndOperatorIdKey(String idKey,String operatorIdKey) throws DataAccessException;
    
    String findAccountLatestSigningSeedById(String id) throws DataAccessException;
    
    String findAccountLatestSigningSeedByName(String name) throws DataAccessException;
    
    String[] findAccountSigningKeysById(String id) throws DataAccessException;
    
    String[] findAccountSigningKeysByName(String name) throws DataAccessException;
    
    IOperator findOperatorByName(String name) throws DataAccessException;
    
    IOperator findOperatorByIdKey(String idKey) throws DataAccessException;
    
    String findOperatorIdentitySeedByIdKey(String idKey) throws DataAccessException;
    
    String findOperatorIdentitySeedByName(String name) throws DataAccessException;
    
    String findOperatorJwtByIdKey(String idKey) throws DataAccessException;
    
    String findOperatorJwtByName(String operatorName) throws DataAccessException;
    
    String findOperatorLatestSigningSeedByIdKey(String idKey) throws DataAccessException;
    
    
    String findOperatorLatestSigningSeedByName(String name) throws DataAccessException;
    
    String[] findOperatorSigningKeysByIdKey(String idKey) throws DataAccessException;
    
    String[] findOperatorSigningKeysByName(String name) throws DataAccessException;
    
    IUser findUserByName(String name,String accountName) throws DataAccessException;
    
    String findUserJwtById(String id,String accountName) throws DataAccessException;
    
    String findUserJwtByIdKeyAndAccountIdKey(String userIdKey,String accountIdKey,String operatorIdKey) throws DataAccessException;
    
    String findUserSeedById(String id,String accountName) throws DataAccessException;
    
    String findUserSeedByName(String name,String accountName) throws DataAccessException;
    
    List<IAccount> findAllAccountsByOperatorIdKey(String idKey) throws DataAccessException;
    
    List<IUser> findAllUsersByAccountIdKeyAndOperatorIdKey(String accountIdKey,String operatorIdKey) throws DataAccessException;
    
    SimpleNKeyPair findSigningSeedBySigningKey(String signingKey) throws DataAccessException;
    
    SimpleNKeyPair findIdSeedByIdKey(String idKey) throws DataAccessException;
    
    List<SimpleNKeyPair> findSigningSeedsByIdKey(String idKey) throws DataAccessException;
    
    SimpleNKeyPair saveSeed(String idKey, String signingKey, String seed, EntityType entityType,KeyType keyType) throws DataAccessException;
    
    IAccount updateAccount(IAccount name) throws DataAccessException;
    
    IUser updateUser(IUser name) throws DataAccessException;
    
    
    
    

}
