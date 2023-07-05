;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use room3)

(public
	proc16_0 0
)

(procedure (proc16_0 param1 &tmp temp0 temp1)
	(= global859 param1)
	(= [global877 0] ((global859 spadesList:) size:))
	(= [global877 1] ((global859 clubsList:) size:))
	(= [global877 2] ((global859 diamondsList:) size:))
	(= [global877 3] ((global859 heartsList:) size:))
	(= global100 100)
	(= global860 [global877 global170])
	(= global862 (= global863 0))
	(for ((= temp0 0)) (< temp0 ((global859 cardList:) size:)) ((++ temp0))
		(if (== (= temp1 (((global859 cardList:) at: temp0) cardRank:)) 1)
			(= temp1 14)
		)
		(if (== (((global859 cardList:) at: temp0) cardSuit:) global170)
			(if (> temp1 global862)
				(= global862 temp1)
			)
			(if (> temp1 global171)
				(++ global863)
			)
		)
	)
	(= global875 (- (= global860 [global877 global170]) global863))
	(= global100 101)
	(= global876
		(if [global877 global170]
			(localproc_19 global170)
		else
			0
		)
	)
	(= global858 (localproc_20))
	(= global100 102)
	(= global865 (localproc_3))
	(= global100 103)
	(= global864 (localproc_0))
	(= global867 (localproc_4))
	(= global100 106)
	(= global856 (localproc_8))
	(= global857 (localproc_9))
	(= global868 (localproc_6 global170))
	(= global100 107)
	(global859 heartDanger: (localproc_10 3))
	(= global100 108)
	(global859 spadeDanger: (localproc_11))
	(= global100 109)
	(= global869 (localproc_12))
	(= global100 110)
	(= global870 (localproc_13))
	(= global100 111)
	(= global871 (localproc_14))
	(= global100 112)
	(= global872 (localproc_15))
	(= global100 113)
	(= global873 (localproc_17))
	(= global100 114)
	(= global874 (localproc_18))
	(= global100 115)
	(localproc_21)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(if (!= (global859 takeAllPlayer:) global859)
		(= global326 (= temp2 -1))
		(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
			(if (and (= temp1 (localproc_1 temp0)) (> temp1 global326))
				(if
					(and
						(== temp0 3)
						global858
						(!= global269 global859)
						(<
							(global859
								howManyHigher:
									3
									(((global859 heartsList:)
											at:
												(-
													((global859 heartsList:)
														size:
													)
													1
												)
										)
										cardRank:
									)
							)
							5
						)
					)
					(break)
				else
					(= global326 temp1)
					(= temp2 temp0)
				)
			)
		)
		(if (== temp2 -1)
			(= temp2 global865)
		)
	else
		(= temp2 3)
		(= temp3 99)
		(if [global877 0]
			(= temp3 (global859 spadesStrength:))
			(= temp2 0)
		)
		(if (and [global877 1] (< (global859 clubsStrength:) temp3))
			(= temp3 (global859 clubsStrength:))
			(= temp2 1)
		)
		(if (and [global877 2] (< (global859 diamondsStrength:) temp3))
			(= temp3 (global859 diamondsStrength:))
			(= temp2 2)
		)
	)
	(return temp2)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(global859 getSuitList: param1)
	(if
		(or
			(not global306)
			(and (== param1 0) (global859 spadeDanger:))
			(and (== param1 3) (global859 heartDanger:))
			(- (localproc_2 param1) (localproc_7 param1))
		)
		(return 0)
	)
	(return (= temp0 (localproc_5 param1)))
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global448)
		(if (global859 playerOutOf: param1 temp1)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp1 (localproc_10 0))
	(= temp2 0)
	(if global306
		(= temp3 ((global310 at: global307) cardRank:))
	)
	(if (== temp3 1)
		(= temp3 14)
	)
	(for ((= temp0 1)) (< temp0 4) ((++ temp0))
		(= global264 (localproc_10 temp0))
		(if global306
			(if (== (= temp4 ((global310 at: global307) cardRank:)) 1)
				(= temp4 14)
			)
			(cond
				((> global264 temp1)
					(= temp1 global264)
					(= temp2 temp0)
					(= temp3 temp4)
				)
				(
					(and
						(== global264 temp1)
						(>= temp4 ((global310 at: global307) cardRank:))
					)
					(= temp1 global264)
					(= temp2 temp0)
					(= temp3 temp4)
				)
			)
		)
	)
	(return temp2)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(if (global859 takeAllPlayer:)
		(= temp0 (not ((global859 takeAllPlayer:) outOf: global170)))
		(= temp1 (gDeck anyHigherRemaining: global170 global171))
		(return (or temp0 temp1))
	)
	(return 0)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(= temp1 0)
	(if
		(and
			(!= (= temp0 (- global448 (localproc_7 param1))) 1)
			(<=
				[global877 param1]
				(/
					(+
						(gDeck remaining: param1)
						(if (== param1 global170) [global441 param1] else 0)
					)
					temp0
				)
			)
		)
		(= temp1
			(-
				(+
					(gDeck remaining: param1)
					(if (== param1 global170) [global441 param1] else 0)
				)
				(* [global877 param1] temp0)
			)
		)
	)
	(return temp1)
)

(procedure (localproc_6 param1 &tmp [temp0 2])
	(if
		(or
			global870
			(and
				(>=
					(- (gDeck remaining: param1) [global877 param1])
					(+ (- (- global448 global856) global276) 1)
				)
				global857
			)
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_7 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global448)
		(if
			(and
				(global859 playerOutOf: param1 temp1)
				(global270 outOf: 3)
				(or (global859 queenSpades:) global265 (global270 outOf: 0))
			)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

(procedure (localproc_8 &tmp temp0 temp1 temp2 temp3)
	(= temp0 0)
	(= temp2 (- global448 global276))
	(for
		((= temp1 (+ (gCardRoom currentPlayer:) 1)))
		(<= temp1 (+ (gCardRoom currentPlayer:) temp2))
		((++ temp1))
		
		(= temp3
			(if (>= temp1 global448)
				(- temp1 global448)
			else
				temp1
			)
		)
		(if
			(and
				(not ((gPlayerList at: temp3) sittingOut:))
				((gPlayerList at: temp3) outOf: global170)
				((gPlayerList at: temp3) outOf: 3)
				(or
					(global859 queenSpades:)
					global265
					((gPlayerList at: temp3) outOf: 0)
				)
			)
			(++ temp0)
		)
	)
	(return temp0)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3)
	(= temp2 (- global448 global276))
	(for
		((= temp1 (+ (gCardRoom currentPlayer:) 1)))
		(<= temp1 (+ (gCardRoom currentPlayer:) temp2))
		((++ temp1))
		
		(= temp3
			(if (>= temp1 global448)
				(- temp1 global448)
			else
				temp1
			)
		)
		(if
			(and
				(not ((gPlayerList at: temp3) sittingOut:))
				((gPlayerList at: temp3) outOf: global170)
				(or
					(not ((gPlayerList at: temp3) outOf: 3))
					(and
						(not (global859 queenSpades:))
						(not global265)
						(not ((gPlayerList at: temp3) outOf: 0))
					)
				)
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_10 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(global859 getSuitList: param1)
	(= global168 0)
	(if global306
		(for ((= temp0 0)) (< temp0 global306) ((++ temp0))
			(if (== (= temp1 (global310 atRank: temp0)) 1)
				(= temp1 14)
			)
			(= temp2 (- (- global448 1) (localproc_7 param1)))
			(= temp3 (global859 howManyLower: param1 temp1))
			(switch temp0
				(0
					(if (>= temp3 temp2)
						(= global168 (+ (- temp3 temp2) 1))
					)
				)
				(1
					(if (>= (= temp4 (- (- temp3 1) (* 2 temp2))) 0)
						(+= global168 (+ temp4 1))
					)
				)
				(2
					(if (>= (= temp4 (- (- temp3 1) (* 3 temp2))) 0)
						(+= global168 (+ temp4 1))
					)
				)
				(3
					(if (>= (= temp4 (- (- temp3 1) (* 4 temp2))) 0)
						(+= global168 (+ temp4 1))
					)
				)
			)
		)
		(if (== global168 1)
			(= global168 0)
		)
	)
	(return global168)
)

(procedure (localproc_11 &tmp temp0 temp1)
	(if
		(or
			global265
			(and
				(not (global859 queenSpades:))
				(not (global859 kingSpades:))
				(not (global859 aceSpades:))
			)
		)
		(return 0)
	)
	(= global165 1)
	(for ((= global264 0)) (< global264 global448) ((++ global264))
		(proc3_1 global264)
		(if (and (!= global270 global859) global270 (not (global270 outOf: 0)))
			(++ global165)
		)
	)
	(= temp1 (- (gDeck remaining: 0) [global877 0]))
	(if (> (- global165 1) temp1)
		(= global165 (+ temp1 1))
	)
	(= temp0 0)
	(if (global859 queenSpades:)
		(= temp0 (+ (global859 kingSpades:) (global859 aceSpades:)))
	)
	(if
		(>
			(+ (global859 lowSpades:) temp0)
			(/ (gDeck remaining: 0) global165)
		)
		(return 0)
	else
		(return 1)
	)
)

(procedure (localproc_12 &tmp temp0 temp1 temp2)
	(= global145 -1)
	(= temp1 [global877 0])
	(= temp2 0)
	(for ((= temp0 1)) (<= temp0 3) ((++ temp0))
		(if (> [global877 temp0] temp1)
			(= global145 temp2)
			(= temp2 temp0)
			(= temp1 [global877 temp0])
		)
	)
	(if (not global145)
		(= global145 -1)
	)
	(return temp2)
)

(procedure (localproc_13)
	(return (== (- global448 global276) 1))
)

(procedure (localproc_14 &tmp temp0 temp1 temp2)
	(if (not (- (gDeck remaining: global170) [global877 global170]))
		(return 0)
	)
	(= temp1 (- (- global448 global276) 1))
	(for
		((= temp0 (+ (gCardRoom currentPlayer:) 1)))
		(<= temp0 (+ (gCardRoom currentPlayer:) temp1))
		((++ temp0))
		
		(= temp2
			(if (>= temp0 global448)
				(- temp0 global448)
			else
				temp0
			)
		)
		(if (not ((gPlayerList at: temp2) outOf: global170))
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_15)
	(if
		(or
			[global877 2]
			[global877 1]
			(>= [global877 0] 2)
			(and (== [global877 0] 1) (not (global859 queenSpades:)))
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_16 param1 &tmp temp0 temp1 temp2)
	(= temp1 (- (- global448 global276) 1))
	(for ((= temp0 (+ 486 1))) (<= temp0 (+ 486 temp1)) ((++ temp0))
		(= temp2
			(if (>= temp0 global448)
				(- temp0 global448)
			else
				temp0
			)
		)
		(if (== param1 (gPlayerList at: temp2))
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_17 &tmp [temp0 3])
	(localproc_16 (global859 takeAllPlayer:))
)

(procedure (localproc_18)
	(global859 getSuitList: global170)
	(return
		(if global306
			(global859
				howManyHigher: global170 ((global310 at: global307) cardRank:)
			)
		else
			0
		)
	)
)

(procedure (localproc_19 param1 &tmp temp0 temp1)
	(global859 getSuitList: param1)
	(= temp0 (global859 howManyLower: param1 ((global310 at: 0) cardRank:)))
	(= temp1 (- (- (- global448 1) global276) (localproc_8)))
	(return (> temp0 temp1))
)

(procedure (localproc_20 &tmp temp0 temp1)
	(= temp0 0)
	(if (gPlayer0 handPoints:)
		(= temp1 gPlayer0)
		(++ temp0)
	)
	(if (gPlayer1 handPoints:)
		(= temp1 gPlayer1)
		(++ temp0)
	)
	(if (gPlayer2 handPoints:)
		(= temp1 gPlayer2)
		(++ temp0)
	)
	(if (gPlayer3 handPoints:)
		(= temp1 gPlayer3)
		(++ temp0)
	)
	(= global269 0)
	(if (== temp0 1)
		(= global269 temp1)
	)
	(if (or (not temp0) (and (== temp0 1) (not global169)))
		(return 1)
	)
	(if (and (== temp0 1) global169)
		(cond
			((localproc_16 temp1)
				(if (== global172 (temp1 playerNum:))
					(return 1)
				)
			)
			(
				(or
					(temp1 outOf: global170)
					(not (gDeck anyHigherRemaining: global170 global171))
				)
				(return 1)
			)
		)
	)
	(return 0)
)

(procedure (localproc_21)
	(if
		(and
			global858
			(== global172 global866)
			(or
				(and
					(== global170 3)
					(> (global859 howManyLower: 3 global171) (+ global448 2))
				)
				(and (== global170 0) (not global265) (>= global171 12))
			)
		)
		(global859 takeAllPlayer: (proc3_1 global866) obvious: 1)
		(switch (global859 skill:)
			(0
				(global859 takeAllPlayer: 0)
			)
			(1
				(if (== (global859 takeAllPlayer:) global859)
					(global859 takeAllPlayer: 0)
				)
			)
		)
	)
)

