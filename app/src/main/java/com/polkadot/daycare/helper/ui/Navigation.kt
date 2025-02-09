package com.polkadot.daycare.helper.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.polkadot.daycare.helper.ui.login.LoginScreen
import com.polkadot.daycare.helper.ui.student.StudentScreen
import kotlinx.serialization.Serializable

@Serializable
object StudentList

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { LoginScreen(
            onNavigateToDaycare = { navController.navigate(route = StudentList) }
        )}
        composable<StudentList> { StudentScreen(modifier = Modifier.padding(16.dp)) }
        // TODO: Add more destinations
    }
}
