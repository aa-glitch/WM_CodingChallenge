$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "WorkMarket API Automation Challenge",
  "description": "",
  "id": "workmarket-api-automation-challenge",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User SignUp Scenario",
  "description": "",
  "id": "workmarket-api-automation-challenge;user-signup-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User connects to endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "firstName:\u003cfirstName\u003e and lastName:\u003clastName\u003e email:\u003cEmail\u003e username:\u003cusername\u003e password:\u003cpassword\u003e and phoneNumber:\u003cphoneNumber\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Assert that status code is ok",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "workmarket-api-automation-challenge;user-signup-scenario;",
  "rows": [
    {
      "cells": [
        "firstName",
        "lastName",
        "Email",
        "username",
        "password",
        "phoneNumber"
      ],
      "line": 10,
      "id": "workmarket-api-automation-challenge;user-signup-scenario;;1"
    },
    {
      "cells": [
        "Anshul",
        "Anand",
        "ansh.anand@gmail.com",
        "anshcse",
        "Anshul@123",
        "6033129204"
      ],
      "line": 11,
      "id": "workmarket-api-automation-challenge;user-signup-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "User SignUp Scenario",
  "description": "",
  "id": "workmarket-api-automation-challenge;user-signup-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User connects to endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "firstName:Anshul and lastName:Anand email:ansh.anand@gmail.com username:anshcse password:Anshul@123 and phoneNumber:6033129204",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Assert that status code is ok",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.user_connects_to_endpoint()"
});
formatter.result({
  "duration": 515486712,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Anshul",
      "offset": 10
    },
    {
      "val": "Anand",
      "offset": 30
    },
    {
      "val": "ansh.anand@gmail.com",
      "offset": 42
    },
    {
      "val": "anshcse",
      "offset": 72
    },
    {
      "val": "Anshul@123",
      "offset": 89
    },
    {
      "val": "6033129204",
      "offset": 116
    }
  ],
  "location": "stepDefinition.firstname_and_lastname_email_username_password_and_phonenumber(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 2109287684,
  "error_message": "java.lang.AssertionError: 1 expectation failed.\nExpected status code \u003c200\u003e but was \u003c201\u003e.\n\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:83)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:77)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:60)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:235)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:247)\r\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure.validate(ResponseSpecificationImpl.groovy:483)\r\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure$validate$1.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:113)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:125)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.validateResponseIfRequired(ResponseSpecificationImpl.groovy:655)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite$PogoCachedMethodSiteNoUnwrapNoCoerce.invoke(PogoMetaMethodSite.java:210)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite.callCurrent(PogoMetaMethodSite.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:52)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:154)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:166)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.statusCode(ResponseSpecificationImpl.groovy:123)\r\n\tat io.restassured.specification.ResponseSpecification$statusCode$0.callCurrent(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:52)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:154)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:166)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.statusCode(ResponseSpecificationImpl.groovy:131)\r\n\tat io.restassured.internal.ValidatableResponseOptionsImpl.statusCode(ValidatableResponseOptionsImpl.java:119)\r\n\tat stepdefinitions.stepDefinition.firstname_and_lastname_email_username_password_and_phonenumber(stepDefinition.java:34)\r\n\tat ✽.When firstName:Anshul and lastName:Anand email:ansh.anand@gmail.com username:anshcse password:Anshul@123 and phoneNumber:6033129204(login.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "stepDefinition.assert_that_status_code_is_ok()"
});
formatter.result({
  "status": "skipped"
});
});