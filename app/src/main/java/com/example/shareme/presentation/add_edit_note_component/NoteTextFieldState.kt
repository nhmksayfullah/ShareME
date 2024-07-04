package com.example.shareme.presentation.add_edit_note_component

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)