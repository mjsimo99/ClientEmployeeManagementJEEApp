package com.majidim.easybankv3.easybankv3.servlets;

import com.majidim.easybankv3.easybankv3.dto.Client;
import com.majidim.easybankv3.easybankv3.dto.Employe;
import com.majidim.easybankv3.easybankv3.dto.Personne;
import com.majidim.easybankv3.easybankv3.implementation.EmployeImpl;
import com.majidim.easybankv3.easybankv3.service.EmployeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet("/employe")

public class EmployeServlet extends HttpServlet {
    private final EmployeService employeService;

    public EmployeServlet() {
        this.employeService = new EmployeService(new EmployeImpl());
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "list";
        }
        switch (action){
            case "add" -> addEmploye(request,response);
            case "view" -> listEmploye(request,response);
            case "search" -> searchEmployes(request, response);
            default -> listEmploye(request,response);
        }

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    private void listEmploye(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        List<Employe> employes = employeService.ShowList();
        request.setAttribute("employes",employes);
        request.getRequestDispatcher("/view/employe/employelist.jsp").forward(request,response);
    }

    private void searchEmployes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");

        List<Employe> searchResults = employeService.SearchByEmail(query);

        request.setAttribute("employes", searchResults);
        request.getRequestDispatcher("/view/employe/employelist.jsp").forward(request,response);
    }


    private void addEmploye(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String matricule = request.getParameter("matricule");
        LocalDate dateRecrutement = LocalDate.parse(request.getParameter("dateRecrutement"));
        String emailAdresse = request.getParameter("emailAdresse");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        LocalDate dateN = LocalDate.parse(request.getParameter("dateN"));
        String tel = request.getParameter("tel");
        String adress = request.getParameter("adress");

        Employe employe = new Employe(nom,prenom,dateN,tel,adress, matricule, dateRecrutement, emailAdresse);
        Optional<Personne> addEmploye = employeService.add(employe);
        if (addEmploye.isPresent()){
            response.sendRedirect(request.getContextPath() + "/employe?action=list");
        } else {
            response.sendRedirect("/employe?error=ajoute-failed");
        }

    }
    }