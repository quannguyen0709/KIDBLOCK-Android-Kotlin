package com.example.kidlock.persentation.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


//data class PInfor(
//    val appname = "",
//    val pname = "",
//    val versionName = "",
//    val versionCode = 0,
//    val Drawable icon
//)

fun getBitmapFromDrawable (drawable: Drawable): Bitmap {
    val bmp = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas: Canvas = Canvas(bmp)
    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
    drawable.draw(canvas)
    return bmp
}

suspend fun getApplicationInstalled(context: Context): ArrayList<ApplicationInfo>{
     val apps = GlobalScope.async { context.packageManager.getInstalledApplications(0) }
     val listAppInstalled :ArrayList<ApplicationInfo> = arrayListOf()
     GlobalScope.launch(Dispatchers.IO) {
         apps.await().forEach {
             launch {
                 if(!it.name.isNullOrBlank() && it.icon != 0 && it.icon != null){
                     listAppInstalled.add(it)
                 }
             }
         }
     }.join()
     return listAppInstalled
}

suspend fun getApplicationsIcon(context: Context, listApplicationInfor: ArrayList<ApplicationInfo>): ArrayList<Drawable>{
    val listApplicationIcon: ArrayList<Drawable> = arrayListOf()
   GlobalScope.launch {
       listApplicationInfor.forEach{
           launch {
               val drawable = async { context.packageManager.getApplicationIcon(it.packageName) }.await()
               listApplicationIcon.add(drawable)
           }
       }
   }.join()
    return listApplicationIcon
}

suspend fun getApplicationInstalledLabbel(context: Context, applicationsInfo: ArrayList<ApplicationInfo>): ArrayList<String>{
    val labelApplications : ArrayList<String> = arrayListOf()
    GlobalScope.launch {
        applicationsInfo.forEach {
            launch {
                labelApplications.add(async { context.packageManager.getApplicationLabel(it).toString() }.await())
            }
        }
    }.join()
    return labelApplications
}

fun getBitmapFromString (base64: String ): Bitmap{
    val decodedString: ByteArray = Base64.decode(base64, Base64.DEFAULT)
    val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    return decodedByte
}

fun getStringFromBitmap(bitmapPicture: Bitmap): String {
    val COMPRESSION_QUALITY = 100
    val encodedImage: String
    val byteArrayBitmapStream = ByteArrayOutputStream()
    bitmapPicture.compress(
        CompressFormat.PNG, COMPRESSION_QUALITY,
        byteArrayBitmapStream
    )
    val b = byteArrayBitmapStream.toByteArray()
    encodedImage = Base64.encodeToString(b, Base64.DEFAULT)
    return encodedImage
}

fun writeImageInDir(dirPath: String, imageByBitmap: Bitmap, context: Context, nameFile: String): Boolean{
    try {
        val pathDirApp = context.packageManager.getApplicationInfo(context.packageName, 0).dataDir
        val file: File = File(pathDirApp +  dirPath +  nameFile +".png")
        val fOut = FileOutputStream(file)
        imageByBitmap.compress(CompressFormat.PNG, 100, fOut)
        fOut.close()
        return true
    }catch (e: Exception){
        return false
    }
}