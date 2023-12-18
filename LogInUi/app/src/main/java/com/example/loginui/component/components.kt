package com.example.loginui.component

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun CustomTextFiled(
    modifier:Modifier=Modifier,
    text:String,
    isEnabled: Boolean=true,
    maxLines: Int =1,
    keyboardType: KeyboardType=KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Done,
    keyboardOptions: KeyboardOptions= KeyboardOptions(
        keyboardType = keyboardType,
        imeAction = imeAction
    ),
    keyboardActions: KeyboardActions=KeyboardActions.Default,
    shape: Shape= RoundedCornerShape(corner = CornerSize(16.dp)),
    containerColor: Color = MaterialTheme.colorScheme.background,

){
    val usrNumber= remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = usrNumber.value,
        onValueChange = {
                        usrNumber.value=it
        },
        label = {
            Text(text = text)
        },
        modifier=modifier,
        enabled=isEnabled,
        keyboardOptions=keyboardOptions,
        maxLines=maxLines,
        shape = shape,
        colors = TextFieldDefaults.textFieldColors(
            containerColor=containerColor,
        )
    )
}