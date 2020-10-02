/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManage;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;

/**
 *
 *
 */
public class DBManager {

 private static DB database;

 public static DB getDatabase() throws UnknownHostException
 {
 if(database == null)
 {
     try {
         
            MongoClientURI uri = new MongoClientURI(
               "mongodb://Admin:admin@timemanagedbjava-shard-00-00.metey.mongodb.net:27017,timemanagedbjava-shard-00-01.metey.mongodb.net:27017,timemanagedbjava-shard-00-02.metey.mongodb.net:27017/TimeManageDB_java?ssl=true&replicaSet=atlas-7gfq3b-shard-0&authSource=admin&retryWrites=true&w=majority");

           MongoClient mongoClient = new MongoClient(uri);
            database = mongoClient.getDB("TimeManageDB_java");

     } catch (Exception e) {
         System.out.println(e);
     }
 }
 return database;
 }
}

