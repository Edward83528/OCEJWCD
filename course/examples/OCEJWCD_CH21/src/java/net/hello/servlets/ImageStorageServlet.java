package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "ImageStorageServlet", urlPatterns = {"/ImageStorageServlet"})
@MultipartConfig(location="C:/OCEJWCD/resources/upload/")
public class ImageStorageServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        
        Part imagePart = request.getPart("filename");
        String fileName = extractFileName(imagePart);
        
        if (fileName != null && fileName.length() > 0) {
            String imageFileName = getUniqueName(fileName);
            imagePart.write(imageFileName);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<html><head></head><body>");
            out.write("<h1>Upload complete.</h1>");
            out.write("<a href=\"index.html\">Home</a>");
            out.write("</body></html>");
        }
    }

    private String extractFileName(Part part) {
        // 讀取HTTP Header中的資訊
        String contentDisp = part.getHeader("content-disposition");
        // 使用「;」拆解
        String[] items = contentDisp.split(";");
        
        for (String s : items) {
            // 是否為上傳檔案名稱的HTTP Header資訊 
            if (s.trim().startsWith("filename")) {
                // 回傳上傳檔案名稱
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        
        return "";
    }    
    
    private String getUniqueName(String fn) {
        // 上傳檔案名稱中「.」的位置
        int dot = fn.lastIndexOf(".");
        String sn = "";

        if (dot != -1) {
            // 取得上傳檔案名稱的副檔名
            sn = fn.substring(dot);
        }

        // 建立產生檔案名稱的日期物件
        Date now = new Date();
        // 設定檔案名稱格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(now) + sn;
    }    
}
