package com.sunanang.okrxtext;

import com.sunanang.okrxtext.bean.GsonBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by ${Sunanang} on 2018/3/20.
 */

public interface QNewsService {

    /**
     * @GET     get请求
     * @POST    post请求
     * @Query   拼接请求链接
     * @Url     请求链接完整地址，直接访问
     *
     * 具体参考  https://www.jianshu.com/p/15ccdacfd199
     */

    public static final String DESC = "desc"; // 指定时间之前发布的
    public static final String ASC = "asc";   // 指定时间之后发布的


    /**
     * 查询最新的段子数据
     *
     * @param page      查询的页数
     * @param pagesize  一页数据显示的条数
     * @return          查询结束返回的被观察者
     */
    //接口完整地址
    // http://japi.juhe.cn/joke/content/text.from?key=ae240f7fba620fc370b803566654949e
    @GET("text.from?key=ae240f7fba620fc370b803566654949e")
    Observable<GsonBean> getCurrentJokeData(
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );




    /**
     * 根据指定的时间，获取相关的段子数据
     *
     * @param time          要指定查询的时间
     * @param page          查询的页数
     * @param pagesize      一页数据显示的条数
     * @param sort          判断是在指定时间之前还是之后
     *                          {@value DESC 指定之前},{@value ASC 指定之后}
     * @return              查询结束返回的被观察者
     */
    //接口完整地址
    // http://japi.juhe.cn/joke/content/list.from?key=ae240f7fba620fc370b803566654949e&page=1&pagesize=5&sort=desc
    @GET("list.from?key=ae240f7fba620fc370b803566654949e")
    Observable<GsonBean> getAssignJokeData(
            @Query("time") long time,
            @Query("page") int page,
            @Query("pagesize") int pagesize,
            @Query("sort") String sort

    );

    @POST("ajax.mobileSword")
    Observable<String> login(@QueryMap HashMap<String,String> paramsMap);



}
