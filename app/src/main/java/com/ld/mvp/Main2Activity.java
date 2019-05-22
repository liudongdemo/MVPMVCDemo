package com.ld.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ld.mvc.callback.Callback1;
import com.ld.mvc.model.UserInfo;
import com.ld.mvp.contract.SampleContract;

public class Main2Activity extends AppCompatActivity implements SampleContract.View {
    private SampleContract.Presenter mPresenter;
    private Button mButton;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new SampleContract.Presenter());
        mButton = findViewById(R.id.button);
        mTextView1 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mTextView3 = findViewById(R.id.textView4);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getUserInfo(mTextView3.getText().toString(), new Callback1<UserInfo>() {
                    @Override
                    public void onCallBack(UserInfo userInfo) {
                        setDataToView(userInfo);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void setDataToView(UserInfo userInfo) {
        mTextView2.setText(userInfo.getName());
        mTextView3.setText(userInfo.getUid());
        mTextView1.setText(userInfo.getAge()+"");
        Toast.makeText(Main2Activity.this,"成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(SampleContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
