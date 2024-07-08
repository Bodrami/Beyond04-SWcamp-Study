package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* 설명. 요청이 서블릿으로 들어올 때 HttpServletRequest 에는 JSESSIONID 라는 값이 Header 에 같이
         *      포함되어 넘어온다. 그럼 해당 JSESSIONID 에 맞는 HttpSession 객체를 생성해서 해당 사용자를 위한 전용
         *      저장 공간을 제공하게 된다. */
        HttpSession session = req.getSession();

        /* 설명. 따로 설정하지 않으면 session 공간은 30분의 만료시간을 가진다. (보통 우리 로그인해서 사용할 수 있는 시간을 생각하자) */
        System.out.println("session 객체의 defalut 유지 시간(초): " + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);                // (초 단위) 10분

        System.out.println("session 객체의 defalut 유지 시간(초): " + session.getMaxInactiveInterval());
        System.out.println("session id: " + session.getId());   // JESESSIONID 출력

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");
    }
}
