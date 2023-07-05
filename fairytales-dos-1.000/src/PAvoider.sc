;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 927)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Polygon)
(use System)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp1 (Min param1 param3))
	(= temp0 (Min param2 param4))
	(= temp3 (Max param1 param3))
	(= temp2 (Max param2 param4))
	(if (<= param1 param3)
		(Graph grDRAW_LINE param2 param1 param4 param3 param5 -1 -1)
	else
		(Graph grDRAW_LINE param4 param3 param2 param1 param5 -1 -1)
	)
	(Graph grUPDATE_BOX (- temp0 1) (- temp1 1) (+ temp2 1) (+ temp3 1) 1)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7) ; UNUSED
	(= temp0 0)
	(= temp7 (param1 points:))
	(= temp1 (WordAt temp7 temp0))
	(= temp5 (= temp2 (WordAt temp7 (+ temp0 1))))
	(= temp6 temp2)
	(for ((+= temp0 2)) (!= (WordAt temp7 temp0) 30583) ((+= temp0 2))
		(= temp3 (WordAt temp7 temp0))
		(= temp4 (WordAt temp7 (+ temp0 1)))
		(localproc_0 temp1 temp2 temp3 temp4 param2)
		(= temp1 temp3)
		(= temp2 temp4)
	)
	(localproc_0 temp1 temp2 temp5 temp6 param2)
)

(procedure (localproc_2 param1 &tmp temp0 [temp1 2] temp3 temp4) ; UNUSED
	(= temp3 -100)
	(for ((= temp0 0)) (!= temp3 30583) ((++ temp0))
		(= temp3 (WordAt param1 (* 2 temp0)))
	)
	(-- temp0)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp3 (param1 size:))
	(for ((= temp0 0)) (< temp0 temp3) ((++ temp0))
		(= temp1 (param1 at: temp0))
		(if (>= (= temp2 (temp1 type:)) 16)
			(temp1 type: (- temp2 16))
			(Print 927 0) ; "hello"
		)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2) ; UNUSED
	(for ((= temp0 0)) (!= temp1 30583) ((++ temp0)) ; UNINIT
		(= temp1 (WordAt param1 (* 2 temp0)))
		(= temp2 (WordAt param1 (+ (* 2 temp0) 1)))
		(Printf 927 1 temp0 temp1 temp2) ; "node: %d x: %d y: %d"
	)
)

(class PAvoider of Code
	(properties
		client 0
		oldBlocker 0
		oldMoverX -1
		oldMoverY -1
	)

	(method (init aClient)
		(if (>= argc 1)
			(= client aClient)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 [temp23 2] temp25)
		(= temp17 0)
		(= temp9 (client mover:))
		(if (and oldBlocker (not temp9))
			(oldBlocker ignoreActors: 0)
			(= oldMoverY (= oldMoverX -1))
			(= oldBlocker 0)
		)
		(if
			(and
				(= temp9 (client mover:))
				(IsObject (= temp4 (temp9 doit:)))
				(not (temp9 completed:))
				(temp9 isKindOf: PolyPath)
				(IsObject ((temp9) obstacles:))
			)
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
			(= temp8 (+ (temp4 y:) temp3 2))
			(if
				(and
					(temp4 respondsTo: #mover)
					(temp4 mover:)
					(not (temp4 isStopped:))
				)
				(= temp10 (temp4 heading:))
				(= temp11
					(*
						(= temp13
							(Min
								(/
									(* 60 (+ (temp4 moveSpeed:) 1))
									(* 10 (+ (client moveSpeed:) 1))
								)
								20
							)
						)
						(client xStep:)
					)
				)
				(= temp12 (* temp13 (client yStep:)))
				(= temp2 (SinMult temp10 temp11))
				(= temp3 (- (CosMult temp10 temp12)))
				(cond
					((< temp2 0)
						(+= temp5 temp2)
					)
					((> temp2 0)
						(+= temp7 temp2)
					)
				)
				(cond
					((< temp3 0)
						(+= temp6 temp2)
					)
					((> temp3 0)
						(+= temp8 temp2)
					)
				)
			)
			(if (<= (- temp8 temp6) 3)
				(-- temp6)
				(++ temp8)
			)
			(= temp16 ((temp9 obstacles:) size:))
			(for ((= temp14 0)) (< temp14 temp16) ((++ temp14))
				(= temp15 ((temp9 obstacles:) at: temp14))
				(= temp18 (AvoidPath temp5 temp6 temp15))
				(= temp19 (AvoidPath temp7 temp6 temp15))
				(= temp20 (AvoidPath temp7 temp8 temp15))
				(= temp21 (AvoidPath temp5 temp8 temp15))
				(if (or temp18 temp19 temp20 temp21)
					(= temp17 1)
				)
			)
			(= temp0 (- (temp9 x:) (client x:)))
			(= temp1 (- (temp9 y:) (client y:)))
			(cond
				((<= temp6 (gEgo y:) temp8)
					(if (>= temp0 0)
						(= temp22 0)
					else
						(= temp22 1)
					)
				)
				((<= temp5 (gEgo x:) temp7)
					(if (>= temp1 0)
						(= temp22 2)
					else
						(= temp22 3)
					)
				)
			)
			(switch temp22
				(3
					(= temp25
						((Polygon new:)
							init:
								(client x:)
								(client y:)
								temp5
								temp8
								temp5
								temp6
								temp7
								temp6
								temp7
								temp8
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
				(2
					(= temp25
						((Polygon new:)
							init:
								(client x:)
								(client y:)
								temp7
								temp6
								temp7
								temp8
								temp5
								temp8
								temp8
								temp6
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
				(0
					(= temp25
						((Polygon new:)
							init:
								(client x:)
								(client y:)
								temp5
								temp6
								temp7
								temp6
								temp7
								temp8
								temp5
								temp8
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
				(1
					(= temp25
						((Polygon new:)
							init:
								(client x:)
								(client y:)
								temp7
								temp8
								temp5
								temp8
								temp5
								temp6
								temp7
								temp6
							type: PBarredAccess
							name: {isBlockedPoly}
							yourself:
						)
					)
				)
			)
			(if (not temp17)
				((temp9 obstacles:) add: temp25)
			else
				(= temp17 0)
			)
			(temp9 value: 2 init: client (temp9 finalX:) (temp9 finalY:))
			(= oldMoverX (temp9 finalX:))
			(= oldMoverY (temp9 finalY:))
			((temp9 obstacles:) delete: temp25)
			(temp25 dispose:)
		)
	)
)

