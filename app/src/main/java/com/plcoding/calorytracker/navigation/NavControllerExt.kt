package com.plcoding.calorytracker.navigation

import androidx.navigation.NavController
import com.plcoding.core.util.UiEvent

/*
when we use the other approach to use event and propagate navigate to event and use it like this:


composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }


 */
//fun NavController.navigate(event: UiEvent.Success){
//    this.navigate(event.route)
//}