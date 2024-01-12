import { TypeStage } from './TypeStage';

export interface Competence {
  id: number;
  typeStages: TypeStage[];
  libelle: string;
  description: string;
}
