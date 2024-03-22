package org.taco.tacos.configuration;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;
import org.taco.tacos.Ingredients;
import org.taco.tacos.Taco;
import org.taco.tacos.TacoOrder;

import static java.lang.Boolean.TRUE;

@Slf4j
@org.springframework.context.annotation.Configuration
public class HibernateConfiguration
{
    //campos
    private SessionFactory sessionFactory;

    //construtor
    public HibernateConfiguration()
    {
        log.info("Iniciando configuração do Hibernate");
        try
        {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Ingredients.class)
                    .addAnnotatedClass(Taco.class)
                    .addAnnotatedClass(TacoOrder.class)
                    //H2 database
                    .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:h2:mem:novabase")
                    //Credenciais não são necessárias para o H2 em memória
                    .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "taco-user")
                    .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "123Taco")
                    //Exportação automática do schema
                    .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,
                            Action.SPEC_ACTION_DROP_AND_CREATE)
                    //SQL logging
                    .setProperty(AvailableSettings.SHOW_SQL, TRUE.toString())
                    .setProperty(AvailableSettings.FORMAT_SQL, TRUE.toString())
                    .setProperty(AvailableSettings.HIGHLIGHT_SQL, TRUE.toString())
                    //Criando a nova SessionFactory
                    .buildSessionFactory();
        } catch (RuntimeException exception)
        {
            System.out.printf("%s", exception.getMessage());
        }
    };//fim do construtor

    //Métodos de consulta
    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    };//fim de getSessionFactory();
};//fim de HibernateConfiguration
