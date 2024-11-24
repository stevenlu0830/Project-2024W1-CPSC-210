# Project-i0s8o - 2024W1 CPSC-210 Project: Assignment Tracking App 

## What will the application do?

This is an **assignment tracking application** that keeps track of a list of assignments to be done. The major feature is to record a list of assignments that haven't finished and will be finished soon. User can enter information of the assignment such as: 
1. Name
2. Related Courses
3. Type (Quiz, Short-Questions, Essay, etc.)
4. Due Date
5. Managed Start Time
6. Description (Optional)

Those assignments will be put on *Unfinished Assignments* part. After user has finished an assignment, he/she will enter finished time. Finally the assignment will be put on *Finished Assignments* part in order to let user review time spent on every assignments. Additional features include:
- Viewing assignment details (including its description)
- Editing informaiton and deleting assignment
- Sort the finished assignments by increasing/decreasing order of time spent
- Visualize the time spent on every courses using a bar chart

## Who will use it?

As assignments are done by students, also the application is designed for students, **all students** will be the target users for the application. After the application has successfully developed, it will first open to university students. If the application is operating well, it will then open to all other students.

## Why is this project of interest to you?

For a simple reason: I am also a student. As a student, one of the main source of stress comes from heavy workload of assignments. I need an app to help me keep track of the assignments to be done. Out of my curiosity, I would like to know how much time did I contribute on every assignment. Therefore, I have come up with this project to record the assignments I have done. Looking at time spent is helpful for my time management as I can reflect how much time I spent on each course.

## User Stories

Unfinished Assignments:
- I want to be able to add an assignment to a list of unfinished assignments and specify the above information
- I want to be able to edit the information (just the due date and description) of the assignment
- I want to be able to remove an assignment from a list of unfinished assignments and a list of finished assignments
- I want to be able to move an assignment from unfinished assignment list to finished assignment list

Finished Assignments:
- I want to be able to sort the finished assignments by increasing order of time spent

Both Unfinished and Finished Assignments:
- I want to be able to view the list of unfinished and finished assignments
- I want to be able to view the number of finished and unfinished assignments

Save and Load Assignments:
- I want to be able to have the option to save my lists of unfinished and finished assignments
- I want to be able to have the option to reload that state from file and resume exactly where they left off at some earlier time

Visualisation:
- I want to be able to include images to every button in the sidebar, to the save assignment button and the load assignment button

Read and write JSON - Code Reference: (JsonSerializationDemo) https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

# Instructions for End User

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by adding a new assignment to the list of unfinished assignments. To do this, click **Unfinished Assignments** button on the sidebar. Click **Add Assignment** button at the bottom of the panel. A new window will be popped out for you to enter the information of the new assignment. Unless specified optional, all information must be entered. After entering information, click **Add the Assignment** button below to add the assignment. 
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by adding one of the unfinished assignments to the list of finished assignments. To do this, make sure you have at least one unfinished assignment. Click **Unfinished Assignments** button on the sidebar. Click **Finish an Assignment** button at the bottom of the panel. A new window will be popped out for you to enter the additional information of the unfinished assignment you specified. After entering all information, click **Finish the Assignment** button below to finish the assignment.
- You can generate the first action related to those Xs and Y by editing the due date of an assignment. To do this, make sure you have at least one unfinished assignment. Click **Unfinished Assignments** button on the sidebar. Click **Edit Assignment Information** button at the bottom of the panel. A new window will be popped out for you to choose which kind of information to edit. Select **Due Date** and then click **Edit** button besides. A new window will be popped out for you to enter the new due date of the unfinished assignment you specified. After entering all information, click **Edit Due Date** button below to edit the due date of the assignment.
- You can generate the second action related to those Xs and Y by editing the description of an assignment. To do this, make sure you have at least one unfinished assignment. Click **Unfinished Assignments** button on the sidebar. Click **Edit Assignment Information** button at the bottom of the panel. A new window will be popped out for you to choose which kind of information to edit. Select **Description** and then click "Edit" button besides. A new window will be popped out for you to enter the new description of the unfinished assignment you specified. After entering all information, click **Edit Description** button below to edit the due date of the assignment.
- You can generate the third action related to those Xs and Y by removing an assignment. To do this, make sure you have at least one unfinished assignment. Click **Unfinished Assignments** button on the sidebar. Click **Remove an Assignment** button at the bottom of the panel. A new window will be popped out for you to specify the unfinished assignment. After entering the information, click **Remove the Assignment** button below to finish the assignment.
- You can generate the fourth action related to those Xs and Y by sorting the list of finished assignments in increasing order of duration. To do this, make sure you have at least one finished assignment. Click **Finished Assignments** button on the sidebar. Click **Sort Assignments (Increasing Order)** button at the bottom of the panel. 
- You can generate the fifth action related to those Xs and Y by viewing the list of unfinished and finished assignments. Make sure you have at least one unfinished assignment and at least one finished assignments. To do this, select **Unfinished Assignments** button on the sidebar and click **View Assignments** on the bottom to view a list of unfinished assignments. Select **Finished Assignments** button on the sidebar and click **View Assignments** on the bottom to view a list of finished assignments.
- You can generate the sixth action related to those Xs and Y by viewing the number of unfinished and finished assignments. To do this, select **Unfinished Assignments** button on the sidebar and click **View Number of Assignments** on the bottom to view the number of unfinished assignments. Select **Finished Assignments** button on the sidebar and click **View Number of Assignments** on the bottom to view the number of finished assignments.
- You can locate my visual component by seeing the images on the buttons on the sidebar, on the save assignment button and the load assignment button. They are png images that are stored on the **images** package under **src** package.
- You can save the state of my application by first clicking the **Save/Load Assignments** button on the sidebar. Click **Save to Computer** button on the panel to save the state of my application.
- You can reload the state of my application by first clicking the **Save/Load Assignments** button on the sidebar. Click **Load from Computer** button on the panel to reload the state of my application.
