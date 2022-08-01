package com.loyal.prueba.service.impl;

import com.loyal.prueba.service.MovieService;
import com.loyal.prueba.service.RunScript;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public String[] getMovieTitles(String substr) {
        RunScript runScript = new RunScript();
        return runScript.runScript(substr);
    }
}