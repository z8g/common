package net.zhaoxuyang.demo.rate;

import com.google.common.util.concurrent.RateLimiter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhaoxuyang
 */
public class GuavaTest {
    private static final Logger LOG = Logger.getLogger(GuavaTest.class.getName());
    public static void main(String[] args) {
        String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        RateLimiter limiter = RateLimiter.create(1.0); // 这里的1表示每秒允许处理的量为1个
        for (int i = 1; i <= 10; i++) {
            limiter.acquire();// 请求RateLimiter, 超过permits会被阻塞
            LOG.log(Level.INFO, "call: {0}", i);
        }
        String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        LOG.log(Level.INFO, "start time:{0}", start);
        LOG.log(Level.INFO, "end time:{0}", end);
    }
}
