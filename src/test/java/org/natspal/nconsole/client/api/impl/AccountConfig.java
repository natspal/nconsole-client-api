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
package org.natspal.nconsole.client.api.impl;

import java.util.List;

import org.natspal.nconsole.client.api.EntityType;
import org.natspal.nconsole.client.api.IAccountConfig;
import org.natspal.nconsole.client.api.IAccountDefaultPermission;
import org.natspal.nconsole.client.api.IAccountLimits;
import org.natspal.nconsole.client.api.IExport;
import org.natspal.nconsole.client.api.IImport;

/***
 * 
 * @author Amit K Gupta
 *
 */

public class AccountConfig implements IAccountConfig{

    
	private List<? extends IExport> exports;
	
	private List<? extends IImport> imports;
	
    private IAccountDefaultPermission defaultPermissions;
    
    private IAccountLimits limits;
    
    private String[] signingKeys;
    
    private EntityType type = EntityType.account;
    
    private int version;

    // --------------------------------------------
    // Constructors
    // --------------------------------------------
    
    public AccountConfig() {
    }
    
    
    
    public AccountConfig(List<? extends IExport> exports
            , List<? extends IImport> imports
            ,IAccountDefaultPermission defaultPermissions
            , IAccountLimits limits
            , String[] signingKeys
            , EntityType type
            , int version) {
        super();
        this.exports = exports;
        this.imports = imports;
        this.defaultPermissions = defaultPermissions;
        this.limits = limits;
        this.signingKeys = signingKeys;
        this.type = type;
        this.version = version;
    }



    @Override
	public List<? extends  IExport> getExports() {
		return exports;
	}

	@Override
	public void setExports(List<? extends IExport> exports) {
		this.exports = exports;
	}

	@Override
	public List<? extends IImport> getImports() {
		return imports;
	}

	@Override
	public void setImports(List<? extends IImport> imports) {
		this.imports = imports;
	}
    
    /**
     * @return the defaultPermissions
     */
    public IAccountDefaultPermission getDefaultPermissions() {
        return defaultPermissions;
    }

    /**
     * @param defaultPermissions the defaultPermissions to set
     */
    public void setDefaultPermissions(IAccountDefaultPermission defaultPermissions) {
        this.defaultPermissions = defaultPermissions;
    }

    /**
     * @return the limits
     */
    public IAccountLimits getLimits() {
        return limits;
    }

    /**
     * @param limits the limits to set
     */
    public void setLimits(IAccountLimits limits) {
        this.limits = limits;
    }

    /**
     * @return the signingKeys
     */
    public String[] getSigningKeys() {
        return signingKeys;
    }

    /**
     * @param signingKeys the signingKeys to set
     */
    public void setSigningKeys(String[] signingKeys) {
        this.signingKeys = signingKeys;
    }

    /**
     * @return the type
     */
    public EntityType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EntityType type) {
        this.type = type;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    
}
