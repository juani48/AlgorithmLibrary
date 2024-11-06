package com.juani48.algorithmlibrary.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juani48.algorithmlibrary.R
import com.juani48.algorithmlibrary.application.entity.Cube
import com.juani48.algorithmlibrary.application.vm.CubeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var cubeViewModel: CubeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            this.cubeViewModel.init()
            MainApp(this.cubeViewModel)
        }
    }
}

@Preview
@Composable
fun Preview(){

}

@Composable
fun MainApp(cubeViewModel: CubeViewModel) {

    val list: List<Cube> by cubeViewModel.cubeList.observeAsState(initial = listOf())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Title()
        ListOfCubes(list)
    }
}

@Composable
fun Title() {
    Box(modifier = Modifier.padding(20.dp)) {
        Text(
            text = stringResource(R.string.main_title),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
    }
}

@Composable
fun ListOfCubes(list: List<Cube>) {
    Box(modifier = Modifier.padding(10.dp)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(list) { x ->
                Text(
                    text = x.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

