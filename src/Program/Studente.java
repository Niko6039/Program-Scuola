package Program;

public class Studente {
    private String nome;
    private String cognome;
    private String matricula;
    private String email;

    public Studente() {}

    public Studente(String nome, String cognome, String matricula, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricula = matricula;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getEmail() {
        email = nome + "." + cognome + "@lol.it";
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String toString() {
        return nome + ", " + cognome + ", " + matricula + ", " + email;
    }
}
