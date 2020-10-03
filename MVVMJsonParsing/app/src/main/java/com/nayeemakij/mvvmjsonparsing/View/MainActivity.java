package com.nayeemakij.mvvmjsonparsing.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nayeemakij.mvvmjsonparsing.Model.User;
import com.nayeemakij.mvvmjsonparsing.R;
import com.nayeemakij.mvvmjsonparsing.Viewmodel.MainActivityViewModel;
import com.nayeemakij.mvvmjsonparsing.adapter.UserAdapter;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel activityViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.userRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        activityViewModel.AllUserliveData().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(User[] users) {
                recyclerView.setAdapter(new UserAdapter(users));
            }
        });
    }
}