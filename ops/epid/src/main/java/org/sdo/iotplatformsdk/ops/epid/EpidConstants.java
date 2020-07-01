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

package org.sdo.iotplatformsdk.ops.epid;

/**
 * Constants class for EPID extension related constants.
 */
public class EpidConstants {

  public static final String onlineEpidUrlDefault = "https://verify.epid.trustedservices.intel.com";
  public static final String sandboxEpidUrlDefault =
      "https://verify.epid-sbx.trustedservices.intel.com";

  public static final int EPID1X_GID_SIZE = 4;
  public static final int EPID2X_GID_SIZE = 16;
}
