@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.jettipapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettipapp.components.InputField
import com.example.jettipapp.ui.theme.JetTipAppTheme
import com.example.jettipapp.utils.calculateTotalPerPerson
import com.example.jettipapp.utils.calculateTotalTip
import com.example.jettipapp.widgets.RoundIconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
//                TopHeader()
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetTipAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                content()
            }

        }
    }
}

//@Preview
@Composable
fun MainContent() {


    BillForm()

}

//@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 0.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(all = 18.dp)
            .clip(shape = RoundedCornerShape(CornerSize(12.dp))),
        color = Color(0xFFB89FE2)
    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "Total Per Person",
//                modifier=Modifier.padding(6.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            Text(
                text = "$$total",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    onValChange: (String) -> Unit = {}
) {
    val totalBillState = remember {
        mutableStateOf("")
    }
    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val numberOfPeople = remember {
        mutableStateOf(1)
    }
    val range = IntRange(start = 1, endInclusive = 100)
    val sliderPositionState = remember {
        mutableStateOf(0f)
    }
// for tip
    var tipPercentage = (sliderPositionState.value * 100).toInt()
//    val tipPercentFormat = "%.2f".format(tip)
    val tipAmountState = remember {
        mutableStateOf(0.0)
    }

    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }
    TopHeader(totalPerPerson = totalPerPersonState.value)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(
                modifier = Modifier.fillMaxWidth(),
                valueState = totalBillState,
                labelId = "Enter Bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions

                    onValChange(totalBillState.value.trim())

                    keyboardController?.hide()
                }
            )

            if(validState){
                //Split section
                Row(
                    modifier = Modifier
                        .width(300.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Split",
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RoundIconButton(
                            imageVector = Icons.Default.Remove,
                            onClick = {
                                if (numberOfPeople.value > 1) {
                                    numberOfPeople.value--
                                }
                                totalPerPersonState.value = calculateTotalPerPerson(
                                    totalBill = (totalBillState.value).toDouble(),
                                    splitBy = numberOfPeople.value,
                                    tipPercentage = tipPercentage
                                )
                            },
                            backgroundColor = Color.White
                        )
                        Text(
                            text = "${numberOfPeople.value}",
                            modifier = Modifier.padding(start = 9.dp, end = 9.dp),
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )
                        RoundIconButton(
                            imageVector = Icons.Default.Add,
                            onClick = {
                                if (numberOfPeople.value < range.last) {
                                    numberOfPeople.value++
                                }
                                totalPerPersonState.value = calculateTotalPerPerson(
                                    totalBill = (totalBillState.value).toDouble(),
                                    splitBy = numberOfPeople.value,
                                    tipPercentage = tipPercentage
                                )
                            },
                            backgroundColor = Color.White
                        )
                    }
                }

                //Tip section

                Row(
                    modifier = Modifier
                        .width(300.dp)
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Tip",
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "$${tipAmountState.value}",
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Percentage

                    Text(
                        text = "$tipPercentage %",
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Spacer(modifier = modifier.height(14.dp))
                    //Slider
                    Slider(
                        value = sliderPositionState.value,
                        onValueChange = { newVal ->
                            sliderPositionState.value = newVal
                            tipAmountState.value = calculateTotalTip(
                                totalBill = (totalBillState.value).toDouble(),
                                tipPercentage = tipPercentage
                            )
                            totalPerPersonState.value = calculateTotalPerPerson(
                                totalBill = (totalBillState.value).toDouble(),
                                splitBy = numberOfPeople.value,
                                tipPercentage = tipPercentage
                            )
//                    Log.d("sliderValue","$newVal")
                        },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
//                    steps = 5,
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFF8A6EBB),
                            activeTrackColor = Color(0xFF8A6EBB)
                        )
                    )
                }
            }

            else{
                Box(){
                    
                }
            }


        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
//        TopHeader()
        MainContent()
    }
}