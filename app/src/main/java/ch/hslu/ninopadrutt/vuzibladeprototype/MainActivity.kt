package ch.hslu.ninopadrutt.vuzibladeprototype

import android.app.ActivityOptions
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.vuzix.hud.actionmenu.ActionMenuActivity
import android.widget.Toast
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
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
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {

        if (event.keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            val intent = Intent(context, WarningActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }

        return super.dispatchKeyEvent(event)
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
