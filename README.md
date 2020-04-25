# imageboard-backend

This is the backend server behind my imageboard project. It let users
create posts with images and query them. Posts are organized by boards. You can
query all original posts (OPs) from the catalog page of explore a OP and their replies.

TODO: Most of these features. lmao

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start the postgresql database, run:

    docker-compose up

Don't forget to migrat the database before starting the server. To do so, simply
use:

    lein migratus migrate

Then, to start a web server for the application, run:

    lein ring server

## License

Copyright © 2020 FIXME
