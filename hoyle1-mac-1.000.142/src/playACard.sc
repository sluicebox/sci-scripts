;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 207)
(include sci.sh)
(use Main)
(use room5)
(use Interface)

(public
	playACard 0
)

(instance playACard of GO
	(properties
		x 193
		y 143
		view 167
		cursorX 221
		cursorY 173
	)

	(method (init param1)
		(if (!= status0 param1)
			(= status0 param1)
			(proc0_2 view 2 status0 x y)
			(if param1
				(global517 add: self)
			else
				(global517 delete: self)
			)
		)
	)

	(method (doit param1 &tmp temp0)
		(if (global300 windowUp:)
			(return)
		)
		(if
			(and
				(or
					(not argc)
					(and
						status0
						(not global184)
						global180
						((gPlayer0 cardList:) size:)
						(not ((proc5_3) mover:))
					)
				)
				(or
					(not argc)
					(== global855 2)
					(== global854 13)
					(== global854 20992)
				)
			)
			(if argc
				(= global321 param1)
			)
			(if (or (not argc) (proc5_7 x (+ x 35) y (+ y 43)))
				(if argc
					(param1 claimed: 1)
				)
				(if (== status0 4)
					(if (gPlayer0 howManyCardsDim:)
						((gPlayer0 findADimCard:) loop: 0)
						(gPlayer0 pickedUpCard: 10)
						((gPlayer0 cardList:) eachElementDo: #update)
						(proc0_5)
					)
					(if (not (global390 go:))
						(proc5_9 1003 0 0)
						(= global305 (Print global199 #at 113 118 #dispose))
						(if (< (= global772 (* global407 25)) 60)
							(= global772 60)
						)
						(proc0_1 global772)
					else
						(= global179 0)
					)
					(global390 giveAGo: gPlayer0)
					(if (and (not (global390 go:)) argc)
						(gCardRoom cue:)
					)
				else
					(if (== ((gPlayer0 cardList:) size:) 1)
						(((gPlayer0 cardList:) at: 0) loop: 1)
					)
					(if (gPlayer0 howManyCardsDim:)
						(if
							(>
								(= temp0 ((gPlayer0 findADimCard:) cardRank:))
								10
							)
							(= temp0 10)
						)
						(if (<= (+ (global390 count:) temp0) 31)
							(gPlayer0 playCard:)
						else
							((gPlayer0 findADimCard:) loop: 0)
							(gPlayer0 pickedUpCard: 10)
							((gPlayer0 cardList:) eachElementDo: #update)
							(proc0_5)
							(gSndEffect number: 36 play:)
							((gPlayer2 altrEgo:) say: 7)
							(= global179 1)
							(if argc
								(gCardRoom cue:)
							)
						)
					else
						(gSndEffect number: 36 play:)
						((gPlayer2 altrEgo:) say: 8)
						(= global179 1)
						(if argc
							(gCardRoom cue:)
						)
					)
				)
			)
		)
	)
)

