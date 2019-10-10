/********************************************************************************
 * Copyright (c) 2019 Stephane Bastian
 *
 * This program and the accompanying materials are made available under the 2
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *
 * Contributors: 4
 *   Stephane Bastian - initial API and implementation
 ********************************************************************************/
package io.vertx.ext.auth;

import org.junit.Assert;
import org.junit.Test;

public class NotAuthorizationTest {

  @Test
  public void testImpliesOk1() {
    Assert.assertEquals(true, NotAuthorization.create(PermissionBasedAuthorization.create("p1"))
        .verify(NotAuthorization.create(PermissionBasedAuthorization.create("p1"))));
  }

  @Test
  public void testImpliesKo1() {
    Assert.assertEquals(false, NotAuthorization.create(PermissionBasedAuthorization.create("p1"))
        .verify(NotAuthorization.create(PermissionBasedAuthorization.create("p2"))));
  }

  @Test
  public void testImpliesKo2() {
    Assert.assertEquals(false, NotAuthorization.create(PermissionBasedAuthorization.create("p1"))
        .verify(PermissionBasedAuthorization.create("p2")));
  }

}
