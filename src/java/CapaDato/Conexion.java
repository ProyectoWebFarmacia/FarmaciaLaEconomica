
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDato;
//import com.mongodb.*;
 import com.mongodb.MongoClient;
 import com.mongodb.MongoException;
 import com.mongodb.WriteConcern;
 import com.mongodb.DB;
 import com.mongodb.DBCollection;
 import com.mongodb.BasicDBObject;
 import com.mongodb.DBObject;
 import com.mongodb.DBCursor;
 import com.mongodb.ServerAddress;
 import java.util.Arrays;
import java.net.UnknownHostException;
import java.util.Set;
/**
 *
 * @author Gabriel
 */
public class Conexion 
{
    // Conexion por defecto a localhost por el puerto 27017
    public static void main (String [] Args) throws UnknownHostException {
        try 
        {
            // Para conectarse al servidor MongoDB
            MongoClient conexion = new MongoClient("localhost",27017);
            // Ahora conectarse a bases de datos
            DB ejemplo = conexion.getDB("Ejemplo");
            System.out.println("Conectarse a la base de datos exitoso");
            DBCollection coleccion = ejemplo.getCollection("Alumno");
//             Set<String> collectionNames = ejemplo.getCollectionNames();
//            for (final String s : collectionNames) 
//            {
//            System.out.println(s);
//            }
            //Para consultar otro método
            Object objeto = new Object();
            objeto = "null,{nombre:1}";
            DBCursor cursor = coleccion.find();
            
            try {
            while (cursor.hasNext()) {
            System.out.println(cursor.next());
            }
            } finally {
            cursor.close();
            }

            //DBObject doc = coleccion.findOne();
            
            //Para consultar
            //DBCursor cursor = coleccion.find ();
            //System.out.println(cursor);
//            int i = 1;
//          while (cursor.hasNext ()) 
//          { 
//             System.out.println ("insertado documento:" + i); 
//             System.out.println (cursor.next ()); 
//             i ++;
//          }
            

        } catch (Exception e) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    
    
    }
}
