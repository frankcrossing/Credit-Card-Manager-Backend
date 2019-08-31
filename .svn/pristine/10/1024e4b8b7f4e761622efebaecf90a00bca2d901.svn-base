package com.jieandata.web.config;

import com.p6spy.engine.spy.appender.SingleLineFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: pengke
 * @Date: 2019-2-11 10:48
 * @Description:
 */
public class P6LogFormat extends SingleLineFormat {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @Override
    public String formatMessage(int connectionId, String now,
                                    long elapsed, String category, String prepared, String sql) {
        if (!sql.trim().equals("")) {
            return format.format(new Date()) + " | took " + elapsed + "ms | "
                    + category + " | connection " + connectionId + "\n " + sql + ";";
        }
        return "";
    }
}
