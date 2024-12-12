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

import org.natspal.nconsole.client.api.ExportType;
import org.natspal.nconsole.client.api.IExport;
import org.natspal.nconsole.client.api.ResponseType;

/***
 * 
 * @author Amit K Gupta
 *
 */

public class Export implements IExport {

	private static final long serialVersionUID = 5444951423252639539L;

	private String name;
	
	private String guid;
	
	private String subject;
	
	private ExportType type;
	
	private ResponseType responseType;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSubject() {
		return subject;
	}

	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public ExportType getType() {
		return type;
	}

	@Override
	public void setType(ExportType type) {
		this.type = type;
	}

	@Override
	public ResponseType getResponseType() {
		return responseType;
	}

	@Override
	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	@Override
	public String getGuid() {
		return guid;
	}

	@Override
	public void setGuid(String guid) {
		this.guid = guid;
	}

}
