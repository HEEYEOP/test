package kr.green.test.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
	
		UUID uid = UUID.randomUUID();	//고유식별자를 통해 같은 파일명이여도 다르게 저장되도록 하는 UUID생성
		
		String savedName = uid.toString() +"_" + originalName; //UUID_파일명
		String savedPath = calcPath(uploadPath);				//날짜로된 폴더 생성(해당 폴더가 없으면) 한 후 업로드할 날짜폴더의 풀 경로 가져옴 ex)) \\년\\월\\일
		File target = new File(uploadPath + savedPath, savedName);	//	uploadPath\\년\\월\\일 폴더 밑에 UUID_파일명을 가지는 빈 파일 생성
		FileCopyUtils.copy(fileData, target);						//해당 파일에 클라이언트가 보낸 파일 복사(== 서버에 업로드)
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName); //폴더 경로와 파일명을 이용하여 URL형태로 바꿈 ex)) C\\WHY\\git\\uploadfiles\\2019\\08\\06\\UUID_파일명 ===> /2019/08/06/UUID_파일명
		return uploadFileName;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	private static void makeDir(String uploadPath, String... paths) {
		if(new File(paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

}
