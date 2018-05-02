package com.common.utils;

import com.common.base.enums.DirectionTypeEnum;
import com.common.pojo.ContractRequest;
import com.common.pojo.request.IndividualRequest;
import com.common.pojo.request.UserRequest;

import java.io.File;
import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by linlipin on 18/3/3.
 */

public class HttpApiUtil {

    public static final MediaType MEDIA_TYPE_IMAGE
            = MediaType.parse("image/*; charset=utf-8");

    public static void uploadImage(File file, DirectionTypeEnum directionTypeEnum, Callback callback){
        RequestBody fileBody = RequestBody.create(MEDIA_TYPE_IMAGE, file);
//        String formdata = String.format("form-data; name=\"file\";filename=\"%s\"", file.getName());
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), fileBody)
                .build();
        OkHttpUtil.enqueuePost(String.format("/idimage/%s/upload", directionTypeEnum.name()),requestBody,callback);
    }

    public static void login(UserRequest userRequest, Callback callback){
        OkHttpUtil.enqueuePost("/login", GsonUtil.toJson(userRequest), callback);
    }

    //    注册
    public static void register(IndividualRequest individualRequest, Callback callback){
        OkHttpUtil.enqueuePost("/register/individual", GsonUtil.toJson(individualRequest), callback);
    }

    public static Response register(IndividualRequest individualRequest) throws IOException {
        return OkHttpUtil.executePost("/register/individual", GsonUtil.toJson(individualRequest));
    }

    public static void getProductCode(String code, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/qr/code/%s/info", code), callback);
    }

//    新建合同
    public static void addSellContract(Long assistantId, ContractRequest contractRequest, Callback callback){
        OkHttpUtil.enqueuePost(String.format("/contract/employee/%d", assistantId), GsonUtil.toJson(contractRequest), callback);
    }

//    消费者签合同
    public static void customerSignContract(Long userId, String enc_cno, Callback callback){
        OkHttpUtil.enqueuePost(String.format("/contract/customer/%d/sign/%s",userId, enc_cno),
                "", callback);
    }

//  商品保真
    public static void verifyProductCode(Long contractId, String code, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/contract/%d/code/%s",contractId, code),
                "", callback);    }
    public static Response verifyProductCode(Long contractId, String code) throws IOException {
        return OkHttpUtil.executePut(String.format("/contract/%d/code/%s",contractId, code),
                "");    }

    public static void verifyEncProductCode(Long contractId, String enc_code, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/contract/%d/enccode/%s",contractId, enc_code), "", callback);    }
    public static Response verifyEncProductCode(Long contractId, String enc_code) throws IOException {
        return OkHttpUtil.executePut(String.format("/contract/%d/enccode/%s",contractId, enc_code), "");    }
//    消费者验真
    public static void productCodeVerify(String code, Long individualId, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/product/code/%s/individual/%d/verify", code, individualId), "", callback);
    }

    public static Response productCodeVerify(String code, Long individualId) throws IOException {
        return OkHttpUtil.executePut(String.format("/product/code/%s/individual/%d/verify", code, individualId),"");
    }

    public static void productEncCodeVerify(String enc_code, Long userId, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/product/enccode/%s/user/%d/verify", enc_code, userId),"", callback);
    }

    public static Response productEncCodeVerify(String enc_code, Long userId) throws IOException {
        return OkHttpUtil.executePut(String.format("/product/enccode/%s/user/%d/verify", enc_code, userId),"");
    }

//      获取合同列表 -> 通过contact
    public static void getContractsBySellerEmployee(Long employeeId, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/contract/seller/employee/%d", employeeId), callback);
    }

    public static void getContractsBySellerEmployee(Long employeeId, int page, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/contract/seller/employee/%d/page/%d", employeeId, page),
                callback);
    }

    public static void getContractsByIndividual(Long individualId, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/contract/individual/%d", individualId), callback);
    }

    public static void getContractsByIndividual(Long individualId, int page, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/contract/individual/%d/page/%d", individualId, page),
                callback);
    }

//    获取验证码
    public static void getVerifyCode(String mobilePhone, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/sms/mobilePhone/%s", mobilePhone), callback);
    }

    public static Response getVerifyCode(String mobilePhone) throws IOException {
        return OkHttpUtil.executeGet(String.format("/sms/mobilePhone/%s", mobilePhone));
    }

//    验证手机验证码
    public static void verifyCode(String telephone, String verifyCode, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/sms/mobilePhone/%s/code/%s",telephone, verifyCode),
                "", callback);
    }
    public static Response verifyCode(String telephone, String verifyCode) throws IOException {
        return OkHttpUtil.executePut(String.format("/sms/mobilePhone/%s/code/%s",telephone, verifyCode), "");
    }


}
