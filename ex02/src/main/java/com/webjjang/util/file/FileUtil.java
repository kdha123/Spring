package com.webjjang.util.file;

import java.io.File;

public class FileUtil {

	public static File removeDuplicateFileName(final String realPath, final String fileName)throws Exception{
		int cnt = 0; // 사용할 때 ++cnt 사용한다.
		File saveFile = new File(realPath, fileName);
		int seperatePos = fileName.lastIndexOf(".");
		String name = fileName.substring(0, seperatePos);
		// .을 포함한다.
		String ext = fileName.substring(seperatePos);
		System.out.println("name:"+ name + ", ext:"+ext);
		while(saveFile.exists()) {
			// 중복된 파일이 있는 경우 처리
			saveFile = new File(realPath, name + (++cnt) + ext);
		}
		// 중복이 되지 않는 파일 객체 리턴
		return saveFile;
	}
	
}
