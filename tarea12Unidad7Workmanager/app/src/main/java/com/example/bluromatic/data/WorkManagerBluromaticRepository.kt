package com.example.bluromatic.data

import android.content.Context
import android.net.Uri
import androidx.lifecycle.asFlow
import androidx.work.*
import com.example.bluromatic.*
import com.example.bluromatic.workers.BlurWorker
import com.example.bluromatic.workers.CleanupWorker
import com.example.bluromatic.workers.SaveImageToFileWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class WorkManagerBluromaticRepository(context: Context) : BluromaticRepository {
    private val workManager = WorkManager.getInstance(context)
    private var imageUri: Uri = context.getImageUri()

    /*override val outputWorkInfo: Flow<WorkInfo> = workManager.getWorkInfosByTagLiveData(TAG_OUTPUT)
                                                             .asFlow()
                                                             .mapNotNull { if (it.isNotEmpty()) it.first() else null }
*/
    override val outputWorkInfo: Flow<WorkInfo> = workManager.getWorkInfosByTagLiveData(TAG_OUTPUT)
                                                              .asFlow()
                                                              .mapNotNull { if (it.isNotEmpty()) it.first() else null }


    override fun applyBlur(blurLevel: Int) {
        var continuation = workManager.beginUniqueWork(IMAGE_MANIPULATION_WORK_NAME,
                                                       ExistingWorkPolicy.REPLACE,
                                                       OneTimeWorkRequest.from(CleanupWorker::class.java))

        val constraints = Constraints.Builder()                        //3
                                     .setRequiresBatteryNotLow(true)   //4
                                     .build()                          //5

        val blurBuilder = OneTimeWorkRequestBuilder<BlurWorker>()

        blurBuilder.setInputData(createInputDataForWorkRequest(blurLevel, imageUri))
        blurBuilder.setConstraints(constraints)

        continuation = continuation.then(blurBuilder.build())

        val save = OneTimeWorkRequestBuilder<SaveImageToFileWorker>().addTag(TAG_OUTPUT)
                                                                     .build()

        continuation = continuation.then(save)
        continuation.enqueue()
    }

    /*override fun applyBlur(blurLevel: Int) {
        val blurBuilder= OneTimeWorkRequestBuilder<BlurWorker>()
        var continuation=workManager.beginWith(OneTimeWorkRequest.Companion.from(CleanupWorker::class.java))

        blurBuilder.setInputData(createInputDataForWorkRequest(blurLevel, imageUri))
        workManager.enqueue(blurBuilder.build())
        continuation=continuation.then(blurBuilder.build())
        val save= OneTimeWorkRequestBuilder<SaveImageToFileWorker>().build()
        continuation=continuation.then(save)
        continuation.enqueue()
    }
*/
    override fun cancelWork() { workManager.cancelUniqueWork(IMAGE_MANIPULATION_WORK_NAME) }

    private fun createInputDataForWorkRequest(blurLevel: Int, imageUri: Uri): Data {
        val builder = Data.Builder()
        builder.putString(KEY_IMAGE_URI, imageUri.toString()).putInt(KEY_BLUR_LEVEL, blurLevel)
        return builder.build()
    }
}
