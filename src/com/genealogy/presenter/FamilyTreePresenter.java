package com.genealogy.presenter;

import com.genealogy.model.Gender;
import com.genealogy.model.Person;
import com.genealogy.model.FamilyTreeService;
import com.genealogy.view.FamilyTreeView;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeService<Person> service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService<Person> service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    public void addMember(String name, Gender gender, LocalDate birthDate, String parentName) {
        Person person = new Person(name, gender, birthDate, parentName.isEmpty() ? null : parentName);
        service.addMember(person);
        view.showMessage("Член семьи добавлен.");
    }

    public void showAllMembers() {
        List<Person> members = service.getAllMembers();
        view.showFamilyMembers(members);
    }

    public void showChildren(String parentName) {
        List<Person> children = service.getChildren(parentName);
        view.showChildren(children);
    }

    public void sortByName() {
        service.sortByName();
        view.showMessage("Члены семьи отсортированы по имени.");
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.showMessage("Члены семьи отсортированы по дате рождения.");
    }

    public void saveFamilyTree(String fileName) {
        service.saveFamilyTree(fileName);
        view.showMessage("Семейное дерево сохранено.");
    }

    public void loadFamilyTree(String fileName) {
        service.loadFamilyTree(fileName);
        view.showMessage("Семейное дерево загружено.");
    }

    public FamilyTreeView getView() {
        return view;
    }
}