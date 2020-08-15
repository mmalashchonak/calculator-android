package com.itrestum.calculator.ui

import com.itrestum.calculator.ResultsFragment
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.itrestum.calculator.History
import com.itrestum.calculator.R
import com.itrestum.calculator.databinding.ActivitySearchBinding
import com.itrestum.calculator.extension.observe
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception

class SearchActivity : AppCompatActivity() {
    private val viewModel: SearchViewModel by viewModel()

    val fragment = ResultsFragment()

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.apply {
            observe(data, ::display)
            observe(history, ::updateHistory)
            observe(histories, ::updateHistories)
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.commit()

        binding.btn0.setOnClickListener { setTextFields("0") }
        binding.btn1.setOnClickListener { setTextFields("1") }
        binding.btn2.setOnClickListener { setTextFields("2") }
        binding.btn3.setOnClickListener { setTextFields("3") }
        binding.btn4.setOnClickListener { setTextFields("4") }
        binding.btn5.setOnClickListener { setTextFields("5") }
        binding.btn6.setOnClickListener { setTextFields("6") }
        binding.btn7.setOnClickListener { setTextFields("7") }
        binding.btn8.setOnClickListener { setTextFields("8") }
        binding.btn9.setOnClickListener { setTextFields("9") }
        binding.btnDot.setOnClickListener { setTextFields(".") }

        binding.btnMinus.setOnClickListener { setTextFields("-") }
        binding.btnPlus.setOnClickListener { setTextFields("+") }
        binding.btnMult.setOnClickListener { setTextFields("*") }
        binding.btnDivide.setOnClickListener { setTextFields("/") }
        binding.btnBrcL.setOnClickListener { setTextFields(")") }
        binding.btnBrcR.setOnClickListener { setTextFields("(") }

        binding.btnAc.setOnClickListener {
            binding.mathOperation.text = ""
            binding.resultText.text = ""
        }

        binding.btnBack.setOnClickListener {
            val str = binding.mathOperation.text.toString()
            if (str.isNotEmpty())
                binding.mathOperation.text = str.substring(0, str.length - 1)

            binding.resultText.text = ""
        }

        binding.btnEql.setOnClickListener {
            viewModel.calculate(binding.mathOperation.text.toString())
        }

        viewModel.getHistories()

    }

    private fun display(value: String?) {
        binding.resultText.text = value
    }

    fun setTextFields(str: String) {
        math_operation.append(str)
    }

    private fun updateHistory(value: String?) {
        value?.let { fragment.addToList(it) }
    }

    private fun updateHistories(value: List<History>?) {
        value?.forEach {
            fragment.addToList(it.savedValue)
        }
    }

}