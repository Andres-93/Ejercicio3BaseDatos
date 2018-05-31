package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import modelo.piloto;


public class PilotoPersistencia {

	private accesoBD acceso;

	
	public PilotoPersistencia() {
		this.acceso = new accesoBD();
	}
	
	public ArrayList<piloto> cargarPilotos() {
		
		ArrayList<piloto> pilotos = new ArrayList<piloto>();
		piloto pi = null;
		Connection con = null;
		Statement st = null;
        ResultSet rs = null;
		
		
		try {
			
			con = acceso.getConexion();
			System.out.println("Conectado");
			
            st = con.createStatement();
            rs = st.executeQuery("Select * from pilotos");
           
           while(rs.next()) {      	   
        	   pi = new piloto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
        	  pilotos.add(pi);      	   
           }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error");
           ex.printStackTrace();
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }
		catch(Exception e) {
			e.printStackTrace();
        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
        }finally {	
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				if(con != null) {
					acceso.desconectar(con);
				}			
			}catch(SQLException e) {
				 System.out.println("No se pudo cerrar");
			}	
        }
		return pilotos;
	}

	public void añadirPiloto(piloto pi) {
	
	PreparedStatement st = null;
	Connection con = null;
	
	try {
		
		con =acceso.getConexion();
		System.out.println("Conectado");
		
        st = con.prepareStatement("insert into pilotos (numero,nombre,nacionalidad,edad,escuderia) values (?,?,?,?,?)");
        st.setInt(1, pi.getNumero());
        st.setString(2, pi.getNombre());
        st.setString(3, pi.getNacionalidad());
        st.setInt(4, pi.getEdad());
        st.setString(5, pi.getEscuderia());
        st.executeUpdate();
        JOptionPane.showConfirmDialog(null, "Piloto guardado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Piloto ya existente");
    }catch(ClassNotFoundException er) {
    	er.printStackTrace();
    }catch(Exception e) {
    	JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.CANCEL_OPTION);
    }finally {
		try {
			if(st != null) {
				st.close();
			}
			if(con != null) {
				acceso.desconectar(con);
			}
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}
    }
}
	
	public void eliminarPiloto(piloto pi) {
		
		 PreparedStatement st = null;
		 Connection con = null;
			
		try {
			
			con = acceso.getConexion();
			System.out.println("Conectado");
			
          st = con.prepareStatement("Delete from pilotos where numero =?");
          st.setInt(1, pi.getNumero());
          st.execute();
          JOptionPane.showConfirmDialog(null, "Piloto eliminado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {        
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {
	        	
	        	try {
	        		if(st != null) {
	        			st.close();
	        		}
	        		if (con != null) {
	        			acceso.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println("No se pudo cerrar");
	    		}		        	
	        }				
	}	
	
	public void modificarAlumno(piloto pi) {
		
		PreparedStatement sm = null;
		Connection con = null;		
		try {
			
			con = acceso.getConexion();
			System.out.println("Conectado");
	
			sm = con.prepareStatement("update pilotos set nacionalidad = ?,edad = ?, escuderia = ? where numero = ?");
            sm.setString(1, pi.getNacionalidad());
            sm.setInt(2, pi.getEdad());
            sm.setString(3, pi.getEscuderia());
            sm.setInt(4, pi.getNumero());
            sm.executeUpdate();
            JOptionPane.showConfirmDialog(null, "Piloto modificado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {
	        	
	        	try {
	        		if(sm != null) {
	        			sm.close();
	        		}
	        		if (con != null) {
	        			acceso.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println("No se pudo cerrar");
	    		}		        	
	        }		
				
					
	}
	
	
}
