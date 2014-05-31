/**
 * Exports
 */

package com.yoshuawuyts.whereapp;

/**
 * Module dependencies
 */

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

/**
 * Home fragment
 */

public class FragmentHome extends Fragment {

  public FragmentHome() {}

  /**
   * Lifecycle: onCreateView
   *
   * @param {LayoutInflater} inflater
   * @param {ViewGroup} container
   * @param {Bundle} savedInstanceState
   * @return {View}
   * @api private
   */

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);
    return rootView;
  }
}