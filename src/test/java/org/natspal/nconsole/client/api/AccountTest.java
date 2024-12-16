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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import org.natspal.nconsole.client.api.impl.Account;
import org.natspal.nconsole.client.api.impl.AccountConfig;
import org.natspal.nconsole.client.api.impl.AccountDefaultPermission;
import org.natspal.nconsole.client.api.impl.AccountLimits;
import org.natspal.nconsole.client.api.impl.Export;
import org.natspal.nconsole.client.api.impl.Import;
import org.natspal.nconsole.client.api.impl.PublishPermission;
import org.natspal.nconsole.client.api.impl.SubscribePermission;
import org.natspal.nconsole.client.jwt.Mapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class AccountTest {
    
    
    ObjectMapper mapper = Mapper.getObjectMapper();
    
    String accountJwt = "{\n"
    		+ "	\"create_user_id\": 1234,\n"
    		+ " \"update_user_id\": 4567,\n"
    		+ "	\"create_date\": 1726642150,\n"
    		+ "	\"update_date\": 1764562150, \n"
    		+ "  \"guid\": \"gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght\",\n"
            + " \"iat\": 1660937715,\n"
            + " \"exp\": 1726642150,\n"
            + " \"iss\": \"OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK\",\n"
            + " \"jti\": \"S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA\",\n"
            + " \"name\": \"amitaccount\",\n"
            + " \"nats\": {\n"
            + "  \"default_permissions\": {\n"
            + "   \"pub\": {},\n"
            + "   \"sub\": {}\n"
            + "  },\n"
            + "  \"exports\": [\n"
            + "   {\n"
            + "    \"name\": \"stream_names\",\n"
            + "    \"response_type\": \"Stream\",\n"
            + "    \"subject\": \"$JS.API.STREAM.NAMES\",\n"
            + "    \"type\": \"service\"\n"
            + "   },\n"
            + "   {\n"
            + "    \"name\": \"js_event\",\n"
            + "    \"subject\": \"$JS.EVENT.>\",\n"
            + "    \"type\": \"stream\"\n"
            + "   }\n"
            + "  ],\n"
            + "  \"imports\": [\n"
            + "   {\n"
            + "    \"account\": \"ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7\",\n"
            + "    \"name\": \"js_ack\",\n"
            + "    \"subject\": \"$JS.ACK.amit.>\",\n"
            + "    \"type\": \"service\"\n"
            + "   }\n"
            + "  ],\n"
            + "  \"limits\": {\n"
            + "   \"conn\": -1,\n"
            + "   \"consumer\": -1,\n"
            + "   \"data\": -1,\n"
            + "   \"disk_storage\": 1000000000,\n"
            + "   \"exports\": -1,\n"
            + "   \"imports\": -1,\n"
            + "   \"leaf\": -1,\n"
            + "   \"payload\": -1,\n"
            + "   \"streams\": -1,\n"
            + "   \"subs\": -1,\n"
            + "   \"wildcards\": true\n"
            + "  },\n"
            + "  \"signing_keys\": [\n"
            + "   \"AWEFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM\"\n"
            + "  ],\n"
            + "  \"type\": \"account\",\n"
            + "  \"version\": 2\n"
            + " },\n"
            + " \"sub\": \"ACHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM\"\n"
            + "}";
    
    
    /**
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Test
    public void deserialize() throws JsonMappingException, JsonProcessingException {
        
        //when
        
        IAccount account = mapper.readValue(accountJwt, Account.class);
        
        
        // assert 
        assertEquals("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght", account.getGuid());
        assertEquals("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA", account.getJwtId());
        assertEquals(1660937715, account.getIssueAt());
        
        assertEquals(1726642150, account.getExpiry());
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", account.getIssuer());
        assertEquals("amitaccount", account.getName());
        
        assertEquals("ACHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM", account.getSubject());
        
        assertEquals(1234,account.getCreateUserId());
        assertEquals(4567,account.getUpdateUserId());
        assertEquals(1726642150,account.getCreateDate());
        assertEquals(1764562150,account.getUpdateDate());
        
        // assert nats config
        
        IAccountConfig accountConfig = (IAccountConfig)account.getNats();
        
        assertNotNull(accountConfig);
        
        IAccountDefaultPermission accountDefaultPermission = accountConfig.getDefaultPermissions();
        assertNotNull(accountDefaultPermission);
        
        IPublishPermission publish = accountDefaultPermission.getPublish();
        
        assertNotNull(publish);
        
        assertNull(publish.getAllow());
        assertNull(publish.getDeny());
        
        ISubscribePermission subscribe = accountDefaultPermission.getSubscribe();
        
        assertNotNull(subscribe);
        
        assertNull(subscribe.getAllow());
        assertNull(subscribe.getDeny());
        
        List<? extends IExport> exports = accountConfig.getExports();
        assertNotNull(exports);
        
        assertEquals(2, exports.size());
        
        IExport export1 = exports.get(0);
        assertNotNull(export1);
        
        assertEquals("stream_names",export1.getName());
        assertEquals(ResponseType.Stream,export1.getResponseType());
        assertEquals("$JS.API.STREAM.NAMES",export1.getSubject());
        assertEquals(ExportType.service,export1.getType());
        
        IExport export2 = exports.get(1);
        assertNotNull(export2);
        
        assertEquals("js_event",export2.getName());
        assertEquals("$JS.EVENT.>",export2.getSubject());
        assertEquals(ExportType.stream,export2.getType());
        
        
        List<? extends IImport> imports = accountConfig.getImports();
        assertNotNull(imports);
        assertEquals(1, imports.size());
        IImport import1 = imports.get(0);
        assertNotNull(import1);
        
        assertEquals("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7",import1.getAccount());
        assertEquals("js_ack",import1.getName());
        assertEquals("$JS.ACK.amit.>",import1.getSubject());
        assertEquals(ExportType.service,import1.getType());
        
        IAccountLimits accountLimits =  accountConfig.getLimits();
        assertNotNull(accountLimits);
        
        assertEquals(-1,accountLimits.getConnections());
        assertEquals(-1,accountLimits.getConsumer());
        assertEquals(-1,accountLimits.getData());
        assertEquals(1000000000,accountLimits.getDiskStorage());
        assertEquals(0,accountLimits.getMemStorage());
        assertEquals(-1,accountLimits.getExports());
        assertEquals(-1,accountLimits.getImports());
        assertEquals(-1,accountLimits.getLeaf());
        assertEquals(-1,accountLimits.getPayload());
        assertEquals(-1,accountLimits.getStreams());
        assertEquals(-1,accountLimits.getSubscriptions());
        assertTrue(accountLimits.isWildcards());
        
        
        assertEquals(1,accountConfig.getSigningKeys().length);
        
        assertEquals("AWEFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM",accountConfig.getSigningKeys()[0]);
        
        assertEquals(EntityType.account,accountConfig.getType());
        
        assertEquals(2,accountConfig.getVersion());
        
    }

    /**
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Test
    public void serialize() throws JsonMappingException, JsonProcessingException {
        
        //when
        
        IAccount account = new Account();
        
        account.setGuid("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght");
        
        account.setJwtId("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA");
        
        account.setIssueAt(1634840614);
        
        account.setExpiry(1726642150);
        
        account.setIssuer("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK");
        
        account.setName("amitaccount");
        
        account.setSubject("ACHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM");
        
        account.setCreateUserId(347347352);
        account.setUpdateUserId(345638567);
        account.setCreateDate(77868667);
        account.setUpdateDate(6767676);
        
        IAccountConfig accountConfig = new AccountConfig();
        
        
        // Default permission
        
        IPublishPermission publishPermission = new PublishPermission(new String[] {"amit.>"}, new String[]{"gupta.>"});

        ISubscribePermission subscribePermission = new SubscribePermission(new String[] {"foo.>"}, new String[] {"bar.>"});
        
        IAccountDefaultPermission accountDefaultPermission = new AccountDefaultPermission(publishPermission,subscribePermission);
       
        accountConfig.setDefaultPermissions(accountDefaultPermission);
        
        //List of exports
        
        List<IExport> exports = new ArrayList<IExport>();
        
        // export 1
        IExport export1 = new Export();
        
        export1.setName("stream_names");
        export1.setSubject("$JS.API.STREAM.NAMES");
        export1.setResponseType(ResponseType.Stream);
        export1.setType(ExportType.service);
        
        exports.add(export1);
        
        // export 2
        IExport export2 = new Export();
        
        export2.setName("js_event");
        export2.setSubject("$JS.EVENT.>");
        export2.setType(ExportType.stream);
        
        exports.add(export2);
        
        accountConfig.setExports(exports);
        
        //List of imports
        List<IImport> imports = new ArrayList<IImport>();
        
        // import 1
        IImport import1 = new Import();
        
        import1.setAccount("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7");
        import1.setName("js_ack");
        import1.setSubject("$JS.ACK.amit.>");
        import1.setType(ExportType.service);
        
        imports.add(import1);
        
        accountConfig.setImports(imports);
        
        IAccountLimits limits = new AccountLimits();
        
        limits.setConnections(100);
        limits.setConsumer(100);
        limits.setData(-1);
        
        limits.setLeaf(100);
        limits.setPayload(10000);
        
        accountConfig.setLimits(limits);
        
        String[] signingKeys = new String[] {"AWEFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM"};
        
        accountConfig.setSigningKeys(signingKeys);
        
        accountConfig.setType(EntityType.account);
        
        accountConfig.setVersion(2);
        
        account.setNats(accountConfig);
        
        
        // Check assert
        
        String accountString = mapper.writeValueAsString(account);
        
        DocumentContext doc = JsonPath.parse(accountString);
        
        
        
        assertEquals("gfgh6755-gfds-kjy7-76gr-hgr5ewdsqght", doc.read("$.guid"));
        
        assertEquals("S3EQRFJAVD43OILV4H7FXMOUJQZTY7HRLRWO3MTWGPPX2IJGJUSA", doc.read("$.jti"));
        
        assertEquals(Integer.valueOf(1634840614), doc.read("$.iat"));
        
        assertEquals(Integer.valueOf(1726642150), doc.read("$.exp"));
        
        assertEquals("OAUL4MS7IANRZ3BMHTQ3IAKYDFL436VB7O3ZFXC2DHFEXPSJUWBGFZGK", doc.read("$.iss"));
        assertEquals("amitaccount", doc.read("$.name"));
        
        assertEquals("ACHFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM", doc.read("$.sub"));
        
        //assert default permission
        assertNotNull(doc.read("$.nats.default_permissions"));
        assertNotNull(doc.read("$.nats.default_permissions.pub"));
        
        assertEquals("amit.>",doc.read("$.nats.default_permissions.pub.allow[0]"));
        assertEquals("gupta.>",doc.read("$.nats.default_permissions.pub.deny[0]"));
        
        assertNotNull(doc.read("$.nats.default_permissions.sub"));
        assertEquals("foo.>",doc.read("$.nats.default_permissions.sub.allow[0]"));
        assertEquals("bar.>",doc.read("$.nats.default_permissions.sub.deny[0]"));
        
        
        //assert exports
        
        assertNotNull(doc.read("$.nats.exports"));
        
        assertEquals("stream_names",doc.read("$.nats.exports[0].name"));
        assertEquals("$JS.API.STREAM.NAMES",doc.read("$.nats.exports[0].subject"));
        assertEquals(ResponseType.Stream.name(),doc.read("$.nats.exports[0].response_type"));
        assertEquals(ExportType.service.name(),doc.read("$.nats.exports[0].type"));
        
        assertEquals("js_event",doc.read("$.nats.exports[1].name"));
        assertEquals("$JS.EVENT.>",doc.read("$.nats.exports[1].subject"));
        assertEquals(ExportType.stream.name(),doc.read("$.nats.exports[1].type"));
        
       //assert imports
        
        assertNotNull(doc.read("$.nats.imports"));
        
        assertEquals("js_ack",doc.read("$.nats.imports[0].name"));
        assertEquals("$JS.ACK.amit.>",doc.read("$.nats.imports[0].subject"));
        assertEquals("ACK5GDGC5RYTIVBHEELIPQYY6GABNSMB2BCFSMWHXV3IEFB2VSQ2ADE7",doc.read("$.nats.imports[0].account"));
        assertEquals(ExportType.service.name(),doc.read("$.nats.imports[0].type"));
        assertEquals("AWEFNBTJPVIZC7B6ZSXDFWZHFOVQWJ5LZTI2UJJKCHXGE6ND5J3VNERM",doc.read("$.nats.signing_keys[0]"));
        
        
        // assert limits
        
        assertEquals(Integer.valueOf(100),doc.read("$.nats.limits.conn")); 
        assertEquals(Integer.valueOf(100),doc.read("$.nats.limits.consumer"));
        assertEquals(Integer.valueOf(-1),doc.read("$.nats.limits.data"));
        assertEquals(Integer.valueOf(0),doc.read("$.nats.limits.disk_storage"));
        assertEquals(Integer.valueOf(0),doc.read("$.nats.limits.mem_storage"));
        assertEquals(Integer.valueOf(-1),doc.read("$.nats.limits.exports"));
        assertEquals(Integer.valueOf(-1),doc.read("$.nats.limits.imports"));
        assertEquals(Integer.valueOf(100),doc.read("$.nats.limits.leaf"));
        assertEquals(Integer.valueOf(10000),doc.read("$.nats.limits.payload"));
        assertEquals(Integer.valueOf(0),doc.read("$.nats.limits.streams"));
        assertEquals(Integer.valueOf(-1),doc.read("$.nats.limits.subs"));
        assertEquals(true,doc.read("$.nats.limits.wildcards"));
        
        assertEquals(EntityType.account.name(),doc.read("$.nats.type"));
        
        assertEquals(Integer.valueOf(2),doc.read("$.nats.version"));
        
        assertEquals(Integer.valueOf(347347352),doc.read("$.create_user_id"));
        assertEquals(Integer.valueOf(345638567),doc.read("$.update_user_id"));
        assertEquals(Integer.valueOf(77868667),doc.read("$.create_date"));
        assertEquals(Integer.valueOf(6767676),doc.read("$.update_date"));
        
        
    }
}
