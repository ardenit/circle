import java.awt.Graphics
import javax.swing.JPanel
import javax.swing.SwingUtilities
import kotlin.concurrent.fixedRateTimer
import kotlin.math.min
import kotlin.math.sqrt

class Panel : JPanel() {

    private val imageLoader = ImageLoader()

    var mouseX = 0
    var mouseY = 0

    private var circleX = 0
    private var circleY = 0

    private var range = 0.0
    private val angryRange = 40.0

    private val circleSpeed = 5
    private val circleRadius = 50
    private val repaintPeriod = 10L
    private val horizontalMargin = 9
    private val verticalMargin = 38

    init {
        layout = null
        fixedRateTimer(period = repaintPeriod) {
            SwingUtilities.invokeLater {
                updateCircle()
                repaint()
            }
        }
    }

    private fun updateCircle() {
        val deltaX = (mouseX - circleX).toDouble()
        val deltaY = (mouseY - circleY).toDouble()
        val range = sqrt(deltaX * deltaX + deltaY * deltaY)
        this.range = range
        val maxRangePart = min(circleSpeed.toDouble() / range, 1.0)
        circleX += (deltaX * maxRangePart).toInt()
        circleY += (deltaY * maxRangePart).toInt()
    }

    public override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        g?.drawImage(imageLoader.getImage("sky"), 0, 0, width, height, null)
        g?.drawImage(
            imageLoader.getImage(if (range < angryRange) "nice" else "angry"),
            circleX - circleRadius - horizontalMargin,
            circleY - circleRadius - verticalMargin,
            circleRadius * 2,
            circleRadius * 2,
            null
        )
    }

}