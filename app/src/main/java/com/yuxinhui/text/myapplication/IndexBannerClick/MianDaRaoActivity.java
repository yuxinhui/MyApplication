package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yuxinhui.text.myapplication.R;

import java.util.Calendar;

public class MianDaRaoActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView mivReturn,mivOpenmsg,mivOpneinnight,mivClosemsg;
    RelativeLayout mOpenMsg,mOpenInNight,mCloseMsg;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian_da_rao);
        initView();
        setOnclickListener();
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

    }

    private void setOnclickListener() {
        mivReturn.setOnClickListener(this);
        mOpenMsg.setOnClickListener(this);
        mOpenInNight.setOnClickListener(this);
        mCloseMsg.setOnClickListener(this);
    }

    private void initView() {
        mivReturn = (ImageView) findViewById(R.id.miandarao_back);
        mivOpenmsg = (ImageView) findViewById(R.id.iv_open_msg);
        mivOpneinnight = (ImageView) findViewById(R.id.iv_openonnight);
        mivClosemsg = (ImageView) findViewById(R.id.iv_close_msg);
        mOpenMsg = (RelativeLayout) findViewById(R.id.open_msg);
        mOpenInNight = (RelativeLayout) findViewById(R.id.openonnight);
        mCloseMsg = (RelativeLayout) findViewById(R.id.close_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.miandarao_back:
                this.finish();
                break;
            case R.id.open_msg:
                mivOpenmsg.setVisibility(View.VISIBLE);
                mivClosemsg.setVisibility(View.GONE);
                mivOpneinnight.setVisibility(View.GONE);
                break;
            case R.id.openonnight:
                mivOpenmsg.setVisibility(View.GONE);
                mivClosemsg.setVisibility(View.GONE);
                mivOpneinnight.setVisibility(View.VISIBLE);
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                if(hour>22||hour<8){
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                }else {
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                }
                break;
            case R.id.close_msg:
                mivOpenmsg.setVisibility(View.GONE);
                mivClosemsg.setVisibility(View.VISIBLE);
                mivOpneinnight.setVisibility(View.GONE);
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                break;
        }
    }
}
