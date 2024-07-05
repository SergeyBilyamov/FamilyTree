package com.genealogy.model;

import com.genealogy.io.FileHandler;

import java.util.List;

public class FamilyTreeServiceImpl implements FamilyTreeService<Person> {
    private FamilyTree<Person> familyTree;
    private FileHandler fileHandler;

    public FamilyTreeServiceImpl(FamilyTree<Person> familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    @Override
    public void addMember(Person person) {
        familyTree.addMember(person);
    }

    @Override
    public List<Person> getAllMembers() {
        return familyTree.getAllMembers();
    }

    @Override
    public List<Person> getChildren(String parentName) {
        return familyTree.getChildren(parentName);
    }

    @Override
    public void sortByName() {
        familyTree.sortByName();
    }

    @Override
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    @Override
    public void saveFamilyTree(String fileName) {
        fileHandler.save(familyTree, fileName);
    }

    @Override
    public void loadFamilyTree(String fileName) {
        FamilyTree<?> loadedTree = fileHandler.load(fileName);
        if (loadedTree != null) {
            try {
                this.familyTree = (FamilyTree<Person>) loadedTree;
            } catch (ClassCastException e) {
                e.printStackTrace();
                // Обработка ошибки приведения типа, например:
                throw new RuntimeException("Ошибка при загрузке семейного дерева из файла: неверный тип данных");
            }
        }
    }
}