package com.polkadot.daycare.helper.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.polkadot.daycare.helper.ui.login.LoginScreen
import com.polkadot.daycare.helper.ui.student.StudentDetailScreen
import com.polkadot.daycare.helper.ui.student.StudentsScreen
import kotlinx.serialization.Serializable

@Serializable
data class StudentDetails(val studentId: Int, val guardianId: Int)

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { LoginScreen(
            onNavigateToDaycare = { navController.navigate("students") }
        )}
        composable("students")  { StudentsScreen(
            onNavigateToStudentDetails = { studentId, guardianId -> navController.navigate(route = StudentDetails(studentId, guardianId)) }
        ) }
        composable<StudentDetails> { StudentDetailScreen() }
        // TODO: Add more destinations
    }
}
