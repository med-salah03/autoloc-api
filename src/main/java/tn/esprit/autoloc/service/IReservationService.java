package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation ajouterReservation(Reservation reservation);

    Reservation modifierReservation(Reservation reservation);

    List<Reservation> afficherToutesReservations();

    Reservation afficherReservationById(long id);

    void supprimerReservation(Reservation reservation);
}
