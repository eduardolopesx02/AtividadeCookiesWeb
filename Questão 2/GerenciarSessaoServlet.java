import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/GerenciarSessaoServlet")
public class GerenciarSessaoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtém a sessão existente ou cria uma nova sessão
        HttpSession session = request.getSession();

        // Obtém o ID da sessão
        String sessionID = session.getId();

        // Verifica se a contagem de sessões já foi inicializada
        if (session.getAttribute("contador") == null) {
            session.setAttribute("contador", 0);
        }

        // Obtém a contagem atual de sessões
        int contador = (int) session.getAttribute("contador");
        contador++;

        // Define a última data e hora de acesso da sessão
        session.setAttribute("ultimoAcesso", new Date());

        // Verifica se é a 5ª sessão
        if (contador == 5) {
            out.println("Esta é a 5ª sessão!");
        }

        // Exibe informações da sessão
        out.println("ID da Sessão: " + sessionID + "<br>");
        out.println("Data e Hora de Criação da Sessão: " + new Date(session.getCreationTime()) + "<br>");

        if (session.getAttribute("ultimoAcesso") != null) {
            Date ultimoAcesso = (Date) session.getAttribute("ultimoAcesso");
            out.println("Data e Hora do Último Acesso: " + ultimoAcesso + "<br>");
        }

        // Atualiza a contagem de sessões na sessão
        session.setAttribute("contador", contador);
    }
}