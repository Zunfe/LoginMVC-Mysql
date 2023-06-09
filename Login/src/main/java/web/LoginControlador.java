package web;

import datos.UsuarioDAO;
import dominio.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;

public class LoginControlador extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.obtenerUsuarioPorEmail(email);
        
        if (usuario != null && usuarioDAO.verificarContrasena(usuario, contrasena)) {
            
            response.sendRedirect("index.jsp");
            
        } else {
            request.setAttribute("Error", "Credenciales invalidas");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
    }
    
}
