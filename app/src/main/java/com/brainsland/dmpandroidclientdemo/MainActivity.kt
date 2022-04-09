package com.brainsland.dmpandroidclientdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.brainsland.dmpandroidclientdemo.databinding.ActivityMainBinding
import com.brainsland.dmpclient.DMP
import com.brainsland.dmpclient.requests.NewsArticleRequest
import com.brainsland.dmpclient.requests.PageViewRequest
import com.brainsland.dmpclient.requests.base.PageViewInfo

class MainActivity : AppCompatActivity() {

    var pageViewInfo: PageViewInfo? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNextScreen.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        binding.btnScrollPos.setOnClickListener {
            DMP.scrollPosition(12)
        }
        binding.btnBreadcrumb.setOnClickListener {
            DMP.breadcrumb("homepage")
        }
        binding.btnZonetracker.setOnClickListener {
            DMP.trackZone("Manşet", "1")
        }
        binding.btnPageUser.setOnClickListener {
            DMP.trackUser("paid", "09f46664f")
        }
        binding.btnPageEvent.setOnClickListener {
            DMP.pageEvent("https://www.hurriyet.com.tr/", "Video", "play", "Fall Campaign")
        }
        binding.btnNewsArticle.setOnClickListener {
            DMP.newsArticle(
                NewsArticleRequest(
                    newsUrl = "https://www.hurriyet.com.tr/dunya/sadece-bir-yerde-yetisiyor-sahte-muz-iklim-krizini-cozebilecek-mi-41989711",
                    headline = "Sadece bir yerde yetişiyor... 'Sahte muz' iklim krizini çözebilecek mi?",
                    description = "Şimdilik sadece Etiyopya'da yetiştirilen ve 'sahte muz' olarak da adlandırılan enset adındaki bir bitki uzmanlara göre insanlığı bekleyen iklim krizi kaynaklı gıda kıtlığındaki kurtarıcımız olabilir! İşte haberin ilginç detayları...",
                    section = "Dünya",
                    author1 = "hurriyet.com.tr",
                    author2 = "",
                    author3 = "",
                    image1 = "https://i4.hurimg.com/i/hurriyet/75/1200x675/61efc8354e3fe01654ed9345.jpg",
                    image2 = "",
                    image3 = "",
                    keywords = "[\"Etiyopya\",\"iklim krizi\",\"enset\",\"aksampromo\",\"OMICRON\",\"ABD\",\"Çin\",\"RUSYA\",\"Ukrayna\"]",
                    info = "{\"seo_news\":\"false\"}",
                    datePublished = "2022-01-25T12:51:00+03:00",
                    dateModified = "2022-01-25T13:43:07+03:00",
                    wordCount = 642
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        val request = PageViewRequest(
            url = "https://example.com/",
            title = "Main Activity"
        )
        pageViewInfo = DMP.pageView(this, request, pageViewInfo)
    }
}