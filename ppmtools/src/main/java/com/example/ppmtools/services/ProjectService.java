package com.example.ppmtools.services;

import com.example.ppmtools.domain.Project;
import com.example.ppmtools.exception.ProjectIDException;
import com.example.ppmtools.repository.ProjectRepository;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    //POST/PUT Operation
    public Project saveOrUpdateProject(Project project){
        try{
            project.getProjectIdentifier().toUpperCase();
            return projectRepository.save(project);
        } catch (Exception e){
            throw new ProjectIDException("Project ID '"+project.getProjectIdentifier().toUpperCase()+
                    "' exits already");
        }
    }

    //GET Operation
    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIDException("Project ID '"+projectId+ "' does not exist");
        }

        return project;
    }

    //GET Operation
    public Iterable<Project> findAllProjects (){
        return projectRepository.findAll();
    }

    //DELETE Operation
    public void DeleteProjectByIDentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project == null){
            throw new ProjectIDException("Project ID '"+projectId+ "' does exist!, can't delete the project!");
        }
        projectRepository.delete(project);
    }
}
