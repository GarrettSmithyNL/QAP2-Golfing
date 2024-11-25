# Member and Tournament Search API

This project provides a RESTful API for managing members and tournaments. It includes various search functionalities to retrieve members and tournaments based on different criteria.

## Endpoints

### Member Endpoints

- **POST /member**
    - Create a new member.
    - Request Body: `Member` object.

- **GET /member/{id}**
    - Retrieve a member by their ID.
    - Path Variable: `id` (long)

- **GET /member/name/{name}**
    - Retrieve all members with the specified name.
    - Path Variable: `name` (String)

- **GET /member/phone/{phoneNumber}**
    - Retrieve all members with the specified phone number.
    - Path Variable: `phoneNumber` (String)

### Tournament Endpoints

- **POST /tournament**
    - Create a new tournament.
    - Request Body: `Tournament` object.

- **POST /tournament/{id}/add-member**
    - Add a member to a tournament.
    - Path Variable: `id` (long)
    - Request Body: `Member` object.

- **GET /tournament/{id}**
    - Retrieve a tournament by its ID.
    - Path Variable: `id` (long)

- **GET /tournament/{id}/members**
    - Retrieve all members in a specific tournament.
    - Path Variable: `id` (long)

- **GET /tournament/start-date/{tournamentStartDate}**
    - Retrieve all tournaments starting on a specific date.
    - Path Variable: `tournamentStartDate` (LocalDate)

- **GET /tournament/location/{location}**
    - Retrieve all tournaments at a specific location.
    - Path Variable: `location` (String)

- **GET /tournament/members/start-date/{tournamentStartDate}**
    - Retrieve all members participating in tournaments starting on a specific date.
    - Path Variable: `tournamentStartDate` (LocalDate)

## Models

### Member

- `id` (long)
- `name` (String)
- `phoneNumber` (String)

### Tournament

- `id` (long)
- `startDate` (LocalDate)
- `endDate` (LocalDate)
- `location` (String)
- `entryFee` (double)
- `prizeAmount` (double)
- `playersInTournament` (List\<Member\>)