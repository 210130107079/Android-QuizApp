package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "What is the purpose of the <html> tag in HTML?",
            "Which HTML tag is used to define a hyperlink?",
            "What is the difference between the <br> and <p> tags in HTML?",
            "How do you define a CSS style in HTML?",
            "What is the purpose of the <head> tag in HTML?",
            "Which HTML tag is used to define a list?",
            "What is the difference between the <strong> and <b> tags in HTML?",
            "How do you add an image to an HTML page?",
            "What is the purpose of the <body> tag in HTML?",
            "Which HTML tag is used to define a table?"
    };
    String answers[] = {
            "To define the structure of an HTML document",
            "<a>",
            "<br> is used for a line break, <p> is used for a paragraph",
            "Using the <style> tag", "Using the <script> tag",
            "To define the title of an HTML document",
            "<ul>",
            "<strong> is used for bold text, <b> is used for italic text",
            "Using the <img> tag",
            "To define the content of an HTML document",
            "<table>",
    };
    String opt[] = {
            "To define the structure of an HTML document", "To add styles to an HTML document", "To add scripts to an HTML document", "To add images to an HTML document",
            "<a>", "<link>", "<img>", "<button>",
            "<br> is used for a line break, <p> is used for a paragraph", "<br> is used for a paragraph, <p> is used for a line break", "<br> is used for a heading, <p> is used for a paragraph", "<br> is used for a paragraph, <p> is used for a heading",
            "Using the <style> tag", "Using the <script> tag", "Using the <link> tag", "Using the <img> tag",
            "To define the title of an HTML document", "To define the styles of an HTML document", "To define the scripts of an HTML document", "To define the structure of an HTML document",
            "<ul>", "<ol>", "<li>", "<table>",
            "<strong> is used for bold text, <b> is used for italic text", "<strong> is used for italic text, <b> is used for bold text", "<strong> is used for underlined text, <b> is used for bold text", "<strong> is used for bold text, <b> is used for underlined text",
            "Using the <img> tag", "Using the <picture> tag", "Using the <figure> tag", "Using the <figcaption> tag",
            "To define the content of an HTML document", "To define the styles of an HTML document", "To define the scripts of an HTML document", "To define the structure of an HTML document",
            "<table>", "<tr>", "<td>", "<th>",
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}