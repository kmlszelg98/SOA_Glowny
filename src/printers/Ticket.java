package printers;


import java.sql.Timestamp;

/**
 * Created by Kamil on 26.05.2017.
 */

public class Ticket {

    private int id;


    private String numerRejestracyjny;
    private String rodzajBiletu;
    private Timestamp startTime;
    private Timestamp endTime;
    private int strefa;

    public Ticket() {
    }

    public Ticket(String numerRejestracyjny, String rodzajBiletu, Timestamp startTime, Timestamp endTime, int strefa) {
        this.numerRejestracyjny = numerRejestracyjny;
        this.rodzajBiletu = rodzajBiletu;
        this.startTime = startTime;
        this.endTime = endTime;
        this.strefa = strefa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public String getRodzajBiletu() {
        return rodzajBiletu;
    }

    public void setRodzajBiletu(String rodzajBiletu) {
        this.rodzajBiletu = rodzajBiletu;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getStrefa() {
        return strefa;
    }

    public void setStrefa(int strefa) {
        this.strefa = strefa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket that = (Ticket) o;

        if (id != that.id) return false;
        if (strefa != that.strefa) return false;
        if (numerRejestracyjny != null ? !numerRejestracyjny.equals(that.numerRejestracyjny) : that.numerRejestracyjny != null)
            return false;
        if (rodzajBiletu != null ? !rodzajBiletu.equals(that.rodzajBiletu) : that.rodzajBiletu != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numerRejestracyjny != null ? numerRejestracyjny.hashCode() : 0);
        result = 31 * result + (rodzajBiletu != null ? rodzajBiletu.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + strefa;
        return result;
    }

    public String toString(){
        return " Numer rej: "+ numerRejestracyjny +" Rodzaj: "+ rodzajBiletu +" Od: "+ startTime +" Do: "+ endTime;
    }
}
