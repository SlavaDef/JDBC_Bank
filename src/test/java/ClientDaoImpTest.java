import com.progItHomework.dto.clientDao.ClientDao;
import com.progItHomework.dto.clientDao.ClientDaoImpl;
import com.progItHomework.dto.ScoreDao.ScoreDao;
import com.progItHomework.dto.ScoreDao.ScoreDaoImp;
import com.progItHomework.entity.Client;
import com.progItHomework.entity.ExchangeRates;
import com.progItHomework.entity.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientDaoImpTest {

    ClientDao clientDao;
    ScoreDao scoreDao;

    Client client = new Client("Arni", "033-33-22", "Jordan Street 5", "ff@com",
            "HH220022", List.of(new Score(22.0, 20.0, 200.5,
            new ExchangeRates(37.5, 38.5, 40.5, 41.5))));

    Score score = new Score(22.0, 20.0, 200.5,
            new ExchangeRates(37.5, 38.5, 40.5, 41.5));


    @BeforeEach
    public void initialize() {
        clientDao = new ClientDaoImpl();
        scoreDao = new ScoreDaoImp();
    }

    @Test
    void ifClientIsAdd() {
        client.setEmail("gmail.com");
        clientDao.addClient(client);
        Client random = clientDao.getById(client.getId());
        assertEquals(client.getEmail(), random.getEmail());
    }

    @Test
    void ifClientGetingById() {
        clientDao.addClient(client);
        Client find = clientDao.getById(client.getId());
        assertEquals(client.getPhone(), find.getPhone());
    }

    @Test
    void ifCreateSomeClientsWork() {
        clientDao.createSomeClients(5);
        List<Client> clients = clientDao.getAllClients();
        assertEquals(6, clients.size());  // TO-DO
    }

    @Test
    void ifClientIsUpdated() {
        clientDao.addClient(client);
        client.setClientFullName("new Name");
        clientDao.updateClient(client);
        String name = client.getClientFullName();
        assertEquals("new Name", name);

    }

    @Test
    void ifAddScoreToClientWorks() {
        scoreDao.addScore(score);
        clientDao.addClient(client);
        clientDao.addScoreToClient(scoreDao.getById(score.getId()), clientDao.getById(client.getId()));
        Score scoreList = clientDao.getById(client.getId()).getScoreList().get(0);
        assertEquals(score.getId(), scoreList.getId());
    }

    @Test
    void ifClientReturnsByPassport() {
        clientDao.addClient(client);
        Client client1 = clientDao.getClientByPassport("HH220022");
        assertEquals(client.getPhone(), client1.getPhone());
    }
}
