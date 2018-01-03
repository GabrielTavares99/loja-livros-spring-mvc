package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

//    O getServletConfigClasses pede um array de classes de configurações, que ainda não temos, mas que iremos criar depois
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppWebConfiguration.class};
    }

//    O getServletMappings pede um array com os mapeamentos que queremos que nosso servlet atenda
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
