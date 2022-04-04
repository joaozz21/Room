package com.generation.todo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todo.data.User
import com.generation.todo.data.UserDataBase
import com.generation.todo.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(context: Context?): ViewModel() {

    val lerTodosOsDados: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao= UserDataBase.getDatabase(context!!).userDao()
        repository= UserRepository(userDao)
        lerTodosOsDados= repository.lerTodosOsDados
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

}