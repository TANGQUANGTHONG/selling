
package com.example.kotlin.diem_cong_asm

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun dang_ky_demo() {
    Box(modifier = Modifier.fillMaxSize(),) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,) {
            Image(painter = painterResource(id = R.drawable.rua), contentDescription = null)

            Text(text = "Let's Get Started",
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "Create an new account",
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                fontWeight = FontWeight.Light)
            TextField(
                value = "", onValueChange = { null },
                Modifier
                    .background(color = Color.Gray)
                    .fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            TextField(
                value = "**********", onValueChange = { null },
                Modifier
                    .background(color = Color.Gray)
                    .fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            TextField(
                value = "**********", onValueChange = { null },
                Modifier
                    .background(color = Color.Gray)
                    .fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            TextField(
                value = "**********", onValueChange = { null },
                Modifier
                    .background(color = Color.Gray)
                    .fillMaxWidth().padding(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(10.dp)
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                shape = RoundedCornerShape(10.dp),

                ) {
                Text(text = "Sign in")
            }
            Row (   modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                ,horizontalArrangement = Arrangement.Center){
                Text(text = "have a account")
                Text(text = "Sign up", color = Color.Blue)
            }
        }
    }
}