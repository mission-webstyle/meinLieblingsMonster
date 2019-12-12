package de.rhistel.meinlieblingsmonster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.main_activity_content_layout.view.*


/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {

    //region 1. Decl. and Init Widgets und Attribute
    private lateinit var mainToolbar: Toolbar
    private lateinit var mainLayout: LinearLayoutCompat

    private lateinit var txtInputUserName: EditText
    private lateinit var txtUserPw: EditText
    private lateinit var btnLogIn: Button
    private lateinit var btnGenerateYourSelfWithOutXmlDefintion: Button
    //endregion

    //region 2. Lebenszyklus

    /**
     * Startet als erstes nach dem Konstruktor
     * Setzt das Layout und generiert alle direkt
     * benoetigten Widgets. Setzt Listener
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1. Layout setzen
        this.setContentView(R.layout.main_activity_layout)

        //2. Views generieren
        this.mainToolbar = this.findViewById(R.id.mainToolbar)

        //Layout, welches die neue View beinhalten soll Layout muss im xml-layout eine id haben
        this.mainLayout = this.findViewById(R.id.mainLayout)

        this.btnLogIn = this.findViewById(R.id.btnLogIn)
        this.txtInputUserName = this.findViewById(R.id.txtInputUserName)
        this.txtUserPw = this.findViewById(R.id.txtUserPw)

        this.generateANewButtonWithOutAXmlDefiniton()

        //3. Setzen der Toolbar
        setSupportActionBar(this.mainToolbar)

        //4. Listener setzen
        this.btnLogIn.setOnClickListener {
            val strUserName = this.txtInputUserName.text.toString()
            val strUserPw = this.txtUserPw.text.toString()

            if ((strUserName.isNotEmpty()) && (strUserPw.isNotEmpty())) {
                val strCredentialsMessage = getString(R.string.strUserCredentialsMessage) +
                        strUserName + " " + strUserPw

                Toast.makeText(
                    this,
                    strCredentialsMessage,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    R.string.strUserMessageFillInUserNameAndPw,
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }

    //endregion


    //region 3. MenuHandling
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    //endregion

    //region 4. Neue Views generieren
    /**
     * Generiert einene neuen Button der wenn er geklickt wird immer neue TextViews
     * generiert.
     */
    private fun generateANewButtonWithOutAXmlDefiniton() {

        //Objekt selbst generieren
        this.btnGenerateYourSelfWithOutXmlDefintion = Button(this)

        //Attribute setzen
        this.btnGenerateYourSelfWithOutXmlDefintion.setText(R.string.strGeneratedItSelfText)
        //Anschreibmodus textAllCaps deaktivieren
        this.btnGenerateYourSelfWithOutXmlDefintion.isAllCaps = false;

        /*
         * Breite des Buttons auf die Breites des Elternlayotus setzen,
         * Hoehe ist standardmaessig wrap_content
         */
        this.btnGenerateYourSelfWithOutXmlDefintion.width = mainLayout.width

        //Dem Layout die View hinzufuegen
        this.mainLayout.addView(this.btnGenerateYourSelfWithOutXmlDefintion)

        //Dem Button noch einen Listener geben der selbst weitere TextViews generiert
        this.btnGenerateYourSelfWithOutXmlDefintion.setOnClickListener{
            addANewTextViewWithOutAXmlDefintions()
        }
    }

    /**
     * Generiert eine neue TextView und haengt diese unter den Button
     */
    private fun addANewTextViewWithOutAXmlDefintions(){
        val txtvNewTextView = TextView(this).apply {
            text = getString(R.string.strNewTextViewText)
            textSize = 18f
        }
        this.mainLayout.addView(txtvNewTextView)

    }

    //endregion
}
