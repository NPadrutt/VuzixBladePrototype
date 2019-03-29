package ch.hslu.ninopadrutt.vuzibladeprototype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
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
            Toast.makeText(this, "Position Clicked:"+" "+position, Toast.LENGTH_SHORT).show()
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
        item1.Message = "Delta 3 überschritten"
        item1.Machine = "Machine: 010202"

        var item3 = ListItemHolder();
        item1.Message = "Delta 4 überschritten"
        item1.Machine = "Machine: 010202"

        return arrayListOf(item1, item2, item3)
    }

    private fun getInformation() : ArrayList<ListItemHolder>{
        var item1 = ListItemHolder();
        item1.Message = "Everything Awesome"
        item1.Machine = "Machine: 010202"

        var item2 = ListItemHolder();
        item1.Message = "Still Awesome"
        item1.Machine = "Machine: 010202"

        var item3 = ListItemHolder();
        item1.Message = "Yep, all good"
        item1.Machine = "Machine: 010202"

        var item4 = ListItemHolder();
        item1.Message = "Fine here"
        item1.Machine = "Machine: 010202"

        var item5 = ListItemHolder();
        item1.Message = "..Stop asking"
        item1.Machine = "Machine: 010202"

        return arrayListOf(item1, item2, item3, item4, item5)
    }
}
