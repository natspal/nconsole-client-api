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

import org.natspal.nconsole.client.api.impl.Account;
import org.natspal.nconsole.client.api.impl.Operator;
import org.natspal.nconsole.client.api.impl.User;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
/**
 * 
 * @author Amit K Gupta
 *
 */

public final class Mapper {
    
    private static ObjectMapper mapper;
    private static boolean toInitialize = true;

    private Mapper(){
    }
    
    

    public static ObjectMapper getObjectMapper() {
        if (toInitialize) {
            synchronized (Mapper.class) {
                if (toInitialize) {
                    mapper = JsonMapper.builder()
                            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                            .build();
                    SimpleModule module = new SimpleModule();
                    ObjectReader reader = mapper.reader();
                    module.addDeserializer(Operator.class, new OperatorDeserializer(reader));
                    module.addDeserializer(Account.class, new AccountDeserializer(reader));
                    module.addDeserializer(User.class, new UserDeserializer(reader));
                    
                    mapper.registerModule(module);
                    mapper.setSerializationInclusion(Include.NON_NULL);
                    toInitialize = false;
                }
            }
        }  
        
      return mapper;
    }

}
