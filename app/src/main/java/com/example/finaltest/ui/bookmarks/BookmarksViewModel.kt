package com.example.finaltest.ui.bookmarks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookmarksViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is bookmarks Fragment"
    }
    val text: LiveData<String> = _text
}