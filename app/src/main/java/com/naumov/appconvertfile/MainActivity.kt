package com.naumov.appconvertfile

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import coil.load
import com.naumov.appconvertfile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter


//    private val registerActivityForResult = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
//        Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show()
//
//        binding.sourceImage.load(uri)
//        binding.destinationImage.load(uri)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, activityResultRegistry)
        presenter.initView()
    }

    override fun setTextImageOld(t: String) {
        binding.sourceImageTv.text = t
    }

    override fun setTextImageNew(t: String) {
        binding.destinationImageTv.text = t
    }

    override fun setImageOld(path: Uri) {
        Toast.makeText(this, "set image", Toast.LENGTH_SHORT).show()
        binding.sourceImage.load(path)

    }

    override fun setImageNew(path: Uri) {
        binding.destinationImage.load(path)
    }

    override fun initView() {
        binding.buttonImage.setOnClickListener {
            presenter.сonvertFile()
        }
    }
}