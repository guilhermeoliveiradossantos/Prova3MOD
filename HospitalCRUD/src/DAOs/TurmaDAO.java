package DAOs;

import Conexao.ConexaoSQL;
import Models.TurmasModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TurmaDAO {

    public void CadastrarTurmas(TurmasModel tm) {

        String sql = "INSERT INTO Turmas (ProfessorResponsavel,AnoLetivo,CodigoTurma,HorariodeAula) VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = ConexaoSQL.conexaoMySQL();
            ps = connection.prepareStatement(sql);

            ps.setString(1, tm.getProfessorResponsavel());
            ps.setString(2, tm.getAnoLetivo());
            ps.setString(3, tm.getCodigoTurma());
            ps.setString(4, tm.getHorariodeAula());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso");

        } catch (Exception exception) {

            exception.printStackTrace();

        }

    }

    public List<TurmasModel> ShowTurmas() {

        String sql = "SELECT * FROM Turmas";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<TurmasModel> tms = new ArrayList<>();

        try {

            connection = ConexaoSQL.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                TurmasModel tm = new TurmasModel();
                
                tm.setNumeroTurma(resultSet.getInt("NumeroTurma"));
                tm.setProfessorResponsavel(resultSet.getString("ProfessorResponsavel"));
                tm.setAnoLetivo(resultSet.getString("AnoLetivo"));
                tm.setCodigoTurma(resultSet.getString("CodigoTurma"));
                tm.setHorariodeAula(resultSet.getString("HorariodeAula"));

                tms.add(tm);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "erro em Mostrar Turmas: " + e);

        }
        return tms;
    }

    public void DeletarProfessores(int id) {

        String sql = "DELETE FROM Professores WHERE id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConexaoSQL.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Turma deletada com sucesso");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "erro em deletar Turma: " + e);

        }

    }

}
