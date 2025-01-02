//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.material.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlin.random.Random
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MathGame()
//        }
//    }
//}
//
//@Composable
//fun MathGame() {
//    var number1 by remember { mutableStateOf(0) }
//    var number2 by remember { mutableStateOf(0) }
//    var result by remember { mutableStateOf(0) }
//    var missingIndex by remember { mutableStateOf(0) }
//    var userAnswer by remember { mutableStateOf(TextFieldValue("")) }
//    var isGameOver by remember { mutableStateOf(false) }
//    var score by remember { mutableStateOf(0) }
//
//    LaunchedEffect(Unit) {
//        generateEquation { num1, num2, res, missingIdx ->
//            number1 = num1
//            number2 = num2
//            result = res
//            missingIndex = missingIdx
//        }
//    }
//
//    if (isGameOver) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxSize().padding(16.dp)
//        ) {
//            Text("Game Over!", style = MaterialTheme.typography.h4)
//            Spacer(modifier = Modifier.height(16.dp))
//            Text("Your score: $score", style = MaterialTheme.typography.h5)
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = {
//                score = 0
//                isGameOver = false
//                generateEquation { num1, num2, res, missingIdx ->
//                    number1 = num1
//                    number2 = num2
//                    result = res
//                    missingIndex = missingIdx
//                }
//            }) {
//                Text("Restart")
//            }
//        }
//    } else {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxSize().padding(16.dp)
//        ) {
//            Text("Solve the equation:", style = MaterialTheme.typography.h6)
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                if (missingIndex == 0) {
//                    AnswerTextField(userAnswer) { userAnswer = it }
//                } else {
//                    Text("$number1", style = MaterialTheme.typography.h4)
//                }
//
//                Spacer(modifier = Modifier.width(8.dp))
//                Text("+", style = MaterialTheme.typography.h4)
//                Spacer(modifier = Modifier.width(8.dp))
//
//                if (missingIndex == 1) {
//                    AnswerTextField(userAnswer) { userAnswer = it }
//                } else {
//                    Text("$number2", style = MaterialTheme.typography.h4)
//                }
//
//                Spacer(modifier = Modifier.width(8.dp))
//                Text("=", style = MaterialTheme.typography.h4)
//                Spacer(modifier = Modifier.width(8.dp))
//
//                if (missingIndex == 2) {
//                    AnswerTextField(userAnswer) { userAnswer = it }
//                } else {
//                    Text("$result", style = MaterialTheme.typography.h4)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Button(onClick = {
//                val answer = userAnswer.text.toIntOrNull()
//                val correctAnswer = when (missingIndex) {
//                    0 -> number1
//                    1 -> number2
//                    2 -> result
//                    else -> 0
//                }
//
//                if (answer == correctAnswer) {
//                    score++
//                    userAnswer = TextFieldValue("")
//                    generateEquation { num1, num2, res, missingIdx ->
//                        number1 = num1
//                        number2 = num2
//                        result = res
//                        missingIndex = missingIdx
//                    }
//                } else {
//                    isGameOver = true
//                }
//            }) {
//                Text("Submit")
//            }
//        }
//    }
//}
//
//@Composable
//fun AnswerTextField(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
//    BasicTextField(
//        value = value,
//        onValueChange = onValueChange,
//        modifier = Modifier.width(50.dp).height(50.dp),
//        textStyle = MaterialTheme.typography.h4
//    )
//}
//
//fun generateEquation(onGenerated: (Int, Int, Int, Int) -> Unit) {
//    val num1 = Random.nextInt(1, 10)
//    val num2 = Random.nextInt(1, 10)
//    val result = num1 + num2
//    val missingIndex = Random.nextInt(0, 3)
//    onGenerated(num1, num2, result, missingIndex)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MathGame()
//}
