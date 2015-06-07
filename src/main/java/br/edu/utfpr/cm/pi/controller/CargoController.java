package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.daos.CargoDao;

/**
 *
 * @author raphael
 */
public class CargoController extends SuperController {

    private static final long serialVersionUID = -2370921254016052104L;
    
    private CargoDao dao;

    public CargoController() {
        dao = new CargoDao();
    }

    @Override
    public String acaoPadrao(HttpServletRequest request) {
        List<Cargo> cargos = dao.getAll();
        request.setAttribute("lista", cargos);
        return "listas/listaCargos.jsp";
    }

    public String incluir(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        request.setAttribute("cargo", cargo);
        return "cadastros/formCargo.jsp";
    }

    public String salvar(HttpServletRequest request) throws JasperException {
        Cargo cargo = new Cargo();
        JspRuntimeLibrary.introspect(cargo, request);

        dao.save(cargo);
        return acaoPadrao(request);
    }

    public String excluir(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        Long id = Long.parseLong(request.getParameter("id"));
        cargo=dao.findById(id);
        dao.delete(cargo);
        return acaoPadrao(request);
    }

    public String alterar(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        Long id = Long.parseLong(request.getParameter("id"));
        cargo = dao.findById(id);
        request.setAttribute("cargo", cargo);
        return "cadastros/formCargo.jsp";
    }

}
