package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gensee.common.ServiceType;
import com.gensee.entity.InitParam;
import com.gensee.entity.UserInfo;
import com.gensee.net.AbsRtAction;
import com.gensee.player.OnPlayListener;
import com.gensee.player.Player;
import com.gensee.view.GSVideoView;
import com.yuxinhui.text.myapplication.R;

/**直播视频的activity
 * Created by Administrator on 2016/5/31.
 * */

public class ZhiboActivity extends AppCompatActivity implements OnPlayListener{

    private GSVideoView mGSzhibo;//视频插件
    Player player = new Player();
    InitParam initParam = new InitParam();
    Handler mHandler = new Handler();
    ImageView mIvbackgroud,mIvplayer,mContentZhibo,mIvretrun;
    boolean isPlayed = false;
    TextView mtvFullScreen;
    SeekBar msbAudio;
    AudioManager am ;
    int streamVolume;
//    String url = "dd020436921d43a79dcf6965415179f8";
    //491a1a7b416043b0987c499690412a11

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhibo);
        Log.e("TAG",isPlayed+"");
        am= (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        streamVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);//获取系统当前的媒体音量
        initView();
        setOnClick();
    }

    //实例化控件
    private void initView() {
        mIvbackgroud = (ImageView) findViewById(R.id.iv_backgroud);
        mGSzhibo = (GSVideoView)findViewById(R.id.zhibo_video);
        mContentZhibo = (ImageView) findViewById(R.id.contentZhibo);
        mIvretrun = (ImageView) findViewById(R.id.zhibo_return_img);
        mtvFullScreen = (TextView) findViewById(R.id.tv_fullscreen);
        msbAudio = (SeekBar) findViewById(R.id.sb_audio);
        msbAudio.setProgress(streamVolume);
        mIvplayer = (ImageView) findViewById(R.id.iv_player);
        player.setGSVideoView(mGSzhibo);
        initParam.setDomain("yxhcorp.gensee.com");
        initParam.setNumber("19367734");
        initParam.setLiveId("dd020436921d43a79dcf6965415179f8");
        initParam.setJoinPwd("");
        initParam.setNickName("android");
        initParam.setServiceType(ServiceType.WEBCAST);
        initParam.setLoginPwd("");
        initParam.setLoginAccount("");
    }

    //结束这个activity
    private void finishactivity(){
        this.finish();
    }

    @Override
    public void finish() {
        player.leave();
        super.finish();
    }

    //设置每个控件的监听事件
    public void setOnClick(){
        mIvretrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishactivity();
            }
        });
        mIvplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvbackgroud.setVisibility(View.GONE);
                mIvplayer.setVisibility(View.GONE);
                isPlayed = true;
                initplayer(initParam);
            }
        });
        mGSzhibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlayed){
                    mIvplayer.setVisibility(View.VISIBLE);
                    pausePlay();
                }else{
                    mIvbackgroud.setVisibility(View.GONE);
                    mIvplayer.setVisibility(View.GONE);
                    resume();
                }
                isPlayed = !isPlayed;
            }
        });
        msbAudio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                changeAudio(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //设置全屏播放按钮的监听
        mtvFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //改变系统音量大小的方法
    public void changeAudio(final int i){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                am.setStreamVolume(AudioManager.STREAM_MUSIC,streamVolume,i);
            }
        });

//        sp.load(this, seekBar, i);
    }

    //暂停视频播放
    private void pausePlay() {
        if (player != null) {
            player.leave();
        }
    }

    //恢复视频播放
    private void resume() {
        if (player != null) {
            player.join(getApplicationContext(),initParam,this);
        }
    }

    //初始化播放器（开始播放）
    private void initplayer(final InitParam initParam) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                player.join(getApplicationContext(), initParam, ZhiboActivity.this);
            }
        });

    }


    @Override
    public void onJoin(int result) {
        String msg = null;
        switch (result) {
            case JOIN_OK:
                msg = "加入成功";
                Log.e("TAG",msg);
                break;
            case JOIN_CONNECTING:
                msg = "正在加入";
                Log.e("Tag",msg);
                break;
            case JOIN_CONNECT_FAILED:
                msg = "连接失败";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                Log.e("TAG", msg);
                break;
            case JOIN_RTMP_FAILED:
                msg = "连接服务器失败";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                Log.e("TAG", msg);
                break;
            case JOIN_TOO_EARLY:
                msg = "直播还未开始";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                Log.e("TAG",msg);
                break;
            case JOIN_LICENSE:
                msg = "人数已满";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                Log.e("TAG", msg);
                break;
            default:
                msg = "加入返回错误" + result;
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                Log.e("TAG",msg);
                break;
        }

    }

    @Override
    public void onUserJoin(UserInfo userInfo) {

    }

    @Override
    public void onUserLeave(UserInfo userInfo) {

    }

    @Override
    public void onUserUpdate(UserInfo userInfo) {

    }

    @Override
    public void onRosterTotal(int i) {

    }

    @Override
    public void onReconnecting() {
        onJoin(JOIN_CONNECTING);
    }

    @Override
    public void onLeave(int i) {
        String msg = "";
        switch (i){
            case LEAVE_NORMAL:
                msg = "leave nomal";
                break;
            case LEAVE_KICKOUT:
                msg = "你已经被踢出";
                break;
            case LEAVE_TIMEOUT:
                msg = "连接超时，已退出";
                break;
            case LEAVE_CLOSE:
                msg = "直播间已经关闭";
                break;
            case LEAVE_UNKNOWN:
                msg = "因为未知原因退出";
                break;
            case LEAVE_RELOGIN:
                msg = "因为异地登录退出";
                break;
        }
        if (msg !=null) {
            final String finalMsg = msg;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ZhiboActivity.this, finalMsg,Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void onCaching(boolean b) {

    }


    @Override
    public void onErr(int errCode) {
        String msg = null;
        switch (errCode) {
            case AbsRtAction.ErrCode.ERR_DOMAIN:
                msg = "域名domain不正确";
                break;
            case AbsRtAction.ErrCode.ERR_TIME_OUT:
                msg = "请求超时，稍后重试";
                break;
            case AbsRtAction.ErrCode.ERR_SITE_UNUSED:
                msg = "站点不可用，请联系客服或相关人员";
                break;
            case AbsRtAction.ErrCode.ERR_UN_NET:
                msg = "网络不可用，请检查网络连接正常后再试";
                break;
            case AbsRtAction.ErrCode.ERR_SERVICE:
                msg = "service  错误，请确认是webcast还是training";
                break;
            case AbsRtAction.ErrCode.ERR_PARAM:
                msg = "initparam参数不全";
                break;
            case AbsRtAction.ErrCode.ERR_THIRD_CERTIFICATION_AUTHORITY:
                msg = "第三方认证失败";
                break;
            case AbsRtAction.ErrCode.ERR_NUMBER_UNEXIST:
                msg = "编号不存在";
                break;
            case AbsRtAction.ErrCode.ERR_TOKEN:
                msg = "口令错误";
                break;
            case AbsRtAction.ErrCode.ERR_LOGIN:
                msg = "站点登录帐号或登录密码错误";
                break;
            default:
                msg = "错误：errCode = " + errCode;
                break;
        }
        if (msg != null) {
            final String finalMsg = msg;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ZhiboActivity.this, finalMsg,Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void onDocSwitch(int i, String s) {

    }

    @Override
    public void onVideoBegin() {
        Log.e("TAG", "VideoBegin");
//        mVodPlayer.play(getVodIdOrLocalPath(), this, "");
    }

    @Override
    public void onVideoEnd() {

    }

    @Override
    public void onAudioLevel(int i) {

    }

    @Override
    public void onPublish(boolean b) {

    }

    @Override
    public void onSubject(String s) {

    }

    @Override
    public void onPageSize(int i, int i1, int i2) {

    }


    @Override
    public void onPublicMsg(long l, String s) {

    }

    @Override
    public void onLiveText(String s, String s1) {

    }

    @Override
    public void onRollcall(int i) {

    }

    @Override
    public void onLottery(int i, String s) {

    }

    @Override
    public void onFileShare(int i, String s, String s1) {

    }

    @Override
    public void onFileShareDl(int i, String s, String s1) {

    }

    @Override
    public void onInvite(int i, boolean b) {

    }

    @Override
    public void onMicNotify(int i) {

    }
}
