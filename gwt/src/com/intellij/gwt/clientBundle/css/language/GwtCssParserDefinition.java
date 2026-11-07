package com.intellij.gwt.clientBundle.css.language;

import com.intellij.gwt.clientBundle.css.language.psi.impl.GwtCssFileImpl;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiParser;
import com.intellij.lang.css.CSSParserDefinition;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.css.impl.CssStubStylesheet;
import com.intellij.psi.tree.IFileElementType;
import org.jetbrains.annotations.NotNull;

public final class GwtCssParserDefinition extends CSSParserDefinition {
  @Override
  public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new GwtCssFileImpl(viewProvider);
  }

  @Override
  public @NotNull IFileElementType getFileNodeType() {
    return GwtCssStubElementTypes.GWT_CSS_FILE;
  }

  @Override
  public @NotNull PsiElement createElement(@NotNull ASTNode node) {
    if (node.getElementType() == GwtCssStubElementTypes.GWT_CSS_STYLESHEET) {
      return new CssStubStylesheet(node);
    }
    return super.createElement(node);
  }

  @Override
  public @NotNull PsiParser createParser(@NotNull Project project) {
    return new GwtCssParser();
  }
}
