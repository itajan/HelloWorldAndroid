package edu.cnm.bootcamp.itajan.helloworldandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnHelloWorldAndroid = (Button) findViewById(R.id.btnHelloWorldAndroid);
    btnHelloWorldAndroid.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        TextView textView = (TextView) findViewById(R.id.txtHelloWorldAndroid);
        String text = textView.getText().toString();
        String expected = getString(R.string.message_received);

        if (Objects.equals(text, expected)) {
          textView.setText(R.string.hello_world_android);

        }
        else {
          textView.setText(R.string.message_received);
        }

      }
    });
  }
}
