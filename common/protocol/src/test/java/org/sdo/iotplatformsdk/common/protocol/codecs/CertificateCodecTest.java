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

package org.sdo.iotplatformsdk.common.protocol.codecs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.CharBuffer;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sdo.iotplatformsdk.common.protocol.codecs.CertificateCodec;

class CertificateCodecTest {

  Certificate certificate;
  CertificateCodec certificateCodec;
  CertificateFactory certificateFactory;
  InputStream certificateInputStream;
  static StringWriter writer;

  @BeforeAll
  static void beforeAll() {
    writer = new StringWriter();
  }

  @BeforeEach
  void beforeEach() throws CertificateException, FileNotFoundException {

    certificateInputStream = new FileInputStream("sample-x509-certificate.crt");
    certificateFactory = CertificateFactory.getInstance("X.509");
    certificate = certificateFactory.generateCertificate(certificateInputStream);
    certificateCodec = new CertificateCodec();
  }

  @Test
  void test_Encoder() throws IOException, CertificateEncodingException {

    certificateCodec.encoder().apply(writer, certificate);
  }

  @Test
  void test_Decoder() throws IOException {

    certificateCodec.decoder().apply(CharBuffer.wrap(writer.toString()));
  }
}
