package com.example.university.service;

import com.example.university.entity.Faculty;
import com.example.university.entity.Group;
import com.example.university.repository.GroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroup() {

        return groupRepository.findAll();
    }


    public Group saveGroup(Group group) {

        return groupRepository.save(group);
    }

    public Group getGroup(int id) {
        return groupRepository.findById(id).orElse(null);
    }

    public void deleteGroup(int id) {

        groupRepository.deleteById(id);
    }

    public Page<Object[]> getFacultyGroupCount(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return groupRepository.findFacultyGroupCount(pageable);
    }




}
