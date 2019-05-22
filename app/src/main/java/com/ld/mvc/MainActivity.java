package com.ld.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ld.mvc.callback.Callback1;
import com.ld.mvc.model.SampleModel;
import com.ld.mvc.model.UserInfo;
import com.ld.mvp.R;

/**
 * 一酌清风孤傲酒，敢问世间谁人懂。
 * 满腹经纶诗常在，半世清醒半沉沦。
 */
public class MainActivity extends AppCompatActivity {
    private SampleModel mSampleModel;
    private Button mButton;
    private TextView mTextView1,mTextView2,mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView3 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mTextView1 = findViewById(R.id.textView4);
        mButton = findViewById(R.id.button);
        mSampleModel = new SampleModel();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfo(mTextView1.getText().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSampleModel.onDestroy();
    }
    
    private void getUserInfo(String uid){
        mSampleModel.getUserInfo(uid, new Callback1<UserInfo>() {
            @Override
            public void onCallBack(UserInfo userInfo) {
                setDataToView(userInfo);
            }
        });
    }

    private void setDataToView(UserInfo userInfo) {
        mTextView3.setText(userInfo.getAge()+"");
        mTextView2.setText(userInfo.getName());
        mTextView1.setText(userInfo.getUid());
        Toast.makeText(MainActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
    }
}
