/**
 * Actividad principal de la aplicación, donde se configura la UI base.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura para que el contenido se dibuje detrás de las barras del sistema
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Vincula el layout usando ViewBinding
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        // Asigna la barra superior (Toolbar) como ActionBar
        setSupportActionBar(binding.toolbar)
    }
}