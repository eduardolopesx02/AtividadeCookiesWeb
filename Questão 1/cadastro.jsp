<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
    <form action="SalvarDadosServlet" method="post">
        <h2>Informações Pessoais</h2>
        Nome: <input type="text" name="nomePessoal"><br>
        Idade: <input type="text" name="idade"><br>

        <h2>Informações Acadêmicas</h2>
        Universidade: <input type="text" name="universidade"><br>
        Curso: <input type="text" name="curso"><br>

        <h2>Informações Profissionais</h2>
        Cargo: <input type="text" name="cargo"><br>
        Empresa: <input type="text" name="empresa"><br>

        <h2>Cor Favorita</h2>
        Cor: <input type="text" name="corFavorita"><br>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
