package com.example.xpaybackuserapp.UI
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xpaybackuserapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserListFragment(), "UserListFragment")
                .commit()
        }
    }
}