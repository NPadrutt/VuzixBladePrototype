package ch.hslu.ninopadrutt.vuzibladeprototype

import android.os.Bundle
import com.vuzix.hud.actionmenu.ActionMenuActivity
import kotlinx.android.synthetic.main.activity_detail_page.*

class DetailPage : ActionMenuActivity() {

    companion object {
        public val ITEM_TYPE_KEY = "Type";
        public val ITEM_MACHINE_KEY = "Machine";
        public val ITEM_MESSAGE_KEY = "Message";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        var type = intent.getStringExtra(ITEM_TYPE_KEY)
        var machine = intent.getStringExtra(ITEM_MACHINE_KEY)
        var message = intent.getStringExtra(ITEM_MESSAGE_KEY)

        machine_text_view.text = machine
        message_text_view.text = message
    }
}
