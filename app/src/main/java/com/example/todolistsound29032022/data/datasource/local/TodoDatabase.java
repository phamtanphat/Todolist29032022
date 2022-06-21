package com.example.todolistsound29032022.data.datasource.local;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todolistsound29032022.data.datasource.local.entities.TodoEntity;

@Database(entities = TodoEntity.class, version = 1)
public abstract class TodoDatabase extends RoomDatabase {
    private static TodoDatabase instance;
    public abstract TodoDao todoDao();

    public static TodoDatabase getInstance(Application context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context,
                    TodoDatabase.class,
                    "todo_database.sql"
            ).build();
        }
        return instance;
    }
}
