/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.database.impl

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import de.rexlmanu.manuapi.database.DatabaseSelection
import de.rexlmanu.manuapi.database.SimpleDatabase
import org.bson.Document


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 07.07.2018 / 06:58
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class MongoDBDatabase(override val database: String, override val host: String, override val port: Int) : SimpleDatabase, DatabaseSelection {

    lateinit var mongoClient: MongoClient
    lateinit var mongoDatabase: MongoDatabase

    override fun databaseSelection() {
        mongoDatabase = mongoClient.getDatabase(database)
    }

    override fun connect() {
        mongoClient = MongoClient(host, port)
    }

    override fun disconnect() {
        mongoClient.close()
    }

    override fun reconnect() {
        disconnect()
        connect()
    }

    fun getCollection(collectionName: String): MongoCollection<Document> = mongoDatabase.getCollection(collectionName)

}