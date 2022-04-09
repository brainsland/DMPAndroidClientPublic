package com.brainsland.dmpandroidclientdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainsland.dmpclient.DMP
import com.brainsland.dmpclient.requests.PageViewRequest
import com.brainsland.dmpclient.requests.base.PageViewInfo

class SecondActivity : AppCompatActivity() {

    var pageViewInfo: PageViewInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
        val request = PageViewRequest(
            url = "https://second.com/",
            title = "Second Activity",
        )
        pageViewInfo = DMP.pageView(this, request, pageViewInfo)
    }
}