package Cap2
//Correr en android studio
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textField = findViewById<EditText>(R.id.textField)
        val incorrectText = textField?.text.toString() ?: ""
        println("Incorrecto: '$incorrectText'")
        val correctText = textField?.text?.toString() ?: ""
        println("Correcto: '$correctText'")
    }
}