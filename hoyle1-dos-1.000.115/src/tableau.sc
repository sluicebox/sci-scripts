;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use room5)
(use Interface)

(public
	tableau 0
)

(class Tableau of WL
	(properties
		x 90
		y 94
		overlap 12
		count 0
		go 0
		points1 0
		points2 0
		points3 0
		playerWhoGaveGo 0
		lastCardPlayedBy 0
	)

	(method (init)
		(super add:)
	)

	(method (howMany param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(+= temp1 (== ((self at: temp0) cardRank:) param1))
		)
		(return temp1)
	)

	(method (numActiveCards &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (not ((self at: temp0) loop:))
				(return (- size temp0))
			)
		)
	)

	(method (giveAGo param1)
		(= playerWhoGaveGo param1)
		(if go
			(self dim:)
			(= playerWhoGaveGo (= count (= go 0)))
		else
			(= go 1)
			((proc5_2) movePeg: lastCardPlayedBy 1 0)
		)
	)

	(method (check1531 &tmp temp0)
		(cond
			((== count 15)
				(= points1 1000)
				(= temp0 2)
			)
			((== count 31)
				(if go
					(= points1 1002)
					(= temp0 1)
				else
					(= points1 1001)
					(= temp0 2)
				)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)

	(method (checkPairs &tmp temp0 temp1)
		(= points2 0)
		(= temp1 ((self at: (- size 1)) cardRank:))
		(for ((= temp0 (- size 2))) (>= temp0 0) ((-- temp0))
			(cond
				(((self at: temp0) loop:)
					(break)
				)
				((!= ((self at: temp0) cardRank:) temp1)
					(break)
				)
				(else
					(switch points2
						(0
							(= points2 1006)
						)
						(1006
							(= points2 1007)
						)
						(1007
							(= points2 1008)
						)
					)
				)
			)
		)
		(switch points2
			(0
				(return 0)
			)
			(1006
				(return 2)
			)
			(1007
				(return 6)
			)
			(1008
				(return 12)
			)
		)
	)

	(method (checkRuns &tmp temp0 temp1 temp2)
		(if (not points2)
			(if (>= (= temp1 (self numActiveCards:)) 3)
				(= temp0 3)
				(= temp2 0)
				(while (<= temp0 temp1)
					(if (self isARun: temp0)
						(= temp2 temp0)
					)
					(++ temp0)
				)
			)
			(switch temp2
				(0
					(= points2 0)
				)
				(3
					(= points2 1009)
				)
				(4
					(= points2 1010)
				)
				(5
					(= points2 1011)
				)
				(6
					(= points2 1012)
				)
				(7
					(= points2 1013)
				)
			)
			(return temp2)
		)
	)

	(method (checkLastCard)
		(if (and (== size 8) (!= count 31))
			(= points3 1005)
		)
		(return (if points3 1 else 0))
	)

	(method (isARun param1 &tmp temp0 temp1 temp2 temp3 temp4)
		((= temp2 (WL new:)) add:)
		((= temp3 (WL new:)) add:)
		(for ((= temp0 (- size 1))) (>= temp0 (- size param1)) ((-- temp0))
			(temp2 add: (self at: temp0))
		)
		(for ((= temp1 1)) (<= temp1 13) ((++ temp1))
			(for ((= temp0 0)) (< temp0 (temp2 size:)) ((++ temp0))
				(if (== ((temp2 at: temp0) cardRank:) temp1)
					(temp3 add: (temp2 at: temp0))
				)
			)
		)
		(= temp4 1)
		(for ((= temp0 0)) (< temp0 (- (temp3 size:) 1)) ((++ temp0))
			(if
				(!=
					(+ ((temp3 at: temp0) cardRank:) 1)
					((temp3 at: (+ temp0 1)) cardRank:)
				)
				(= temp4 0)
				(break)
			)
		)
		(temp2 empty: dispose:)
		(temp3 empty: dispose:)
		(return temp4)
	)

	(method (cue)
		(switch global432
			(1
				(self addTo: global173)
				((gPlayer0 cardList:) delete: global173)
				(gPlayer0 rePosition:)
				(proc0_5)
				(self scorePoints: gPlayer0)
			)
			(2
				(self addTo: global173)
				((gPlayer2 cardList:) delete: global173)
				(gPlayer2 rePosition:)
				(proc0_5)
				(self scorePoints: gPlayer2)
			)
		)
		(= global432 0)
		(if ((proc5_2) isNotPegging:)
			(gCardRoom cue:)
		)
	)

	(method (dim)
		(self eachElementDo: #loop 1 eachElementDo: #update)
		(proc0_5)
	)

	(method (nextX)
		(return (+ x (* size overlap)))
	)

	(method (nextY param1)
		(return
			(if (== param1 gPlayer0)
				(+ y 3)
			else
				(- y 43)
			)
		)
	)

	(method (adjustForCount &tmp temp0 temp1 temp2 temp3)
		(self
			eachElementDo: #erase 1
			eachElementDo: #loop 0
			eachElementDo: #update
		)
		(for ((= temp0 (= temp1 (= temp2 0)))) (< temp0 size) ((++ temp0))
			(= temp3 (self at: temp0))
			(if (> ((self at: temp0) y:) y)
				(temp3 x: (+ x 32 (* 7 temp2)) y: (gPlayer0 baseY:))
				((gPlayer0 cardList:) add: temp3)
				(++ temp2)
			else
				(temp3 x: (+ x 32 (* 7 temp1)) y: (gPlayer2 baseY:))
				((gPlayer2 cardList:) add: temp3)
				(++ temp1)
			)
		)
	)

	(method (adjustForCountPart2)
		(self eachElementDo: #erase 0 eachElementDo: #update empty:)
	)

	(method (addTo param1)
		(param1 loop: 0 faceUp: 1 erase: 0 update:)
		(self add: global173)
		((proc5_4) doit:)
		(proc0_5)
	)

	(method (add param1)
		(+=
			count
			(if (> (param1 cardRank:) 10)
				10
			else
				(param1 cardRank:)
			)
		)
		(super add: param1)
	)

	(method (delete param1)
		(-=
			count
			(if (> (param1 cardRank:) 10)
				10
			else
				(param1 cardRank:)
			)
		)
		(super delete: param1)
	)

	(method (testPoints param1 &tmp temp0)
		(self add: param1)
		(param1 points1: 0 points2: 0)
		(= points1 (= points2 (= points3 0)))
		(if
			(and
				(= temp0
					(+ (self check1531:) (self checkPairs:) (self checkRuns:))
				)
				(not points1)
				points2
			)
			(= points1 points2)
			(= points2 0)
		)
		(param1 points1: points1 points2: points2)
		(self delete: param1)
		(return temp0)
	)

	(method (scorePoints param1 &tmp temp0)
		(= points1 (= points2 (= points3 0)))
		(= lastCardPlayedBy param1)
		(if
			(= temp0
				(+
					(self check1531:)
					(self checkPairs:)
					(self checkRuns:)
					(self checkLastCard:)
				)
			)
			(if (and (not points1) points2)
				(= points1 points2)
				(= points2 0)
			)
			(if (and (not points1) (not points2))
				(= points1 points3)
				(= points3 0)
			)
			((proc5_4) doit:)
			(proc0_5)
			(switch param1
				(gPlayer0
					(proc5_9 points1 points2 points3)
					(= global305 (Print global199 #at 108 118 #dispose))
					(if
						(or
							(and
								(or
									(<= 1000 points1 1006)
									(<= 1000 points2 1006)
								)
								(== (Random 0 2) 0)
							)
							(<= 1007 points1 1013)
							(<= 1007 points2 1013)
						)
						(switch (Random 0 2)
							(0
								((gPlayer2 altrEgo:) anger: 1)
							)
							(else
								((gPlayer2 altrEgo:) upset: 1)
							)
						)
					)
				)
				(gPlayer2
					(if
						(or
							(and
								(or
									(<= 1000 points1 1006)
									(<= 1000 points2 1006)
								)
								(== (Random 0 2) 0)
							)
							(<= 1007 points1 1013)
							(<= 1007 points2 1013)
						)
						(switch (Random 0 2)
							(0
								((gPlayer2 altrEgo:) smirk:)
							)
							(else
								((gPlayer2 altrEgo:) smile:)
							)
						)
					)
					(proc0_5)
					((gPlayer2 altrEgo:) say: points1 points2 points3)
				)
			)
			((proc5_2) movePeg: param1 temp0)
		)
	)

	(method (endHand &tmp temp0)
		(self
			addAllToWorkingDeck:
			eachElementDo: #erase 1
			eachElementDo: #loop 0
			eachElementDo: #faceUp 0
			eachElementDo: #update
			count: 0
			empty:
		)
	)
)

(instance tableau of Tableau
	(properties)
)

