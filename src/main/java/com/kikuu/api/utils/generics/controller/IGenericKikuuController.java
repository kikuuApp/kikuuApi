package com.kikuu.api.utils.generics.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kikuu.api.utils.json.KikuuPayload;


public interface IGenericKikuuController<T,S,N>{
    

    public KikuuPayload<T> register( T doc, HttpServletRequest req, HttpServletResponse resp)throws Exception;
    public KikuuPayload<S> update(T doc, HttpServletRequest req, HttpServletResponse resp)throws Exception;
    public KikuuPayload<S> delete(T doc, HttpServletRequest req, HttpServletResponse resp)throws Exception;
    public KikuuPayload<S> delete( String id)throws Exception;
    public KikuuPayload<T> find(T doc);
    public KikuuPayload<T> find( String id);
    public KikuuPayload<T> findAll(Integer from, Integer to);
    public KikuuPayload<N> count();
}