
package top.chenwanpeng.scheduledTask;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import top.chenwanpeng.utils.ImitateOperateUtiles;
import top.chenwanpeng.utils.TTSUtils;
 
/**
 * CWP
 * Date 2018/11/2
 * Description:定时任务
 */
@Component
public class ScheduledTask {
    private final Logger logger = LoggerFactory.getLogger(getClass());
 
    /**
     * 每间隔一段时间执行
     * @throws Exception 
     */
    @Scheduled(fixedRate = 10000)
    public void runByTime() throws Exception{
        
        //TTSUtils.readStringsIntoList("name.txt");
        logger.info("runByTime，现在时间："+System.currentTimeMillis());
 
    }
    
    /**
     * 规定时间执行
     */
//    @Scheduled(cron="0 37 15 * * *")
//    public void logByCron(){
//        
//        logger.info("logByCron，现在时间："+System.currentTimeMillis());
// 
//    }
}