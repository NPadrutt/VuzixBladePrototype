package ch.hslu.ninopadrutt.vuzibladeprototype

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.vuzix.hud.actionmenu.ActionMenuActivity

class MessageOverview : ActionMenuActivity() {

    companion object {
        public val ERROR_INTENT_TYPE = "error"
        public val WARNING_INTENT_TYPE = "warning"
        public val INFORMATION_INTENT_TYPE = "information"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over_view_warnings)

        var type = intent.getStringExtra(MainActivity.INTENT_TYPE)

        var listOfMessages = arrayListOf<ListItemHolder>()

        if(type == ERROR_INTENT_TYPE) {
            listOfMessages = getErrors()
        }
        else if(type == WARNING_INTENT_TYPE) {
            listOfMessages = getWarnings()
        }
        else if(type == INFORMATION_INTENT_TYPE) {
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
        item1.Message = "Motor A Kugellager muss ersetzt werden."
        item1.Machine = "Maschine: 010202"

        return arrayListOf(item1)
    }

    private fun getWarnings() : ArrayList<ListItemHolder>{
        var item1 = ListItemHolder();
        item1.Message = "Auftrag pausiert"
        item1.Machine = "Machine: 010202"

        var item2 = ListItemHolder();
        item2.Message = "Delta 3 überschritten"
        item2.Machine = "Machine: 010202"

        var item3 = ListItemHolder();
        item3.Message = "Delta 4 überschritten"
        item3.Machine = "Machine: 010202"

        var item4 = ListItemHolder();
        item4.Message = "Delta 1 überschritten"
        item4.Machine = "Machine: 010203"

        var item5 = ListItemHolder();
        item5.Message = "Delta 3 überschritten"
        item5.Machine = "Machine: 010204"

        var item6 = ListItemHolder();
        item6.Message = "Delta 4 überschritten"
        item6.Machine = "Machine: 010204"

        return arrayListOf(item1, item2, item3, item4, item5, item6)
    }

    private fun getInformation() : ArrayList<ListItemHolder>{
        var item1 = ListItemHolder();
        item1.Message = "Auftrag 2019034 wurde gestartet."
        item1.Machine = "Maschine: 010202"

        var item2 = ListItemHolder();
        item2.Message = "Auftrag 2019034 zu 1% Verarbeitet"
        item2.Machine = "Maschine: 010202"

        var item3 = ListItemHolder();
        item3.Message = "Auftrag 2019034 zu 2% Verarbeitet"
        item3.Machine = "Maschine: 010202"

        var item4 = ListItemHolder();
        item4.Message = "Materialkontainer A aufgefüllt."
        item4.Machine = "Maschine: 010202"

        var item5 = ListItemHolder();
        item5.Message = "Materialkontainer B aufgefüllt."
        item5.Machine = "Maschine: 010202"

        var item6 = ListItemHolder();
        item6.Message = "Auftrag 2019034 wurde gestartet."
        item6.Machine = "Maschine: 010203"

        var item7 = ListItemHolder();
        item7.Message = "Auftrag 2019034 zu 1% Verarbeitet"
        item7.Machine = "Maschine: 010201"

        var item8 = ListItemHolder();
        item8.Message = "Auftrag 2019034 zu 2% Verarbeitet"
        item8.Machine = "Maschine: 010204"

        var item9 = ListItemHolder();
        item9.Message = "Materialkontainer A aufgefüllt."
        item9.Machine = "Maschine: 010205"

        var item10 = ListItemHolder();
        item10.Message = "Materialkontainer B aufgefüllt."
        item10.Machine = "Maschine: 010206"

        var item11 = ListItemHolder();
        item11.Message = "Materialkontainer B aufgefüllt."
        item11.Machine = "Maschine: 010207"

        var item12 = ListItemHolder();
        item12.Message = "Auftrag 2019034 wurde gestartet."
        item12.Machine = "Maschine: 010203"

        var item13 = ListItemHolder();
        item13.Message = "Auftrag 2019034 zu 1% Verarbeitet"
        item13.Machine = "Maschine: 010201"

        var item14 = ListItemHolder();
        item14.Message = "Auftrag 2019034 zu 2% Verarbeitet"
        item14.Machine = "Maschine: 010203"

        var item15 = ListItemHolder();
        item15.Message = "Materialkontainer A aufgefüllt."
        item15.Machine = "Maschine: 010204"

        return arrayListOf(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15)
    }
}
