/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lzy.demo.okrx2;

import android.os.Bundle;
import android.view.View;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseRxDetailActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class RxCommonActivity extends BaseRxDetailActivity {

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_rx_common);
        ButterKnife.bind(this);
        setTitle("OkRx基本请求");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        dispose();
    }

    @OnClick(R.id.commonRequest)
    public void commonRequest(View view) {

    }

    @OnClick(R.id.jsonRequest)
    public void jsonRequest(View view) {

    }

    @OnClick(R.id.jsonArrayRequest)
    public void jsonArrayRequest(View view) {

    }

    @OnClick(R.id.upString)
    public void upString(View view) {

    }

    @OnClick(R.id.upJson)
    public void upJson(View view) {

    }
}
