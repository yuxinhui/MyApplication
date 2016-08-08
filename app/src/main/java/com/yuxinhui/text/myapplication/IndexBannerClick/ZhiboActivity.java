package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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
import com.yuxinhui.text.myapplication.Fragment.zhibo.ZhiboChat;
import com.yuxinhui.text.myapplication.Fragment.zhibo.ZhiboJianjie;
import com.yuxinhui.text.myapplication.Fragment.zhibo.ZhiboVideo;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;
import com.yuxinhui.text.myapplication.Utils.ExampleClient;
import com.yuxinhui.text.myapplication.Utils.NetUtil;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 直播视频的activity
 * Created by Administrator on 2016/5/31.
 */
public class ZhiboActivity extends FragmentActivity implements OnPlayListener, View.OnClickListener {

    private final static int SCREEN_LAND = 0;
    private final static int SCREEN_PORT = 1;
    private int screen_direction;
    private GSVideoView mGSzhibo, mGSzhiboLand;//视频插件
    Player player = new Player();
    InitParam initParam = new InitParam();
    ImageView mIvplayer, mivPlayLand;
    boolean isPlayed;
    ImageView mtvFullScreen, mivNormalScreen, mivfinish;
    View mLayoutBack;
    View mLayoutConterl;
    SeekBar msbAudio, msbAudioLand;
    AudioManager am;
    int streamVolume;
    int streamMaxVolume;
    ExampleClient client;
    boolean isShowLayout;
    //直播下面的控件
    private ImageButton chat_img, jianjie_img, video_img;
    private TextView chat_txt, jianjie_txt, video_txt;
    private ViewPager zhibo_viewpager;
    private ZhiboVPAdapter zhiboVPAdapter;
    private List<Fragment> mFragments;
    public static int STOPTAG;
    public String kk;

    private RelativeLayout loading_rl;
    private ProgressBar loading_large_img;

    interface HANDlER {
        int USERINCREASE = 1;
        int USERDECREASE = 2;
        int USERUPDATE = 3;
        int SUCCESSJOIN = 4;
        int SUCCESSLEAVE = 5;
        int CACHING = 6;
        int CACHING_END = 7;
        int RECONNECTING = 8;
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.e("msg",msg.toString());
            switch (msg.what) {
                case HANDlER.USERINCREASE:
                    break;
                case HANDlER.USERDECREASE:
                    break;
                case HANDlER.USERUPDATE:
                    break;
                case HANDlER.SUCCESSJOIN:
                    loading_rl.setVisibility(View.GONE);
                    loading_large_img.setVisibility(View.GONE);
                    break;
                case HANDlER.SUCCESSLEAVE:
                    break;
                case HANDlER.CACHING:
                    loading_rl.setVisibility(View.VISIBLE);
                    loading_large_img.setVisibility(View.VISIBLE);
                    break;
                case HANDlER.CACHING_END:
                    break;
                case HANDlER.RECONNECTING:
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhibo);
        checkWifi();
        client = new ExampleClient(URI.create(YuXinHuiApplication.URL_BOOT + "ws?id=" + YuXinHuiApplication.getInstace().getUser().getId()), this);
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        streamVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);//获取系统当前的媒体音量
        streamMaxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        screen_direction = SCREEN_PORT;
        initView();
        initClickListener();
        setOnClick();
        initVariable();
        client.connect();
        isShowLayout = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                kk = NetUtil.getK();
                initParam(kk);
                initplayer();
                isPlayed = true;
            }
        }).start();
    }

    public void initParam(String s) {
        initParam.setDomain("longding999.gensee.com");
        initParam.setNumber("05719166");
        initParam.setNickName("android");
        initParam.setK(s);
        initParam.setServiceType(ServiceType.WEBCAST);
    }

    private void initVariable() {
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new ZhiboChat());
        mFragments.add(new ZhiboJianjie());
        mFragments.add(new ZhiboVideo());
        zhiboVPAdapter = new ZhiboVPAdapter(getSupportFragmentManager(), mFragments);
        zhibo_viewpager.setAdapter(zhiboVPAdapter);
    }

    //实例化控件
    private void initView() {
        mivfinish = (ImageView) findViewById(R.id.zhibo_back);
        mLayoutConterl = findViewById(R.id.layout_conterl);
        mLayoutBack = findViewById(R.id.layout_back);
        mGSzhibo = (GSVideoView) findViewById(R.id.zhibo_video);
        mtvFullScreen = (ImageView) findViewById(R.id.tv_fullscreen);
        msbAudio = (SeekBar) findViewById(R.id.sb_audio);
        msbAudio.setMax(streamMaxVolume);
        msbAudio.setProgress(streamVolume);
        mIvplayer = (ImageView) findViewById(R.id.iv_player);
        mIvplayer.setVisibility(View.GONE);
        player.setGSVideoView(mGSzhibo);

        //播放下面的控件
        chat_img = (ImageButton) findViewById(R.id.chat_img);
        jianjie_img = (ImageButton) findViewById(R.id.intro_img);
        video_img = (ImageButton) findViewById(R.id.video_img);
        chat_txt = (TextView) findViewById(R.id.chat_txt);
        jianjie_txt = (TextView) findViewById(R.id.intro_txt);
        video_txt = (TextView) findViewById(R.id.video_txt);
        zhibo_viewpager = (ViewPager) findViewById(R.id.zhibo_vp);
        //滑动监听
        zhibo_viewpager.addOnPageChangeListener(new ZhiboOnPageChangeListener());

        //刚进去加载布局
        loading_rl = (RelativeLayout) findViewById(R.id.loading_rl);
        loading_large_img= (ProgressBar) findViewById(R.id.loading_large_img);
    }

    //结束这个activity
    private void finishactivity() {
        this.finish();
    }

    //横竖屏的切换处理
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            this.setContentView(R.layout.activity_zhibo);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            screen_direction = SCREEN_LAND;
            initLandView();
            setLandOnClick();
            isShowLayout = true;
            if (isPlayed) {
                player.leave();
                player.setGSVideoView(mGSzhiboLand);
                initplayer();
                mivPlayLand.setVisibility(View.GONE);
            }
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            this.setContentView(R.layout.activity_zhibo);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            screen_direction = SCREEN_PORT;
            initView();
            zhibo_viewpager.addOnPageChangeListener(new ZhiboOnPageChangeListener());
            initClickListener();
            zhiboVPAdapter = new ZhiboVPAdapter(getSupportFragmentManager(), mFragments);
            zhibo_viewpager.setAdapter(zhiboVPAdapter);
            setOnClick();
            isShowLayout = true;
            if (isPlayed) {
                mIvplayer.setVisibility(View.GONE);
                player.leave();
                player.setGSVideoView(mGSzhibo);
                initplayer();
            }
        }
    }

    //设置横屏时的监听事件
    private void setLandOnClick() {
        mivfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZhiboActivity.this.finish();
            }
        });
        mivPlayLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initplayer();
            }
        });
        mGSzhiboLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowLayout) {
                    mLayoutConterl.setVisibility(View.GONE);
                    mLayoutBack.setVisibility(View.GONE);
                } else {
                    mLayoutBack.setVisibility(View.VISIBLE);
                    mLayoutConterl.setVisibility(View.VISIBLE);
                }
                isShowLayout = !isShowLayout;
            }
        });
        msbAudioLand.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
        mivNormalScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
    }

    //初始化橫屏控件
    private void initLandView() {
        mivfinish = (ImageView) findViewById(R.id.iv_finish_land);
        mLayoutBack = findViewById(R.id.layoou_back_land);
        mLayoutConterl = findViewById(R.id.layout_control_land);
        mGSzhiboLand = (GSVideoView) findViewById(R.id.zhibo_video_land);
        msbAudioLand = (SeekBar) findViewById(R.id.sb_audio_land);
        msbAudioLand.setMax(streamMaxVolume);
        msbAudioLand.setProgress(streamVolume);
        mivNormalScreen = (ImageView) findViewById(R.id.iv_normalscreen);
        mivPlayLand = (ImageView) findViewById(R.id.iv_player_land);
    }

    @Override
    public void finish() {
        if (screen_direction == SCREEN_LAND) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            player.leave();
            super.finish();
        }
    }

    //设置每个控件的监听事件
    public void setOnClick() {
        mivfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZhiboActivity.this.finish();
            }
        });
        mIvplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvplayer.setVisibility(View.GONE);
                isPlayed = true;
                initplayer();
            }
        });
        mGSzhibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowLayout) {
                    mLayoutConterl.setVisibility(View.GONE);
                    mLayoutBack.setVisibility(View.GONE);
                } else {
                    mLayoutBack.setVisibility(View.VISIBLE);
                    mLayoutConterl.setVisibility(View.VISIBLE);
                }
                isShowLayout = !isShowLayout;
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
                playbyFullscreen();
            }
        });
        //聊天监听

    }

    //全屏播放的方法
    private void playbyFullscreen() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    //改变系统音量大小的方法
    public void changeAudio(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
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
            player.join(getApplicationContext(), initParam, this);
        }
    }

    //初始化播放器（开始播放）
    private void initplayer() {
        player.join(getApplicationContext(), initParam, this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
                int width = wm.getDefaultDisplay().getWidth();
                int height = wm.getDefaultDisplay().getHeight();
                float rawX = ev.getRawX();
                float rawY = ev.getRawY();
                float x = ev.getX();
                float y = ev.getY();
                if (rawX < width / 2) {
                    if (rawY < y) {
                        streamVolume++;
                        changeAudio(streamVolume);
                    } else {
                        streamVolume--;
                        changeAudio(streamVolume);
                    }
                } else {
                    if (rawY < y) {

                    } else {

                    }
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_SCROLL:

                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    //停止播放
    @Override
    protected void onStop() {
        if (STOPTAG == ZhiboChat.START_SELECT) {
            if (isPlayed) {
                pausePlay();
            }
        }
        super.onStop();
    }

    //重新开始
    @Override
    protected void onRestart() {
        if (isPlayed) {
            resume();
        }
        super.onRestart();
    }

    @Override
    public void onJoin(int result) {
        String msg = null;
        switch (result) {
            case JOIN_OK:
                msg = "加入成功";
                Message message = new Message();
                message.what = HANDlER.SUCCESSJOIN;
                mHandler.sendMessage(message);
                break;
            case JOIN_CONNECTING:
                msg = "正在加入";
                break;
            case JOIN_CONNECT_FAILED:
                msg = "连接失败";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                break;
            case JOIN_RTMP_FAILED:
                msg = "连接服务器失败";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                break;
            case JOIN_TOO_EARLY:
                msg = "直播还未开始";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                break;
            case JOIN_LICENSE:
                msg = "人数已满";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                break;
            default:
                msg = "加入返回错误" + result;
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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
        Message message = new Message();
        message.what = HANDlER.RECONNECTING;
        mHandler.sendMessage(message);
    }

    @Override
    public void onLeave(int i) {
        String msg = "";
        switch (i) {
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
        if (msg != null) {
            final String finalMsg = msg;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ZhiboActivity.this, finalMsg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void onCaching(boolean b) {
        Message msg = new Message();
        msg.what = b ? HANDlER.CACHING
                : HANDlER.CACHING_END;
        mHandler.sendMessage(msg);

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
                    Toast.makeText(ZhiboActivity.this, finalMsg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void onDocSwitch(int i, String s) {

    }

    @Override
    public void onVideoBegin() {

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

    //设置图标点击监听器
    public void initClickListener() {
        chat_img.setOnClickListener(this);
        jianjie_img.setOnClickListener(this);
        video_img.setOnClickListener(this);
        chat_txt.setOnClickListener(this);
        jianjie_txt.setOnClickListener(this);
        video_txt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chat_txt:
            case R.id.chat_img:
                setSelect(0);
                break;
            case R.id.intro_txt:
            case R.id.intro_img:
                setSelect(1);
                break;
            case R.id.video_txt:
            case R.id.video_img:
                setSelect(2);
                break;
        }
    }

    //设置将点击的那个图标为亮色,切换内容区域
    public void setSelect(int i) {
        initTabImage();
        switch (i) {
            case 0:
                chat_txt.setTextColor(Color.RED);
                chat_img.setImageResource(R.mipmap.ic_broadcastroom_chat_pressed);
                break;
            case 1:
                jianjie_txt.setTextColor(Color.RED);
                jianjie_img.setImageResource(R.mipmap.ic_broadcastroom_intro_pressed);
                break;
            case 2:
                video_txt.setTextColor(Color.RED);
                video_img.setImageResource(R.mipmap.ic_broadcastroom_video_pressed);
                break;
            default:
                break;
        }
        zhibo_viewpager.setCurrentItem(i);
    }

    private class ZhiboVPAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList;

        public ZhiboVPAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    //ViewPager的PageChangeListener(页面改变的监听器)
    private class ZhiboOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //滑动时改变图片状态
        @Override
        public void onPageSelected(int position) {
            int currentItem = zhibo_viewpager.getCurrentItem();
            initTabImage();
            switch (currentItem) {
                case 0:
                    chat_txt.setTextColor(Color.RED);
                    chat_img.setImageResource(R.mipmap.ic_broadcastroom_chat_pressed);
                    break;
                case 1:
                    jianjie_txt.setTextColor(Color.RED);
                    jianjie_img.setImageResource(R.mipmap.ic_broadcastroom_intro_pressed);
                    break;
                case 2:
                    video_txt.setTextColor(Color.RED);
                    video_img.setImageResource(R.mipmap.ic_broadcastroom_video_pressed);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    //初始的图标状态(滑动和点击事件改变的时候都要初始化)
    private void initTabImage() {
        chat_txt.setTextColor(Color.DKGRAY);
        jianjie_txt.setTextColor(Color.DKGRAY);
        video_txt.setTextColor(Color.DKGRAY);
        chat_img.setImageResource(R.mipmap.ic_broadcastroom_chat_default);
        jianjie_img.setImageResource(R.mipmap.ic_broadcastroom_intro_default);
        video_img.setImageResource(R.mipmap.ic_broadcastroom_video_default);
    }

    private boolean checkWifi() {
        boolean isWifiConnect = true;
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        //[java]view plain copy print ?
        //check the networkInfos numbers
        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();
        for (int i = 0; i < networkInfos.length; i++) {
            if (networkInfos[i].getState() == NetworkInfo.State.CONNECTED) {
                if (networkInfos[i].getType() == cm.TYPE_MOBILE) {
                    DialogUtils.createAlertDialog(this, null, "当前使用非wifi，继续使用将会产生流量\n是否继续", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    isWifiConnect = false;
                }
                if (networkInfos[i].getType() == cm.TYPE_WIFI) {
                    isWifiConnect = true;
                }
            }
        }
        return isWifiConnect;
    }
}
