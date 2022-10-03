package servlets;

import domain.Note;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        // get the note from the txt file and set it to the request
        String title = br.readLine();
        String contents = br.readLine();
        Note note = new Note();
        note.setTitle(title);
        note.setContents(contents);
        request.setAttribute("note", note);

        // forward the request to the viewnote.jsp or editnote.jsp
        if (request.getParameter("edit") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Create a new Note object
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        Note note = new Note(title, contents);

        // Set the Note object as a session attribute
        request.setAttribute("note", note);

        //validate the parameters
        if (title == null || title.equals("") || contents == null || contents.equals("")) {
            boolean error = true;
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }

        // Write the Note object to the file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(title);
        pw.println(contents);
        pw.close();

        // Forward to the edit.jsp page
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    }
}
