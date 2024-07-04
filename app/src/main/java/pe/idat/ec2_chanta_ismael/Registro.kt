package pe.idat.ec2_chanta_ismael

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pe.idat.ec2_chanta_ismael.ui.theme.EC2CHANTAISMAELTheme

data class Book(val title: String, val description: String, val publishDate: String)

@Composable
fun BookList(books: List<Book>) {
    LazyColumn {
        items(books) { book ->
            BookCard(book)
        }
    }
}

@Composable
fun BookCard(book: Book) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(), elevation = 4.dp) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = book.title, style = MaterialTheme.typography.titleLarge)
            Text(text = book.description, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Published: ${book.publishDate}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

fun Card(modifier: Modifier, elevation: Dp, content: @Composable() (ColumnScope.() -> Unit)) {
    TODO("Not yet implemented")
}

@Composable
fun BookListScreen() {
    val books = listOf(
        Book("Clean Code", "A Handbook of Agile Software Craftsmanship", "2008"),
        Book("The Pragmatic Programmer", "Your Journey to Mastery", "1999"),
        Book("Design Patterns", "Elements of Reusable Object-Oriented Software", "1994"),

    )
    BookList(books)
}

class BookListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EC2CHANTAISMAELTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    BookListScreen()
                }
            }
        }
    }
}
