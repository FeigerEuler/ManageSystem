package com.cau.managesystem.smsService;

import com.baidubce.http.ApiExplorerClient;
import com.baidubce.http.AppSigner;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.ApiExplorerRequest;
import com.baidubce.model.ApiExplorerResponse;

public class BaiduSmsService {

    public static void sendSmsNotify(String phoneNo,String content){

        String path = "http://gwgp-wtxhytukujk.n.bdcloudapi.com/chuangxinsms/dxjk";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.GET, path);
       // request.setCredentials("7e1b840366564db18ad27f80f4e98ced", "89d50ca4ccba4bbd90a827a6e615ed04");
        request.setCredentials("7e1b840366564db18ad27f80f4e98ced", "89d50ca4ccba4bbd90a827a6e615ed04");
        // 设置header参数
        request.addHeaderParameter("Content-Type", "application/json;charset=UTF-8");
        request.addHeaderParameter("X-Bce-Signature","AppCode/ed49161fcaef475d88da824ccde21418");

        request.addQueryParameter("content", content);
        request.addQueryParameter("mobile", phoneNo);

        ApiExplorerClient client = new ApiExplorerClient(new AppSigner());

        try {
            ApiExplorerResponse response = client.sendRequest(request);
            // 返回结果格式为Json字符串
            System.out.println(response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
