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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

/**
 * 
 * @author Amit K Gupta
 *
 */
public class EntityTypeTest {

	 @Test
	 public void valueOf() {
		 
		 EntityType operator = EntityType.operator;
		 
		 EntityType account = EntityType.account;
		 
		 EntityType user = EntityType.user;
		 
		 assertEquals("operator", operator.toString());
		 assertEquals(EntityType.operator, EntityType.valueOf("operator"));
		 
		 assertEquals("account", account.toString());
		 assertEquals(EntityType.account, EntityType.valueOf("account"));
		 
		 assertEquals("user", user.toString());
		 assertEquals(EntityType.user, EntityType.valueOf("user"));
		 
		 //assertEquals(EntityType.UNKNOWN, EntityType.valueOf("test"));
		 
		 
	 }
	
}
