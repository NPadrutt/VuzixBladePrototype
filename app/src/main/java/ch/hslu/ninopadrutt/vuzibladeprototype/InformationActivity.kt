package ch.hslu.ninopadrutt.vuzibladeprototype

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.vuzix.hud.actionmenu.ActionMenuActivity

class InformationActivity : ActionMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {

        if (event.keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            val intent = Intent(context, WarningActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }

        return super.dispatchKeyEvent(event)
    }
}
