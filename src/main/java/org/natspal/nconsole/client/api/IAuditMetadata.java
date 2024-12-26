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

import org.natspal.nconsole.client.views.Views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * 
 * @author Amit Kumar Gupta
 *
 */

public interface IAuditMetadata {

	/**
	 * @return the createUserId
	 */
	@JsonProperty("create_user_id")
	@JsonView(Views.Public.class)
	public Long getCreateUserId();

	/**
	 * @param createUserId the createUserId to set
	 */
	@JsonProperty("create_user_id")
	public void setCreateUserId(Long createUserId);

	/**
	 * @return the updateUserId
	 */
	@JsonProperty("update_user_id")
	@JsonView(Views.Public.class)
	public Long getUpdateUserId();

	/**
	 * @param updateUserId the updateUserId to set
	 */
	@JsonProperty("update_user_id")
	public void setUpdateUserId(Long updateUserId);

	/**
	 * @return the createDate
	 */
	@JsonProperty("create_date")
	@JsonView(Views.Public.class)
	public Long getCreateDate();

	/**
	 * @param createDate the createDate to set
	 */
	@JsonProperty("create_date")
	public void setCreateDate(Long createDate);

	/**
	 * @return the updateDate
	 */
	@JsonProperty("update_date")
	@JsonView(Views.Public.class)
	public Long getUpdateDate();

	/**
	 * @param updateDate the updateDate to set
	 */
	@JsonProperty("update_date")
	public void setUpdateDate(Long updateDate);

}
