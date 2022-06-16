package com.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Place
import retrofit2.http.Query

class PlaceViewModel :ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()//用于对界面显示的城市信息进行缓存

    val placeLiveData = Transformations.switchMap(searchLiveData){
        query -> Repository.searchPlaces(query)//ViewModel中的某个LiveData是调用另外的方法获取的需要借助SwitchMap()方法
    }

    fun searchPlaces(query: String){
        searchLiveData.value = query
    }



}