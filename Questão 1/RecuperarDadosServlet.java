import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RecuperarDadosServlet")
public class RecuperarDadosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();

        String corFavorita = null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("corFavorita")) {
                corFavorita = cookie.getValue();
                break;
            }
        }

        if (corFavorita != null) {
            response.getWriter().println("<h2 style=\"color: " + corFavorita + "\">Dados Salvos com Sucesso:</h2>");
            for (Cookie cookie : cookies) {
                response.getWriter().println(cookie.getName() + ": " + cookie.getValue() + "<br>");
            }
        } else {
            response.getWriter().println("<h2>Dados não encontrados.</h2>");
        }
    }
}
