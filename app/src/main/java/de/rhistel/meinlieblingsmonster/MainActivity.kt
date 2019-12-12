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


/**
 * Einstiegspunkt in die App.
 * Diese Klasse zeigt sythetisches View Binding
 * normale generierung von Widgets ueber findViewById
 * sowie die Erstellung von Menus und die Klickauswertung
 * der MenuItems
 */
class MainActivity : AppCompatActivity() {

    //region 1. Decl. and Init Widgets und Attribute
    private lateinit var mainToolbar: Toolbar
    private lateinit var mainLayout: LinearLayoutCompat

    private lateinit var txtInputUserName: EditText
    private lateinit var txtUserPw: EditText
    private lateinit var btnLogIn: Button
    private lateinit var btnGenerateYourSelfWithOutXmlDefinition: Button
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

        this.txtInputUserName = this.findViewById(R.id.txtInputUserName)
        this.txtUserPw = this.findViewById(R.id.txtUserPw)
        this.btnLogIn = this.findViewById(R.id.btnLogIn)

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

    /**
     * Generiert das Menu dynamisch zur Laufzeit
     * ueber einen speziellen LayoutInflater nur fuer
     * Menus; den geerbten MenuInflater
     * @return true = Menu anzeigen | false = Menu nicht anzeigen
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //Menu generieren
        this.menuInflater.inflate(R.menu.main_activity_main_menu_layout, menu)
        return true
    }

    /**
     * Auswertung der Menuklicks
     * Checken welches Item geklickt wurde und
     * entsprechende Aktion einleiten
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnuItemGenerateAButtonWithoutAXmlDefinition -> generateANewButtonWithOutAXmlDefiniton()
            else -> super.onOptionsItemSelected(item)
        }

        return true;
    }
    //endregion

    //region 4. ClickHandling

    //region 5. Neue Views generieren
    /**
     * Generiert einene neuen Button der wenn er geklickt wird immer neue TextViews
     * generiert.
     */
    private fun generateANewButtonWithOutAXmlDefiniton() {

        //Objekt selbst generieren
        this.btnGenerateYourSelfWithOutXmlDefinition = Button(this)

        //Attribute setzen
        this.btnGenerateYourSelfWithOutXmlDefinition.setText(R.string.strGeneratedWithoutAXmlDefinition)

        //Anschreimodus textAllCaps deaktivieren
        this.btnGenerateYourSelfWithOutXmlDefinition.isAllCaps = false;

        /*
         * Breite des Buttons auf die Breites des Elternlayotus setzen,
         * Hoehe ist standardmaessig wrap_content
         */
        this.btnGenerateYourSelfWithOutXmlDefinition.width = mainLayout.width

        //Dem Layout die View hinzufuegen
        this.mainLayout.addView(this.btnGenerateYourSelfWithOutXmlDefinition)

        //Dem Button noch einen Listener geben der selbst weitere TextViews generiert
        this.btnGenerateYourSelfWithOutXmlDefinition.setOnClickListener{
            this.addANewTextViewWithOutAXmlDefintion()
        }
    }

    /**
     * Generiert eine neue TextView und haengt diese unter den Button
     */
    private fun addANewTextViewWithOutAXmlDefintion(){
        val txtvNewTextView = TextView(this).apply {
            text = getString(R.string.strNewTextViewText)
            textSize = 18f
        }
        this.mainLayout.addView(txtvNewTextView)

    }

    //endregion
}
