package beans;

import java.util.List;
import java.util.Objects;

public class PersonDTOList {

    private List<PersonDTO> personDTOList;

    public PersonDTOList(List<PersonDTO> personDTOList) {
        this.personDTOList = personDTOList;
    }

    public PersonDTOList() {
    }

    public List<PersonDTO> getPersonDTOList() {
        return personDTOList;
    }

    public void setPersonDTOList(List<PersonDTO> personDTOList) {
        this.personDTOList = personDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDTOList that = (PersonDTOList) o;

        return Objects.equals(personDTOList, that.personDTOList);
    }

    @Override
    public int hashCode() {
        return personDTOList != null ? personDTOList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PersonDTOList{" +
                "personDTOList=" + personDTOList +
                '}';
    }
}
