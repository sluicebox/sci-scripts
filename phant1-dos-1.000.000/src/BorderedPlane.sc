;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use DText)
(use Plane)
(use Array)
(use Actor)
(use System)

(class BorderedPlane of Plane
	(properties
		myCast 0
		borderView -1
	)

	(method (addBorder param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= borderView param1)
		(if myCast
			(myCast dispose:)
		)
		(= myCast (Cast new:))
		(self addCast: myCast)
		(if (!= borderView -1)
			(= temp0 (* (CelWide borderView 0 0) 2))
			(= temp1 (/ (* (CelHigh borderView 0 0) 24) 10))
			(= temp2 right)
			(= temp3 bottom)
			(= temp2 (+ (* temp2 2) 3))
			(= temp3 (+ (/ (* temp3 24) 10) 2))
			((= temp7 (View new:)) bitmap: (Bitmap 0 temp2 temp3 0 0 640 480)) ; Create
			(= temp4 (* (CelWide borderView 4 0) 2))
			(= temp5 (/ (* (CelHigh borderView 4 0) 24) 10))
			(for
				((= temp6 (- temp1 2)))
				(< temp6 (- temp3 (- temp1 3)))
				((+= temp6 temp5))
				
				(Bitmap 3 (temp7 bitmap:) borderView 5 0 0 temp6) ; AddCel
				(Bitmap 3 (temp7 bitmap:) borderView 7 0 (- temp2 1) temp6) ; AddCel
			)
			(for
				((= temp6 temp0))
				(< temp6 (- temp2 (- temp0 2)))
				((+= temp6 (- temp4 1)))
				
				(Bitmap 3 (temp7 bitmap:) borderView 6 0 temp6 temp3) ; AddCel
				(Bitmap 3 (temp7 bitmap:) borderView 4 0 temp6 0) ; AddCel
			)
			(Bitmap 3 (temp7 bitmap:) borderView 0 0 0 0) ; AddCel
			(Bitmap 3 (temp7 bitmap:) borderView 1 0 0 temp3) ; AddCel
			(Bitmap 3 (temp7 bitmap:) borderView 2 0 temp2 0) ; AddCel
			(Bitmap 3 (temp7 bitmap:) borderView 3 0 temp2 temp3) ; AddCel
			(temp7 init: myCast)
			(self setSize:)
		)
	)

	(method (setTitle param1 &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(self addCast: ((= temp2 (Cast new:)) name: {titleCast} yourself:))
		((= temp10 (DText new:))
			fore: 24
			back: 0
			font: 0
			text: param1
			posn: 0 0
		)
		(= temp3 (IntArray new:))
		(Text 0 (temp3 data:) param1 0 -1) ; TextSize
		(= temp4 (+ (temp3 at: 3) 12))
		(temp10 nsLeft: 0 nsTop: 0 nsRight: (- right left) nsBottom: temp4)
		(= temp11 (- (temp10 nsRight:) (temp10 nsLeft:)))
		(= temp12 (- (temp3 at: 2) (temp3 at: 0)))
		(= temp13 (/ (- temp11 temp12) 2))
		(temp10
			textLeft: temp13
			textTop: 8
			textRight: (+ temp13 temp12 8)
			textBottom: temp4
			init: temp2
		)
		(temp3 dispose:)
		(= temp5 (+ (- bottom top) 1))
		(if (< top temp4)
			(= top 0)
		else
			(-= top temp4)
		)
		(self setRect: left top right (+ top temp5 temp4) 1)
		(for
			((= temp6 (KList 3 (casts elements:)))) ; FirstNode
			temp6
			((= temp6 (casts nextNode:)))
			
			(casts nextNode: (KList 6 temp6)) ; NextNode
			(= temp8 (KList 8 temp6)) ; NodeValue
			(for
				((= temp7 (KList 3 (temp8 elements:)))) ; FirstNode
				temp7
				((= temp7 (temp8 nextNode:)))
				
				(temp8 nextNode: (KList 6 temp7)) ; NextNode
				(if (!= (= temp9 (KList 8 temp7)) temp10) ; NodeValue
					(temp9
						y: (+ (temp9 y:) temp4)
						nsTop: (+ (temp9 nsTop:) temp4)
						nsBottom: (+ (temp9 nsBottom:) temp4)
					)
					(UpdateScreenItem temp9)
				)
			)
		)
	)

	(method (dispose)
		(if myCast
			(myCast dispose:)
			(= myCast 0)
		)
		(super dispose: &rest)
	)
)

