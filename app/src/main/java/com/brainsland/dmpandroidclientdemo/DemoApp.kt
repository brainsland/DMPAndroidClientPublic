package com.brainsland.dmpandroidclientdemo

import android.app.Application
import com.brainsland.dmpclient.DMP

class DemoApp: Application() {
    override fun onCreate() {
        super.onCreate()
        DMP.setup(this, "usertest", "https://b-ingest.hurriyet.com.tr/ingest/", true)
    }
}