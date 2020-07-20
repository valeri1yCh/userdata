package org.bloodwyn.userdata.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.bloodwyn.userdata.data.User
import org.bloodwyn.userdata.data.UserRepository

private const val TAG = "UsersViewModel"

class UsersViewModel(private val userRepository: UserRepository) : ViewModel() {

    var users: ObservableField<List<User>?> = ObservableField()

    private var subscriptions = ArrayList<Disposable>()

    fun start() {
        loadData()
    }

    private fun loadData() {
        val subscribe = userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ fetchedUsers -> users.set(fetchedUsers) }, { exception ->
                Log.i(TAG, exception.stackTrace.toString())
            })
        subscriptions.add(subscribe)
    }

    override fun onCleared() {
        subscriptions.clear()
        super.onCleared()
    }
}