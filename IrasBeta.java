/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irasbeta;

import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat; 
import java.io.*;


class Student
{    
    Scanner sion = new Scanner(System.in);
    String major,minor,address;
    private int studentID;
    String ability,sex,studentName;
    public void getdata()
    {
      System.out.print("Name: ");
      studentName=sion.nextLine();
      System.out.print("Address: ");
      address=sion.nextLine();
      System.out.print("Major: ");
      major=sion.nextLine();
      System.out.print("Minor: ");
      minor=sion.nextLine();
      System.out.print("ID: ");
      studentID=sion.nextInt();
      sion.nextLine();
      System.out.println();
    }
    public void displaySData()
    {
        System.out.println("ID: "+studentID+"\t\tMajor: "+major.toUpperCase());
        System.out.println("Name: "+studentName.toUpperCase()+"\t\tMinor: "+minor.toUpperCase());
        System.out.println("Address: "+address.toUpperCase());
        
    }
}


class Course
{
    Scanner sion = new Scanner(System.in);
    private String courseName,courseID,grade;
    private float credit,gradePoint;
    static float ggg,ccc;
    static float sumCredit=0.0f;
    static float sumGP=0.0f;
    static float sCredit=0.0f;
    static float sGP=0.0f;
    public void getCourse()
    {
        System.out.print("Course Title: ");
        courseName = sion.nextLine();
        System.out.print("Course ID : ");
        courseID = sion.nextLine();
        System.out.print("Grade: ");
        grade = sion.nextLine();
        grade=grade.toUpperCase();
        System.out.print("Credit(Float): ");
        credit =sion.nextFloat();
        System.out.println(); 
        switch (grade) {
            case "A":
                gradePoint =4.0f;
                break;
            case "A-":
                gradePoint =3.7f;
                break;
            case "B+":
                gradePoint =3.3f;
                break;
            case "B":
                gradePoint =3.0f;
                break;
            case "B-":
                gradePoint =2.7f;
                break;
            case "C+":
                gradePoint =2.3f;
                break;
            case "C":
                gradePoint =2.0f;
                break;
            case "C-":
                gradePoint =1.7f;
                break;
            case "D+":
                gradePoint =1.3f;
                break;
            case "D":
                gradePoint =1.0f;
                break;
            case "P":
                gradePoint =0.0f;
                break;
            case "W":
                gradePoint =0.0f;
                break;
            case "F":
                gradePoint =0.0f;
                break;
            default:
                break;
        }
        sumCredit+=credit;
        sumGP+=gradePoint*credit;
        ggg=sumGP/sumCredit;
        sCredit+=credit;
        sGP+=gradePoint*credit;
        ccc=sGP/sCredit;
    }

    
    public void displayData()
    {
        
        System.out.println("Course: "+courseID);
        System.out.println("Course Title: "+courseName);
        System.out.println("Grade: "+grade+"\tCredit: "+credit+"\tCredit for GPA: "+gradePoint);             
    }    
}


class Semester
{
    Scanner sion = new Scanner(System.in);
    private String semesterName;
    private int semesterYear,noOfCourse;
    Course []cr;
    Course c = new Course();
    
    Semester()
    {
        
    }
    public void getSemester()
    {
        System.out.print("Semester name: ");
        semesterName=sion.nextLine();
        System.out.print("Semester year: ");
        semesterYear=sion.nextInt();
        System.out.println();
        System.out.print("Number of courses: ");
        noOfCourse=sion.nextInt();
        System.out.println();
        cr = new Course[noOfCourse];
        for(int i=0;i<noOfCourse;i++)
        {
            System.out.println("Data for course: "+(i+1));
            cr[i]= new Course();
            cr[i].getCourse();
            
        }
    }
    public void displaySemester()
    {
        System.out.println("Semester: "+semesterName+" "+semesterYear);
        for(int i=0;i<noOfCourse;i++)
        {
            cr[i].displayData();
        }
    }
}


class Document
{
    Scanner sio = new Scanner(System.in);
    int serialNo;
    String dateIssue;
    
    public void generateData()
    {
        Random r = new Random();
        serialNo = r.nextInt(1999);
        System.out.print("Date of issue: ");
        dateIssue=sio.nextLine();       
    }
    
}


class Transcript extends Document
{
    Scanner sion = new Scanner(System.in);
    Student s = new Student(); 
    Semester []st;
    Document dct;
    Course c = new Course();
    float []a;
    DecimalFormat f = new DecimalFormat("##.00");
    Transcript()
    {
        super.generateData();
        s.getdata();
        System.out.print("Number of semester(s): ");
        int sem = sion.nextInt();
        System.out.println();
        st= new Semester[sem]; 
        a= new float[sem];
        for(int i=0;i<sem;i++)
        {
            System.out.println("Data for semester: "+(i+1)); //CHECK 3
            st[i]= new Semester();
            st[i].getSemester();
            a[i]=c.ggg;
            c.sumGP=0.0f;
            c.sumCredit=0.0f;
        }
    }
    public void display()
    {
        System.out.println("Date of issue: "+dateIssue);
        System.out.println("Unique serial number: "+serialNo);
        s.displaySData();
        System.out.println();
        for(int i=0;i<st.length;i++)
        {
            st[i].displaySemester();
            System.out.print("GPA: ");
            System.out.println(f.format(a[i]));
            System.out.println();
            
        }
        System.out.println();
        System.out.println("Total Credits Earned: "+(c.sCredit));
        System.out.println("Total Grade Points Earned: "+(c.sGP));
        System.out.println("CGPA: "+(c.ccc));
    }
}

class Recommendation 
{
    Student s = new Student();
    String tempSex = new String();
    String temp = new String();
    void generateRecomLetter()
    {
    Scanner sion = new Scanner(System.in);
    
    s.getdata();
    
    System.out.println("Enter Student's sex: (M/F)");
    s.sex = sion.nextLine();
    
    if ("M".equals( s.sex))
        tempSex = " his ";
    
    else if("F".equals( s.sex)) 
        tempSex = " her ";
    else
        tempSex = " "+s.studentName+"'s ";
    
            
    temp = "Dear recruiter:\n" +
    "\n" +
    "This reference letter is provided at the written request of "+ s.studentName+  ", who has asked me to serve as a reference on" + tempSex +"behalf. It is my understanding that " + s.studentName +  " is a candidate for recruitment in your organization. Please be advised that the information contained in this letter is confidential and should be treated as such. The information should not be disclosed to "+ s.studentName +" or anyone in your organization who would not be involved in the hiring decision regarding this individual. Additionally, the information should not be disclosed to anyone outside of your organization without the consent of the student.\n" +
    "\n" +
    "I have known " + s.studentName + " for quite a time as "+ s.studentName + "has attended a course which I teach As "+ tempSex +" professor. I have had an opportunity to observe the student's participation and interaction in class and to evaluate the student's knowledge of the subject matter. I would rate the student's overall performance in these subjects as good. This is evidenced by "+ tempSex +"  grades.\n" +
    "\n" +
    "As part of "+ tempSex +" grade in the course, the student was required to prepare a paper. The paper was designed to measure the student's ability to research, to analyze the results of the research, and to write. Based upon this, I rate the student's skills verry good.\n" +
    "\n" +
    "Based upon the student's academic performance and my understanding of the position for which the student is applying, I believe the student would perform [place overall evaluation here].\n" +
    "\n" +
    "If you would like to discuss this further, please feel free to contact me.\n" +
    "\n" +
    "Sincerely,\n"
    +s.studentName+ "'s Teacher";
    }
    public void displayRecomm()
    {
        System.out.println();
        System.out.println();
        System.out.println(temp);
       
    }
}

class Certificate extends Document
{
    Student s = new Student();
    String tempSex = new String();
    String temp = new String();
    public void generateCertificate()
    {
        super.generateData();
        s.getdata();
        temp= "\t\t\t\t\t\t\tINDEPENDENT UNIVERSITY,BANGLADESH"+
                "\n\t\t\t\t\tTHE BOARD OF TRUSTEES IN ACCORDANCE WITH THE RECOMMENDATION"
                +"\n\t\t\t\t\tOF THE PRESIDENT OF IUB,AND OF THE CHANCELLOR AND FACULTY OF IUB"
                +"\n\t\t\t\t\tHERE BY CONFERS THAT"
                +"\n\t\t\t\t\tTHE BACHELOR OF SCINECE IN "+s.major+" HAS BEEN COMPLETED BY"
                +"\n\t\t\t\t\t\t\t"+s.studentName.toUpperCase();
    }
    public void displayCertificate()
    {
        System.out.println(temp);
        System.out.println("Date of issue: "+dateIssue);
    }
}


public class IrasBeta 
{
    public static void main(String[] args) 
    {
        Scanner sion = new Scanner(System.in);
        System.out.println("Transcript: 1"+"\tRecommendation Letter: 2"+ "\tCertificate: 3");
        System.out.print("Enter choice: ");
        int choice= sion.nextInt();
        if(choice==1)
        {
            Transcript t = new Transcript();
            t.display();
        }
        else if(choice==2)
        {
            Recommendation recomm = new Recommendation();
            recomm.generateRecomLetter();
            recomm.displayRecomm();
        }
        else if(choice==3)
        {
            Certificate cert = new Certificate();
            cert.generateCertificate();
            cert.displayCertificate();
        }
        sion.nextLine();
    }
}
