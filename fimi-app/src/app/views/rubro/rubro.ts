import { Cuenta } from "../cuenta/cuenta";

export class Rubro {
    idRubro: number;
    codigo: string;
    rubro: string;
    descripcion: string;
    cuentaContable: Cuenta = null;
    
}
