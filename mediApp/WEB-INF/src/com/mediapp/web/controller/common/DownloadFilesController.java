package com.mediapp.web.controller.common;

import org.springframework.web.servlet.mvc.SimpleFormController;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.ModelAndView;
public class DownloadFilesController extends SimpleFormController{

	private static final String destinationDir = "C:/Documents and Settings/Administrator/Desktop/padmaraj/myfiles/";
	  
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ServletContext servletContext = request.getSession()
        .getServletContext();

        String file = request.getParameter("file");
      //  String fileName = request.getParameter("fileName");
        String tempDestPath=destinationDir+file;
        File uFile = new File(tempDestPath);
        System.out.println("filepath:"+tempDestPath);
        System.out.println("File exist:"+uFile.exists()+"..readable:"+uFile.isFile());
        try{
            uFile=new File(tempDestPath);
        }
        catch(Exception ex){
            System.out.println("exception getting file:"+ex.getMessage());
        }
        int fSize = (int) uFile.length();
        if (fSize > 0) {

        BufferedInputStream in = new BufferedInputStream(
        new FileInputStream(uFile));
        String mimetype = servletContext.getMimeType(file);

        response.setBufferSize(fSize);
        response.setContentType(mimetype);
        response.setHeader("Content-Disposition", "inline; filename=\""
        + file + "\"");
        response.setContentLength(fSize);
        //added later
        /**response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        */
        //finish added later
        FileCopyUtils.copy(in, response.getOutputStream());
        in.close();
        response.getOutputStream().flush();
        response.getOutputStream().close();
        } else {
        response.setContentType("text/html");
        PrintWriter printwriter = response.getWriter();
        printwriter.println("<html>");
        printwriter.println("<br><br><br><h2>Could not get file name:<br>" + file + "</h2>");
        printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
        printwriter.println("<br><br><br>&copy; webAccess");
        printwriter.println("</html>");
        printwriter.flush();
        printwriter.close();
        }

        return null;
        }

}
