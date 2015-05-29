package br.edu.utfpr.cm.pi.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "SuperControlador", urlPatterns = { "/SuperController" })
public abstract class SuperController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public abstract String acaoPadrao(HttpServletRequest request);

	public abstract String incluir(HttpServletRequest request);

	public abstract String salvar(HttpServletRequest request);

	public abstract String alterar(HttpServletRequest request);

	public abstract String excluir(HttpServletRequest request);

	private String proximaPagina = "index.jsp";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		String acao = request.getParameter("acao");

		if (acao == null) {

			proximaPagina = acaoPadrao(request);
		} else {
			try {

				Class<? extends SuperController> estaClasse = this.getClass();
				Method metodo = estaClasse.getDeclaredMethod(acao,
						HttpServletRequest.class);
				proximaPagina = (String) metodo.invoke(this, request);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		request.getRequestDispatcher(proximaPagina).forward(request, response);

	}
}