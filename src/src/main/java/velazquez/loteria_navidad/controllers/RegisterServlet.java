package velazquez.loteria_navidad.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.loteria_navidad.dao.DAOUsuarioImpl;
import velazquez.loteria_navidad.utils.PasswordHashGenerator;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    static final Logger logger = LoggerFactory.getLogger(RegisterServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        logger.info("doGet");

        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("doPost");

        boolean success;
        String error;

        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        logger.info(nombre +  ", " + usuario + ", " + password);

        if (nombre != null && usuario != null && password != null) {

            password = PasswordHashGenerator.hashPassword(password);
            DAOUsuarioImpl daoUsuario = new DAOUsuarioImpl();
            success = daoUsuario.register(usuario, password, nombre);

            if (success) {
                logger.info("Usuario creado con éxito");
            } else {
                logger.error("No pudo crearse el usuario");
            }

            response.sendRedirect(request.getContextPath() + "/Inicio");
        } else {
            error = "No se facilitaron los campos necesarios";
            logger.error(error);
            request.setAttribute("error", error);

            doGet(request, response);
        }
    }

}