package eyesOnTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Eyes implements ITestListener {
    private static final Logger logger = LogManager.getLogger();
    private String blueCircle = "\uD83D\uDD35";
    private String greenTick = "\u2705";
    private String greenMark = "\u001B[32m";
    private String boldPass = "\u001B[1m" + " PASSED: " + "\u001B[0m";
    private String defaultText = "\u001B[0m ";
    private String redCross = "\u274C";
    private String redMark = "\u001B[31m";
    private String boldFail = "\u001B[1m" + " FAILED: " + "\u001B[0m";


    @Override
    public void onTestStart(ITestResult result) {
        logger.info(blueCircle + " TEST: " + result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(greenTick +
                greenMark +
                boldPass +
                defaultText +
                result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(redCross +
                redMark +
                boldFail +
                defaultText +
                result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

}
