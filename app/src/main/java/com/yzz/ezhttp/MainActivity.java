package com.yzz.ezhttp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yzz.ezhttp.service.TestService;
import com.yzz.ezhttplib.retrofit.RetrofitUtil;
import com.yzz.ezhttplib.retrofit.model.HttpResult;
import com.yzz.ezhttplib.rxutil.HttpObserver;
import com.yzz.ezhttplib.rxutil.RxUtil;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn_http, btn_download, btn_upload;

    private Map<String, String> params = new HashMap<>();
    private Map<String, String> params1 = new HashMap<>();
    private Map<String, String> params2 = new HashMap<>();
    private Map<String, String> params3 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        params.put("deviceId", "86157903495428");
        params.put("equipmentFlag", "2");
        params.put("pNn", "18984371787");
        params.put("pWd", "18d411085171fa228f7dde1fdfe39361");
        params.put("userNum", "18984371787");

        params1.put("equipmentId", "4FD8FED793F8FBE4E050A10A7E1C1CC7");
        params1.put("userNum", "18984371787");


        params2.put("equipmentId", "50C8BCB9A6C9C40DE050A10A7E1C3E5A");
        params2.put("userNum", "18984371787");

        params3.put("userNum","18984371787");
//  https://api.lookdoor.cn/func/hjapp/user/v1/login.json?&
// deviceId=86157903495428&
// equipmentFlag=2&
// pNn=18984371787&
// pWd=18d411085171fa228f7dde1fdfe39361&
// userNum=18984371787
        initUI();

    }


    private void initUI() {
        btn_http = (Button) findViewById(R.id.btn_http);
        btn_download = (Button) findViewById(R.id.btn_download);
        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_http.setOnClickListener(this);
        btn_download.setOnClickListener(this);
        btn_upload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_http:

                RetrofitUtil.getInstance()
                        .create(TestService.class)
                        .httppost("/func/hjapp/user/v1/login.json", params)
                        .compose(RxUtil.<HttpResult>defaultSchedulers())
                        .subscribe(new HttpObserver<HttpResult>() {
                            @Override
                            protected void onFailed(String message) {

                            }

                            @Override
                            protected void onSuccess(HttpResult response) {

                            }

                            @Override
                            public void onNext(HttpResult value) {
                                Toast.makeText(MainActivity.this, value.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

//               // https://api.lookdoor.cn/func/hjapp/user/v1/loginReturnValues.json?&userNum=18984371787
//                RetrofitUtil.getInstance()
//                        .create(TestService.class)
//                        .httppost("/func/hjapp/user/v1/loginReturnValues.json", params3)
//                        .compose(RxUtil.<HttpResult>defaultSchedulers())
//                        .subscribe(new HttpObserver<HttpResult>() {
//                            @Override
//                            protected void onFailed(String message) {
//
//                            }
//
//                            @Override
//                            protected void onSuccess(HttpResult response) {
//
//                            }
//
//                            @Override
//                            public void onNext(HttpResult value) {
//                                Toast.makeText(MainActivity.this, value.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        });

                break;
            case R.id.btn_download:
//                RetrofitUtil.getInstance()
//                        .create(DownloadService.class)
//                        .download("http://172.16.0.165:8080/download/test.apk")
//                        .compose(RxUtil.<ResponseBody>newThread())
//                        .subscribe(new DownloadObserver<ResponseBody>() {
//                            @Override
//                            protected void onFailed(String message) {
//
//                            }
//
//                            @Override
//                            protected void onSuccess(ResponseBody response) {
//
//                            }
//
//
//                        });
//https://api.lookdoor.cn/func/hjapp/house/v1/pushOpenDoorBySn.json?&
// equipmentId=4FD8FED793F8FBE4E050A10A7E1C1CC7&
// userNum=18984371787

                RetrofitUtil.getInstance()
                        .create(TestService.class)
                        .httppost("/func/hjapp/house/v1/pushOpenDoorBySn.json", params1)
                        .compose(RxUtil.<HttpResult>defaultSchedulers())
                        .subscribe(new HttpObserver<HttpResult>() {
                            @Override
                            protected void onFailed(String message) {

                            }

                            @Override
                            protected void onSuccess(HttpResult response) {

                            }

                            @Override
                            public void onNext(HttpResult value) {
                                Toast.makeText(MainActivity.this, value.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                break;
            case R.id.btn_upload:
//                List<File> mFileList = new ArrayList<>();
//                File file = new File(Environment.getExternalStorageDirectory() + "/1.jpg");
//                File file2 = new File(Environment.getExternalStorageDirectory().getPath() + "/2.jpg");
//                File file3 = new File(Environment.getExternalStorageDirectory().getPath() + "/3.jpg");
//                mFileList.add(file);
//                mFileList.add(file2);
//                mFileList.add(file3);
//
//                List<MultipartBody.Part> parts= NetUtil.filesToMultipartBodyParts(mFileList);
//                RetrofitUtil.getInstance()
//                        .create(UploadService.class)
//                        .uploadFilesWithParts(parts)
//                       .compose(RxUtil.<BaseResponse<String>>newThread())
//                        .subscribe(new UploadObserver<BaseResponse<String>>() {
//                            @Override
//                            protected void onFailed(String message) {
//
//                            }
//
//                            @Override
//                            protected void onSuccess(BaseResponse<String> response) {
//
//                            }
//
//                            @Override
//                            public void onNext(BaseResponse<String> value) {
//
//                            }
//                        });


//https://api.lookdoor.cn/func/hjapp/house/v1/pushOpenDoorBySn.json?&
// equipmentId=50C8BCB9A6C9C40DE050A10A7E1C3E5A&
// userNum=18984371787


                RetrofitUtil.getInstance()
                        .create(TestService.class)
                        .httppost("/func/hjapp/house/v1/pushOpenDoorBySn.json", params2)
                        .compose(RxUtil.<HttpResult>defaultSchedulers())
                        .subscribe(new HttpObserver<HttpResult>() {
                            @Override
                            protected void onFailed(String message) {

                            }

                            @Override
                            protected void onSuccess(HttpResult response) {

                            }

                            @Override
                            public void onNext(HttpResult value) {
                                Toast.makeText(MainActivity.this, value.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                break;
        }

    }
}
