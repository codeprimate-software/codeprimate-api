package org.codeprimate.sql;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * The DataSourceAdapter class is an implementation of the javax.sql.DataSource interface throwing
 * UnsupportedOperationExceptions for all data source operations.
 *
 * @author John J. Blum
 * @see java.lang.UnsupportedOperationException
 * @see javax.sql.DataSource
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class DataSourceAdapter implements DataSource {

  protected static final String UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE = "Not Implemented!";

  @Override
  public Connection getConnection() throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

  @Override
  public Connection getConnection(final String username, final String password) throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

  @Override
  public PrintWriter getLogWriter() throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

  @Override
  public void setLogWriter(final PrintWriter out) throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

  @Override
  public int getLoginTimeout() throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

  @Override
  public void setLoginTimeout(final int seconds) throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
  }

}
