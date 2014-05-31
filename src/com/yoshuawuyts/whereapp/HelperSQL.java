/**
 * Exports
 */

package com.yoshuawuyts.whereapp;

/**
 * Module dependencies
 */

import java.util.LinkedList;
import java.util.List;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.yoshuawuyts.whereapp.ModelLocation;

/**
 * SQLite helper class.
 */

public class HelperSQL extends SQLiteOpenHelper {
  
  private static final int DATABASE_VERSION = 1;
  private static final String DATABASE_NAME = "LocationDB";

  // Books table name
  private static final String TABLE_LOCATIONS = "LocationModel";

  // Books Table Columns names
  private static final String KEY_ID = "id";
  private static final String KEY_NAME = "name";

  private static final String[] COLUMNS = {KEY_ID,KEY_NAME};

  // creator
  public HelperSQL(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_LOCATION_TABLE = "CREATE TABLE locations"
      + " ( "
      + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
      + "name TEXT"
      + " )";
    
    // create table
    db.execSQL(CREATE_LOCATION_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // drop older table if it existed
    db.execSQL("DROP TABLE IF EXISTS locations");

    // create fresh locations table
    this.onCreate(db);
  }

  /**
   * Add a location to the db.
   * 
   * @param {LocationModel} location
   * @api public
   */
  
  public void addLocation(ModelLocation location) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
  
    values.put(KEY_NAME, location.getName());
    db.insert(TABLE_LOCATIONS, null, values);
  
    Log.d("addLocation", location.toString());
    db.close();
  }
  
  /**
   * Get a location by id.
   * 
   * @param {Integer} id
   * @return {LocationModel}
   * @api public
   */
  
  public ModelLocation getLocation(int id) {
    SQLiteDatabase db = this.getReadableDatabase();
    ModelLocation location = new ModelLocation();
    Cursor cursor = db.query(
      TABLE_LOCATIONS,
      COLUMNS,
      " id = ?", 
      new String[] {String.valueOf(id)},
      null,
      null,
      null,
      null
    );
  
    // if results were fetched, move to first in list
    if (cursor != null) cursor.moveToFirst();
  
    // build a new location object
    location.setId(Integer.parseInt(cursor.getString(0)));
    location.setName(cursor.getString(1));
  
    Log.d("getLocation(" + id + ")", location.toString());
    return location;
  }
  
  /**
   * Get all locations.
   *
   * @return {List}
   * @api public
   */
  
  public List<ModelLocation> getAllLocations() {
    List<ModelLocation> locations = new LinkedList<ModelLocation>();
    String query = "SELECT * FROM " + TABLE_LOCATIONS;
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(query, null);
  
    // iterate over rows, build location and add to list
    ModelLocation location = null;
    if (cursor.moveToFirst()) {
      do {
        location = new ModelLocation();
        location.setId(Integer.parseInt(cursor.getString(0)));
        location.setName(cursor.getString(1));
        locations.add(location);
      } while (cursor.moveToNext());
    }
  
    Log.d("getAllLocations()", locations.toString());
    return locations;
  }
  
  /**
   * Update location at id.
   *
   * @param {LocationModel} location
   * @return {Integer}
   * @api public
   */
  
  public int updateLocation(ModelLocation location) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
  
    values.put("name", location.getName());
  
    int i = db.update(
      TABLE_LOCATIONS,
      values,
      KEY_ID + " = ?",
      new String[] {String.valueOf(location.getId())}
    );
  
    Log.d("updateLocation", location.toString());
    db.close();
    return i;
  }
  
  /**
   * Delete a location from DB.
   *
   * @param {LocationModel} location
   * @api public
   */
  
  public void deleteLocation(ModelLocation location) {
    SQLiteDatabase db = this.getWritableDatabase();
  
    db.delete(
      TABLE_LOCATIONS,
      KEY_ID + " = ?",
      new String[] {String.valueOf(location.getId())}
    );
  
    Log.d("deleteLocation", location.toString());
    db.close();
  }
  
}