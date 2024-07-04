package com.example.shareme.domin.use_case

import com.example.shareme.data.SignUp.Note
import com.example.shareme.domin.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}