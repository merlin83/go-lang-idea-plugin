package ro.redeul.google.go.lang.psi.resolve.refs;

import ro.redeul.google.go.lang.psi.resolve.ReferenceSolvingVisitor;
import ro.redeul.google.go.lang.psi.resolve.VisitingReferenceSolver;
import ro.redeul.google.go.lang.psi.types.GoPsiTypeStruct;
import ro.redeul.google.go.lang.psi.types.struct.GoTypeStructAnonymousField;
import ro.redeul.google.go.lang.psi.types.struct.GoTypeStructField;
import ro.redeul.google.go.lang.psi.types.struct.GoTypeStructPromotedFields;

public class StructFieldSolver extends VisitingReferenceSolver<StructFieldReference, StructFieldSolver> {

    public StructFieldSolver(StructFieldReference reference) {
        solveWithVisitor(new ReferenceSolvingVisitor(this, reference) {
            @Override
            public void visitTypeStructField(GoTypeStructField field) {
                checkIdentifiers(referenceName(), field.getIdentifiers());
            }

            @Override
            public void visitTypeStructAnonymousField(GoTypeStructAnonymousField field) {
                if (matchNames(referenceName(), field.getFieldName()))
                    addTarget(field);
            }

            @Override
            public void visitStructType(GoPsiTypeStruct type) {
                for (GoTypeStructField structField : type.getFields()) {
                    structField.accept(this);
                }

                for (GoTypeStructAnonymousField anonymousField : type.getAnonymousFields()) {
                    anonymousField.accept(this);
                }

                GoTypeStructPromotedFields promotedFields = type.getPromotedFields();
                checkIdentifiers(referenceName(), promotedFields.getNamedFields());

                for (GoTypeStructAnonymousField anonymousField : promotedFields.getAnonymousFields()) {
                    anonymousField.accept(this);
                }
            }
        });
    }

    @Override
    public StructFieldSolver self() { return this; }
}