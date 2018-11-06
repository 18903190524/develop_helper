package top.chenwanpeng.activeMQ;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    
    @JmsListener(destination="cwptop_text")
    public void readMessage(String text){
        System.out.println("接收到消息："+text);
    }
    
    @JmsListener(destination="cwptop_map")
    public void readMap(Map map){
        System.out.println("接收到消息："+map);        
    }
    
}