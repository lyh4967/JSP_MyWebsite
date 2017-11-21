package Hoons;

import java.sql.Date;
public class Writing{
	private int id;
	private String title;
	private String writer;
	private int count=0;
	private java.sql.Date date;
	private String content;
	
	
	public Writing(int id, String title, String writer, Date date,int count, String content){
	
		this.id=id;
		this.title = title;
		this.writer = writer;
		this.date=date;
		this.count=count;
		this.content = content;
	}
	public Writing(){
		this( "", "","");
	}
	public Writing(String title, String writer,  String content) {
	
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Writing [ID=" +id+", title=" + title + ", writer=" + writer +", w_date="+date+ ", count=" + count + ", content=" + content + "]";
	}
}