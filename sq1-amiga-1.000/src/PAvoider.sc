;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 927)
(include sci.sh)
(use PolyPath)
(use Polygon)
(use System)

(class PAvoider of Code
	(properties
		client 0
	)

	(method (init aClient)
		(if (>= argc 1)
			(= client aClient)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(if
			(and
				(= temp8 (client mover:))
				(IsObject (= temp2 (temp8 doit:)))
				(not (temp8 completed:))
				(temp8 isKindOf: PolyPath)
				(IsObject ((temp8) obstacles:))
			)
			(= temp4
				(-
					(temp2 brLeft:)
					(= temp0
						(+
							(* 2 (client xStep:))
							(/
								(Max
									(CelWide (client view:) 2 0)
									(CelWide (client view:) 0 0)
								)
								2
							)
						)
					)
				)
			)
			(= temp5
				(-
					(CoordPri 1 (CoordPri (temp2 y:)))
					(= temp1 (* (client yStep:) 2))
				)
			)
			(= temp6 (+ (temp2 brRight:) temp0))
			(= temp7 (+ (temp2 y:) temp1))
			(if (and (temp2 respondsTo: #mover) (temp2 mover:))
				(= temp9 (temp2 heading:))
				(= temp10
					(*
						(= temp12
							(Min
								(/
									(* 60 (+ (temp2 moveSpeed:) 1))
									(* 10 (+ (client moveSpeed:) 1))
								)
								20
							)
						)
						(client xStep:)
					)
				)
				(= temp11 (* temp12 (client yStep:)))
				(= temp0 (SinMult temp9 temp10))
				(= temp1 (- (CosMult temp9 temp11)))
				(cond
					((< temp0 0)
						(+= temp4 temp0)
					)
					((> temp0 0)
						(+= temp6 temp0)
					)
				)
				(cond
					((< temp1 0)
						(+= temp5 temp0)
					)
					((> temp1 0)
						(+= temp7 temp0)
					)
				)
			)
			((temp8 obstacles:)
				add:
					(= temp3
						((Polygon new:)
							init:
								temp4
								temp5
								temp6
								temp5
								(+ temp6 (client xStep:))
								(temp2 y:)
								temp6
								temp7
								temp4
								temp7
								(- temp4 (client xStep:))
								(temp2 y:)
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
			)
			(temp8 value: 2 init: client (temp8 finalX:) (temp8 finalY:))
			((temp8 obstacles:) delete: temp3)
			(temp3 dispose:)
		)
	)
)

