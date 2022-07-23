package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import TestCases.TESTCASE1_Login;
import TestCases.TESTCASE2_ResetPassword;

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
  TESTCASE1_Login.class,
  TESTCASE2_ResetPassword.class,
})


public class TestSuite1{
	
}