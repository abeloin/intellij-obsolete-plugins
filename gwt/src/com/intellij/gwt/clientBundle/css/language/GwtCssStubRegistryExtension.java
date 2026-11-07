package com.intellij.gwt.clientBundle.css.language;

import com.intellij.psi.css.impl.stubs.CssStylesheetStubSerializingFactory;
import com.intellij.psi.stubs.StubRegistry;
import com.intellij.psi.stubs.StubRegistryExtension;
import org.jetbrains.annotations.NotNull;

public final class GwtCssStubRegistryExtension implements StubRegistryExtension {
  @Override
  public void register(@NotNull StubRegistry registry) {
    registry.registerStubSerializingFactory(GwtCssStubElementTypes.GWT_CSS_STYLESHEET,
                                            new CssStylesheetStubSerializingFactory(GwtCssStubElementTypes.GWT_CSS_STYLESHEET));
  }
}
