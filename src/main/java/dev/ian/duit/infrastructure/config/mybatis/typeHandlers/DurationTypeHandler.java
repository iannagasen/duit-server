package dev.ian.duit.infrastructure.config.mybatis.typeHandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Duration.class)
public class DurationTypeHandler extends BaseTypeHandler<Duration>{

  @Override
  public void setNonNullParameter(PreparedStatement preparedStatement, int i, Duration duration, JdbcType jdbcType) throws SQLException {
    preparedStatement.setLong(i, duration.toMillis());
  }

  @Override
  public Duration getNullableResult(ResultSet resultSet, String s) throws SQLException {
    long millis = resultSet.getLong(s);
    return Duration.ofMillis(millis);
  }

  @Override
  public Duration getNullableResult(ResultSet resultSet, int i) throws SQLException {
    long millis = resultSet.getLong(i);
    return Duration.ofMillis(millis);
  }

  @Override
  public Duration getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
    long millis = callableStatement.getLong(i);
    return Duration.ofMillis(millis);
  }
  
}
