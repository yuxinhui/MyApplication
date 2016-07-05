package com.yuxinhui.text.myapplication.Utils;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/5.
 */

public class VerCodeTImer extends CountDownTimer {
    private int seconds;
    private int interval;
    private TextView tv;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public VerCodeTImer(long millisInFuture, long countDownInterval,TextView tv) {
        super(millisInFuture, countDownInterval);
        seconds = (int) (millisInFuture/1000);
        interval = (int) (countDownInterval / 1000);
        this.tv = tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tv.setClickable(false);
        tv.setText((millisUntilFinished/1000)+"秒后重试");

    }

    @Override
    public void onFinish() {
            tv.setText("重新获取验证码");
            tv.setClickable(true);
    }

}
