package com.example.myapplication.view

import com.example.myapplication.data.RepositoryClient
import com.example.myapplication.logic.Controller
import com.example.myapplication.logic.interfac.OperationsInterface

class Dialog(var controller: Controller) {
    private var listener: OperationsInterface? = null

    private var action : Int = 0

    //Carga el listener para el botón
    fun setListener ( _listener : OperationsInterface){
        listener = _listener

    }

    fun show(typeAction : Int){
        listener?.let{
            val posibleName = "CAMBIADO"
            val posibleId = controller.devIdRandom()
            when (typeAction){
                0 -> onAccept()

                1 ->
                    if (posibleId != -1)
                        onEdit(posibleId, "CAMBIADO")

                2 ->
                    if (posibleId != -1)
                        onDelete(posibleId)

            }

        }
    }

    private fun onDelete(id : Int) {
        listener!!.ClientDel(id)
    }

    private fun onEdit(id: Int, name : String) {
        listener!!.ClientUpdate(id, name)
    }

    private fun onAccept() {
        listener!!.ClientAdd(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE", "NUEVO APELLIDO", 123456789
        )
    }
    
}