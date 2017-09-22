$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/mikesimagination/cucumber/loginTest/login.feature");
formatter.feature({
  "line": 1,
  "name": "A user can login sucessfully or fail",
  "description": "",
  "id": "a-user-can-login-sucessfully-or-fail",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4882738099,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User navigates to Initek\u0027s website",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on initek\u0027s website",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginTest.goToInitekWebsite()"
});
formatter.result({
  "duration": 1887479574,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "User gives credentials",
  "description": "",
  "id": "a-user-can-login-sucessfully-or-fail;user-gives-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I enter username as \"peter.livingston@initech.com\" and I enter password as \"peter\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Login should pass",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "peter.livingston@initech.com",
      "offset": 21
    },
    {
      "val": "peter",
      "offset": 76
    }
  ],
  "location": "LoginTest.enterUserName(String,String)"
});
formatter.result({
  "duration": 1546633632,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.employeeHomePageLoaded()"
});
formatter.result({
  "duration": 26188404,
  "status": "passed"
});
});