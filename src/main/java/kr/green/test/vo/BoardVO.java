package kr.green.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String valid;
	private String file;
	private Date registered;
	private int views;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getFile() {
		return file;
	}
	public String getFileName() { //---------------------------------새로만들어뜌 왜냐믄 사용자에게 파일명만 간단하게 보여주기 위해서
		int index = file.indexOf("_");
		return file.substring(index+1);
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getRegistered() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(registered);
	}
	public String getRegisteredUntilDay() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(registered);
	}
	public void setRegistered(Date registered) {
		this.registered = registered;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", valid="
				+ valid + ", file=" + file + ", registered=" + registered + ", views=" + views + "]";
	}
	
	
	
	

}
