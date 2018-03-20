package com.sunanang.okrxtext;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sunanang.okrxtext.utils.URLUtils;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ${Sunanang} on 2018/3/20.
 */

public class QClitent {
    private static QClitent mQClient;
    private Retrofit mRetrofit;

    private QClitent(){
        mRetrofit = createRetrofit();
    }

    public static QClitent getInstance() {
        if (mQClient == null){
            synchronized (QClitent.class){
                if (mQClient == null){
                    mQClient = new QClitent();
                }
            }
        }
        return mQClient;
    }
    /**
     * 创建相应的服务接口
     */
    public <T> T create(Class<T> service){
        checkNotNull(service, "service is null");
        return mRetrofit.create(service);
    }
    /**
     * 直接创建 QNewsService
     */
    public QNewsService createQNewsService(){
        return mRetrofit.create(QNewsService.class);
    }

    private  <T> T checkNotNull(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }

    private Retrofit createRetrofit() {
        //初始化OkHttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(9, TimeUnit.SECONDS)    //设置连接超时 9s
                .readTimeout(10, TimeUnit.SECONDS);      //设置读取超时 10s

        if (BuildConfig.DEBUG) { // 判断是否为debug
            // 如果为 debug 模式，则添加日志拦截器
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        // 返回 Retrofit 对象
        return new Retrofit.Builder()
                .baseUrl(URLUtils.DATA_URL)
                .client(builder.build()) // 传入请求客户端
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换工厂
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加RxJava2调用适配工厂
                .build();

    }




}
