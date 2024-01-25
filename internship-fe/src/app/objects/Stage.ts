import { Entreprise } from './Entreprise';
import { Etudiant } from './Etudiant';
import { Tuteur } from './Tuteur';
import { TypeStage } from './TypeStage';

export interface Stage {
  id: number;
  entreprise?: Entreprise | null;
  typeStage?: TypeStage | null;
  tuteur?: Tuteur | null;
  etudiants: Etudiant[];
  dateDebut: string;
  dateFin: string;
}
