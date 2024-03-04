import './style.scss';
import { useEffect, useState } from "react";
import api from "../../utils/api";

interface Manufacturer {
    manufactureId: number;
    manufacturerName: string;
    manufacturerCNPJ: string;
    manufacturerFantasyName: string;
    manufacturerActive: boolean;
  }





const Listing: React.FC = () => {
    const [manufacturers, setManufacturers] = useState<Manufacturer[]>([]);
    
    useEffect(() => {
        const fetchData = async () => {
          try {
            const response = await api.get('/find/all');
            setManufacturers(response.data);
          } catch (error) {
            console.error('Error fetching manufacturers:', error);
          }
        };
    
        fetchData();
      }, []);

      const getActiveStatus = (isActive: boolean) => {
        return isActive ? 'Sim' : 'Não';
      };

    return(
        <>
        <div className="container over">
        <h4 className='margin-top-20'>Empresas Cadastradas</h4>
        <p></p>
        <table>
        <thead>
          <tr>
            <th className="space-table">Id</th>
            <th className="space-table">Name</th>
            <th className="space-table">CNPJ</th>
            <th className="space-table">Nome Fantasia</th>
            <th className="space-table">Empresa Ativa</th>
            </tr>
        </thead>
        <tbody>
          {manufacturers.map((manufacturer) => (
            <tr key={manufacturer.manufactureId}>
              <td className="space-table">{manufacturer.manufactureId}</td>
              <td className="space-table">{manufacturer.manufacturerName}</td>
              <td className="space-table">{manufacturer.manufacturerCNPJ}</td>
              <td className="space-table">{manufacturer.manufacturerFantasyName}</td>
              <td className="space-table">{getActiveStatus(manufacturer.manufacturerActive)}</td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
      </>
        
        
        
    );
}


export default Listing;