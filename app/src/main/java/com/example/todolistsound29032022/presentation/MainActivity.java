package com.example.todolistsound29032022.presentation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todolistsound29032022.R;
import com.example.todolistsound29032022.data.model.Todo;
import com.example.todolistsound29032022.presentation.viewmodel.MainViewModel;
import com.example.todolistsound29032022.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    Button btnRecord, btnStop, btnPlayRecord;
    TextView tvNameRecord;
    int requestCodeRecord = 123;
    boolean isPermissionGranted = false;
    MediaRecorder mediaRecorder;
    File fileRecord;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecord = findViewById(R.id.button_record);
        btnStop = findViewById(R.id.button_stop);
        btnPlayRecord = findViewById(R.id.button_play_record);
        tvNameRecord = findViewById(R.id.text_view_name_record_file);

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, requestCodeRecord);
        } else {
            isPermissionGranted = true;
        }

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
                Log.d("BBB", todos.size() + "");
            }
        });

        mainViewModel.queryTodoLists();

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPermissionGranted) {
                    startAndSaveRecordToFile(FileUtil.createFileNameRecord(MainActivity.this));
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRecord();
                if (fileRecord != null){
                    btnPlayRecord.setVisibility(View.VISIBLE);
                    tvNameRecord.setVisibility(View.VISIBLE);
                    String fileName = getFileName(fileRecord);
                    tvNameRecord.setText(fileName);
                } else {
                    btnPlayRecord.setVisibility(View.GONE);
                    tvNameRecord.setVisibility(View.GONE);
                }
            }
        });

        btnPlayRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }
                try {
                    mediaPlayer.setDataSource(fileRecord.getAbsolutePath());
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String getFileName(File file) {
        return file.getName();
    }

    private void startAndSaveRecordToFile(File file) {
        fileRecord = file;
        if (mediaRecorder == null) {
            mediaRecorder = new MediaRecorder();
        }
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(file.getAbsolutePath());
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopRecord() {
        if (mediaRecorder == null) return;
        mediaRecorder.stop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCodeRecord == requestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                isPermissionGranted = true;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void testSaveAndGetBitmap() {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.asynchornous);
//        String nameImage = String.format("image%d",System.currentTimeMillis());
//        String path = FileUtil.saveToInternalStorage(bitmap, this, nameImage);
//        Log.d("BBB", path);
//        Uri: /data/data/com.example.todolistsound29032022/app_assets/image1655813701493.png
//        Bitmap bitmap = FileUtil.loadImageFromStorage("/data/data/com.example.todolistsound29032022/app_assets/image1655813701493.png");
//        img.setImageBitmap(bitmap);
    }
}
