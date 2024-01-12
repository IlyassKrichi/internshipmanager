import { Competence } from './Competence';
import { Stage } from './Stage';

export interface TypeStage {
  id: number;
  stages: Stage[];
  competences: Competence[];
  nom: string;
}
