/**
 * Copyright (c) 2018 MapR, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ojai.store.exceptions;

public class StoreExistsException extends StoreException {
  private static final long serialVersionUID = 0x2fd486e2327dfc74L;

  public StoreExistsException(String storeName) {
    super(msg(storeName));
  }

  public StoreExistsException(String storeName, Throwable t) {
    super(msg(storeName), t);
  }

  private static String msg(String storeName) {
    return String.format("The DocumentStore specified by the name '%s' already exists.", storeName);
  }

}
