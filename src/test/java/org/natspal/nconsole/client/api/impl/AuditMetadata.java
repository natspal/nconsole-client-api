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

import org.natspal.nconsole.client.api.IAuditMetadata;
/***
 * 
 * @author Amit K Gupta
 *
 * 
 */

public class AuditMetadata implements IAuditMetadata {

	private long createUserId;
	private long updateUserId;
	private long createDate;
	private long updateDate;
	
	
	@Override
	public long getCreateUserId() {
		return createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

	@Override
	public long getUpdateUserId() {
		return updateUserId;
	}

	@Override
	public void setUpdateUserId(long updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Override
	public long getCreateDate() {
		return createDate;
	}

	@Override
	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	@Override
	public long getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(long updateDate) {
		this.updateDate = updateDate;
	}

}
