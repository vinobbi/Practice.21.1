package com.example.myapplication211

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val t1 : TextView = findViewById(R.id.textView)
        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        findViewById<Button>(R.id.button).setOnClickListener {
            Thread {
                try {
                    val content = getContent("https://эор.мггтк.рф/")
                    webView.post {
                        webView.loadUrl("https://www.gosuslugi.ru/help/faq/legal_issues/2683")
                        Toast.makeText(
                            applicationContext,
                            "Данные загружены",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (ex: IOException) {
                    t1.post {
                        t1.text = "Ошибка: " + ex.message
                        Toast.makeText(applicationContext, "Ошибка",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        }
    }
    @Throws(IOException::class)
    private fun getContent(path: String) {
        var reader: BufferedReader? = null
    }
}