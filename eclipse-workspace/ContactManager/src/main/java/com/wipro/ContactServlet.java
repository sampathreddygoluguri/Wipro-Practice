package com.wipro;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ContactServlet - supports list, add, create, edit, update, delete actions.
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ATTR_CONTACTS = "contacts";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // initialize thread-safe list once in application scope
        if (getServletContext().getAttribute(ATTR_CONTACTS) == null) {
            getServletContext().setAttribute(ATTR_CONTACTS, new CopyOnWriteArrayList<Contact>());
        }
    }

    @SuppressWarnings("unchecked")
    private List<Contact> contacts() {
        return (List<Contact>) getServletContext().getAttribute(ATTR_CONTACTS);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null || action.isEmpty() || "welcome".equals(action)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        switch (action) {
            case "list":
                request.setAttribute("contacts", contacts());
                request.getRequestDispatcher("listContacts.jsp").forward(request, response);
                return;

            case "add":
                // show add form
                request.getRequestDispatcher("addEditContact.jsp").forward(request, response);
                return;

            case "edit":
                // find contact by id and forward to form with contact attribute
                String idToEdit = request.getParameter("id");
                if (idToEdit != null) {
                    Contact found = findById(idToEdit);
                    if (found != null) {
                        request.setAttribute("contact", found);
                        request.getRequestDispatcher("addEditContact.jsp").forward(request, response);
                        return;
                    } else {
                        flashError(request.getSession(), "Record not found for editing.");
                    }
                } else {
                    flashError(request.getSession(), "Missing contact id for edit.");
                }
                response.sendRedirect("ContactServlet?action=list");
                return;

            case "delete":
                String idToDelete = request.getParameter("id");
                if (idToDelete != null) {
                    boolean removed = deleteById(idToDelete);
                    if (removed) {
                        flashSuccess(request.getSession(), "Contact deleted successfully.");
                    } else {
                        flashError(request.getSession(), "Contact not found; delete failed.");
                    }
                } else {
                    flashError(request.getSession(), "Missing contact id for delete.");
                }
                response.sendRedirect("ContactServlet?action=list");
                return;

            default:
                response.sendRedirect("ContactServlet?action=list");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String name = trim(request.getParameter("name"));
            String email = trim(request.getParameter("email"));
            String phone = trim(request.getParameter("phone"));
            String notes = trim(request.getParameter("notes"));

            if (name.isEmpty()) {
                flashError(request.getSession(), "Name is required.");
                // preserve entered values to show back on form
                request.setAttribute("contact", buildTempContact(null, name, email, phone, notes));
                request.getRequestDispatcher("addEditContact.jsp").forward(request, response);
                return;
            }

            Contact c = new Contact();
            c.setId(UUID.randomUUID().toString());
            c.setName(name);
            c.setEmail(email);
            c.setPhone(phone);
            c.setNotes(notes);
            contacts().add(c);

            flashSuccess(request.getSession(), "Contact added successfully.");
            response.sendRedirect("ContactServlet?action=list");
            return;
        }

        if ("update".equals(action)) {
            String id = request.getParameter("id");
            String name = trim(request.getParameter("name"));
            String email = trim(request.getParameter("email"));
            String phone = trim(request.getParameter("phone"));
            String notes = trim(request.getParameter("notes"));

            if (id == null || id.isEmpty()) {
                flashError(request.getSession(), "Missing contact id for update.");
                response.sendRedirect("ContactServlet?action=list");
                return;
            }
            if (name.isEmpty()) {
                flashError(request.getSession(), "Name is required.");
                request.setAttribute("contact", buildTempContact(id, name, email, phone, notes));
                request.getRequestDispatcher("addEditContact.jsp").forward(request, response);
                return;
            }

            Contact found = findById(id);
            if (found != null) {
                found.setName(name);
                found.setEmail(email);
                found.setPhone(phone);
                found.setNotes(notes);
                flashSuccess(request.getSession(), "Contact updated successfully.");
            } else {
                flashError(request.getSession(), "Contact not found; update failed.");
            }
            response.sendRedirect("ContactServlet?action=list");
            return;
        }

        // unknown POST action -> go to list
        response.sendRedirect("ContactServlet?action=list");
    }

    // Helpers
    private Contact findById(String id) {
        for (Contact c : contacts()) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    private boolean deleteById(String id) {
        Contact found = findById(id);
        if (found != null) return contacts().remove(found);
        return false;
    }

    private void flashSuccess(HttpSession session, String message) {
        session.setAttribute("messageType", "success");
        session.setAttribute("message", message);
    }

    private void flashError(HttpSession session, String message) {
        session.setAttribute("messageType", "error");
        session.setAttribute("message", message);
    }

    private Contact buildTempContact(String id, String name, String email, String phone, String notes) {
        Contact t = new Contact();
        t.setId(id);
        t.setName(name);
        t.setEmail(email);
        t.setPhone(phone);
        t.setNotes(notes);
        return t;
    }

    private String trim(String s) {
        return s == null ? "" : s.trim();
    }
}
