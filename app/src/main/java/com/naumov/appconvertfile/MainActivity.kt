package com.naumov.appconvertfile

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.naumov.appconvertfile.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        presenter.initView()
    }

    override fun setImage(path: String) {
        Toast.makeText(this, "set image", Toast.LENGTH_SHORT).show()
    }

    override fun initView() {
        binding.buttonImage.setOnClickListener {
            presenter.pressButtonConvertFile()

        }
    }
}