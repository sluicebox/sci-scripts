;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 711)
(include sci.sh)
(use Main)
(use n724)
(use SortArray)
(use System)

(public
	BridgeStrategyPlayTrump 0
)

(local
	[local0 13]
	[local13 13]
	[local26 13]
)

(class BridgeStrategyPlayTrump of Code
	(properties
		LHOChance 0
		combinedHCP 0
		missingHCP 0
		LHOPoints 0
		RHOPoints 0
		topCl 0
		topDi 0
		topHt 0
		topSp 0
		LHO 0
		RHO 0
		mustLose 0
		finChance 0
		finCard 0
		finTricks 0
		noFinLoserChance 0
		noFinLoserTricks 0
		forceLosers 0
		clLosers 0
		diLosers 0
		htLosers 0
		spLosers 0
		plan 0
	)

	(method (init)
		(cond
			((== global429 (global117 atLocation: 3))
				(self LHO: (global117 atLocation: 2))
				(self RHO: (global117 atLocation: 4))
			)
			((== global429 (global117 atLocation: 2))
				(self LHO: (global117 atLocation: 1))
				(self RHO: (global117 atLocation: 3))
			)
			((== global429 (global117 atLocation: 1))
				(self LHO: (global117 atLocation: 4))
				(self RHO: (global117 atLocation: 2))
			)
			(else
				(self LHO: (global117 atLocation: 3))
				(self RHO: (global117 atLocation: 1))
			)
		)
		(= [local0 0] 100)
		(= [local0 1] 100)
		(= [local0 2] 52)
		(= [local0 3] 78)
		(= [local0 4] 41)
		(= [local0 5] 68)
		(= [local0 6] 36)
		(= [local0 7] 62)
		(= [local0 8] 33)
		(= [local0 9] 59)
		(= [local0 10] 31)
		(= [local0 11] 57)
		(= [local0 12] 30)
		(= [local13 0] 100)
		(= [local13 1] 100)
		(= [local13 2] 100)
		(= [local13 3] 100)
		(= [local13 4] 90)
		(= [local13 5] 96)
		(= [local13 6] 84)
		(= [local13 7] 93)
		(= [local13 8] 80)
		(= [local13 9] 90)
		(= [local13 10] 77)
		(= [local13 11] 89)
		(= [local13 12] 76)
		(= [local26 0] 100)
		(= [local26 1] 100)
		(= [local26 2] 100)
		(= [local26 3] 100)
		(= [local26 4] 100)
		(= [local26 5] 100)
		(= [local26 6] 99)
		(= [local26 7] 99)
		(= [local26 8] 97)
		(= [local26 9] 99)
		(= [local26 10] 96)
		(= [local26 11] 98)
		(= [local26 12] 95)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (think &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 [temp74 4])
		(= temp69 (gTrick trump:))
		(= temp9 (gTrick tricksPlayed:))
		(= temp56 (gTrick leader:))
		(= temp57 (gTrick size:))
		(= temp58 (gTrick suitLead:))
		(= temp10 (- global433 (+ global434 6)))
		(= temp11 (- (- global433 temp9) (- global434 7)))
		(= temp52 (self plan:))
		(= temp59 (global429 clubs:))
		(= temp60 (global429 diamonds:))
		(= temp61 (global429 hearts:))
		(= temp62 (global429 spades:))
		(= temp63 (global431 clubs:))
		(= temp64 (global431 diamonds:))
		(= temp65 (global431 hearts:))
		(= temp66 (global431 spades:))
		(cond
			((== temp56 global429)
				(= temp54 1)
			)
			((== temp56 global431)
				(= temp55 1)
			)
		)
		(= temp2 temp59)
		(= temp3 temp63)
		(= temp5 (self checkLongTricks: 1))
		(= temp20 (self LHOChance:))
		(= temp12 (self forceWinners: 1))
		(= temp16 (self forceLosers:))
		(= clLosers (self topLosers: 1))
		(= temp2 temp60)
		(= temp3 temp64)
		(= temp6 (self checkLongTricks: 2))
		(= temp21 (self LHOChance:))
		(= temp13 (self forceWinners: 2))
		(= temp17 (self forceLosers:))
		(= diLosers (self topLosers: 2))
		(= temp2 temp61)
		(= temp3 temp65)
		(= temp7 (self checkLongTricks: 3))
		(= temp22 (self LHOChance:))
		(= temp14 (self forceWinners: 3))
		(= temp18 (self forceLosers:))
		(= htLosers (self topLosers: 3))
		(= temp2 temp62)
		(= temp3 temp66)
		(= temp8 (self checkLongTricks: 4))
		(= temp23 (self LHOChance:))
		(= temp15 (self forceWinners: 4))
		(= temp19 (self forceLosers:))
		(= spLosers (self topLosers: 4))
		(if (and (!= temp69 5) (or (LHO hasCard: temp69) (RHO hasCard: temp69)))
			(switch temp69
				(4
					(= temp72 temp15)
					(= temp73 temp8)
					(= temp2 temp62)
					(= temp3 temp66)
				)
				(3
					(= temp72 temp14)
					(= temp73 temp7)
					(= temp2 temp61)
					(= temp3 temp65)
				)
				(2
					(= temp72 temp13)
					(= temp73 temp6)
					(= temp2 temp60)
					(= temp3 temp64)
				)
				(1
					(= temp72 temp12)
					(= temp73 temp5)
					(= temp2 temp59)
					(= temp3 temp63)
				)
			)
			(proc724_0 temp69)
			(if (= temp0 (proc724_2 self temp2 temp3 temp69 LHO RHO))
				(= temp70 (self temp0:))
				(= temp71 (self finCard:))
			)
			(cond
				(temp72
					(self topCard: temp69)
					(return)
				)
				(temp73
					(self topCard: temp69)
					(return)
				)
				(temp70
					(if temp71
						(return)
					)
				)
				(else
					(self bottomCard: temp69)
					(return)
				)
			)
		)
		(if temp52
			(switch temp52
				(2
					(if temp12
						(if
							(= temp67
								(self
									whichReturn:
										1
										temp54
										temp55
										temp59
										temp63
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
				(3
					(if temp13
						(if
							(= temp67
								(self
									whichReturn:
										2
										temp54
										temp55
										temp60
										temp64
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
				(4
					(if temp14
						(if
							(= temp67
								(self
									whichReturn:
										3
										temp54
										temp55
										temp61
										temp65
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
				(5
					(if temp15
						(if
							(= temp67
								(self
									whichReturn:
										4
										temp54
										temp55
										temp62
										temp66
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
				(6
					(if (and temp5 temp20)
						(if
							(= temp67
								(self
									whichReturn:
										1
										temp54
										temp55
										temp59
										temp63
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
				(7
					(if (and temp6 temp21)
						(if
							(= temp67
								(self
									whichReturn:
										2
										temp54
										temp55
										temp60
										temp64
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
				(8
					(if (and temp7 temp22)
						(if
							(= temp67
								(self
									whichReturn:
										3
										temp54
										temp55
										temp61
										temp65
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
				(9
					(if (and temp8 temp23)
						(if
							(= temp67
								(self
									whichReturn:
										4
										temp54
										temp55
										temp62
										temp66
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					else
						(= temp52 0)
						(self plan: 0)
					)
				)
			)
		)
		(= temp4 0)
		(if (== temp23 100)
			(+= temp4 temp8)
		else
			(+= temp4 topSp)
		)
		(if (== temp22 100)
			(+= temp4 temp7)
		else
			(+= temp4 topHt)
		)
		(if (== temp21 100)
			(+= temp4 temp6)
		else
			(+= temp4 topDi)
		)
		(if (== temp20 100)
			(+= temp4 temp5)
		else
			(+= temp4 topCl)
		)
		(if (>= (+ global433 temp4) temp10)
			(switch (= temp1 (Max topCl topDi topHt topSp))
				(topCl
					(if
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
				(topDi
					(if
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
				(topHt
					(if
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
				(topSp
					(if
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(cond
				((== temp1 topCl)
					(= temp1 (Max topDi topHt topSp))
				)
				((== temp1 topDi)
					(= temp1 (Max topCl topHt topSp))
				)
				((== temp1 topHt)
					(= temp1 (Max topCl topDi topSp))
				)
				((== temp1 topSp)
					(= temp1 (Max topCl topDi topHt))
				)
			)
			(switch temp1
				(topCl
					(if
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
				(topDi
					(if
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
				(topHt
					(if
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
				(topSp
					(if
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(if (== temp56 global429)
				(if temp59
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global162 temp1] 2)
							(self bottomCard: 1)
							(return)
						)
					)
				)
				(if temp60
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global149 temp1] 2)
							(self bottomCard: 2)
							(return)
						)
					)
				)
				(if temp61
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global136 temp1] 2)
							(self bottomCard: 3)
							(return)
						)
					)
				)
				(if temp62
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global123 temp1] 2)
							(self bottomCard: 4)
							(return)
						)
					)
				)
			)
			(if (== temp56 global431)
				(if temp63
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global162 temp1] 1)
							(self bottomCard: 1)
							(return)
						)
					)
				)
				(if temp64
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global149 temp1] 1)
							(self bottomCard: 2)
							(return)
						)
					)
				)
				(if temp65
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global136 temp1] 1)
							(self bottomCard: 3)
							(return)
						)
					)
				)
				(if temp66
					(for ((= temp1 0)) (< temp1 topCl) ((++ temp1))
						(if (== [global123 temp1] 1)
							(self bottomCard: 4)
							(return)
						)
					)
				)
			)
		)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(switch temp1
				(1
					(= temp2 temp59)
					(= temp3 temp63)
				)
				(2
					(= temp2 temp60)
					(= temp3 temp64)
				)
				(3
					(= temp2 temp61)
					(= temp3 temp65)
				)
				(4
					(= temp2 temp62)
					(= temp3 temp66)
				)
			)
			(proc724_0 temp1)
			(= temp0 (proc724_2 self temp2 temp3 temp1 LHO RHO))
			(switch temp1
				(1
					(if temp0
						(= temp28 (self temp0:))
						(= temp39 (self mustLose:))
						(= temp24 (self finChance:))
						(= temp43 (self finCard:))
						(if noFinLoserChance
							(= temp47 (self noFinLoserChance:))
							(= temp51 (self noFinLoserTricks:))
						)
					)
				)
				(2
					(if temp0
						(= temp29 (self temp0:))
						(= temp38 (self mustLose:))
						(= temp25 (self finChance:))
						(= temp42 (self finCard:))
						(if noFinLoserChance
							(= temp46 (self noFinLoserChance:))
							(= temp50 (self noFinLoserTricks:))
						)
					)
				)
				(3
					(if temp0
						(= temp30 (self temp0:))
						(= temp37 (self mustLose:))
						(= temp26 (self finChance:))
						(= temp41 (self finCard:))
						(if noFinLoserChance
							(= temp45 (self noFinLoserChance:))
							(= temp49 (self noFinLoserTricks:))
						)
					)
				)
				(4
					(if temp0
						(= temp31 (self temp0:))
						(= temp36 (self mustLose:))
						(= temp27 (self finChance:))
						(= temp40 (self finCard:))
						(if noFinLoserChance
							(= temp44 (self noFinLoserChance:))
							(= temp48 (self noFinLoserTricks:))
						)
					)
				)
			)
		)
		(if temp52
			(switch temp52
				(10
					(cond
						((or (== temp28 12) (== temp28 13) (== temp28 14))
							(cond
								((!= temp56 global429)
									(if (= temp67 (self bottomCard: 1 2))
										(return)
									)
								)
								((= temp67 (self bottomCard: 1 1))
									(return)
								)
							)
						)
						(
							(or
								(== temp28 1)
								(== temp28 2)
								(== temp28 3)
								(== temp28 4)
								(== temp28 5)
								(== temp28 6)
								(== temp28 7)
								(== temp28 8)
								(== temp28 9)
								(== temp28 10)
							)
							(if (!= temp56 global429)
								(cond
									(temp43
										(return)
									)
									((= temp67 (self bottomCard: 1 2))
										(return)
									)
								)
							else
								(= temp52 18)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
				(11
					(cond
						((or (== temp29 12) (== temp29 13) (== temp29 14))
							(cond
								((!= temp56 global429)
									(if (= temp67 (self bottomCard: 2 2))
										(return)
									)
								)
								((= temp67 (self bottomCard: 2 1))
									(return)
								)
							)
						)
						(
							(or
								(== temp29 1)
								(== temp29 2)
								(== temp29 3)
								(== temp29 4)
								(== temp29 5)
								(== temp29 6)
								(== temp29 7)
								(== temp29 8)
								(== temp29 9)
								(== temp29 10)
							)
							(if (!= temp56 global429)
								(cond
									(temp42
										(return)
									)
									((= temp67 (self bottomCard: 2 2))
										(return)
									)
								)
							else
								(= temp52 19)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
				(12
					(cond
						((or (== temp30 12) (== temp30 13) (== temp30 14))
							(cond
								((!= temp56 global429)
									(if (= temp67 (self bottomCard: 3 2))
										(return)
									)
								)
								((= temp67 (self bottomCard: 3 1))
									(return)
								)
							)
						)
						(
							(or
								(== temp30 1)
								(== temp30 2)
								(== temp30 3)
								(== temp30 4)
								(== temp30 5)
								(== temp30 6)
								(== temp30 7)
								(== temp30 8)
								(== temp30 9)
								(== temp30 10)
							)
							(if (!= temp56 global429)
								(cond
									(temp41
										(return)
									)
									((= temp67 (self bottomCard: 3 2))
										(return)
									)
								)
							else
								(= temp52 20)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
				(13
					(cond
						((or (== temp31 12) (== temp31 13) (== temp31 14))
							(cond
								((!= temp56 global429)
									(if (= temp67 (self bottomCard: 4 2))
										(return)
									)
								)
								((= temp67 (self bottomCard: 4 1))
									(return)
								)
							)
						)
						(
							(or
								(== temp31 1)
								(== temp31 2)
								(== temp31 3)
								(== temp31 4)
								(== temp31 5)
								(== temp31 6)
								(== temp31 7)
								(== temp31 8)
								(== temp31 9)
								(== temp31 10)
							)
							(if (!= temp56 global429)
								(cond
									(temp40
										(return)
									)
									((= temp67 (self bottomCard: 4 2))
										(return)
									)
								)
							else
								(= temp52 21)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
				(14
					(cond
						((or (== temp28 12) (== temp28 13) (== temp28 14))
							(cond
								((!= temp56 global431)
									(if (= temp67 (self bottomCard: 1))
										(return)
									)
								)
								((= temp67 (self bottomCard: 1 2))
									(return)
								)
							)
						)
						(
							(or
								(== temp28 16)
								(== temp28 17)
								(== temp28 18)
								(== temp28 19)
								(== temp28 20)
								(== temp28 21)
								(== temp28 22)
								(== temp28 23)
								(== temp28 24)
								(== temp28 25)
							)
							(if (!= temp56 global431)
								(cond
									(temp43
										(return)
									)
									((= temp67 (self bottomCard: 1 1))
										(return)
									)
								)
							else
								(= temp52 18)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
				(15
					(cond
						((or (== temp29 12) (== temp29 13) (== temp29 14))
							(cond
								((!= temp56 global431)
									(if (= temp67 (self bottomCard: 2 1))
										(return)
									)
								)
								((= temp67 (self bottomCard: 2 2))
									(return)
								)
							)
						)
						(
							(or
								(== temp29 16)
								(== temp29 17)
								(== temp29 18)
								(== temp29 19)
								(== temp29 20)
								(== temp29 21)
								(== temp29 22)
								(== temp29 23)
								(== temp29 24)
								(== temp29 25)
							)
							(if (!= temp56 global431)
								(cond
									(temp42
										(return)
									)
									((= temp67 (self bottomCard: 2 1))
										(return)
									)
								)
							else
								(= temp52 19)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
				(16
					(cond
						((or (== temp30 12) (== temp30 13) (== temp30 14))
							(cond
								((!= temp56 global431)
									(if (= temp67 (self bottomCard: 3 1))
										(return)
									)
								)
								((= temp67 (self bottomCard: 3 2))
									(return)
								)
							)
						)
						(
							(or
								(== temp30 16)
								(== temp30 17)
								(== temp30 18)
								(== temp30 19)
								(== temp30 20)
								(== temp30 21)
								(== temp30 22)
								(== temp30 23)
								(== temp30 24)
								(== temp30 25)
							)
							(if (!= temp56 global431)
								(cond
									(temp41
										(return)
									)
									((= temp67 (self bottomCard: 3 1))
										(return)
									)
								)
							else
								(= temp52 20)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
				(17
					(cond
						((or (== temp31 12) (== temp31 13) (== temp31 14))
							(cond
								((!= temp56 global431)
									(if (= temp67 (self bottomCard: 4 1))
										(return)
									)
								)
								((= temp67 (self bottomCard: 4 2))
									(return)
								)
							)
						)
						(
							(or
								(== temp31 16)
								(== temp31 17)
								(== temp31 18)
								(== temp31 19)
								(== temp31 20)
								(== temp31 21)
								(== temp31 22)
								(== temp31 23)
								(== temp31 9)
								(== temp31 25)
							)
							(if (!= temp56 global431)
								(cond
									(temp40
										(return)
									)
									((= temp67 (self bottomCard: 4 1))
										(return)
									)
								)
							else
								(= temp52 21)
							)
						)
						(else
							(= temp52 0)
						)
					)
				)
			)
		)
		(cond
			(
				(and
					(> (+ topCl topDi topHt temp15) temp10)
					(<= (+ temp19 clLosers diLosers htLosers) temp11)
				)
				(self plan: 5)
				(if
					(= temp67
						(self
							whichReturn:
								4
								temp54
								temp55
								temp62
								temp66
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					(> (+ topSp topDi topHt temp12) temp10)
					(<= (+ temp16 spLosers diLosers htLosers) temp11)
				)
				(self plan: 2)
				(if
					(= temp67
						(self
							whichReturn:
								1
								temp54
								temp55
								temp59
								temp63
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					(> (+ topCl topSp topHt temp13) temp10)
					(<= (+ temp17 clLosers spLosers htLosers) temp11)
				)
				(self plan: 3)
				(if
					(= temp67
						(self
							whichReturn:
								2
								temp54
								temp55
								temp60
								temp64
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					(> (+ topCl topDi topSp temp14) temp10)
					(<= (+ temp18 clLosers diLosers spLosers) temp11)
				)
				(self plan: 4)
				(if
					(= temp67
						(self
							whichReturn:
								3
								temp54
								temp55
								temp61
								temp65
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					(> (+ topCl topDi temp14 temp15) temp10)
					(<= (+ temp19 clLosers diLosers temp18) temp11)
				)
				(if (> temp15 temp14)
					(self plan: 5)
					(if
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				else
					(self plan: 4)
					(if
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					(> (+ topCl topHt temp13 temp15) temp10)
					(<= (+ temp19 clLosers htLosers temp17) temp11)
				)
				(if (> temp15 temp13)
					(self plan: 5)
					(if
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				else
					(self plan: 3)
					(if
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					(> (+ topCl topSp temp14 temp13) temp10)
					(<= (+ temp17 clLosers spLosers temp18) temp11)
				)
				(if (> temp14 temp13)
					(self plan: 4)
					(if
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				else
					(self plan: 3)
					(if
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					(> (+ topHt topDi temp12 temp15) temp10)
					(<= (+ temp19 htLosers diLosers temp16) temp11)
				)
				(if (> temp15 temp12)
					(self plan: 5)
					(if
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				else
					(self plan: 2)
					(if
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					(> (+ topDi topSp temp14 temp12) temp10)
					(<= (+ temp16 clLosers spLosers temp18) temp11)
				)
				(if (> temp14 temp12)
					(self plan: 4)
					(if
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				else
					(self plan: 2)
					(if
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					(> (+ topHt topSp temp12 temp13) temp10)
					(<= (+ temp17 htLosers spLosers temp16) temp11)
				)
				(if (> temp12 temp13)
					(self plan: 2)
					(if
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				else
					(self plan: 3)
					(if
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					(> (+ temp14 topSp temp12 temp13) temp10)
					(<= (+ temp17 temp18 spLosers temp16) temp11)
				)
				(cond
					((and (>= temp12 temp13) (>= temp12 temp14))
						(self plan: 2)
						(if
							(= temp67
								(self
									whichReturn:
										1
										temp54
										temp55
										temp59
										temp63
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					((and (>= temp13 temp12) (>= temp13 temp14))
						(self plan: 3)
						(if
							(= temp67
								(self
									whichReturn:
										2
										temp54
										temp55
										temp60
										temp64
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					(else
						(self plan: 4)
						(if
							(= temp67
								(self
									whichReturn:
										3
										temp54
										temp55
										temp61
										temp65
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
				)
			)
			(
				(and
					(> (+ temp15 topHt temp12 temp13) temp10)
					(<= (+ temp17 temp19 htLosers temp16) temp11)
				)
				(cond
					((and (>= temp12 temp13) (>= temp12 temp15))
						(self plan: 2)
						(if
							(= temp67
								(self
									whichReturn:
										1
										temp54
										temp55
										temp59
										temp63
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					((and (>= temp13 temp12) (>= temp13 temp15))
						(self plan: 3)
						(if
							(= temp67
								(self
									whichReturn:
										2
										temp54
										temp55
										temp60
										temp64
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					(else
						(self plan: 5)
						(if
							(= temp67
								(self
									whichReturn:
										4
										temp54
										temp55
										temp62
										temp66
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
				)
			)
			(
				(and
					(> (+ temp14 topDi temp12 temp15) temp10)
					(<= (+ temp19 temp18 diLosers temp16) temp11)
				)
				(cond
					((and (>= temp12 temp15) (>= temp12 temp14))
						(self plan: 2)
						(if
							(= temp67
								(self
									whichReturn:
										1
										temp54
										temp55
										temp59
										temp63
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					((and (>= temp15 temp12) (>= temp15 temp14))
						(self plan: 5)
						(if
							(= temp67
								(self
									whichReturn:
										4
										temp54
										temp55
										temp62
										temp66
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					(else
						(self plan: 4)
						(if
							(= temp67
								(self
									whichReturn:
										3
										temp54
										temp55
										temp61
										temp65
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
				)
			)
			(
				(and
					(> (+ temp14 topCl temp15 temp13) temp10)
					(<= (+ temp17 temp18 clLosers temp19) temp11)
				)
				(cond
					((and (>= temp15 temp13) (>= temp15 temp14))
						(self plan: 5)
						(if
							(= temp67
								(self
									whichReturn:
										4
										temp54
										temp55
										temp62
										temp66
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					((and (>= temp13 temp15) (>= temp13 temp14))
						(self plan: 3)
						(if
							(= temp67
								(self
									whichReturn:
										2
										temp54
										temp55
										temp60
										temp64
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					(else
						(self plan: 4)
						(if
							(= temp67
								(self
									whichReturn:
										3
										temp54
										temp55
										temp61
										temp65
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
				)
			)
			(
				(and
					(> (+ temp14 temp12 temp15 temp13) temp10)
					(<= (+ temp17 temp18 temp16 temp19) temp11)
				)
				(cond
					(
						(and
							(>= temp15 temp13)
							(>= temp15 temp14)
							(>= temp15 temp12)
						)
						(self plan: 5)
						(if
							(= temp67
								(self
									whichReturn:
										4
										temp54
										temp55
										temp62
										temp66
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					(
						(and
							(>= temp13 temp15)
							(>= temp13 temp14)
							(>= temp13 temp12)
						)
						(self plan: 3)
						(if
							(= temp67
								(self
									whichReturn:
										2
										temp54
										temp55
										temp60
										temp64
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					(
						(and
							(>= temp14 temp15)
							(>= temp14 temp13)
							(>= temp14 temp12)
						)
						(self plan: 4)
						(if
							(= temp67
								(self
									whichReturn:
										3
										temp54
										temp55
										temp61
										temp65
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
					(else
						(self plan: 2)
						(if
							(= temp67
								(self
									whichReturn:
										1
										temp54
										temp55
										temp59
										temp63
										temp58
										temp56
										temp57
								)
							)
							(return)
						)
					)
				)
			)
			(
				(and
					temp23
					(>= temp23 temp22)
					(>= temp23 temp21)
					(>= temp23 temp20)
					(or
						(> temp23 temp27)
						(>
							(+
								(Max temp51 temp50 temp49)
								topCl
								topDi
								topHt
							)
							temp10
						)
					)
					(> (+ topCl topHt topDi temp8) temp10)
					(<= (+ spLosers clLosers htLosers diLosers) temp11)
				)
				(self plan: 9)
				(if
					(= temp67
						(self
							whichReturn:
								4
								temp54
								temp55
								temp62
								temp66
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					temp22
					(>= temp22 temp23)
					(>= temp22 temp21)
					(>= temp22 temp20)
					(or
						(> temp22 temp26)
						(>
							(+
								(Max temp51 temp50 temp48)
								topCl
								topDi
								topSp
							)
							temp10
						)
					)
					(> (+ topCl topSp topDi temp7) temp10)
					(<= (+ spLosers clLosers htLosers diLosers) temp11)
				)
				(self plan: 8)
				(if
					(= temp67
						(self
							whichReturn:
								3
								temp54
								temp55
								temp61
								temp65
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					temp21
					(>= temp21 temp22)
					(>= temp21 temp23)
					(>= temp21 temp20)
					(or
						(> temp21 temp25)
						(>
							(+
								(Max temp51 temp48 temp49)
								topCl
								topSp
								topHt
							)
							temp10
						)
					)
					(> (+ topCl topSp temp6 topHt) temp10)
					(<= (+ spLosers clLosers htLosers diLosers) temp11)
				)
				(self plan: 7)
				(if
					(= temp67
						(self
							whichReturn:
								2
								temp54
								temp55
								temp60
								temp64
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					temp20
					(>= temp20 temp22)
					(>= temp20 temp21)
					(>= temp20 temp23)
					(or
						(> temp20 temp24)
						(>
							(+
								(Max temp48 temp50 temp49)
								topSp
								topDi
								topHt
							)
							temp10
						)
					)
					(> (+ topDi topSp temp5 topHt) temp10)
					(<= (+ spLosers clLosers htLosers diLosers) temp11)
				)
				(self plan: 6)
				(if
					(= temp67
						(self
							whichReturn:
								1
								temp54
								temp55
								temp59
								temp63
								temp58
								temp56
								temp57
						)
					)
					(return)
				)
			)
			(
				(and
					temp27
					(> (+ temp32 topCl topDi topHt topSp) temp10) ; UNINIT
					temp31
					(OneOf temp31 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp66)
				)
				(self plan: 13)
				(cond
					((not temp40)
						(self bottomCard: 4 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp27
					(> (+ temp32 topCl topDi topHt topSp) temp10) ; UNINIT
					temp31
					(OneOf temp31 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp62)
				)
				(self plan: 17)
				(cond
					((not temp40)
						(self bottomCard: 4 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp26
					(> (+ temp33 topCl topDi topHt topSp) temp10) ; UNINIT
					temp30
					(OneOf temp30 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp65)
				)
				(self plan: 12)
				(cond
					((not temp41)
						(self bottomCard: 3 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp26
					(> (+ temp33 topCl topDi topHt topSp) temp10) ; UNINIT
					temp30
					(OneOf temp30 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp61)
				)
				(self plan: 16)
				(cond
					((not temp41)
						(self bottomCard: 3 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp25
					(> (+ temp34 topCl topDi topHt topSp) temp10) ; UNINIT
					temp29
					(OneOf temp29 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp64)
				)
				(self plan: 11)
				(cond
					((not temp42)
						(self bottomCard: 2 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp25
					(> (+ temp34 topCl topDi topHt topSp) temp10) ; UNINIT
					temp29
					(OneOf temp29 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp60)
				)
				(self plan: 15)
				(cond
					((not temp42)
						(self bottomCard: 2 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp24
					(> (+ temp35 topCl topDi topHt topSp) temp10) ; UNINIT
					temp28
					(OneOf temp28 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp63)
				)
				(self plan: 10)
				(cond
					((not temp43)
						(self bottomCard: 1 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp24
					(> (+ temp35 topCl topDi topHt topSp) temp10) ; UNINIT
					temp28
					(OneOf temp28 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp59)
				)
				(self plan: 14)
				(cond
					((not temp43)
						(self bottomCard: 1 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp23
					(or
						(and (== temp56 global429) temp62)
						(and (== temp56 global431) temp66)
						(and (!= temp56 global429) (!= temp56 global431))
					)
				)
				(cond
					((== temp56 global429)
						(if (global429 hasCard: 4 14)
							(self topCard: 4 1)
							(return)
						else
							(self bottomCard: 4 1)
							(return)
						)
					)
					((global431 hasCard: 4 14)
						(self topCard: 4 2)
						(return)
					)
					(else
						(self bottomCard: 4 2)
						(return)
					)
				)
			)
			(
				(and
					temp22
					(or
						(and (== temp56 global429) temp61)
						(and (== temp56 global431) temp65)
						(and (!= temp56 global429) (!= temp56 global431))
					)
				)
				(cond
					((== temp56 global429)
						(if (global429 hasCard: 3 14)
							(self topCard: 3 1)
							(return)
						else
							(self bottomCard: 3 1)
							(return)
						)
					)
					((global431 hasCard: 3 14)
						(self topCard: 3 2)
						(return)
					)
					(else
						(self bottomCard: 3 2)
						(return)
					)
				)
			)
			(
				(and
					temp21
					(or
						(and (== temp56 global429) temp60)
						(and (== temp56 global431) temp64)
						(and (!= temp56 global429) (!= temp56 global431))
					)
				)
				(cond
					((== temp56 global429)
						(if (global429 hasCard: 2 14)
							(self topCard: 2 1)
							(return)
						else
							(self bottomCard: 2 1)
							(return)
						)
					)
					((global431 hasCard: 2 14)
						(self topCard: 2 2)
						(return)
					)
					(else
						(self bottomCard: 2 2)
						(return)
					)
				)
			)
			(
				(and
					temp20
					(or
						(and (== temp56 global429) temp59)
						(and (== temp56 global431) temp63)
						(and (!= temp56 global429) (!= temp56 global431))
					)
				)
				(cond
					((== temp56 global429)
						(if (global429 hasCard: 1 14)
							(self topCard: 1 1)
							(return)
						else
							(self bottomCard: 1 1)
							(return)
						)
					)
					((global431 hasCard: 1 14)
						(self topCard: 1 2)
						(return)
					)
					(else
						(self bottomCard: 1 2)
						(return)
					)
				)
			)
			(
				(and
					temp27
					(> (+ temp32 topCl topDi topHt topSp) temp10) ; UNINIT
					temp31
					(OneOf temp31 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp66)
				)
				(self plan: 13)
				(cond
					((not temp40)
						(self bottomCard: 4 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp27
					temp31
					(OneOf temp31 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp62)
				)
				(self plan: 17)
				(cond
					((not temp40)
						(self bottomCard: 4 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									4
									temp54
									temp55
									temp62
									temp66
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp26
					temp30
					(OneOf temp30 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp65)
				)
				(self plan: 12)
				(cond
					((not temp41)
						(self bottomCard: 3 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp26
					temp30
					(OneOf temp30 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp61)
				)
				(self plan: 16)
				(cond
					((not temp41)
						(self bottomCard: 3 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									3
									temp54
									temp55
									temp61
									temp65
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp25
					temp29
					(OneOf temp29 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp64)
				)
				(self plan: 11)
				(cond
					((not temp42)
						(self bottomCard: 2 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp25
					temp29
					(OneOf temp29 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp60)
				)
				(self plan: 15)
				(cond
					((not temp42)
						(self bottomCard: 2 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									2
									temp54
									temp55
									temp60
									temp64
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp24
					temp28
					(OneOf temp28 1 2 12 3 4 5 13 6 7 8 14 9 10)
					(!= temp56 global429)
					(or (!= temp56 global431) temp63)
				)
				(self plan: 10)
				(cond
					((not temp43)
						(self bottomCard: 1 2)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(
				(and
					temp24
					temp28
					(OneOf temp28 16 17 12 18 19 20 13 21 22 23 14 24 25)
					(!= temp56 global431)
					(or (!= temp56 global429) temp59)
				)
				(self plan: 14)
				(cond
					((not temp43)
						(self bottomCard: 1 1)
						(return)
					)
					(
						(= temp67
							(self
								whichReturn:
									1
									temp54
									temp55
									temp59
									temp63
									temp58
									temp56
									temp57
							)
						)
						(return)
					)
				)
			)
			(else
				(cond
					(
						(==
							(= temp1
								(Max
									(+ temp62 temp66)
									(+ temp61 temp65)
									(+ temp60 temp64)
									(+ temp59 temp63)
								)
							)
							(+ temp62 temp66)
						)
						(if
							(or
								(and (== temp56 global429) temp62)
								(!= temp56 global429)
							)
							(self bottomCard: 4 1)
							(return)
						)
						(if
							(or
								(and (== temp56 global431) temp66)
								(!= temp56 global431)
							)
							(self bottomCard: 4 2)
							(return)
						)
					)
					((== temp1 (+ temp61 temp65))
						(if
							(or
								(and (== temp56 global429) temp61)
								(!= temp56 global429)
							)
							(self bottomCard: 3 1)
							(return)
						)
						(if
							(or
								(and (== temp56 global431) temp65)
								(!= temp56 global431)
							)
							(self bottomCard: 3 2)
							(return)
						)
					)
					((== temp1 (+ temp60 temp64))
						(if
							(or
								(and (== temp56 global429) temp60)
								(!= temp56 global429)
							)
							(self bottomCard: 2 1)
							(return)
						)
						(if
							(or
								(and (== temp56 global431) temp64)
								(!= temp56 global431)
							)
							(self bottomCard: 2 2)
							(return)
						)
					)
					((== temp1 (+ temp59 temp63))
						(if
							(or
								(and (== temp56 global429) temp59)
								(!= temp56 global429)
							)
							(self bottomCard: 1 1)
							(return)
						)
						(if
							(or
								(and (== temp56 global431) temp63)
								(!= temp56 global431)
							)
							(self bottomCard: 1 2)
							(return)
						)
					)
				)
				(if
					(or
						(== temp56 global429)
						(and (== temp56 LHO) (== temp57 3))
						(and (== temp56 RHO) (== temp57 1))
					)
					(= temp1 (Max temp62 temp61 temp60 temp59))
					(= temp68 1)
				else
					(= temp1 (Max temp66 temp65 temp64 temp63))
					(= temp68 2)
				)
				(cond
					(
						(==
							temp1
							(switch temp68
								(1 temp62)
								(2 temp66)
							)
						)
						(self bottomCard: 4 temp68)
						(return)
					)
					(
						(==
							temp1
							(switch temp68
								(1 temp61)
								(2 temp65)
							)
						)
						(self bottomCard: 3 temp68)
						(return)
					)
					(
						(==
							temp1
							(switch temp68
								(1 temp60)
								(2 temp64)
							)
						)
						(self bottomCard: 2 temp68)
						(return)
					)
					(
						(==
							temp1
							(switch temp68
								(1 temp59)
								(2 temp63)
							)
						)
						(self bottomCard: 1 temp68)
						(return)
					)
				)
			)
		)
	)

	(method (forceWinners &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(= temp2 0)
		(= temp3 0)
		(while (< temp0 13)
			(if (== [global201 temp0] 1)
				(++ temp2)
			)
			(if (== [global201 temp0] 2)
				(++ temp3)
			)
			(++ temp0)
		)
		(cond
			(
				(and
					[global201 0]
					[global201 1]
					[global201 2]
					[global201 4]
					[global201 5]
				)
				(self forceLosers: 1)
				(if (and (< temp2 5) (< temp3 5))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 4)
				)
			)
			(
				(and
					[global201 0]
					[global201 1]
					[global201 3]
					[global201 4]
					[global201 5]
				)
				(self forceLosers: 1)
				(if (and (< temp2 5) (< temp3 5))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 4)
				)
			)
			((and [global201 0] [global201 1] [global201 3] [global201 4])
				(self forceLosers: 1)
				(if (and (< temp2 4) (< temp3 4))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 3)
				)
			)
			(
				(and
					[global201 0]
					[global201 2]
					[global201 3]
					[global201 4]
					[global201 5]
				)
				(self forceLosers: 1)
				(if (and (< temp2 5) (< temp3 5))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 4)
				)
			)
			((and [global201 0] [global201 2] [global201 3] [global201 4])
				(self forceLosers: 1)
				(if (and (< temp2 4) (< temp3 4))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 3)
				)
			)
			((and [global201 0] [global201 2] [global201 3])
				(self forceLosers: 1)
				(if (and (< temp2 3) (< temp3 3))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 2)
				)
			)
			(
				(and
					[global201 1]
					[global201 2]
					[global201 3]
					[global201 4]
					[global201 5]
				)
				(self forceLosers: 1)
				(if (and (< temp2 5) (< temp3 5))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 4)
				)
			)
			((and [global201 1] [global201 2] [global201 3] [global201 4])
				(self forceLosers: 1)
				(if (and (< temp2 4) (< temp3 4))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 3)
				)
			)
			((and [global201 1] [global201 2] [global201 3])
				(self forceLosers: 1)
				(if (and (< temp2 3) (< temp3 3))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 2)
				)
			)
			(
				(and
					[global201 1]
					[global201 2]
					[global201 4]
					[global201 5]
					[global201 6]
				)
				(self forceLosers: 2)
				(if (and (< temp2 5) (< temp3 5))
					(return (- 2 (Max temp2 temp3)))
				else
					(return 3)
				)
			)
			((and [global201 1] [global201 2] [global201 4] [global201 5])
				(self forceLosers: 2)
				(if (and (< temp2 4) (< temp3 4))
					(return (- 2 (Max temp2 temp3)))
				else
					(return 2)
				)
			)
			((and [global201 1] [global201 2])
				(self forceLosers: 1)
				(if (and (< temp2 2) (< temp3 2))
					(return (- 1 (Max temp2 temp3)))
				else
					(return 1)
				)
			)
			(
				(and
					[global201 2]
					[global201 3]
					[global201 4]
					[global201 5]
					[global201 6]
				)
				(self forceLosers: 2)
				(if (and (< temp2 5) (< temp3 5))
					(return (- 2 (Max temp2 temp3)))
				else
					(return 3)
				)
			)
			((and [global201 2] [global201 3] [global201 4] [global201 5])
				(self forceLosers: 2)
				(if (and (< temp2 4) (< temp3 4))
					(return (- 2 (Max temp2 temp3)))
				else
					(return 2)
				)
			)
			((and [global201 2] [global201 3] [global201 4])
				(self forceLosers: 2)
				(if (and (< temp2 3) (< temp3 3))
					(return (- 2 (Max temp2 temp3)))
				else
					(return 1)
				)
			)
			(
				(and
					[global201 2]
					[global201 3]
					[global201 5]
					[global201 6]
					[global201 7]
				)
				(self forceLosers: 3)
				(if (and (< temp2 5) (< temp3 5))
					(return (- 2 (Max temp2 temp3)))
				else
					(return 2)
				)
			)
		)
	)

	(method (checkLongTricks param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp8 (self LHO:))
		(= temp9 (self RHO:))
		(self checkTopTricks:)
		(switch param1
			(1
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 1)
						((global117 atLocation: 2) countSuit: 1)
						((global117 atLocation: 1) countSuit: 1)
						((global117 atLocation: 4) countSuit: 1)
					)
				)
				(= temp1 (self topCl:))
				(= temp2 (temp8 minClubs:))
				(= temp3 (temp8 maxClubs:))
				(= temp4 (temp9 minClubs:))
				(= temp5 (temp9 maxClubs:))
				(= temp6 (global429 clubs:))
				(= temp7 (global431 clubs:))
			)
			(2
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 2)
						((global117 atLocation: 2) countSuit: 2)
						((global117 atLocation: 1) countSuit: 2)
						((global117 atLocation: 4) countSuit: 2)
					)
				)
				(= temp1 (self topDi:))
				(= temp2 (temp8 minDiamonds:))
				(= temp3 (temp8 maxDiamonds:))
				(= temp4 (temp9 minDiamonds:))
				(= temp5 (temp9 maxDiamonds:))
				(= temp6 (global429 diamonds:))
				(= temp7 (global431 diamonds:))
			)
			(3
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 3)
						((global117 atLocation: 2) countSuit: 3)
						((global117 atLocation: 1) countSuit: 3)
						((global117 atLocation: 4) countSuit: 3)
					)
				)
				(= temp1 (self topHt:))
				(= temp2 (temp8 minHearts:))
				(= temp3 (temp8 maxHearts:))
				(= temp4 (temp9 minHearts:))
				(= temp5 (temp9 maxHearts:))
				(= temp6 (global429 hearts:))
				(= temp7 (global431 hearts:))
			)
			(else
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 4)
						((global117 atLocation: 2) countSuit: 4)
						((global117 atLocation: 1) countSuit: 4)
						((global117 atLocation: 4) countSuit: 4)
					)
				)
				(= temp1 (self topSp:))
				(= temp2 (temp8 minSpades:))
				(= temp3 (temp8 maxSpades:))
				(= temp4 (temp9 minSpades:))
				(= temp5 (temp9 maxSpades:))
				(= temp6 (global429 spades:))
				(= temp7 (global431 spades:))
			)
		)
		(= temp10 (- (+ temp7 temp6) temp0))
		(self mustLose: 0)
		(if (> (- temp1 (Max temp3 temp5)) 0)
			(self LHOChance: 100)
			(return (Max (temp7 temp6:)))
		)
		(if (>= temp1 (/ (+ 5 temp10) 2))
			(self LHOChance: [local26 temp10])
			(return (Max temp7 temp6))
		)
		(if (>= temp1 (/ (+ 3 temp10) 2))
			(self LHOChance: [local13 temp10])
			(return (Max temp7 temp6))
		)
		(if (>= temp1 (/ (+ 1 temp10) 2))
			(self LHOChance: [local0 temp10])
			(return (Max temp7 temp6))
		)
		(if (< temp1 (/ (+ 1 temp10) 2))
			(self LHOChance: 100)
			(return temp1)
		)
	)

	(method (duckToSetUp param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= temp9 (self LHO:))
		(= temp10 (self RHO:))
		(self checkTopTricks:)
		(switch param1
			(1
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 1)
						((global117 atLocation: 2) countSuit: 1)
						((global117 atLocation: 1) countSuit: 1)
						((global117 atLocation: 4) countSuit: 1)
					)
				)
				(= temp1 (self topCl:))
				(= temp2 (temp9 minClubs:))
				(= temp3 (temp9 maxClubs:))
				(= temp4 (temp10 minClubs:))
				(= temp5 (temp10 maxClubs:))
				(= temp7 (global429 clubs:))
				(= temp8 (global431 clubs:))
			)
			(2
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 2)
						((global117 atLocation: 2) countSuit: 2)
						((global117 atLocation: 1) countSuit: 2)
						((global117 atLocation: 4) countSuit: 2)
					)
				)
				(= temp1 (self topDi:))
				(= temp2 (temp9 minDiamonds:))
				(= temp3 (temp9 maxDiamonds:))
				(= temp4 (temp10 minDiamonds:))
				(= temp5 (temp10 maxDiamonds:))
				(= temp7 (global429 diamonds:))
				(= temp8 (global431 diamonds:))
			)
			(3
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 3)
						((global117 atLocation: 2) countSuit: 3)
						((global117 atLocation: 1) countSuit: 3)
						((global117 atLocation: 4) countSuit: 3)
					)
				)
				(= temp1 (self topHt:))
				(= temp2 (temp9 minHearts:))
				(= temp3 (temp9 maxHearts:))
				(= temp4 (temp10 minHearts:))
				(= temp5 (temp10 maxHearts:))
				(= temp7 (global429 hearts:))
				(= temp8 (global431 hearts:))
			)
			(else
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 4)
						((global117 atLocation: 2) countSuit: 4)
						((global117 atLocation: 1) countSuit: 4)
						((global117 atLocation: 4) countSuit: 4)
					)
				)
				(= temp1 (self topSp:))
				(= temp2 (temp9 minSpades:))
				(= temp3 (temp9 maxSpades:))
				(= temp4 (temp10 minSpades:))
				(= temp5 (temp10 maxSpades:))
				(= temp7 (global429 spades:))
				(= temp8 (global431 spades:))
			)
		)
		(= temp11 (- (+ temp8 temp7) temp0))
		(= temp6 (Max temp7 temp8))
		(switch param2
			(1
				(if (> temp6 (/ (+ 5 temp11) 2))
					(self LHOChance: [local26 temp11])
					(return (- (/ (+ 1 temp11) 2) (+ temp1 temp6)))
				)
				(if (> temp6 (/ (+ 3 temp11) 2))
					(self LHOChance: [local13 temp11])
					(return (- (/ (+ 1 temp11) 2) (+ temp1 temp6)))
				)
				(if (<= 1 (- temp1 (/ (+ 1 temp11) 2)))
					(self LHOChance: [local0 temp11])
					(return (- (/ (+ 1 temp11) 2) (+ temp1 temp6)))
				)
			)
			(2
				(if (> temp6 (/ (+ 5 temp11) 2))
					(self LHOChance: [local26 temp11])
					(return (- (/ (+ 3 temp11) 2) (+ temp1 temp6)))
				)
				(if (> temp6 (/ (+ 3 temp11) 2))
					(self LHOChance: [local13 temp11])
					(return (- (/ (+ 3 temp11) 2) (+ temp1 temp6)))
				)
				(if (<= 1 (- temp1 (/ (+ 1 temp11) 2)))
					(self LHOChance: [local0 temp11])
					(return (- (/ (+ 3 temp11) 2) (+ temp1 temp6)))
				)
			)
			(3
				(if (> temp6 (/ (+ 5 temp11) 2))
					(self LHOChance: [local26 temp11])
					(return (- (/ (+ 5 temp11) 2) (+ temp1 temp6)))
				)
				(if (> temp6 (/ (+ 5 temp11) 2))
					(self LHOChance: [local26 temp11])
					(return (- (/ (+ 5 temp11) 2) (+ temp1 temp6)))
				)
				(if (<= 1 (- temp1 (/ (+ 1 temp11) 2)))
					(self LHOChance: [local0 temp11])
					(return (- (/ (+ 5 temp11) 2) (+ temp1 temp6)))
				)
			)
			(else
				(self LHOChance: 0)
				(return temp1)
			)
		)
	)

	(method (topLosers param1 &tmp temp0 temp1 temp2)
		(for ((= temp2 0)) (< temp2 (global429 size:)) ((++ temp2))
			(if
				(and
					(== ((global429 at: temp2) suit:) param1)
					(<
						(= temp1 (SortArray isCurrent: (global429 at: temp2)))
						temp0 ; UNINIT
					)
				)
				(= temp0 temp1)
			)
			(if
				(and
					(== ((global431 at: temp2) suit:) param1)
					(<
						(= temp1 (SortArray isCurrent: (global431 at: temp2)))
						temp0
					)
				)
				(= temp0 temp1)
			)
		)
		(return temp0)
	)

	(method (checkTopTricks &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(for
			((= temp9 (= temp4 (= temp5 (= temp6 (= temp7 0))))))
			(< temp9 (global429 size:))
			((++ temp9))
			
			(if (== (= temp8 (SortArray isCurrent: (global429 at: temp9))) 0)
				(switch ((global429 at: temp9) suit:)
					(4
						(++ temp3) ; UNINIT
					)
					(1
						(++ temp0) ; UNINIT
					)
					(2
						(++ temp1) ; UNINIT
					)
					(3
						(++ temp2) ; UNINIT
					)
				)
			)
			(if (== (= temp8 (SortArray isCurrent: (global431 at: temp9))) 0)
				(switch ((global431 at: temp9) suit:)
					(4
						(++ temp3) ; UNINIT
					)
					(1
						(++ temp0) ; UNINIT
					)
					(2
						(++ temp1) ; UNINIT
					)
					(3
						(++ temp2) ; UNINIT
					)
				)
			)
		)
		(while
			(or
				(!= temp0 temp7) ; UNINIT
				(!= temp1 temp6) ; UNINIT
				(!= temp2 temp5) ; UNINIT
				(!= temp3 temp4) ; UNINIT
			)
			(= temp9 0)
			(= temp7 temp0) ; UNINIT
			(= temp6 temp1) ; UNINIT
			(= temp5 temp2) ; UNINIT
			(= temp4 temp3) ; UNINIT
			(while (< temp9 (Min (global431 size:) (global429 size:)))
				(= temp8 (SortArray isCurrent: (global429 at: temp9)))
				(switch ((global429 at: temp9) suit:)
					(4
						(if (== temp8 temp3 1) ; UNINIT
							(++ temp3) ; UNINIT
						)
					)
					(1
						(if (== temp8 temp0 1) ; UNINIT
							(++ temp0) ; UNINIT
						)
					)
					(2
						(if (== temp8 temp1 1) ; UNINIT
							(++ temp1) ; UNINIT
						)
					)
					(3
						(if (== temp8 temp2 1) ; UNINIT
							(++ temp2) ; UNINIT
						)
					)
				)
				(= temp8 (SortArray isCurrent: (global431 at: temp9)))
				(switch ((global429 at: temp9) suit:)
					(4
						(if (== temp8 temp3 1) ; UNINIT
							(++ temp3) ; UNINIT
						)
					)
					(1
						(if (== temp8 temp0 1) ; UNINIT
							(++ temp0) ; UNINIT
						)
					)
					(2
						(if (== temp8 temp1 1) ; UNINIT
							(++ temp1) ; UNINIT
						)
					)
					(3
						(if (== temp8 temp2 1) ; UNINIT
							(++ temp2) ; UNINIT
						)
					)
				)
				(++ temp9)
			)
			(if (> (global431 size:) temp9)
				(++ temp9)
				(= temp8 (SortArray isCurrent: (global431 at: temp9)))
				(switch ((global429 at: temp9) suit:)
					(4
						(if (== temp8 temp3 1) ; UNINIT
							(++ temp3) ; UNINIT
						)
					)
					(1
						(if (== temp8 temp0 1) ; UNINIT
							(++ temp0) ; UNINIT
						)
					)
					(2
						(if (== temp8 temp1 1) ; UNINIT
							(++ temp1) ; UNINIT
						)
					)
					(3
						(if (== temp8 temp2 1) ; UNINIT
							(++ temp2) ; UNINIT
						)
					)
				)
			)
			(if (> (global429 size:) temp9)
				(= temp8 (SortArray isCurrent: (global431 at: temp9)))
				(switch ((global429 at: temp9) suit:)
					(4
						(if (== temp8 temp3 1) ; UNINIT
							(++ temp3) ; UNINIT
						)
					)
					(1
						(if (== temp8 temp0 1) ; UNINIT
							(++ temp0) ; UNINIT
						)
					)
					(2
						(if (== temp8 temp1 1) ; UNINIT
							(++ temp1) ; UNINIT
						)
					)
					(3
						(if (== temp8 temp2 1) ; UNINIT
							(++ temp2) ; UNINIT
						)
					)
				)
			)
		)
		(if (> temp0 (Max (global431 clubs:) (global429 clubs:))) ; UNINIT
			(= temp0 (Max (global431 clubs:) (global429 clubs:)))
		)
		(if (> temp1 (Max (global431 diamonds:) (global429 diamonds:))) ; UNINIT
			(= temp1 (Max (global431 diamonds:) (global429 diamonds:)))
		)
		(if (> temp2 (Max (global431 hearts:) (global429 hearts:))) ; UNINIT
			(= temp2 (Max (global431 hearts:) (global429 hearts:)))
		)
		(if (> temp3 (Max (global431 spades:) (global429 spades:))) ; UNINIT
			(= temp3 (Max (global431 spades:) (global429 spades:)))
		)
		(self topCl: temp0)
		(self topDi: temp1)
		(self topHt: temp2)
		(self topSp: temp3)
		(return (+ temp0 temp1 temp2 temp3))
	)

	(method (whichReturn param1 param2 param3 param4 param5 param6 param7 param8)
		(cond
			((and param2 param4)
				(self topCard: param1 1)
				(return)
			)
			((and param3 param5)
				(self topCard: param1 2)
				(return)
			)
			((and (== param6 param1) (not param2) (not param3))
				(if
					(or
						(and (== param7 LHO) (< param8 2))
						(and (== param7 RHO) (== param8 3))
					)
					(self topCard: param1 2)
					(return)
				else
					(self topCard: param1 1)
					(return)
				)
			)
		)
	)

	(method (topCard param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 0)
		(= temp3 13)
		(= temp4 0)
		(while (< temp2 (global429 size:))
			(if (!= param2 1)
				(if
					(<
						(= temp0 (SortArray isCurrent: (global429 at: temp2)))
						temp3
					)
					(= temp3 temp0)
					(= temp4 temp2)
				)
				(if (and (== temp0 0) (== temp1 ((global429 at: temp2) suit:))) ; UNINIT
					(global429 at: temp2)
					(return)
				)
			)
			(if (!= param2 2)
				(if
					(<
						(= temp0 (SortArray isCurrent: (global431 at: temp2)))
						temp3
					)
					(= temp3 temp0)
					(= temp4 (+ 13 temp2))
				)
				(if (and (== temp0 0) (== temp1 ((global431 at: temp2) suit:))) ; UNINIT
					(global431 at: temp2)
					(return)
				)
			)
			(++ temp2)
		)
		(cond
			((< temp3 7)
				(if (> temp4 13)
					(global431 at: (- 13 temp4))
					(return)
				else
					(global429 at: temp4)
					(return)
				)
			)
			(param2
				(self bottomCard: param1 param2)
				(return)
			)
			(else
				(self bottomCard: param1)
				(return)
			)
		)
	)

	(method (bottomCard param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp2 0)
		(= temp3 0)
		(= temp4 0)
		(while (< temp2 (global429 size:))
			(if (== param2 2)
				(= temp0 (SortArray isCurrent: (global429 at: temp2)))
				(= temp5 (global429 at: temp2))
			else
				(= temp0 (SortArray isCurrent: (global431 at: temp2)))
				(= temp5 (global431 at: temp2))
			)
			(if (and (> temp0 temp3) (== (temp5 suit:) param1))
				(= temp4 temp2)
				(= temp3 temp0)
			)
			(++ temp2)
		)
		(cond
			((== temp4 0)
				(return 0)
			)
			((== param2 2)
				(return (global431 at: temp4))
			)
			(else
				(return (global429 at: temp4))
			)
		)
	)

	(method (calcPoints &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp5 (self LHO:))
		(= temp6 (self RHO:))
		(for ((= temp2 (= temp0 (= temp1 0)))) (< temp2 13) ((++ temp2))
			(= temp3 (global431 at: temp2))
			(= temp4 (global429 at: temp2))
			(switch (temp3 rank:)
				(14
					(+= temp0 4)
				)
				(13
					(+= temp0 3)
				)
				(12
					(+= temp0 2)
				)
				(11
					(+= temp0 1)
				)
			)
			(switch (temp4 rank:)
				(14
					(+= temp1 4)
				)
				(13
					(+= temp1 3)
				)
				(12
					(+= temp1 2)
				)
				(11
					(+= temp1 1)
				)
			)
		)
		(for
			((= temp2 (= temp7 0)))
			(< temp2 ((temp5 playedList:) size:))
			((++ temp2))
			
			(= temp3 (temp5 at: temp2))
			(switch (temp3 rank:)
				(14
					(+= temp7 4)
				)
				(13
					(+= temp7 3)
				)
				(12
					(+= temp7 2)
				)
				(11
					(+= temp7 1)
				)
			)
		)
		(for
			((= temp2 (= temp8 0)))
			(< temp2 ((temp6 playedList:) size:))
			((++ temp2))
			
			(= temp3 (temp6 at: temp2))
			(switch (temp3 rank:)
				(14
					(+= temp8 4)
				)
				(13
					(+= temp8 3)
				)
				(12
					(+= temp8 2)
				)
				(11
					(+= temp8 1)
				)
			)
		)
		(self LHOPoints: temp7)
		(self RHOPoints: temp8)
		(if (> (temp5 maxPoints:) (+ temp1 temp0 temp8))
			(temp5 maxPoints: (- 40 (+ temp1 temp0 temp8)))
		)
		(if (> (temp6 maxPoints:) (+ temp1 temp0 temp7))
			(temp6 maxPoints: (- 40 (+ temp1 temp0 temp7)))
		)
		(if (> temp7 (temp5 minPoints:))
			(temp5 minPoints: temp7)
		)
		(if (> temp8 (temp6 minPoints:))
			(temp6 minPoints: temp8)
		)
		(if (> (temp5 minPoints:) (temp5 maxPoints:))
			(temp5 maxPoints: (temp5 minPoints:))
		)
		(if (> (temp6 minPoints:) (temp6 maxPoints:))
			(temp6 maxPoints: (temp6 minPoints:))
		)
		(if (== 40 (+ temp0 temp1 temp7 temp8))
			(temp5 maxPoints: 0)
			(temp6 maxPoints: 0)
		)
		(= combinedHCP (+ temp0 temp1))
		(= missingHCP (- 40 combinedHCP))
	)
)

(instance clubsPlayed of List ; UNUSED
	(properties)
)

(instance diamondsPlayed of List ; UNUSED
	(properties)
)

(instance heartsPlayed of List ; UNUSED
	(properties)
)

(instance spadesPlayed of List ; UNUSED
	(properties)
)

