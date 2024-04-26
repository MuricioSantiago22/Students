package com.mauricioJimenez.students.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauricioJimenez.students.domain.entities.Student
import com.mauricioJimenez.students.domain.useCase.GetStudentDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@HiltViewModel
class StudentViewModel @Inject constructor(
    private val getStudentDataUseCase: GetStudentDataUseCase,
    private val coroutineContext: CoroutineContext
): ViewModel() {

    private val _studentDataList : MutableLiveData<List<Student>> = MutableLiveData()
    val studentDataList: LiveData<List<Student>> get() = _studentDataList

    fun getStudentData(){
        viewModelScope.launch(coroutineContext){
            val response = getStudentDataUseCase()
            withContext(Dispatchers.Main){
                _studentDataList.value = response
            }
        }
    }
    fun insertStudentData(){

    }
}