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

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * 
 * @author Amit K Gupta
 *
 */

public interface IAccountConfig extends Serializable{

	/**
     * @return the exports
     */
    @JsonProperty("exports")
    public List<? extends IExport> getExports();

    /**
     * @param exports the exports to set
     */
    @JsonProperty("exports")
    public void setExports(List<? extends IExport> exports);
    
    /**
     * @return the imports
     */
    @JsonProperty("imports")
    public List<? extends IImport> getImports();

    /**
     * @param imports the imports to set
     */
    @JsonProperty("imports")
    public void setImports(List<? extends IImport> imports);
	
    /**
     * @return the defaultPermissions
     */
    @JsonProperty("default_permissions")
    public IAccountDefaultPermission getDefaultPermissions();

    /** 
     * @param defaultPermissions the defaultPermissions to set
     */
    @JsonProperty("default_permissions")
    public void setDefaultPermissions(IAccountDefaultPermission defaultPermissions);

    /**
     * @return the limits
     */
    @JsonProperty("limits")
    public IAccountLimits getLimits();

    /**
     * @param limits the limits to set
     */
    @JsonProperty("limits")
    public void setLimits(IAccountLimits limits);

    /**
     * @return the signingKeys
     */
    @JsonProperty("signing_keys")
    public String[] getSigningKeys();

    /**
     * @param signingKeys the signingKeys to set
     */
    @JsonProperty("signing_keys")
    public void setSigningKeys(String[] signingKeys);

    /**
     * @return the signingKeyList
     */
    @JsonProperty("signing_key_list")
    public Set<? extends ISigningKey> getSigningKeyList();

    /**
     * @param signingKeyList the signingKeyList to set
     */
    @JsonProperty("signing_key_list")
    //@JsonIgnore
    public void setSigningKeyList(Set<? extends ISigningKey> signingKeyList);
    
    /**
     * @return the type
     */
    @JsonProperty("type")
    public EntityType getType();

    /**
     * @param type the type to set
     */
    @JsonProperty("type")
    public void setType(EntityType type);

    /**
     * @return the version
     */
    @JsonProperty("version")
    public int getVersion();

    /**
     * @param version the version to set
     */
    @JsonProperty("version")
    public void setVersion(int version);
    
}
