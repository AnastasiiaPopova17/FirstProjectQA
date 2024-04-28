package tests.homeproject.utils;

import org.testng.annotations.DataProvider;
import tests.homeproject.dto.UserDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewAccount() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"Asya", "Po", "gdlfga@gmail.com", "1234Qwer!", "1234Qwer!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addAccountsCSVFile() {
        List<Object[]> list = new ArrayList<>();
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("src/test/resources/accounts.csv")));
            line = reader.readLine();

            while (line != null) {
                String [] split = line.split(",");
                list.add(new Object[]{new UserDTO().setFirstName(split[0])
                        .setLastName(split[1])
                        .setEmail(split[2])
                        .setPassword(split[3])
                        .setConfirmPassword(split[4])});
                line = reader.readLine();
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();

    }
}
