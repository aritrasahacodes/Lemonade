package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Lemonade("Steps to make a lemonade")
                }
            }
        }
    }
}
@Composable
fun Lemonade(message : String)
{
    var temp by remember { mutableStateOf(1) }
    val imageResource =when(temp)
    {
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        else ->R.drawable.lemon_restart
    }
    val title =when(temp)
    {
        1->R.string.mes_1
        2->R.string.mes_2
        3->R.string.mes_3
        else ->R.string.mes_4
    }
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize(), color = Color.Cyan) {
        Column (modifier = Modifier , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ){
            Text(text = stringResource(id = title), fontSize = 18.sp,
                modifier = Modifier.padding(top=16.dp, bottom = 16.dp))
            Image(painter = painterResource(id = imageResource), contentDescription =temp.toString(),
                modifier = Modifier
                    .border(width = 2.dp, color = Color.Yellow)
                    .clickable {
                        temp++
//                        if(temp==2)
//                        {
//                            ForTwo(1..10.random())
//                        }
                        if (temp > 4) {
                            temp = 1
                        }
                    })
        }
    }

}
//@Composable
//fun ForTwo(read : Int) {
//    val imageResource = R.drawable.lemon_squeeze
//    val title = R.string.mes_2
//    var temp by remember { mutableStateOf(read) }
//    while (temp != 0) {
//        androidx.compose.material.Surface(modifier = Modifier.fillMaxSize(), color = Color.Cyan) {
//            Column(
//                modifier = Modifier,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = stringResource(id = title), fontSize = 18.sp,
//                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
//                )
//                Image(painter = painterResource(id = imageResource),
//                    contentDescription = temp.toString(),
//                    modifier = Modifier
//                        .border(width = 2.dp, color = Color.Yellow)
//                        .clickable { temp-- })
//                //result = (1..6).random()
//            }
//        }
//    }
//}
@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade("Steps to make a lemonade")
    }
}