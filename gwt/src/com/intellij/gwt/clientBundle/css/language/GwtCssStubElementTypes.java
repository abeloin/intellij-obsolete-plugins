package com.intellij.gwt.clientBundle.css.language;

import com.intellij.psi.css.impl.stubs.CssStubDefinition;
import com.intellij.psi.css.impl.stubs.base.ICssStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import org.jetbrains.annotations.NotNull;

public final class GwtCssStubElementTypes {
  // Stub serialization and PSI creation for this element type are registered separately:
  // see GwtCssStubRegistryExtension and GwtCssParserDefinition.createElement().
  public static final IElementType GWT_CSS_STYLESHEET = new GwtCssStylesheetElementType("GWT_CSS_STYLESHEET");

  public static final IFileElementType GWT_CSS_FILE = new GwtCssFileElementType();


  private static final class GwtCssStylesheetElementType extends IElementType implements ICssStubElementType {
    GwtCssStylesheetElementType(@NotNull String debugName) {
      super(debugName, GwtCssLanguage.GWT_CSS_LANGUAGE);
    }

    // same presentation as the former CssStylesheetStubElementType (used by PSI dumps)
    @Override
    public String toString() {
      return "PsiElement(" + super.toString() + ")";
    }
  }

  private static class GwtCssFileElementType extends IStubFileElementType {

    GwtCssFileElementType() {
      super("GWT_CSS_FILE", GwtCssLanguage.GWT_CSS_LANGUAGE);
    }

    @Override
    public @NotNull String getExternalId() {
      return "gwt.css.file";
    }

    @Override
    public int getStubVersion() {
      // bumped from 1 when the stylesheet stub moved to CssStylesheetStubSerializingFactory
      return 2 + CssStubDefinition.BASE_VERSION;
    }
  }
}
