package org.bloodwyn.userdata.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.bloodwyn.userdata.data.User
import org.bloodwyn.userdata.data.UserRepository
import org.bloodwyn.userdata.data.UserRepositoryImpl

private const val TAG = "UsersViewModel"

class UsersViewModel(private val userRepository: UserRepository) : ViewModel() {

    var users: ObservableField<List<User>?> = ObservableField()

    init {
        loadData()
    }

    fun loadData() {
        Log.i(TAG, userRepository.toString())
        userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ fetchedUsers -> users.set(fetchedUsers) }, { exception ->
                Log.i(TAG, exception.toString())
            })
    }
}