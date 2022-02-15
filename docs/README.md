# User Guide

Welcome to Duke! Duke is a CLI focused task manager which is built to handle simple tasks. 
## Features 

### Tasks 
There are 3 basic tasks which can be created in Duke 

<li> Todo </li>
<li> Deadline </li>
<li> Event </li>

### Others 

Duke has several functions to help you manage these tasks such as search by keyword and marking these task as completed

## Usage

### `todo` - Creates a basic task

Example of usage: 

`todo <description>`

```
todo Read book 
----
Added: Read book
```
---

### `deadline` - Creates a Deadline Task

Example of usage:

`deadline <description> /by <date in yyyy-mm-d> `

```
deadline Finish book /by 2022-01-01 
----
Added: Finish book
```
---

### `event` -  Creates an Event Task

Example of usage:

`event <description> /on <date in yyyy-mm-d>`

```
event Dinner party /on 2022-02-02 
----
Added: Dinner party 
```
---

### `list` -  Shows Task List

Example of usage:

`list`

```
list 
----
[T][] Read book 
[D][] Finish book
[E][] Dinner Party 
```
---

### `find` - Shows tasks with related keyword

Example of usage:

`find <Keyword>`

```
find book 
----
[T][] Read book 
[D][] Finish book
```
---

### `mark` -  Marks task as complete

Example of usage:

`mark <Index>`

```
mark 1
----
Nice! I've marked this task as done: 
[T][X] Read book
```

---

### `unmark` -  Marks task as incomplete

Example of usage:

`unmark <Index>`

```
unmark 1
----
Oh no! one more thing that needs to be done: 
[T][] Read book 
```

---

### `delete` - Removes a task form the Task List

Example of usage:

`delete <Index>`

```
delete 1 
----
Noted. I've removed this task: 
[T][] Read book 
```
---

### `bye` - Closes duke

Example of usage:

`todo <description>`

Closes Application







