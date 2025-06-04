import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import androidx.work.ListenableWorker
import androidx.work.testing.TestListenableWorkerBuilder
import androidx.work.workDataOf
import com.example.bluromatic.KEY_IMAGE_URI
import com.example.bluromatic.workers.BlurWorker
import com.example.bluromatic.workers.CleanupWorker
import com.example.bluromatic.workers.SaveImageToFileWorker
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WorkerInstrumentationTest {
    private lateinit var context: Context
    private val mockUriInput: Pair<String, String> =
        KEY_IMAGE_URI to "android.resource://com.example.bluromatic/drawable/android_cupcake"

    @Before fun setUp() { context = ApplicationProvider.getApplicationContext() }


   @Test fun cleanupWorker_doWork_resultSuccess() {
        val worker = TestListenableWorkerBuilder<CleanupWorker>(context).build()
        runBlocking {
            val result = worker.doWork()
            assertTrue(result is ListenableWorker.Result.Success)
        }
    }

   @Test fun blurWorker_doWork_resultSuccessReturnsUri() {
       val worker = TestListenableWorkerBuilder<BlurWorker>(context).setInputData(workDataOf(mockUriInput)).build()
       runBlocking {
           val result = worker.doWork()
           val resultUri = result.outputData.getString(KEY_IMAGE_URI)
       }
    }

   @Test fun saveImageToFileWorker_doWork_resultSuccessReturnsUrl() {
       val worker = TestListenableWorkerBuilder<SaveImageToFileWorker>(context).setInputData(workDataOf(mockUriInput)).build()
       runBlocking {
           val result = worker.doWork()
           val resultUri = result.outputData.getString(KEY_IMAGE_URI)
           assertTrue(result is ListenableWorker.Result.Success)
           assertTrue(result.outputData.keyValueMap.containsKey(KEY_IMAGE_URI))
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
               TestCase.assertTrue(
                   resultUri?.startsWith("content://media/external_primary/images/media/")
                        ?: false
               )
           } else {
               TestCase.assertTrue(
                   resultUri?.startsWith("content://media/external/images/media/")
                       ?: false
               )
            }
        }
    }
}
