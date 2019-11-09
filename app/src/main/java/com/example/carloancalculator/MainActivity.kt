package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EditTxtCarPrice.requestFocus()
        btnCalculate.setOnClickListener {
            calculation()

        }
        /*val a:String="1"
      val ddd:Double=a.toDouble()
        txtViewCarPrice.text=ddd.toString()*/


    }
    private fun calculation()
    {
        val dblCarPrice:Double=EditTxtCarPrice.text.toString().toDouble()
        val downPayment:Double=EditTxtDownPaymentAmt.text.toString().toDouble()
        val intLoanPeriod:Int=EditTxtLoanPeriod.text.toString().toInt()
        val dblInterestRate:Double=EditTxtInterestRate.text.toString().toDouble()
        val dblCarLoan:Double=dblCarPrice-downPayment
        val dblInterest:Double=dblCarLoan*dblInterestRate*intLoanPeriod
        val monthlyPayment:Double=(dblCarLoan+dblInterest)/intLoanPeriod/12
        displayOutput(dblCarLoan,dblInterest,monthlyPayment)
    }
    private fun displayOutput(dblCarLoan:Double,dblInterest:Double,monthlyPayment:Double)
    {
        txtViewOutCarLoan.text=String.format("RM%.2f",dblCarLoan)
        txtViewOutInterest.text=String.format("RM%.2f",dblInterest)
        txtViewOutMonthlyRepayment.text=String.format("RM%.2f",monthlyPayment)
    }
}
