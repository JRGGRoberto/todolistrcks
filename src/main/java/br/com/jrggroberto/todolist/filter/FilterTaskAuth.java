package br.com.jrggroberto.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import jakarta.servlet.FilterChain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.jrggroberto.todolist.user.IUserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

  @Autowired
  private IUserRepository uIUserRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    var servletPath = request.getServletPath();
    if (servletPath.startsWith("/tasks/")) {
      // Pegar a autenticação (user)
      var authorization = request.getHeader("Authorization").substring(6);

      // System.out.println(authorization);
      // pegar parte útil: retorno :"Basic anJnZ3JvYmVydG86MTIzNDU="

      byte[] authDecode = Base64.getDecoder().decode(authorization);
      var authString = new String(authDecode);

      String[] credentials = authString.split(":");
      String username = credentials[0];
      String password = credentials[1];

      // Validar usuário
      var user = this.uIUserRepository.findByUsername(username);

      if (user == null) {
        response.sendError(401);
      } else {
        // Validar senha
        var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if (passwordVerify.verified) {
          request.setAttribute("idUser", user.getId());
          filterChain.doFilter(request, response);
        } else {
          response.sendError(401);
        }

      }

    } else {
      filterChain.doFilter(request, response);
    }

  }

}
