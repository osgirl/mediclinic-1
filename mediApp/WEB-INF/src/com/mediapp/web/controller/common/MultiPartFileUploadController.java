package com.mediapp.web.controller.common;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mediapp.domain.common.MultiPartFileUploadBean;

public class MultiPartFileUploadController extends SimpleFormController {
    private static final String destinationDir = "C:/userdata/";
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest req, 
                                    HttpServletResponse res, 
                                    Object command, 
                                    BindException errors) throws Exception {
        res.setContentType("text/plain");
        if (!(req instanceof MultipartHttpServletRequest)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Expected multipart request");
            return null;
        }
        MultiPartFileUploadBean bean = (MultiPartFileUploadBean) command;
        MultipartFile file = bean.getFile();
        File destination = new File(destinationDir + file.getOriginalFilename());
        file.transferTo(destination);
        res.getWriter().write("Success, wrote to " + destination.getAbsolutePath());        
        res.flushBuffer();
        return null;
    }
}
