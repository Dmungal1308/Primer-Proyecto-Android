package com.example.myapplication.logic.interfac

interface OperationsInterface {
    fun ClientAdd(id : Int, name : String)
    fun ClientDel(id : Int)
    fun ClientUpdate(id : Int, name : String)
}