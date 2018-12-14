/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.k19;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fabio
 * @version betta 2.0.1
 * @since 11/12/2018
 */
public class ListaEditoraJPA {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("livraria-pu");
        
        EntityManager manager = factory.createEntityManager();
        
        //Query query = manager.createQuery("SELECT e FROM Editora e");
        //List<Editora> editoras = query.getResultList();
        
        //chamando os metodos da classe de repositorio
        EditoraRepository eRep = new EditoraRepository(manager);
        List<Editora> editoras = eRep.buscaTodas();
        
        System.out.println("\nLISTA DE EDITORAS.!!\n");
        for(Editora e : editoras){            
            System.out.println("Editora: "+e.getNome()+" - "+"E-mail: "+
                    e.getEmail()+" - "+"Codigo: "+e.getId());
            
        }
        System.out.println("");
        manager.close();
        factory.close();
    }//main
}//classe
