import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.resume.R
import com.example.resume.model.StudentInfo
import com.example.resume.viewmodel.StudentViewModel
import com.lightspark.composeqr.DotShape
import com.lightspark.composeqr.QrCodeColors
import com.lightspark.composeqr.QrCodeView

@Composable
fun StudentInfo(studentViewModel: StudentViewModel) {
    val studentInfo = studentViewModel.studentInfo

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val boxWidth = screenWidth * 0.70f
    val boxHeight = screenHeight * 0.75f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(boxWidth)
                .height(boxHeight)
                .background(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularImage(studentInfo.photoResId)

                Spacer(modifier = Modifier.height(16.dp))

                StudentInfoText(studentInfo)

                Spacer(modifier = Modifier.height(16.dp))

                TelegramQrCode(studentInfo.telegramId)
            }
        }
    }
}

@Composable
fun CircularImage(photoResId: Int) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = photoResId),
            contentDescription = "Student Photo",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
fun StudentInfoText(studentInfo: StudentInfo) {
    Text(
        text = studentInfo.studentId,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary
    )
    Text(
        text = studentInfo.telegramId,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun TelegramQrCode(telegramId: String) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.White)
    ) {
        QrCodeView(
            data = "https://t.me/$telegramId",
            modifier = Modifier.fillMaxSize(),
            colors = QrCodeColors(
                background = Color.White,
                foreground = Color.Black
            ),
            dotShape = DotShape.Square
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.telegram),
                    contentDescription = "Telegram Logo",
                    modifier = Modifier
                        .size((100.dp.value * 0.25f).dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}