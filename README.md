### Package Structure
  - controllers
    - question
      - QuestionQueryController
      - mcq
        - McqCommandController
        - McqQueryController
      - identification
        - IdentificationCommandController
        - IdentificationQueryController
  - core
    - common
      - typehandlers
    - question
      - mcq
        - Mcq.java
        - McqChoice.java
        - command
          - McqCommandService.java
          - McqCommandMapper.java
          - CreateMcqCommand.java
          - UpdateMcqCommand.java
          - DeleteMcqCommand.java
        - query
          - McqQueryService.java
          - McqQueryMapper.java
          - GetMcqQuery.java
          - ListMcqQuery.java
      - identification
        - Identification.java
        - command
          - IdentificationCommandService.java
          - IdentificationCommandMapper.java
          - CreateIdentificationCommand.java
          - UpdateIdentificationCommand.java
          - DeleteIdentificationCommand.java
        - query
          - IdentificationQueryService.java
          - IdentificationQueryMapper.java
          - GetIdentificationQuery.java
          - ListIdentificationQuery.java
  - common
  - infrastructure
    - configs


### Repair Flyway by Resetting DB Schema
```sql
drop schema duit;
create schema duit;
```

### Queries
`Save a MCQ`
```json
{
  "topic": "AWS",
  "question": "this is another test",
  "choices": [
    {
      "choice": "a",
      "explanation": "is a",
      "isCorrect": "Y"
    },
    {
      "choice": "b",
      "explanation": "is a",
      "isCorrect": "N"
    }
  ]
}
```