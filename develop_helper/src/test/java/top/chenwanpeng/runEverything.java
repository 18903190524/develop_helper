package top.chenwanpeng;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Test;

import top.chenwanpeng.entity.Code;
import top.chenwanpeng.utils.ImitateOperateUtiles;
import top.chenwanpeng.utils.TTSUtils;

public class runEverything {

    @Test
    public void runMain() throws Exception {

        // ======== develop services start ========
        // runProjects();
        // ======== open chrome ========
        // ----product----
        // ImitateOperateUtiles.runToChrome("https://jushispoc.com/#/home");
        // ImitateOperateUtiles.runToChrome("https://jushispoc.com/jsw-admin/login");
        // ----test----
        // ImitateOperateUtiles.runToChrome("https://jswcourse.com/#/home");
        // ImitateOperateUtiles.runToChrome("http://114.242.153.14:8080/swagger-ui.html#/");
        // ImitateOperateUtiles.runToChrome("https://jswcourse.com/jsw-admin/login");
        // ----develop----
        // ImitateOperateUtiles.runToChrome("http://localhost:9091/swagger-ui.html#/class-controller");
        // ImitateOperateUtiles.runToChrome("http://localhost:9092/jsw-admin/login");
        // ----personal page----
        // ImitateOperateUtiles.runToChrome("https://www.chenwanpeng.top/jpress/about");
        // ImitateOperateUtiles.runToChrome("https://fanyi.baidu.com/");
        // ImitateOperateUtiles.runToChrome("https://www.baidu.com/");
        // Jenkins
        // ImitateOperateUtiles.runToChrome("http://112.74.169.55:8888");
        // ======== connection server ========
        // ImitateOperateUtiles.runProject("xshell");
        // ImitateOperateUtiles.runProject("FileZilla");
        // ======== open content ========
        // ImitateOperateUtiles.runToPath("E:\\服务器备份");
        // ImitateOperateUtiles.runToPath("F:\\");
        // ImitateOperateUtiles.runToPath("G:\\测试用");
        // ImitateOperateUtiles.runToPath("G:\\05_Git版本控制");
        // ======== open file ========
        // ImitateOperateUtiles.runToPath("E:\\develop\\e_CodeUtil_V2.4_64\\code_util64.exe");
        // ImitateOperateUtiles.runToPath("G:\\05_Git版本控制\\04.教案\\git教案-v2.0.docx");
        // ======== copy file ========
        // ----product----
        // copyToPath("E:\\服务器备份\\配置\\3 生产配置\\product_provider");
        // copyToPath("E:\\服务器备份\\配置\\3 生产配置\\product_admin");
        // copyToPath("E:\\服务器备份\\配置\\3 生产配置\\product_pc");
        // ----test----
        // copyToPath("E:\\服务器备份\\配置\\2 测试配置\\provider");
        // ----develop----
        // copyToPath("E:\\服务器备份\\配置\\1 本地配置\\provider");
        // copyToPath("E:\\服务器备份\\配置\\1 本地配置\\admin");
        // copyToPath("E:\\服务器备份\\配置\\1 本地配置\\pc");
        // ======== generate code ========
        // generateCode(1, "generate");// 1 查看 2 执行 => 字符串为表名的前缀
    }

    /**
     * 启动 常用项目
     * 
     * @throws Exception
     */
    // @Test
    public void runProjects() throws Exception {

        ImitateOperateUtiles.runProject("zkServer");
        ImitateOperateUtiles.runProject("redis-server");
        ImitateOperateUtiles.runProject("rdm");
        ImitateOperateUtiles.runToPath("D:\\develop\\Navicat 12 for MySQL\\navicat.exe");

    }

    /**
     * 准备
     * 
     * @throws Exception
     */
    // @Test
    public void runBefore() throws Exception {
        Robot r = new Robot();
        ImitateOperateUtiles.keyPressWithWind(r, KeyEvent.VK_DOWN);// 最小化
        r.delay(500);
        ImitateOperateUtiles.keyPressWithWind(r, KeyEvent.VK_DOWN);// 最小化
        r.delay(500);
    }

    /**
     * 打开常用目录
     * 
     * @throws Exception
     */
    // @Test
    public void runToPath() throws Exception {

        ImitateOperateUtiles.runToPath("F:\\linux常用脚本");

    }

    /**
     * 复制目录文件
     * 
     * @throws Exception
     */
    // @Test
    public void copyToPath(String pathStr) throws Exception {

        ImitateOperateUtiles.runToPath(pathStr);
        ImitateOperateUtiles.copyAll();

    }

    /**
     * 生成code(慎用)
     * 
     * @throws Exception
     */
    // @Test
    public void generateCode(int flag, String tableName) throws Exception {

        // 查看之前生成的代码有没有删除
        ImitateOperateUtiles.runToPath("D:\\temp_code");

        if (flag == 2) {
            // 生成代码
            Code code = new Code();
            code.setUserName("root");
            code.setPassword("root");
            code.setSavePath("D:\\temp_code");
            code.setProjectName("jushiwang");
            code.setPackageName("com.jsw.all");
            code.setProjectNameCH("聚师网");
            code.setWriterName("Benjamin");
            // code.setDatabaseName("jsw-spoc");//前缀
            code.setDatabaseName(tableName);// 前缀
            ImitateOperateUtiles.generateCode(code);
        }

    }

    /**
     * 生成语音文件(没有安装TTS不能用)
     * 
     * @throws Exception
     */
    // @Test
    public void runSaveSpeakFile() throws Exception {

        TTSUtils.readStringsIntoList("name.txt");

    }

}
