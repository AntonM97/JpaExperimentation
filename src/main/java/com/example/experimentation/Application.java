package com.example.experimentation;

import java.util.ArrayList;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.experimentation.model.Address;
import com.example.experimentation.model.Program;
import com.example.experimentation.model.Student;
import com.example.experimentation.repository.AddressRepository;
import com.example.experimentation.repository.ProgramRepository;
import com.example.experimentation.repository.StudentRepository;

@Component
public class Application implements ApplicationRunner{
    
    private ProgramRepository progRep;
    private StudentRepository studRep;
    private AddressRepository addRep;
    
    public Application(ProgramRepository progRep, StudentRepository studRep, AddressRepository addRep) {
        this.progRep = progRep;
        this.studRep = studRep;
        this.addRep = addRep;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        int runNum = 1;
        
        Program program = new Program();
        program.setName("TestProgram" + runNum);
        progRep.save(program);
        System.out.println("program saved");
        
        Student student = new Student();
        student.setName("TestStduent" + runNum);
        student.setProgram(program);
        studRep.save(student);
        System.out.println("student saved");
        
        program.setStudents(new ArrayList<>());
        program.getStudents().add(student);
        System.out.println("program added to studet");
        
        Address address = new Address();
        address.setCountry("Country"+runNum);
        addRep.save(address);
        System.out.println("address saved");
        
        student.setAddress(address);
        System.out.println("address set");
    }

}