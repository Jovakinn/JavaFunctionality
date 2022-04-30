package ua.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Log
@WebServlet("/morning")
public class MorningServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printClientsMood(req);
        printClientsCookies(req);
        printMorning(req, resp);
        resp.addCookie(new Cookie("SUPER_ID", UUID.randomUUID().toString()));
    }

    private void printClientsCookies(HttpServletRequest req) {
        Stream.of(req.getCookies())
                .forEach(cookie -> log.info(cookie.getName() + "=" + cookie.getValue()));
    }

    @SneakyThrows
    private void printMorning(HttpServletRequest req, HttpServletResponse resp) {
        var session = req.getSession();
        var sessionName = Optional.ofNullable((String)session.getAttribute("name"));
        var requestName = Optional.ofNullable(req.getParameter("name"));
        requestName
                .filter(name -> sessionName.isEmpty())
                .ifPresent(name -> session.setAttribute("name", name));

        var writer = resp.getWriter();
        var name = requestName
                .or(() -> sessionName)
                .orElse("my friend");
        writer.println("Good Morning, " + name);
    }

    private void printClientsMood(HttpServletRequest req) {
        var name = Optional.ofNullable(req.getParameter("name"))
                        .orElse(req.getRemoteAddr());
        Optional.ofNullable(req.getHeader("X-Mood"))
                .ifPresent(mood -> log.info(name + " is feeling " + mood));
    }
}
