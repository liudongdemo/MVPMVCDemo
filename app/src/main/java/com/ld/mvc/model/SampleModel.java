package com.ld.mvc.model;

import com.ld.mvc.callback.Callback1;

import java.util.UUID;

public class SampleModel implements BaseModel {
    public void getUserInfo(String uid, Callback1<UserInfo> callback){
        UserInfo userInfo = new UserInfo(UUID.randomUUID().toString(),13,"刘冬");
        callback.onCallBack(userInfo);
    }
    @Override
    public void onDestroy() {

    }
}
