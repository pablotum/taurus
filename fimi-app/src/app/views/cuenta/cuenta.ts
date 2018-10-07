import { Flujocuenta } from "../flujocuenta/flujocuenta";
import { Usocuenta } from "../usocuenta/usocuenta";
import { Clasificacioncuenta } from "../clasificacioncuenta/clasificacioncuenta";

export class Cuenta {
    idCuentaContable: number;
    cuentaContable: string;
    descripcion: string;
    clasificacion: Clasificacioncuenta = null;
    uso: Usocuenta = null;
    flujo: Flujocuenta = null;
    bloqueo: boolean;
}
