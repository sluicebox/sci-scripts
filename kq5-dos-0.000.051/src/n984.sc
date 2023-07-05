;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 984)
(include sci.sh)
(use Main)

(public
	SortedAdd 0
)

(procedure (SortedAdd theOrigin theLists &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15) ; UNUSED
	(= temp1 [theLists 0])
	(= temp12 (theOrigin x:))
	(= temp13 (theOrigin y:))
	(= temp15
		(cond
			((< (= temp14 (theOrigin heading:)) 90)
				(GetDistance temp12 temp13 320 0 gPerspective)
			)
			((< temp14 180)
				(GetDistance temp12 temp13 320 200 gPerspective)
			)
			((< temp14 270)
				(GetDistance temp12 temp13 0 200 gPerspective)
			)
			(else
				(GetDistance temp12 temp13 0 0 gPerspective)
			)
		)
	)
	(-- argc)
	(repeat
		(= temp7 0)
		(= temp6 32767)
		(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
			(= temp2 [theLists temp0])
			(for
				((= temp3 (FirstNode (temp2 elements:))))
				(and temp3 (IsObject (= temp5 (NodeValue temp3))))
				((= temp3 (NextNode temp3)))
				
				(if (temp1 contains: temp5)
				else
					(= temp8 (temp5 x:))
					(= temp9 (temp5 y:))
					(= temp10 (- (GetAngle temp12 temp13 temp8 temp9) temp14))
					(= temp11
						(<=
							(= temp10
								(Abs
									(+
										temp10
										(cond
											((<= temp10 -180) 360)
											((> temp10 180) -360)
										)
									)
								)
							)
							(- 180 global56)
						)
					)
					(if
						(and
							(<=
								(= temp4
									(+
										(GetDistance
											temp12
											temp13
											temp8
											temp9
											gPerspective
										)
										(if temp11 temp15)
									)
								)
								temp6
							)
							(<= 1 temp8 320)
							(<= 1 temp9 200)
							(or (== temp4 0) temp11)
						)
						(= temp7 temp5)
						(= temp6 temp4)
					)
				)
			)
		)
		(if temp7
			(temp1 addToEnd: temp7)
		else
			(break)
		)
	)
)

