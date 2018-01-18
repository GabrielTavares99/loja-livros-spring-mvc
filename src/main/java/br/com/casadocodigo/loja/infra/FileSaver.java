package br.com.casadocodigo.loja.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String write(String pastaDestino, MultipartFile file){
        String realPath = request.getServletContext().getRealPath("/"+ pastaDestino);
        System.out.println("REAL PATH "+ realPath);
        String path = realPath+"/"+file.getOriginalFilename();
        System.out.println("Path "+ path);
        try {
            // TODO: 18/01/18 Reafactor 
            File fileToCreateDirs = new File(realPath+"/");
            fileToCreateDirs.mkdirs();

            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pastaDestino+"/"+file.getOriginalFilename();
    }

}
