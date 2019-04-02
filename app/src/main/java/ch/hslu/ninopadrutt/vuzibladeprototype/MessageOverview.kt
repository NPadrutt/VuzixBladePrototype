package ch.hslu.ninopadrutt.vuzibladeprototype

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.vuzix.hud.actionmenu.ActionMenuActivity

class MessageOverview : ActionMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over_view_warnings)

        var type = intent.getStringExtra(MainActivity.INTENT_TYPE)

        var listOfMessages = arrayListOf<ListItemHolder>()

        if(type == MainActivity.ERROR_INTENT_TYPE) {
            listOfMessages = getErrors()
        }
        else if(type == MainActivity.WARNING_INTENT_TYPE) {
            listOfMessages = getWarnings()
        }
        else if(type == MainActivity.INFORMATION_INTENT_TYPE) {
            listOfMessages = getInformation()
        }

        var list = findViewById<ListView>(R.id.list_overview)

        val adapter = CustomListAdapter(this, listOfMessages)

        list.adapter = adapter
        list.setOnItemClickListener { parent, view, position, id ->

            val item = listOfMessages.get(position)
            val intent = Intent(context, DetailPage::class.java)
            intent.putExtra(DetailPage.ITEM_TYPE_KEY, "something")
            intent.putExtra(DetailPage.ITEM_MACHINE_KEY, item.Machine)
            intent.putExtra(DetailPage.ITEM_MESSAGE_KEY, item.Message)
            startActivity(intent);
        }
    }

    private fun getErrors() : ArrayList<ListItemHolder>{
        var item1 = ListItemHolder();
        item1.Message = "This is an Error!"
        item1.Machine = "Machine: 010202"

        return arrayListOf(item1)
    }

    private fun getWarnings() : ArrayList<ListItemHolder>{
        var item1 = ListItemHolder();
        item1.Message = "Delta 1 überschritten"
        item1.Machine = "Machine: 010202"

        var item2 = ListItemHolder();
        item2.Message = "Delta 3 überschritten"
        item2.Machine = "Machine: 010202"

        var item3 = ListItemHolder();
        item3.Message = "Delta 4 überschritten"
        item3.Machine = "Machine: 010202"

        return arrayListOf(item1, item2, item3)
    }

    private fun getInformation() : ArrayList<ListItemHolder>{
        var item1 = ListItemHolder();
        item1.Message = "Everything Awesome"
        item1.Machine = "Machine: 010202"

        var item2 = ListItemHolder();
        item2.Message = "Still Awesome"
        item2.Machine = "Machine: 010202"

        var item3 = ListItemHolder();
        item3.Message = "Yep, all good"
        item3.Machine = "Machine: 010202"

        var item4 = ListItemHolder();
        item4.Message = "Fine here"
        item4.Machine = "Machine: 010202"

        var item5 = ListItemHolder();
        item5.Message = "..Stop asking"
        item5.Machine = "Machine: 010202"

        return arrayListOf(item1, item2, item3, item4, item5)
    }
}
