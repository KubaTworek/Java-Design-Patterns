package pl.pjatk.Composite;

public class Professor implements Faculty{
    private String mName;
    private String mPosition;
    private int mOfficeNum;

    public Professor(String name, String position, int officeNum) {
        mName = name;
        mPosition = position;
        mOfficeNum = officeNum;
    }

    @Override
    public String getDetails() {
        return (mName + " is the  " + mPosition);
    }
}
