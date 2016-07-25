package com.yuxinhui.text.myapplication.Actiity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.Player;

public class PlayVideoActivity extends AppCompatActivity {
    private SurfaceView surfaceView;
    ImageView mivPlay;
    private SeekBar skbProgress;
    private Player player;
    String url;
    private boolean isPlayed = false,isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        surfaceView = (SurfaceView) this.findViewById(R.id.surfaceView1);

        mivPlay = (ImageView) findViewById(R.id.play);
        mivPlay.setOnClickListener(new ClickEvent());

        skbProgress = (SeekBar) this.findViewById(R.id.skbProgress);
        skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(surfaceView, skbProgress);
    }

    class ClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            if(isPlaying){
                mivPlay.setImageResource(R.mipmap.icon_play);
                player.pause();
            }else {
                mivPlay.setImageResource(R.mipmap.icon_pause);
                if(isPlayed){
                    player.play();
                }else {
                    player.playUrl(url);
                    isPlayed=true;
                }
            }
            isPlaying = !isPlaying;
        }
    }
    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // 原本是(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
            this.progress = progress * player.mediaPlayer.getDuration()
                    / seekBar.getMax();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
            player.mediaPlayer.seekTo(progress);
        }
    }

    @Override
    public void finish() {
        if (isPlaying){
        player.stop();}
        super.finish();
    }
}
