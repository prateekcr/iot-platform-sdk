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

package org.sdo.iotplatformsdk.common.protocol.config;

import java.security.SecureRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SslContextFactoryBeanTest {

  ObjectFactory<SecureRandom> secureRandomProvider;
  SslContextFactory sslContextFactoryBean;

  @BeforeEach
  void beforeEach() throws Exception {

    secureRandomProvider = Mockito.mock(ObjectFactory.class);
    sslContextFactoryBean = new SslContextFactory(secureRandomProvider.getObject());
  }

  @Test
  void test_Bean() throws Exception {
    sslContextFactoryBean.getObject();
  }
}
