package com.example.vaccinessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // criando recyclerview para que recebe o id da nossa recycle
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // definindo um layout para nosso recyclerView caso nao tivessemos definido
        // passando o contexto e a orientacao do layout, usando o false para nao definir um reverseLayout
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        // data source do tipo vaccinemodel para adcionarmos dados
        val vaccineList: ArrayList<VaccineModel> = ArrayList()
        vaccineList.add(VaccineModel("covid","matou muito",R.drawable.medical_red))
        vaccineList.add(VaccineModel("febre amarela","matou muito",R.drawable.mediacal_yellow))
        vaccineList.add(VaccineModel("raiva","matou muito",R.drawable.medical_raiva))
        vaccineList.add(VaccineModel("gripe","matou muito",R.drawable.medical_gripe))
        vaccineList.add(VaccineModel("poliomielite","matou muito",R.drawable.medical_poliomielite))
        vaccineList.add(VaccineModel("compostox","matou muito",R.drawable.medical_compostox))

        // definindo adapter e pasando o nosso array de vacinas
        val adapter = MyAdapter(vaccineList)
        recyclerView.adapter = adapter
    }
}