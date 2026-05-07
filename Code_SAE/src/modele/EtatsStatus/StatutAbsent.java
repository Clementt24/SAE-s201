package modele.EtatsStatus;

import modele.Statut;

public class StatutAbsent extends Statut {

    private static final String STATUT_ABSENT = "Absent";

    StatutAbsent()
    {
        super();
        super.setStatut(STATUT_ABSENT);
    }

    public String toSTring()
    {
        return STATUT_ABSENT;
    }
}