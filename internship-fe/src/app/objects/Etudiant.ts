import { Promotion } from './Promotion';
import { Stage } from './Stage';

export enum Genre {
  MASCULIN,
  FEMININ,
}

export interface Etudiant {
  nom: string;
  prenom: string;
  email: string;
  tel: string;
  adresse: string;
  dateNaissance: string;
  genre: Genre;
  stages: Stage[];
  promotion: Promotion;
}
