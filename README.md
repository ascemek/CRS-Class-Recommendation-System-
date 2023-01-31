# CRS-Class-Recommendation-System-

## Authors

Contributors' names and contact info:

* [Sami Cemek](https://github.com/ascemek) 
* [Sebastian Mark](https://github.com/SebastianMark32)

## Description and Motivation
After brainstorming some ideas, we both came to an agreement that some recommender
system would be an interesting project to create. Since we are both gamers, creating a simple
tic-tac-toe game will not satisfy a true gamer’s heart. Therefore, a more pragmatic project would
not only be more useful to us but it could potentially become a design that we could
progressively work on throughout the future. So, since one of the many stresses of a college
student is deciding what classes are available and which one will be beneficial towards our
current area of concentration (AOC). The decision was simple; we wanted to create a graphical
user interface (GUI) that would allow the user to select previously taken courses from a list, and
that would ultimately output a suggestive list of courses for the student to enroll in. Now, this is
based on current courses taken and the prerequisites for those classes. Nevertheless, we
wanted to create a program that would be beneficial not only to our lives, but that could possibly
help us and others with the tough task of organizing semester schedules.

## Dataset
The datasets used are read from a csv file. In theory, our data set can be anything we like,
because each class is read from a simple .txt file. Meanwhile, this is extremely beneficial for the
reason that if we want to update our system or list, all we need to do is adjust the current file
(csv). Therefore, this provides a lot of flexibility in what our program can display. Additionally, the
current dataset is a list of computer science courses New College of Florida has to offer. We
created a system that is easily integrated and updated without making changes to the code
(modular design). In the future, we can easily add more .txt files for other AOCs if we want to
expand our project.

## Recommendation Algorithm (Sami Cemek)
I did not implement an existing algorithm, rather I looked at some examples of existing
algorithms (listed on references) to get an idea of what I can do and implemented my
own. Currently, this system is console-based, meaning that you see most of the outputs
on the console. The recommender class takes the final output of the GIU (CSV file) and
in order to make comparisons, first we need to split at each comma (because the output
is a string separated by commas), and afterwards put them into an ArrayList. The
reason being that I used ArrayList is because I wanted to have a dynamic data
structure. I cannot change the length of the array once it is created. For the core
computer science courses there is a sequence of events that need to take place first.
Meaning, a person needs to have the proper prerequisites before they can enroll into a
class. So, I need to consider the prerequisites and terms offered. For example, if the
user only took an introduction to Python class, then by the sequence the recommender
system would say “you should take OOP, Discrete Math, OOD, Algorithms and Software
Engineering next semester.” We have an ArrayList that stores the classes taken and
compares them by the Core Course ArrayList. If a class in classTaken Arraylist is also in
Core course ArrayList then we remove that class from core course Arraylist and finally
print whatever is left on core course Arraylist.
For each elective area, I needed to add additional code to the GUI (see the screenshot
on the next page). So I look at how many classes are selected from GUI by looking at
how many classes are selected using the dropbox. Everytime the user selects a class, I
increase my counter by 1 (countChecked) and print whatever is selected to the console.
There are a certain number of elective area classes you need to take to meet the
requirements. These requirements are: 2 Applications, 1 AI, 2 Mathematics, 2 Systems,
1 Languages, 1 Theory. I declared these numbers as a field on each related elective
area class. Then I compare if countChecked is greater than or equal to required course
count. If it is, that means you already met this requirement and don’t need to take a
class from that area. If not, for Theory and Languages, you can take any of the classes
(since required course count is 1 for these two). So I print all of the classes from the
related txt file. For the other elective areas, I remove the classTaken from all possible
classes in that field and print what is left(similar to core CS courses). The core principles 
being used are inheritance, encapsulation, modular design, abstraction, interfaces and I/O 
handling.

## Shortcomings of Our Work
The graphical user interface came out functional, however, the display is quite primitive
looking. When the user sees the first window, there is only the option to select one
AOC, nevertheless adding another area of concentration could be easily added. Meanwhile, 
we could add additional aesthetic features to the GUI, so it looks more presentable. 
However, those are minor details in the GUI that can be modified in the
next version of the project. Although, to add more areas of focus that would imply many
more classes in the project file. So, one of the shortcomings is if we wanted to have four
to five different natural science fields, then we could potentially have twenty-five
different classes inside of the IDE workspace.
Furthermore, one of the biggest issues we came across was the actual
recommendation system. Although this kind of system can certainly become very
advanced we tried to keep it simple for now; because considering our programming
experience and while having a tight time constraint, it definitely hindered us from
advancing the project more. Furthermore, after the user selects their courses from the
drop-down window and presses the print to CSV button, the next step is the actual
recommending classes, which at the moment is not functioning perfectly as we like.
Our initial thought was implementing a Hashmap for each elective area. Meaning, that
for each one of our classes we would have a unique ID, and were planning to refer to
those IDs when recommending classes. However, I changed my mind (Sami), and
decided to use an arraylists instead. Currently for each elective our system is
disregarding the prerequisites. So let’s say the user wants to take Theory of
Computation, but there are two prerequisites: Discrete Mathematics and Data
Structures. Therefore, our system will still recommend those classes even if you did not
take Discrete Mathematics or Data Structures. Additionally, some classes fall in two
categories. Those classes should then be addressed based on the user's credits
needed. We specified those courses on each text file so the user can manually decide
which courses are going to count towards the elective requirement.
In summary, we have created the GUI frame that has functional buttons, with a
drop-down menu for the user to select the current courses taken. Additional, conditional
operations were needed to prevent certain errors. For example, in the GUI the remove
button would function even when the text field was empty, which caused an out of
bounds error. Lastly, the recommender system is not optimal which needs to be
addressed and provide continuous future work.
