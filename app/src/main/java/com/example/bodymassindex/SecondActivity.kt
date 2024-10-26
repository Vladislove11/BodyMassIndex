package com.example.bodymassindex

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

class SecondActivity : AppCompatActivity() {

    private lateinit var discriptionTV: TextView
    private lateinit var resultCalculateTV: TextView
    private lateinit var recomentionTextTV: TextView
    private lateinit var imageView: ImageView

    private var listIndexMass = listOf<IndexInfo>(
        IndexInfo("<18.5", "Дефицит", "Нехватака минералов и витаминов, плохое" +
                "пиатение. Необходим комплексный подход в наборе веса: полноценный отдых"),
        IndexInfo("18.5 - 24.9", "Норма", "Рассчитывается в соотетствии с возрастом." +
                "Обследование ни когда не будет лишним. Необходимо делать общий анализ крови с СОЭ"),
        IndexInfo("25.0 - 29.9", "Предожирение", "Вести более активный образ жизни." +
                "Т.к. ожирени всегда начинается из-за лени. Уменьшить количество вредных привычек. Избегать" +
                "длительных стрессов"),
        IndexInfo(">30.0", "Ожирение", "Поможет комплексный подход. Мотивация для формирования" +
                "правильных привычек. Изменени отношения к питанию. Считание калорий и БЖУ.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        discriptionTV = findViewById(R.id.descriptionTV)
        resultCalculateTV = findViewById(R.id.resultCalculateTV)
        recomentionTextTV = findViewById(R.id.recomendationTV)
        imageView = findViewById(R.id.imageView)

        val height = intent.getStringExtra("height").toString().toDouble()
        val weight = intent.getStringExtra("weight").toString().toDouble()
        val resulCalc = BigDecimal(weight/(height * height)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        resultCalculateTV.text = "Ваш индекс массы тела = $resulCalc"

        when(resulCalc){
            in 0.0..18.5 -> {
                imageView.setImageResource(R.drawable.p1)
                discriptionTV.text = listIndexMass[0].description
                recomentionTextTV.text = listIndexMass[0].recommend
            }
            in 18.5 .. 24.9 -> {
                imageView.setImageResource(R.drawable.p2)
                discriptionTV.text = listIndexMass[1].description
                recomentionTextTV.text = listIndexMass[1].recommend
            }
            in 25.0 .. 29.9 -> {
                imageView.setImageResource(R.drawable.p3)
                discriptionTV.text = listIndexMass[2].description
                recomentionTextTV.text = listIndexMass[2].recommend
            }
            in 30.0 .. 100.0 -> {
                imageView.setImageResource(R.drawable.p4)
                discriptionTV.text = listIndexMass[3].description
                recomentionTextTV.text = listIndexMass[3].recommend
            }
        }



    }
}