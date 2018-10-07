import { Donante } from "../donante/donante";
import { Moneda } from "../moneda/moneda";
import { Convenioactividad } from "./convenioactividad";
import { Conveniorubro } from "./conveniorubro";
import { Convenioarchivo } from "./convenioarchivo";
import { Conveniodesembolso } from "./conveniodesembolso";

export class Convenio {
    idConvenio: number;
    codigo: string;
    nombre: string;
    descripcion: string;
    donante: Donante = null;
    inicio: Date;
    fin: Date;
    moneda: Moneda = null;
    monto: number;
    actividades: Convenioactividad[] = null;
    rubros: Conveniorubro[] = null;
    archivos: Convenioarchivo[] = null;
    desembolsos: Conveniodesembolso[] = null;
}
