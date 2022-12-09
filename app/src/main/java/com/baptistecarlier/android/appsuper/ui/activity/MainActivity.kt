package com.baptistecarlier.android.appsuper.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.baptistecarlier.android.appsuper.ui.component.MainNav
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSuperTheme {
                MainNav()
            }
        }
    }
}