package com.gap.atpractice.testLinkAPI;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.constants.TestImportance;
import br.eti.kinoshita.testlinkjavaapi.model.*;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by ssibaja on 6/22/17.
 */
public class TestLinkCustomAPI extends TestLinkAPI {



    public TestLinkCustomAPI(String testLinkURL, String testLinkKey) throws TestLinkAPIException, MalformedURLException {
        super(new URL(testLinkURL), testLinkKey);

    }

    // Create Plan implementation method from TestLinkAPI api
    public TestPlan createTestPlan(String planName, String projectName, String notes, Boolean isActive, Boolean isPublic) throws TestLinkAPIException
    {
        return super.createTestPlan(planName, projectName, notes, isActive, isPublic);

    }

    // Create a Build for an specific Test Plan
    public Build createBuild(Integer testPlanId, String buildName, String buildNotes) throws TestLinkAPIException{
        return super.createBuild(testPlanId, buildName, buildNotes);
    }

    // Add a test case to an specific Test Plan
    public Integer addTestCaseToTestPlan (Integer testProjectId, Integer testPlanId, Integer testCaseId, Integer version,
                                           Integer platformId,Integer order, Integer urgency) throws TestLinkAPIException{

        return super.addTestCaseToTestPlan(testProjectId, testPlanId, testCaseId, version, platformId, order, urgency);

    }

    public ReportTCResultResponse setTestCaseExecutionResult(Integer testCaseId, Integer testCaseExternalId, Integer testPlanId,
                                                             ExecutionStatus status, Integer buildId, String buildName, String notes,
                                                             Boolean guess, String bugId, Integer platformId, String platformName,
                                                             Map<String,String> customFields, Boolean overwrite) throws TestLinkAPIException{

        return super.setTestCaseExecutionResult(testCaseId, testCaseExternalId, testPlanId,status, buildId, buildName, notes,
                                                guess, bugId, platformId, platformName, customFields, overwrite);

    }

}

