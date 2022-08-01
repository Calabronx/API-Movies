package com.loyal.prueba.service;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejecuta el script sql, iterando la data de la tabla y ingresandola en una lista, para devolverla en una HTTP GET
 */
@Service
@Component
public class RunScript {

    private String[] movie_titles;

    public String[] runScript(String title) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            String mysqlUrl = "jdbc:mysql://localhost:3306/db_example";
            String getStatement = "SELECT MovieTitles from Movies";
            Connection conn = DriverManager.getConnection(mysqlUrl, "root", "Biohazard_1");
            System.out.println("Connection established...");

            ScriptRunner scriptRun = new ScriptRunner(conn);

            Reader reader = new BufferedReader(new FileReader("C:\\Users\\sebic\\IdeaProjects\\testingreso\\src\\main\\resources\\departmentSummary.sql"));

            scriptRun.runScript(reader);

            movie_titles = getData(conn, title);

        } catch (SQLException e) {
            System.out.println("SQLEXCEPTION was thrown");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException was thrown");
        }
        return movie_titles;
    }

    public static String[] getData(Connection conn, String titlesMovies) {
        PreparedStatement stmt;
        List<String> titlesList = new ArrayList<>();
        String[] titlesElement = new String[10];


        String stmtSelect = "SELECT MovieTitles from Movies";

        try {
            stmt = conn.prepareStatement(stmtSelect);

            ResultSet myRs = stmt.executeQuery();

            while (myRs.next()) {
                String title = myRs.getString("MovieTitles");
                titlesList.add(title);
                //titlesElement[index] = titlesList.get(index);
            }
            titlesElement = new String[titlesList.size()];


            for (int i = 0; i < titlesList.size(); i++) {
                titlesMovies = titlesList.get(i);
                titlesElement[i] = titlesMovies;
                System.out.println(titlesMovies);
            }

            for (int i = 0; i < titlesElement.length; i++) {
                if (titlesElement[i] == null) {
                    break;
                }
                String title = titlesElement[i];
                System.out.println(title);
            }

            System.out.println("Titles of movies: " + titlesList.toString());

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database error");
        }
        return titlesElement;
    }
}