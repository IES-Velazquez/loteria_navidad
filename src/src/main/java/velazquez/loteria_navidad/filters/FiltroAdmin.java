package velazquez.loteria_navidad.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class FiltroAdmin implements Filter {

  public FiltroAdmin() {}

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sesion = httpRequest.getSession();
    String email = (String) sesion.getAttribute("email");
    String role = (String) sesion.getAttribute("role");

    if (!sesion.isNew() && email != null && role.equals("admin")) {
      chain.doFilter(request, response);
    } else {
      httpResponse.sendRedirect(httpRequest.getContextPath());
    }
  }
}
