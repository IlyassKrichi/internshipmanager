import { Etudiant } from './Etudiant';
import { Professeur } from './Professeur';

export interface Promotion {
  id: number;
  professeur: Professeur;
  etudiants: Etudiant[];
  annee: number;
  totalEtudiants: number;
  etudiantsReussis: number;
}
