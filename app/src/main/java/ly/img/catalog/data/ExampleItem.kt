package ly.img.catalog.data

val items = arrayListOf(
    ExampleItem("Show Editor", "Presents the photo editor"),
    ExampleItem("Show Editor", "Presents the video editor"),
)

data class ExampleItem(val title: String, val subtitle: String)