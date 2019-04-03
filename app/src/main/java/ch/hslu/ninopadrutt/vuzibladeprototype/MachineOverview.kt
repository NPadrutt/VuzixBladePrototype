package ch.hslu.ninopadrutt.vuzibladeprototype

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.vuzix.hud.actionmenu.ActionMenuActivity

class MachineOverview : ActionMenuActivity() {

    companion object {
        public val INTENT_TYPE = "intent_type"
    }

    private var openMenuItem: MenuItem? = null
    private var scanBarcodeItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_machine_overview)

        var listData = listOf("Fehler: 1", "Warnungen: 3", "Informationen: 5")
        var list = findViewById<ListView>(R.id.list_main)
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->

            var intent: Intent

            if (position == 0) {
                intent = createIntent(this, MessageOverview.ERROR_INTENT_TYPE);
            }
            else if (position == 1) {
                intent = createIntent(this, MessageOverview.WARNING_INTENT_TYPE);
            }
            else {
                intent = createIntent(this, MessageOverview.INFORMATION_INTENT_TYPE);
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
