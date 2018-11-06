package top.chenwanpeng.utils;

import java.io.*;

import org.junit.Test;

import top.chenwanpeng.entity.Code;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;

/**
 * 模拟控制工具类
 * 
 * cwp 20180123
 */
public class ImitateOperateUtiles {

    /**
     * 控制
     * 
     * @throws Exception
     */
    @Test
    public void runTest() throws Exception {

        Robot r = new Robot();

        // 打开记事本,输入已经运行完毕
        // windowMax(r);
        // keyPressInString(r, "over", 20);
        // System.out.println("操作运行完毕!");

    }

    public ImitateOperateUtiles() {
    }

    /**
     * 生成代码
     * 
     * @throws Exception
     */
    public static void generateCode(Code code) throws Exception {
        Robot r = new Robot();
        runToPath("E:\\develop\\e_CodeUtil_V2.4_64\\code_util64.exe");
        r.delay(1500);
        keyPress(r, KeyEvent.VK_DOWN);
        r.delay(200);
        keyPressAndEnter(r, KeyEvent.VK_DOWN);
        r.delay(200);
        // 两个下然后回车
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        // 两下tab
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressString(r, code.getUserName());
        r.delay(200);
        // 用户名
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        // tab
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressString(r, code.getPassword());
        r.delay(200);
        // 密码
        r.mouseMove(800, 670);
        r.delay(200);
        mouseMoveAndClick(r, 800, 670);
        r.delay(200);
        mouseMoveAndClick(r, 800, 680);
        r.delay(200);
        mouseMoveAndClick(r, 800, 690);
        r.delay(1000);
        keyPress(r, KeyEvent.VK_ENTER);
        r.delay(200);
        // 鼠标移动点击测试连接
        keyPressWithShift(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPressWithShift(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPressInString(r, code.getDatabaseName(), 200);
        r.delay(200);
        // 回退输入表名
        r.mouseMove(1100, 670);
        r.delay(200);
        mouseMoveAndClick(r, 1100, 670);
        r.delay(1000);
        // 鼠标移动点击跳过
        keyPress(r, KeyEvent.VK_DOWN);
        r.delay(200);
        keyPress(r, KeyEvent.VK_DOWN);
        r.delay(200);
        keyPressAndEnter(r, KeyEvent.VK_DOWN);
        r.delay(200);
        // 三个下然后回车
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressString(r, code.getSavePath());
        // 三个tab然后录入生成路径
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressString(r, code.getProjectName());
        r.delay(200);
        // 两个tab然后是项目名称
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressString(r, code.getPackageName());
        r.delay(200);
        // 一个tab然后是包名
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressString(r, code.getProjectNameCH());
        r.delay(200);
        // 一个tab项目中文名
        keyPress(r, KeyEvent.VK_TAB);
        r.delay(200);
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressString(r, code.getWriterName());
        r.delay(200);
        // 一个tab作者
        r.mouseMove(840, 820);
        r.delay(200);
        mouseMoveAndClick(r, 840, 820);
        // 鼠标移动点击生成代码
    }

    /**
     * 全选并复制
     * 
     * @throws Exception
     */
    public static void copyAll() throws Exception {
        Robot r = new Robot();
        // 全选并复制
        r.delay(200);
        mouseMoveAndClick(r, 600, 800);
        r.delay(200);
        keyPressWithCtrl(r, 65);
        r.delay(200);
        keyPressWithCtrl(r, 67);
        r.delay(200);
    }

    /**
     * 启动 一个项目并最小化
     * 
     * @throws Exception
     */
    public static void runProject(String projectName) throws Exception {
        Robot r = new Robot();
        runProjectOnly(r, projectName);
        keyPressWithWind(r, KeyEvent.VK_DOWN);// 最小化
        r.delay(500);
    }

    /**
     * 启动 一个项目
     * 
     * @throws Exception
     */
    public static void runProjectOnly(Robot r, String projectName) throws Exception {
        keyPressWithWind(r, 82);
        r.delay(100);
        keyPressString(r, projectName);
        r.delay(100);
        r.keyPress(KeyEvent.VK_ENTER); // 按下 enter
        r.keyRelease(KeyEvent.VK_ENTER); // 按下 enter
        r.delay(1000);
    }

    /**
     * 打开一个目录
     * 
     * @throws Exception
     */
    public static void runToPath(String pathName) throws Exception {

        Robot r = new Robot();
        r.delay(200);
        keyPressWithWind(r, 69);
        r.delay(1000);
        keyPress(r, 115);//F4
        r.delay(300);
        keyPressWithCtrl(r, 65);//全选
        r.delay(300);
        keyPressWithCtrl(r, 65);//全选
        keyPressString(r, pathName);// 粘贴路径
        r.delay(200);
        keyPress(r, KeyEvent.VK_ENTER);
        r.delay(500);
    }

    /**
     * 打开浏览器
     * 
     * @throws Exception
     */
    public static void runToChrome(String urlName) throws Exception {

        Robot r = new Robot();
        runProjectOnly(r, "Chrome");
        r.delay(200);
        keyPressWithCtrl(r, 65);//全选
        keyPressString(r, urlName);// 粘贴路径
        r.delay(200);
        r.keyPress(KeyEvent.VK_ENTER); // 按下 enter
        r.keyRelease(KeyEvent.VK_ENTER); // 按下 enter
        r.delay(200);
        keyPressWithWind(r, KeyEvent.VK_UP);
        r.delay(200);
    }

    // 当前窗口最小化，先按Alt+空格，然后按N
    public static void WindowMin(Robot r) {
        keyPressWithAlt(r, 32);
        r.delay(100);
        r.keyPress(78);
        r.keyRelease(78);
        r.delay(100);
    }

    // 打开记事本,并且窗口最大化
    public static void windowMax(Robot robot) {
        try {
            Runtime.getRuntime().exec("notepad");
            robot.delay(1000); // 等待 1秒
            // keyPressWithAlt(robot, KeyEvent.VK_SPACE); // 按下 alt+ 空格
        } catch (IOException e) {
            e.printStackTrace();
        } // 打开一个记事本程序

    }

    // 模拟按下按键
    public static void keydownAChar(Robot r, char ch) {
        try {
            r.keyPress(KeyEvent.VK_CONTROL);// 按下左Contrl keycode为17
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_ESCAPE);
            r.keyRelease(KeyEvent.VK_ESCAPE);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_CONTROL);// 释放左Control键
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 模拟鼠标移动,并且单击
    public static void mouseMoveAndClick(Robot r, int x, int y) {
        try {
            r = new Robot();
            r.mouseMove(x, y);// 将鼠标移至屏幕坐标(288,15)
            r.delay(150);// 停留150ms
            r.mousePress(InputEvent.BUTTON1_MASK);// 按下鼠标左键
            r.delay(100);
            r.mouseRelease(InputEvent.BUTTON1_MASK);// 松开左键
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // 模拟鼠标移动,并且双击
    public static void mouseMoveAndDbclick(Robot r, int x, int y) {

        try {
            r = new Robot();
            r.mouseMove(x, y);// 将鼠标移至屏幕坐标(288,15)
            r.delay(150);// 停留150ms
            r.mousePress(InputEvent.BUTTON1_MASK);// 按下鼠标左键
            r.delay(100);
            r.mouseRelease(InputEvent.BUTTON1_MASK);// 松开左键
            r.delay(100);
            r.mousePress(InputEvent.BUTTON1_MASK);// 按下鼠标左键
            r.delay(100);
            r.mouseRelease(InputEvent.BUTTON1_MASK);// 松开左键
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // shift+ 按键

    public static void keyPressWithShift(Robot r, int key) {
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.delay(100);
    }

    // ctrl+ 按键
    public static void keyPressWithCtrl(Robot r, int key) {
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.delay(100);
    }

    // alt+ 按键
    public static void keyPressWithAlt(Robot r, int key) {
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_ALT);
        r.delay(100);
    }

    // wind+ 按键
    public static void keyPressWithWind(Robot r, int key) {
        r.keyPress(KeyEvent.VK_WINDOWS);
        r.keyPress(key);
        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_WINDOWS);
        r.delay(100);
    }

    // 打印出字符串,剪切板原理
    public static void keyPressString(Robot r, String str) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();// 获取剪切板
        Transferable tText = new StringSelection(str);
        clip.setContents(tText, null); // 设置剪切板内容
        keyPressWithCtrl(r, KeyEvent.VK_V);// 粘贴
        r.delay(100);
    }

    // 单个 按键
    public static void keyPress(Robot r, int key) {
        r.keyPress(key);
        r.keyRelease(key);
        r.delay(100);
    }

    // 单个 按键+回车
    public static void keyPressAndEnter(Robot r, int key) {
        r.keyPress(key);
        r.keyRelease(key);
        r.delay(100);
        r.keyPress(KeyEvent.VK_ENTER); // 按下 enter
        r.keyRelease(KeyEvent.VK_ENTER); // 按下 enter
        r.delay(100);
    }

    // 按键模拟输入字符串
    public static void keyPressInString(Robot r, String str, int speed) {

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            int num = ch;// 字符转化成数字
            System.out.println(str.charAt(i) + "  " + num);
            try {
                if (ch >= 'a' && ch <= 'z') {
                    num = num - 32;
                    // keyPressAndEnter(r, num);
                    keyPress(r, num);
                } else if (ch >= 'A' && ch <= 'Z') {
                    keyPressWithShift(r, num);
                } else if (ch >= '0' && ch <= '9') {
                    // keyPressAndEnter(r, num);
                    keyPress(r, num);
                } else {
                    switch (ch) {
                    case '{':
                    case '}':
                        keyPressWithShift(r, num - 32);
                        break;
                    case '[':
                    case ']':
                        keyPressAndEnter(r, num - 32);
                        break;
                    case '(':
                    case ')':
                        keyPressWithShift(r, num + 17);
                        break;
                    default:
                        keyPressAndEnter(r, num);
                        break;
                    }
                }
            } catch (Exception e) {
                keyPressAndEnter(r, 46);// 如果字符为汉字或者其他,就空格
            }
            r.delay(speed);
        }

    }

    // 按键常量(KeyEvent量)
    //
    // VK_HOME Home键 VK_CONTROL 控制键
    // VK_END End键 VK_SHIFT shift键
    // VK_PGUP page up键 VK_BACK_SPACE 退格键
    // VK_PGDN page down键 VK_CAPS_LOCK 大小写锁定键
    // VK_UP 上箭头 VK_NUM_LOCK 小键盘锁定键
    // VK_DOWN 下箭头 VK_ENTER 回车键
    // VK_LEFT 左箭头 VK_UNDEFINED 未知键
    // VK_RIGHT 右箭头 VK_F1--VK_F12 F1 -- F12
    // VK_ESCAPE Esc键 VK_0 --VK_9 0 --- 9
    // VK_TAB Tab键 VK_A --VK_Z A----Z
    //
    //
    // event.keyCode键值表
    // keycode 0 =
    // keycode 1 =
    // keycode 2 =
    // keycode 3 =
    // keycode 4 =
    // keycode 5 =
    // keycode 6 =
    // keycode 7 =
    // keycode 8 = BackSpace BackSpace
    // keycode 9 = Tab Tab
    // keycode 10 =
    // keycode 11 =
    // keycode 12 = Clear
    // keycode 13 = Enter
    // keycode 14 =
    // keycode 15 =
    // keycode 16 = Shift_L
    // keycode 17 = Control_L
    // keycode 18 = Alt_L
    // keycode 19 = Pause
    // keycode 20 = Caps_Lock
    // keycode 21 =
    // keycode 22 =
    // keycode 23 =
    // keycode 24 =
    // keycode 25 =
    // keycode 26 =
    // keycode 27 = Escape Escape
    // keycode 28 =
    // keycode 29 =
    // keycode 30 =
    // keycode 31 =
    // keycode 32 = space space
    // keycode 33 = Prior
    // keycode 34 = Next
    // keycode 35 = End
    // keycode 36 = Home
    // keycode 37 = Left
    // keycode 38 = Up
    // keycode 39 = Right
    // keycode 40 = Down
    // keycode 41 = Select
    // keycode 42 = Print
    // keycode 43 = Execute
    // keycode 44 =
    // keycode 45 = Insert
    // keycode 46 = Delete
    // keycode 47 = Help
    // keycode 48 = 0 equal braceright
    // keycode 49 = 1 exclam onesuperior
    // keycode 50 = 2 quotedbl twosuperior
    // keycode 51 = 3 section threesuperior
    // keycode 52 = 4 dollar
    // keycode 53 = 5 percent
    // keycode 54 = 6 ampersand
    // keycode 55 = 7 slash braceleft
    // keycode 56 = 8 parenleft bracketleft
    // keycode 57 = 9 parenright bracketright
    // keycode 58 =
    // keycode 59 =
    // keycode 60 =
    // keycode 61 =
    // keycode 62 =
    // keycode 63 =
    // keycode 64 =
    // keycode 65 = a A
    // keycode 66 = b B
    // keycode 67 = c C
    // keycode 68 = d D
    // keycode 69 = e E EuroSign
    // keycode 70 = f F
    // keycode 71 = g G
    // keycode 72 = h H
    // keycode 73 = i I
    // keycode 74 = j J
    // keycode 75 = k K
    // keycode 76 = l L
    // keycode 77 = m M mu
    // keycode 78 = n N
    // keycode 79 = o O
    // keycode 80 = p P
    // keycode 81 = q Q at
    // keycode 82 = r R
    // keycode 83 = s S
    // keycode 84 = t T
    // keycode 85 = u U
    // keycode 86 = v V
    // keycode 87 = w W
    // keycode 88 = x X
    // keycode 89 = y Y
    // keycode 90 = z Z
    // keycode 91 =
    // keycode 92 =
    // keycode 93 =
    // keycode 94 =
    // keycode 95 =
    // keycode 96 = KP_0 KP_0
    // keycode 97 = KP_1 KP_1
    // keycode 98 = KP_2 KP_2
    // keycode 99 = KP_3 KP_3
    // keycode 100 = KP_4 KP_4
    // keycode 101 = KP_5 KP_5
    // keycode 102 = KP_6 KP_6
    // keycode 103 = KP_7 KP_7
    // keycode 104 = KP_8 KP_8
    // keycode 105 = KP_9 KP_9
    // keycode 106 = KP_Multiply KP_Multiply
    // keycode 107 = KP_Add KP_Add
    // keycode 108 = KP_Separator KP_Separator
    // keycode 109 = KP_Subtract KP_Subtract
    // keycode 110 = KP_Decimal KP_Decimal
    // keycode 111 = KP_Divide KP_Divide
    // keycode 112 = F1
    // keycode 113 = F2
    // keycode 114 = F3
    // keycode 115 = F4
    // keycode 116 = F5
    // keycode 117 = F6
    // keycode 118 = F7
    // keycode 119 = F8
    // keycode 120 = F9
    // keycode 121 = F10
    // keycode 122 = F11
    // keycode 123 = F12
    // keycode 124 = F13
    // keycode 125 = F14
    // keycode 126 = F15
    // keycode 127 = F16
    // keycode 128 = F17
    // keycode 129 = F18
    // keycode 130 = F19
    // keycode 131 = F20
    // keycode 132 = F21
    // keycode 133 = F22
    // keycode 134 = F23
    // keycode 135 = F24
    // keycode 136 = Num_Lock
    // keycode 137 = Scroll_Lock
    // keycode 138 =
    // keycode 139 =
    // keycode 140 =
    // keycode 141 =
    // keycode 142 =
    // keycode 143 =
    // keycode 144 =
    // keycode 145 =
    // keycode 146 =
    // keycode 147 =
    // keycode 148 =
    // keycode 149 =
    // keycode 150 =
    // keycode 151 =
    // keycode 152 =
    // keycode 153 =
    // keycode 154 =
    // keycode 155 =
    // keycode 156 =
    // keycode 157 =
    // keycode 158 =
    // keycode 159 =
    // keycode 160 =
    // keycode 161 =
    // keycode 162 =
    // keycode 163 =
    // keycode 164 =
    // keycode 165 =
    // keycode 166 =
    // keycode 167 =
    // keycode 168 =
    // keycode 169 =
    // keycode 170 =
    // keycode 171 =
    // keycode 172 =
    // keycode 173 =
    // keycode 174 =
    // keycode 175 =
    // keycode 176 =
    // keycode 177 =
    // keycode 178 =
    // keycode 179 =
    // keycode 180 =
    // keycode 181 =
    // keycode 182 =
    // keycode 183 =
    // keycode 184 =
    // keycode 185 =
    // keycode 186 =
    // keycode 187 = acute grave
    // keycode 188 = comma semicolon
    // keycode 189 = minus underscore
    // keycode 190 = period colon
    // keycode 191 =
    // keycode 192 = numbersign apostrophe
    // keycode 193 =
    // keycode 194 =
    // keycode 195 =
    // keycode 196 =
    // keycode 197 =
    // keycode 198 =
    // keycode 199 =
    // keycode 200 =
    // keycode 201 =
    // keycode 202 =
    // keycode 203 =
    // keycode 204 =
    // keycode 205 =
    // keycode 206 =
    // keycode 207 =
    // keycode 208 =
    // keycode 209 =
    // keycode 210 = plusminus hyphen macron
    // keycode 211 =
    // keycode 212 = copyright registered
    // keycode 213 = guillemotleft guillemotright
    // keycode 214 = masculine ordfeminine
    // keycode 215 = ae AE
    // keycode 216 = cent yen
    // keycode 217 = questiondown exclamdown
    // keycode 218 = onequarter onehalf threequarters
    // keycode 219 =
    // keycode 220 = less greater bar
    // keycode 221 = plus asterisk asciitilde
    // keycode 222 =
    // keycode 223 =
    // keycode 224 =
    // keycode 225 =
    // keycode 226 =
    // keycode 227 = multiply division
    // keycode 228 = acircumflex Acircumflex
    // keycode 229 = ecircumflex Ecircumflex
    // keycode 230 = icircumflex Icircumflex
    // keycode 231 = ocircumflex Ocircumflex
    // keycode 232 = ucircumflex Ucircumflex
    // keycode 233 = ntilde Ntilde
    // keycode 234 = yacute Yacute
    // keycode 235 = oslash Ooblique
    // keycode 236 = aring Aring
    // keycode 237 = ccedilla Ccedilla
    // keycode 238 = thorn THORN
    // keycode 239 = eth ETH
    // keycode 240 = diaeresis cedilla currency
    // keycode 241 = agrave Agrave atilde Atilde
    // keycode 242 = egrave Egrave
    // keycode 243 = igrave Igrave
    // keycode 244 = ograve Ograve otilde Otilde
    // keycode 245 = ugrave Ugrave
    // keycode 246 = adiaeresis Adiaeresis
    // keycode 247 = ediaeresis Ediaeresis
    // keycode 248 = idiaeresis Idiaeresis
    // keycode 249 = odiaeresis Odiaeresis
    // keycode 250 = udiaeresis Udiaeresis
    // keycode 251 = ssharp question backslash
    // keycode 252 = asciicircum degree
    // keycode 253 = 3 sterling
    // keycode 254 = Mode_switch
}
