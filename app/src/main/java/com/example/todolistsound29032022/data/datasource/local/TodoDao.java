package com.example.todolistsound29032022.data.datasource.local;

import androidx.room.Dao;
import androidx.room.Query;
import com.example.todolistsound29032022.data.datasource.local.entities.TodoEntity;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface TodoDao {

    @Query("Select * from to_do")
    Flowable<List<TodoEntity>> getTodoLists();
}
