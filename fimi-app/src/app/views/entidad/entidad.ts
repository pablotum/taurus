import { Pais } from "../pais/pais";

export class Entidad {
    idEntidad: number;
    codigo: string;
    nombre: string;
    telefono: string;
    correo: string;
    postal: string;
    direccion: string;
    ciudad: string;
    pais: Pais = null;
}
