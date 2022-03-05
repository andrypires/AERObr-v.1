package controles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Contato;

@WebServlet("/serv5")
public class servContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servContato() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato();
		
		contato.setContat(request.getParameter("contat"));
		contato.setComent(request.getParameter("coment"));
		
		request.setAttribute("dados", contato);
		
		RequestDispatcher envio2 = request.getRequestDispatcher("2_5saidaContato.jsp");
		envio2.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
