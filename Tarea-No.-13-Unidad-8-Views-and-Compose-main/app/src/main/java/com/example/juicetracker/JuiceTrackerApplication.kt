/**
 * Clase `Application` personalizada para inicializar dependencias globales.
 */
class JuiceTrackerApplication : Application() {

    // Contenedor de dependencias que puede usarse en toda la app
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        // Se inicializa el contenedor de dependencias
        container = AppDataContainer(this)
    }
}