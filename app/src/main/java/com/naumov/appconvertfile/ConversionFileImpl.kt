package com.naumov.appconvertfile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.FileOutputStream

class ConversionFileImpl : ConversionFileInterface {
    override fun conversionFile(path: String, callbaclConversion: MainPresenter.callbaclConversion) {
        Thread.sleep(3000)

        if (path.isEmpty()) {
            callbaclConversion.onError(NullPointerException())
        }
        val pathNew = path.replace(".jpg", ".png", true)

        try {
            val uri = Uri.parse(path)
            val inputStreem = App().contentResolver.openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStreem)

            val fileout: FileOutputStream = FileOutputStream(pathNew)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileout)
            callbaclConversion.onSucces(pathNew)

        } catch (e: NullPointerException) {
            callbaclConversion.onError(e)
        }

    }
}
