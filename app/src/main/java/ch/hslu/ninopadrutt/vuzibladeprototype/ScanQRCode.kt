package ch.hslu.ninopadrutt.vuzibladeprototype

import android.os.Bundle
import com.vuzix.hud.actionmenu.ActionMenuActivity

class ScanQRCode : ActionMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_qrcode)
    }
}
