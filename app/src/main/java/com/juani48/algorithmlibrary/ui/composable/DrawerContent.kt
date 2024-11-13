package com.juani48.algorithmlibrary.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juani48.algorithmlibrary.R
import com.juani48.algorithmlibrary.ui.item.DrawerItem

@Preview
@Composable
fun Test(){
    DrawerContent() {  }
}

@Composable
fun DrawerContent(onItemClick: (DrawerItem) -> Unit) {
    val items: List<DrawerItem> = DrawerItem.entries
    ModalDrawerSheet(
        drawerContainerColor = colorResource(R.color._fronground)
    ) {
        Column(
            modifier = Modifier
                .padding(30.dp)
        ) {
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Menu de opciones",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                color = colorResource(R.color._text),
                fontStyle = FontStyle.Italic,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            HorizontalDivider(
                color = colorResource(R.color._background),
                thickness = 3.dp
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column {
                items.forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable { onItemClick(it) }
                    ) {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 10.dp),
                            tint = colorResource(R.color._text),

                            )
                        Text(
                            text = it.text,
                            fontSize = 20.sp,
                            color = colorResource(R.color._text)
                        )
                    }
                }
            }
        }
    }
}