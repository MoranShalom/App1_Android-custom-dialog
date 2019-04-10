// In this tutorial you will learn how to create Android custom dialog.
// We will start first by creating AlertDialog using AlertDialog builder, and then we will
// design an XML resource layout file that we will use later for the custom alertdialog.
//
// for a custom Dialog we need to create a separate layout- we will call this layout - dialog_layout !!!

package com.example.tutorial1_androidcustomdialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // main layout
    private Button showDialog;

    // login_layout
    private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;


    // AlertDialog view
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.btnShowDialog);


        showDialog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //  create the dialog
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                // create a View to  inflate the layout we just created -  (resource file, we dont have a view group so we will leave it null - root= null
                View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
                // defined the views inside the dialog layout - so we will need to add this mView that created for dialog_layout
                mEmail= (EditText) mView.findViewById(R.id.etEmail);
                mPassword= (EditText) mView.findViewById(R.id.etPassword);
                mLogin= (Button) mView.findViewById(R.id.btnLogin);

                    // create a Toast message that appear if on of the field is empty
                    // if the user will not input data to on of the fields (email or password) the toast will appear
                    mLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()) {
                                Toast.makeText(MainActivity.this,
                                        getString(R.string.successful_login_message),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this,
                                        getString(R.string.error_login_message),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    //in order tp popup the dialog window on the screen
                    // we need to set the View for the layout- we need to reference the mBuilder to mView
                    mBuilder.setView(mView);  // with out this line the dialog will not be popped up on the screen

                    // show the AlertDialog
                     dialog= mBuilder.create();
                     dialog.show();


            }
        });


    }
}
