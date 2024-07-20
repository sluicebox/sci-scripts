;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1100)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use h5Messager)
(use theTitle)
(use ChipsPlane)
(use Str)
(use Array)
(use Print)
(use IconBar)
(use Timer)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	pokerRoom 0
	proc1100_1 1
	theChipPiles 2
	potPile 3
	float1 4
	float1b 5
	float2 6
	float2b 7
	float3 8
	float3b 9
	float4 10
	float4b 11
	proc1100_12 12
	theHands 13
	proc1100_14 14
	proc1100_15 15
	proc1100_16 16
	float1c 17
	float2c 18
	float3c 19
	float4c 20
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 10] = [104 105 106 107 110 108 80 109 112 111]
	[local16 4]
	[local20 4]
	[local24 4]
	[local28 4]
	local32
	local33
	local34
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 (Str format: {PENGIN16.DLL}))
	(global900 at: 0 2)
	(global900
		at:
			8
			(hand1 lastPlay:)
			(hand2 lastPlay:)
			(hand3 lastPlay:)
			(hand4 lastPlay:)
	)
	(if (hand1 stillInGame:)
		(global900 at: 19 ((hand1 at: 0) rank:) ((hand1 at: 0) suit:))
		(global900 at: 21 ((hand1 at: 1) rank:) ((hand1 at: 1) suit:))
		(global900 at: 23 ((hand1 at: 2) rank:) ((hand1 at: 2) suit:))
		(global900 at: 25 ((hand1 at: 3) rank:) ((hand1 at: 3) suit:))
		(global900 at: 27 ((hand1 at: 4) rank:) ((hand1 at: 4) suit:))
	)
	(if (hand2 stillInGame:)
		(global900 at: 29 ((hand2 at: 0) rank:) ((hand2 at: 0) suit:))
		(global900 at: 31 ((hand2 at: 1) rank:) ((hand2 at: 1) suit:))
		(global900 at: 33 ((hand2 at: 2) rank:) ((hand2 at: 2) suit:))
		(global900 at: 35 ((hand2 at: 3) rank:) ((hand2 at: 3) suit:))
		(global900 at: 37 ((hand2 at: 4) rank:) ((hand2 at: 4) suit:))
	)
	(if (hand3 stillInGame:)
		(global900 at: 39 ((hand3 at: 0) rank:) ((hand3 at: 0) suit:))
		(global900 at: 41 ((hand3 at: 1) rank:) ((hand3 at: 1) suit:))
		(global900 at: 43 ((hand3 at: 2) rank:) ((hand3 at: 2) suit:))
		(global900 at: 45 ((hand3 at: 3) rank:) ((hand3 at: 3) suit:))
		(global900 at: 47 ((hand3 at: 4) rank:) ((hand3 at: 4) suit:))
	)
	(if (hand4 stillInGame:)
		(global900 at: 49 ((hand4 at: 0) rank:) ((hand4 at: 0) suit:))
		(global900 at: 51 ((hand4 at: 1) rank:) ((hand4 at: 1) suit:))
		(global900 at: 53 ((hand4 at: 2) rank:) ((hand4 at: 2) suit:))
		(global900 at: 55 ((hand4 at: 3) rank:) ((hand4 at: 3) suit:))
		(global900 at: 57 ((hand4 at: 4) rank:) ((hand4 at: 4) suit:))
	)
	(if (== (WinDLL 2 (temp2 data:) (global900 data:)) 0)
		(Printf {Error calling DLL})
	)
	(switch (= temp1 (global900 at: 62))
		(1
			(hand1 total: (+ (potPile total:) (hand1 total:)))
			(potPile play: (potPile total:) hand1Pile)
		)
		(2
			(hand2 total: (+ (potPile total:) (hand2 total:)))
			(potPile play: (potPile total:) hand2Pile)
		)
		(3
			(= temp3 (* (/ (/ (potPile total:) 5) 2) 5))
			(= temp4 (- (potPile total:) temp3))
			(potPile play: temp3 hand2Pile)
			(hand2 total: (+ temp3 (hand2 total:)))
			(potPile play: temp4 hand1Pile)
			(hand1 total: (+ temp4 (hand1 total:)))
		)
		(4
			(hand3 total: (+ (potPile total:) (hand3 total:)))
			(potPile play: (potPile total:) hand3Pile)
		)
		(5
			(= temp3 (* (/ (/ (potPile total:) 5) 2) 5))
			(= temp4 (- (potPile total:) temp3))
			(potPile play: temp3 hand3Pile)
			(hand3 total: (+ temp3 (hand3 total:)))
			(potPile play: temp4 hand1Pile)
			(hand1 total: (+ temp4 (hand1 total:)))
		)
		(6
			(= temp3 (* (/ (/ (potPile total:) 5) 2) 5))
			(= temp4 (- (potPile total:) temp3))
			(potPile play: temp3 hand2Pile)
			(hand2 total: (+ temp3 (hand2 total:)))
			(potPile play: temp4 hand3Pile)
			(hand3 total: (+ temp4 (hand3 total:)))
		)
		(7
			(= temp3 (* (/ (/ (potPile total:) 5) 3) 5))
			(= temp4 (- (potPile total:) (* temp3 2)))
			(potPile play: temp3 hand2Pile)
			(hand2 total: (+ temp3 (hand2 total:)))
			(potPile play: temp3 hand3Pile)
			(hand3 total: (+ temp3 (hand3 total:)))
			(potPile play: temp4 hand1Pile)
			(hand1 total: (+ temp4 (hand1 total:)))
		)
		(8
			(hand4 total: (+ (potPile total:) (hand4 total:)))
			(potPile play: (potPile total:) hand4Pile)
		)
		(9
			(= temp3 (* (/ (/ (potPile total:) 5) 2) 5))
			(= temp4 (- (potPile total:) temp3))
			(potPile play: temp3 hand4Pile)
			(hand4 total: (+ temp3 (hand4 total:)))
			(potPile play: temp4 hand1Pile)
			(hand1 total: (+ temp4 (hand1 total:)))
		)
		(10
			(= temp3 (* (/ (/ (potPile total:) 5) 2) 5))
			(= temp4 (- (potPile total:) temp3))
			(potPile play: temp3 hand2Pile)
			(hand2 total: (+ temp3 (hand2 total:)))
			(potPile play: temp4 hand4Pile)
			(hand4 total: (+ temp4 (hand4 total:)))
		)
		(11
			(= temp3 (* (/ (/ (potPile total:) 5) 3) 5))
			(= temp4 (- (potPile total:) (* temp3 2)))
			(potPile play: temp3 hand2Pile)
			(hand2 total: (+ temp3 (hand2 total:)))
			(potPile play: temp3 hand4Pile)
			(hand4 total: (+ temp3 (hand4 total:)))
			(potPile play: temp4 hand1Pile)
			(hand1 total: (+ temp4 (hand1 total:)))
		)
		(12
			(= temp3 (* (/ (/ (potPile total:) 5) 2) 5))
			(= temp4 (- (potPile total:) temp3))
			(potPile play: temp3 hand3Pile)
			(hand3 total: (+ temp3 (hand3 total:)))
			(potPile play: temp4 hand4Pile)
			(hand4 total: (+ temp4 (hand4 total:)))
		)
		(13
			(= temp3 (* (/ (/ (potPile total:) 5) 3) 5))
			(= temp4 (- (potPile total:) (* temp3 2)))
			(potPile play: temp3 hand4Pile)
			(hand4 total: (+ temp3 (hand4 total:)))
			(potPile play: temp3 hand3Pile)
			(hand3 total: (+ temp3 (hand3 total:)))
			(potPile play: temp4 hand1Pile)
			(hand1 total: (+ temp4 (hand1 total:)))
		)
		(14
			(= temp3 (* (/ (/ (potPile total:) 5) 3) 5))
			(= temp4 (- (potPile total:) (* temp3 2)))
			(potPile play: temp3 hand2Pile)
			(hand2 total: (+ temp3 (hand2 total:)))
			(potPile play: temp3 hand3Pile)
			(hand3 total: (+ temp3 (hand3 total:)))
			(potPile play: temp4 hand4Pile)
			(hand4 total: (+ temp4 (hand4 total:)))
		)
		(15
			(= temp3 (* (/ (/ (potPile total:) 5) 4) 5))
			(= temp4 (- (potPile total:) (* temp3 3)))
			(potPile play: temp3 hand2Pile)
			(hand2 total: (+ temp3 (hand2 total:)))
			(potPile play: temp3 hand3Pile)
			(hand3 total: (+ temp3 (hand3 total:)))
			(potPile play: temp3 hand4Pile)
			(hand4 total: (+ temp3 (hand4 total:)))
			(potPile play: temp4 hand1Pile)
			(hand1 total: (+ temp4 (hand1 total:)))
		)
	)
	(temp2 dispose:)
	(return temp1)
)

(procedure (proc1100_1)
	(IconBarF darken:)
	((ScriptID 1180 0) init:) ; scorePoker
	(DisposeScript 1180)
	(IconBarF lighten:)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(= temp1 10)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= local33 (= temp0 (localproc_0)))
	(switch temp0
		(1
			(= temp4 (Random 0 2))
			(if (< (proc1100_12 -1) 3)
				(while (not ((theHands at: (+ temp4 1)) stillIn:))
					(= temp4 (Random 0 2))
				)
			)
			(= temp1 temp4)
			(= temp2 0)
			(= temp3 -1)
		)
		(2
			(= temp3 0)
			(if (<= 13 (Random 1 20))
				(= temp1 0)
				(= temp2 1)
			else
				(= temp2 0)
				(cond
					((Random 0 1)
						(cond
							(((theHands at: 3) stillIn:)
								(= temp1 2)
							)
							(((theHands at: 2) stillIn:)
								(= temp1 1)
							)
							(else
								(= temp1 0)
								(= temp2 1)
							)
						)
					)
					(((theHands at: 2) stillIn:)
						(= temp1 1)
					)
					(((theHands at: 3) stillIn:)
						(= temp1 2)
					)
					(else
						(= temp1 0)
						(= temp2 1)
					)
				)
			)
		)
		(4
			(= temp3 1)
			(if (<= 13 (Random 1 20))
				(= temp1 1)
				(= temp2 1)
			else
				(= temp2 0)
				(cond
					((Random 0 1)
						(cond
							(((theHands at: 3) stillIn:)
								(= temp1 2)
							)
							(((theHands at: 1) stillIn:)
								(= temp1 0)
							)
							(else
								(= temp1 1)
								(= temp2 1)
							)
						)
					)
					(((theHands at: 1) stillIn:)
						(= temp1 0)
					)
					(((theHands at: 3) stillIn:)
						(= temp1 2)
					)
					(else
						(= temp1 1)
						(= temp2 1)
					)
				)
			)
		)
		(8
			(= temp3 2)
			(if (<= 13 (Random 1 20))
				(= temp1 2)
				(= temp2 1)
			else
				(= temp2 0)
				(cond
					((Random 0 1)
						(cond
							(((theHands at: 2) stillIn:)
								(= temp1 1)
							)
							(((theHands at: 1) stillIn:)
								(= temp1 0)
							)
							(else
								(= temp1 2)
								(= temp2 1)
							)
						)
					)
					(((theHands at: 1) stillIn:)
						(= temp1 0)
					)
					(((theHands at: 2) stillIn:)
						(= temp1 1)
					)
					(else
						(= temp1 2)
						(= temp2 1)
					)
				)
			)
		)
		(else
			(= global920 1)
			(gChar1 sayReg: 1014 1 180 0 1)
			(return temp0)
		)
	)
	(if (== (proc1100_12 -1) 3)
		(if (== temp3 -1)
			(for
				((= temp4 (Random 0 2)))
				(not ((theHands at: (+ temp4 1)) stillInGame:))
				((= temp4 (Random 0 2)))
			)
			((Characters at: temp4) sayPN: 1000 2 83 0 (Random 1 5))
		else
			((Characters at: temp3) sayPN: 1000 2 82 0 (Random 1 5))
		)
		(return temp0)
	)
	(if (and (localproc_3) gAttitudeSetting (> temp3 -1))
		((Characters at: temp3)
			say: 1100 (+ ((Characters at: temp3) view:) 1) 81 0 1
		)
	)
	(if (and (== temp2 0) (> temp3 -1) (== ((Characters at: temp1) view:) 5))
		(= temp2 1)
		(= temp1 temp3)
	)
	(if gAttitudeSetting
		(cond
			(temp2
				((Characters at: temp1) say: 1000 2 82 0 (Random 1 5))
			)
			(gAttitudeSetting
				((Characters at: temp1) say: 1000 2 83 0 (Random 1 5))
			)
			(else
				((Characters at: temp1) sayPN: 1000 2 83 0 (Random 1 5))
			)
		)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2)
	(= temp0 -1)
	(for ((= temp1 0)) (< temp1 4) ((++ temp1))
		(if
			(and
				((theHands at: temp1) stillIn:)
				(> ((theHands at: temp1) handRank:) temp0)
			)
			(= temp0 ((theHands at: temp1) handRank:))
		)
	)
	(for ((= temp1 0)) (< temp1 4) ((++ temp1))
		(for ((= temp2 (+ temp1 1))) (< temp2 4) ((++ temp2))
			(if
				(and
					((theHands at: temp1) stillIn:)
					((theHands at: temp2) stillIn:)
					(==
						((theHands at: temp1) handRank:)
						((theHands at: temp2) handRank:)
						temp0
					)
				)
				(return 1)
			)
		)
	)
	(return 0)
)

(procedure (proc1100_12 param1 &tmp temp0 temp1)
	(= temp1 0)
	(cond
		((or (== param1 -2) (== param1 -1) (== param1 0) (== param1 1))
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(if (== ((theHands at: temp0) lastPlay:) param1)
					(++ temp1)
				)
			)
		)
		((== param1 2)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(if (== ((theHands at: temp0) stillIn:) 1)
					(++ temp1)
				)
			)
		)
		(else
			(Printf {Wrong Parameters sent})
		)
	)
	(return temp1)
)

(procedure (proc1100_14 param1 &tmp temp0)
	(if param1
		(floatPot view: 1179 loop: 0 cel: 0 posn: 250 120 init:)
		(floatPotb view: 1179 loop: 4 cel: 2 posn: 275 128 init:)
		(floatPotNum1 hide:)
		(floatPotNum2 hide:)
		(floatPotNum3 hide:)
		(floatPotNum4 hide:)
	)
	(cond
		((>= (= temp0 global887) 1000)
			(floatPotNum1
				view: 1179
				loop: 5
				cel: (mod (/ temp0 1000) 10)
				posn: (+ (floatPotb x:) 45 5) 129
				init:
			)
			(floatPotNum2
				view: 1179
				loop: 5
				cel: (mod (/ temp0 100) 10)
				posn: (+ (floatPotNum1 nsRight:) 5) 129
				init:
			)
			(floatPotNum3
				view: 1179
				loop: 5
				cel: (mod (/ temp0 10) 10)
				posn: (+ (floatPotNum2 nsRight:) 5) 129
				init:
			)
			(floatPotNum4
				view: 1179
				loop: 5
				cel: (mod temp0 10)
				posn: (+ (floatPotNum3 nsRight:) 5) 129
				init:
			)
		)
		((>= temp0 100)
			(floatPotNum2
				view: 1179
				loop: 5
				cel: (mod (/ temp0 100) 10)
				posn: (+ (floatPotb x:) 45 17) 129
				init:
			)
			(floatPotNum3
				view: 1179
				loop: 5
				cel: (mod (/ temp0 10) 10)
				posn: (+ (floatPotNum2 nsRight:) 5) 129
				init:
			)
			(floatPotNum4
				view: 1179
				loop: 5
				cel: (mod temp0 10)
				posn: (+ (floatPotNum3 nsRight:) 5) 129
				init:
			)
		)
		((>= temp0 10)
			(floatPotNum3
				view: 1179
				loop: 5
				cel: (mod (/ temp0 10) 10)
				posn: (+ (floatPotb x:) 45 29) 129
				init:
			)
			(floatPotNum4
				view: 1179
				loop: 5
				cel: (mod temp0 10)
				posn: (+ (floatPotNum3 nsRight:) 5) 129
				init:
			)
		)
		((>= temp0 0)
			(floatPotNum4
				view: 1179
				loop: 5
				cel: (mod temp0 10)
				posn: (+ (floatPotb x:) 45 35) 129
				init:
			)
		)
	)
)

(procedure (proc1100_15 param1 param2 param3 param4 &tmp temp0)
	(localproc_4 param2)
	(= temp0 param1)
	(+= param3 50)
	(+= param4 1)
	(if (> temp0 0)
		(cond
			((>= temp0 1000)
				([local16 param2]
					view: 1179
					loop: 5
					cel: (mod (/ temp0 1000) 10)
					posn: (+ param3 5) param4
					init:
				)
				([local20 param2]
					view: 1179
					loop: 5
					cel: (mod (/ temp0 100) 10)
					posn: (+ ([local16 param2] nsRight:) 5) param4
					init:
				)
				([local24 param2]
					view: 1179
					loop: 5
					cel: (mod (/ temp0 10) 10)
					posn: (+ ([local20 param2] nsRight:) 5) param4
					init:
				)
				([local28 param2]
					view: 1179
					loop: 5
					cel: (mod temp0 10)
					posn: (+ ([local24 param2] nsRight:) 5) param4
					init:
				)
			)
			((>= temp0 100)
				([local20 param2]
					view: 1179
					loop: 5
					cel: (mod (/ temp0 100) 10)
					posn: (+ param3 5) param4
					init:
				)
				([local24 param2]
					view: 1179
					loop: 5
					cel: (mod (/ temp0 10) 10)
					posn: (+ ([local20 param2] nsRight:) 5) param4
					init:
				)
				([local28 param2]
					view: 1179
					loop: 5
					cel: (mod temp0 10)
					posn: (+ ([local24 param2] nsRight:) 5) param4
					init:
				)
			)
			((>= temp0 10)
				([local24 param2]
					view: 1179
					loop: 5
					cel: (mod (/ temp0 10) 10)
					posn: (+ param3 5) param4
					init:
				)
				([local28 param2]
					view: 1179
					loop: 5
					cel: (mod temp0 10)
					posn: (+ ([local24 param2] nsRight:) 5) param4
					init:
				)
			)
			((>= temp0 0)
				([local28 param2]
					view: 1179
					loop: 5
					cel: (mod temp0 10)
					posn: (+ param3 5) param4
					init:
				)
			)
		)
	)
)

(procedure (localproc_4 param1)
	([local16 param1] hide:)
	([local20 param1] hide:)
	([local24 param1] hide:)
	([local28 param1] hide:)
)

(procedure (proc1100_16 param1)
	(if argc
		(= local34 param1)
	else
		(return local34)
	)
)

(procedure (localproc_5) ; UNUSED
	((hand1 at: 0) suit: 0)
	((hand1 at: 0) rank: 9)
	((hand1 at: 1) suit: 0)
	((hand1 at: 1) rank: 8)
	((hand1 at: 2) suit: 0)
	((hand1 at: 2) rank: 7)
	((hand1 at: 3) suit: 0)
	((hand1 at: 3) rank: 4)
	((hand1 at: 4) suit: 1)
	((hand1 at: 4) rank: 2)
	((hand2 at: 0) suit: 0)
	((hand2 at: 0) rank: 11)
	((hand2 at: 1) suit: 1)
	((hand2 at: 1) rank: 11)
	((hand2 at: 2) suit: 3)
	((hand2 at: 2) rank: 3)
	((hand2 at: 3) suit: 3)
	((hand2 at: 3) rank: 4)
	((hand2 at: 4) suit: 3)
	((hand2 at: 4) rank: 7)
	((hand3 at: 0) suit: 3)
	((hand3 at: 0) rank: 11)
	((hand3 at: 1) suit: 2)
	((hand3 at: 1) rank: 11)
	((hand3 at: 2) suit: 2)
	((hand3 at: 2) rank: 3)
	((hand3 at: 3) suit: 2)
	((hand3 at: 3) rank: 5)
	((hand3 at: 4) suit: 2)
	((hand3 at: 4) rank: 6)
	((hand4 at: 0) suit: 1)
	((hand4 at: 0) rank: 7)
	((hand4 at: 1) suit: 1)
	((hand4 at: 1) rank: 6)
	((hand4 at: 2) suit: 1)
	((hand4 at: 2) rank: 5)
	((hand4 at: 3) suit: 1)
	((hand4 at: 3) rank: 4)
	((hand4 at: 4) suit: 0)
	((hand4 at: 4) rank: 2)
)

(instance pokerRoom of HoyleRoom
	(properties
		style 14
	)

	(method (init &tmp temp0 temp1)
		(= global900 (IntArray new: 376))
		(= temp0 (Str format: {PENGIN16.DLL}))
		(if (<= (WinDLL 0 (temp0 data:)) 33)
			(Printf {Error loading DLL})
		)
		(temp0 dispose:)
		(if (not global921)
			(Load 140 604) ; WAVE
			(Lock 140 604) ; WAVE
			(Load 140 605) ; WAVE
			(Lock 140 605) ; WAVE
			(Load 140 606) ; WAVE
			(Lock 140 606) ; WAVE
		)
		(= local34 0)
		(= gSortMode 1)
		(= picture -2)
		(= global395 0)
		(= local4 0)
		(Load rsVIEW (+ 54 global384))
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW 214)
		(Load rsVIEW 905)
		(Load rsHEAP 18)
		(Load rsSCRIPT 18)
		(= [local16 0] float1Num0)
		(= [local20 0] float1Num1)
		(= [local24 0] float1Num2)
		(= [local28 0] float1Num3)
		(= [local16 1] float2Num0)
		(= [local20 1] float2Num1)
		(= [local24 1] float2Num2)
		(= [local28 1] float2Num3)
		(= [local16 2] float3Num0)
		(= [local20 2] float3Num1)
		(= [local24 2] float3Num2)
		(= [local28 2] float3Num3)
		(= [local16 3] float4Num0)
		(= [local20 3] float4Num1)
		(= [local24 3] float4Num2)
		(= [local28 3] float4Num3)
		(= global886 0)
		(= global887 0)
		(= local0 0)
		((= gPoker_opt poker_opt) doit:)
		(if global878
			(PlaySong play: (+ 50 global878))
		else
			(PlaySong play: 51)
		)
		(if (not local34)
			(gSong setLoop: 1)
		)
		(= gChipCast (ChipCast new:))
		(= gChipsPlane
			((ChipsPlane new:)
				priority: 1
				picture: (+ 901 global385)
				init: 0 0 640 480
				addCast: gChipCast
				yourself:
			)
		)
		(KeyMouse setList: gTheKeyMouseList)
		(gGame setCursor: 999)
		(super init:)
		(Deck init:)
		((= global117 theHands) add: hand1 hand2 hand3 hand4)
		((= local2 theChipPiles) add: hand1Pile hand2Pile hand3Pile hand4Pile)
		((local2 at: 0) init: global911)
		((local2 at: 1) init: global912)
		((local2 at: 2) init: global913)
		((local2 at: 3) init: global914)
		(= global911 500)
		(= global912 500)
		(= global913 500)
		(= global914 500)
		(hand1 total: ((local2 at: 0) total:))
		(hand2 total: ((local2 at: 1) total:))
		(hand3 total: ((local2 at: 2) total:))
		(hand4 total: ((local2 at: 3) total:))
		(potPile init: 0)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1)
		(hand3 add: owner: gChar2)
		(hand4 add: owner: gChar3)
		(hand1Pile add: owner: 0)
		(hand2Pile add: owner: gChar1)
		(hand3Pile add: owner: gChar2)
		(hand4Pile add: owner: gChar3)
		(handleEventList add:)
		(= gCardGameScriptNumber 1100)
		(Dealer cardsToDeal: 5)
		(gChar1 posn: 61 327 init: show:)
		(gChar2 posn: 200 61 show: init:)
		(gChar3 posn: 582 99 show: init:)
		(Characters init:)
		(Deck shuffle:)
		(gPoker_opt doit: 3)
		(IconBarF init:)
		(self setScript: roomScript)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(= global290 0)
			(global117 eachElementDo: #sort)
			(UpdateScreenItem (gCast elements:) 1)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
	)

	(method (dispose &tmp temp0)
		(= global458 0)
		(Lock 140 604 0) ; WAVE
		(UnLoad 140 604)
		(Lock 140 605 0) ; WAVE
		(UnLoad 140 605)
		(Lock 140 606 0) ; WAVE
		(UnLoad 140 606)
		(= temp0 (Str format: {PENGIN16.DLL}))
		(if (!= (WinDLL 1 (temp0 data:)) 1)
			(Printf {Error unloading DLL})
		)
		(temp0 dispose:)
		(KeyMouse release:)
		(Dealer dispose:)
		(global117 release: dispose:)
		(local2 dispose:)
		(potPile dispose:)
		(handleEventList release: dispose:)
		(if gTray
			(if (gTray elements:)
				(gTray release:)
			)
			(gTray dispose:)
		)
		(Deck dispose:)
		(IconBarF dispose:)
		(global900 dispose:)
		(DisposeScript 1180)
		(DisposeScript 9)
		(DisposeScript 1190)
		(gChipsPlane dispose:)
		(= gChipsPlane 0)
		(DisposeScript 22)
		(super dispose:)
	)
)

(instance theHands of List
	(properties)
)

(instance theChipPiles of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 6] temp6)
		(switch (= state newState)
			(0
				(IconBar show:)
				(DisableCursor)
				(= ticks 1)
			)
			(1
				(if local0
					(RedrawCast)
					((ScriptID 1190 0) init:) ; optionPoker
					(DisableCursor)
				)
				(= ticks 1)
			)
			(2
				(Dealer init: hand1 hand2 hand3 hand4)
				(Dealer cardsToDeal: 5)
				(Dealer eachElementDo: #init)
				(local2 eachElementDo: #show)
				(hand1 stillInGame: 1)
				(hand2 stillInGame: 1)
				(hand3 stillInGame: 1)
				(hand4 stillInGame: 1)
				(Deck rankAces: 14)
				(if (< (hand1Pile total:) 50)
					(hand1 stillIn: 0 open: 0)
					(hand1 stillInGame: 0)
					(hand1 lastPlay: -1)
				)
				(if (and (< (hand2Pile total:) 50) (hand2 stillInGame:))
					(proc0_10 1179 6 1 90 380 100)
					(hand2 stillIn: 0 open: 0)
					(hand2 stillInGame: 0)
					(hand2 lastPlay: -1)
					(Dealer delete: hand2)
				)
				(if (and (< (hand3Pile total:) 50) (hand3 stillInGame:))
					(proc0_10 1179 6 1 10 60 100)
					(hand3 stillIn: 0 open: 0)
					(hand3 stillInGame: 0)
					(hand3 lastPlay: -1)
					(Dealer delete: hand3)
				)
				(if (and (< (hand4Pile total:) 50) (hand4 stillInGame:))
					(proc0_10 1179 6 1 380 60 100)
					(hand4 stillIn: 0 open: 0)
					(hand4 stillInGame: 0)
					(hand4 lastPlay: -1)
					(Dealer delete: hand4)
				)
				(Dealer curPlayer: (Dealer at: 1) dealTo: (Dealer at: 1))
				(= ticks 1)
			)
			(3
				(if (hand1 stillInGame:)
					(hand1
						totalBet: 0
						currentBet: 0
						lastPlay: -3
						stillIn: 1
						open: 0
						lastRaise: 0
						lastSaw: 0
						tookCard: 0
					)
				)
				(if (hand2 stillInGame:)
					(hand2
						totalBet: 0
						currentBet: 0
						lastPlay: -3
						stillIn: 1
						open: 0
						lastRaise: 0
						lastSaw: 0
						tookCard: 0
					)
				)
				(if (hand3 stillInGame:)
					(hand3
						totalBet: 0
						currentBet: 0
						lastPlay: -3
						stillIn: 1
						open: 0
						lastRaise: 0
						lastSaw: 0
						tookCard: 0
					)
				)
				(if (hand4 stillInGame:)
					(hand4
						totalBet: 0
						currentBet: 0
						lastPlay: -3
						stillIn: 1
						open: 0
						lastRaise: 0
						lastSaw: 0
						tookCard: 0
					)
				)
				(= global888 0)
				(= global887 0)
				(proc1100_14 1)
				(EnableCursor)
				(= global889 0)
				(anteButton init:)
			)
			(4
				(= global887 (* (= global890 (Dealer size:)) global879))
				(global117
					eachElementDo: #prevTotal 0
					eachElementDo: #handTotal 0
					eachElementDo: #tempTotal 0
				)
				(= global402 0)
				(= global889 1)
				(= ticks 1)
			)
			(5
				(proc1100_14 1)
				(= local5 (Random 0 2))
				(if
					(and
						(!= (Dealer dealer:) (theHands at: (+ local5 1)))
						((theHands at: (+ local5 1)) stillInGame:)
					)
					((Characters at: local5)
						sayReg:
							1100
							(+ ((Characters at: local5) view:) 1)
							102
							0
							2
					)
				)
				(Dealer playDirection: 0 deal: self)
				(= global890 (Dealer size:))
			)
			(6
				(Arrow x: 400 y: 130 init:)
				(directionArrow init: (Dealer playDirection:))
				(= local1 global890)
				(hand1 eachElementDo: #addKeyMouse)
				(handleEventList
					add:
						hand1
						hand2
						hand3
						hand4
						hand1Pile
						hand2Pile
						hand3Pile
						hand4Pile
						potPile
				)
				(= global904 0)
				(= global905 0)
				(= global907 0)
				(= global906 0)
				(= global888 0)
				(= ticks 1)
			)
			(7
				(hand1 sort:)
				(RedrawCast)
				(if
					(and
						(< global905 (- (proc1100_12 2) 1))
						(< (proc1100_12 -2) (proc1100_12 2))
					)
					(if
						(and
							((Dealer at: 1) stillInGame:)
							((Dealer at: 1) stillIn:)
						)
						((ScriptID 1110 0) init: 1) ; betPoker
						(DisposeScript 1110)
						(proc1100_14)
					)
					(cond
						((> (Dealer size:) 2)
							(if
								(and
									((Dealer at: 2) stillIn:)
									(!= ((Dealer at: 2) type:) 0)
								)
								(Arrow
									setLoop: ((Dealer at: 2) getLocation:)
									init:
								)
								(= ticks (* global899 10))
							else
								(= ticks 1)
							)
						)
						(
							(and
								((Dealer at: 0) stillIn:)
								(!= ((Dealer at: 0) type:) 0)
							)
							(Arrow setLoop: ((Dealer at: 0) getLocation:) init:)
							(= ticks (* global899 10))
						)
						(else
							(= ticks 1)
						)
					)
				else
					(= ticks 1)
				)
			)
			(8
				(if (> (Dealer size:) 2)
					(if
						(and
							(< global905 (- (proc1100_12 2) 1))
							(< (proc1100_12 -2) (proc1100_12 2))
						)
						(if
							(and
								((Dealer at: 2) stillInGame:)
								((Dealer at: 2) stillIn:)
							)
							((ScriptID 1110 0) init: 2) ; betPoker
							(DisposeScript 1110)
							(proc1100_14)
						)
						(cond
							((> (Dealer size:) 3)
								(if
									(and
										((Dealer at: 3) stillIn:)
										(!= ((Dealer at: 3) type:) 0)
									)
									(Arrow
										setLoop: ((Dealer at: 3) getLocation:)
										init:
									)
									(= ticks (* global899 10))
								else
									(= ticks 1)
								)
							)
							(
								(and
									((Dealer at: 0) stillIn:)
									(!= ((Dealer at: 0) type:) 0)
								)
								(Arrow
									setLoop: ((Dealer at: 0) getLocation:)
									init:
								)
								(= ticks (* global899 10))
							)
							(else
								(= ticks 1)
							)
						)
					else
						(= ticks 1)
					)
				else
					(= ticks 1)
				)
			)
			(9
				(if (> (Dealer size:) 3)
					(if
						(and
							(< global905 (- (proc1100_12 2) 1))
							(< (proc1100_12 -2) (proc1100_12 2))
						)
						(if
							(and
								((Dealer at: 3) stillInGame:)
								((Dealer at: 3) stillIn:)
							)
							((ScriptID 1110 0) init: 3) ; betPoker
							(DisposeScript 1110)
							(proc1100_14)
						)
						(if
							(and
								((Dealer at: 0) stillIn:)
								(!= ((Dealer at: 0) type:) 0)
							)
							(Arrow setLoop: ((Dealer at: 0) getLocation:) init:)
							(= ticks (* global899 10))
						else
							(= ticks 1)
						)
					else
						(= ticks 1)
					)
				else
					(= ticks 1)
				)
			)
			(10
				(if
					(and
						(< global905 (- (proc1100_12 2) 1))
						(< (proc1100_12 -2) (proc1100_12 2))
					)
					(if
						(and
							((Dealer at: 0) stillInGame:)
							((Dealer at: 0) stillIn:)
						)
						((ScriptID 1110 0) init: 0) ; betPoker
						(DisposeScript 1110)
						(proc1100_14)
						(= ticks 1)
					else
						(= ticks 1)
					)
				else
					(= ticks 1)
				)
			)
			(11
				(cond
					(
						(and
							(< global905 (- (proc1100_12 2) 1))
							(< (proc1100_12 -2) (proc1100_12 2))
						)
						(if (== global907 (- (Dealer size:) 1))
							(= state 18)
							(= ticks 1)
						else
							(if
								(and
									((Dealer at: 1) stillIn:)
									(!= ((Dealer at: 1) type:) 0)
								)
								(Arrow
									setLoop: ((Dealer at: 1) getLocation:)
									init:
								)
								(= ticks (* global899 10))
							else
								(= ticks 1)
							)
							(= state 6)
						)
					)
					((== global907 (- (Dealer size:) 1))
						(= state 18)
						(= ticks 1)
					)
					(else
						(= ticks 1)
					)
				)
			)
			(12
				(if (!= (hand1 lastPlay:) -1)
					(hand1 currentBet: 0 lastPlay: -3)
				)
				(if (!= (hand2 lastPlay:) -1)
					(hand2 currentBet: 0 lastPlay: -3)
				)
				(if (!= (hand3 lastPlay:) -1)
					(hand3 currentBet: 0 lastPlay: -3)
				)
				(if (!= (hand4 lastPlay:) -1)
					(hand4 currentBet: 0 lastPlay: -3)
				)
				(Arrow setLoop: ((Dealer curPlayer:) getLocation:) init:)
				(= ticks 1)
			)
			(13
				(Arrow x: 400 y: 130 init:)
				(directionArrow init: (Dealer playDirection:))
				(hand1 sort:)
				(hand2 sort: 1)
				(hand3 sort: 1)
				(hand4 sort: 1)
				(RedrawCast)
				(EnableCursor)
				(if
					(and
						(== ((Dealer curPlayer:) type:) 0)
						((Dealer curPlayer:) stillIn:)
					)
					(EnableCursor)
					(Tray x: 250 y: 160 init: handleEventList self)
					((ScriptID 18 0) cel: 6) ; theTitle
				else
					(= cycles 1)
				)
			)
			(14
				(if ((Dealer curPlayer:) stillIn:)
					(if (== ((Dealer curPlayer:) type:) 0)
						(= global886 ((ScriptID 15 1) size:)) ; discardList
						((global117 at: 0) tookCard: global886)
						(hand1 floater: global886)
					else
						(= global886 ((Dealer curPlayer:) think:))
					)
					(if global886
						(Dealer cardsToDeal: global886)
						(Dealer caller: self)
						(Dealer setScript: dealToOneScript)
						(if ((ScriptID 15 1) size:) ; discardList
							((ScriptID 15 1) release: dispose:) ; discardList
						)
						(= global886 0)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(15
				(Dealer nextDealTo: nextToPlay:)
				(if (== (-- local1) 0)
					(= local1 global890)
					(= cycles 1)
				else
					(= state 12)
					(= cycles 1)
				)
			)
			(16
				(= global889 2)
				(= local32 1)
				(if (= temp6 (theHands firstTrue: #open))
					(= local32 (Dealer indexOf: temp6))
					(theHands eachElementDo: #open 0)
				)
				(= global904 0)
				(= global905 0)
				(= global906 0)
				(= global888 0)
				(= cycles 1)
			)
			(17
				(hand1 sort:)
				(hand2 sort: 1)
				(hand3 sort: 1)
				(hand4 sort: 1)
				(RedrawCast)
				(if
					(and
						(< global905 (- (proc1100_12 2) 1))
						(< (proc1100_12 -2) (proc1100_12 2))
					)
					(if
						(and
							((Dealer at: local32) stillInGame:)
							((Dealer at: local32) stillIn:)
						)
						((ScriptID 1110 0) init: local32) ; betPoker
						(DisposeScript 1110)
						(proc1100_14)
						(= ticks 1)
					else
						(= ticks 1)
					)
				else
					(= ticks 1)
				)
				(if (== (++ local32) (Dealer size:))
					(= local32 0)
				)
			)
			(18
				(if
					(and
						(< global905 (- (proc1100_12 2) 1))
						(< (proc1100_12 -2) (proc1100_12 2))
					)
					(if
						(and
							((Dealer at: local32) stillInGame:)
							((Dealer at: local32) stillIn:)
						)
						(Arrow
							setLoop: ((Dealer at: local32) getLocation:)
							init:
						)
						(if (!= ((Dealer at: local32) type:) 0)
							(= ticks (* global899 10))
						else
							(= ticks 1)
						)
					else
						(= ticks 1)
					)
					(= state 16)
				else
					(= ticks 1)
				)
			)
			(19
				(hand1 currentBet: 0)
				(hand2 currentBet: 0)
				(hand3 currentBet: 0)
				(hand4 currentBet: 0)
				(hand2 sort: 1)
				(hand3 sort: 1)
				(hand4 sort: 1)
				(RedrawCast)
				(= ticks 1)
			)
			(20
				(Arrow endHand:)
				(directionArrow init: -1)
				(= global889 0)
				(if (< global907 (- (Dealer size:) 1))
					(if (and (hand1 stillIn:) (hand1 stillInGame:))
						(hand1 eachElementDo: #flip 1)
					)
					(if (and (hand2 stillIn:) (hand2 stillInGame:))
						(hand2 eachElementDo: #flip 1)
					)
					(if (and (hand3 stillIn:) (hand3 stillInGame:))
						(hand3 eachElementDo: #flip 1)
					)
					(if (and (hand4 stillIn:) (hand4 stillInGame:))
						(hand4 eachElementDo: #flip 1)
					)
				)
				(hand1 sort:)
				(RedrawCast)
				(handleEventList
					delete:
						hand1
						hand2
						hand3
						hand4
						hand1Pile
						hand2Pile
						hand3Pile
						hand4Pile
						potPile
				)
				(= cycles 1)
			)
			(21
				(= cycles 1)
			)
			(22
				(RedrawCast)
				(global117 eachElementDo: #calcScore 1)
				(if (< global907 (- (Dealer size:) 1))
					(if (and (hand1 stillIn:) (hand1 stillInGame:))
						(hand1 whatAmI:)
					)
					(if (and (hand2 stillIn:) (hand2 stillInGame:))
						(hand2 whatAmI:)
					)
					(if (and (hand3 stillIn:) (hand3 stillInGame:))
						(hand3 whatAmI:)
					)
					(if (and (hand4 stillIn:) (hand4 stillInGame:))
						(hand4 whatAmI:)
					)
				)
				(if (not (hand2 stillInGame:))
					(hand2 lastPlay: -1)
				)
				(if (not (hand3 stillInGame:))
					(hand3 lastPlay: -1)
				)
				(if (not (hand4 stillInGame:))
					(hand4 lastPlay: -1)
				)
				(RedrawCast)
				(localproc_2)
				(= cycles 1)
			)
			(23
				(whoWonButton init: local33)
			)
			(24
				(global117 eachElementDo: #endHand)
				(float1 dispose:)
				(float2 dispose:)
				(float3 dispose:)
				(float4 dispose:)
				(float1b dispose:)
				(float2b dispose:)
				(float3b dispose:)
				(float4b dispose:)
				(float1c dispose:)
				(float2c dispose:)
				(float3c dispose:)
				(float4c dispose:)
				(localproc_4 1)
				(localproc_4 2)
				(localproc_4 3)
				(localproc_4 0)
				(= ticks 1)
			)
			(25
				(if (< (hand1Pile total:) 50)
					(hand1 stillIn: 0 open: 0)
					(hand1 stillInGame: 0)
					(hand1 lastPlay: -1)
				)
				(if (and (< (hand2Pile total:) 50) (hand2 stillInGame:))
					(proc0_10 1179 6 1 90 380 100)
					(hand2 stillIn: 0 open: 0)
					(hand2 stillInGame: 0)
					(hand2 lastPlay: -1)
					(Dealer delete: hand2)
				)
				(if (and (< (hand3Pile total:) 50) (hand3 stillInGame:))
					(proc0_10 1179 6 1 10 60 100)
					(hand3 stillIn: 0 open: 0)
					(hand3 stillInGame: 0)
					(hand3 lastPlay: -1)
					(Dealer delete: hand3)
				)
				(if (and (< (hand4Pile total:) 50) (hand4 stillInGame:))
					(proc0_10 1179 6 1 380 60 100)
					(hand4 stillIn: 0 open: 0)
					(hand4 stillInGame: 0)
					(hand4 lastPlay: -1)
					(Dealer delete: hand4)
				)
				(if
					(and
						(hand1 stillInGame:)
						(or
							(hand2 stillInGame:)
							(hand3 stillInGame:)
							(hand4 stillInGame:)
						)
					)
					(= state 2)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 5)
				)
				(= ticks 1)
			)
			(26
				(cond
					((hand1 stillInGame:)
						(if (> gAttitudeSetting 1)
							(= global920 1)
							(gChar1 say: 15 15 179 0 (Random 1 7))
						)
					)
					((> gAttitudeSetting 1)
						(cond
							(
								(and
									(>= (hand2 total:) (hand3 total:))
									(>= (hand2 total:) (hand4 total:))
								)
								(gChar1 sayReg: 1000 2 64 0 1 718 1)
							)
							(
								(and
									(>= (hand3 total:) (hand4 total:))
									(>= (hand3 total:) (hand2 total:))
								)
								(gChar2 sayReg: 1000 2 64 0 1 718 1)
							)
							(else
								(gChar3 sayReg: 1000 2 64 0 1 718 1)
							)
						)
					)
				)
				(IconBarF darken:)
				((ScriptID 1180 0) init:) ; scorePoker
				(DisposeScript 1180)
				(= global748 0)
				((ScriptID 930 0) init: 1170) ; yesNo
				(DisposeScript 930)
				(IconBarF lighten:)
				(cond
					(global748
						(= gNewRoomNum gCurRoomNum)
						(= gCurRoomNum 0)
						(gCurRoom style: 256)
						(proc0_8 0)
						(= global199 1)
						(proc0_9 (gCast elements:) 0)
					)
					(global924
						(gGame quitGame:)
						(proc0_8 0)
					)
					(else
						(= ticks 1)
					)
				)
			)
			(27
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance dealToOneScript of Script
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(DisableCursor)
				(= register 0)
				(switch ((client at: 0) location:)
					(1
						(client dealerX: (/ gScreenWidth 2) dealerY: 10)
					)
					(3
						(client
							dealerX: (/ gScreenWidth 2)
							dealerY: (+ gScreenHeight 40)
						)
					)
					(2
						(client
							dealerX: (+ gScreenWidth 40)
							dealerY: (/ gScreenHeight 2)
						)
					)
					(4
						(client dealerX: -40 dealerY: (/ gScreenHeight 2))
					)
				)
				(client litlCard: (ScriptID 15 6)) ; littleCard
				((ScriptID 15 6) ; littleCard
					view: (+ 54 global384)
					posn: (client dealerX:) (client dealerY:)
					init:
				)
				(if (== global898 0)
					(for
						((= temp1 0))
						(< temp1 (Dealer cardsToDeal:))
						((++ temp1))
						
						((Dealer dealTo:) add: (= temp0 (Deck getCard:)) 1)
						(switch ((Dealer dealTo:) handDirection:)
							(2
								(temp0 setPri: (/ (+ 8 temp1) 4))
							)
							(1
								(temp0 setPri: 2)
							)
						)
						(switch ((client dealTo:) handNumber:)
							(1
								(temp0
									flip: ((client dealTo:) faceUp:)
									show:
									init: 0
								)
							)
							(3
								(temp0
									flip: ((client dealTo:) faceUp:)
									show:
									init: 0
								)
							)
							(2
								(temp0
									flip: ((client dealTo:) faceUp:)
									setPri: 2
									show:
									init: 0
								)
							)
							(4
								(temp0
									flip: ((client dealTo:) faceUp:)
									setPri: 2
									show:
									init: 0
								)
							)
						)
						((client dealTo:) update:)
					)
					(= state 2)
				)
				(= ticks 1)
			)
			(1
				(gSound play: 902)
				(cond
					(((ScriptID 15 6) isNotHidden:) ; littleCard
						(if global898
							((ScriptID 15 6) show:) ; littleCard
						)
					)
					((not global898)
						((ScriptID 15 6) hide:) ; littleCard
					)
				)
				(if global898
					((ScriptID 15 6) ; littleCard
						show:
						moveSpeed: (/ global898 4)
						cycleSpeed: global898
						setMotion:
							MoveTo
							(+ ((client dealTo:) calcNextX:) 0)
							(+ ((client dealTo:) calcNextY:) 0)
							self
						setLoop: 1
					)
				else
					((ScriptID 15 6) hide:) ; littleCard
					(= ticks 1)
				)
			)
			(2
				((ScriptID 15 6) ; littleCard
					view: (+ 54 global384)
					setStep:
						(+ 8 (* 2 (- 16 global898)))
						(+ 8 (* 2 (- 16 global898)))
				)
				(++ register)
				(if global898
					((ScriptID 15 6) posn: (client dealerX:) (client dealerY:)) ; littleCard
				)
				((client dealTo:) add: (= temp0 (Deck getCard:)) 1)
				(switch ((client dealTo:) handNumber:)
					(1
						(temp0
							flip: ((client dealTo:) faceUp:)
							setPri: 2
							show:
							init: 0
						)
					)
					(3
						(temp0
							flip: ((client dealTo:) faceUp:)
							setPri: 2
							show:
							init: 0
						)
					)
					(2
						(temp0
							flip: ((client dealTo:) faceUp:)
							setPri: 2
							show:
							init: 0
						)
					)
					(4
						(temp0
							flip: ((client dealTo:) faceUp:)
							setPri: 2
							show:
							init: 0
						)
					)
				)
				((client dealTo:) update:)
				(if (!= register (client cardsToDeal:))
					(= state 0)
				)
				(= ticks 1)
			)
			(3
				(RedrawCast)
				(if (Dealer caller:)
					((Dealer caller:) cue:)
					(Dealer caller: 0)
				)
				(Dealer setScript: 0)
			)
		)
	)
)

(instance anteButton of TrackingView
	(properties
		view 1183
	)

	(method (init)
		(= x 267)
		(= y 195)
		(super init:)
		(EnableCursor)
		((KeyMouse objList:) release: add: self)
		(handleEventList add: self)
	)

	(method (dispose)
		((KeyMouse objList:) release:)
		(handleEventList delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(and
				(not (event claimed:))
				(not (& (event type:) evMOUSERELEASE))
				(not (and (<= 66 (event x:) 580) (<= 420 (event y:) 441)))
				(or
					(and
						(<= nsLeft (event x:) (- nsRight 1))
						(<= nsTop (event y:) (- nsBottom 1))
					)
					(proc0_2 event)
				)
			)
			(cond
				((proc0_2 event)
					(self enterKey:)
					(= temp1 1)
					(event claimed: 1)
				)
				((and (== (event modifiers:) $000f) (& (event type:) evMOUSEBUTTON)) ; emALT | emCTRL | emSHIFT
					(cond
						((and (== (gChar2 view:) 1403) (not global921))
							(gSound2 play: 302)
							(gChar2 view: 1183 loop: 3)
							(gChar1 view: 1183 loop: 1)
							(gChar3 view: 1183 loop: 2)
						)
						((and (& (event type:) evMOUSEBUTTON) (= temp1 (self track:)))
							(gSound2 play: 901)
						)
					)
					(event claimed: 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(if (= temp1 (self track:))
						(gSound2 play: 901)
					)
					(event claimed: 1)
				)
			)
		)
		(if temp1
			(anteButton setCycle: Fwd)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(if ((global117 at: temp0) stillInGame:)
					((global117 at: temp0) currentBet: global879)
					((global117 at: temp0)
						totalBet:
							(+
								((global117 at: temp0) totalBet:)
								((global117 at: temp0) currentBet:)
							)
					)
					((global117 at: temp0)
						total:
							(-
								((global117 at: temp0) total:)
								((global117 at: temp0) currentBet:)
							)
					)
					((global117 at: temp0) currentBet: 0)
				)
			)
			(if (hand1 stillInGame:)
				(hand1Pile ante: global879)
			)
			(if (hand2 stillInGame:)
				(hand2Pile ante: global879)
			)
			(if (hand3 stillInGame:)
				(hand3Pile ante: global879)
			)
			(if (hand4 stillInGame:)
				(hand4Pile ante: global879)
			)
			(event claimed: 1)
			((pokerRoom script:) state: 3 cycles: 1)
			(self dispose:)
		)
	)
)

(instance whoWonButtonTimer of Timer
	(properties)

	(method (cue)
		(whoWonButton dispose:)
	)
)

(instance whoWonButton of TrackingView
	(properties
		priority 350
		view 1184
	)

	(method (init param1 &tmp temp0 temp1 [temp2 2])
		(whoWonButtonTimer init: whoWonButton)
		(whoWonButtonTimer setReal: whoWonButtonTimer (+ global899 15))
		(= temp1 10)
		(= temp0 10)
		(= x 280)
		(= y 195)
		(self setPri: 350)
		(switch param1
			(1
				(= cel (= loop 0))
				(if (== gAttitudeSetting 0)
					(= loop 2)
					(self posn: 254 271)
				else
					(self posn: 365 322)
				)
			)
			(2
				(= cel (= loop 0))
				(if (== gAttitudeSetting 0)
					(= loop 2)
					(self posn: 144 190)
				else
					(self posn: 123 172)
				)
			)
			(4
				(= cel (= loop 0))
				(if (== gAttitudeSetting 0)
					(= loop 2)
					(self posn: 255 79)
				else
					(self posn: 365 92)
				)
			)
			(8
				(= cel (= loop 0))
				(if (== gAttitudeSetting 0)
					(= loop 2)
					(self posn: 380 190)
				else
					(self posn: 516 283)
				)
			)
			(else
				(if (== gAttitudeSetting 0)
					(= loop 3)
					(= cel 0)
				else
					(= loop 1)
					(= cel 0)
				)
			)
		)
		(super init:)
		(EnableCursor)
		((KeyMouse objList:) release: add: self)
		(handleEventList add: self)
		(whoWonButton cycleSpeed: 20 setCycle: Fwd)
	)

	(method (dispose)
		((pokerRoom script:) state: 23 cycles: 1)
		((KeyMouse objList:) release:)
		(handleEventList delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(or
				(and
					(not (event claimed:))
					(not (& (event type:) evMOUSERELEASE))
					(not (and (<= 66 (event x:) 580) (<= 420 (event y:) 441)))
				)
				(proc0_2 event)
			)
			(cond
				((proc0_2 event)
					(self enterKey:)
					(= temp1 1)
					(event claimed: 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(if (= temp1 (self track:))
						(gSound2 play: 901)
					)
					(event claimed: 1)
				)
			)
		)
		(event claimed: 1)
		((pokerRoom script:) state: 23 cycles: 1)
		(self dispose:)
	)
)

(instance poker_opt of File
	(properties
		name {poker.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0
								format:
									{%d%d%d%d%2d%d%d%2d%d%d%d%d%d%d}
									global880
									global882
									global883
									global884
									global879
									global385
									global878
									global384
									local34
									0
									0
									0
									0
									0
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
				(= temp1 (Str new:))
				(self readString: temp1 2)
				(= global880 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global882 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global883 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global884 (temp1 asInteger:))
				(self readString: temp1 3)
				(= global879 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global385 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global878 (temp1 asInteger:))
				(self readString: temp1 3)
				(= global384 (temp1 asInteger:))
				(self readString: temp1 2)
				(= local34 (temp1 asInteger:))
				(self readString: temp1 2)
				(= temp2 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(if temp2
					(= local4 1)
				)
				(switch global883
					(0
						(= [global894 0] 5)
						(= [global891 0] 15)
					)
					(1
						(= [global894 0] 5)
						(= [global891 0] 25)
					)
					(2
						(= [global894 0] 25)
						(= [global891 0] 50)
					)
				)
				(switch global884
					(0
						(= [global894 1] 5)
						(= [global891 1] 25)
					)
					(1
						(= [global894 1] 5)
						(= [global891 1] 50)
					)
					(2
						(= [global894 1] 25)
						(= [global891 1] 100)
					)
				)
				(return 0)
			)
			(else
				(= global880 0)
				(= global882 0)
				(= global883 0)
				(= global884 0)
				(= [global891 0] 15)
				(= [global891 1] 25)
				(= [global894 0] 5)
				(= [global894 1] 5)
				(= global879 5)
				(= local34 0)
				(return 0)
			)
		)
	)
)

(class PokerHand of Hand
	(properties
		tookCard 0
		inGame 4
		handRank 0
		totalBet 0
		currentBet 0
		handNum 0
		lastPlay -2
		stillIn 1
		gull 3
		aggr 2
		stillInGame 1
		open 0
		lastRaise 0
		lastSaw 0
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(if gTray
			(if (gTray validPlay: param1)
				(self moveCard: gTray)
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
		else
			(param1 moveBack:)
		)
	)

	(method (cue)
		(super cue:)
		((ScriptID 15 6) setCycle: 0) ; littleCard
		(if gTray
			(gTray setCard: global458)
		)
		(= global395 (= global458 0))
	)

	(method (floater param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 6)
			(= temp1 6)
			(= param1 0)
			(= temp2 param2)
		else
			(= temp1 1)
			(= temp2 (Dealer curPlayer:))
		)
		(localproc_4 (temp2 handNum:))
		(switch (temp2 location:)
			(1
				(float1b loop: 0 cel: 0 setPri: 8 init:)
				(float1 loop: temp1 cel: param1 setPri: 9 init: hide:)
				(= temp0
					(+
						(float1b nsLeft:)
						(/
							(-
								(- (float1b nsRight:) (float1b nsLeft:))
								(- (float1 nsRight:) (float1 nsLeft:))
							)
							2
						)
					)
				)
				(float1 posn: temp0 (+ 8 (float1b y:)) show:)
			)
			(3
				(float2b loop: 0 cel: 0 setPri: 7 init:)
				(float2 loop: temp1 cel: param1 setPri: 8 init: hide:)
				(= temp0
					(+
						(float2b nsLeft:)
						(/
							(-
								(- (float2b nsRight:) (float2b nsLeft:))
								(- (float2 nsRight:) (float2 nsLeft:))
							)
							2
						)
					)
				)
				(float2 posn: temp0 (+ 8 (float2b y:)) show:)
			)
			(2
				(float3b loop: 0 cel: 0 setPri: 7 init:)
				(float3 loop: temp1 cel: param1 setPri: init: hide:)
				(= temp0
					(+
						(float3b nsLeft:)
						(/
							(-
								(- (float3b nsRight:) (float3b nsLeft:))
								(- (float3 nsRight:) (float3 nsLeft:))
							)
							2
						)
					)
				)
				(float3 posn: temp0 (+ 8 (float3b y:)) show:)
			)
			(4
				(float4b loop: 0 cel: 0 setPri: 7 init:)
				(float4 loop: temp1 cel: param1 setPri: 8 init: hide:)
				(= temp0
					(+
						(float4b nsLeft:)
						(/
							(-
								(- (float4b nsRight:) (float4b nsLeft:))
								(- (float4 nsRight:) (float4 nsLeft:))
							)
							2
						)
					)
				)
				(float4 posn: temp0 (+ 8 (float4b y:)) show:)
			)
		)
	)

	(method (whatAmI &tmp temp0 temp1 temp2)
		(= temp1 (Str format: {PENGIN16.DLL}))
		(global900 at: 0 4)
		(global900 at: 8 1)
		(global900 at: 19 ((self at: 0) rank:) ((self at: 0) suit:))
		(global900 at: 21 ((self at: 1) rank:) ((self at: 1) suit:))
		(global900 at: 23 ((self at: 2) rank:) ((self at: 2) suit:))
		(global900 at: 25 ((self at: 3) rank:) ((self at: 3) suit:))
		(global900 at: 27 ((self at: 4) rank:) ((self at: 4) suit:))
		(if (== (WinDLL 2 (temp1 data:) (global900 data:)) 0)
			(Printf {Error calling DLL})
		)
		(switch (= temp0 (global900 at: 61))
			(0
				(= temp0 0)
			)
			(1
				(= temp0 1)
			)
			(2
				(= temp0 2)
			)
			(4
				(= temp0 3)
			)
			(8
				(= temp0 4)
			)
			(16
				(= temp0 5)
			)
			(32
				(= temp0 6)
			)
			(64
				(= temp0 7)
			)
			(128
				(= temp0 8)
			)
		)
		(if (and (< (proc1100_12 -1) 3) (!= gAttitudeSetting 0) (self stillIn:))
			(cond
				((== (self type:) 0)
					(= global920 1)
					(gChar1 say: 1014 1 [local6 temp0] 0 1)
				)
				((> temp0 0)
					((self owner:)
						say: 1100 (+ ((self owner:) view:) 1) [local6 temp0] 0 1
					)
				)
				(else
					((self owner:)
						sayReg:
							1100
							(+ ((self owner:) view:) 1)
							[local6 temp0]
							0
							2
					)
				)
			)
		)
		(localproc_4 (self handNum:))
		(switch (self location:)
			(1
				(float1c hide:)
				(float1b loop: 0 cel: 0 setPri: 8 init:)
				(float1 loop: 3 cel: temp0 setPri: 9 init: hide:)
				(= temp2
					(+
						(float1b nsLeft:)
						(/
							(-
								(- (float1b nsRight:) (float1b nsLeft:))
								(- (float1 nsRight:) (float1 nsLeft:))
							)
							2
						)
					)
				)
				(float1 posn: temp2 (+ 8 (float1b y:)) show:)
			)
			(3
				(float2c hide:)
				(float2b loop: 0 cel: 0 setPri: 7 init:)
				(float2 loop: 3 cel: temp0 setPri: 8 init: hide:)
				(= temp2
					(+
						(float2b nsLeft:)
						(/
							(-
								(- (float2b nsRight:) (float2b nsLeft:))
								(- (float2 nsRight:) (float2 nsLeft:))
							)
							2
						)
					)
				)
				(float2 posn: temp2 (+ 8 (float2b y:)) show:)
			)
			(2
				(float3c hide:)
				(float3b loop: 0 cel: 0 setPri: 7 init:)
				(float3 loop: 3 cel: temp0 setPri: 8 init: hide:)
				(= temp2
					(+
						(float3b nsLeft:)
						(/
							(-
								(- (float3b nsRight:) (float3b nsLeft:))
								(- (float3 nsRight:) (float3 nsLeft:))
							)
							2
						)
					)
				)
				(float3 posn: temp2 (+ 8 (float3b y:)) show:)
			)
			(4
				(float4c hide:)
				(float4b loop: 0 cel: 0 setPri: 7 init:)
				(float4 loop: 3 cel: temp0 setPri: 8 init: hide:)
				(= temp2
					(+
						(float4b nsLeft:)
						(/
							(-
								(- (float4b nsRight:) (float4b nsLeft:))
								(- (float4 nsRight:) (float4 nsLeft:))
							)
							2
						)
					)
				)
				(float4 posn: temp2 (+ 8 (float4b y:)) show:)
			)
		)
		(self handRank: temp0)
		(temp1 dispose:)
	)

	(method (calcScore param1)
		(if (and argc param1)
			(super calcScore:)
		else
			(= tempTotal (localproc_1 self))
		)
	)

	(method (think &tmp temp0 temp1 temp2)
		(= temp2 (Str format: {PENGIN16.DLL}))
		(global900 at: 0 3)
		(global900 at: 8 1)
		(global900 at: 19 ((self at: 0) rank:) ((self at: 0) suit:))
		(global900 at: 21 ((self at: 1) rank:) ((self at: 1) suit:))
		(global900 at: 23 ((self at: 2) rank:) ((self at: 2) suit:))
		(global900 at: 25 ((self at: 3) rank:) ((self at: 3) suit:))
		(global900 at: 27 ((self at: 4) rank:) ((self at: 4) suit:))
		(if (== (WinDLL 2 (temp2 data:) (global900 data:)) 0)
			(Printf {Error calling DLL})
		)
		(= temp0 0)
		(if (global900 at: 67)
			(= global458 ((Dealer curPlayer:) at: 4))
			((Dealer curPlayer:) moveCard: discardHand 0)
			(++ temp0)
		)
		(if (global900 at: 66)
			(= global458 ((Dealer curPlayer:) at: 3))
			((Dealer curPlayer:) moveCard: discardHand 0)
			(++ temp0)
		)
		(if (global900 at: 65)
			(= global458 ((Dealer curPlayer:) at: 2))
			((Dealer curPlayer:) moveCard: discardHand 0)
			(++ temp0)
		)
		(if (global900 at: 64)
			(= global458 ((Dealer curPlayer:) at: 1))
			((Dealer curPlayer:) moveCard: discardHand 0)
			(++ temp0)
		)
		(if (global900 at: 63)
			(= global458 ((Dealer curPlayer:) at: 0))
			((Dealer curPlayer:) moveCard: discardHand 0)
			(++ temp0)
		)
		(temp2 dispose:)
		((Dealer curPlayer:) tookCard: temp0)
		(= global395 0)
		(self floater: temp0)
		(return temp0)
	)
)

(instance hand1 of PokerHand
	(properties
		x 190
		y 312
		handNumber 3
		faceUp 1
		total 500
		centerX 320
		centerY 312
		stillIn 0
		gull 1
	)

	(method (init &tmp temp0))
)

(instance hand2 of PokerHand
	(properties
		x 70
		y 96
		handDirection 2
		type 1
		handNumber 4
		location 4
		total 500
		centerX 70
		centerY 240
		handNum 1
		stillIn 0
	)

	(method (init &tmp temp0)
		(self faceUp: local4)
		(self gull: (>> gSkill $0008))
		(self aggr: (& gSkill $00ff))
	)
)

(instance hand3 of PokerHand
	(properties
		x 190
		y 20
		type 1
		handNumber 1
		location 1
		total 500
		centerX 320
		centerY 20
		handNum 2
		stillIn 0
	)

	(method (init &tmp temp0)
		(self faceUp: local4)
		(self gull: (>> global197 $0008))
		(self aggr: (& global197 $00ff))
	)
)

(instance hand4 of PokerHand
	(properties
		x 500
		y 96
		handDirection 2
		type 1
		handNumber 2
		location 2
		total 500
		centerX 500
		centerY 240
		handNum 3
		stillIn 0
	)

	(method (init &tmp temp0)
		(self faceUp: local4)
		(self gull: (>> global198 $0008))
		(self aggr: (& global198 $00ff))
	)
)

(instance discardHand of PokerHand
	(properties
		x 320
		y 600
		handDirection 2
		type 1
		handNumber 6
		centerX 320
		centerY 600
	)
)

(instance hand1Pile of HandPile
	(properties
		owner 1
		x 420
		y 400
	)
)

(instance hand2Pile of HandPile
	(properties
		owner 2
		x 90
		y 400
	)
)

(instance hand3Pile of HandPile
	(properties
		owner 3
		x 10
		y 80
	)
)

(instance hand4Pile of HandPile
	(properties
		owner 4
		x 380
		y 80
	)
)

(instance potPile of HandPile
	(properties
		owner 5
		x 255
		y 260
	)
)

(instance float1 of View
	(properties
		x 265
		y 55
		view 1179
	)

	(method (init)
		(self setPri: 9)
		(super init:)
	)
)

(instance float1b of View
	(properties
		x 260
		y 50
		view 1179
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float1c of View
	(properties
		x 260
		y 50
		view 1179
	)

	(method (init)
		(super init:)
	)
)

(instance float2 of View
	(properties
		x 265
		y 347
		view 1179
	)

	(method (init)
		(self setPri: 9)
		(super init:)
	)
)

(instance float2b of View
	(properties
		x 260
		y 342
		view 1179
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float2c of View
	(properties
		x 260
		y 342
		view 1179
	)

	(method (init)
		(super init:)
	)
)

(instance float3 of View
	(properties
		x 435
		y 245
		view 1179
	)

	(method (init)
		(self setPri: 9)
		(if (and (== loop 2) (or (== cel 3) (== cel 0)))
			(= x 505)
		else
			(= x 435)
		)
		(super init:)
	)
)

(instance float3b of View
	(properties
		x 430
		y 240
		view 1179
	)

	(method (init)
		(self setPri: 8)
		(if (== cel 2)
			(= x 500)
		else
			(= x 430)
		)
		(super init:)
	)
)

(instance float3c of View
	(properties
		x 430
		y 240
		view 1179
	)

	(method (init)
		(super init:)
	)
)

(instance float4 of View
	(properties
		x 75
		y 245
		view 1179
	)

	(method (init)
		(self setPri: 9)
		(super init:)
	)
)

(instance float4b of View
	(properties
		x 70
		y 240
		view 1179
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float4c of View
	(properties
		x 70
		y 240
		view 1179
	)

	(method (init)
		(super init:)
	)
)

(instance floatPot of View
	(properties
		x 320
		y 200
		view 24
	)

	(method (init)
		(self setPri: 7)
		(super init:)
	)
)

(instance floatPotb of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance floatPotNum1 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance floatPotNum2 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance floatPotNum3 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance floatPotNum4 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float1Num0 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float1Num1 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float1Num2 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float1Num3 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float2Num0 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float2Num1 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float2Num2 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float2Num3 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float3Num0 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float3Num1 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float3Num2 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float3Num3 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float4Num0 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float4Num1 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float4Num2 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance float4Num3 of View
	(properties
		x 320
		y 205
		view 24
	)

	(method (init)
		(self setPri: 8)
		(super init:)
	)
)

(instance directionArrow of View
	(properties
		view 214
	)

	(method (init param1)
		(if (>= param1 0)
			(if param1
				(self posn: (+ (Arrow x:) 44) (Arrow y:))
			else
				(self posn: (- (Arrow x:) 15) (Arrow y:))
			)
			(self cel: param1 ignoreActors: setPri: 3 show:)
			(super init:)
		else
			(self dispose:)
		)
	)
)

