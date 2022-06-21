package com.example.todolistsound29032022.data.repository;

import android.content.Context;

import com.example.todolistsound29032022.data.datasource.local.TodoDao;
import com.example.todolistsound29032022.data.datasource.local.TodoDatabase;
import com.example.todolistsound29032022.data.datasource.local.entities.TodoEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class TodoRepository {
    private TodoDao todoDao;

    public TodoRepository(Context context) {
        todoDao = TodoDatabase.getInstance(context).todoDao();
    }

    public Flowable<List<TodoEntity>> getTodoLists() {
        return todoDao.getTodoLists();
    }
}
