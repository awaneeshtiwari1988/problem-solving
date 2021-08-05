package com.practice.problem.solving.strings;

import org.junit.Assert;
import org.junit.Test;

public class VacuumCleanerRouteTest {

    @Test
    public void testIsBackToOriginalPosition(){
        VacuumCleanerRoute vacuumCleanerRoute = new VacuumCleanerRoute();
        Assert.assertTrue(vacuumCleanerRoute.isBackToOriginalPosition("LR"));
        Assert.assertFalse(vacuumCleanerRoute.isBackToOriginalPosition("URURD"));
        Assert.assertTrue(vacuumCleanerRoute.isBackToOriginalPosition("RUULLDRD"));
    }
}
