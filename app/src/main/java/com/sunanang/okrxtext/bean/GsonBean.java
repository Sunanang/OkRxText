package com.sunanang.okrxtext.bean;

import java.util.ArrayList;

/**
 * Created by ${Sunanang} on 2018/3/20.
 */

public class GsonBean {


    public String reason;
    public Result result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    class Result{
        public ArrayList<DataBean> data;

        public ArrayList<DataBean> getData() {
            return data;
        }

        public void setData(ArrayList<DataBean> data) {
            this.data = data;
        }
    }
}
