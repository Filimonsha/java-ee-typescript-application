package com.example.itmoweb2.service.abst;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface HitService {
    public void getHitById(Long id,HttpServletRequest request, HttpServletResponse response);
    public void getAllHits(HttpServletRequest request, HttpServletResponse response);
    public void saveHit(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
