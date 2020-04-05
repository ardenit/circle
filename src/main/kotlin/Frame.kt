import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import javax.swing.JFrame
import javax.swing.WindowConstants

class Frame : JFrame() {

    private val panel = Panel()

    init {
        title = "Circle!"
        contentPane.add(panel)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        val mouseMotionListener = object : MouseMotionListener {

            override fun mouseMoved(e: MouseEvent?) {
                e ?: return
                panel.mouseX = e.x
                panel.mouseY = e.y
            }

            override fun mouseDragged(e: MouseEvent?) {
                mouseMoved(e)
            }

        }
        addMouseMotionListener(mouseMotionListener)
        setSize(800, 600)
        isVisible = true
    }

}

fun main() {
    Frame()
}