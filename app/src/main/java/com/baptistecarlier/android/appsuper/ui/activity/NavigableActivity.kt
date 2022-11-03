package com.baptistecarlier.android.appsuper.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.baptistecarlier.android.appsuper.ui.component.MainNav
import com.baptistecarlier.android.appsuper.ui.theme.AppSuperTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSuperTheme {
                MainNav()
            }
        }
    }
}


