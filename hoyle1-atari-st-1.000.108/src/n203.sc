;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use room5)

(public
	proc203_0 0
)

(procedure (proc203_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15)
	(gGame setCursor: 997)
	(proc0_5)
	((ScriptID 208) setStyle: 0) ; countCombos
	(proc5_1 (param1 cardList:))
	(param1 bestCribCard1: 0)
	(param1 bestCribCard2: 0)
	(= temp8 0)
	(= temp7 -10)
	(= temp10 -100)
	((= temp6 (WL new:)) add:)
	(param1 setRanks: (param1 cardList:))
	(= temp15 (= temp4 0))
	(while (< temp4 5)
		(for ((= temp5 (+ temp4 1))) (< temp5 6) ((++ temp5))
			(= temp1 (gWL at: temp4))
			(= temp2 (gWL at: temp5))
			((param1 tempList:) empty:)
			(for ((= temp3 0)) (< temp3 6) ((++ temp3))
				(if
					(and
						(!= (= temp9 (gWL at: temp3)) temp1)
						(!= temp9 temp2)
					)
					((param1 tempList:) add: temp9)
				)
			)
			(param1 setRanks: (param1 tempList:))
			(= temp8 (param1 cribCardPoints: temp1 temp2))
			(if
				(>
					(= [global350 temp15]
						(+ ((ScriptID 208) doit: (param1 tempList:)) temp8) ; countCombos
					)
					temp7
				)
				(= temp7 [global350 temp15])
			)
			(++ temp15)
		)
		(++ temp4)
	)
	((ScriptID 208) setStyle: 1) ; countCombos
	(= temp15 (= temp4 0))
	(while (< temp4 5)
		(for ((= temp5 (+ temp4 1))) (< temp5 6) ((++ temp5))
			(if (> [global350 temp15] (- temp7 2))
				(= temp1 (gWL at: temp4))
				(= temp2 (gWL at: temp5))
				((param1 tempList:) empty:)
				(temp6 empty: add: temp1 temp2)
				(for ((= temp3 0)) (< temp3 6) ((++ temp3))
					(if
						(and
							(!= (gWL at: temp3) temp1)
							(!= (gWL at: temp3) temp2)
						)
						((param1 tempList:) add: (gWL at: temp3))
					)
				)
				(= temp8 (param1 cribCardPoints: temp1 temp2))
				(= temp13 [global350 temp15])
				(= temp0 1)
				(= temp12 0)
				(while (< temp0 14)
					((ScriptID 208) doit: (param1 tempList:) temp0) ; countCombos
					(if (== temp0 1)
						(if (> (+ temp13 temp8) temp7)
							(= temp7 (+ temp13 temp8))
						)
						(if (< (+ temp13 temp8) (- temp7 1))
							(break)
						)
					)
					(if (!= global775 0)
						(+=
							temp12
							(*
								((ScriptID 208) starterPoints:) ; countCombos
								(- 4 [global390 temp0])
							)
						)
						(= temp11
							(*
								(-
									((ScriptID 208) doit: temp6 temp0) ; countCombos
									(Abs temp8)
								)
								(- 4 [global390 temp0])
							)
						)
						(+=
							temp12
							(if (== (gPlayerList at: 0) self)
								temp11
							else
								(- temp11)
							)
						)
					)
					(++ temp0)
				)
				(if (== global775 2)
					(= temp12
						(+
							(= temp12
								(+
									(= temp12
										(+
											(+=
												temp12
												(if
													(or
														(==
															(temp1 cardRank:)
															11
														)
														(==
															(temp2 cardRank:)
															11
														)
													)
													(if
														(==
															(gPlayerList at: 0)
															param1
														)
														11
													else
														-11
													)
												)
											)
											(* [global390 11] 11)
										)
									)
									(if (== (temp1 cardSuit:) (temp2 cardSuit:))
										(if (== (gPlayerList at: 0) param1)
											2
										else
											-2
										)
									)
								)
							)
							(* [global390 1] 15)
							(* [global390 2] 5)
							[global390 3]
						)
					)
				)
				(if (> (= temp11 (+ (* 52 temp13) temp12)) temp10)
					(= temp10 temp11)
					(param1 bestCribCard1: temp1)
					(param1 bestCribCard2: temp2)
				)
			)
			(++ temp15)
		)
		(++ temp4)
	)
	((ScriptID 208) setStyle: 0) ; countCombos
	((param1 tempList:) empty:)
	(temp6 empty: dispose:)
	(gWL empty: dispose:)
	(gGame setCursor: 999)
)

