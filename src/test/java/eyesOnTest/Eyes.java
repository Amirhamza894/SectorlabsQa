package eyesOnTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.desktop.SystemEventListener;

public class Eyes implements ITestListener {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("\u2192 TEST: " + result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("\u2705 PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("\u274C Test FAILED: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Test skipped: " + result.getName());
    }

    // Other methods can also be implemented based on your needs
}
