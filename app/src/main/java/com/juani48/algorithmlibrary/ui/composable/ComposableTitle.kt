package com.juani48.algorithmlibrary.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juani48.algorithmlibrary.R

@Preview
@Composable
fun TestTitle(){
    Title("Test Title")
}

@Composable
fun Title(string: String) {
    Text(
        text = string,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        color = colorResource(R.color._text),
    )
    Spacer(modifier = Modifier.height(15.dp))
    HorizontalDivider(
        color = colorResource(R.color._text),
        thickness = 3.dp
    )
    Spacer(modifier = Modifier.height(30.dp))
}