package com.example.resume.viewmodel

import androidx.lifecycle.ViewModel
import com.example.resume.R
import com.example.resume.model.StudentInfo

class StudentViewModel : ViewModel() {
    val studentInfo = StudentInfo(
        photoResId = R.drawable.artaz,
        studentId = "993613031",
        telegramId = "cryofme"
    )
}