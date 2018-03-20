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
     *
     *
     *
     * 注解	                    请求方式	                        用途
     * @Path	                      GET	            用于替换Url路径中的变量字符
     * @Query	                      GET	            用于拼接在Url路径后的查询参数，但相对于直接在Url后拼接，@Query则是添加一个变量
     * @QueryMap	                  GET	            效果等同于多个@Query 参数为Map类型
     * @FormUrlEncoded/@Field	      POST	            @FormUrlEncoded修饰表单域，每个表单域子件key-value采用@Field修饰
     * @Body	                      POST	            可以指定一个对象作为HTTP请求体@Body
     * @FormUrlEncoded/@Field	      PUT	            @FormUrlEncoded修饰表单域，每个表单域子件key-value采用@Field修饰
     * @HTTP/@Body	             DELETE	            @HTTP修饰表单域，以指定一个对象作为HTTP请求体@Body，此时表单域一定要写上hasBody = true
     * @Multipart/@Part或者@PartMap POST	            文件上传使用，@Multipart修饰表单域，参数@Part修饰或者参数使用@PartMap
     * 具体参考http://blog.csdn.net/f917386389/article/details/76461231
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
