package com.mboti.draghandleex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Example1() {
    ModalBottomSheet(
        modifier = Modifier,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false),
        onDismissRequest = {},
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    ) {
        CustomBottomSheetContainer()
    }
}


@Composable
fun CustomBottomSheetContainer() {
    Scaffold(topBar = {
        Column {
            Text(
                text = "Theme",
                fontSize = 23.sp,
                modifier = Modifier
                    .height(75.dp)
                    .padding(start = 29.dp, top = 26.dp),
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Black)
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                text = "Select theme",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 29.dp, top = 20.dp, bottom = 10.dp)
                    .height(40.dp)
            )
            CustomItem("Light")
            CustomItem("Dark")
            CustomItem("System default")
        }
    }
}


@Composable
fun CustomItem(text: String) {
    Row(modifier = Modifier.height(40.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier.padding(start = 31.dp, top = 9.dp), contentDescription = ""
        )
        Text(
            text = text,
            fontSize = 18.sp,
            modifier = Modifier
                .height(40.dp)
                .padding(start = 20.dp, top = 11.dp)
        )
    }
}