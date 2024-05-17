package Program2;

public class Brano {
    private String nomeBrano;
    private String artista;
    private String genere;

    void setNomeBrano(String nomeBrano) {
        this.nomeBrano = nomeBrano;
    }
    void setArtista(String artista) {
        this.artista = artista;
    }
    void setGenere(String genere) {
        this.genere = genere;
    }
    String getNomeBrano() {
        return nomeBrano;
    }
    String getArtista() {
        return artista;
    }
    String getGenere() {
        return genere;
    }
    public String toString() {
        return nomeBrano + ", " + artista + ", " + genere;
    }
}
