package velazquez.loteria_navidad.controllers;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "Inicio")
public class Inicio extends HttpServlet {
  static final Logger logger = LoggerFactory.getLogger(Inicio.class);

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    response.setContentType("text/html");

    logger.info("doGet");

//    request.getRequestDispatcher("WEB-INF/view/formularioEntrada.jsp").forward(request, response);
    request.getRequestDispatcher("WEB-INF/test/test.jsp").forward(request, response);
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

  }
}
