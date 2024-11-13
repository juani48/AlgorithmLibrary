package com.juani48.algorithmlibrary.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.juani48.algorithmlibrary.application.vm.CubeViewModel
import com.juani48.algorithmlibrary.ui.screen.AddCubeScreen
import com.juani48.algorithmlibrary.ui.screen.CubeViewScreen
import com.juani48.algorithmlibrary.ui.screen.MainMenuScreen
import com.juani48.algorithmlibrary.ui.screen.SearchScreen
import com.juani48.algorithmlibrary.ui.screen.UploadScreen

@Composable
fun NavigationWrapper(cubeViewModel: CubeViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainMenu) {
        composable<MainMenu> {
            cubeViewModel.initList()
            MainMenuScreen(
                cubeViewModel,
                { navController.navigate(MainMenu) { popUpTo<MainMenu> { inclusive = true } } },
                { navController.navigate(AddCube) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(Search) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(UploadAlgorithm) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(CubeView(it)) },
            )
        }
        composable<AddCube> {
            AddCubeScreen(
                cubeViewModel,
                { navController.navigate(MainMenu) { popUpTo<MainMenu> { inclusive = true } } },
                { navController.navigate(AddCube) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(Search) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(UploadAlgorithm) { popUpTo<MainMenu> { inclusive = false } } }
            )
        }

        composable<Search> {
            SearchScreen(
                cubeViewModel,
                { navController.navigate(MainMenu) { popUpTo<MainMenu> { inclusive = true } } },
                { navController.navigate(AddCube) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(Search) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(UploadAlgorithm) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(CubeView(it)) }
            )
        }

        composable<UploadAlgorithm> {
            UploadScreen(
                { navController.navigate(MainMenu) { popUpTo<MainMenu> { inclusive = true } } },
                { navController.navigate(AddCube) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(Search) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(UploadAlgorithm) { popUpTo<MainMenu> { inclusive = false } } }
            )
        }

        composable<CubeView> { backStackEntry ->
            val cubeView = backStackEntry.toRoute<CubeView>()
            cubeViewModel.getCube(cubeView.id)
            CubeViewScreen(
                cubeViewModel,
                { navController.navigate(MainMenu) { popUpTo<MainMenu> { inclusive = true } } },
                { navController.navigate(AddCube) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(Search) { popUpTo<MainMenu> { inclusive = false } } },
                { navController.navigate(UploadAlgorithm) { popUpTo<MainMenu> { inclusive = false } } }
            )
        }
    }
}