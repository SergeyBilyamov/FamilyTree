package com.genealogy;

import com.genealogy.model.FamilyTree;
import com.genealogy.model.Person;
import com.genealogy.presenter.FamilyTreePresenter;
import com.genealogy.model.FamilyTreeServiceImpl;
import com.genealogy.io.FileHandlerImpl;
import com.genealogy.view.FamilyTreeConsoleView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FamilyTreeServiceImpl service = new FamilyTreeServiceImpl(familyTree, new FileHandlerImpl());
        FamilyTreeConsoleView view = new FamilyTreeConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        view.setPresenter(presenter);
        view.start();
    }
}