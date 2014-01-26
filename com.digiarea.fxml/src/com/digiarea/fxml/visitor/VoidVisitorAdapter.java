package com.digiarea.fxml.visitor;

import com.digiarea.fxml.Attribute;
import com.digiarea.fxml.Attribute.AttributeType;
import com.digiarea.fxml.Comment;
import com.digiarea.fxml.CopyElement;
import com.digiarea.fxml.DefineElement;
import com.digiarea.fxml.Element;
import com.digiarea.fxml.Fxml;
import com.digiarea.fxml.ImportProcessing;
import com.digiarea.fxml.ImportProcessing.ImportType;
import com.digiarea.fxml.IncludeElement;
import com.digiarea.fxml.InstanceDeclarationElement;
import com.digiarea.fxml.LanguageProcessing;
import com.digiarea.fxml.ProcessingInstruction;
import com.digiarea.fxml.Project;
import com.digiarea.fxml.PropertyElement;
import com.digiarea.fxml.PropertyElement.PropertyType;
import com.digiarea.fxml.ReferenceElement;
import com.digiarea.fxml.RootElement;
import com.digiarea.fxml.ScriptElement;
import com.digiarea.fxml.UknownStaticPropertyElement;
import com.digiarea.fxml.UknownTypeElement;

public class VoidVisitorAdapter<C> implements VoidVisitor<C> {

	@Override
	public void visit(Attribute n, C ctx) throws Exception {
		if (n.getAttributeType() != null) {
			n.getAttributeType().accept(this, ctx);
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(AttributeType n, C ctx) throws Exception {
	}

	@Override
	public void visit(Comment n, C ctx) throws Exception {
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(CopyElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(DefineElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(Fxml n, C ctx) throws Exception {
		if (n.getProcessingInstructions() != null) {
			for (ProcessingInstruction item : n.getProcessingInstructions()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getRoot() != null) {
			n.getRoot().accept(this, ctx);
		}
		if (n.getComments() != null) {
			for (Comment item : n.getComments()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(ImportProcessing n, C ctx) throws Exception {
		if (n.getImportType() != null) {
			n.getImportType().accept(this, ctx);
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(ImportType n, C ctx) throws Exception {
	}

	@Override
	public void visit(IncludeElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(InstanceDeclarationElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(LanguageProcessing n, C ctx) throws Exception {
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(Project n, C ctx) throws Exception {
		if (n.getFxmls() != null) {
			for (Fxml item : n.getFxmls()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(PropertyElement n, C ctx) throws Exception {
		if (n.getPropertyType() != null) {
			n.getPropertyType().accept(this, ctx);
		}
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(PropertyType n, C ctx) throws Exception {
	}

	@Override
	public void visit(ReferenceElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(RootElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(ScriptElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(UknownStaticPropertyElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	@Override
	public void visit(UknownTypeElement n, C ctx) throws Exception {
		if (n.getAttributes() != null) {
			for (Attribute item : n.getAttributes()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getElements() != null) {
			for (Element item : n.getElements()) {
				if (item != null) {
					item.accept(this, ctx);
				}
			}
		}
		if (n.getParent() != null) {
			n.getParent().accept(this, ctx);
		}
	}

	public VoidVisitorAdapter() {
		super();
	}

}
