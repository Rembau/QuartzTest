package test;

import java.io.UnsupportedEncodingException;

public class TransfChar {
	public static void main(String[] args) {
		String str="��-1������CronTrigger��ָ���鼰���";
		try {
			p(new String(str.getBytes("gbk"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void p(Object o){
		System.out.println(o);
	}
}
