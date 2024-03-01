package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxRed.bottom)
                    end.linkTo(boxRed.start)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(boxRed.top)
                    end.linkTo(boxRed.start)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    bottom.linkTo(boxRed.top)
                    start.linkTo(boxRed.end)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end)
                }
        )
    }
}

@Composable
fun ConstraintExampleGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val starGuide = createGuidelineFromStart(0.1F)
        val topGuide = createGuidelineFromTop(0.1F)
        val boxRef = createRef()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRef) {
                top.linkTo(topGuide)
                start.linkTo(starGuide)
            })
    }
}

@Composable
fun ConstrainBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(parent.start, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(225.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxRed.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(barrier)
            })
    }
}

@Preview
@Composable
fun ConstraintChainExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(parent.start)
                end.linkTo(boxGreen.start)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(boxRed.end)
                end.linkTo(boxYellow.start)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxGreen.end)
                end.linkTo(parent.end)
            })

        createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)
    }
}
