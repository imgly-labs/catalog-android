package ly.img.catalog.data

import ly.img.catalog.examples.Example
import ly.img.catalog.examples.ShowPhotoEditor

val items = arrayListOf(
    ExampleItem("Show Editor", "Presents the photo editor", Product.PESDK, ShowPhotoEditor),
    ExampleItem("Show Editor", "Presents the video editor", Product.VESDK, ShowPhotoEditor),
)

data class ExampleItem(val title: String, val subtitle: String, val product: Product, val example: Example)

enum class Product {
    PESDK,
    VESDK,
    BOTH
}