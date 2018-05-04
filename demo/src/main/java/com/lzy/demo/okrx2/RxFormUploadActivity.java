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

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.demo.R;
import com.lzy.demo.base.BaseRxDetailActivity;
import com.lzy.demo.ui.NumberProgressBar;
import com.lzy.demo.utils.GlideImageLoader;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
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
public class RxFormUploadActivity extends BaseRxDetailActivity {

    @Bind(R.id.formUpload1)
    Button btnFormUpload1;
    @Bind(R.id.formUpload2)
    Button btnFormUpload2;
    @Bind(R.id.downloadSize)
    TextView tvDownloadSize;
    @Bind(R.id.tvProgress)
    TextView tvProgress;
    @Bind(R.id.netSpeed)
    TextView tvNetSpeed;
    @Bind(R.id.pbProgress)
    NumberProgressBar pbProgress;
    @Bind(R.id.images)
    TextView tvImages;

    private List<ImageItem> imageItems;
    private NumberFormat numberFormat;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_rx_form_upload);
        ButterKnife.bind(this);
        setTitle("文件上传");

        numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMinimumFractionDigits(2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        dispose();
    }

    @OnClick(R.id.selectImage)
    public void selectImage(View view) {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());
        imagePicker.setMultiMode(true);   //多选
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setSelectLimit(9);    //最多选择9张
        imagePicker.setCrop(false);       //不进行裁剪
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == 100) {
                //noinspection unchecked
                imageItems = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                if (imageItems != null && imageItems.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < imageItems.size(); i++) {
                        if (i == imageItems.size() - 1) sb.append("图片").append(i + 1).append(" ： ").append(imageItems.get(i).path);
                        else sb.append("图片").append(i + 1).append(" ： ").append(imageItems.get(i).path).append("\n");
                    }
                    tvImages.setText(sb.toString());
                } else {
                    tvImages.setText("--");
                }
            } else {
                Toast.makeText(this, "没有选择图片", Toast.LENGTH_SHORT).show();
                tvImages.setText("--");
            }
        }
    }

    @OnClick(R.id.formUpload1)
    public void formUpload1(View view) {

    }

    @OnClick(R.id.formUpload2)
    public void formUpload2(View view) {

    }
}
