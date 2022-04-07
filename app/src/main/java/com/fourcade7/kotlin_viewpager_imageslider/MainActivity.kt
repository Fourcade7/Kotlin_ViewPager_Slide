package com.fourcade7.kotlin_viewpager_imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.fourcade7.kotlin_viewpager_imageslider.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var a=0
    var b=0
    val TAG = "Pr"
    val arraylist=ArrayList<Fragment>()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //go_timer()
        arraylist.add(BlankFragment())
        arraylist.add(BlankFragment2())
        val slidePagerAdapter=SlidePagerAdapter(supportFragmentManager,arraylist)
        binding.viewpager1.adapter=slidePagerAdapter
       binding.button1.setOnClickListener {
           binding.viewpager1.currentItem=binding.viewpager1.currentItem+1
       }



    }

    fun go_timer(){
        val handler=Handler()
        val runnable=object :Runnable{
            override fun run() {
                a++
                Log.d(TAG, "run: a= $a")

            }
        }

        val timer=Timer()
        val timertask=object : TimerTask() {
            override fun run() {
                b++
                handler.post(runnable)
                Log.d(TAG, "run:b= $b")
                if (b==10){
                    timer.cancel()
                }
            }
        }
        timer.schedule(timertask,250,1000)

//        Handler().postDelayed({
//            //something
//        },2000)
    }
}