;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 209)
(include sci.sh)
(use Main)
(use room5)

(public
	tally 0
)

(local
	local0
	local1
)

(instance tally of GO
	(properties
		x 85
		y 48
		view 170
		state 4
	)

	(method (init param1 param2 param3)
		(if (>= argc 2)
			(= caller param2)
		)
		(= special (if (== argc 3) param3 else 0))
		(proc0_2 view 0 param1 85 48)
		(if param1
			(= state (= status0 0))
		)
		(proc0_5)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (< state 4)
			(switch state
				(0
					(= global100 1)
					(= status0 ((ScriptID 208) total:)) ; countCombos
					(= global100 2)
					(= global100 3)
					(= local0 1)
					(= local1
						(if (!= ((ScriptID 208) numScores:) 10) ; countCombos
							(/ (* (- 10 ((ScriptID 208) numScores:)) 8) 2) ; countCombos
						else
							0
						)
					)
					(= global100 4)
					(= state 1)
				)
				(1
					(= global100 5)
					(if (<= local0 ((ScriptID 208) numScores:)) ; countCombos
						(= global100 6)
						(= temp0
							(switch [global330 local0]
								(1016 0)
								(1008 1)
								(1007 2)
								(1006 3)
								(1000 4)
								(1009 5)
								(1010 6)
								(1011 7)
								(1014 8)
								(1015 9)
							)
						)
						(= global100 7)
						(proc0_2
							169
							0
							temp0
							(+ x 3)
							(+ local1 y 3 (* (- local0 1) 8))
						)
						(++ local0)
						(= state 2)
						(= global100 8)
						(proc0_5 1)
					else
						(= global100 9)
						(= state 3)
					)
				)
				(2
					(= global100 10)
					(if (> global433 1)
						(= temp2 (* (- local0 2) 5))
						(= global100 11)
						(for ((= temp1 0)) (< temp1 5) ((++ temp1))
							(if [global449 (+ temp2 temp1)]
								([global449 (+ temp2 temp1)] loop: 1)
							)
						)
						(= global100 12)
						(if special
							(= global100 13)
							((proc5_8) eachElementDo: #update)
							(= global100 14)
						else
							(= global100 15)
							((caller cardList:) eachElementDo: #update)
							(= global100 16)
						)
						(= global100 17)
						((gDeck upCardView:) update:)
						(= global100 18)
						(proc0_5 1)
						(= global100 19)
						(proc0_1
							(if (== global433 9)
								10000
							else
								(+ (* (- global433 1) 20) 1)
							)
						)
						(= global100 20)
						(for ((= temp1 0)) (< temp1 5) ((++ temp1))
							(if [global449 (+ temp2 temp1)]
								([global449 (+ temp2 temp1)] loop: 0)
							)
						)
						(= global100 21)
						(if special
							(= global100 22)
							(= global100 23)
							((proc5_8) eachElementDo: #update)
							(= global100 24)
						else
							(= global100 25)
							((caller cardList:) eachElementDo: #update)
							(= global100 26)
						)
						(= global100 27)
						((gDeck upCardView:) update:)
						(= global100 28)
						(proc0_5 1)
					)
					(= state 1)
				)
				(3
					(= status0 ((ScriptID 208) total:)) ; countCombos
					(cond
						((== status0 0)
							(if (== caller gPlayer2)
								((gPlayer2 altrEgo:) upset: 1)
							else
								((gPlayer2 altrEgo:) smile: 1)
							)
							(gIntroSong number: (Random 32 35) play:)
						)
						((or (> status0 14) (and special (> status0 11)))
							(if (== caller gPlayer2)
								((gPlayer2 altrEgo:) bigSmile: 1)
							else
								((gPlayer2 altrEgo:) shock: 1)
							)
							(gIntroSong
								number:
									(if (== caller gPlayer0)
										27
									else
										((caller altrEgo:) song:)
									)
								play:
							)
						)
						((> status0 9)
							(if (== caller gPlayer2)
								((gPlayer2 altrEgo:) smile: 1)
							else
								((gPlayer2 altrEgo:) upset: 1)
							)
						)
						((and (not special) (< status0 2))
							(if (== caller gPlayer2)
								((gPlayer2 altrEgo:) upset: 1)
							else
								((gPlayer2 altrEgo:) smile: 1)
							)
						)
					)
					(= global100 29)
					(= temp0
						(cond
							((== special 1) 2)
							((== caller gPlayer2) 1)
							(else 0)
						)
					)
					(= global100 30)
					(proc0_2 169 2 0 (+ x 3) (+ local1 y 3 (* (- local0 1) 8)))
					(= global100 31)
					(proc0_2
						169
						(if (!= (Graph grGET_COLOURS) 2) 1 else 3)
						temp0
						(+ x 3)
						(+ local1 y 5 (* (- local0 1) 8))
					)
					(= global100 32)
					(proc0_2
						168
						1
						(if (< status0 10)
							10
						else
							(/ status0 10)
						)
						(+ x 3)
						(+ local1 y 5 (* (- local0 1) 8))
					)
					(= global100 33)
					(proc0_2
						168
						1
						(mod status0 10)
						(+ x 10)
						(+ local1 y 5 (* (- local0 1) 8))
					)
					(= global100 34)
					((proc5_2) movePeg: caller ((ScriptID 208) total:)) ; countCombos
					(= global100 35)
					(= state 4)
				)
			)
		)
	)
)

