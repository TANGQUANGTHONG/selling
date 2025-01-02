import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.ui.theme.KotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SaoPoem(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun SaoPoem(modifier: Modifier = Modifier) {
    Surface() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "SAO",
                modifier = modifier.padding(16.dp),
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // Phần 1

            Row {
                Text(text = "Một ngôi ", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "sao", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = " vừa rơi", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Text(text = "Vụt tắt trên bầu trời", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Hay là tên người ấy", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Vụt tắt ở trong tôi?", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)

            // Phần 2
            Text(text = "")
            Text(text = "Vẫn thấy trên bầu trời", color = Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row {
                Text(text = "Có muôn vạn ", color = Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "sao", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = " sáng", color = Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Text(text = "Mà ở trong lòng tôi", color = Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Như một hành lang vắng.", color = Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.Bold)

            // Phần 3
            Text(text = "")
            Text(text = "Một ngôi ", color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row {
                Text(text = "sao", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = " vừa tắt", color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Text(text = "Bầu trời vẫn không buồn", color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row {
                Text(text = "Sao", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = " tên người ấy tắt", color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Text(text = "Trong lòng tôi cô đơn?", color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    KotlinTheme {

    }
}
