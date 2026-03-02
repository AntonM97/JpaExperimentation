package com.example.experimentation;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.experimentation.model.Program;
import com.example.experimentation.model.Student;
import com.example.experimentation.repository.ProgramRepository;
import com.example.experimentation.repository.StudentRepository;

@Component
public class Application implements ApplicationRunner{
    
    private ProgramRepository progRep;
    private StudentRepository studRep;
    
    public Application(ProgramRepository progRep, StudentRepository studRep) {
        this.progRep = progRep;
        this.studRep = studRep;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Program newProgr = new Program();
        newProgr.name = "prog"; 
        progRep.save(newProgr);
        System.out.println("arrived to save the student");
        //Program prog = progRep.findById(1).get();
        
        Student stud = new Student();
        stud.name = "Student";
        studRep.save(stud);
        System.out.println("arrived to save the student");
        
        Student studFromRep = studRep.findById(1).get();
        studFromRep.program = newProgr;
        
        studRep.save(studFromRep);
        
        System.out.println("finished");
    }

}