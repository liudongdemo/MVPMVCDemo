package com.ld.mvp.view;

import com.ld.mvp.presenter.BasePresenter;

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
