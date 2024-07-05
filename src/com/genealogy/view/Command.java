package com.genealogy.view;

import com.genealogy.presenter.FamilyTreePresenter;
import com.genealogy.model.Gender;
import java.time.LocalDate;

public interface Command {
    void execute();
}

class AddMemberCommand implements Command {
    private FamilyTreePresenter presenter;

    public AddMemberCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        String name = presenter.getView().getUserInput("Введите имя: ");
        String genderStr = presenter.getView().getUserInput("Введите пол (MALE/FEMALE): ");
        String birthDateStr = presenter.getView().getUserInput("Введите дату рождения (гггг-мм-дд): ");
        String parentName = presenter.getView().getUserInput("Введите имя родителя (если есть): ");

        Gender gender = Gender.valueOf(genderStr.toUpperCase());
        LocalDate birthDate = LocalDate.parse(birthDateStr);

        presenter.addMember(name, gender, birthDate, parentName);
    }
}

class ShowAllMembersCommand implements Command {
    private FamilyTreePresenter presenter;

    public ShowAllMembersCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.showAllMembers();
    }
}

class ShowChildrenCommand implements Command {
    private FamilyTreePresenter presenter;

    public ShowChildrenCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        String parentName = presenter.getView().getUserInput("Введите имя родителя: ");
        presenter.showChildren(parentName);
    }
}

class SortByNameCommand implements Command {
    private FamilyTreePresenter presenter;

    public SortByNameCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByName();
    }
}

class SortByBirthDateCommand implements Command {
    private FamilyTreePresenter presenter;

    public SortByBirthDateCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByBirthDate();
    }
}

class SaveFamilyTreeCommand implements Command {
    private FamilyTreePresenter presenter;

    public SaveFamilyTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        String fileName = presenter.getView().getUserInput("Введите имя файла для сохранения: ");
        presenter.saveFamilyTree(fileName);
    }
}

class LoadFamilyTreeCommand implements Command {
    private FamilyTreePresenter presenter;

    public LoadFamilyTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        String fileName = presenter.getView().getUserInput("Введите имя файла для загрузки: ");
        presenter.loadFamilyTree(fileName);
    }
}