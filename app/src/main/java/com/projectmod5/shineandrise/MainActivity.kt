package com.projectmod5.shineandrise

import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.projectmod5.shineandrise.adapters.MyAdapter
import com.projectmod5.shineandrise.viewModels.AlarmItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var myAdapter: MyAdapter? = null
    private var arrayList: ArrayList<AlarmItem>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        setupList()
        loaddata()

        fab.setOnClickListener { view ->
            val myItem = AlarmItem()
            myItem.name = "Sid_10"
            myItem.number = "09889987610"
            arrayList?.add(myItem) ?: throw NullPointerException("Expression 'arrayList' must not be null")

            Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loaddata() {

        for (i in 0..9) {
            val myItem = AlarmItem()
            myItem.name = "Sid_" + i
            myItem.number = "098899876" + i
            arrayList?.add(myItem) ?: throw NullPointerException("Expression 'arrayList' must not be null")
        }

        if (myAdapter != null) myAdapter!!.notifyDataSetChanged() else throw NullPointerException("Expression 'myAdapter' must not be null")

    }

    private fun setupList() {
        rlItems!!.layoutManager = layoutManager
        rlItems!!.adapter = myAdapter
    }

    private fun initialize() {
        arrayList = ArrayList<AlarmItem>()
        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        myAdapter = MyAdapter(arrayList!!, this, R.layout.alarm_item)

    }

    fun onAdd(view: View) = Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()

//        val myItem = AlarmItem()
//        myItem.name = "Sid_10"
//        myItem.number = "09889987610"
//        arrayList?.add(myItem) ?: throw NullPointerException("Expression 'arrayList' must not be null")
//
//        if (myAdapter != null) myAdapter!!.notifyDataSetChanged() else throw NullPointerException("Expression 'myAdapter' must not be null")

}