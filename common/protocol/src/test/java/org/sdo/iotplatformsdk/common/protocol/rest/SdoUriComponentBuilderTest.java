/*******************************************************************************
 * Copyright 2020 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.sdo.iotplatformsdk.common.protocol.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;

import org.junit.jupiter.api.Test;
import org.sdo.iotplatformsdk.common.protocol.types.MessageType;

class SdoUriComponentBuilderTest {

  SdoUriComponentsBuilder sdoUriComponentsBuilder;
  URI uri;

  @Test
  void test_UriComponentBuilder() throws IOException {
    String path = SdoUriComponentsBuilder.path(MessageType.TO2_DONE.intValue());
    assertEquals("/mp/113/msg/50", path);
  }
}
