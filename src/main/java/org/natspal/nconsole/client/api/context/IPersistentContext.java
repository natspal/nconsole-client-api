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
import org.natspal.nconsole.client.api.IAccountConfig;
import org.natspal.nconsole.client.api.IOperator;
import org.natspal.nconsole.client.api.IOperatorConfig;
import org.natspal.nconsole.client.api.ISigningKey;
import org.natspal.nconsole.client.api.IUser;
import org.natspal.nconsole.client.api.IUserConfig;
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
    
    IAccount<IAccountConfig> createAccount(IAccount<IAccountConfig> name) throws DataAccessException; 
    
    IOperator<IOperatorConfig> createOperator(IOperator<IOperatorConfig> name) throws DataAccessException;
    
    IOperator<IOperatorConfig> updateOperator(IOperator<IOperatorConfig> name) throws DataAccessException;
    
    IUser<IUserConfig> createUser(IUser<IUserConfig> name);
    
    void deleteAccountByNameAndOperatorIdKey(String name,String operatorIdKey) throws DataAccessException; 
    
    void deleteOperatorByName(String name) throws DataAccessException; 
    
    void deleteSeedByIdentityKey(String idKey) throws DataAccessException;
    
    void deleteSeedBySigningKey(String idKey) throws DataAccessException;
    
    void deleteUserByGuidAndAccountGuidAndOperatorGuid(String userGuid,String accountGuid,String operatorGuid)  throws DataAccessException;
    
    void deleteUserByNameAndAccountGuidAndOperatorGuid(String userName,String accountGuid,String operatorGuid)  throws DataAccessException;
    
    void deleteAccountByIdKeyAndOperatorIdKey(String accountIdKey,String operatorIdKey) throws DataAccessException;
    
    void deleteOperatorByIdKey(String operatorIdKey) throws DataAccessException;
    
    String findAccountIdentitySeedById(String id) throws DataAccessException; 
    
    String findAccountIdentitySeedByName(String name) throws DataAccessException; 
    
    String findAccountJwtByIdKeyAndOperatorIdKey(String idKey,String operatorIdKey) throws DataAccessException;
    
    IAccount<IAccountConfig> findAccountByNameAndOperatorIdKey(String name,String operatorIdKey) throws DataAccessException;
    
    IAccount<IAccountConfig> findAccountByIdKeyAndOperatorIdKey(String idKey,String operatorIdKey) throws DataAccessException;
    
    String findAccountLatestSigningSeedById(String id) throws DataAccessException;
    
    String findAccountLatestSigningSeedByName(String name) throws DataAccessException;
    
    String[] findAccountSigningKeysById(String id) throws DataAccessException;
    
    String[] findAccountSigningKeysByName(String name) throws DataAccessException;
    
    IOperator<IOperatorConfig> findOperatorByName(String name) throws DataAccessException;
    
    IOperator<IOperatorConfig> findOperatorByIdKey(String idKey) throws DataAccessException;
    
    String findOperatorIdentitySeedByIdKey(String idKey) throws DataAccessException;
    
    String findOperatorIdentitySeedByName(String name) throws DataAccessException;
    
    String findOperatorJwtByIdKey(String idKey) throws DataAccessException;
    
    String findOperatorJwtByName(String operatorName) throws DataAccessException;
    
    String findOperatorLatestSigningSeedByIdKey(String idKey) throws DataAccessException;
    
    
    String findOperatorLatestSigningSeedByName(String name) throws DataAccessException;
    
    String[] findOperatorSigningKeysByIdKey(String idKey) throws DataAccessException;
    
    String[] findOperatorSigningKeysByName(String name) throws DataAccessException;
    
    IUser<IUserConfig> findUserByNameAndAccountGuidAndOperatorGuid(String userName,String accountGuid,String operatorGuid) throws DataAccessException;
    
    IUser<IUserConfig> findUserByGuidAndAccountGuidAndOperatorGuid(String userGuid,String accountGuid,String operatorGuid) throws DataAccessException;
    
    String findUserJwtByGuidAndAccountGuidAndOperatorGuid(String userGuid,String accountGuid,String operatorGuid) throws DataAccessException;
    
    String findUserJwtByNameAndAccountGuidAndOperatorGuid(String userName,String accountGuid,String operatorGuid) throws DataAccessException;
    
    String findUserSeedById(String id,String accountName) throws DataAccessException;
    
    String findUserSeedByName(String name,String accountName) throws DataAccessException;
    
    List<IAccount> findAllAccountsByOperatorIdKey(String idKey) throws DataAccessException;
    
    List<IUser> findAllUsersByAccountGuidAndOperatorGuid(String accountGuid,String operatorGuid) throws DataAccessException;
    
    SimpleNKeyPair findSigningSeedBySigningKey(String signingKey) throws DataAccessException;
    
    SimpleNKeyPair findIdSeedByIdKey(String idKey) throws DataAccessException;
    
    List<SimpleNKeyPair> findSigningSeedsByIdKey(String idKey) throws DataAccessException;
    
    SimpleNKeyPair saveSeed(String idKey, String signingKey, String seed, EntityType entityType,KeyType keyType) throws DataAccessException;
    
    IAccount<IAccountConfig> updateAccount(IAccount<IAccountConfig> name) throws DataAccessException;
    
    IUser<IUserConfig> updateUser(IUser<IUserConfig> name,String operatorIdKey) throws DataAccessException;
    
    
    
    /**********************************************/
    /** Signing Key methods                       */
    /**********************************************/
	
	ISigningKey createSigningKey(ISigningKey signingKey) throws DataAccessException;
	
	ISigningKey updateSigningKey(ISigningKey signingKey) throws DataAccessException;
	
	ISigningKey findSigningKeyByGuid(String guid) throws DataAccessException;
	
	ISigningKey findOperatorSigningKeyByKey(String key) throws DataAccessException;
	
	List<ISigningKey> findOperatorSigningKeyByReferenceGuid(String refGuid) throws DataAccessException;
    
	/**********************************************/
    /** End Signing Key methods                       */
    /**********************************************/
    

}
