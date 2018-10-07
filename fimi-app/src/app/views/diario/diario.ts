import { Diariodetalle } from "./diariodetalle";

export class Diario {
    asiento: number;
    fecha: Date;
    descripcion: string;
    codigo: string;
    detalle: Diariodetalle[] = null;
}
