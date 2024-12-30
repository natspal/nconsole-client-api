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
package org.natspal.nconsole.client.jwt;
/**
 * 
 * @author Amit K Gupta
 *
 */

public interface JsonClaims extends JwtClaims {
    
	String GUID 				= "guid";
    
	String AUDIT_META_DATA 		= "audit_meta_data";
	
	String SIGNING_KEY_LIST 	= "signing_key_list";
    
	interface AUDIT_DATA {
		
		String CREATE_USER_ID 	= "create_user_id";
		String UPDATE_USER_ID 	= "update_user_id";
		String CREATE_DATE   	= "create_date";
		String UPDATE_DATE   	= "update_date";
		
		
	}
    
	interface SIGNING_KEY {
		String DESCRIPTION 		= "description";
		String ISSUE_AT 		= "iat";
		String EXPIRE_AT 		= "exp";
		String GUID 			= "guid";
		String IS_DEFAULT 		= "is_default";
		String KEY 				= "key";
		String ENTITY_TYPE 		= "entity_type";
		String KEY_TYPE 		= "key_type";
		String ENTITY_GUID 		= "entity_guid";
		String ANCESTOR_GUID 	= "ancestor_guid";
		
	}
	
}
