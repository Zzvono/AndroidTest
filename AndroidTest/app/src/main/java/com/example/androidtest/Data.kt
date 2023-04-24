package com.example.androidtest
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class Data(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private var context: Context? = context

    companion object {
        private const val DATABASE_NAME = "data.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "runner"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_NAME = "runner_name"
        private const val COLUMN_STEPS = "runner_steps"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME TEXT, $COLUMN_STEPS INTEGER);"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addHighScore(runner_name: String?, runner_steps: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_NAME, runner_name)
        cv.put(COLUMN_STEPS, runner_steps)
        val result = db.insert(TABLE_NAME, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added successfully !", Toast.LENGTH_SHORT).show()
        }
    }
}