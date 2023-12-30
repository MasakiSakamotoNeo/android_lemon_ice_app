package com.example.lemoniceapp.ui.main.component.timeline

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.lemoniceapp.R

private const val HeaderIndex = -1

@ExperimentalFoundationApi
@Composable
fun <E : TimeLineItem> TimeLine(
    items: List<E>,
    modifier: Modifier = Modifier,
    timeLineOption: TimeLineOption = TimeLineOption(),
    timeLinePadding: TimeLinePadding = TimeLinePadding(),
    header: @Composable (String) -> Unit,
    content: @Composable (E) -> Unit
) {

    Column(
        modifier = modifier
    ) {
        val groupedItems = items.groupBy { it.title }
        groupedItems.onEachIndexed { groupIndex, (key, elements) ->
            TimeLineView(
                title = key,
                item = elements.first(),
                groupSize = groupedItems.size,
                groupIndex = groupIndex,
                elementsSize = elements.size,
                elementsIndex = HeaderIndex,
                timeLineOption = timeLineOption,
                timeLinePadding = timeLinePadding,
                isHeader = true,
                header = header,
                content = content
            )

            elements.forEachIndexed { elementIndex, element ->
                TimeLineView(
                    title = key,
                    item = element,
                    groupSize = groupedItems.size,
                    groupIndex = groupIndex,
                    elementsSize = elements.size,
                    elementsIndex = elementIndex,
                    timeLineOption = timeLineOption,
                    timeLinePadding = timeLinePadding,
                    isHeader = false,
                    header = header,
                    content = content
                )
            }
        }
    }
}

@Composable
private fun <E : TimeLineItem> TimeLineView(
    title: String,
    item: E,
    groupSize: Int,
    groupIndex: Int,
    elementsSize: Int,
    elementsIndex: Int,
    timeLineOption: TimeLineOption,
    timeLinePadding: TimeLinePadding,
    isHeader: Boolean,
    header: @Composable (String) -> Unit,
    content: @Composable (E) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(timeLineOption.contentHeight)
    ) {
        val (circle, circleInnerLine, topLine, bottomLine, timeLineContent) = createRefs()
        Image(
            painter = painterResource(R.drawable.timeline_icon),
            contentDescription = "Item Image",
            modifier = Modifier
                .size(timeLineOption.circleSize)
                .constrainAs(circle) {
                    start.linkTo(parent.start)
                    top.linkTo(timeLineContent.top)
                    bottom.linkTo(timeLineContent.bottom)
                }
                .alpha(if (isHeader) 1f else 0f)
        )
        if (!isHeader) {
            Divider(
                modifier = Modifier
                    .constrainAs(circleInnerLine) {
                        top.linkTo(circle.top)
                        bottom.linkTo(circle.bottom)
                        start.linkTo(circle.start)
                        end.linkTo(circle.end)
                        width = Dimension.value(timeLineOption.lineWidth)
                        height = Dimension.fillToConstraints
                    },
                color = timeLineOption.lineColor
            )
        }
        Surface(
            modifier = Modifier.constrainAs(timeLineContent) {
                start.linkTo(circle.end, timeLinePadding.contentStart)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        ) {
            if (isHeader) {
                header(title)
            } else if (groupIndex != groupSize - 1) {
                content(item)
            }
        }
        if (!(groupIndex == 0 && elementsIndex == HeaderIndex)) {
            Divider(
                modifier = Modifier
                    .constrainAs(topLine) {
                        top.linkTo(parent.top)
                        bottom.linkTo(
                            circle.top,
                            if (isHeader) timeLinePadding.circleLineGap else 0.dp
                        )
                        start.linkTo(circle.start)
                        end.linkTo(circle.end)
                        width = Dimension.value(timeLineOption.lineWidth)
                        height = Dimension.fillToConstraints
                    },
                color = timeLineOption.lineColor
            )
        }
        if (!(groupIndex == groupSize - 1 && elementsIndex == elementsSize - 1)) {
            Divider(
                modifier = Modifier.constrainAs(bottomLine) {
                    top.linkTo(
                        circle.bottom,
                        if (isHeader) timeLinePadding.circleLineGap else 0.dp
                    )
                    bottom.linkTo(parent.bottom)
                    start.linkTo(circle.start)
                    end.linkTo(circle.end)
                    width = Dimension.value(timeLineOption.lineWidth)
                    height = Dimension.fillToConstraints
                },
                color = timeLineOption.lineColor
            )
        }
    }
}
