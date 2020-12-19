package com.example.modul11.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modul11.api.PhotosService
import com.example.modul11.model.Photo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

//view model sebagai penyedia data
class ListViewModel: ViewModel() {
    private val photosService = PhotosService()
    private val disposable = CompositeDisposable()
    val photos = MutableLiveData<List<Photo>>()

    //mengambil data
    fun fetchData(){
        disposable.add(
            photosService.getPhotos()
                //membuat thread baru dan mengirim hasil kerja
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Photo>>(){
                    //mengirim data jika thread berhasil
                    override fun onSuccess(value: List<Photo>?) {
                        photos.value = value
                    }

                    //menampilkan log eror jika thread gagal
                    override fun onError(e: Throwable?) {
                        Log.e("ERRORFETCHDATA", "error$e")
                    }
                })
        )
    }

    //menghapus data
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}