package com.example.myapplication.view

import Dialog
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.data.RepositoryClient
import com.example.myapplication.logic.Client

class MainActivity : AppCompatActivity() {
    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog: Dialog
    private lateinit var myListClient: MutableList<Client>

    companion object {
        const val TAG = "---SALIDA---"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Esto es un ejemplo de log")
        myListClient = RepositoryClient.arrayClient.toMutableList()
        start()
    }

    // Aquí comienza todo. Como si fuera nuestro main
    private fun start() {
        myButtonAdd = findViewById(R.id.iv_add)
        myButtonUpdate = findViewById(R.id.iv_update)
        myButtonDel = findViewById(R.id.iv_del)

        myDialog = Dialog().apply {
            setOnAddListener { id, name, apellidos, telefono ->
                val newClient = Client(id, name, apellidos, telefono)
                myListClient.add(newClient)  // Agregamos el nuevo cliente a la lista
                Log.d(TAG, "El cliente con id = $id, ha sido insertado correctamente")
                showConsoleData()  // Mostrar datos actualizados
            }

            setOnUpdateListener { id, name, apellidos, telefono ->
                val findClient: Client? = myListClient.find { it.id == id }
                if (findClient != null) {
                    findClient.name = name
                    findClient.apellidos = apellidos
                    findClient.telefono = telefono
                    Log.d(TAG, "El cliente con id = $id, ha sido actualizado correctamente")
                } else {
                    Log.d(TAG, "El cliente con id = $id, no ha sido encontrado para actualizar")
                }
                showConsoleData()
            }

            setOnDeleteListener { id ->
                val wasDeleted = myListClient.removeAll { it.id == id }
                if (wasDeleted) {
                    Log.d(TAG, "El cliente con id = $id, ha sido eliminado correctamente")
                } else {
                    Log.d(TAG, "El cliente con id = $id, no ha sido encontrado para eliminar")
                }
                showConsoleData()
            }
        }

        myButtonAdd.setOnClickListener {
            myDialog.show(0)
        }

        myButtonUpdate.setOnClickListener {
            val clientIdToUpdate = RepositoryClient.primary - 1
            myDialog.show(1, clientIdToUpdate)
        }

        myButtonDel.setOnClickListener {
            val clientIdToDelete = RepositoryClient.primary - 1
            myDialog.show(2, clientIdToDelete)
        }

    }

    private fun showConsoleData() {

        val msg = myListClient.joinToString { "ID: ${it.id}, Nombre: ${it.name}, Apellidos: ${it.apellidos}, Teléfono: ${it.telefono}" }
        Log.d(TAG, "Lista de Clientes: $msg")
    }
}
