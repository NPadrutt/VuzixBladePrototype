package ch.hslu.ninopadrutt.vuzibladeprototype

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.vuzix.hud.actionmenu.ActionMenuActivity

class ScanQRCode : ActionMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_qrcode)
    }

    public fun onClick(view : View){
        var intent = Intent(this, MachineOverview::class.java)
        startActivity(intent)
    }
}
