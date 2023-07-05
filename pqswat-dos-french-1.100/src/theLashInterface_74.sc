;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Button)
(use LashInterface)
(use Motion)
(use Actor)

(public
	theLashInterface 0
)

(instance theLashInterface of LashInterface
	(properties)

	(method (addItems)
		(lashBackground init:)
		(openButn init:)
		(closedButn init:)
		(lockedButn init:)
		(frontButn init:)
		(backButn init:)
		(initiateButn init:)
		(yesButn init:)
		(noButn init:)
		(upButn init:)
		(downButn init:)
		(doorButn init:)
		(windowButn init:)
		(coverButn init:)
		(pull_backButn init:)
		(clearButn init:)
		(containmentButn init:)
		(compromisedButn init:)
		(closetButn init:)
		(entry_teamButn init:)
		(trailerButn init:)
		(in_positionButn init:)
		(in_controlButn init:)
		(leftButn init:)
		(rightButn init:)
		(suspectButn init:)
		(hostageButn init:)
		(coming_outButn init:)
		(gasButn init:)
		(ramButn init:)
		(high_groundButn init:)
		(l_oneButn init:)
		(l_twoButn init:)
		(l_threeButn init:)
		(l_fourButn init:)
		(l_fiveButn init:)
		(s_oneButn init:)
		(s_twoButn init:)
		(s_threeButn init:)
		(s_fourButn init:)
		(transmitButn init:)
		(leftFlash init:)
		(rightFlash init:)
	)

	(method (flashDoits)
		(rightFlash doit:)
		(leftFlash doit:)
	)
)

(instance lashBackground of View
	(properties
		view 17
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)
)

(instance openButn of LashButton
	(properties
		loop 1
		enumType 1
		buttVerb 136
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance closedButn of LashButton
	(properties
		loop 2
		enumType 2
		buttVerb 182
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance lockedButn of LashButton
	(properties
		loop 3
		enumType 3
		buttVerb 183
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance frontButn of LashButton
	(properties
		loop 4
		enumType 4
		buttVerb 184
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance backButn of LashButton
	(properties
		loop 5
		enumType 5
		buttVerb 185
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance initiateButn of LashButton
	(properties
		loop 6
		enumType 6
		buttVerb 59
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance yesButn of LashButton
	(properties
		loop 7
		enumType 7
		buttVerb 145
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance noButn of LashButton
	(properties
		loop 8
		enumType 8
		buttVerb 146
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance upButn of LashButton
	(properties
		loop 9
		enumType 9
		buttVerb 186
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance downButn of LashButton
	(properties
		loop 10
		enumType 10
		buttVerb 140
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance doorButn of LashButton
	(properties
		loop 11
		enumType 11
		buttVerb 88
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance windowButn of LashButton
	(properties
		loop 12
		enumType 12
		buttVerb 192
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance coverButn of LashButton
	(properties
		loop 13
		enumType 14
		buttVerb 95
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance pull_backButn of LashButton
	(properties
		loop 14
		enumType 15
		buttVerb 188
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance clearButn of LashButton
	(properties
		loop 15
		enumType 16
		buttVerb 98
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance containmentButn of LashButton
	(properties
		loop 16
		enumType 17
		buttVerb 189
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance compromisedButn of LashButton
	(properties
		loop 17
		enumType 18
		buttVerb 87
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance closetButn of LashButton
	(properties
		loop 18
		enumType 13
		buttVerb 190
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance entry_teamButn of LashButton
	(properties
		loop 19
		enumType 19
		buttVerb 191
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance trailerButn of LashButton
	(properties
		loop 20
		enumType 20
		buttVerb 101
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance in_positionButn of LashButton
	(properties
		loop 21
		enumType 43
		buttVerb 77
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance in_controlButn of LashButton
	(properties
		loop 22
		enumType 42
		buttVerb 139
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance leftButn of LashButton
	(properties
		loop 23
		enumType 78
		buttVerb 134
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance rightButn of LashButton
	(properties
		loop 24
		enumType 79
		buttVerb 135
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance suspectButn of LashButton
	(properties
		loop 25
		enumType 21
		buttVerb 89
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance hostageButn of LashButton
	(properties
		loop 26
		enumType 22
		buttVerb 90
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance coming_outButn of LashButton
	(properties
		loop 27
		enumType 23
		buttVerb 141
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance gasButn of LashButton
	(properties
		loop 28
		enumType 24
		buttVerb 67
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance ramButn of LashButton
	(properties
		loop 29
		enumType 25
		buttVerb 66
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance high_groundButn of LashButton
	(properties
		loop 30
		enumType 26
		buttVerb 37
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance l_oneButn of LashButton
	(properties
		loop 31
		enumType 28
		buttVerb 156
	)

	(method (init)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: level)
		)
		(super select: param1 param2 &rest)
	)
)

(instance l_twoButn of LashButton
	(properties
		loop 32
		enumType 29
		buttVerb 157
	)

	(method (init)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: level)
		)
		(super select: param1 param2 &rest)
	)
)

(instance l_threeButn of LashButton
	(properties
		loop 33
		enumType 30
		buttVerb 158
	)

	(method (init)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: level)
		)
		(super select: param1 param2 &rest)
	)
)

(instance l_fourButn of LashButton
	(properties
		loop 34
		enumType 31
		buttVerb 159
	)

	(method (init)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: level)
		)
		(super select: param1 param2 &rest)
	)
)

(instance l_fiveButn of LashButton
	(properties
		loop 35
		enumType 32
		buttVerb 160
	)

	(method (init)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: level)
		)
		(super select: param1 param2 &rest)
	)
)

(instance s_oneButn of LashButton
	(properties
		loop 36
		enumType 34
		buttVerb 156
	)

	(method (init)
		(= x (+ (lashBackground x:) 122))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
	)
)

(instance s_twoButn of LashButton
	(properties
		loop 37
		enumType 35
		buttVerb 157
	)

	(method (init)
		(= x (+ (lashBackground x:) 198))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
	)
)

(instance s_threeButn of LashButton
	(properties
		loop 38
		enumType 36
		buttVerb 158
	)

	(method (init)
		(= x (+ (lashBackground x:) 274))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
	)
)

(instance s_fourButn of LashButton
	(properties
		loop 39
		enumType 37
		buttVerb 159
	)

	(method (init)
		(= x (+ (lashBackground x:) 350))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
	)
)

(instance level of LashButton
	(properties
		buttVerb 153
	)

	(method (doVerb))

	(method (select))
)

(instance side of LashButton
	(properties
		buttVerb 154
	)

	(method (doVerb))

	(method (select))
)

(instance transmitButn of Button
	(properties
		view 17
		loop 40
	)

	(method (init)
		(= x (+ (lashBackground x:) 196))
		(= y (+ (lashBackground y:) 206))
		(super init: &rest)
	)

	(method (doVerb)
		(leftFlash setCycle: Fwd)
		(rightFlash setCycle: Fwd)
		(self setActive: 0)
		(gLashInterface transmit:)
	)
)

(instance leftFlash of Prop
	(properties
		view 17
		loop 42
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

(instance rightFlash of Prop
	(properties
		view 17
		loop 43
	)

	(method (init)
		(= x (+ (lashBackground x:) 446))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

