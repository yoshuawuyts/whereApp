/**
 * Exports
 */

package com.yoshuawuyts.whereapp;

/**
 * Module dependencies
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Save fragment
 * 
 * @api public
 */

public class FragmentList extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_list, container, false);
  }
}
