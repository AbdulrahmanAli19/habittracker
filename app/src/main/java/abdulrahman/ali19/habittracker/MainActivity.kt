package abdulrahman.ali19.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import abdulrahman.ali19.habittracker.ui.theme.HabitTrackerTheme
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTrackerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HabitTrackerContent(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        state = UIState(
                            isPaid = BuildConfig.IS_PAID,
                        ),
                    )
                }
            }
        }
    }
}

@Composable
fun HabitTrackerContent(
    state: UIState,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = state.previewText,
            modifier = Modifier.padding(16.dp),
            style = TextStyle(
                textAlign = TextAlign.Center
            )
        )
        Button(
            modifier = Modifier.padding(top = 24.dp),
            enabled = state.isButtonEnabled,
            onClick = {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Click Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HabitTrackerContentEnabledPreview() {
    HabitTrackerTheme {
        HabitTrackerContent(
            state = UIState(
                isPaid = true,
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HabitTrackerContentDisabledPreview() {
    HabitTrackerTheme {
        HabitTrackerContent(
            state = UIState(
                isPaid = false,
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}