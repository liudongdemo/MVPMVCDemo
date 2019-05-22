package com.ld.mvp.contract;

import com.ld.mvc.callback.Callback1;
import com.ld.mvc.model.UserInfo;
import com.ld.mvp.presenter.BasePresenter;
import com.ld.mvp.view.BaseView;

import java.util.UUID;

public class SampleContract {

    public static class Presenter implements BasePresenter{
        public void getUserInfo(String uid, Callback1<UserInfo> callback){
            UserInfo userInfo = new UserInfo(UUID.randomUUID().toString(),13,"刘流动冬");
            callback.onCallBack(userInfo);
        }
        @Override
        public void onDestroy() {

        }
    }

    public interface View extends BaseView<Presenter>{
        void setDataToView(UserInfo userInfo);
    }
}
