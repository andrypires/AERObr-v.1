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

@WebServlet("/serv2")
public class servCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servCadastro() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher envio = null;
		
		try {
		
		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setSnome(request.getParameter("snome"));
		cliente.setIdade(request.getParameter("idade")); 
		cliente.setContat(request.getParameter("contat"));
		cliente.setUf(request.getParameter("uf"));
		cliente.setSenha(request.getParameter("senha"));
		
		DAOCadastro.create(cliente);
		
		request.setAttribute("dados", cliente);
		
		envio = request.getRequestDispatcher("2_2saidaCadastro.jsp");
		envio.forward(request, response);
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
