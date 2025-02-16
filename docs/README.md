# Parakeet User Guide


Parakeet is a chatbox that can help you manage your task easily.


## Feature: Adding a todo task

Add `todo` task to the list of tasks.
- Task with the same description and type(i.e: both of type `todo`) can not be added twice

Format: `todo DESCRIPTION`

Example: `todo go shopping`


## Feature: Adding a deadline task

Add a `deadline` task to the task list.

Format: `deadline DESCRIPTION /by DATE (yyyy-mm-dd HH:mm)`

- DATE should be in form of yyyy-mm-dd HH:mm
- Task with the same description, type(i.e: both of type `deadline`) and date can not be added twice

Example: `deadline individual project /by 2025-02-21 16:59`




## Feature: Adding an event task
Add `event` task to the task list.

Format: `event DESCRIPTION /from DATE  /to DATE `
- DATE should be in form of yyyy-mm-dd HH:mm
- Replace DESCRIPTION with actual description of the task and DATE with the actual date of the task
- Task with the same description and type(i.e: both of type `event`) and date

Example: `event  project meeting /from 2025-02-21 16:59 /to 2025-02-21 17:35`




## Feature: List

Shows a list of all the tasks that have been added

Format: `list`


## Feature: Delete

Deletes the specified task in the task list.

Format: `delete INDEX`
- Deletes the task at the specified INDEX.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, …​

Example: `delete 1`

## Feature: Find

Finds task whose description contains the given keyword.

Format: `find KEYWORD`
- The search is case-insensitive. e.g `Assignment` does not match `assignment`

Example: `find meeting`

## Feature: Mark

Marks the specified task as done

Format: `mark INDEX`
- Marks the task at the specified INDEX.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, …​

Example:`mark 1`
## Feature: Mark

Marks the specified task as done

Format: `unmark INDEX`
- Unmarks the task at the specified INDEX.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, …​

Example:`unmark 2`
