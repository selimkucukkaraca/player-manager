
# Producter Backend Developer Case

This project is for the basketball team and its players; adding, deleting, listing etc. offers transactions.


## Tech Stack
Java17, Spring Boot, H2 Database, GraphQL, Docker, Lombok

## API Use Of

#### Save Team

```http
  POST http://localhost:8080/graphql
```

| Parameter | Type     | Description               |
|:----------|:---------|:--------------------------|
| `name`    | `string` | **Necessary**. Team Name. |

```
mutation{
    createTeam(request: {name: "samsun"}){
        name
        createDate
        updateDate
    }
}
```

#### Delete Team

```http
  POST http://localhost:8080/graphql
```

| Parameter | Type     | Description              |
| :-------- |:---------|:-------------------------|
| `name`      | `string` | **Necessary**. Team Name |

```
mutation{
    deleteTeam(name: "Bursa")
}
```

#### Get All Teams

```http
  POST http://localhost:8080/graphql
```

| Parameter | Type  | Description                 |
| :-------- |:------|:----------------------------|
| `page` | `int` | **Necessary**. Page Number. |
| `size` | `int` | **Necessary**. Data Number. |

```
{
    getAllTeams(page : 1, size : 1){
        name 
        createDate 
        updateDate
    }
}
```

#### Save Player

```http
  POST http://localhost:8080/graphql
```

| Parameter                 | Type     | Description                      |
|:-----------------|:---------|:---------------------------------|
| `name`           | `string` | **Necessary**. Player Name.      |
| `lastName`       | `string` | **Necessary**. Player Lastname.  |
| `teamName`       | `string` | **Necessary**. Player Team name. |
| `playerPosition` | `string` | **Necessary**. Player Position.  |

```
mutation{
    createPlayer(request: {name: "Selim", lastName: "Karaca", teamName: "samsun", playerPosition: CENTER}){
        name
        lastName
        name
        playerId
        playerPosition
        createDate
        updateDate
    }
}
```


#### Delete Player

```http
  POST http://localhost:8080/graphql
```

| Parameter | Type     | Description              |
| :-------- |:---------|:-------------------------|
| `playerId`      | `string` | **Necessary**. Player id |

```
mutation{
    deletePlayer(playerId: "5d55f056-f9c8-49f7-8c0b-1d50ae41b39f")
}
```


#### Get All Players

```http
  POST http://localhost:8080/graphql
```

| Parameter | Type  | Description                 |
| :-------- |:------|:----------------------------|
| `page` | `int` | **Necessary**. Page Number. |
| `size` | `int` | **Necessary**. Data Number. |

```
{
    getAllPlayers(page : 1, size : 5){
        name
        lastName
        name
        playerId
        playerPosition
        createDate
        updateDate
    }
}
```


  