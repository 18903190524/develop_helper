package top.chenwanpeng.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 语音合成工具包
 * 1 在java项目中实现语音读取的功能
 * 2 可生成语音文件,为web项目提供语音支持
 * @author 万鹏
 *
 */
public class TTSUtils {

	/**
	 * 运行测试代码可以从指定的文件中读取字符串,然后自动生成语音文件到指定文件夹
	 * @throws Exception
	 */
	@Test
	public void doSaveSpeakFile() throws Exception {
	    
	    //有时会因为window系统中没有安装TTS问题会导致无法保存为语音文件
		readStringsIntoList("name.txt");//运行保存语音文件程序
		
	}
	
	/**
	 * 从指定文件中读取内容
	 * @param filepath
	 * @throws IOException
	 */
	public static void readStringsIntoList(String filepath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		int  i = 1;
		while ((line = br.readLine()) != null) {
			// 语音 运行出所有字符串 用于保存语音文件
			TTSUtils.saveSpeakFile(line,i);
			i++;
		}
		br.close();
	}
	
	/**
	 * 将指定字符串转化成语音,然后保存到指定文件夹
	 * @param text
	 * @throws IOException
	 */
	public static void saveSpeakFile(String text,int i) throws IOException {

		//===========保存文件版==========
		String format = "PowerShell -Command \"Add-Type –AssemblyName System.Speech; $PowerShellSpeak = New-Object System.Speech.Synthesis.SpeechSynthesizer; $PowerShellSpeak.SetOutputToWaveFile('D:\\audio\\%s.wav'); $PowerShellSpeak.Speak('%s');%s\"";
		String format_2 = "$PowerShellSpeak.SetOutputToDefaultAudioDevice();";
		String command = String.format(format, i+" "+text, text,format_2);
		//===================================
		// 提示
		// System.out.println("开始朗读: " + text);

		// 执行命令
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		// 处理结果
		close(powerShellProcess);
		out(powerShellProcess);
		err(powerShellProcess);
	}
	
	/**
	 * 将指定字符串转化成语音在播放器中读取
	 * @param text
	 * @throws IOException
	 */
	public static void speak(String text) throws IOException {
		//===========读音版==========
		// powershell执行的命令
		String format = "PowerShell -Command \"Add-Type –AssemblyName System.Speech; $PowerShellSpeak = New-Object System.Speech.Synthesis.SpeechSynthesizer; $PowerShellSpeak.Speak('%s');\"";
		// 拼接命令
		String command = String.format(format, text);
		
		// 提示
		// System.out.println("开始朗读: " + text);

		// 执行命令
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		// 处理结果
		close(powerShellProcess);
		out(powerShellProcess);
		err(powerShellProcess);
	}

	private static void close(Process powerShellProcess) throws IOException {
		powerShellProcess.getOutputStream().close();
	}

	private static void out(Process powerShellProcess) throws IOException {
		String line;
		boolean isFirstLine = true;
		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		while ((line = stdout.readLine()) != null) {
			if (isFirstLine) {
				System.out.println("正常输出:");
				isFirstLine = false;
			}
			System.out.println(line);
		}
		stdout.close();
	}

	private static void err(Process powerShellProcess) throws IOException {
		String line;
		boolean isFirstLine = true;
		BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
			if (isFirstLine) {
				System.out.println("错误输出:");
				isFirstLine = false;
			}
			System.out.println(line);
		}
		stderr.close();
	}

	//c#实现阅读并保存语音文件
	//http://blog.csdn.net/dcrmg/article/details/52389842
	// using System;
	// using System.Collections.Generic;
	// using System.ComponentModel;
	// using System.Data;
	// using System.Drawing;
	// using System.Linq;
	// using System.Text;
	// using System.Threading.Tasks;
	// using System.Windows.Forms;
	// using System.Speech.Synthesis;
	//
	// namespace MS_TTS
	// {
	// public partial class Form1 : Form
	// {
	// private SpeechSynthesizer speechSyn;
	// public Form1()
	// {
	// InitializeComponent();
	// }
	// private void Form1_Load(object sender, EventArgs e) //界面初始化
	// {
	// label1.Text = "请输入你要转换为语音的文字:\n——(中英文均可):";
	// String str = "记者：您的成绩是58秒85!\n傅园慧：哎呀,我这么快啊！我都不知道!
	// \n记者：您这个还是有所保留吗？\n傅园慧：那必须没有啊！我已经用了洪荒之力了！！";
	// richTextBox1.Text = str;
	// speechSyn = new SpeechSynthesizer();
	// }
	// private void BeginRead(object sender, EventArgs e) //开始朗读按钮
	// {
	// speechSyn.SpeakAsync(richTextBox1.Text);
	// }
	// private void PauseRead(object sender, EventArgs e) //暂停和继续按钮
	// {
	// if (button2.Text == "暂停")
	// {
	// speechSyn.Pause();
	// button2.Text = "继续";
	// }
	// else
	// {
	// speechSyn.Resume();
	// button2.Text = "暂停";
	// }
	// }
	// private void SaveToWav(object sender, MouseEventArgs e) //保存为音频文件
	// {
	// SpeechSynthesizer speechSyn = new SpeechSynthesizer();
	// speechSyn.Volume = trackBar2.TabIndex;
	// speechSyn.Rate = trackBar1.TabIndex;
	// speechSyn.SetOutputToWaveFile("D:\\Record.wav");
	// speechSyn.Speak(richTextBox1.Text);
	// speechSyn.SetOutputToDefaultAudioDevice();
	// MessageBox.Show("保存录音文件成功，保存路径：D:\\Record.wav！");
	// speechSyn.Dispose();//释放资源
	// }
	// private void Exit(object sender, EventArgs e) //退出程序
	// {
	// speechSyn.Dispose();
	// Application.Exit();
	// }
	// }
	// }
	
	
}
