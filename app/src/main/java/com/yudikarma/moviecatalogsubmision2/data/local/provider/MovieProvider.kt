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
import com.yudikarma.moviecatalogsubmision2.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.HasContentProviderInjector
import dagger.android.support.HasSupportFragmentInjector
import java.lang.IllegalArgumentException
import java.util.*
import javax.inject.Inject
import android.content.ContentUris
import android.content.ContentValues
import androidx.annotation.NonNull
import android.content.UriMatcher
import android.content.ContentProvider
import android.annotation.SuppressLint
import androidx.annotation.Nullable


@SuppressLint("Registered")
class MovieProvider @Inject constructor() : ContentProvider() {

    private var database: AppDatabase? = null

    override fun onCreate(): Boolean {
        AndroidInjection.inject(this)
        database = AppDatabase.getInstance(context)
        return true
    }

    @Nullable
    override fun query(
        uri: Uri,
        @Nullable projection: Array<String>?,
        @Nullable selection: String?,
        @Nullable selectionArgs: Array<String>?,
        @Nullable sortOrder: String?
    ): Cursor? {

        val code = MATCHER.match(uri)
        if (code == CODE_DIR || code == CODE_ITEM) {
            val context = context ?: return null

            database = AppDatabase.getInstance(context)
            var cursor: Cursor? = null

            if (code == CODE_DIR) {
                cursor = database!!.movieDao().getAll()
                Log.i("test","cursor get")
                if (cursor.moveToFirst()) {

                   Log.i("data cursor",cursor.getString(cursor.getColumnIndexOrThrow(MovieEntity.titled)))
                }
            }
            Objects.requireNonNull(cursor)?.setNotificationUri(context.contentResolver, uri)
            return cursor
        } else {
            throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    @Nullable
    override fun getType(uri: Uri): String? {
        when (MATCHER.match(uri)) {
            CODE_DIR -> return "vnd.android.cursor.dir/$AUTHORITY.Movie"
            CODE_ITEM -> return "vnd.android.cursor.item/$AUTHORITY.Movie"
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    @Nullable
    override fun insert(uri: Uri, @Nullable values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, @Nullable selection: String?, @Nullable selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun update(uri: Uri, @Nullable values: ContentValues?, @Nullable selection: String?, @Nullable selectionArgs: Array<String>?): Int {
        return 0
    }

    companion object {
        val AUTHORITY = "com.yudikarma.moviecatalogsubmision2.data.local.provider"
        val URI_MOVIE = Uri.parse("content://$AUTHORITY/MOVIE")

        private val CODE_DIR = 1
        private val CODE_ITEM = 2

        private val MATCHER = UriMatcher(UriMatcher.NO_MATCH)

        init {
            MATCHER.addURI(AUTHORITY, "MOVIE", CODE_DIR)
            MATCHER.addURI(AUTHORITY, "MOVIE" + "/*", CODE_ITEM)
        }
    }
}