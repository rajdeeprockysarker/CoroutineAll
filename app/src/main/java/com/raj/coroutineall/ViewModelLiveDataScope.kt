package com.raj.coroutineall

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay

class ViewModelLiveDataScope: ViewModel() {


    private val _userId: MutableLiveData<Int> = MutableLiveData()
    val user = Transformations
        .switchMap(_userId) { _userId ->
        liveData(viewModelScope.coroutineContext +  IO ) {
            emit("database.loadUserById(_userId)")
            delay(1000);
            emit("database.insertAll_into_another_DB(_userId)")
        }
    }



    fun setUserId(userId: Int){
        val update = userId
        if (_userId.value == update) {
            return
        }
        _userId.value = update
    }





}