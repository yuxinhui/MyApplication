/*
package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yuxinhui.text.myapplication.R;

public class MsgSettingActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView mivReturn,mivZhendong,mivAudio;
    RelativeLayout miandarao;
    Button unLogin;
    boolean isVibrate=true,isRing=true;
    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_setting);
        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        initView();
        setOnClickLIstener();
    }

    private void setOnClickLIstener() {
        mivReturn.setOnClickListener(this);
        mivZhendong.setOnClickListener(this);
        mivAudio.setOnClickListener(this);
        miandarao.setOnClickListener(this);
        unLogin.setOnClickListener(this);
    }

    private void initView() {
        mivReturn = (ImageView) findViewById(R.id.msg_setting_back);
        mivZhendong = (ImageView) findViewById(R.id.iv_vibrate_setting);
        mivAudio = (ImageView) findViewById(R.id.iv_audio_setting);
        miandarao = (RelativeLayout) findViewById(R.id.miandarao);
        unLogin = (Button) findViewById(R.id.un_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msg_setting_back:
                this.finish();
                break;
            case R.id.iv_vibrate_setting:
                if(isVibrate){
                    mivZhendong.setImageResource(R.mipmap.icon_close);
                    am.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,AudioManager.VIBRATE_SETTING_OFF);
                }else {
                    mivZhendong.setImageResource(R.mipmap.icon_opne);
                    am.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,AudioManager.VIBRATE_SETTING_ON);
                }
                isVibrate = !isVibrate;
                break;
            case R.id.iv_audio_setting:
                if (isRing) {
                    mivAudio.setImageResource(R.mipmap.icon_close);
                    am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                }else{
                    mivAudio.setImageResource(R.mipmap.icon_opne);
                    am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                }
                isRing = !isRing;
                break;
            case R.id.miandarao:
                Intent intent = new Intent(this,MianDaRaoActivity.class);
                startActivity(intent);
                break;
            case R.id.un_login:
                unLogin.setText("点击登陆");
                break;
        }
    }
}
*/
