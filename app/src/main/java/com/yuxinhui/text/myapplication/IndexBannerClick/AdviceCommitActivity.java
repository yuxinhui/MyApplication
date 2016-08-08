package com.yuxinhui.text.myapplication.IndexBannerClick;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.DialogUtils;

public class AdviceCommitActivity extends AppCompatActivity {
    ImageView mReturn;
    EditText metAdvice;
    ImageView mivFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_commit);
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdviceCommitActivity.this.finish();
            }
        });
        mivFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metAdvice.setText("");
                DialogUtils.createAlertDialog(AdviceCommitActivity.this, "意见提交", "您的建议已经提交", null, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void initView() {
        mReturn = (ImageView) findViewById(R.id.iv_advice_back);
        metAdvice = (EditText) findViewById(R.id.et_advice);
        mivFinish = (ImageView) findViewById(R.id.iv_finish);
    }


}
