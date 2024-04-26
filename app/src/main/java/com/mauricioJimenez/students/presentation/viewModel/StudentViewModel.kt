package com.mauricioJimenez.students.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauricioJimenez.students.domain.entities.Student
import com.mauricioJimenez.students.domain.useCase.DeleteStudentUseCase
import com.mauricioJimenez.students.domain.useCase.GetStudentDataUseCase
import com.mauricioJimenez.students.domain.useCase.InsertStudentDataUseCase
import com.mauricioJimenez.students.domain.useCase.UpdateStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@HiltViewModel
class StudentViewModel @Inject constructor(
    private val getStudentDataUseCase: GetStudentDataUseCase,
    private val insertStudentDataUseCase: InsertStudentDataUseCase,
    private val deleteStudentUseCase: DeleteStudentUseCase,
    private val updateStudentUseCase: UpdateStudentUseCase,
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
    fun insertStudentData(name: String, age:String){
        viewModelScope.launch(coroutineContext){
            insertStudentDataUseCase(name, age)
        }
    }
    fun deleteStudent(id:Int){
        viewModelScope.launch(coroutineContext) {
            deleteStudentUseCase(id)
        }
    }

    fun updateStudent(studentId: Int, name: String, age: String){
        viewModelScope.launch(coroutineContext){
            updateStudentUseCase(studentId, name, age)
        }
    }
}