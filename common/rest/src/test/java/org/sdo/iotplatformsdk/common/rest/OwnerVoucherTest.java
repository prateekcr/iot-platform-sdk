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

package org.sdo.iotplatformsdk.common.rest;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sdo.iotplatformsdk.common.rest.OwnerVoucher;
import org.sdo.iotplatformsdk.common.rest.OwnerVoucherEntry;
import org.sdo.iotplatformsdk.common.rest.OwnerVoucherHeader;

class OwnerVoucherTest {

  List<Object> dc;
  List<OwnerVoucherEntry> en;
  List<Object> hmac;
  OwnerVoucher ownerVoucher;
  OwnerVoucherHeader oh;

  @SuppressWarnings("unchecked")
  @BeforeEach
  void beforeEach() {
    dc = Mockito.mock(List.class);
    en = Mockito.mock(List.class);
    hmac = Mockito.mock(List.class);
    oh = new OwnerVoucherHeader();
    ownerVoucher = new OwnerVoucher();
  }

  @Test
  void test_Bean() throws IOException {
    ownerVoucher.setDc(dc);
    ownerVoucher.setEn(en);
    ownerVoucher.setHmac(hmac);
    ownerVoucher.setOh(oh);
    ownerVoucher.setSz(100);

    ownerVoucher.getDc();
    ownerVoucher.getEn();
    ownerVoucher.getHmac();
    ownerVoucher.getOh();
    ownerVoucher.getSz();

  }

}

