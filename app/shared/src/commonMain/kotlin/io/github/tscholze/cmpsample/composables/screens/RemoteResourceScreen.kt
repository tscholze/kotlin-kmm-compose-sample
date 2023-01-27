package io.github.tscholze.cmpsample.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.model.SnippetConfiguration
import io.github.tscholze.cmpsample.navigation.AppScreens
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

@Composable
internal fun RemoteResourceScreen(router: Router<AppScreens>) {

    // MARK: - Properties -

    val scope = rememberCoroutineScope()
    var posts by remember { mutableStateOf(emptyList<SnippetConfiguration>()) }

    val client = HttpClient(CIO) {
        // Configure http client.
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    // MARK: - Helper -

    val uriHandler = LocalUriHandler.current

    // MARK: - LaunchedEffect -

    LaunchedEffect(true) {
        // Fetch posts on launch
        scope.launch {
            posts = client
                .get("https://tscholze.github.io/blog/posts.json")
                .body<List<SnippetConfiguration>>()
                .sortedBy { it.created }
                .reversed()
        }
    }

    // MARK: - UI -

    PageLayout("Remote Resources", router) {
        // 1. Info block
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(MaterialTheme.colors.secondary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "The following posts are fetch from an url",
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.padding(horizontal = 8.dp)

                    )
            }

            // 2. List of all items
            LazyColumn {
                itemsIndexed(posts) { index, post ->
                    Column {
                        Column(
                            modifier = Modifier.padding(vertical = 8.dp)
                                .clickable {
                                    uriHandler.openUri(post.url)
                                }
                        ) {
                            Text(post.title, fontWeight = FontWeight.Medium)
                            Text(
                                post.created,
                                style = MaterialTheme.typography.caption,
                                fontStyle = FontStyle.Italic
                            )
                        }

                        // Show divider if current item is not the last one.
                        if (index < posts.lastIndex) {
                            Divider(
                                color = MaterialTheme.colors.secondaryVariant,
                                thickness = 0.5.dp
                            )
                        }
                    }
                }
            }
        }
    }
}