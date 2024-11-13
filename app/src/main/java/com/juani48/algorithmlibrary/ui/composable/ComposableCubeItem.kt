package com.juani48.algorithmlibrary.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juani48.algorithmlibrary.R
import com.juani48.algorithmlibrary.application.entity.Cube

@Preview
@Composable
fun TestCubeItem(){
    CubeItem(Cube(0,"Cube 0")) {}
}

@Composable
fun CubeItem(cube: Cube, onCubeClicked: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .padding(10.dp)
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onCubeClicked(cube.id) },
            colors = CardDefaults.cardColors(containerColor = colorResource(R.color._fronground))
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = cube.name,
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = cube.id.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}