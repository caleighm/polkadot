package com.polkadot.daycare.helper.ui.composables

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.polkadot.daycare.helper.PolkadotApp
import com.polkadot.daycare.helper.R
import com.polkadot.daycare.helper.ui.theme.PolkadotAppTheme

enum class AppDestinations(
    @StringRes val label: Int,
    val icon: ImageVector,
    @StringRes val contentDescription: Int
) {
    STUDENTS(R.string.nav_students, Icons.Default.Group, R.string.nav_students),
    ENROLL(R.string.nav_enroll, Icons.Default.PersonAdd, R.string.nav_enroll),
    SETTINGS(R.string.nav_settings, Icons.Default.Settings, R.string.nav_settings),
}

@Composable
fun PolkadotNavigationSuiteScaffoldColors() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.STUDENTS) }

    val navController = PolkadotApp.context.navController

    val myNavigationSuiteItemColors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
    )

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = stringResource(it.contentDescription)
                        )
                    },
                    label = { Text(stringResource(it.label)) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it },
                    colors = myNavigationSuiteItemColors,
                )
            }
        },
    ) {
        when (currentDestination) {
            AppDestinations.STUDENTS -> navController.navigate("students")
            AppDestinations.ENROLL -> TODO()
            AppDestinations.SETTINGS -> TODO()
        }
    }
}

@Composable
fun HomeDestination() {}

@Composable
fun StudentsDestination() {}

@Composable
fun ShoppingDestination() {}

@Composable
fun ProfileDestination() {}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PolkadotAppTheme {
        PolkadotNavigationSuiteScaffoldColors()
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    PolkadotAppTheme {
        PolkadotNavigationSuiteScaffoldColors()
    }
}