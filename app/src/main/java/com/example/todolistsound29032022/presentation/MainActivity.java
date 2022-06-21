package com.example.todolistsound29032022.presentation;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.todolistsound29032022.R;
import com.example.todolistsound29032022.data.model.Todo;
import com.example.todolistsound29032022.presentation.viewmodel.MainViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(MainActivity.this);
            }
        }).get(MainViewModel.class);

        mainViewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("BBB", s);
            }
        });

        mainViewModel.getTodoLists().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                Log.d("BBB",todos.size() + "");
            }
        });

        mainViewModel.queryTodoLists();
    }
}
