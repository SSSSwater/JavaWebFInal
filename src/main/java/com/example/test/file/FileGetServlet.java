package com.example.test.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

@WebServlet(name="QuestionGetServlet",urlPatterns = "/FileGetServlet")
public class FileGetServlet extends HttpServlet {
    //从网页获取以文件。文件内包含以特定格式书写的一道题目

    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    /**
     * 上传数据及保存文件
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }


        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录(统默认的临时文件路径)
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");//这个不能改，改了连收到文件夹里的文件也会乱码=_=

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;//文件储存相对目录
                        File file = new File(filePath);//将当前路径封装成File对象

                        // 保存文件到硬盘
                        item.write(file);
                        System.out.println(filePath);

                        FileWrite.txtString(file);//调用类方法，将file读取并写入数据库
                        response.setContentType("text/html; charset=UTF-8");//必须写且必须在response上面,否则乱码
                        PrintWriter pw=response.getWriter();

                        //文件上传成功，打印success到网页中
                        pw.println("Success!");

                        //5秒后自动跳转

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
    }

    public static void merge()throws IOException {
        //如果没有文件夹则创建文件夹
        File splits = new File("splits");
        if (!splits.exists()) {
            splits.mkdir();
        }
        ArrayList<FileInputStream> al = new ArrayList<>();
        for (int x = 1; x <= 2; x++) {
            al.add(new FileInputStream(splits + "\\" + x + ".part"));
        }
        //Enumeration使用匿名内部类，所以对访问的局部变量进行final修饰
        final Iterator<FileInputStream> it = al.iterator();
        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            public FileInputStream nextElement() {
                return it.next();
            }
        };
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream(splits+"\\"+"0.mp3");
        byte[] buf = new byte[1024];
        int len;
        while((len=sis.read(buf))!=-1)
        {
            fos.write(buf,0,len);
        }
        fos.close();
        sis.close();
    }
}
