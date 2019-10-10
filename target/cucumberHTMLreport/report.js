$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("EtsyLogin.feature");
formatter.feature({
  "line": 3,
  "name": "Etsy page",
  "description": "",
  "id": "etsy-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Verify login functionality",
  "description": "",
  "id": "etsy-page;verify-login-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Etsy homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters username \"\u003cusername\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User enters password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify user successfully logs in",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "etsy-page;verify-login-functionality;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 13,
      "id": "etsy-page;verify-login-functionality;;1"
    },
    {
      "cells": [
        "amely1988@bk.ru",
        "cyplenok"
      ],
      "line": 14,
      "id": "etsy-page;verify-login-functionality;;2"
    },
    {
      "cells": [
        "aska",
        "1988"
      ],
      "line": 15,
      "id": "etsy-page;verify-login-functionality;;3"
    },
    {
      "cells": [
        "amina",
        "adzhieva"
      ],
      "line": 16,
      "id": "etsy-page;verify-login-functionality;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11484170300,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verify login functionality",
  "description": "",
  "id": "etsy-page;verify-login-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Etsy homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters username \"amely1988@bk.ru\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User enters password \"cyplenok\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify user successfully logs in",
  "keyword": "Then "
});
formatter.match({
  "location": "etsyStep.user_is_on_Etsy_homepage()"
});
formatter.result({
  "duration": 10052391000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "amely1988@bk.ru",
      "offset": 22
    }
  ],
  "location": "EtsyLoginSD.user_enters_username(String)"
});
formatter.result({
  "duration": 6209673000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cyplenok",
      "offset": 22
    }
  ],
  "location": "EtsyLoginSD.user_enters_password(String)"
});
formatter.result({
  "duration": 403649100,
  "status": "passed"
});
formatter.match({
  "location": "EtsyLoginSD.verify_user_successfully_logs_in()"
});
formatter.result({
  "duration": 6039451900,
  "status": "passed"
});
formatter.after({
  "duration": 110300,
  "status": "passed"
});
formatter.before({
  "duration": 50697300,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Verify login functionality",
  "description": "",
  "id": "etsy-page;verify-login-functionality;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Etsy homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters username \"aska\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User enters password \"1988\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify user successfully logs in",
  "keyword": "Then "
});
formatter.match({
  "location": "etsyStep.user_is_on_Etsy_homepage()"
});
formatter.result({
  "duration": 7194300700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "aska",
      "offset": 22
    }
  ],
  "location": "EtsyLoginSD.user_enters_username(String)"
});
formatter.result({
  "duration": 15789005100,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#sign\\-in\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-PVPCVUF\u0027, ip: \u0027192.168.1.9\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\Asiyat\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55199}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 0755f55aaac1df129fb57e392776f6b4\n*** Element info: {Using\u003did, value\u003dsign-in}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.click(Unknown Source)\r\n\tat StepDefs.EtsyLoginSD.user_enters_username(EtsyLoginSD.java:20)\r\n\tat ✽.When User enters username \"aska\"(EtsyLogin.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "1988",
      "offset": 22
    }
  ],
  "location": "EtsyLoginSD.user_enters_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtsyLoginSD.verify_user_successfully_logs_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1132089300,
  "status": "passed"
});
formatter.before({
  "duration": 43329600,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verify login functionality",
  "description": "",
  "id": "etsy-page;verify-login-functionality;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Etsy homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters username \"amina\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User enters password \"adzhieva\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify user successfully logs in",
  "keyword": "Then "
});
formatter.match({
  "location": "etsyStep.user_is_on_Etsy_homepage()"
});
formatter.result({
  "duration": 6620755100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "amina",
      "offset": 22
    }
  ],
  "location": "EtsyLoginSD.user_enters_username(String)"
});
formatter.result({
  "duration": 15560885500,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#sign\\-in\"}\n  (Session info: chrome\u003d77.0.3865.90)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-PVPCVUF\u0027, ip: \u0027192.168.1.9\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 77.0.3865.90, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: C:\\Users\\Asiyat\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55199}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 0755f55aaac1df129fb57e392776f6b4\n*** Element info: {Using\u003did, value\u003dsign-in}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.click(Unknown Source)\r\n\tat StepDefs.EtsyLoginSD.user_enters_username(EtsyLoginSD.java:20)\r\n\tat ✽.When User enters username \"amina\"(EtsyLogin.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "adzhieva",
      "offset": 22
    }
  ],
  "location": "EtsyLoginSD.user_enters_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EtsyLoginSD.verify_user_successfully_logs_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 1081249900,
  "status": "passed"
});
});