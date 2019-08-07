// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.devtools;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

/**
 * Created by aohana
 */
public abstract class ChromeDevToolsTestBase extends DevToolsTestBase {

  ChromeDriver chromeDriver;

  @Before
  public void setUp() {

    super.setUp();

    ChromeOptions options = new ChromeOptions();
    String chromePath = System.getProperty("webdriver.chrome.binary");
    if (chromePath != null) {
      options.setBinary(new File(chromePath));
    }

    chromeDriver = new ChromeDriver(options);
    devTools = chromeDriver.getDevTools();

    devTools.createSession();
  }


  @After
  public void terminateSession() {
    devTools.close();
    chromeDriver.quit();
  }

}
