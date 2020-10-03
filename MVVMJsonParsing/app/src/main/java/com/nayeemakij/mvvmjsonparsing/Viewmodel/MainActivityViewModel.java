package com.nayeemakij.mvvmjsonparsing.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nayeemakij.mvvmjsonparsing.Model.User;
import com.nayeemakij.mvvmjsonparsing.Model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

    UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }
    public LiveData<User[]> AllUserliveData(){
        return userRepository.getUserData();
    }
}
