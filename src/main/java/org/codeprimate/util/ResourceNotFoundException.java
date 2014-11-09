/*
 * Copyright 2014-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codeprimate.util;

/**
 * The ResourceNotFoundException class is a RuntimeException indicating that a resource could not be found.
 *
 * @author John J. Blum
 * @see java.lang.RuntimeException
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException() {
  }

  public ResourceNotFoundException(final String message) {
    super(message);
  }

  public ResourceNotFoundException(final Throwable cause) {
    super(cause);
  }

  public ResourceNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
