package modele.EtatsStatus;

import modele.Statut;

public class StatutAbsent extends Statut {

    private static final String STATUT_ABSENT = "Absent";

    StatutAbsent ()
    {
        super();
        this.texte = STATUT_ABSENT;
    }

    public String toSTring()
    {
        return STATUT_ABSENT;
    }
}