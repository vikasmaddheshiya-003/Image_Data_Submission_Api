package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bank.util.DBUtil;

public class ChequeSubmissionDAO {

    private static final String SQL =
        "INSERT INTO tbl_outward " +
        "(actionType, chequeNumber, front, rear) " +
        "VALUES (?, ?, ?, ?)";

    public void insert(String actionType,
                       String chequeNumber,
                       byte[] front,
                       byte[] rear) throws Exception {

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL)) {

            ps.setString(1, actionType);
            ps.setString(2, chequeNumber);
            ps.setBytes(3, front);
            ps.setBytes(4, rear);

            ps.executeUpdate();
        }
    }
    public static void main(String[] args) {
		System.out.println("sdvsdcs");
	}
}
