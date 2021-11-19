### Basics

* Spring boot is an abstraction of Spring framework
* Spring framework is 5.x
* Spring boot 2.5.x

* __Dependency Injection__ Avoid unneccessary creation or lookup code in your application
* Avoid writing plumbing code 
* Spring framework is a lightweight container. 
* It manages the life cycle of all the objects in the application.
* Creates objects of the classes(or beans) that you write
* And your application can use the objects without having to worry about creating/destroying them
* POJO framework

### MySql
* docker run --name -p3306:3306  mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

``` sql
create database training;
create table training.persons( id int(4) primary key not null auto_increment, name varchar(40), age int(4));
create table training.cars( id int(4) primary key not null auto_increment, model varchar(40), year int(4), person_id int(4));
```

### Graphql

```
query {
  inStockBooks: books(inStock: true) {
    title
  }
  inStockShoes: shoes(inStock: true) {
    make
  }
  oosStockBooks: books(inStock: false) {
    title
  }
  oosStockShoes: shoes(inStock: false) {
    make
  }
}

query {
  books: all {
    title
    price
  }
  shoes: allShoes {
    make
    price
  }
}

query {
  allBooks: all {
    title
    price
  }
  inStockBooks: books(inStock: true) {
    title
  }
  outOfStockBooks: books(inStock: false) {
    title
  }
}

query {
  all: books {
    title
    price
  }
  ids: books {
    id
  }
  pricelist: books {
    price
  }
}

```