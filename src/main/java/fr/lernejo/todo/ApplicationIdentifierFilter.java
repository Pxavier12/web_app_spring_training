package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {

    final String uuid;

    public ApplicationIdentifierFilter() {
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResp = (HttpServletResponse) response;

        try {
            ((HttpServletResponse) response).addHeader("Instance-Id", uuid);
            chain.doFilter(request, response);

        } catch (Exception e){
        }
    }
}
