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
/**
 * 
 * @author Amit K Gupta
 *
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.natspal.nconsole.client.api.impl.PublishPermission;
import org.natspal.nconsole.client.api.impl.SubscribePermission;
import org.natspal.nconsole.client.api.impl.User;
import org.natspal.nconsole.client.api.impl.UserConfig;
import org.natspal.nconsole.client.jwt.Mapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class UserTest {
    
    
    ObjectMapper mapper = Mapper.getObjectMapper();
    
    String userJwt = "{\n"
    		+ "	\"create_user_id\": 1234,\n"
    		+ "	\"update_user_id\": 4567,\n"
    		+ "	\"create_date\": 1726642150,\n"
    		+ "	\"update_date\": 1764562150, \n"
    		+ "  \"guid\": \"gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght\",\n"
            + "  \"jti\": \"AQAMGCOPWDUUEZYW7ILJW6N5WBUXIE6MUPIRIML6DVWVYF7X4P6A\",\n"
            + "  \"iat\": 1651011888,\n"
            + "  \"exp\": 1726642150,\n"
            + "  \"iss\": \"AC36YMF6TYR7F2RCSGOVYUBP35L6P5LHU7Q5JG2XMXK7IZ54X2QATDOY\",\n"
            + "  \"name\": \"u\",\n"
            + "  \"sub\": \"UCS7KJIXYPAQUNXFM5BQUR2CBBNV2AWEH4YTJAA2DYFCE7LXQUXA2KB7\",\n"
            + "  \"nats\": {\n"
            + "    \"pub\": {},\n"
            + "    \"sub\": {},\n"
            + "    \"subs\": -1,\n"
            + "    \"data\": -1,\n"
            + "    \"payload\": -1,\n"
            + "    \"type\": \"user\",\n"
            + "    \"version\": 2\n"
            + "  }\n"
            + "}";
    
    
    /**
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Test
    public void deserialize() throws JsonMappingException, JsonProcessingException {
        
        //when
        
        IUser user = mapper.readValue(userJwt, User.class);
        
        
        // assert 
        
        assertEquals("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght", user.getGuid());
        
        assertEquals("AQAMGCOPWDUUEZYW7ILJW6N5WBUXIE6MUPIRIML6DVWVYF7X4P6A", user.getJwtId());
        assertEquals(1651011888, user.getIssueAt());
        
        assertEquals(1726642150, user.getExpiry());
        
        assertEquals("AC36YMF6TYR7F2RCSGOVYUBP35L6P5LHU7Q5JG2XMXK7IZ54X2QATDOY", user.getIssuer());
        assertEquals("u", user.getName());
        
        assertEquals("UCS7KJIXYPAQUNXFM5BQUR2CBBNV2AWEH4YTJAA2DYFCE7LXQUXA2KB7", user.getSubject());
        
        
        assertEquals(1234,user.getCreateUserId());
        assertEquals(4567,user.getUpdateUserId());
        assertEquals(1726642150,user.getCreateDate());
        assertEquals(1764562150,user.getUpdateDate());
        
        // assert nats config
        
        IUserConfig userConfig = (IUserConfig)user.getNats();
        
        assertNotNull(userConfig);
        
        IPublishPermission publish = userConfig.getPublish();
        
        assertNotNull(publish);
        
        assertNull(publish.getAllow());
        assertNull(publish.getDeny());
        
        
        ISubscribePermission subscribe = userConfig.getSubscribe();
        
        assertNotNull(subscribe);
        assertNull(subscribe.getAllow());
        assertNull(subscribe.getDeny());
        
        assertEquals(-1,userConfig.getSubscriptions());
        assertEquals(-1,userConfig.getData());
        assertEquals(-1,userConfig.getPayload());
        
        assertEquals(EntityType.user,userConfig.getType());
        
        assertEquals(2,userConfig.getVersion());
        
    }

    /**
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Test
    public void serialize() throws JsonMappingException, JsonProcessingException {
        
        //when
        
        IUser user = new User();
        
        user.setGuid("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght");
        
        user.setJwtId("AQAMGCOPWDUUEZYW7ILJW6N5WBUXIE6MUPIRIML6DVWVYF7X4P6A");
        
        user.setIssueAt(1651011888);
        
        user.setExpiry(1726642150);
        
        user.setIssuer("AC36YMF6TYR7F2RCSGOVYUBP35L6P5LHU7Q5JG2XMXK7IZ54X2QATDOY");
        
        user.setName("u");
        
        user.setSubject("UCS7KJIXYPAQUNXFM5BQUR2CBBNV2AWEH4YTJAA2DYFCE7LXQUXA2KB7");
        
        
        user.setCreateUserId(347347352);
        user.setUpdateUserId(345638567);
        user.setCreateDate(77868667);
        user.setUpdateDate(6767676);
        
        IUserConfig userConfig = new UserConfig();
        
        IPublishPermission publish = new PublishPermission();
        publish.setAllow(new String[] {"amit.>"});
        
        publish.setDeny(new String[] {"foo.>","bar.>"});
        
        userConfig.setPublish(publish);
        
        userConfig.setSubscribe(new SubscribePermission());
        
        userConfig.setSubscriptions(100);
        userConfig.setData(-1);
        
        userConfig.setPayload(10000);
        
        userConfig.setType(EntityType.user);
        
        userConfig.setVersion(2);
        
        user.setNats(userConfig);
        
        
        // Check assert
        
        String userString = mapper.writeValueAsString(user);
        
        DocumentContext doc = JsonPath.parse(userString);
        
        assertEquals("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght", doc.read("$.guid"));
        
        assertEquals("AQAMGCOPWDUUEZYW7ILJW6N5WBUXIE6MUPIRIML6DVWVYF7X4P6A", doc.read("$.jti"));
        
        assertEquals(Integer.valueOf(1651011888), doc.read("$.iat"));
        
        assertEquals(Integer.valueOf(1726642150), doc.read("$.exp"));
        
        assertEquals("AC36YMF6TYR7F2RCSGOVYUBP35L6P5LHU7Q5JG2XMXK7IZ54X2QATDOY", doc.read("$.iss"));
        assertEquals("u", doc.read("$.name"));
        
        assertEquals("UCS7KJIXYPAQUNXFM5BQUR2CBBNV2AWEH4YTJAA2DYFCE7LXQUXA2KB7", doc.read("$.sub"));
        
        // assert limits
        
        assertNotNull(doc.read("$.nats.pub"));
        
        assertEquals("amit.>",doc.read("$.nats.pub.allow[0]"));
        
        assertEquals("foo.>",doc.read("$.nats.pub.deny[0]"));
        assertEquals("bar.>",doc.read("$.nats.pub.deny[1]"));
        
        assertNotNull(doc.read("$.nats.sub"));
        
        assertEquals(Integer.valueOf(-1),doc.read("$.nats.data"));
        assertEquals(Integer.valueOf(10000),doc.read("$.nats.payload"));
        assertEquals(Integer.valueOf(100),doc.read("$.nats.subs"));
        
        assertEquals(EntityType.user.name(),doc.read("$.nats.type"));
        
        assertEquals(Integer.valueOf(2),doc.read("$.nats.version"));
        
        assertEquals(Integer.valueOf(347347352),doc.read("$.create_user_id"));
        assertEquals(Integer.valueOf(345638567),doc.read("$.update_user_id"));
        assertEquals(Integer.valueOf(77868667),doc.read("$.create_date"));
        assertEquals(Integer.valueOf(6767676),doc.read("$.update_date"));
        
    }
}
