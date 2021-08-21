package com.controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.LideresMayorSalarioDao;
import model.dao.LideresProyectosEmblematicosDao;
import model.dao.MaterialRankeadoImportadoDao;
import vo.LideresMayorSalario;
import vo.LideresProyectosEmblematicos;
import vo.MaterialRankeadoImportado;

//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto5 {

    private final LideresMayorSalarioDao lideresMayorSalarioDao;
    private final LideresProyectosEmblematicosDao lideresProyectosEmblematicosDao;
    private final MaterialRankeadoImportadoDao materialRankeadoImportadoDao;

    public ControladorRequerimientosReto5() {
        this.lideresMayorSalarioDao = new LideresMayorSalarioDao();
        this.lideresProyectosEmblematicosDao = new LideresProyectosEmblematicosDao();
        this.materialRankeadoImportadoDao = new MaterialRankeadoImportadoDao();
    }

    public ArrayList<LideresMayorSalario> consultarLideresMayorSalarios() throws SQLException {
        return this.lideresMayorSalarioDao.rankingLideresMayorSalario();
    }

    public ArrayList<LideresProyectosEmblematicos> consultarLideresProyectosEmblematicos() throws SQLException {
        return this.lideresProyectosEmblematicosDao.rankingProyectosEmblematicos();
    }

    public ArrayList<MaterialRankeadoImportado> consultarMaterialesRankeadosImportados() throws SQLException {
        return this.materialRankeadoImportadoDao.rankingMaterialesImportados();
    }
}
