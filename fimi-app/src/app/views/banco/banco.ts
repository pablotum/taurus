import { Pais } from "../pais/pais";

export class Banco {
    idBanco: number;
    nombre: string;
    direccion: string;
    ciudad: string;
    aba: string;
    swift: string;
    pais: Pais = null;
}
