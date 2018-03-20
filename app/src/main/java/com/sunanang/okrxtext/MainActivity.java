package com.sunanang.okrxtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sunanang.okrxtext.bean.GsonBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateDate();
    }

    private void updateDate() {
//        srlJoke.setRefreshing(true);    // 让SwipeRefreshLayout开启刷新
        QClitent.getInstance()
                .create(QNewsService.class) // 创建服务
                .getCurrentJokeData(1, 8)   // 查询
                .subscribeOn(Schedulers.io())   //  指定被观察者的操作在io线程中完成
                .observeOn(AndroidSchedulers.mainThread())  // 指定观察者接收到数据，然后在Main线程中完成
                .subscribe(new Consumer<GsonBean>() {
                    @Override
                    public void accept(GsonBean jokeBean) throws Exception {
                        // 成功获取数据
//                        mAdapter.setNewData(jokeBean.getResult().getData());    // 给适配器设置数据
//                        srlJoke.setRefreshing(false);       // 让SwipeRefreshLayout关闭刷新
                        Toast.makeText(MainActivity.this, "获取数据成功", Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // 获取数据失败
                        Toast.makeText(MainActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
//                        srlJoke.setRefreshing(false);
                    }
                });
    }

}
