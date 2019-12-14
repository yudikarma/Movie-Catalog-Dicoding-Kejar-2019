package com.yudikarma.moviecatalogsubmision2.data.local.provider

import android.content.*
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.yudikarma.moviecatalogsubmision2.MovieCatalogApp
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.di.component.AppComponent
import dagger.android.AndroidInjection
import dagger.android.HasContentProviderInjector
import dagger.android.support.HasSupportFragmentInjector
import java.lang.IllegalArgumentException
import java.util.*
import javax.inject.Inject

class MovieProvider @Inject constructor() : ContentProvider() {

    @Inject
    internal lateinit var repository: Repository

    companion object {
        const val AUTHORITY:String = "com.yudikarma.moviecatalogsubmision2.data.local.provider"
        val URI_CHEESE:Uri = Uri.parse("content://" + AUTHORITY + "/" + MovieEntity.TABLE_NAME)
        /** The match code for some items in the Cheese table.  */
        private val CODE_CHEESE_DIR = 1

        /** The match code for an item in the Cheese table.  */
        private val CODE_CHEESE_ITEM = 2
    }

    var MATCHER:UriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    init {
        MATCHER.addURI(AUTHORITY,MovieEntity.TABLE_NAME, CODE_CHEESE_DIR )
        MATCHER.addURI(AUTHORITY,MovieEntity.TABLE_NAME+"/*", CODE_CHEESE_ITEM)

    }

    override fun onCreate(): Boolean {
         AndroidInjection.inject(this)
        return true
    }






    override fun getType(uri: Uri): String? {
        when(MATCHER.match(uri)){
            CODE_CHEESE_DIR -> return "vnd.android.cursor.dir/" + AUTHORITY + "." + MovieEntity.TABLE_NAME
            CODE_CHEESE_ITEM -> return "vnd.android.cursor.item/" + AUTHORITY + "." + MovieEntity.TABLE_NAME
            else -> throw IllegalArgumentException("Unknow Uri Type : "+uri)
        }
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        /*var uri:Uri? = null
       when(MATCHER.match(uri)){
           CODE_CHEESE_DIR -> {
               context?.let {
                   values?.let {values ->
                       val id = repository.getInstanceAppDatabase().getInstance(it).movieDao().insertMovie(MovieEntity.fromContentValues(values))
                       context.contentResolver.notifyChange(uri,null)
                       uri = ContentUris.withAppendedId(uri,id)
                   }
               }
           }

            CODE_CHEESE_ITEM -> {
                throw IllegalArgumentException("Invalid URI, cannot insert with ID: " + uri)
            }
            else ->
                throw IllegalArgumentException("Unknow URI, cannot insert with ID: " + uri)
        }
        return uri*/
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {
        val code  = MATCHER.match(uri)
        if (code == CODE_CHEESE_DIR || code == CODE_CHEESE_ITEM){
           if (context == null){
               Log.e("Movie Provider","Context null")
           }
            var cursor:Cursor? = null

            if (code == CODE_CHEESE_DIR){
                cursor = repository.getInstanceAppDatabase().movieDao().getAll()
            }else{

            }

            cursor?.setNotificationUri(context.contentResolver,uri)
            return cursor
        }else{
            throw IllegalArgumentException("Unknow Uris : "+uri)
        }
    }



    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        var count:Int = 0
        /*when(MATCHER.match(uri)){
            CODE_CHEESE_DIR -> throw IllegalArgumentException("Invalid URI, cannot update without ID "+uri)

            CODE_CHEESE_ITEM -> {
                if (context == null){
                    return 0
                }
                val movieEntity = MovieEntity.fromContentValues(values!!)
                movieEntity.id  = ContentUris.parseId(uri)
                count = repository.getInstanceAppDatabase().getInstance(context).movieDao().updateMovie(movieEntity)
                context.contentResolver.notifyChange(uri,null)
            }
            else -> throw IllegalArgumentException("Invalid URI, cannot update without ID "+uri)
        }*/
        return  count
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        var count:Int = 0
        /*when(MATCHER.match(uri)){
            CODE_CHEESE_DIR -> throw IllegalArgumentException("Invalid URI, cannot update without ID "+uri)

            CODE_CHEESE_ITEM -> {
                if (context == null){
                    return 0
                }
                count = repository.getInstanceAppDatabase().getInstance(context).movieDao().deleteById(ContentUris.parseId(uri))
                context.contentResolver.notifyChange(uri,null)
            }
        }*/
        return  count
    }

    fun deferInit(){
       // AndroidInjection.inject(this)

    }

}