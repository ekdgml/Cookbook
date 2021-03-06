package com.namoo.cookbook.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.namoo.cookbook.dao.RecipeDao;
import com.namoo.cookbook.domain.ImageFile;
import com.namoo.cookbook.domain.Recipe;
import com.namoo.cookbook.shared.exception.CookbookRuntimeException;

@Repository
public class RecipeDaoJdbc implements RecipeDao {
	//
	@Autowired
	private DataSource datasource;
	
	@Override
	public List<Recipe> readAllRecipes() {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		try {
			 conn = datasource.getConnection();
			 String sql = "SELECT recipe_nm, ingredients, procedures, img_type, img_file FROM recipe_tb";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 while (rs.next()) {
				 recipes.add(mapToRecipe(rs));
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CookbookRuntimeException("모든 조리법 목록조회 중 오류", e);
		} finally {
			closeQueitly(rs, pstmt, conn);
		}
		return recipes;
	}

	@Override
	public Recipe readRecipe(String recipeName) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Recipe recipe = null;
		try {
			 conn = datasource.getConnection();
			 String sql = "SELECT recipe_nm, ingredients, procedures, img_type, img_file FROM recipe_tb WHERE recipe_nm=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, recipeName);
			 rs = pstmt.executeQuery();
			 
			 if (rs.next()) {
				recipe = mapToRecipe(rs);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CookbookRuntimeException("조리법 조회 중 오류", e);
		} finally {
			closeQueitly(rs, pstmt, conn);
		}
		return recipe;
	}

	@Override
	public void insertRecipe(Recipe recipe) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			 conn = datasource.getConnection();
			 String sql = "INSERT INTO recipe_tb(recipe_nm, ingredients, procedures, img_type, img_file) VALUES(?,?,?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, recipe.getName());
			 pstmt.setString(2, recipe.getIngredients());
			 pstmt.setString(3, recipe.getProcedure());
			 
			 if(recipe.getRecipeImage() != null) {
				 pstmt.setString(4, recipe.getRecipeImage().getContentType());
				 pstmt.setString(5, recipe.getRecipeImage().getFileName());
			 } else {
				 pstmt.setString(4, "");
				 pstmt.setString(5, "");
			 }
			 
			 pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CookbookRuntimeException("조리법 추가 중 오류", e);
		} finally {
			closeQueitly(pstmt, conn);
		}
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			 conn = datasource.getConnection();
			 String sql = "UPDATE recipe_tb SET ingredients=?, procedures=?, img_type=?, img_file=? WHERE recipe_nm=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, recipe.getIngredients());
			 pstmt.setString(2, recipe.getProcedure());
			 
			 if(recipe.getRecipeImage() != null) {
				 pstmt.setString(3, recipe.getRecipeImage().getContentType());
				 pstmt.setString(4, recipe.getRecipeImage().getFileName());
			 } else {
				 pstmt.setString(3, "");
				 pstmt.setString(4, "");
			 }
			 
			 pstmt.setString(5, recipe.getName());
			 pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CookbookRuntimeException("조리법 수정 중 오류", e);
		} finally {
			closeQueitly(pstmt, conn);
		}
	}

	@Override
	public void deleteRecipe(String recipeName) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			 conn = datasource.getConnection();
			 String sql = "DELETE FROM recipe_tb WHERE recipe_nm=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, recipeName);
			 
			 pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CookbookRuntimeException("조리법 삭제 중 오류", e);
		} finally {
			closeQueitly(pstmt, conn);
		}
	}
	//---------------------------------------------------------------------------------------------------
	// private method
	
	/**
	 * ResultSet을 Recipe객체로 변환한다.
	 * 
	 * @param rs 조회결과
	 * @return {@link Recipe}
	 * @throws SQLException
	 */
	private Recipe mapToRecipe(ResultSet rs) throws SQLException {
		//
		String recipeName = rs.getString("recipe_nm");
		String ingredients = rs.getString("ingredients");
		String procedure = rs.getString("procedures");
		
		Recipe recipe = new Recipe(recipeName, ingredients, procedure);
		
		String imgType = rs.getString("img_type");
		String imgFile = rs.getString("img_file");
		if (!StringUtils.isEmpty(imgType) && !StringUtils.isEmpty(imgFile)) {
			//
			recipe.setRecipeImage(new ImageFile(imgType, imgFile));
		}
		
		return recipe;
	}
	

	/**
	 * DB 관련 자원을 종료한다.
	 * 
	 * @param rs 
	 * @param pstmt
	 * @param conn
	 */
	private void closeQueitly(AutoCloseable ...autoCloseables) {
		//
		for (AutoCloseable closeable : autoCloseables) {
			if (closeable != null) try { closeable.close(); } catch(Exception e) { }
		}
	}
}
