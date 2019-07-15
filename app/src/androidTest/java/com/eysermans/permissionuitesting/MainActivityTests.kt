package com.eysermans.permissionuitesting

import android.Manifest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTests {

    private var device : UiDevice? = null

    @get:Rule
    var mainActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        this.device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @After
    fun tearDown() {

        /*
        InstrumentationRegistry.getInstrumentation().uiAutomation.revokeRuntimePermission(
            InstrumentationRegistry.getInstrumentation().targetContext.packageName,
            Manifest.permission.ACCESS_COARSE_LOCATION)

        InstrumentationRegistry.getInstrumentation().uiAutomation.revokeRuntimePermission(
            InstrumentationRegistry.getInstrumentation().targetContext.packageName,
            Manifest.permission.ACCESS_FINE_LOCATION)
            */
    }

    @Test
    fun testFeedbackLocationPermissionDenied() {
        val denyButton = this.device?.findObject(UiSelector().text("DENY"))
        val permissionDeniedMessage = this.device?.findObject(UiSelector().text("Permission denied"))

        denyButton!!.click()

        assert(permissionDeniedMessage!!.exists())
    }

    @Test
    fun testFeedbackLocationPermissionAllowed() {
        val allowButton = this.device?.findObject(UiSelector().text("ALLOW"))
        var permissionAllowedMessage = this.device?.findObject(UiSelector().text("Permission allowed"))
        allowButton!!.click()
        assert(permissionAllowedMessage!!.exists())
    }


}