package com.oe.student.config.filter;

import com.alibaba.fastjson.JSONObject;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.OeResponse;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangwj
 * @data 2019/4/4
 */
public class JWTFilter extends OncePerRequestFilter {

    public JWTFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        boolean isFilter = false;
        if (header == null || !header.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            authentication = getAuthentication(request);
            request.setAttribute("userId", ((LinkedHashMap<String, Object>) authentication.getPrincipal()).get("username"));
            isFilter = true;
        } catch (Exception e) {
            OutputStream out = null;
            try {
                out = response.getOutputStream();
                PrintWriter writer = new PrintWriter(out);
                OeResponse res = OeResponseBuilder.buildFailed(e);
                writer.write(JSONObject.toJSONString(res));
                writer.flush();
                writer.close();
            } catch (Exception e1) {
                System.out.println(e1);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
        if (isFilter) {
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.

            Object user = Jwts.parser()
                    .setSigningKey("0faccb886fe0432eae4869eb22a3c8e09eb22a3c8e0")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .get("user");

            if (user != null) {
                LinkedHashMap<String, Object> userVo = (LinkedHashMap<String, Object>) user;
                LinkedHashMap<String, String> role = (LinkedHashMap<String, String>) userVo.get("role");
                List<String> list = new ArrayList<>(1);
                list.add("ROLE_" + role.get("roleName"));
                return new UsernamePasswordAuthenticationToken(user, null, list.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
            }
            return null;
        }
        return null;
    }
}
