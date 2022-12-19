package com.naumov.appconvertfile

class Model  {
    private val conversionFile:ConversionFile = ConversionFileImpl()
    fun getNewFile(pathFile:String):String{
        return conversionFile.conversionFile(pathFile)
    }
}