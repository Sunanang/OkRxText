package com.sunanang.okrxtext.bean;

/**
 * Created by ${Sunanang} on 2018/3/20.
 */

public class DataBean {
    /*
    content: "老板特别喜欢吃榴莲，但我是那种闻到榴莲味就想吐的。。。 今天老板在办公室吃榴莲，我送报告进去给他签字，出来后感觉胃里很难受，总想吐。 然后同事看到后问我为什么想吐，我很不耐烦的怼了一句，问老板去 ~ 老板娘，事情的经过就是这样的！！！",
hashId: "2386e933254d321b8cedd2fbdd0c26b9",
unixtime: 1521510900,
updatetime: "2018-03-20 09:55:00"
     */

    public String content;
    public String hashId;
    public long unixtime;
    public String updatetime;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(long unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
