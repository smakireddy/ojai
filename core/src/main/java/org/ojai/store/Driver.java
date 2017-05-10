/**
 * Copyright (c) 2016 MapR, Inc.
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
package org.ojai.store;

import java.util.Map;

import org.ojai.Document;
import org.ojai.DocumentBuilder;
import org.ojai.exceptions.DecodingException;
import org.ojai.exceptions.OjaiException;

/**
 * Entry point of an implementation of OJAI APIs. An OJAI Driver implementation must
 * support JAVA Service Provider Interface.
 *
 * DriverManager uses the implementation to establish connection to the OJAI data
 * source.
 */
public interface Driver {

  /**
   * Creates and returns a new, empty instance of an OJAI Document.
   */
  public Document newDocument();

  /**
   * Returns a new instance of OJAI Document parsed from the specified JSON string.
   */
  public Document newDocument(String documentJson) throws DecodingException;

  /**
   * Returns a new instance of Document constructed from the specified Map
   */
  public Document newDocument(Map<String, Object> map) throws DecodingException;

  /**
   * Returns a new instance of Document built from the specified Java bean.
   */
  public Document newDocument(Object bean) throws DecodingException;

  /**
   * Returns a new DocumentBuilder object.
   */
  public DocumentBuilder newDocumentBuilder();

  /**
   * Creates and returns a new DocumentMutation object.
   */
  public DocumentMutation newMutation();

  /**
   * Creates and returns a new DocumentMutation object decoded from the supplied JSON String.
   */
  public DocumentMutation newMutation(String mutationJson);

  /**
   * Creates and returns a new QueryCondition object.
   */
  public QueryCondition newCondition();

  /**
   * Creates and returns a new QueryCondition object decoded from the supplied JSON String.
   */
  public QueryCondition newCondition(String conditionJson);

  /**
   * Creates and returns a new Query object.
   */
  public Query newQuery();

  /**
   * Creates and returns a new Query object decoded from the supplied JSON String.
   */
  public Query newQuery(String queryJson);

  //
  // Methods used by OJAI DriverManager
  //

  /**
   * Returns true if this Driver supports the protocol specified in the URL.
   */
  public boolean accepts(String url);

  /**
   * Establishes and returns a Connection to an OJAI data source.
   * Used by DriverManager to connect to the OJAI data source. Application should
   * not use this API directly.
   */
  public Connection connect(String url, java.util.Properties info) throws OjaiException;

}