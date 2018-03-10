package cn.dq.www.guangchangan.server;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dugaolong on 17/8/17.
 * 定义一个接口，封装url地址和数据请求
 */

public interface RequestServices {

    //请求方式是get，
    @GET("userControl/login?choicename=ddd")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<String> login(@Query("userPhone") String userPhone, @Query("userpass") String userpass);

    //请求方式是get，
    @GET("userControl/registe?choicename=ddd")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<String> registe(@Query("username") String userName, @Query("userAge") String userAge,
                         @Query("userSchool") String userSchool,@Query("userPhone") String userPhone,
                         @Query("userpass") String userpass);

    //请求方式是get，
    @GET("userControl/updateName?choicename=ddd")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<String> updateName(@Query("username") String userName,@Query("userPhone") String userPhone);

    //请求方式是get，
    @GET("userControl/updatePass?choicename=ddd")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<String> updatePass(@Query("userpass") String userpass,@Query("userPhone") String userPhone);

    //请求方式是get，
    @GET("userControl/userInfo?choicename=ddd")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<String> userInfo(@Query("userPhone") String userPhone);

    //请求方式是get，
    @GET("userControl/checkVersion?choicename=ddd")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<String> checkVersion();

}
