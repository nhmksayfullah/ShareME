package com.example.shareme.presentation.notes.components

import com.example.shareme.data.SignUp.Note
import com.example.shareme.domin.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}