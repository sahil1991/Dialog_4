package com.example.lenovo.dialog_2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {
Button b1,okay,cancel;
    EditText e1;
    int n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.dialog);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 open(view);

            }
        });




            }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.prompt, null);



        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        AlertDialog alertDialog3=alertDialogBuilder.create();
        alertDialog3.show();
        e1=(EditText)alertDialog3.findViewById(R.id.number);
        okay=(Button) alertDialog3.findViewById(R.id.okay);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTaskRunner process2=new AsyncTaskRunner();
                String n=e1.getText().toString();
                process2.execute(n);


            }
        });
        cancel=(Button)alertDialog3.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });




           }
    private class AsyncTaskRunner extends AsyncTask<String, String, Void> {
        private String resp;


        @Override
        protected Void doInBackground(String... strings) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                // Do your long operations here and return the result
                int time = Integer.parseInt(strings[0]);
                // Sleeping for given time period
                Thread.sleep(time);
                resp = "Slept for " + time + " milliseconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            super.onProgressUpdate(values);
            final ProgressDialog progress = new ProgressDialog(MainActivity.this);
            progress.setTitle("please Wait");

            progress.show();


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            super.onPostExecute(aVoid);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setTitle("Successful");
            alertDialogBuilder.setMessage("completed");




            alertDialogBuilder.setNegativeButton("ok",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }


    }


        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
         */



