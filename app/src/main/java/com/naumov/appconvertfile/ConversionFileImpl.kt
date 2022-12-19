package com.naumov.appconvertfile

class ConversionFileImpl:ConversionFile {
    override fun conversionFile(path: String): String {
        Thread.sleep(3000)
        return "new file"
    }
}