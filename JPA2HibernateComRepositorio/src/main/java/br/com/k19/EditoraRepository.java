/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.k19;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Fabio
 * @version betta 2.0.1
 * @since 11/12/2018
 */
public class EditoraRepository {
    private EntityManager manager;
    
    public EditoraRepository(EntityManager manager){
        this.manager = manager;
    }
    
    public void adciona (Editora e){
        this.manager.persist(e);
    }
    public Editora busca (Long id){
        return this.manager.find(Editora.class, id);
    }
    
    public List<Editora> buscaTodas(){
        Query query = this.manager.createQuery("SELECT e FROM Editora e");
        return query.getResultList();
    }
}
