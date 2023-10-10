package com.majidim.easybankv3.easybankv3.servlets;

import com.majidim.easybankv3.easybankv3.dto.Client;
import com.majidim.easybankv3.easybankv3.dto.Personne;
import com.majidim.easybankv3.easybankv3.implementation.ClientImpl;
import com.majidim.easybankv3.easybankv3.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    private final ClientService clientService;

    public ClientServlet() {
        this.clientService = new ClientService(new ClientImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list" -> listClients(request, response);
            case "view" -> viewClient(request, response);
            case "edit" -> editClient(request, response);
            case "delete" -> deleteClient(request, response);
            default -> listClients(request, response);
        }
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientService.showList();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/view/client/clientlist.jsp").forward(request, response);

    }

    private void viewClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code != null) {
            List<Client> clients = clientService.searchByCode(code);
            if (!clients.isEmpty()) {
                Client client = clients.get(0);
                request.setAttribute("client", client);
                request.getRequestDispatcher("/client-view.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/client");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/client");
        }
    }

    private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code != null) {
            List<Client> clients = clientService.searchByCode(code);
            if (!clients.isEmpty()) {
                Client client = clients.get(0);
                request.setAttribute("client", client);
                request.getRequestDispatcher("/client-edit.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/client");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/client");
        }
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        if (code != null) {
            boolean deleted = clientService.delete(code);
            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/client");
            } else {
                response.sendRedirect("/client?error=delete-failed");

            }
        } else {
            response.sendRedirect(request.getContextPath() + "/client");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "edit" -> updateClient(request, response);
            case "add" -> addClient(request, response);
            default -> listClients(request, response);
        }
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        LocalDate dateN = LocalDate.parse(request.getParameter("dateN"));
        String tel = request.getParameter("tel");
        String adress = request.getParameter("adress");

        Client client = new Client(code, nom, prenom, dateN, tel, adress);

        Optional<Client> updatedClient = clientService.update(client);

        if (updatedClient.isPresent()) {
            response.sendRedirect(request.getContextPath() + "/client?action=list");
        } else {
            response.sendRedirect("/client?error=update-failed");
        }
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        LocalDate dateN = LocalDate.parse(request.getParameter("dateN"));
        String tel = request.getParameter("tel");
        String adress = request.getParameter("adress");

        Client client = new Client(code, nom, prenom, dateN, tel, adress);

        Optional<Personne> addedClient = clientService.add(client);

        if (addedClient.isPresent()) {
            response.sendRedirect(request.getContextPath() + "/client?action=list");
        } else {
            response.sendRedirect("/client?error=ajoute-failed");

        }
    }
}
