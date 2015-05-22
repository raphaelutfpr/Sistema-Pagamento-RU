package br.edu.utfpr.cm.controller;


    import java.io.IOException;
    import java.io.PrintWriter;
    import java.lang.reflect.Method;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    /**
     *
     * @author raphael
     */
    //@WebServlet(name = "SuperControlador", urlPatterns = {"/SuperControlador"})
    public abstract class SuperControlador extends HttpServlet {

        /**
         * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
         * methods.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("text/html;charset=UTF-8");

            String acao = request.getParameter("acao");
            String proximaPagina = "index.jsp";

            if (acao == null) {
                proximaPagina = acaoPadrao(request);
            } else {
                try {
                    Class estaClasse = this.getClass();
                    Method metodo = estaClasse.getDeclaredMethod(acao, HttpServletRequest.class);
                    proximaPagina=(String) metodo.invoke(this, request);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            request.getRequestDispatcher(proximaPagina).forward(request, response);

        }

        public abstract String acaoPadrao(HttpServletRequest request);

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
            return "Short description";
        }// </editor-fold>

    }
