package ch.hslu.ninopadrutt.vuzibladeprototype

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.vuzix.hud.actionmenu.ActionMenuActivity
import android.widget.TextView
import android.widget.Toast
import android.app.Activity
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : ActionMenuActivity() {

    private var openMenuItem: MenuItem? = null
    private var scanBarcodeItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listData = listOf("Test", "Foo", "hey hey")
        var list = findViewById<ListView>(R.id.list_test)
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData)
        list.adapter = adapter
    }

    override fun onCreateActionMenu(menu: Menu?): Boolean {
        super.onCreateActionMenu(menu)

        menuInflater.inflate(R.menu.main_menu, menu)

        openMenuItem = menu?.findItem(R.id.menu_open)
        scanBarcodeItem = menu?.findItem(R.id.menu_scan_barcode)

        return true
    }

    fun openOnClick(item: MenuItem) {

        showToast("Hello World!")
        openMenuItem?.isEnabled = true
        scanBarcodeItem?.isEnabled = true
    }

    fun scanBarcodeOnClick(item: MenuItem) {

        showToast("Stand back! Scanning!")
        openMenuItem?.isEnabled = true
        scanBarcodeItem?.isEnabled = true
    }

    private fun showToast(text: String) {

        val activity = this
        activity.runOnUiThread { Toast.makeText(activity, text, Toast.LENGTH_SHORT).show() }
    }
}
