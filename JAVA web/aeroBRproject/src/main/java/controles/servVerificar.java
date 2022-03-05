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

@WebServlet("/serv2_2")
public class servVerificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servVerificar() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contat = request.getParameter("contat");
		Cliente cliente = DAOCadastro.findByContat(contat);
		
		request.setAttribute("dados", cliente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("2_2saidaVerificacao");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
