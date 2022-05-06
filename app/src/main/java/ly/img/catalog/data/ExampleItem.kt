package ly.img.catalog.data

import ly.img.catalog.examples.Example
import ly.img.catalog.examples.ShowPhotoEditor
import kotlin.reflect.KClass

val items = arrayListOf(
    ExampleItem("Show Editor", "Presents the photo editor", Product.PESDK, ShowPhotoEditor::class.java),
    ExampleItem("Show Editor", "Presents the video editor", Product.VESDK, ShowPhotoEditor::class.java),
)

data class ExampleItem(val title: String, val subtitle: String, val product: Product, val example: Class<out Example>)

enum class Product {
    PESDK,
    VESDK,
    BOTH
}