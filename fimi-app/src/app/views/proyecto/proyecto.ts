import { Convenio } from "../convenio/convenio";
import { Entidad } from "../entidad/entidad";
import { Moneda } from "../moneda/moneda";
import { Proyectoactividad } from "./proyectoactividad";
import { Proyectorubro } from "./proyectorubro";
import { Proyectoarchivo } from "./proyectoarchivo";
import { Proyectodesembolso } from "./proyectodesembolso";

export class Proyecto {
    idProyecto: number;
    codigo: string;
    nombre: string;
    convenio: Convenio = null;
    descripcion: string;
    entidad: Entidad = null;
    inicio: Date;
    fin: Date;
    moneda: Moneda = null;
    monto: number;
    actividades: Proyectoactividad[] = null;
    rubros: Proyectorubro[] = null;
    archivos: Proyectoarchivo[] = null;
    desembolsos: Proyectodesembolso[] = null;
}
