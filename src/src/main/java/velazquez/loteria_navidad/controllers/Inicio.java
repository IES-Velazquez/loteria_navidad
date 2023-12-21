package velazquez.loteria_navidad.controllers;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.loteria_navidad.dao.DAOUsuarioImpl;
import velazquez.loteria_navidad.models.Usuario;
import velazquez.loteria_navidad.utils.PasswordHashGenerator;

@WebServlet(name = "Inicio", value="/Inicio")
public class Inicio extends HttpServlet {
    static final Logger logger = LoggerFactory.getLogger(Inicio.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        logger.info("doGet");

//        request.getRequestDispatcher("WEB-INF/view/inicio.jsp").forward(request, response);
        request.getRequestDispatcher("WEB-INF/view/private/administrador.jsp").forward(request, response);
//    request.getRequestDispatcher("WEB-INF/test/test.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("doPost");
        if (request.getParameter("usuario") != null && request.getParameter("pass") != null) {
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            DAOUsuarioImpl dao = new DAOUsuarioImpl();

            Usuario user = dao.getUsuario(usuario);


            if (user != null) {
                logger.info("Usuario encontrado: " + user.getUsuario());
                logger.info("Password DB: " + user.getPass());
                logger.info("Password Request: " + pass);
                if (PasswordHashGenerator.checkPassword(pass, user.getPass())) {

                    HttpSession sesion = request.getSession();

                    sesion.setAttribute("usuario", user.getUsuario());
                    sesion.setAttribute("role", user.getRole());

                    if ("admin".equals(user.getRole())) {
                        response.sendRedirect("Admin/");
                    } else {
                        response.sendRedirect("User");
                    }
                } else {
                    request.setAttribute("error", "login inválido");
                    doGet(request, response);
                    return;
                }
            } else {
                request.setAttribute("error", "faltan parametros");
                request.getRequestDispatcher("WEB-INF/view/inicio.jsp").forward(request, response);
            }
        }
    }
}

