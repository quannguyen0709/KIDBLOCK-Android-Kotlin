package com.example.kidlock.persentation.views.mainscreen

import android.content.Context
import android.content.pm.ApplicationInfo
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.kidlock.persentation.navigation.NavigationApplication
import com.example.kidlock.persentation.utils.getApplicationInstalled
import com.example.kidlock.persentation.utils.getApplicationInstalledLabbel
import com.example.kidlock.persentation.utils.getApplicationsIcon
import com.example.kidlock.persentation.utils.getBitmapFromDrawable
import com.example.kidlock.persentation.utils.writeImageInDir
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject
import kotlin.system.measureTimeMillis

@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {
    lateinit var navControllerApplication: NavController
    lateinit var listAppInstalledLabel : ArrayList<String>
    val listAppInstalledIcon : ArrayList<Bitmap> = arrayListOf()
     var checkWirteCorrect: MutableLiveData<Boolean> = MutableLiveData(false)
    val dirImage  = "/fileIconApplicationInstalled/"
    fun controllerNavApplication(controller: NavController){
        navControllerApplication = NavigationApplication(navController = controller).navigationApplication()
    }



    suspend fun test(context: Context){

        GlobalScope.launch(Dispatchers.IO) {
            val listApplication: Deferred<ArrayList<ApplicationInfo>> = async { getApplicationInstalled(context) }
            val a = async { getApplicationsIcon(context,listApplication.await()) }
            val b = async { getApplicationInstalledLabbel(context, listApplication.await()) }
            a.await().forEach {
                launch {
                    listAppInstalledIcon.add(getBitmapFromDrawable(it))
                }
            }
            listAppInstalledLabel = b.await()
        }.join()
    }

     suspend fun testWrite(context: Context){
        val pathDirApp =  context.packageManager.getApplicationInfo(context.packageName, 0).dataDir
         File(pathDirApp , "fileImageIconApp").mkdirs()
        val dirImage  = "/fileImageIconApp/"
         val test = measureTimeMillis {
             GlobalScope.launch(Dispatchers.IO) {
                 for (i in 0..listAppInstalledIcon.size - 1) {
                     launch {
                         writeImageInDir(
                             dirPath = dirImage,
                             imageByBitmap = listAppInstalledIcon.get(i),
                             context = context,
                             nameFile = listAppInstalledLabel.get(i)
                         )
                     }
                 }
             }.join()
         }
         Log.e("corutine write is completed", "time write is " + test.toString() + "ms")
    }
    fun clear(){
        listAppInstalledIcon.clear()
    }

    fun printTest(){
        println(listAppInstalledLabel)
    }
}