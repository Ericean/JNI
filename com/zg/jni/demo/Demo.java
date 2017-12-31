package com.zg.jni.demo;
import java.io.*;
public class Demo{
	static {
		System.loadLibrary("foo");
	}
	private byte[] load(InputStream is) throws IOException{
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		int ch;
		while((ch=is.read())!=-1){
			bs.write(ch);
		}
		byte data[] = bs.toByteArray();
		bs.close();
		return data;
	}
	private native void init(byte[] data);
	public static void main(String[] args){
		Demo d=new Demo();
		try(InputStream inputstream = new FileInputStream("test.txt")){
			System.out.println("Start to load model...");
			long startTime = System.currentTimeMillis();
			byte[] data = d.load(inputstream);
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("time cost: "+ totalTime);

			System.out.println("Start to do buff copy...");
			startTime = System.currentTimeMillis();
			d.init(data);
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("time cost: "+ totalTime);

		}catch(IOException e){
		}
	}
}
