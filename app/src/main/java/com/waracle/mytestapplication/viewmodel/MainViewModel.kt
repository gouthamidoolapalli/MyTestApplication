package com.waracle.mytestapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waracle.mytestapplication.model.Cake
import com.waracle.mytestapplication.network.Resource
import com.waracle.mytestapplication.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    var myCakesResponse = MutableLiveData<Resource<List<Cake>>>()
    val loading = MutableLiveData<Boolean>()


    fun getAllCakes() {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            myCakesResponse.postValue(Resource.loading(null))
            mainRepository.getCakes().let { it ->
                if (it.isSuccessful){
                    val myList : List<Cake>? = it.body()
                    //remove duplicates
                    val myDistinctList : List<Cake>? = myList?.distinctBy { it.title }
                    //sort by name
                    val sortedList :List<Cake>? = myDistinctList?.sortedBy { it.title }
                    myCakesResponse.postValue(Resource.success(sortedList))
                }else{
                    myCakesResponse.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        }
    }
}