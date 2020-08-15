package com.itrestum.calculator

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.itrestum.calculator.databinding.ActivityMainBinding
import com.itrestum.calculator.di.databaseModules
import com.itrestum.calculator.di.repositoryModule
import com.itrestum.calculator.di.viewModelModule
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

import java.lang.Exception


class MainActivity : Application() {

//    private lateinit var binding: ActivityMainBinding

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(
                listOf(viewModelModule, databaseModules, repositoryModule)
            )
        }


//        val fragment = ResultsFragment.newInstance("", "")
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.container, fragment)
//        transaction.commit()
//
//        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "history-db").allowMainThreadQueries().build()
//        var history = db.historyDao().getAll()
//        history.forEach{
//            fragment.addToList(it.savedValue)
//        }

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)


//        binding.btn0.setOnClickListener { setTextFields("0") }
//        binding.btn1.setOnClickListener { setTextFields("1") }
//        binding.btn2.setOnClickListener { setTextFields("2") }
//        binding.btn3.setOnClickListener { setTextFields("3") }
//        binding.btn4.setOnClickListener { setTextFields("4") }
//        binding.btn5.setOnClickListener { setTextFields("5") }
//        binding.btn6.setOnClickListener { setTextFields("6") }
//        binding.btn7.setOnClickListener { setTextFields("7") }
//        binding.btn8.setOnClickListener { setTextFields("8") }
//        binding.btn9.setOnClickListener { setTextFields("9") }
//        binding.btnDot.setOnClickListener { setTextFields(".") }
//
//        binding.btnMinus.setOnClickListener { setTextFields("-") }
//        binding.btnPlus.setOnClickListener { setTextFields("+") }
//        binding.btnMult.setOnClickListener { setTextFields("*") }
//        binding.btnDivide.setOnClickListener { setTextFields("/") }
//        binding.btnBrcL.setOnClickListener { setTextFields(")") }
//        binding.btnBrcR.setOnClickListener { setTextFields("(") }
//
//        binding.btnAc.setOnClickListener {
//            binding.mathOperation.text = ""
//            binding.resultText.text = ""
//        }
//
//        binding.btnBack.setOnClickListener {
//            val str = binding.mathOperation.text.toString()
//            if (str.isNotEmpty())
//                binding.mathOperation.text = str.substring(0, str.length - 1)
//
//            binding.resultText.text = ""
//        }
//
//        binding.btnEql.setOnClickListener {
//            try {
//                val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
//                val result = ex.evaluate()
//
//                val longres = result.toLong()
//
//                binding.resultText.text = if (result == longres.toDouble()) longres.toString()
//                else result.toString()
//
//                fragment.addToList(
//                    "${binding.mathOperation.text.toString()} = ${binding.resultText.text.toString()}"
//                )
//
//                db.historyDao().insertAll(History(
//                    //history.lastOrNull()?.uid?.plus(1),
//                    "${binding.mathOperation.text.toString()} = ${binding.resultText.text.toString()}"))
//            } catch (e: Exception) {
//                Log.d("Error!", "Message: ${e.message}")
//            }
//        }

    }


//    fun setTextFields(str: String) {
//        math_operation.append(str)
//    }
}