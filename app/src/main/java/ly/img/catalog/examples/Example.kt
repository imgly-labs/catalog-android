package ly.img.catalog.examples

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class Example(private val activity: AppCompatActivity) {

    companion object {
        const val GALLERY_REQUEST_CODE = 0x69
        const val EDITOR_REQUEST_CODE = 0x42
    }

    private var onSelect: ((uri: Uri) -> Unit)? = null

    abstract fun invoke()

    open fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        intent ?: return
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                intent.data?.let { onSelect?.invoke(it) } ?: showMessage("Invalid Uri")
            } else if (resultCode == Activity.RESULT_CANCELED) {
                showMessage("User cancelled selection")
            }
        }
    }

    fun selectImageFromGallery(onImageSelect: (uri: Uri) -> Unit) {
        onSelect = onImageSelect
        selectFromGallery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    }

    fun selectVideoFromGallery(onVideoSelect: (uri: Uri) -> Unit) {
        onSelect = onVideoSelect
        selectFromGallery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
    }

    fun showMessage(message: String) {
        Toast.makeText(activity.applicationContext, message, Toast.LENGTH_LONG).show()
    }

    private fun selectFromGallery(uri: Uri) {
        val intent = Intent(Intent.ACTION_PICK, uri)
        try {
            activity.startActivityForResult(intent, GALLERY_REQUEST_CODE)
        } catch (ex: ActivityNotFoundException) {
            showMessage("No Gallery app installed")
        }
    }
}