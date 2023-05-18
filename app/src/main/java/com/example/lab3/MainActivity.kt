package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zero = findViewById<Button>(R.id.btnZero)
        val one = findViewById<Button>(R.id.btnOne);
        val two = findViewById<Button>(R.id.btnTwo);
        val three = findViewById<Button>(R.id.btnThree);
        val four = findViewById<Button>(R.id.btnFour);
        val five = findViewById<Button>(R.id.btnFive);
        val six = findViewById<Button>(R.id.btnSix);
        val seven = findViewById<Button>(R.id.btnSeven);
        val eight = findViewById<Button>(R.id.btnEight);
        val nine = findViewById<Button>(R.id.btnNine);

        val ac = findViewById<Button>(R.id.btnAC);
        val divide = findViewById<Button>(R.id.btnDivide);
        val multi = findViewById<Button>(R.id.btnMultiply);
        val minus = findViewById<Button>(R.id.btnMinus);
        val plus = findViewById<Button>(R.id.btnPlus);
        val comma = findViewById<Button>(R.id.btnComma);
        val percent = findViewById<Button>(R.id.btnSignChange);
        val equals = findViewById<Button>(R.id.btnEquals);
        val minusPlus = findViewById<Button>(R.id.btnPlusMinus);
        val texts = findViewById<TextView>(R.id.mainText);
        var caseA = 0.0;
        var caseB = 0.0;
        var caseZn = "";
        var caseCheckingForText= "";

        fun setTextFields(str: String){
            val ffff = findViewById<TextView>(R.id.mainText).text.toString();
            if (caseCheckingForText == "" && (ffff != "0" || str == ".")) {
                texts.text = ffff+str
            }
            else{
                texts.text = str
                caseCheckingForText = ""
            }
        }

        fun znack(str: String){
            caseA = texts.text.toString().toDouble()
            caseZn = str
            caseCheckingForText = str
        }

        nine.setOnClickListener{ setTextFields("9") }
        eight.setOnClickListener{ setTextFields("8") }
        seven.setOnClickListener{ setTextFields("7") }
        six.setOnClickListener{ setTextFields("6") }
        five.setOnClickListener{ setTextFields("5") }
        four.setOnClickListener{ setTextFields("4") }
        three.setOnClickListener{ setTextFields("3") }
        two.setOnClickListener{ setTextFields("2") }
        one.setOnClickListener{ setTextFields("1") }
        zero.setOnClickListener{ setTextFields("0") }
        comma.setOnClickListener{
            if (!("." in texts.text.toString())){
                setTextFields(".")
            }
        }
        plus.setOnClickListener{ znack("+") }
        minus.setOnClickListener{ znack("-") }
        multi.setOnClickListener{ znack("*") }
        divide.setOnClickListener{ znack("/") }

        ac.setOnClickListener{
            texts.text = "0"
        }

        percent.setOnClickListener {
            if (texts.text != "0"){
                texts.text = (texts.text.toString().toDouble() / 100).toString();
            }
        }
        minusPlus.setOnClickListener {
            val c = -1*texts.text.toString().toDouble()
            texts.text = CheckForInt(c).toString()
        }

        equals.setOnClickListener{
            try {
                if (caseZn == "+"){
                    caseB = texts.text.toString().toDouble()
                    var caseC = caseA+caseB
                    texts.text = CheckForInt(caseC).toString();
                    caseZn = "="
                    caseCheckingForText = "="
                }
                else if (caseZn == "-"){
                    caseB = texts.text.toString().toDouble()
                    var caseC = caseA-caseB
                    texts.text = CheckForInt(caseC).toString();
                    caseZn = "="
                    caseCheckingForText = "="
                }else if (caseZn == "*"){
                    caseB = texts.text.toString().toDouble()
                    var caseC = caseA*caseB
                    texts.text = CheckForInt(caseC).toString();
                    caseZn = "="
                    caseCheckingForText = "="
                }else if (caseZn == "/"){
                    caseB = texts.text.toString().toDouble()
                    if (caseB==0.0 && caseA!=0.0){
                        texts.text = "Ошибка";
                        caseZn = "="
                        caseCheckingForText = "="
                    }else {
                        var caseC = caseA / caseB
                        texts.text = CheckForInt(caseC).toString();
                        caseZn = "="
                        caseCheckingForText = "="
                    }
                }else{
                    texts.text = "Ошибка";
                    caseZn = "="
                    caseCheckingForText = "="
                }
            }
            catch (e: Exception){
                texts.text = "Ошибка";
                caseZn = "="
                caseCheckingForText = "="
            }
        }
    }

    private fun CheckForInt(double: Double): Any {
        return if(double == double.roundToInt().toDouble()){
            double.roundToInt()
        }else{
            double
        }
    }
}