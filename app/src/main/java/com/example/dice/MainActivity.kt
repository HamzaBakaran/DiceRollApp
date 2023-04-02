package com.example.dice

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dice.ui.theme.DiceTheme
import com.example.dice.ui.theme.Purple200
import com.example.dice.ui.theme.Purple500
import com.example.dice.ui.theme.Purple700
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceTheme {
                DiceRollerApp()
            }
        }
    }
}
@Preview
@Composable
fun DiceRollerApp()
{
DiceWithButtonAndImage(modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
}

@Composable
fun showMessage(context: Context, message:String){
   Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

}


@Composable
fun DiceWithButtonAndImage(modifier: Modifier=Modifier)
{

    var result by remember {
        mutableStateOf(1)
    }
    val imageResource=when(result)
    {
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column() {
        Spacer(modifier = Modifier.height(125.dp))
        Text(text = "WELCOME TO DICE ROLL APP",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = androidx.compose.ui.text.TextStyle(
                fontSize=24.sp,
                color = Purple500,
                fontWeight = FontWeight.Bold
            )
        )
    }

Column(modifier = modifier,
horizontalAlignment = Alignment.CenterHorizontally) {


    Image(painter = painterResource(id = imageResource), contentDescription =result.toString() )
    Spacer(modifier = Modifier.height(25.dp))
    Button(onClick = { result=(1..6).random() }) {
    Text(stringResource(R.string.roll))
    
}



}
    showMessage(LocalContext.current,"You rolled $result")
}

