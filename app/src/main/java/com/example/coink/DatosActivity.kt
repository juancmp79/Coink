package com.example.coink


import android.app.DatePickerDialog
import android.app.Dialog
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.fragment.app.DialogFragment
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year
import java.util.*


public class DatosActivity : AppCompatActivity() {


    lateinit var tipo_documento: String
    lateinit var numero_documento: String
    lateinit var nacimiento: String
    lateinit var expedicion_documento: String
    lateinit var genero: String
    lateinit var email: String
    lateinit var password: String

    private var mYear: Int = 0
    private var mMonth: kotlin.Int = 0
    private var mDay: kotlin.Int = 0

    lateinit  var Fecnacimiento: EditText
    lateinit  var Fecdocumento: EditText

    lateinit  var TextExpDoc: TextView
    lateinit  var TextFechNacimiento: TextView

    lateinit var emailId: EditText
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


    val cal = Calendar.getInstance()
    val cal_1 = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //----------------- Deshabilita el Boton Siguiente ----------------
        val blogin = findViewById<View>(R.id.button14) as Button
        blogin.setBackgroundResource(R.drawable.redondear2)
        blogin.setTextColor(Color.WHITE)
        blogin.isEnabled = false



        val atras = findViewById<View>(R.id.imageView) as ImageView
        atras.setOnClickListener {
            onBackPressed()
        }

        //----------------- Mensajes de los selectores -------------------------
        val TextSpinnerDoc = findViewById<View>(R.id.textView14) as TextView
        TextSpinnerDoc.setVisibility(View.INVISIBLE)

        val TextNumDoc = findViewById<View>(R.id.textView15) as TextView
        TextNumDoc.setVisibility(View.INVISIBLE)

        TextExpDoc = findViewById<View>(R.id.textView16) as TextView
        TextExpDoc.setVisibility(View.INVISIBLE)

        TextFechNacimiento = findViewById<View>(R.id.textView17) as TextView
        TextFechNacimiento.setVisibility(View.INVISIBLE)

        val TextSpinnerGenero = findViewById<View>(R.id.textView18) as TextView
        TextSpinnerGenero.setVisibility(View.INVISIBLE)

        val TextCorreo1 = findViewById<View>(R.id.textView20) as TextView
        TextCorreo1.setVisibility(View.INVISIBLE)

        val TextCorreo2 = findViewById<View>(R.id.textView21) as TextView
        TextCorreo2.setVisibility(View.INVISIBLE)


        //--------------------- Codigo Bottones libres -------------------------------------------

        val NumeroDocumento = findViewById<View>(R.id.editTextNumber) as EditText
        NumeroDocumento.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if(NumeroDocumento.text.length > 0)
                    TextNumDoc.setVisibility(View.VISIBLE)
                else
                    TextNumDoc.setVisibility(View.INVISIBLE)

            }
            false
        }

        val EmailUno = findViewById<View>(R.id.editTextTextPostalAddress) as EditText
        EmailUno.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if(EmailUno.text.length > 0)
                    TextCorreo1.setVisibility(View.VISIBLE)
                else
                    TextCorreo1.setVisibility(View.INVISIBLE)

            }
            false
        }

        EmailUno.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(EmailUno.text.toString()).matches()){

                }
                else{
                    EmailUno.setError("Email invalido")
                }

            }

        })



        val EmailDos = findViewById<View>(R.id.editTextTextPostalAddress2) as EditText
        EmailDos.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE) {
                if(EmailDos.text.length > 0)
                    TextCorreo2.setVisibility(View.VISIBLE)
                else
                    TextCorreo2.setVisibility(View.INVISIBLE)

            }
            false
        }

        EmailDos.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(EmailDos.text.toString()).matches()){
                    if(EmailUno.text.toString() == EmailDos.text.toString()){
                          //EmailUno.setCompoundDrawables(null, null, getResources().getDrawable(R.drawable.ic_ok), null)
                        EmailDos.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_ok, 0, 0, 0);
                        //android:drawableRight="@drawable/ic_ok"



                    }
                    else
                        EmailDos.setError("Los dos Email deben ser iguales")


                }
                else{
                    EmailDos.setError("Email invalido")
                }

            }

        })

        val Password1 = findViewById<View>(R.id.editTextTextPostalAddress3) as EditText
        Password1.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_NEXT) {


            }
            false
        }

        val Password2 = findViewById<View>(R.id.editTextTextPostalAddress4) as EditText
        Password2.setOnEditorActionListener { _, actionId, _ ->

        if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE) {

            if(Password1.text.toString() == Password2.text.toString()){
                blogin.setBackgroundResource(R.drawable.redondear)
                blogin.setTextColor(R.color.verde_1)
                blogin.isEnabled = true
            }
            else
                Password2.setError("Confirmar PIN de seguridad")

            }
            false
        }


        //--------------------- Codigo Spinner 1 Documento -----------------------------------------
        val lista = resources.getStringArray(R.array.documento)
        val spinnerDoc = findViewById<View>(R.id.idSpinner) as Spinner

        val adaptador = ArrayAdapter(this, R.layout.spinner_documento, lista)
        spinnerDoc.adapter = adaptador

        spinnerDoc.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (
                        if(p2 > 0)
                            TextSpinnerDoc.setVisibility(View.VISIBLE)


                        )
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //-------------- Codigo Spinner 2 Genero ---------------------------------
        val listaGen = resources.getStringArray(R.array.genero)
        val spinnerGen = findViewById<View>(R.id.idSpinner2) as Spinner

        val adaptadorGen = ArrayAdapter(this, R.layout.spinner_genero, listaGen)
        spinnerGen.adapter = adaptadorGen

        spinnerGen.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (
                        if(p2 > 0)
                            TextSpinnerGenero.setVisibility(View.VISIBLE)

                        )
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //------------- Codigo Fechas --------------------------------------------
        Fecnacimiento = findViewById<View>(R.id.editTextNumber3) as EditText
        Fecdocumento = findViewById<View>(R.id.editTextNumber2) as EditText

        val dateSetListener = object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker, year: Int, monthofYear: Int, dayofMonth: Int) {
                cal.set(Calendar.YEAR,year)
                cal.set(Calendar.MONTH,monthofYear)
                cal.set(Calendar.DAY_OF_MONTH,dayofMonth)
                updateDateInView()
            }
        }


        Fecnacimiento?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@DatosActivity, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })

        val dateSetListener_1 = object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker, year: Int, monthofYear: Int, dayofMonth: Int) {
                cal_1.set(Calendar.YEAR,year)
                cal_1.set(Calendar.MONTH,monthofYear)
                cal_1.set(Calendar.DAY_OF_MONTH,dayofMonth)
                updateDateInView_1()
            }
        }

        Fecdocumento?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@DatosActivity, dateSetListener_1,
                    cal_1.get(Calendar.YEAR),
                    cal_1.get(Calendar.MONTH),
                    cal_1.get(Calendar.DAY_OF_MONTH)).show()
            }

        })

        //-------------------------- Boton Siguiente ----------------------------

        blogin.setOnClickListener{


            tipo_documento =   spinnerDoc.getSelectedItem().toString()
            numero_documento =  NumeroDocumento.text.toString()
            nacimiento = Fecnacimiento?.text.toString()
            expedicion_documento = Fecdocumento?.text.toString()
            genero = spinnerGen.getSelectedItem().toString()
            email = EmailDos.text.toString()
            password = md5(Password1.text.toString())

            Log.d(TAG, "Tipo Documento" + tipo_documento)
            Log.d(ContentValues.TAG, "Numero Documento" + numero_documento)
            Log.d(ContentValues.TAG, "Fecha de Nacimiento" + nacimiento)
            Log.d(ContentValues.TAG, "Fecha expedicion Documento" + expedicion_documento)
            Log.d(ContentValues.TAG, "Genero" + genero)
            Log.d(ContentValues.TAG, "Email" + email)
            Log.d(ContentValues.TAG, "Password" + password)

            if(tipo_documento.length > 0 && numero_documento.length > 0 && nacimiento.length > 0 && expedicion_documento.length > 0
                && genero.length > 0 && email.length > 0 && password.length > 0){
                val ventana = Intent(this, FinalizarActivity::class.java)
                startActivity(ventana)
            }
            else{
                val builder = AlertDialog.Builder(this@DatosActivity)
                builder.setTitle("Error Ingresando la Información")
                builder.setIcon(R.drawable.ic_logo)
                builder.setMessage("Para poder proceder al regitro todos los datos deberan estar llenos")
                builder.setPositiveButton("Aceptar") { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        "Ok, we change the app background.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                val dialog: AlertDialog = builder.create()
                dialog.show()





            }


        }

    }

    private fun updateDateInView(){
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat,Locale.US)
        Fecnacimiento.setText(sdf.format(cal.time))
        TextFechNacimiento.setVisibility(View.VISIBLE)

    }

    private fun updateDateInView_1(){
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat,Locale.US)
        Fecdocumento.setText(sdf.format(cal_1.time))
        TextExpDoc.setVisibility(View.VISIBLE)

    }



    public fun tipo_documento(): String {
        return tipo_documento;
    }
    public fun numero_documento(): String {
        return numero_documento;
    }
    public fun expedicion_documento(): String {
        return expedicion_documento;
    }
    public fun nacimiento(): String {
        return nacimiento;
    }
    public fun genero(): String {
        return genero;
    }
    public fun email(): String {
        return email;
    }
    public fun password(): String {
        return password;
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

}





