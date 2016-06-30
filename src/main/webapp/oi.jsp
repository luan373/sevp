<%@page import="br.com.sevp.model.entity.TipoProduto"%>
<%@page import="br.com.sevp.model.dao.TipoProdutoDao"%>
<%@page import="br.com.sevp.model.entity.Pedido"%>
<%@page import="br.com.sevp.model.dao.PedidoDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.sevp.model.entity.Usuario"%>
<%@page import="br.com.sevp.model.dao.UsuarioDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		try {

			/**/
			usuario = dao.recuperar(1L);
			//System.out.println(usuario.getNome());

			//System.out.println(usuario.getPedidos()); 
			TipoProdutoDao tipoProdutoDao = new TipoProdutoDao();

			List<TipoProduto> lista = tipoProdutoDao.listar();
			for (TipoProduto produto : lista) {
				System.out.println(produto.getDescricaoTipoProduto());
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println("Aff");
		}
	%>
</body>
</html>