package org.fage.controller;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.fage.dao.UserFileDao;
import org.fage.domain.UserFile;
import org.fage.utils.UploadAndDownUtils;
import com.opensymphony.xwork2.ActionSupport;
/***
 * 
 * @author Administrator
 *	文章出处：http://www.cnblogs.com/xiaoluo501395377/archive/2012/10/26/2740882.html
 */
public class UploadingAction extends ActionSupport{
	//表单标题
	private String title;
	//上传过来的临时文件（并不是上传过来的直接文件）
	private File file;
	//提交过来的file的名字（struts自动注入）
    private String fileFileName;
    //提交过来的file的MIME类型（struts自动注入）
    private String fileContentType;
    //需要存储的路径，
    private String uploadSaveDir;
	
    @Override
	public String execute() throws Exception{
    	//要存储的目录
    	 String root = ServletActionContext.getServletContext().getRealPath(uploadSaveDir);
    	 //构造一个存储在数据库的url
    	 String url = root +"\\"+fileFileName;
    	 UserFileDao userFileDao = new UserFileDao();
    	 UserFile uf = new UserFile(title,fileFileName,url);
    	 userFileDao.add(uf);
    	 //真正的将文件copy到本地
    	 UploadAndDownUtils.copy(file,new File(root, fileFileName));
//    	 System.out.println("fileFileName: " + fileFileName);
//		  因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
//       System.out.println("file: " + file.getName());
//       System.out.println("file: " + file.getPath());
		 return "success";
	}
	
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	public String getUploadSaveDir() {
		return uploadSaveDir;
	}

	public void setUploadSaveDir(String uploadSaveDir) {
		this.uploadSaveDir = uploadSaveDir;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
}
/*public String execute() throws Exception{
	String root = ServletActionContext.getServletContext().getRealPath("/upload");
	InputStream in = new FileInputStream(file);
	OutputStream out = new FileOutputStream(new File(root, fileFileName));
	System.out.println("fileFileName: " + fileFileName);
	因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
   	System.out.println("file: " + file.getName());
   	System.out.println("file: " + file.getPath());
   	byte[] buffer = new byte[1024];
   	int length = 0;
   	while((length=in.read(buffer, 0, buffer.length))!=-1){
       out.write(buffer, 0, length);
   	}
   	out.close();
   	in.close();
	return "success";
}*/
