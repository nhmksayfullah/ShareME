package com.example.shareme.presentation.notes.components

import com.example.shareme.data.SignUp.Note
import com.example.shareme.domin.util.NoteOrder
import com.example.shareme.domin.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder =NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false
)