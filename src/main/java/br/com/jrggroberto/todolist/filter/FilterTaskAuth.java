package br.com.jrggroberto.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import jakarta.servlet.FilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    filterChain.doFilter(request, response);

    // Pegar a autenticação (user)
    var authorization = request.getHeader("Authorization").substring(6);

    // pegar parte útil: retorno :"Basic anJnZ3JvYmVydG86MTIzNDU="
    System.out.println(authorization);

    byte[] authDecode = Base64.getDecoder().decode(authorization);
    var authString = new String(authDecode);

    String[] credentials = authString.split(":");
    String username = credentials[0];
    String password = credentials[1];

    System.out.println(username);
    System.out.println(password);

    // Validar usuário

    System.out.println("chegou ao filtro");

    //
    // throw new UnsupportedOperationException("Unimplemented method
    // 'doFilterInternal'");

  }

}
