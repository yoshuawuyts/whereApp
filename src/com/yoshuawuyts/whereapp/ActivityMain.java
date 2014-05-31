package com.yoshuawuyts.whereapp;

// import android.widget.Button;
import android.view.MenuItem;
import android.app.Activity;
// import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
// import android.os.Build;

public class ActivityMain extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    if (savedInstanceState == null) {
      getFragmentManager()
        .beginTransaction()
        .add(R.id.container, new FragmentHome())
        .commit();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater()
      .inflate(R.menu.main, menu);
    
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  public void handleClick(View view) { 
    if(view.getId() == R.id.saveButton){
      getFragmentManager()
        .beginTransaction()
        .add(R.id.container, new FragmentSave())
        .addToBackStack(null)
        .commit();
    }

    if(view.getId() == R.id.findButton){
      getFragmentManager()
        .beginTransaction()
        .add(R.id.container, new FragmentList())
        .addToBackStack(null)
        .commit();
    }
  }
}