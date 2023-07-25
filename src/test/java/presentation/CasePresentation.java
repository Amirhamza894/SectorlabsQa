package presentation;

import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

public class CasePresentation {
    private static final Logger logger = LogManager.getLogger();

//    public static void step(String message) {
//        logger.info("     Step: " + message);
//    }

    private String tabSpace = "\t ";
    private String greenCircle = "\uD83D\uDFE2";
    private String redCircle = "\uD83D\uDD34";
    private String redClrTxt = "\u001B[31m";
    protected ExtentReports extentReports;
    public void executeStep(ExtentTest extentTest, String stepDescription, Runnable stepAction) {
        try {
            logStep(extentTest, stepDescription);
            stepAction.run();
//            logPass(extentTest, "Step executed successfully: " + stepDescription);
//            logger.info("\t \uD83D\uDFE2 " +stepDescription);
            logger.info(tabSpace + greenCircle + stepDescription);
        } catch (Exception e) {
//            logFail(extentTest, "Step failed: " + stepDescription);
//            logger.info("\t \uD83D\uDD34 " + "\u001B[31m" + "Failed Step: " + stepDescription);
            logger.info(tabSpace + redCircle + redClrTxt + "Failed Step" + stepDescription);
            Assert.fail("Step failed: " + stepDescription, e);
        }
    }

    private void logStep(ExtentTest extentTest, String stepDescription) {
        extentTest.log(Status.INFO, stepDescription);
    }

    protected void logPass(ExtentTest extentTest, String message) {
        extentTest.log(Status.PASS, message);
    }

    protected void logFail(ExtentTest extentTest, String message) {
        extentTest.log(Status.FAIL, message);
    }

}
