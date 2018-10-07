import { Pais } from "../pais/pais";

export class Donante {
    idDonante: number;
    codigo: string;
    nombre: string;
    telefono: string;
    correo: string;
    postal: string;
    direccion: string;
    ciudad: string;
    pais: Pais = null;

}
