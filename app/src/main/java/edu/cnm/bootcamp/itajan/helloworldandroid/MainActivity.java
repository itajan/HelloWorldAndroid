package edu.cnm.bootcamp.itajan.helloworldandroid;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import edu.cnm.bootcamp.itajan.helloworldandroid.fragments.MainFragment;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      }

  @Override
  public void onFragmentInteraction(Uri uri) {

  }
}
