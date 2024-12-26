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

import org.natspal.nconsole.client.views.Views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/***
 * 
 * @author Amit K Gupta
 *
 */
public interface IImport extends Serializable {

	/**
     * @return the guid
     */
	@JsonView(Views.Public.class)
    public String getGuid();

    /**
     * @param guid the guid to set
     */
    public void setGuid(String guid);

	/**
	 * @return the name
	 */
	@JsonProperty("name")
	@JsonView(Views.Jwt.class)
	public String getName();

	/**
	 * @param name the name to set
	 */
	@JsonProperty("name")
	public void setName(String name);

	/**
	 * @return the subject
	 */
	@JsonProperty("subject")
	@JsonView(Views.Jwt.class)
	public String getSubject();

	/**
	 * @param subject the subject to set
	 */
	@JsonProperty("subject")
	public void setSubject(String subject);

	/**
	 * @return the account
	 */
	@JsonProperty("account")
	@JsonView(Views.Jwt.class)
	public String getAccount();

	/**
	 * @param account the account to set
	 */
	@JsonProperty("account")
	public void setAccount(String account);

	/**
	 * @return the localSubject
	 */
	@JsonProperty("local_subject")
	@JsonView(Views.Jwt.class)
	public String getLocalSubject();

	/**
	 * @param localSubject the localSubject to set
	 */
	@JsonProperty("local_subject")
	public void setLocalSubject(String localSubject);

	/**
	 * @return the type
	 */
	@JsonProperty("type")
	@JsonView(Views.Jwt.class)
	public ExportType getType();

	/**
	 * @param type the type to set
	 */
	@JsonProperty("type")
	public void setType(ExportType type);
	
	
}
