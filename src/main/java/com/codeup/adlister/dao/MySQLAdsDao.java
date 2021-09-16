package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    @Override
    public Ad getAdById(int id) {
        Ad ad = null;
        String query = "SELECT * From ads where id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description"));
            }
            return ad;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an ad by id", e);

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }


    public List<Ad> search(String searchTerm) {
        //TODO:like clause would be good to use for query
        // TODO:handle result sets here
        //TODO:make connection to database


        String query = "SELECT * FROM ads WHERE title LIKE '%" + searchTerm + "%'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving searched ads.", e);
        }
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));

        }
    }

        @Override
        public void deleteAd(int id ){
            String del = "Delete FROM ads WHERE id = ?";
            try {
                PreparedStatement stmt = connection.prepareStatement(del);
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error with delete function", e);
            }
        }
            @Override
            public void updateAds (Ad ads){
                String query = "UPDATE ads SET title = ?, description = ? WHERE id LIKE ?";
                try {
                    PreparedStatement stmt = connection.prepareStatement(query);
                    stmt.setString(1, ads.getTitle());
                    stmt.setString(2, ads.getDescription());
                    stmt.setLong(3, ads.getId());
                    stmt.executeUpdate();
                } catch (SQLException sqle) {
                    throw new RuntimeException("could not update ad");
                }
        }
}


    @Override
    public Ad getOne(long adId) {
        String sql = "SELECT * FROM ads WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, adId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Ad();
    }

    @Override
    public Ad getOne() {
        return null;
    }


}

