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

package org.sdo.iotplatformsdk.ops.opsimpl;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.EnvironmentConfiguration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for loading the properties from the configuration file, or,
 * from system properties.
 */
public class OpsPropertiesLoader {

  private static final Logger LOGGER = LoggerFactory.getLogger(OpsPropertiesLoader.class);
  private static final String configurationFile = "application.properties";
  private static final CompositeConfiguration configuration = new CompositeConfiguration();

  /**
   * Constructor.
   */
  public OpsPropertiesLoader() {
    try {
      final FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
          new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
              .configure(new Parameters().properties().setFileName(configurationFile));
      configuration.addConfiguration(new SystemConfiguration().interpolatedConfiguration());
      configuration.addConfiguration(new EnvironmentConfiguration().interpolatedConfiguration());
      configuration.addConfiguration(builder.getConfiguration());
    } catch (ConfigurationException e) {
      LOGGER.error("Unable to create properties configuration. " + e.getMessage());
      LOGGER.debug(e.getMessage(), e);
    }
  }

  /**
   * Get the value of the specified property in the following preference order: system property,
   * environment variable, config file. Once a property is loaded, it is serviced from cache.
   *
   * @param property Property to be read
   * @return         String value of property
   */
  public static final String getProperty(final String property) {
    if (null == property || property.isBlank()) {
      return null;
    }
    if (!configuration.containsKey(property)) {
      LOGGER.error("Undefined property: " + property);
    }
    return configuration.getString(property);
  }
}
