package com.example.kidlock.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityEventSource
import android.view.accessibility.AccessibilityNodeInfo

class MyAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        try {
            val source = event?.source
            if (source != null && event.eventType == AccessibilityEvent.TYPE_VIEW_CLICKED){
                val packageManager: PackageManager  = this.packageManager
                val packageName:String = event.packageName.toString()
                val appInfor: ApplicationInfo = packageManager.getApplicationInfo(packageName, 0)
                if (!appInfor.name.isNullOrBlank() && appInfor.icon != 0 && appInfor.icon != null){
                    val appLabel: String = packageManager.getApplicationLabel(appInfor).toString()
                    Log.e("Accessibility", "app infor" + " " + appLabel)
                }
//                if(event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED){
//                    Log.e("Acessibility" , source.toString())
//                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onServiceConnected() {
        val infor: AccessibilityServiceInfo = AccessibilityServiceInfo()
        infor.apply {
            this.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED or AccessibilityEvent.WINDOWS_CHANGE_ACTIVE or  AccessibilityEvent.TYPE_WINDOWS_CHANGED
            this.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
            this.notificationTimeout = 100
        }
        this.serviceInfo = infor
        super.onServiceConnected()
    }
}