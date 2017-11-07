package com.skynoff.smapp2018.background.database

import android.content.Context

/**
 * Created by cesar.smith on 11/1/2017.
 */
class SQLiteManager(context: Context,var helper: SQLiteHelper = SQLiteHelper(context)) {




 /*   val tablaSecciones: String? = "secciones"
    val tablaLecciones: String? = "lecciones"
    val tablaAsignaturas: String? = "asignaturas"

    private val id = "id"
    private val nombre = "nombre"
    private val asignatura = "asignatura"


    private val leccion = "leccion"
    private val contenido = "contenido"*/

    companion object {


        val tablaSecciones: String? = "secciones"
        val tablaLecciones: String? = "lecciones"
        val tablaAsignaturas: String? = "asignaturas"

        private val id = "id"
        private val nombre = "nombre"
        private val asignatura = "asignatura"


        private val leccion = "leccion"
        private val contenido = "contenido"
        val crearTablaLecciones = "CREATE TABLE $tablaLecciones (\n\t$id\tINTEGER,\n\t$leccion\tTEXT,\n\t$contenido\tTEXT,\n\tPRIMARY KEY($id)\n);"
        val crearTablaAsignaturas = "CREATE TABLE $tablaAsignaturas (\n\t$nombre\tTEXT,\n\t$id\tINTEGER,\n\tPRIMARY KEY($id)\n);"
        val crearTablaSecciones = "CREATE TABLE " + tablaSecciones + " (\n" +

                "\t" + id + "\tINTEGER,\n" +
                "\t" + nombre + "\tTEXT,\n" +
                "\t" + asignatura + "\tINTEGER,\n" +
                "\tPRIMARY KEY(" + id + ")\n" +
                ");"
    }






}


