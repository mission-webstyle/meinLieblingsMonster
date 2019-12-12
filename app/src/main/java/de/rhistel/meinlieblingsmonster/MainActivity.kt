package de.rhistel.meinlieblingsmonster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity_content_layout.*
import kotlinx.android.synthetic.main.main_activity_layout.*


/**
 * Einstiegspunkt in die App.
 * Diese Klasse zeigt sythetisches View Binding
 * normale generierung von Widgets ueber findViewById
 * sowie die Erstellung von Menus und die Klickauswertung
 * der MenuItems
 */
class MainActivity : AppCompatActivity() {


    //region 0. Konstanten
    companion object MainActivityConstants{
        private const val TEST_USER_NAME = "Shrek"
        private const val TEST_USER_PW = "fiona"
    }
    //endregion

    //region 1. Decl. and Init Widgets und Attribute
    private lateinit var txtInputUserName: EditText
    private lateinit var txtUserPw: EditText
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

        //2. Widgets ohne synthetisches binding generieren
        this.txtInputUserName = this.findViewById(R.id.txtInputUserName)
        this.txtUserPw = this.findViewById(R.id.txtUserPw)

        //3. Setzen der Toolbar
        this.setSupportActionBar(this.mainToolbar)

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
            R.id.mnuItemGenerateAButtonWithoutAXmlDefinition -> generateANewButtonWithOutAXmlDefinition()
            else -> super.onOptionsItemSelected(item)
        }

        return true;
    }
    //endregion

    //region 4. ClickHandling

    /**
     * Springt an wenn der LogIn-Button geklickt wird.
     * Diese Methode ist durch den ID-Check schon vorbereitet
     * sollten weitere Buttons hinzukommen, ein Registrierungsbutton
     * zum Beispiel
     */
    fun logIn(v: View){
        if(v.id == R.id.btnLogIn){
            val strUserName = txtInputUserName.text.toString()
            val strUserPw = txtUserPw.text.toString()

            if(userNameAndUserPwAreNotEmpty(strUserName,strUserPw)){
                if(userCredentialsAreValid(strUserName,strUserPw)){

                    //UserMsg LogIn success
                    Toast.makeText(this,
                        R.string.strUserMessageYouAreLoggedInNow,
                        Toast.LENGTH_LONG).show()
                }else{
                    //UserMsg LogIn failed
                    Toast.makeText(this,
                        R.string.strUserMessageCredentialsAreNotValid,
                        Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,
                    R.string.strUserMessageFillInUserNameAndPw,
                    Toast.LENGTH_LONG).show()
            }


        }
    }

    /**
     * Checkt ob die LogIn-Daten richtig sind
     */
    private fun userCredentialsAreValid(strUserName: String, strUserPw: String): Boolean {
        return((strUserName.contentEquals(TEST_USER_NAME))&&
                strUserPw.contentEquals(TEST_USER_PW))
    }

    /**
     * Checkt ob alle Eingabefelder ausgefuellt wurden
     */
    private fun userNameAndUserPwAreNotEmpty(strUserNameToCheck:String,strUserPwToCheck:String): Boolean {
        return(strUserNameToCheck.isNotEmpty()) && (strUserPwToCheck.isNotEmpty())
    }
    //endregion

    //region 5. Neue Views generieren
    /**
     * Generiert einene neuen Button der wenn er geklickt wird immer neue TextViews
     * generiert.
     */
    private fun generateANewButtonWithOutAXmlDefinition() {

        /*
         * Hier fand eine Quellcodeoptimierung statt:
         * Das mainLayout wird durch synthetisches Binding
         * generiert und fuegt direkt mit addView einen neue Button hinzu.
         *
         * Es ist jedoch immer noch die selbe Reihenfolge
         * 1. Textsetzen
         * 2. Die breite des neuen Buttons auf die Breite des Layouts setzen
         *    die height bleibt standardmaessig auf wrap_content
         * 3. Setzen des Listeners
         */
        this.mainLayout.addView(Button(this).apply {
            setText(R.string.strGeneratedWithoutAXmlDefinition)
            isAllCaps = false;
            width = mainLayout.width
            setOnClickListener{addANewTextViewWithOutAXmlDefintion()}
        })

    }

    /**
     * Generiert eine neue TextView und haengt diese unter den Button
     * Setzt einen Text und die Schriftgroesse auf 18sp
     */
    private fun addANewTextViewWithOutAXmlDefintion(){
        this.mainLayout.addView(TextView(this).apply {
            setText(R.string.strNewTextViewText)
            textSize = 18f
        })

    }
    //endregion
}
