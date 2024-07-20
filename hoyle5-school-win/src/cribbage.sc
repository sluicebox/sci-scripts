;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use h5Messager)
(use Tray)
(use CribbageStrategy)
(use Trick)
(use Str)
(use Print)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	cribbage 0
	proc500_1 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	[local20 10] = [1 2 3 4 5 6 7 8 9 10]
	[local30 11] = [0 2 2 6 12 3 4 5 4 5 1]
	[local41 3] = [11 11 11]
	[local44 3] = [154 159 164]
	[local47 3] = [18 18 18]
	[local50 3] = [154 159 164]
	[local53 122] = [0 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 11 13 18 23 29 36 42 47 52 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 54 52 46 37 31 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 33]
	[local175 122] = [0 142 139 136 133 130 125 122 119 116 113 108 105 102 99 96 91 88 85 82 79 74 71 68 65 62 57 54 51 48 45 40 37 34 31 28 23 18 14 12 10 10 12 14 18 23 28 31 34 37 40 45 48 51 54 57 62 65 68 71 74 79 82 85 88 91 96 99 102 105 108 113 116 119 122 125 130 133 136 139 142 148 154 160 164 166 166 164 160 154 148 142 139 136 133 130 125 122 119 116 113 108 105 102 99 96 91 88 85 82 79 74 71 68 65 62 57 54 51 48 45 31]
	[local297 122] = [0 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 19 22 25 29 36 40 43 46 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 47 45 38 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 36 33]
	[local419 122] = [0 142 139 136 133 130 125 122 119 116 113 108 105 102 99 96 91 88 85 82 79 74 71 68 65 62 57 54 51 48 45 40 37 34 31 28 23 20 18 17 16 16 17 18 20 23 28 31 34 37 40 45 48 51 54 57 62 65 68 71 74 79 82 85 88 91 96 99 102 105 108 113 116 119 122 125 130 133 136 139 142 148 151 154 157 160 160 157 154 151 148 142 139 136 133 130 125 122 119 116 113 108 105 102 99 96 91 88 85 82 79 74 71 68 65 62 57 54 51 48 45 31]
	[local541 8] = [0 19 24 29 34 39 44 49]
	[local549 8] = [0 177 177 177 177 177 177 177]
	[local557 8] = [0 19 24 29 34 39 44 49]
	[local565 28] = [0 184 184 184 184 184 184 184 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	local593
	[local594 4]
	local598
	local599
	local600
	local601
	local602
)

(procedure (proc500_1)
	(proc0_8 97)
	((ScriptID 580 0) init:) ; scoreCribbage
	(DisposeScript 580)
	(proc0_8 0)
)

(procedure (localproc_0 param1 param2 param3)
	(if (>= param1 10)
		(proc0_10 501 11 (mod (/ param1 10) 10) param2 param3 14 0 {score})
	)
	(if (>= param1 0)
		(proc0_10 501 11 (mod param1 10) (+ param2 7) param3 14 0 {score})
	)
)

(instance cribbage of HoyleRoom
	(properties
		style 0
	)

	(method (init)
		(= picture (+ (= global747 902) global385))
		(= global406 0)
		(DisableCursor)
		(= local0 0)
		((= gCribbage_opt cribbage_opt) doit:)
		(if global462
			(gChar1 view: global463 active: 1 setLoop: global466)
			((gChar1 face:) view: global463)
			(= gSkill global469)
		)
		(super init:)
		(cribbageBoard init:)
		(cribbageBoard2 init:)
		(if local599
			(local599 dispose:)
		)
		(if local600
			(local600 dispose:)
		)
		(if local601
			(local601 dispose:)
		)
		(= local602 0)
		(= local599 (Str new:))
		(= local600 (Str new:))
		(= local601 (Str with: {,\n}))
		(= gCardGameScriptNumber 500)
		((= gTheHands theHands) add: hand1 hand2)
		(hand1 partner: hand2)
		(hand2 partner: hand1)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1)
		(CribbageTrick add: init:)
		(handleEventList add:)
		(Dealer cardsToDeal: 6)
		(Deck init:)
		(Deck rankAces: 1)
		(= gSortMode global251)
		(= [global390 0] 3)
		(= [global390 1] 1)
		(= [global390 2] 2)
		(= [global390 3] 0)
		(gChar1 posn: 101 20 show: init:)
		(Characters init:)
		((gChar1 face:) view: (gChar1 view:))
		(KeyMouse setList: gTheKeyMouseList)
		(= global419 Stock)
		(self setScript: roomScript)
	)

	(method (drawNewPic)
		(if global406
			(= local5 1)
		else
			(= local5 0)
		)
		(super drawNewPic: &rest)
		(if local5
			(= local5 0)
			(handScorePanel init:)
		)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(= global290 0)
			(gTheHands eachElementDo: #sort)
			(EnableCursor)
		)
	)

	(method (handleEvent event)
		(event plane: 0)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
	)

	(method (dispose)
		(= global406 0)
		(if global458
			(global458 dispose:)
		)
		(= global458 0)
		(= global395 0)
		(KeyMouse release:)
		(Trick numCardsInATrick: 4)
		(gTrick eachElementDo: #dispose)
		(if ((ScriptID 15 1) size:) ; discardList
			((ScriptID 15 1) release:) ; discardList
		)
		((ScriptID 15 1) dispose:) ; discardList
		(= gCrazy8sSortCode 0)
		(gTheHands release: dispose:)
		(if gTray
			(gTray release: dispose:)
		)
		(if (Piles elements:)
			(Piles release: dispose:)
		)
		(if local599
			(local599 dispose:)
		)
		(if local600
			(local600 dispose:)
		)
		(if local601
			(local601 dispose:)
		)
		(= local602 0)
		(if theCrib
			(if (theCrib size:)
				(theCrib release:)
			)
			(theCrib dispose:)
		)
		(Deck dispose:)
		(gDelayCast release:)
		(handleEventList release: dispose:)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 702)
		(DisposeScript 570)
		(super dispose:)
	)
)

(instance quitButton of TrackingView
	(properties
		x 80
		y 195
		view 21
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global748 0)
			((ScriptID 930 0) init: 22) ; yesNo
			(DisposeScript 930)
			(if global748
				(gGame quitGame:)
			)
		)
	)
)

(class Peg of Actor
	(properties
		view 500
		position 0
		whoGetsTheCue 0
	)

	(method (init)
		(gSound2 play: 503)
		(self cel: 0 ignoreActors: setPri: 13 moveSpeed: 0 setStep: 2 2 show:)
		(super init:)
	)

	(method (cue)
		(if (== position 121)
			(gSound play: (if (== (hand1 total:) 121) 304 else 303))
		)
		(if whoGetsTheCue
			(whoGetsTheCue cue:)
		)
	)
)

(instance peg1A of Peg
	(properties)

	(method (init)
		(self setLoop: 2 1 posn: [local41 0] [local44 0])
		(super init:)
		(= position 0)
	)

	(method (cue)
		(gSound2 play: 501)
		(super cue:)
	)
)

(instance peg2A of Peg
	(properties)

	(method (init)
		(self setLoop: 2 1 posn: [local41 1] [local44 1])
		(super init:)
		(= position -1)
	)

	(method (cue)
		(gSound2 play: 501)
		(super cue:)
	)
)

(instance peg3A of Peg
	(properties)

	(method (init)
		(self setLoop: 2 1 posn: [local41 2] [local44 2])
		(super init:)
		(= position 0)
	)

	(method (cue)
		(gSound2 play: 501)
		(super cue:)
	)
)

(instance peg1B of Peg
	(properties)

	(method (init)
		(self setLoop: 3 1 posn: [local47 0] [local50 0])
		(super init:)
		(= position 0)
	)

	(method (cue)
		(gSound2 play: 502)
		(super cue:)
	)
)

(instance peg2B of Peg
	(properties)

	(method (init)
		(self setLoop: 3 1 posn: [local47 1] [local50 1])
		(super init:)
		(= position -1)
	)

	(method (cue)
		(gSound2 play: 502)
		(super cue:)
	)
)

(instance peg3B of Peg
	(properties)

	(method (init)
		(self setLoop: 3 1 posn: [local47 2] [local50 2])
		(super init:)
		(= position 0)
	)

	(method (cue)
		(gSound2 play: 502)
		(super cue:)
	)
)

(class CribbageHand of Hand
	(properties
		gamesTotal 0
		cribsPlayed 0
		pointsPegged 0
		pointsInCrib 0
		pointsInHand 0
		opponentMin 1
		mugginsPointsLost 0
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(cond
			(gTray
				(if (gTray validPlay: param1)
					(self moveCard: gTray self)
					(RedrawCast)
					(cond
						((== (gTray size:) 1)
							(KeyMouse setCursor: (gTray theOkButton:))
						)
						(size
							(KeyMouse
								setCursor:
									(if param2
										param2
									else
										(self at: 0)
									)
							)
						)
					)
				)
			)
			((gTrick validPlay: param1 self)
				(self moveCard: gTrick)
				(RedrawCast)
				(if size
					(KeyMouse
						setCursor:
							(if param2
								param2
							else
								(self at: 0)
							)
					)
				)
			)
		)
	)

	(method (checkPoints)
		(= local14
			(+
				(= local14
					(+
						(= local14
							(+
								(= local14 (+ (= local14 0) (self check1531:)))
								(self checkPairs:)
							)
						)
						(self checkRuns:)
					)
				)
				(self checkLastCard:)
			)
		)
	)

	(method (check1531)
		(= local14 (= global486 0))
		(cond
			((== global493 15)
				(= global486 1)
				(= local14 2)
			)
			((== global493 31)
				(= global486 11)
				(= local14 2)
			)
		)
		(return local14)
	)

	(method (checkPairs &tmp temp0 temp1)
		(= local14 (= global487 0))
		(if
			(and
				(>= global490 2)
				(==
					(= temp1 ((gTrick at: (- (gTrick size:) 1)) rank:))
					((gTrick at: (- (gTrick size:) 2)) rank:)
				)
			)
			(= global487 2)
			(= local14 2)
			(if
				(and
					(>= global490 3)
					(== temp1 ((gTrick at: (- (gTrick size:) 3)) rank:))
				)
				(= global487 3)
				(= local14 6)
				(if
					(and
						(>= global490 4)
						(==
							temp1
							((gTrick at: (- (gTrick size:) 4)) rank:)
						)
					)
					(= global487 4)
					(= local14 12)
				)
			)
		)
		(return local14)
	)

	(method (checkLastCard)
		(= global489 0)
		(if (and (== (gTrick size:) 8) (!= global493 31))
			(= global489 15)
			(return 1)
		)
		(return 0)
	)

	(method (checkRuns &tmp temp0 temp1 temp2)
		(= local14 (= global488 0))
		(if (and (not global487) (>= global490 3))
			(= temp0 3)
			(= temp1 global490)
			(= temp2 0)
			(while (<= temp0 temp1)
				(if (self isARun: temp0)
					(= temp2 temp0)
				)
				(++ temp0)
			)
			(switch temp2
				(0
					(= global488 0)
					(= local14 0)
				)
				(3
					(= global488 5)
					(= local14 3)
				)
				(4
					(= global488 6)
					(= local14 4)
				)
				(5
					(= global488 7)
					(= local14 5)
				)
				(6
					(= global488 13)
					(= local14 6)
				)
				(7
					(= global488 14)
					(= local14 7)
				)
			)
		)
		(return local14)
	)

	(method (isARun param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		((= temp2 (List new:)) add:)
		(= temp1 0)
		(= temp5 0)
		(while (< temp1 param1)
			(temp2 add: (gTrick at: (- (- (gTrick size:) 1) temp1)))
			(+= temp5 ((gTrick at: (- (- (gTrick size:) 1) temp1)) rank:))
			(++ temp1)
		)
		(= temp1 0)
		(= temp3 0)
		(while (< temp1 (temp2 size:))
			(if (> ((temp2 at: temp1) rank:) temp3)
				(= temp3 ((temp2 at: temp1) rank:))
			)
			(++ temp1)
		)
		(= temp1 0)
		(= temp4 15)
		(while (< temp1 (temp2 size:))
			(if (< ((temp2 at: temp1) rank:) temp4)
				(= temp4 ((temp2 at: temp1) rank:))
			)
			(++ temp1)
		)
		(for ((= temp1 0)) (< temp1 (- (temp2 size:) 1)) ((++ temp1))
			(for ((= temp0 (+ temp1 1))) (< temp0 (temp2 size:)) ((++ temp0))
				(if (== ((temp2 at: temp1) rank:) ((temp2 at: temp0) rank:))
					(temp2 release: dispose:)
					(return 0)
				)
			)
		)
		(-= temp5 (* param1 temp4))
		(= temp6
			(switch param1
				(3 3)
				(4 6)
				(5 10)
				(6 15)
				(7 21)
			)
		)
		(temp2 release: dispose:)
		(if (== temp5 temp6)
			(return param1)
		)
		(return 0)
	)

	(method (movePeg param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 (if (>= argc 2) param2 else 0))
		(if
			(and
				(or
					(not param1)
					(>= (hand1 total:) 121)
					(>= (hand2 total:) 121)
				)
				(< argc 3)
			)
			(if temp2
				(temp2 cue:)
			)
			(return)
		)
		(if (>= argc 3)
			(= temp0 (if (== location 3) peg3A else peg3B))
			(temp0 position: (+ (temp0 position:) param1))
			(if (> (temp0 position:) 7)
				(temp0 position: 7)
			)
			(= gamesTotal (temp0 position:))
			(temp0 whoGetsTheCue: temp2)
			(if (== location 3)
				(temp0
					moveSpeed: 3
					setMotion:
						MoveTo
						[local541 (temp0 position:)]
						[local549 (temp0 position:)]
						temp0
				)
			else
				(temp0
					moveSpeed: 3
					setMotion:
						MoveTo
						[local557 (temp0 position:)]
						[local565 (temp0 position:)]
						temp0
				)
			)
		else
			(cond
				((== location 3)
					(if (< (peg1A position:) (peg2A position:))
						(= temp0 peg1A)
						(= temp1 peg2A)
					else
						(= temp0 peg2A)
						(= temp1 peg1A)
					)
				)
				((< (peg1B position:) (peg2B position:))
					(= temp0 peg1B)
					(= temp1 peg2B)
				)
				(else
					(= temp0 peg2B)
					(= temp1 peg1B)
				)
			)
			(temp0 position: (+ (temp1 position:) param1))
			(if (> (temp0 position:) 121)
				(temp0 position: 121)
			)
			(= total (temp0 position:))
			(temp0 whoGetsTheCue: temp2)
			(if (== location 3)
				(temp0
					setMotion:
						MoveTo
						[local53 (temp0 position:)]
						[local175 (temp0 position:)]
						temp0
				)
			else
				(temp0
					setMotion:
						MoveTo
						[local297 (temp0 position:)]
						[local419 (temp0 position:)]
						temp0
				)
			)
		)
	)

	(method (thinkCrib)
		(CribbageStrategy thinkCrib: self)
		(roomScript setScript: discardToCribScript)
	)

	(method (think &tmp temp0)
		(cond
			((= global458 (CribbageStrategy think: self global493))
				(self moveCard: gTrick)
			)
			(global492
				(gChar1 say: (+ 1000 (gChar1 view:)) 1 0 0 31)
				(= local2 1)
				(local18
					movePeg: 1 roomScript
					pointsPegged: (+ (local18 pointsPegged:) 1)
				)
			)
			(else
				(gChar1 say: (+ 1000 (gChar1 view:)) 1 0 0 31)
				(= global492 self)
				(= local18 local10)
				(roomScript cue:)
			)
		)
		(= gCrazy8sHand 0)
	)

	(method (cue)
		(super cue:)
		(if gTray
			(gTray setCard: global458)
		else
			(gTrick setCard: global458)
		)
		(= global395 0)
	)
)

(instance hand1 of CribbageHand
	(properties
		x 100
		y 154
		handNumber 3
		faceUp 1
		centerX 160
		centerY 175
	)
)

(instance hand2 of CribbageHand
	(properties
		x 100
		y 3
		type 1
		handNumber 1
		location 1
		centerX 135
		centerY 5
	)
)

(instance theHands of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance theCrib of Hand
	(properties)
)

(class CountCombos of Code
	(properties
		handList 0
		theHandScore 0
	)

	(method (doit param1 &tmp temp0)
		(= handList (List new:))
		(= theHandScore 0)
		(switch param1
			(hand1
				(for ((= temp0 0)) (< temp0 8) ((++ temp0))
					(if (> ((gTrick at: temp0) y:) 80)
						(handList add: (gTrick at: temp0))
					)
				)
				(handList add: (global419 topCard:))
			)
			(hand2
				(for ((= temp0 0)) (< temp0 8) ((++ temp0))
					(if (< ((gTrick at: temp0) y:) 80)
						(handList add: (gTrick at: temp0))
					)
				)
				(handList add: (global419 topCard:))
			)
			(theCrib
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(handList add: (theCrib at: temp0))
					((theCrib at: temp0) setPri: (+ temp0 2))
				)
				(handList add: (global419 topCard:))
			)
			(else
				(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
					(handList add: (param1 at: temp0))
				)
			)
		)
		(self calcScores: param1)
		(handList release: dispose:)
		(= handList 0)
		(if (!= local11 10)
			(= [local20 local11] 0)
		)
		(return theHandScore)
	)

	(method (calcScores param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= local11 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 5) ((++ temp1))
				(if (self fifteens: (handList at: temp0) (handList at: temp1))
					(= [local20 local11] 1)
					(+= theHandScore 2)
					(++ local11)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 4) ((++ temp1))
				(for ((= temp2 (+ temp1 1))) (< temp2 5) ((++ temp2))
					(if
						(self
							fifteens:
								(handList at: temp0)
								(handList at: temp1)
								(handList at: temp2)
						)
						(= [local20 local11] 1)
						(+= theHandScore 2)
						(++ local11)
					)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 3) ((++ temp1))
				(for ((= temp2 (+ temp1 1))) (< temp2 4) ((++ temp2))
					(for ((= temp3 (+ temp2 1))) (< temp3 5) ((++ temp3))
						(if
							(self
								fifteens:
									(handList at: temp0)
									(handList at: temp1)
									(handList at: temp2)
									(handList at: temp3)
							)
							(= [local20 local11] 1)
							(+= theHandScore 2)
							(++ local11)
						)
					)
				)
			)
		)
		(if
			(self
				fifteens:
					(handList at: 0)
					(handList at: 1)
					(handList at: 2)
					(handList at: 3)
					(handList at: 4)
			)
			(= [local20 local11] 1)
			(+= theHandScore 2)
			(++ local11)
		)
		(= temp4 0)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 3) ((++ temp1))
				(for ((= temp2 (+ temp1 1))) (< temp2 4) ((++ temp2))
					(for ((= temp3 (+ temp2 1))) (< temp3 5) ((++ temp3))
						(if
							(self
								pairs:
									(handList at: temp0)
									(handList at: temp1)
									(handList at: temp2)
									(handList at: temp3)
							)
							(= [local20 local11] 4)
							(+= theHandScore 12)
							(++ local11)
							(= temp4 1)
						)
					)
				)
			)
		)
		(if (not temp4)
			(= temp5 0)
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(for ((= temp1 (+ temp0 1))) (< temp1 4) ((++ temp1))
					(for ((= temp2 (+ temp1 1))) (< temp2 5) ((++ temp2))
						(if
							(self
								pairs:
									(handList at: temp0)
									(handList at: temp1)
									(handList at: temp2)
							)
							(= [local20 local11] 3)
							(+= theHandScore 6)
							(++ local11)
							(= temp5 ((handList at: temp0) rank:))
						)
					)
				)
			)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(for ((= temp1 (+ temp0 1))) (< temp1 5) ((++ temp1))
					(if
						(and
							(!= ((handList at: temp0) rank:) temp5)
							(self
								pairs: (handList at: temp0) (handList at: temp1)
							)
						)
						(= [local20 local11] 2)
						(+= theHandScore 2)
						(++ local11)
					)
				)
			)
		)
		(= temp4 0)
		(if
			(self
				runs:
					(handList at: 0)
					(handList at: 1)
					(handList at: 2)
					(handList at: 3)
					(handList at: 4)
			)
			(= [local20 local11] 7)
			(+= theHandScore 5)
			(++ local11)
			(= temp4 1)
		)
		(if (not temp4)
			(for ((= temp0 0)) (< temp0 2) ((++ temp0))
				(for ((= temp1 (+ temp0 1))) (< temp1 3) ((++ temp1))
					(for ((= temp2 (+ temp1 1))) (< temp2 4) ((++ temp2))
						(for ((= temp3 (+ temp2 1))) (< temp3 5) ((++ temp3))
							(if
								(self
									runs:
										(handList at: temp0)
										(handList at: temp1)
										(handList at: temp2)
										(handList at: temp3)
								)
								(= [local20 local11] 6)
								(+= theHandScore 4)
								(++ local11)
								(= temp4 1)
							)
						)
					)
				)
			)
		)
		(if (not temp4)
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(for ((= temp1 (+ temp0 1))) (< temp1 4) ((++ temp1))
					(for ((= temp2 (+ temp1 1))) (< temp2 5) ((++ temp2))
						(if
							(self
								runs:
									(handList at: temp0)
									(handList at: temp1)
									(handList at: temp2)
							)
							(= [local20 local11] 5)
							(+= theHandScore 3)
							(++ local11)
						)
					)
				)
			)
		)
		(cond
			(
				(self
					flushes:
						(handList at: 0)
						(handList at: 1)
						(handList at: 2)
						(handList at: 3)
						(handList at: 4)
				)
				(= [local20 local11] 9)
				(+= theHandScore 5)
				(++ local11)
			)
			(
				(and
					(!= param1 theCrib)
					(self
						flushes:
							(handList at: 0)
							(handList at: 1)
							(handList at: 2)
							(handList at: 3)
					)
				)
				(= [local20 local11] 8)
				(+= theHandScore 4)
				(++ local11)
			)
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(if (self nobs: (handList at: temp0) (handList at: 4))
				(= [local20 local11] 10)
				(+= theHandScore 1)
				(++ local11)
			)
		)
	)

	(method (fifteens param1 &tmp temp0 temp1 temp2)
		(= temp0 0)
		(for ((= temp2 0)) (< temp2 argc) ((++ temp2))
			(if (> (= temp1 ([param1 temp2] rank:)) 10)
				(= temp1 10)
			)
			(+= temp0 temp1)
		)
		(return (== temp0 15))
	)

	(method (pairs param1 &tmp temp0 temp1)
		(= temp0 ([param1 0] rank:))
		(for ((= temp1 1)) (< temp1 argc) ((++ temp1))
			(if (!= ([param1 temp1] rank:) temp0)
				(return 0)
			)
		)
		(return 1)
	)

	(method (runs param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp2 0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(+= temp2 ([param1 temp0] rank:))
		)
		(for ((= temp0 (= temp3 0))) (< temp0 argc) ((++ temp0))
			(if (> ([param1 temp0] rank:) temp3)
				(= temp3 ([param1 temp0] rank:))
			)
		)
		(= temp0 0)
		(= temp4 15)
		(while (< temp0 argc)
			(if (< ([param1 temp0] rank:) temp4)
				(= temp4 ([param1 temp0] rank:))
			)
			(++ temp0)
		)
		(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 argc) ((++ temp1))
				(if (== ([param1 temp0] rank:) ([param1 temp1] rank:))
					(return 0)
				)
			)
		)
		(-= temp2 (* argc temp4))
		(= temp5
			(switch argc
				(3 3)
				(4 6)
				(5 10)
			)
		)
		(if (== temp2 temp5)
			(return 1)
		)
		(return 0)
	)

	(method (flushes param1 &tmp temp0 temp1)
		(= temp0 ([param1 0] suit:))
		(for ((= temp1 1)) (< temp1 argc) ((++ temp1))
			(if (!= ([param1 temp1] suit:) temp0)
				(return 0)
			)
		)
		(return 1)
	)

	(method (nobs param1)
		(return
			(and
				(== ([param1 0] rank:) 11)
				(== ([param1 0] suit:) ([param1 1] suit:))
			)
		)
	)
)

(instance cribbage_opt of File
	(properties
		name {cribbage.opt}
	)

	(method (doit param1 &tmp temp0 [temp1 19] temp20 [temp21 10])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0
								format:
									{%d%d%2d%d%d}
									global251
									global252
									(gChar1 view:)
									(gChar1 loop:)
									gSkill
							)
						close:
					)
					(temp0 dispose:)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp20 (Str new:))
				(= global251
					((Str with: (self readString: temp20 2)) asInteger:)
				)
				(= global252
					((Str with: (self readString: temp20 2)) asInteger:)
				)
				(= global463
					((Str with: (self readString: temp20 3)) asInteger:)
				)
				(= global466
					((Str with: (self readString: temp20 2)) asInteger:)
				)
				(= global469
					((Str with: (self readString: temp20 2)) asInteger:)
				)
				(self close:)
				(temp20 dispose:)
				(return 0)
			)
			(else
				(= global251 0)
				(= global252 0)
				(= global463 2)
				(= global463 12)
				(= global466 2)
				(= global469 2)
				(return 0)
			)
		)
	)
)

(instance discardToCribScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global458 global483)
				(hand2 moveCard: theCrib self)
			)
			(1
				(theCrib add: global458)
				(global458 flip: (theCrib faceUp:) setPri: 2 show:)
				(= global458 global484)
				(hand2 moveCard: theCrib self)
			)
			(2
				((ScriptID 15 6) setCycle: 0 hide:) ; littleCard
				(theCrib add: global458)
				(global458 flip: (theCrib faceUp:) setPri: 2 show:)
				(= global395 0)
				(= ticks 10)
			)
			(3
				(roomScript setScript: 0 cue:)
			)
		)
	)
)

(class CribbageTrick of Trick
	(properties
		nsTop 95
		northY 62
		southY 108
		numCardsInATrick 9
	)

	(method (testPoints param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
		(+=
			global493
			(= temp1 (if (>= (= temp0 (param1 rank:)) 11) 10 else temp0))
		)
		(++ global490)
		(self add: param1 1)
		(if (>= argc 2)
			(+=
				global493
				(= temp2 (if (>= (= temp0 (param2 rank:)) 11) 10 else temp0))
			)
			(++ global490)
			(self add: param2 1)
		)
		(if (== argc 3)
			(+=
				global493
				(= temp3 (if (>= (= temp0 (param3 rank:)) 11) 10 else temp0))
			)
			(++ global490)
			(self add: param3 1)
		)
		(= temp4 ((Dealer curPlayer:) checkPoints:))
		(-- global490)
		(-= global493 temp1)
		(self delete: param1)
		(if (>= argc 2)
			(-= global493 temp2)
			(-- global490)
			(self delete: param2)
		)
		(if (== argc 3)
			(-= global493 temp3)
			(-- global490)
			(self delete: param3)
		)
		(return temp4)
	)

	(method (endTrick &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((ScriptID 15 1) add: (self at: temp0)) ; discardList
			((self at: temp0) hide:)
		)
		(self release:)
		(= highOfSuitLead (= highTrump 0))
		(= leader highPlayer)
		(= highCard 0)
		(= suitLead -1)
	)

	(method (validPlay param1 param2 param3)
		(if
			(>
				(+
					global493
					(if (> (param1 rank:) 10)
						10
					else
						(param1 rank:)
					)
				)
				31
			)
			(= param3 (param1 signal:))
			(gSound play: 904)
			(gChar1 say: 500 (+ (gChar1 view:) 1) 61 0 1 0 0)
			(return 0)
		)
		(return 1)
	)

	(method (calcNextX)
		(return (+ nsLeft 15 (* size 8)))
	)

	(method (calcNextY)
		(return
			(switch ((Dealer curPlayer:) location:)
				(1 northY)
				(3 southY)
			)
		)
	)

	(method (setCard param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (Str new:))
		(= temp4 0)
		(DisableCursor)
		(= local10 (Dealer curPlayer:))
		(+=
			global493
			(if (> (param1 rank:) 10)
				10
			else
				(param1 rank:)
			)
		)
		(countNumber init:)
		(++ global490)
		(= global291 (+ 2 size))
		(param1
			flip: 1
			posn: (self calcNextX:) (self calcNextY:)
			loop: 0
			setPri: (+ 2 size)
			show:
		)
		(self add: param1)
		(RedrawCast)
		(if (== size 8)
			(= local598 0)
		)
		(if (= local14 ((Dealer curPlayer:) checkPoints:))
			(= local593 0)
			(= [local594 0] 0)
			(= [local594 1] 0)
			(= [local594 2] 0)
			(= [local594 3] 0)
			(if global486
				(= temp2
					(switch global486
						(11 38)
						(1 27)
					)
				)
				(Message msgGET 500 0 temp2 0 1 (local599 data:))
				(local600 cat: local599)
				(switch global486
					(11
						(= [local594 local593] 23)
						(++ local593)
					)
					(1
						(= [local594 local593] 22)
						(++ local593)
					)
				)
			)
			(if global487
				(= temp2
					(switch global487
						(2 30)
						(3 31)
						(4 26)
					)
				)
				(Message msgGET 500 0 temp2 0 1 (local599 data:))
				(if global486
					(local600 cat: local601)
					(++ local602)
				)
				(local600 cat: local599)
				(switch global487
					(2
						(= [local594 local593] 24)
						(++ local593)
					)
					(3
						(= [local594 local593] 24)
						(++ local593)
						(= [local594 local593] 25)
						(++ local593)
						(= temp4 3)
					)
					(4
						(= [local594 local593] 24)
						(++ local593)
						(= [local594 local593] 25)
						(++ local593)
						(= temp4 4)
					)
				)
			)
			(if global488
				(= temp2
					(switch global488
						(5 32)
						(6 33)
						(7 34)
						(13 35)
						(14 36)
					)
				)
				(Message msgGET 500 0 temp2 0 1 (local599 data:))
				(if (or global486 global487)
					(local600 cat: local601)
					(++ local602)
				)
				(local600 cat: local599)
				(= [local594 local593] 26)
				(++ local593)
				(switch global488
					(5
						(= [local594 local593] 14)
						(++ local593)
					)
					(6
						(= [local594 local593] 15)
						(++ local593)
					)
					(7
						(= [local594 local593] 16)
						(++ local593)
					)
					(13
						(= [local594 local593] 17)
						(++ local593)
						(= temp4 13)
					)
					(14
						(= [local594 local593] 18)
						(++ local593)
						(= temp4 14)
					)
				)
			)
			(if global489
				(Message msgGET 500 0 28 0 1 (local599 data:)) ; "Last Card: 1"
				(if (or global486 global487 global488)
					(local600 cat: local601)
					(++ local602)
				)
				(local600 cat: local599)
				(gStr cat: temp1)
				(if (and global486 (or global487 global488))
					(= temp4 999)
				)
				(= [local594 local593] 33)
				(++ local593)
			)
			(= local15 1)
			(if (and temp4 (or (!= temp4 3) (not (Random 0 3))))
				(if (== ((Dealer curPlayer:) location:) 3)
					(gChar1
						say: (+ 1000 (gChar1 view:)) 1 23 0 (Random 3 5) 713
					)
				else
					(gChar1
						say: (+ 1000 (gChar1 view:)) 1 23 0 (Random 1 2) 711
					)
				)
			)
		else
			(= local15 0)
		)
		(= local19 (== global493 31))
		(roomScript cue:)
		(if temp1
			(temp1 dispose:)
		)
	)
)

(instance goButton of TrackingView
	(properties
		x 72
		y 120
		view 500
		loop 1
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (and local598 (not local17) (super handleEvent: event))
			(event claimed: 1)
			(= temp1 0)
			(for ((= temp0 0)) (< temp0 (hand1 size:)) ((++ temp0))
				(if
					(<=
						(+
							global493
							(if (> ((hand1 at: temp0) rank:) 10)
								10
							else
								((hand1 at: temp0) rank:)
							)
						)
						31
					)
					(= temp1 1)
					(break)
				)
			)
			(if temp1
				(gSound play: 904)
				(gChar1 say: 500 (+ (gChar1 view:) 1) 62 0 1 0 0)
			else
				(hand2 opponentMin: (- 32 global493))
				(if global492
					(= local2 1)
					(= local17 1)
					(local18
						movePeg: 1 roomScript
						pointsPegged: (+ (local18 pointsPegged:) 1)
					)
				else
					(= global492 hand1)
					(= local17 1)
					(= local18 local10)
					(roomScript cue:)
				)
			)
		)
		(event claimed:)
	)
)

(instance handScorePanel of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 (= temp4 0))
		(= local6 (if (== (Dealer dealer:) hand1) 0 else 49))
		(= local7 220)
		(= local8 (+ local6 (CelHigh 501 0 0)))
		(= local9 (+ local7 (CelWide 501 0 0)))
		((Dealer curPlayer:) tempTotal: 0)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(if [local20 temp0]
				(scoreBoard
					view: 501
					setLoop: 0
					cel: 0
					posn: local7 (- local6 2)
					setPri: 12
					show:
					init:
				)
				(proc0_10
					501
					[local20 temp0]
					0
					(+ local7 65)
					(+ local6 5 (* temp0 12))
					14
					0
					{score}
				)
				(= temp2 [local20 temp0])
				((Dealer curPlayer:)
					tempTotal:
						(+ ((Dealer curPlayer:) tempTotal:) [local30 temp2])
				)
				(localproc_0
					((Dealer curPlayer:) tempTotal:)
					(+ local7 72)
					(+ local6 5 (* temp0 12))
				)
			else
				(if (== temp0 0)
					(scoreBoard
						view: 501
						setLoop: 0
						cel: 0
						posn: local7 local6
						setPri: 12
						show:
						init:
					)
					(proc0_10 501 13 0 (+ local7 55) (+ local6 55) 14 0 {score})
					(= temp3 1)
				)
				(break)
			)
		)
		(scoreOKButton
			posn: (+ local7 9) (+ local6 125)
			setPri: 13
			ignoreActors:
			show:
			init:
			addKeyMouse:
		)
		(if (not (HaveMouse))
			(KeyMouse setCursor: scoreOKButton)
		)
		(handleEventList add: scoreOKButton)
		(EnableCursor)
		(proc0_7)
		(if temp3
			(gSound play: 504)
			(if (== ((Dealer curPlayer:) location:) 3)
				(gChar1
					say: (+ 1000 (gChar1 view:)) 1 23 0 (Random 1 2) 711
				)
			else
				(gChar1
					say: (+ 1000 (gChar1 view:)) 1 23 0 (Random 4 5) 713
				)
			)
		)
		(if (>= ((Dealer curPlayer:) tempTotal:) 16)
			(gSound play: 506)
			(if (== ((Dealer curPlayer:) location:) 3)
				(gChar1
					say: (+ 1000 (gChar1 view:)) 1 23 0 (Random 3 5) 713
				)
			else
				(gChar1
					say: (+ 1000 (gChar1 view:)) 1 23 0 (Random 1 2) 711
				)
			)
		)
		((Dealer curPlayer:) tempTotal:)
	)

	(method (dispose)
		(scoreOKButton hide: deleteKeyMouse:)
		(disposeScores doit:)
		(= global406 0)
		(handleEventList delete: scoreOKButton)
		(roomScript cue:)
	)
)

(instance scoreOKButton of TrackingView
	(properties
		view 501
		loop 12
		offsetX 53
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (super handleEvent: event)
			(event claimed: 1)
			(handScorePanel dispose:)
			(scoreBoard dispose:)
		)
		(event claimed:)
	)
)

(instance maskOutOfPlayCards of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (gTrick size:)) ((++ temp0))
			(= temp1
				(switch temp0
					(0 mask0)
					(1 mask1)
					(2 mask2)
					(3 mask3)
					(4 mask4)
					(5 mask5)
					(6 mask6)
					(7 mask7)
				)
			)
			(maskCard doit: (gTrick at: temp0) temp1)
		)
		(= global490 0)
	)

	(method (dispose)
		(mask0 dispose:)
		(mask1 dispose:)
		(mask2 dispose:)
		(mask3 dispose:)
		(mask4 dispose:)
		(mask5 dispose:)
		(mask6 dispose:)
		(mask7 dispose:)
	)
)

(instance maskCard of Code
	(properties)

	(method (doit param1 param2)
		(param2
			view: 500
			setLoop: 4
			cel: 0
			posn: (param1 x:) (param1 y:)
			setPri: (+ (param1 priority:) 1)
			show:
			init:
		)
	)
)

(instance mask0 of View
	(properties)
)

(instance mask1 of View
	(properties)
)

(instance mask2 of View
	(properties)
)

(instance mask3 of View
	(properties)
)

(instance mask4 of View
	(properties)
)

(instance mask5 of View
	(properties)
)

(instance mask6 of View
	(properties)
)

(instance mask7 of View
	(properties)
)

(instance countBox of View
	(properties)

	(method (init)
		(self
			view: 500
			setLoop: 7
			cel: 0
			posn: 72 50
			setPri: 12
			ignoreActors:
			show:
		)
		(super init:)
	)
)

(instance countNumber of View
	(properties)

	(method (init)
		(self
			view: 500
			setLoop: (if (<= global493 15) 5 else 6)
			cel: (mod global493 16)
			posn: (+ (countBox x:) 5) (+ (countBox y:) 5)
			setPri: 13
			ignoreActors:
			show:
		)
		(super init:)
	)
)

(instance cribbageBoard of View
	(properties)

	(method (init)
		(self view: 502 setLoop: 0 cel: 0 posn: 0 0 setPri: 8 show:)
		(super init:)
	)
)

(instance cribbageBoard2 of View
	(properties)

	(method (init)
		(self view: 502 setLoop: 0 cel: 1 posn: 0 100 setPri: 8 show:)
		(super init:)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2 [temp3 3] temp6 temp7 [temp8 100])
		(switch (= state newState)
			(0
				(DisableCursor)
				(= ticks 1)
			)
			(1
				(if local0
					(RedrawCast)
					(EnableCursor)
					((ScriptID 590 0) init:) ; optionCribbage
					(DisableCursor)
				)
				(quitButton init:)
				(gSong fade:)
				(Dealer init: hand1 hand2)
				(= ticks 1)
			)
			(2
				(peg3A init:)
				(peg3B init:)
				(= global402 0)
				(hand1
					cribsPlayed: 0
					pointsPegged: 0
					pointsInCrib: 0
					pointsInHand: 0
					mugginsPointsLost: 0
					gamesTotal: 0
				)
				(hand2
					cribsPlayed: 0
					pointsPegged: 0
					pointsInCrib: 0
					pointsInHand: 0
					mugginsPointsLost: 0
					gamesTotal: 0
				)
				(= ticks 1)
			)
			(3
				(peg1A init:)
				(peg2A init:)
				(peg1B init:)
				(peg2B init:)
				(gTheHands
					eachElementDo: #total 0
					eachElementDo: #prevTotal 0
					eachElementDo: #handTotal 0
					eachElementDo: #tempTotal 0
				)
				(= ticks 1)
			)
			(4
				(gTrick
					tricksPlayed: 0
					northPlayer: hand2
					southPlayer: hand1
					eastPlayer: 0
					westPlayer: 0
				)
				(hand1 opponentMin: 1)
				(hand2 opponentMin: 1)
				(Dealer playDirection: 0 deal: self)
			)
			(5
				(if (== (Dealer dealer:) hand1)
					(global419 x: 210 y: 150)
				else
					(global419 x: 210 y: 1)
				)
				(global419 active: 0 loop: 1 init:)
				(gTheHands eachElementDo: #tempTotal 0)
				(hand1 sort:)
				(hand1 eachElementDo: #addKeyMouse)
				(= cycles 1)
			)
			(6
				(theCrib
					x: 229
					y:
						(if (== (Dealer dealer:) hand1)
							(hand1 y:)
						else
							(hand2 y:)
						)
				)
				(Arrow x: 80 y: 85 init:)
				(= global492 0)
				(= local18 0)
				(= local2 0)
				(= global493 0)
				(= global116 0)
				(handleEventList add: quitButton)
				(handleEventList add: hand1 hand2 theCrib global419)
				(= cycles 1)
			)
			(7
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) thinkCrib:)
				else
					(Tray x: 170 y: 63 init: handleEventList self theCrib)
					(EnableCursor)
				)
			)
			(8
				(DisableCursor)
				(if (== ((Dealer curPlayer:) type:) 0)
					((ScriptID 15 6) ; littleCard
						init:
						show:
						posn: 240 90
						setStep: 10 10
						setMotion:
							MoveTo
							(+ (theCrib calcNextX:) 17)
							(+ (theCrib calcNextY:) 21)
							self
						setCycle: Fwd
					)
				else
					(= cycles 1)
				)
			)
			(9
				(if (== ((Dealer curPlayer:) type:) 0)
					(theCrib add: global483)
					(theCrib add: global484)
					((ScriptID 15 6) setMotion: 0 hide:) ; littleCard
					(theCrib
						eachElementDo: #flip (theCrib faceUp:)
						eachElementDo: #show
					)
				)
				(if (< (theCrib size:) 4)
					(-= state 3)
					(= cycles 1)
				else
					(= ticks 45)
				)
				(if (== (theCrib size:) 4)
					(for ((= temp2 0)) (< temp2 4) ((++ temp2))
						((theCrib at: temp2) setPri: (+ temp2 2))
					)
				)
				(Dealer nextToPlay:)
			)
			(10
				(handleEventList add: goButton)
				(goButton init: show: addKeyMouse:)
				(= local598 1)
				(global419 flip: 1)
				(countBox init:)
				(countNumber init:)
				(EnableCursor)
				(Piles add: gTrick)
				(= global490 0)
				(if (== ((global419 topCard:) rank:) 11)
					(RedrawCast)
					(gChar1 say: 500 22 0 0 1 0 0)
					(gSound play: 503)
					((Dealer dealer:)
						movePeg: 2 roomScript
						pointsPegged: (+ ((Dealer dealer:) pointsPegged:) 2)
					)
				else
					(= ticks
						(if (== ((Dealer curPlayer:) type:) 1)
							(* global386 3)
						else
							1
						)
					)
				)
			)
			(11
				(= local3 0)
				(= local17 0)
				(if (or (== (hand1 total:) 121) (== (hand2 total:) 121))
					(= state 36)
					(= ticks 1)
					(return)
				)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) think:)
				else
					(EnableCursor)
				)
			)
			(12
				(= local16 0)
				(if
					(and
						global252
						(== ((Dealer curPlayer:) type:) 0)
						(or (!= global490 1) (== (gTrick size:) 8))
						(not local17)
					)
					((ScriptID 504 0) init:) ; muggins1Input
					(DisposeScript 504)
					(if (!= global491 local14)
						(= temp2 (Abs (- global491 local14)))
						(if (> local14 global491)
							(= local14 global491)
						)
						(gSound play: 504)
						(gChar1 say: (+ 1000 (gChar1 view:)) 1 0 0 28)
						(= local16 1)
						(((Dealer curPlayer:) partner:)
							movePeg: temp2 roomScript
						)
						((Dealer curPlayer:)
							mugginsPointsLost:
								(+
									((Dealer curPlayer:) mugginsPointsLost:)
									temp2
								)
						)
					else
						(= ticks 1)
					)
				else
					(= ticks 1)
				)
			)
			(13
				(DisableCursor)
				(if local15
					(if (== ((Dealer curPlayer:) type:) 1)
						(cribPrint addText: (local600 data:))
						(cribPrint showSelf:)
						(local600 dispose:)
						(= local600 (Str new:))
						(= local15 0)
					else
						(cribPrint addText: (local600 data:))
						(cribPrint showSelf:)
						(local600 dispose:)
						(= local600 (Str new:))
						(= local15 0)
					)
					(if
						(and
							(!= (Dealer curPlayer:) hand2)
							(or local16 (not global252))
						)
						(gSound play: 503)
					)
					((Dealer curPlayer:)
						pointsPegged:
							(+ ((Dealer curPlayer:) pointsPegged:) local14)
						movePeg: local14 roomScript
					)
				else
					(= ticks 1)
				)
			)
			(14
				(cond
					((== (gTrick size:) 8)
						(Dealer nextToPlay: (Dealer dealer:))
						(Dealer nextToPlay:)
					)
					(
						(or
							(== global493 31)
							local2
							(and
								global492
								(not (((Dealer curPlayer:) partner:) size:))
							)
						)
						(maskOutOfPlayCards doit:)
						(if global492
							(Dealer nextToPlay: global492)
							(if (not (global492 size:))
								(Dealer nextToPlay:)
							)
						else
							(Dealer nextToPlay:)
						)
						(= local2 0)
						(= global493 0)
						(countNumber init:)
						(if
							(and
								(not local19)
								global492
								(not (((Dealer curPlayer:) partner:) size:))
							)
							(local18
								pointsPegged: (+ (local18 pointsPegged:) 1)
								movePeg: 1 roomScript
							)
							(if (!= (gTrick size:) 8)
								(-= state 4)
							)
							(= global492 0)
							(return)
						)
						(= global492 0)
					)
					(global492
						(if (not ((Dealer curPlayer:) size:))
							(Dealer nextToPlay: global492)
							(maskOutOfPlayCards doit:)
							(= global493 0)
							(= global492 0)
							(= local2 0)
							(countNumber init:)
							(if (not local19)
								(local18
									pointsPegged: (+ (local18 pointsPegged:) 1)
									movePeg: 1 roomScript
								)
							)
							(if (!= (gTrick size:) 8)
								(-= state 4)
							)
							(return)
						else
							(Dealer nextToPlay: global492)
							(Dealer nextToPlay:)
						)
					)
					(else
						(Dealer nextToPlay:)
						(if (not ((Dealer curPlayer:) size:))
							(Dealer nextToPlay:)
						)
					)
				)
				(if (!= (gTrick size:) 8)
					(-= state 4)
				)
				(= ticks
					(if (== ((Dealer curPlayer:) type:) 1)
						(* global386 3)
					else
						1
					)
				)
			)
			(15
				(Piles delete: gTrick)
				(EnableCursor)
				(handleEventList delete: hand1 hand2 theCrib global419)
				(= ticks 1)
			)
			(16
				(handleEventList delete: goButton)
				(goButton hide: deleteKeyMouse:)
				(countBox dispose:)
				(countNumber dispose:)
				(maskOutOfPlayCards dispose:)
				(= ticks 1)
			)
			(17
				(Dealer nextToPlay: ((Dealer dealer:) partner:))
				(for ((= temp2 0)) (< temp2 8) ((++ temp2))
					(= temp6
						(switch temp2
							(0 mask0)
							(1 mask1)
							(2 mask2)
							(3 mask3)
							(4 mask4)
							(5 mask5)
							(6 mask6)
							(7 mask7)
						)
					)
					(cond
						((== ((Dealer dealer:) partner:) hand1)
							(if (< ((gTrick at: temp2) y:) 80)
								(maskCard doit: (gTrick at: temp2) temp6)
							)
						)
						((> ((gTrick at: temp2) y:) 80)
							(maskCard doit: (gTrick at: temp2) temp6)
						)
					)
				)
				(= ticks 1)
			)
			(18
				(if (or (>= (hand1 total:) 121) (>= (hand2 total:) 121))
					(= state 36)
					(= ticks 1)
					(return)
				)
				(= local13 0)
				(if
					(and
						(== global252 1)
						(== (((Dealer dealer:) partner:) type:) 0)
					)
					((ScriptID 504 0) init:) ; muggins1Input
					(DisposeScript 504)
					(= local12 global491)
					(= local4 (CountCombos doit: ((Dealer dealer:) partner:)))
					(if (!= local12 local4)
						(= local13 (Abs (- local12 local4)))
						(if (> local12 local4)
							(= local12 local4)
						)
						(gSound play: 504)
						(gChar1 say: (+ 1000 (gChar1 view:)) 1 0 0 28)
						(((Dealer dealer:) partner:)
							mugginsPointsLost:
								(+
									(((Dealer dealer:) partner:)
										mugginsPointsLost:
									)
									local13
								)
						)
						((Dealer dealer:) movePeg: local13 roomScript)
					else
						(= ticks 1)
					)
				else
					(CountCombos doit: ((Dealer dealer:) partner:))
					(= local12 (handScorePanel init:))
				)
			)
			(19
				(if local13
					(handScorePanel init:)
				else
					(= ticks 1)
				)
			)
			(20
				(((Dealer dealer:) partner:)
					pointsInHand:
						(+ (((Dealer dealer:) partner:) pointsInHand:) local12)
					movePeg: local12 roomScript
				)
			)
			(21
				(maskOutOfPlayCards dispose:)
				(for ((= temp2 0)) (< temp2 8) ((++ temp2))
					(= temp6
						(switch temp2
							(0 mask0)
							(1 mask1)
							(2 mask2)
							(3 mask3)
							(4 mask4)
							(5 mask5)
							(6 mask6)
							(7 mask7)
						)
					)
					(cond
						((== (Dealer dealer:) hand1)
							(if (< ((gTrick at: temp2) y:) 80)
								(maskCard doit: (gTrick at: temp2) temp6)
							)
						)
						((> ((gTrick at: temp2) y:) 80)
							(maskCard doit: (gTrick at: temp2) temp6)
						)
					)
				)
				(Dealer nextToPlay: (Dealer dealer:))
				(= ticks 10)
			)
			(22
				(if (or (== (hand1 total:) 121) (== (hand2 total:) 121))
					(= state 36)
					(= ticks 1)
					(return)
				)
				(= local13 0)
				(if (and (== global252 1) (== ((Dealer dealer:) type:) 0))
					((ScriptID 504 0) init:) ; muggins1Input
					(DisposeScript 504)
					(= local12 global491)
					(= local4 (CountCombos doit: (Dealer dealer:)))
					(if (!= local12 local4)
						(= local13 (Abs (- local12 local4)))
						(if (> local12 local4)
							(= local12 local4)
						)
						(gSound play: 504)
						(gChar1 say: (+ 1000 (gChar1 view:)) 1 0 0 28)
						((Dealer dealer:)
							mugginsPointsLost:
								(+
									((Dealer dealer:) mugginsPointsLost:)
									local13
								)
						)
						(((Dealer dealer:) partner:)
							movePeg: local13 roomScript
						)
					else
						(= ticks 1)
					)
				else
					(CountCombos doit: (Dealer dealer:))
					(= local12 (handScorePanel init:))
				)
			)
			(23
				(if local13
					(handScorePanel init:)
				else
					(= ticks 1)
				)
			)
			(24
				((Dealer dealer:)
					pointsInHand: (+ ((Dealer dealer:) pointsInHand:) local12)
					movePeg: local12 roomScript
				)
			)
			(25
				(maskCard
					doit: (gTrick at: 0) mask0
					doit: (gTrick at: 1) mask1
					doit: (gTrick at: 2) mask2
					doit: (gTrick at: 3) mask3
					doit: (gTrick at: 4) mask4
					doit: (gTrick at: 5) mask5
					doit: (gTrick at: 6) mask6
					doit: (gTrick at: 7) mask7
				)
				(theCrib eachElementDo: #flip 1)
				(= ticks 10)
			)
			(26
				(if (or (>= (hand1 total:) 121) (>= (hand2 total:) 121))
					(= state 36)
					(= ticks 1)
					(return)
				)
				(= local13 0)
				(if (and (== global252 1) (== ((Dealer dealer:) type:) 0))
					((ScriptID 504 0) init:) ; muggins1Input
					(DisposeScript 504)
					(= local12 global491)
					(= local4 (CountCombos doit: theCrib))
					(if (!= local12 local4)
						(= local13 (Abs (- local12 local4)))
						(if (> local12 local4)
							(= local12 local4)
						)
						(gSound play: 504)
						(gChar1 say: (+ 1000 (gChar1 view:)) 1 0 0 28)
						((Dealer dealer:)
							mugginsPointsLost:
								(+
									((Dealer dealer:) mugginsPointsLost:)
									local13
								)
						)
						(((Dealer dealer:) partner:)
							movePeg: local13 roomScript
						)
					else
						(= ticks 1)
					)
				else
					(CountCombos doit: theCrib)
					(= local12 (handScorePanel init:))
				)
			)
			(27
				(if local13
					(handScorePanel init:)
				else
					(= ticks 1)
				)
			)
			(28
				((Dealer dealer:)
					pointsInCrib: (+ ((Dealer dealer:) pointsInCrib:) local12)
					movePeg: local12 roomScript
				)
			)
			(29
				((Dealer dealer:)
					cribsPlayed: (+ ((Dealer dealer:) cribsPlayed:) 1)
				)
				(++ global402)
				(if (or (>= (hand1 total:) 121) (>= (hand2 total:) 121))
					(= state 36)
					(= ticks 1)
					(return)
				else
					(= ticks 60)
				)
			)
			(30
				(goButton hide: deleteKeyMouse:)
				(countBox dispose:)
				(countNumber dispose:)
				(maskOutOfPlayCards dispose:)
				(gTrick endTrick:)
				(hand1 endHand:)
				(hand2 endHand:)
				(for ((= temp2 0)) (< temp2 4) ((++ temp2))
					((ScriptID 15 1) add: (theCrib at: temp2)) ; discardList
					((theCrib at: temp2) hide:)
				)
				(theCrib release:)
				(global419 endHand:)
				(Arrow endHand:)
				(= ticks 1)
			)
			(31
				(if (and (< (hand1 total:) 121) (< (hand2 total:) 121))
					(= state 3)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 6)
				)
				(= ticks 1)
			)
			(32
				(= ticks 1)
			)
			(33
				(= ticks 1)
			)
			(34
				(if (and (< (hand1 gamesTotal:) 7) (< (hand2 gamesTotal:) 7))
					(= state 2)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 6)
				)
				(= ticks 1)
			)
			(35
				(= global748 0)
				((ScriptID 930 0) init: 570) ; yesNo
				(DisposeScript 930)
				(if global748
					(= state 1)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 6)
				)
				(= ticks 1)
			)
			(36
				(gGame quitGame:)
			)
			(37
				(EnableCursor)
				(Piles delete: gTrick)
				(handleEventList release:)
				(hand2 eachElementDo: #flip 1)
				(theCrib eachElementDo: #flip 1)
				(= ticks 1)
			)
			(38
				(= temp7 1)
				(if (> (hand1 total:) (hand2 total:))
					(if (> (hand1 total:) (+ (hand2 total:) 30))
						(gChar1
							say:
								(+ 1000 (gChar1 view:))
								1
								23
								0
								(Random 4 5)
								713
						)
						(++ temp7)
						(if (> (hand1 total:) (+ (hand2 total:) 60))
							(+= temp7 2)
						)
					)
					(hand1 movePeg: temp7 roomScript 1)
				else
					(if (> (hand2 total:) (+ (hand1 total:) 30))
						(gChar1
							say:
								(+ 1000 (gChar1 view:))
								1
								23
								0
								(Random 1 2)
								711
						)
						(++ temp7)
						(if (> (hand2 total:) (+ (hand1 total:) 60))
							(+= temp7 2)
						)
					)
					(hand2 movePeg: temp7 roomScript 1)
				)
			)
			(39
				(if (>= (hand1 total:) 121)
					(gChar1 say: 500 (+ (gChar1 view:) 1) 63 0 1 0 0)
				else
					(gChar1 say: 500 (+ (gChar1 view:) 1) 64 0 1 0 0)
				)
				(= ticks 1)
			)
			(40
				(if (and (< (hand1 gamesTotal:) 7) (< (hand2 gamesTotal:) 7))
					(gChar1 say: 500 21 0 0 1 0 0)
				else
					(gChar1 say: 500 19 66 0 1 0 0)
				)
				(= state 29)
				(= ticks 60)
			)
		)
	)
)

(instance scoreBoard of View
	(properties)

	(method (init)
		(self view: 501 setLoop: 0 cel: 0 show:)
		(super init:)
	)
)

(instance cribPrint of Print
	(properties
		x 190
		y 110
		ticks 200
	)

	(method (addText)
		(if (== ((Dealer curPlayer:) type:) 1)
			(self posn: 110 40)
		else
			(self posn: 190 110)
		)
		(if (> local602 0)
			(self addBitmap: 25 1 0)
		else
			(self addBitmap: 25 0 0)
		)
		(= local602 0)
		(self ticks: 200)
		(self fore: 0)
		(super addText: &rest)
	)
)

(instance disposeScores of Code
	(properties)

	(method (doit &tmp temp0)
		(for ((= temp0 (- (gCast size:) 1))) (>= temp0 0) ((-- temp0))
			(if (== ((gCast at: temp0) name:) {score})
				((gCast at: temp0) dispose:)
			)
		)
	)
)

