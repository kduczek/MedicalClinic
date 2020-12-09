<h1>Medical Clinic</h1>
This is a simple project for subject Basics of Java Programming at my University. </br>
Let me introduce you to main assumptions of this project.</br>
So we have small medical clinic in which we can hire following people:
<ul>
  <li>Office Workers</li>
  <li>Medical Workers</li>
    <ul>
        <li>Doctors - Pediatricians and Internists</li>
        <li>Nurses</li>
    </ul>
</ul>

We have following informations about every employee: </br>
<ul>
    <li>Employee code</li>
    <li>Name</li>
    <li>Surname</li>
    <li>Date of birth</li>
    <li>Hire date</li>
    <li>Salary</li>
</ul>

Additionally everyone who belongs to Medical Workers group has <b>Medical License Number</b>. </br>
Office Workers can:
<ul>
    <li>Register the visit, that means:</li>
    <ul>
        <li>Ask for patient name and surname</li>
        <li>Ask for his date of birth</li>
        <li>Ask for purpose of visit. Patient tells how many medical procedures will have and next patient lists them (available procedures below)</li>
        <li>Register visit, that means print informations about visit into log file and in console using log</li>
        <li>Pass the patient to proper person from Medical Workers group. If purpose of visit can be realized by the nurse we are passing patient to a nurse.
            If procedures have to be executed by a doctor wy are checking if patient is adult. If not we are passing him to Pediatrician. If patient is adult he is passed to an Internist.
        </li>
    </ul>
</ul>

Medical Worker can:
<ul>
    <li>Execute medical procedure:</li>
    <ul>
        <li>Prints to console and to log file information who executed the procedure and on which patient</li>
    </ul>
</ul>

List of medical procedures: 
<ul>
    <li>Injection</li>
    <li>Weight measurement</li>
    <li>Pressure measurement</li>
    <li>Blood collection</li>
    <li>General check up (Doctor only)</li>
    <li>Ultrasound examination (Doctor only)</li>
    <li>Writing a prescription (Doctor only)</li>
</ul>

How program works?</br>
Each employee from the staff is hardcoded at the beginning. </br>
Next we have a loop in which user from the keyboard choose what to do.</br>
List of possible actions:
<ol>
    <li>Register the new patient. The program asks user for patients personal data and number of treatments. After that the visit is registered and patient is passed to proper person.</li>
    <li>Count whole salary from the beginning of work in Clinic. Program asks for employee code.</li>
    <li>Prints how long employee is working in Clinic in years in floating point format. Program asks for employee code.</li>
    <li>Prints all informations about employee. Program asks for employee code.</li>
</ol>
Additional notes:
<ul>
    <li>Medical procedures are stored in array so first of all we ask user for amount.</li>
    <li>When user will pass incorrect data program will throw exception which will be catched and current function will be canceled and user will came back to choose option again.</li>
    <li>Methods which can be tested where tested in Junit5</li>
</ul>
