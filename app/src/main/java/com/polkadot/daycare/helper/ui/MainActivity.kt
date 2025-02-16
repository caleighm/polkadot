package com.polkadot.daycare.helper.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.polkadot.daycare.helper.PolkadotApp
import dagger.hilt.android.AndroidEntryPoint
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PolkadotApp.context.navController = rememberNavController()
            PolkadotAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavigation(PolkadotApp.context.navController)
                }
            }
        }
    }
}
