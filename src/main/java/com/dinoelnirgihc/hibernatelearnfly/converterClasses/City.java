package com.dinoelnirgihc.hibernatelearnfly.converterClasses;



/**Учебный класс для создания конвертера */
public class City
{
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this.name.equals(((City)obj).getName()))
            return true;
        else return false;
    }
}
