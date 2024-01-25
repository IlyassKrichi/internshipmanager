import { Stage } from './Stage';

export interface Entreprise {
  id: number;
  stages: Stage[];
  nom: string;
  adresse: string;
  formeJuridique: string;
  telStandard: string;
  telContact: string;
  telTuteur: string;
}
