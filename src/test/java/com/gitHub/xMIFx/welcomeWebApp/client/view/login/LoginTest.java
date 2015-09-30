package com.gitHub.xMIFx.welcomeWebApp.client.view.login;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginService;
import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.TestConfiguration;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.spring.GwtSpringRunner;
import com.googlecode.gwt.test.spring.GwtSpringTest;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

/**
 * Created by bukatinvv on 23.09.2015.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)*/
@RunWith(GwtSpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = TestConfiguration.class)
@GwtModule("com.gitHub.xMIFx.welcomeWebApp.WelcomeWebApp")
@Ignore
public class LoginTest extends GwtSpringTest {

    public String getModuleName() {
        return "welcomeWebApp.Application";
    }


    public void testSendToServer() {
        // Not much to actually test in this sample app
        // Ideally you would test your Controller here (NOT YOUR UI)
        // (Make calls to RPC services, test client side model objects, test client side logic, etc)
/* create the service that we will test. */
        LoginServiceAsync loginServiceAsync =
                GWT.create(LoginService.class);
        ServiceDefTarget target = (ServiceDefTarget) loginServiceAsync;
        target.setServiceEntryPoint(GWT.getModuleBaseURL()
                + "gwt/loginService");

      /* since RPC calls are asynchronous, we will need to wait
       for a response after this test method returns. This line
       tells the test runner to wait up to 10 seconds
       before timing out. */
        /*delayTestFinish(10000);
*/
      /* send a request to the server. */
        loginServiceAsync.authorization("john", "smith", "en",
                new AsyncCallback<String>() {
                    public void onFailure(Throwable caught) {
            /* The request resulted in an unexpected error. */
                        fail("Request failure: " + caught.getMessage());
                    }

                    public void onSuccess(String result) {
            /* verify that the response is correct. */
                        assertTrue(result.startsWith("Good"));

            /* now that we have received a response, we need to
             tell the test runner that the test is complete.
             You must call finishTest() after an asynchronous test
             finishes successfully, or the test will time out.*/
                      /*  finishTest();*/
                    }
                });
    }


}