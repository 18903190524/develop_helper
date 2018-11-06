package top.chenwanpeng.activeMQ;

import java.util.HashMap;
import java.util.Map;

import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.crypto.Data;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @RequestMapping("/sendtext")
    public String sendText(String text) throws Exception{
        jmsMessagingTemplate.convertAndSend("cwptop_text", text);
        return "已发送";
    }
    
    @RequestMapping("/sendmap")
    public String sendMap(){
        Map map=new HashMap<>();
        map.put("公司", "聚师网");
        map.put("地址", "汉威国际");       
        jmsMessagingTemplate.convertAndSend("cwptop_map",map);
        return "已发送";
    }

    // 访问 http://localhost:9003/sendtext?text=cwp
    // 访问 http://localhost:9003/sendmap

}