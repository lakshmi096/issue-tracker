# Design a Lightweight Issue Tracker (Like JIRA)

## Context
You are working in SomeCompany’s internal developer tools team. The team wants to replace a legacy bug tracking system with a scalable and extensible in-memory prototype. This tool should support the core lifecycle of an issue item (e.g., bug, task, story) and enable developers, managers, and QA engineers to collaborate efficiently.

---

## 💡 Requirements
Implement a simplified issue tracker system with the following features:

---

## 🧱 Features

### 1. **Create Users**
- Users have a unique ID and name.
- Roles: `DEVELOPER`, `QA`, `MANAGER`.

---

### 2. **Create Issues**
- An issue has:
    - `ID`
    - `Title`
    - `Description`
    - `Status` (`OPEN`, `IN_PROGRESS`, `RESOLVED`, `CLOSED`)
    - `Reporter`
    - `Assignee` (optional)
    - `Priority` (`LOW`, `MEDIUM`, `HIGH`)
    - `Type` (`BUG`, `TASK`, `STORY`)
- Default status: `OPEN`.

---

### 3. **Assign Issue**
- Only a `MANAGER` can assign issues to developers.

---

### 4. **Transition Status**
- Users can update the status of an issue if they are the **reporter** or **assignee**.

---

### 5. **Comment on Issues**
- Users can comment on any issue.
- Each comment has:
    - `Timestamp`
    - `Author`
    - `Message`.

---

### 6. **List Issues**
- List all issues filtered by:
    - `Status`
    - `Priority`
    - `Assignee`.

```cmd
CREATE_USER <user_id> <name> <role>
CREATE_ISSUE <issue_id> <title> <description> <type> <priority> <reporter_id>
ASSIGN_ISSUE <issue_id> <assignee_id> <manager_id>
UPDATE_STATUS <issue_id> <new_status> <user_id>
ADD_COMMENT <issue_id> <user_id> <comment_text>
LIST_ISSUES [FILTER <filter_type> <filter_value>]
```