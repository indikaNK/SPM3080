/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManager;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 *
 * @author IT17113014
 */
public class DBManager {

 private static DB database;

 public static DB getDatabase() throws UnknownHostException
 {
 if(database == null)
 {
 MongoClient mongo;
 mongo = new MongoClient("localhost", 27017);
 database = mongo.getDB("spm_TimeManager_IT17113014");
 }
 return database;
 }
}

