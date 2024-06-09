package QTEAutomation;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class RunnerClass {
	
	
	static TestNG testng;
	
	public static void main(String...a)
	{
		TestListenerAdapter tla=new TestListenerAdapter();
		testng=new TestNG();
		//testng.setTestClasses(new Class[] {TestCartSortPage.class});
		//testng.setTestClasses(new Class[] {TestSocialWebPage.class});
		//testng.setTestClasses(new Class[] {TestCartPage.class});
		//testng.setTestClasses(new Class[] {aaa.class});
		testng.setTestClasses(new Class[] {TestWDULoginPage.class});
		//testng.setTestClasses(new Class[] {TestProfile.class});
		testng.addListener(tla);
		testng.run();
	}
	
	

}
