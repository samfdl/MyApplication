package com.samfdl.opengl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.AllList;
import com.samfdl.R;
import com.samfdl.media.Audio1;
import com.samfdl.media.CameraV2;
import com.samfdl.media.CaptureScreen;
import com.samfdl.media.MediaPlayer1;
import com.samfdl.media.MusicBox;
import com.samfdl.media.RecordSound;
import com.samfdl.media.RecordVideo;
import com.samfdl.media.SoundPool1;
import com.samfdl.media.SurfaceViewPlayVideo;
import com.samfdl.media.VideoView1;

public class OpenGLList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new OpenGLListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(OpenGLList.this, Audio1.class);
                        break;
                    case 1:
                        intent = new Intent(OpenGLList.this, MusicBox.class);
                        break;
                    case 2:
                        intent = new Intent(OpenGLList.this, MediaPlayer1.class);
                        break;
                    case 3:
                        intent = new Intent(OpenGLList.this, SoundPool1.class);
                        break;
                    case 4:
                        intent = new Intent(OpenGLList.this, VideoView1.class);
                        break;
                    case 5:
                        intent = new Intent(OpenGLList.this, SurfaceViewPlayVideo.class);
                        break;
                    case 6:
                        intent = new Intent(OpenGLList.this, RecordSound.class);
                        break;
                    case 7:
                        intent = new Intent(OpenGLList.this, CameraV2.class);
                        break;
                    case 8:
                        intent = new Intent(OpenGLList.this, RecordVideo.class);
                        break;
                    case 9:
                        intent = new Intent(OpenGLList.this, CaptureScreen.class);
                        break;
                    default:
                        intent = new Intent(OpenGLList.this, Audio1.class);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, AllList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}