package com.example.university.controller;

import com.example.university.entity.Group;
import com.example.university.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/groups")
    public List<Group> showAllGroups() {
        List<Group> allGroups = groupService.getAllGroup();
        return allGroups;
    }

    @GetMapping("/groups/{id}")
    public Group getGroups(@PathVariable int id) {
        Group group = groupService.getGroup(id);
        return group;
    }

    @PostMapping("/groups")
    public Group createNewGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @PutMapping("/groups")
    public Group updateGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @DeleteMapping("/groups/{id}")
    public String deleteGroup(@PathVariable int id) {
        groupService.deleteGroup(id);
        return "Group this ID = " + id + " was deleted";

    }





}
