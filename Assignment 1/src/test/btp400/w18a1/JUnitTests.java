package test.btp400.w18a1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, ChequingTest.class, GICTest.class, SavingsTest.class, BankTest.class })
public class JUnitTests {

}