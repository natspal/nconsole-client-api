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
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * 
 * @author Amit K Gupta
 *
 */

public interface IExport extends Serializable {

	/**
     * @return the guid
     */
    public String getGuid();

    /**
     * @param guid the guid to set
     */
    public void setGuid(String guid);
	
	/**
	 * @return the name
	 */
	@JsonProperty("name")
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
	public String getSubject();

	/**
	 * @param subject the subject to set
	 */
	@JsonProperty("subject")
	public void setSubject(String subject);

	/**
	 * @return the type
	 */
	@JsonProperty("type")
	public ExportType getType();

	/**
	 * @param type the type to set
	 */
	@JsonProperty("type")
	public void setType(ExportType type);

	/**
	 * @return the responseType
	 */
	@JsonProperty("response_type")
	public ResponseType getResponseType();

	/**
	 * @param responseType the responseType to set
	 */
	@JsonProperty("response_type")
	public void setResponseType(ResponseType responseType);
	
	
}
