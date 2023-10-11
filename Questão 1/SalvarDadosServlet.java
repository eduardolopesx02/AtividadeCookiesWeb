import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SalvarDadosServlet")
public class SalvarDadosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nomePessoal = request.getParameter("nomePessoal");
        String idade = request.getParameter("idade");
        String universidade = request.getParameter("universidade");
        String curso = request.getParameter("curso");
        String cargo = request.getParameter("cargo");
        String empresa = request.getParameter("empresa");
        String corFavorita = request.getParameter("corFavorita");

        // Salvar os dados como cookies
        Cookie nomeCookie = new Cookie("nomePessoal", nomePessoal);
        Cookie idadeCookie = new Cookie("idade", idade);
        Cookie universidadeCookie = new Cookie("universidade", universidade);
        Cookie cursoCookie = new Cookie("curso", curso);
        Cookie cargoCookie = new Cookie("cargo", cargo);
        Cookie empresaCookie = new Cookie("empresa", empresa);
        Cookie corCookie = new Cookie("corFavorita", corFavorita);

        response.addCookie(nomeCookie);
        response.addCookie(idadeCookie);
        response.addCookie(universidadeCookie);
        response.addCookie(cursoCookie);
        response.addCookie(cargoCookie);
        response.addCookie(empresaCookie);
        response.addCookie(corCookie);

        response.sendRedirect("cadastro.jsp");
    }
}
