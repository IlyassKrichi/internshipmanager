import { Promotion } from './Promotion';
import { Tuteur } from './Tuteur';

export interface Professeur {
  id: number;
  tuteurs: Tuteur[];
  promotion?: Promotion | null;
  nom: string;
  prenom: string;
  adresse: string;
  dateEmbauche: string;
  tel: string;
  email: string;
  dateDepart: string | null;
}
