package com.yzz.ezhttp.service;

import com.yzz.ezhttplib.util.upload.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by yzz on 2017/8/18.
 */

public interface UploadService {

    /**
     * 通过 List<MultipartBody.Part> 传入多个part实现多文件上传
     * @param parts 每个part代表一个
     * @return 状态信息
     */
    @Multipart
    @POST("file/upload")
    Observable<BaseResponse<String>> uploadFilesWithParts(@Part() List<MultipartBody.Part> parts);


    /**
     * 通过 MultipartBody和@body作为参数来上传
     * @param multipartBody MultipartBody包含多个Part
     * @return 状态信息
     */
    @Multipart
    @POST("file/upload")
    Observable<BaseResponse<String>> uploadFileWithRequestBody(@Body MultipartBody multipartBody);

}
