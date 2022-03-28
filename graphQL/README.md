#GraphQL sample (book-details)

<img height="125" src="pictures/graphql.png" width="120"/>

- Starts on `localhost:8080` by default
- queries can be sent through `/graphql` endpoint

It supports:
- <img src="pictures/playground.png" height="20" width="20"/> Playground  on `/playground` endpoint
- <img src="pictures/altair.jpg" height="20" width="20"/> Altair on `/altair` endpoint
- <img src="pictures/graphiql.png" height="20" width="20"/> GraphiQL on `/graphiql` endpoint
- <img src="pictures/voyager.png" height="50" width="100"/> Voyager on `/voyager` endpont

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
```