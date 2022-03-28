#GraphQL sample (book-details)

- Starts on `localhost:8080` by default
- queries can be sent through `/graphql` endpoint
- playground can be used on `/playground` endpoint

Include:
- DataFetchers
- buildSchema
- buildWiring

Data come from in memory Maps

GraphQL schema:

```graphql
type Query {
    bookById(id: ID): Book
    books: [Book]
}

type Book {
    id: ID
    name: String
    pageCount: Int
    author: Author
}

type Author {
    id: ID
    firstName: String
    lastName: String
}