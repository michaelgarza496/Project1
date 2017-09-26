$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/mikesimagination/cucumber/loginTest/login.feature");
formatter.feature({
  "line": 1,
  "name": "A user can login sucessfully or fail",
  "description": "",
  "id": "a-user-can-login-sucessfully-or-fail",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5758888883,
  "error_message": "org.openqa.selenium.SessionNotCreatedException: session not created exception\nfrom chrome not reachable\n  (Session info: chrome\u003d60.0.3112.113)\n  (Driver info: chromedriver\u003d2.32.498550 (9dec58e66c31bcc53a9ce3c7226f0c1c5810906a),platform\u003dWindows NT 10.0.15063 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 5.18 seconds\nBuild info: version: \u00273.5.3\u0027, revision: \u0027a88d25fe6b\u0027, time: \u00272017-08-29T12:42:44.417Z\u0027\nSystem info: host: \u0027DESKTOP-81EINA0\u0027, ip: \u0027192.168.0.15\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: driver.version: ChromeDriver\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.JsonWireProtocolResponse.lambda$new$0(JsonWireProtocolResponse.java:53)\r\n\tat org.openqa.selenium.remote.JsonWireProtocolResponse.lambda$getResponseFunction$2(JsonWireProtocolResponse.java:91)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$24(ProtocolHandshake.java:359)\r\n\tat java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)\r\n\tat java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)\r\n\tat java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)\r\n\tat java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:498)\r\n\tat java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)\r\n\tat java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)\r\n\tat java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)\r\n\tat java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\r\n\tat java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:362)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:136)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:142)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:646)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:255)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:237)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:138)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:178)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:167)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:124)\r\n\tat com.mikesimagination.cucumber.loginTest.LoginTest.chromeDriver(LoginTest.java:19)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\n",
  "status": "failed"
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
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "location": "LoginTest.employeeHomePageLoaded()"
});
formatter.result({
  "status": "skipped"
});
});