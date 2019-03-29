package ch.hslu.ninopadrutt.vuzibladeprototype

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.vuzix.hud.actionmenu.ActionMenuActivity
import android.widget.Toast
import android.content.Context
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : ActionMenuActivity() {

    companion object {
        public val INTENT_TYPE = "intent_type"
        public val ERROR_INTENT_TYPE = "error"
        public val WARNING_INTENT_TYPE = "warning"
        public val INFORMATION_INTENT_TYPE = "information"
    }

    private var openMenuItem: MenuItem? = null
    private var scanBarcodeItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listData = listOf("Fehler: 1", "Warnungen: 3", "Informationen 5")
        var list = findViewById<ListView>(R.id.list_main)
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->

            var intent: Intent

            if (position == 0) {
                intent = createIntent(this, ERROR_INTENT_TYPE);
            }
            else if (position == 1) {
                intent = createIntent(this, WARNING_INTENT_TYPE);
            }
            else {
                intent = createIntent(this, INFORMATION_INTENT_TYPE);
            }

            startActivity(intent)
        }
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

    private fun createIntent(context : Context, type: String) : Intent {
        val intent = Intent(context, MessageOverview::class.java)
        intent.putExtra(INTENT_TYPE, type)
        return intent;
    }
}
