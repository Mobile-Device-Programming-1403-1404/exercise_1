import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFBE5985),
    secondary = Color(0xFF3D0301),
    onPrimaryContainer =  Color(0xFFFFEDFA),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBE5985),
    secondary = Color(0xFF3D0301),
    onPrimaryContainer = Color(0xFFFFEDFA),
    )

@Composable
fun ResumeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}

