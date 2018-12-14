/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.k19;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fabio
 * @version betta 2.0
 * @since 11/12/2018
 */
public class InsereEditoraJPA {
    public static void main(String[] args) {
        EntityManagerFactory factory = 
                Persistence.createEntityManagerFactory("livraria-pu");
        EntityManager manager = factory.createEntityManager();
        
        Editora e = new Editora();
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o nome da editora: ");
        e.setNome(entrada.nextLine());
        
        System.out.println("digite o email da editora: ");
        e.setEmail(entrada.nextLine());
        
        manager.persist(e);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
    }
}
