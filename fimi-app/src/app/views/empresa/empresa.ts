import { Pais } from "../pais/pais";
import { Tipoempresa } from "../tipoempresa/tipoempresa";

export class Empresa {
    id_empresa: number;
    codigo: string;
    nombre: string;
    razon: string;
    nit: string;
    estado: boolean;
    direccion: string;
    colonia: string;
    ciudad: string;
    pais: Pais = null;
    tipoEmpresa: Tipoempresa = null;
}
