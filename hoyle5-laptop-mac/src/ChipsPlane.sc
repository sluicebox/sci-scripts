;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Plane)
(use Actor)
(use System)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(if (((ScriptID 1100 13) at: temp0) open:) ; theHands
			(return 1)
		)
	)
	(return 0)
)

(class ChipsPlane of Plane
	(properties)
)

(class ChipCast of Cast
	(properties)
)

(class Chip of View
	(properties
		priority 20
		view 1178
		value 0
		inView 0
	)

	(method (init)
		(super init: gChipCast)
		(= nsTop y)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(self plane: (gChipCast plane:))
		(UpdatePlane (gChipCast plane:))
	)

	(method (dispose)
		(gChipCast delete: self)
		(super dispose: &rest)
	)

	(method (show)
		(self inView: 1)
		(super show: &rest)
	)

	(method (hide)
		(self inView: 0)
		(super hide: &rest)
	)
)

(instance WhiteChip of Chip
	(properties
		loop 2
		value 5
	)
)

(instance RedChip of Chip
	(properties
		value 25
	)
)

(instance BlueChip of Chip
	(properties
		loop 1
		value 50
	)
)

(class ChipPile of List
	(properties
		amount 0
		x 0
		y 0
	)

	(method (deleteChips param1 param2 &tmp temp0)
		(-= amount param1)
		(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
			(switch param2
				(0
					((self at: (- (self size:) 1)) hide: dispose:)
					(self delete: (self at: (- (self size:) 1)))
				)
				(1
					((self at: (- (self size:) 1)) hide: dispose:)
					(self delete: (self at: (- (self size:) 1)))
				)
				(2
					((self at: (- (self size:) 1)) hide: dispose:)
					(self delete: (self at: (- (self size:) 1)))
				)
			)
		)
	)

	(method (addChips param1 param2 &tmp temp0)
		(+= amount param1)
		(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
			(switch param2
				(0
					(self addToEnd: (WhiteChip new:))
				)
				(1
					(self addToEnd: (RedChip new:))
				)
				(2
					(self addToEnd: (BlueChip new:))
				)
			)
		)
	)

	(method (play param1 param2)
		(self deleteChips: param1 param2)
	)

	(method (calcNextY param1)
		(-= param1 4)
	)

	(method (scatter param1 &tmp temp0 temp1)
		(= temp1 y)
		(for ((= temp0 0)) (< temp0 (self amount:)) ((++ temp0))
			(switch param1
				(0
					(if (not ((self at: temp0) inView:))
						((self at: temp0)
							x: (Random 200 400)
							y: (Random 150 250)
							setPri: (- 20 (- 15 temp0))
							init:
							show:
						)
					)
				)
				(1
					(if (not ((self at: temp0) inView:))
						((self at: temp0)
							x: (Random 200 400)
							y: (Random 150 250)
							setPri: (- 20 (- 15 temp0))
							init:
							show:
						)
					)
				)
				(2
					(if (not ((self at: temp0) inView:))
						((self at: temp0)
							x: (Random 200 400)
							y: (Random 150 250)
							setPri: (- 20 (- 15 temp0))
							init:
							show:
						)
					)
				)
			)
		)
	)

	(method (show param1 param2 &tmp temp0 temp1)
		(= temp1 y)
		(if (== param2 (ScriptID 1100 3)) ; potPile
			(self scatter: param1)
		else
			(for ((= temp0 0)) (< temp0 (self amount:)) ((++ temp0))
				(switch param1
					(0
						((self at: temp0)
							x: x
							y: (= temp1 (self calcNextY: temp1))
							setPri: (- 60 (- 15 temp0))
							init:
							show:
						)
					)
					(1
						((self at: temp0)
							x: (+ x 45)
							y: (= temp1 (self calcNextY: temp1))
							setPri: (- 60 (- 15 temp0))
							init:
							show:
						)
					)
					(2
						(cond
							((> temp0 29)
								((self at: temp0)
									x: (+ x 112)
									y: (+ (= temp1 (self calcNextY: temp1)) 100)
									init:
									setPri: (- 20 (- 15 temp0))
									show:
								)
							)
							((> temp0 19)
								((self at: temp0)
									x: (+ x 67)
									y: (+ (= temp1 (self calcNextY: temp1)) 60)
									init:
									setPri: (- 20 (- 15 temp0))
									show:
								)
							)
							((> temp0 9)
								((self at: temp0)
									x: (+ x 22)
									y: (+ (= temp1 (self calcNextY: temp1)) 20)
									init:
									setPri: (- (- 20 (- 15 temp0)) 5)
									show:
								)
							)
							(else
								((self at: temp0)
									x: (+ x 90)
									y: (= temp1 (self calcNextY: temp1))
									setPri: (- 60 (- 15 temp0))
									init:
									show:
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance WhitePile of ChipPile
	(properties)
)

(instance RedPile of ChipPile
	(properties)
)

(instance BluePile of ChipPile
	(properties)
)

(instance BluePile2 of ChipPile ; UNUSED
	(properties)
)

(instance BluePile3 of ChipPile ; UNUSED
	(properties)
)

(class HandPile of List
	(properties
		owner 0
		x 0
		y 0
		total 0
	)

	(method (init param1)
		(super init:)
		(self add: (WhitePile new:) (RedPile new:) (BluePile new:))
		(self divideUpAdd: param1)
		(self realign:)
	)

	(method (show param1 &tmp temp0)
		((self at: 0) x: x y: y show: 0 param1)
		((self at: 1) x: x y: y show: 1 param1)
		((self at: 2) x: x y: y show: 2 param1)
	)

	(method (hideAll)
		(= total 0)
		((self at: 0) deleteChips: ((self at: 0) amount:) 0)
		((self at: 1) deleteChips: ((self at: 1) amount:) 1)
		((self at: 2) deleteChips: ((self at: 2) amount:) 2)
	)

	(method (realign &tmp temp0 temp1)
		(if (<= ((self at: 1) amount:) 8)
			(= temp0 (/ (- 10 ((self at: 1) amount:)) 2))
			(if (>= ((self at: 2) amount:) temp0)
				(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
					((self at: 1) addChips: 2 1)
					((self at: 2) deleteChips: 1 2)
				)
			else
				(for ((= temp1 0)) (< temp1 ((self at: 2) amount:)) ((++ temp1))
					((self at: 1) addChips: 2 1)
					((self at: 2) deleteChips: 1 2)
				)
			)
		)
		(if (<= ((self at: 0) amount:) 5)
			(= temp0 (/ (- 10 ((self at: 0) amount:)) 5))
			(if (>= ((self at: 1) amount:) temp0)
				(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
					((self at: 0) addChips: 5 0)
					((self at: 1) deleteChips: 1 1)
				)
			else
				(for ((= temp1 0)) (< temp1 ((self at: 1) amount:)) ((++ temp1))
					((self at: 0) addChips: 5 0)
					((self at: 1) deleteChips: 1 1)
				)
			)
		)
		(if (<= ((self at: 1) amount:) 8)
			(= temp0 (/ (- 10 ((self at: 1) amount:)) 2))
			(if (>= ((self at: 2) amount:) temp0)
				(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
					((self at: 1) addChips: 2 1)
					((self at: 2) deleteChips: 1 2)
				)
			else
				(for ((= temp1 0)) (< temp1 ((self at: 2) amount:)) ((++ temp1))
					((self at: 1) addChips: 2 1)
					((self at: 2) deleteChips: 1 2)
				)
			)
		)
		(if (> ((self at: 0) amount:) 10)
			((self at: 0) deleteChips: 5 0)
			((self at: 1) addChips: 1 1)
		)
		(if (> ((self at: 1) amount:) 10)
			((self at: 1) deleteChips: 4 1)
			((self at: 2) addChips: 2 2)
		)
		(self show:)
	)

	(method (divideUpAdd param1 &tmp temp0 temp1 temp2)
		(+= total param1)
		(= temp0 0)
		(= temp1 0)
		(= temp2 0)
		(if (>= param1 50)
			(= temp2 (/ param1 50))
			(-= param1 (* 50 temp2))
		)
		(if (>= param1 25)
			(= temp1 (/ param1 25))
			(-= param1 (* 25 temp1))
		)
		(if (>= param1 5)
			(= temp0 (/ param1 5))
		)
		(if (== self (ScriptID 1100 3)) ; potPile
			(= temp0 local0)
			(= temp1 local1)
			(= temp2 local2)
		)
		((self at: 0) addChips: temp0 0)
		((self at: 1) addChips: temp1 1)
		((self at: 2) addChips: temp2 2)
	)

	(method (divideUpDelete param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(-= total param1)
		(= temp4 param1)
		(= temp3 1)
		(= temp5 0)
		(while temp3
			(= param1 temp4)
			(= temp0 0)
			(= temp1 0)
			(= temp2 0)
			(if (>= param1 50)
				(if (<= (= temp2 (/ param1 50)) ((self at: 2) amount:))
					(-= param1 (* 50 temp2))
				else
					(-= param1 (* 50 ((self at: 2) amount:)))
					(= temp2 ((self at: 2) amount:))
				)
			)
			(if (>= param1 25)
				(if (<= (= temp1 (/ param1 25)) ((self at: 1) amount:))
					(-= param1 (* 25 temp1))
				else
					(-= param1 (* 25 ((self at: 1) amount:)))
					(= temp1 ((self at: 1) amount:))
				)
			)
			(if (>= param1 5)
				(= temp0 (/ param1 5))
			)
			(if
				(or
					(> temp0 ((self at: 0) amount:))
					(> temp1 ((self at: 1) amount:))
					(> temp2 ((self at: 2) amount:))
				)
				(self realign:)
				(= temp3 1)
				(if (> (++ temp5) 2)
					(= temp3 0)
				)
			else
				(= temp3 0)
			)
		)
		(= local0 temp0)
		(= local1 temp1)
		(= local2 temp2)
		(if (localproc_0)
			(cond
				((== (+ temp0 temp1 temp2) 1)
					(gSound play: 604)
				)
				((< (+ temp0 temp1 temp2) 5)
					(gSound play: 605)
				)
				((>= (+ temp0 temp1 temp2) 6)
					(gSound play: 606)
				)
			)
		)
		((self at: 0) play: temp0 0)
		((self at: 1) play: temp1 1)
		((self at: 2) play: temp2 2)
	)

	(method (inMyRect param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 x)
		(= temp2 (+ x 130))
		(= temp3 (- y 50))
		(= temp4 y)
		(if (and (<= temp1 (param1 x:) temp2) (<= temp3 (param1 y:) temp4))
			(= temp0 1)
		else
			(= temp0 0)
		)
		(return temp0)
	)

	(method (handleEvent &tmp temp0))

	(method (play param1 param2)
		(if (!= param2 (ScriptID 1100 3)) ; potPile
			(self hideAll:)
		else
			(self divideUpDelete: param1)
		)
		(param2 divideUpAdd: param1)
		(if (!= param2 (ScriptID 1100 3)) ; potPile
			(param2 realign:)
		)
		(param2 show: param2)
	)

	(method (ante param1)
		(self play: param1 (ScriptID 1100 3)) ; potPile
	)

	(method (emptyPiles)
		((self at: 0) deleteChips: ((self at: 0) amount:))
		((self at: 1) deleteChips: ((self at: 1) amount:))
		((self at: 2) deleteChips: ((self at: 2) amount:))
	)
)

