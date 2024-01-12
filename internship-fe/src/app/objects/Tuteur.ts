import { Professeur } from './Professeur';
import { Stage } from './Stage';

export interface Tuteur {
  id: number;
  stages: Stage[];
  professeurs: Professeur[];
  nom: string;
  prenom: string;
  tel: string;
}
