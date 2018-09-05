/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.controller;

import bus.pomocno.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Matej
 * @param <T> bilo koji entitet mapiran putem ORM-a
 */
public class Obrada<T> {

    private final Session session;

    public Obrada() {
        session = HibernateUtil.getSession();
    }

    //Create ili Update ili Delete jer imamo atribut delete
    public T save(T entitet) {
        session.beginTransaction();
        session.saveOrUpdate(entitet);
        session.getTransaction().commit();
        return entitet;
    }

    //Read
    @Deprecated
    public List<T> createQuery(String hql) {
        Query q = session.createQuery(hql);
        return q.list();
    }

    //Delete
    public void delete(T entitet) {
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }

    public List<T> save(List<T> lista) {
        session.beginTransaction();
        lista.stream().forEach((entitet) -> {
            session.saveOrUpdate(entitet);
        });
        session.getTransaction().commit();
        return lista;
    }

}
