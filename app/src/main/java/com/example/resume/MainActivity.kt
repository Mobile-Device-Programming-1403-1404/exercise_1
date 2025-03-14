package com.example.resume

import ResumeTheme
import StudentInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resume.viewmodel.StudentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResumeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val studentViewModel: StudentViewModel = viewModel()
                    StudentInfo(studentViewModel = studentViewModel)
                }
            }
        }
    }
}