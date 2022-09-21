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
package org.natspal.nconsole.client.exceptions;
/***
 * 
 * @author Amit K Gupta
 *
 */
public class JWTDecodeException extends RuntimeException {
    
    
    private static final long serialVersionUID = 566184395257277266L;

    public JWTDecodeException(String message) {
        this(message, null);
    }
    
    public JWTDecodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
