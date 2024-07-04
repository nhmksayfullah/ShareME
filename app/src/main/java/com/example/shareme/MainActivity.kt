package com.example.shareme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.shareme.presentation.add_edit_note_component.EditScreen
import com.example.shareme.presentation.add_edit_note_component.addEditNoteScreen
import com.example.shareme.presentation.notes.util.Screen
import com.example.shareme.ui.theme.Content
import com.example.shareme.ui.theme.ShareMETheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShareMETheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Content.route
                ) {
                    composable(
                        route = Screen.Content.route
                    ) {
                        Content(navController = navController)
                    }
                    composable(
                        route = Screen.AddEditNoteScreen.route +
                                "?noteId={noteId}&noteColor={noteColor}",
                        arguments = listOf(
                            navArgument("noteId") {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                            navArgument("noteColor") {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                        )
                    ) {
                        val color = it.arguments?.getInt("noteColor") ?: -1
                        addEditNoteScreen(
                            navController = navController,
                            color = color
                        )
                    }
                    composable(
                        route = Screen.EditNoteScreen.route +
                                "?noteId={noteId}&noteTitle={noteTitle}&noteContent={noteContent}&noteColor={noteColor}",
                        arguments = listOf(
                            navArgument("noteId") {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                            navArgument("noteTitle") {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument("noteContent") {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument("noteColor") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        val noteId = it.arguments?.getInt("noteId") ?: -1
                        val noteTitle = it.arguments?.getString("noteTitle") ?: ""
                        val noteContent = it.arguments?.getString("noteContent") ?: ""
                        val noteColor = it.arguments?.getInt("noteColor") ?: -1

                        EditScreen(
                            navController = navController,
                            noteId = noteId,
                            noteTitle = noteTitle,
                            noteContent = noteContent,
                            noteColor = noteColor
                        )
                    }
                }
            }
        }
    }
}
