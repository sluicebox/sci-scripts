;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 927)
(include sci.sh)
(use PolyPath)
(use Polygon)
(use System)

(procedure (localproc_0 param1 &tmp temp0 [temp1 2] temp3 temp4)
	(= temp3 -100)
	(for ((= temp0 0)) (!= temp3 30583) ((++ temp0))
		(= temp3 (WordAt param1 (* 2 temp0)))
	)
	(-- temp0)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp3 (param1 size:))
	(for ((= temp0 0)) (< temp0 temp3) ((++ temp0))
		(= temp1 (param1 at: temp0))
		(if (>= (= temp2 (temp1 type:)) 16)
			(temp1 type: (- temp2 16))
		)
	)
)

(class PAvoider of Code
	(properties
		client 0
		oldBlocker 0
		oldBlockerMover 0
		oldMoverX -99
		oldMoverY -99
	)

	(method (init aClient)
		(if (>= argc 1)
			(= client aClient)
		)
	)

	(method (dispose)
		(if (IsObject oldBlockerMover)
			(oldBlockerMover dispose:)
		)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 4] temp14 temp15 temp16 temp17 [temp18 5] temp23)
		(= temp9 (client mover:))
		(if (and oldBlocker (>= (client distanceTo: oldBlocker) 20))
			(oldBlocker ignoreActors: 0)
			(if oldBlockerMover
				(oldBlocker mover: oldBlockerMover)
			)
			(= oldMoverY (= oldMoverX -99))
			(= oldBlocker (= oldBlockerMover 0))
			(if
				(and
					temp9
					(IsObject (temp9 obstacles:))
					((temp9 obstacles:) isEmpty:)
				)
				((temp9 obstacles:) dispose:)
				(temp9 obstacles: 0)
			)
		)
		(if
			(and
				(= temp9 (client mover:))
				(IsObject (= temp4 (temp9 doit:)))
				(not (temp9 completed:))
				(temp9 isKindOf: PolyPath)
			)
			(if (temp4 respondsTo: #mover)
				(= oldBlockerMover (temp4 mover:))
				(if oldBlockerMover
					(temp4 mover: 0)
				)
			else
				(= oldBlockerMover 0)
			)
			(= oldMoverX (temp9 finalX:))
			(= oldMoverY (temp9 finalY:))
			(= oldBlocker temp4)
			(oldBlocker ignoreActors: 1)
			(= temp5
				(-
					(temp4 brLeft:)
					(= temp2
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
			(= temp6 (CoordPri 1 (CoordPri (temp4 y:))))
			(= temp3 (* 2 (temp4 yStep:)))
			(= temp7 (+ (temp4 brRight:) temp2))
			(if (<= (- (= temp8 (+ (temp4 y:) temp3 2)) temp6) 3)
				(-= temp6 2)
				(+= temp8 2)
			)
			(= temp0 (- (temp9 finalX:) (client x:)))
			(= temp1 (- (temp9 finalY:) (client y:)))
			(= temp23 (client heading:))
			(cond
				((<= 85 temp23 95)
					(= temp14 0)
				)
				((<= 265 temp23 275)
					(= temp14 1)
				)
				((>= temp1 0)
					(= temp14 2)
				)
				(else
					(= temp14 3)
				)
			)
			(switch temp14
				(3
					(= temp17
						((Polygon new:)
							init:
								temp5
								(client y:)
								temp5
								temp6
								temp7
								temp6
								temp7
								(client y:)
								30583
								0
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
				(2
					(= temp17
						((Polygon new:)
							init:
								temp7
								(client y:)
								temp7
								temp8
								temp5
								temp8
								temp5
								(client y:)
								30583
								0
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
				(0
					(= temp17
						((Polygon new:)
							init:
								(client x:)
								temp6
								temp7
								temp6
								temp7
								temp8
								(client x:)
								temp8
								30583
								0
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
				(1
					(= temp17
						((Polygon new:)
							init:
								(client x:)
								temp8
								temp5
								temp8
								temp5
								temp6
								(client x:)
								temp6
								30583
								0
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
			)
			(if (not (temp9 obstacles:))
				(temp9 obstacles: (List new:))
			)
			(if
				(= temp16
					(MergePoly
						(temp17 points:)
						((temp9 obstacles:) elements:)
						((temp9 obstacles:) size:)
					)
				)
				((= temp15 (Polygon new:))
					points: temp16
					size: (localproc_0 temp16)
					type: PBarredAccess
					dynamic: 1
				)
			)
			((temp9 obstacles:) add: temp15)
			(temp9 value: 2 init: client (temp9 finalX:) (temp9 finalY:))
			((temp9 obstacles:) delete: temp15)
			((temp9 obstacles:) delete: temp17)
			(if (IsObject (temp9 obstacles:))
				(localproc_1 (temp9 obstacles:))
			)
			(temp17 dispose:)
			(temp15 dispose:)
		)
	)
)

