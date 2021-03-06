package com.vianabrothers.android.tvmaze.utils

import android.os.Build
import android.text.Html
import android.text.Spanned

class HtmlParse {
    fun parseHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(html)
        }
    }
}