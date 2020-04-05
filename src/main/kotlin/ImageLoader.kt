import java.awt.Image
import java.io.File
import javax.imageio.ImageIO

class ImageLoader {

    private val cachedImages = HashMap<String, Image?>()

    fun getImage(name: String): Image? {
        val image = when {
            name in cachedImages -> {
                cachedImages[name]
            }
            File("./assets/$name.png").exists() -> {
                ImageIO.read(File("./assets/$name.png"))
            }
            File("./$name.png").exists() -> {
                ImageIO.read(File("./$name.png"))
            }
            else -> null
        }
        cachedImages[name] = image
        return image
    }

}