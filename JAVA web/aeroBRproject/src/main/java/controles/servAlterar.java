package controles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCadastro;
import modelos.Cliente;

@WebServlet("/serv2_3")
public class servAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servAlterar() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setSnome(request.getParameter("snome"));
		cliente.setIdade(request.getParameter("idade"));
		cliente.setUf(request.getParameter("uf"));
		cliente.setContat(request.getParameter("contat"));
		cliente.setSenha(request.getParameter("senha"));
		
		DAOCadastro.update(cliente);
		
		request.setAttribute("dados", cliente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("2_2saidaAlterar");
		requestDispatcher.forward(request,  response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
