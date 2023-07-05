;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 602)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Sound)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	spinnerScript 0
	spinnerButton 1
	spinnerList 2
	spinner 3
	associateList 4
	snakes_opt 5
	sound3 6
	sound4 7
	sound5 8
	theTitle 9
	upLeftFront 10
	upRightFront 11
	lowLeftFront 12
	lowRightFront 13
)

(local
	[local0 12] = [3 4 4 5 5 6 6 1 1 2 2 3]
	[local12 11] = [0 95 161 236 311 314 315 243 166 88 64]
	[local23 11] = [0 177 187 183 179 118 57 57 55 53 114]
	local34
)

(instance spinnerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (global178 type:) 2)
					(proc0_4 20)
				)
				(gSound stop:)
				(gSound2 stop:)
				(gPropList eachElementDo: #dispose)
				(= global452 0)
				(= global453 0)
				(KeyMouse setList: spinnerList)
				(if
					(and
						(not global456)
						(or
							(> 69 (global178 sqrNum:) 58)
							(> (global178 sqrNum:) 77)
						)
					)
					(= local34 9)
					(= global456 1)
				)
				(if (and global456 (moveTest doit:))
					(spinner posn: (- global454 27) (- global455 22))
					(spinnerButton posn: global454 global455)
				)
				(global178 loop: 8 cel: 0 setCycle: Fwd)
				(if (not global457)
					(spinner show:)
					(spinnerButton show:)
				)
				(= global280 (= global281 1))
				(if global282
					(gGame
						setCursor: gTheCursor 1 (- global454 35) (- global455 2)
					)
				)
				(if (> (global178 sqrNum:) 81)
					(gStar setPri: 15 setLoop: 5 setCycle: Fwd)
					(switch (global178 sqrNum:)
						(82
							(gStar posn: (- global454 2) (- global455 23))
							(= global285 6)
						)
						(83
							(gStar posn: (- global454 15) (- global455 41))
							(= global285 5)
						)
						(84
							(gStar posn: (- global454 39) (- global455 43))
							(= global285 4)
						)
						(85
							(gStar posn: (- global454 53) (- global455 22))
							(= global285 3)
						)
						(86
							(gStar posn: (- global454 38) (- global455 3))
							(= global285 2)
						)
						(87
							(gStar posn: (- global454 14) (- global455 4))
							(= global285 1)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(if (!= (global178 type:) 2)
					(proc0_3)
				else
					(= cycles 1)
				)
			)
			(2
				(proc0_4)
				(if (== (global178 type:) 2)
					(Wait 1)
					(Wait 20)
					(spinnerButton flash:)
					(gSound play: 900 setLoop: 1)
				)
				(spinner cycleSpeed: 1 setCycle: Fwd)
				(= ticks (Random 50 70))
			)
			(3
				(spinner cycleSpeed: (+ (spinner cycleSpeed:) 1))
				(= ticks (Random 30 50))
			)
			(4
				(spinner cycleSpeed: (+ (spinner cycleSpeed:) 1))
				(= ticks (Random 20 30))
			)
			(5
				(spinner cycleSpeed: (+ (spinner cycleSpeed:) 1))
				(= ticks 20)
			)
			(6
				(spinner cycleSpeed: (+ (spinner cycleSpeed:) 2))
				(= ticks 20)
			)
			(7
				(spinner cycleSpeed: (+ (spinner cycleSpeed:) 3))
				(= ticks 20)
			)
			(8
				(spinner setCycle: 0)
				(= global276 [local0 (spinner cel:)])
				(= ticks 20)
			)
			(9
				(if (<= global276 global285)
					(= global285 100)
					(gStar posn: 350 100 setLoop: 2 stopUpd:)
					(= global279 (+ (global178 sqrNum:) global276))
					(= global281 0)
					(KeyMouse setList: gSlSquares)
					(= global284 (gSlSquares at: (- global279 1)))
					(if (== (global178 type:) 2)
						(= global283 (gSlSquares at: (- global279 1)))
						(global178 setScript: gMoveScript)
					else
						(proc0_3)
						(if global274
							(gStar
								x: (+ (global284 nsLeft:) 11)
								y: (+ (global284 nsTop:) 11)
								setCycle: Fwd
							)
						)
					)
				else
					(gSound play: 909 setLoop: 1)
					(= global281 0)
					(gStar stopUpd: setLoop: 2 posn: 350 100 cel: 0)
					((ScriptID 600 3) doit:) ; lineUp
					(= global285 100)
					(gSnakesScript cue:)
					(Wait 1)
					(Wait 10)
				)
				(= ticks 1)
			)
			(10
				(if global282
					(gGame
						setCursor: gTheCursor 1 (global178 x:) (global178 y:)
					)
				)
				(= ticks 30)
			)
			(11
				(gSnakesScript setScript: 0)
			)
		)
	)
)

(instance spinner of Prop
	(properties)

	(method (init)
		(self
			view: 600
			setLoop: 1
			setPri: 15
			posn: (- global454 27) (- global455 22)
			ignoreActors:
			startUpd:
		)
		(super init:)
	)
)

(instance spinnerButton of TrackingView
	(properties)

	(method (init)
		(self
			view: 600
			setLoop: 0
			cel: 0
			setPri: 14
			posn: global454 global455
			ignoreActors:
			stopUpd:
		)
		(self associatedObj: associateList trackingCode: spinKidTrack)
		(super init:)
	)

	(method (handleEvent event)
		(if (and global280 (super handleEvent: event))
			(event claimed: 1)
			(gSound play: 900 setLoop: 1)
			(spinnerScript cue:)
			(= global280 0)
		)
		(event claimed:)
	)
)

(instance spinKidTrack of Code
	(properties)

	(method (init)
		(proc0_1)
	)

	(method (doit)
		(global178 doit:)
		(gStar doit:)
	)
)

(instance spinnerList of List
	(properties)
)

(instance associateList of List
	(properties)
)

(instance snakes_opt of File
	(properties
		name {snakes.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString: (Format @temp0 602 0 global275 global274) ; "%d%d"
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(if
					(or
						(!=
							(= global275
								(ReadNumber (self readString: @temp20 2))
							)
							0
						)
						(!= global275 1)
					)
					(= global275 1)
				)
				(if
					(or
						(!=
							(= global274
								(ReadNumber (self readString: @temp20 2))
							)
							0
						)
						(!= global274 1)
					)
					(= global274 0)
				)
				(self close:)
				(return 0)
			)
			(else
				(= global275 1)
				(= global274 0)
				(return 0)
			)
		)
	)
)

(instance moveTest of Code
	(properties)

	(method (doit)
		(switch (((ScriptID 600 4) at: (- (global178 sqrNum:) 1)) row:) ; slSquares
			(1
				(if
					(or
						(== local34 1)
						(== local34 2)
						(== local34 3)
						(== local34 4)
						(== local34 8)
					)
					(cond
						((checkCode doit: 9)
							(= global454 [local12 9])
							(= global455 [local23 9])
							(= local34 9)
							(return 1)
						)
						((checkCode doit: 6)
							(= global454 [local12 6])
							(= global455 [local23 6])
							(= local34 6)
							(return 1)
						)
						((checkCode doit: 7)
							(= global454 [local12 7])
							(= global455 [local23 7])
							(= local34 7)
							(return 1)
						)
						((checkCode doit: 5)
							(= global454 [local12 5])
							(= global455 [local23 5])
							(= local34 5)
							(return 1)
						)
						((checkCode doit: 10)
							(= global454 [local12 10])
							(= global455 [local23 10])
							(= local34 10)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
			(2
				(if
					(or
						(== local34 1)
						(== local34 2)
						(== local34 3)
						(== local34 4)
						(== local34 8)
						(== local34 10)
					)
					(cond
						((checkCode doit: 9)
							(= global454 [local12 9])
							(= global455 [local23 9])
							(= local34 9)
							(return 1)
						)
						((checkCode doit: 6)
							(= global454 [local12 6])
							(= global455 [local23 6])
							(= local34 6)
							(return 1)
						)
						((checkCode doit: 7)
							(= global454 [local12 7])
							(= global455 [local23 7])
							(= local34 7)
							(return 1)
						)
						((checkCode doit: 5)
							(= global454 [local12 5])
							(= global455 [local23 5])
							(= local34 5)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
			(3
				(if
					(or
						(== local34 1)
						(== local34 2)
						(== local34 3)
						(== local34 4)
						(== local34 5)
						(== local34 10)
					)
					(cond
						((checkCode doit: 9)
							(= global454 [local12 9])
							(= global455 [local23 9])
							(= local34 9)
							(return 1)
						)
						((checkCode doit: 6)
							(= global454 [local12 6])
							(= global455 [local23 6])
							(= local34 6)
							(return 1)
						)
						((checkCode doit: 7)
							(= global454 [local12 7])
							(= global455 [local23 7])
							(= local34 7)
							(return 1)
						)
						((checkCode doit: 8)
							(= global454 [local12 8])
							(= global455 [local23 8])
							(= local34 8)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
			(4
				(if
					(or
						(== local34 1)
						(== local34 3)
						(== local34 4)
						(== local34 5)
						(== local34 9)
						(== local34 10)
					)
					(cond
						((checkCode doit: 6)
							(= global454 [local12 6])
							(= global455 [local23 6])
							(= local34 6)
							(return 1)
						)
						((checkCode doit: 2)
							(= global454 [local12 2])
							(= global455 [local23 2])
							(= local34 2)
							(return 1)
						)
						((checkCode doit: 7)
							(= global454 [local12 7])
							(= global455 [local23 7])
							(= local34 7)
							(return 1)
						)
						((checkCode doit: 8)
							(= global454 [local12 8])
							(= global455 [local23 8])
							(= local34 8)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
			(5
				(if
					(or
						(== local34 1)
						(== local34 5)
						(== local34 6)
						(== local34 7)
						(== local34 8)
						(== local34 10)
					)
					(cond
						((checkCode doit: 9)
							(= global454 [local12 9])
							(= global455 [local23 9])
							(= local34 9)
							(return 1)
						)
						((checkCode doit: 2)
							(= global454 [local12 2])
							(= global455 [local23 2])
							(= local34 2)
							(return 1)
						)
						((checkCode doit: 3)
							(= global454 [local12 3])
							(= global455 [local23 3])
							(= local34 3)
							(return 1)
						)
						((checkCode doit: 4)
							(= global454 [local12 4])
							(= global455 [local23 4])
							(= local34 4)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
			(6
				(if
					(or
						(== local34 5)
						(== local34 6)
						(== local34 7)
						(== local34 8)
						(== local34 9)
						(== local34 10)
					)
					(cond
						((checkCode doit: 2)
							(= global454 [local12 2])
							(= global455 [local23 2])
							(= local34 2)
							(return 1)
						)
						((checkCode doit: 3)
							(= global454 [local12 3])
							(= global455 [local23 3])
							(= local34 3)
							(return 1)
						)
						((checkCode doit: 1)
							(= global454 [local12 1])
							(= global455 [local23 1])
							(= local34 1)
							(return 1)
						)
						((checkCode doit: 4)
							(= global454 [local12 4])
							(= global455 [local23 4])
							(= local34 4)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
			(7
				(if
					(or
						(== local34 2)
						(== local34 5)
						(== local34 6)
						(== local34 7)
						(== local34 8)
						(== local34 9)
					)
					(cond
						((checkCode doit: 3)
							(= global454 [local12 3])
							(= global455 [local23 3])
							(= local34 3)
							(return 1)
						)
						((checkCode doit: 4)
							(= global454 [local12 4])
							(= global455 [local23 4])
							(= local34 4)
							(return 1)
						)
						((checkCode doit: 1)
							(= global454 [local12 1])
							(= global455 [local23 1])
							(= local34 1)
							(return 1)
						)
						((checkCode doit: 10)
							(= global454 [local12 10])
							(= global455 [local23 10])
							(= local34 10)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
			(8
				(if
					(or
						(== local34 6)
						(== local34 7)
						(== local34 8)
						(== local34 9)
						(== local34 10)
					)
					(cond
						((checkCode doit: 2)
							(= global454 [local12 2])
							(= global455 [local23 2])
							(= local34 2)
							(return 1)
						)
						((checkCode doit: 3)
							(= global454 [local12 3])
							(= global455 [local23 3])
							(= local34 3)
							(return 1)
						)
						((checkCode doit: 4)
							(= global454 [local12 4])
							(= global455 [local23 4])
							(= local34 4)
							(return 1)
						)
						((checkCode doit: 5)
							(= global454 [local12 5])
							(= global455 [local23 5])
							(= local34 5)
							(return 1)
						)
						((checkCode doit: 1)
							(= global454 [local12 1])
							(= global455 [local23 1])
							(= local34 1)
							(return 1)
						)
					)
				else
					(return 0)
				)
			)
		)
	)
)

(instance checkCode of Code
	(properties)

	(method (doit param1)
		(switch param1
			(1
				(if
					(or
						((ScriptID 601 1) populatn:) ; slSqr1
						((ScriptID 601 2) populatn:) ; slSqr2
						((ScriptID 601 3) populatn:) ; slSqr3
						((ScriptID 601 20) populatn:) ; slSqr20
						((ScriptID 601 21) populatn:) ; slSqr21
						((ScriptID 601 22) populatn:) ; slSqr22
						((ScriptID 601 23) populatn:) ; slSqr23
						((ScriptID 601 24) populatn:) ; slSqr24
						((ScriptID 601 25) populatn:) ; slSqr25
					)
					(return 0)
				else
					(return 1)
				)
			)
			(2
				(if
					(or
						((ScriptID 601 4) populatn:) ; slSqr4
						((ScriptID 601 5) populatn:) ; slSqr5
						((ScriptID 601 6) populatn:) ; slSqr6
						((ScriptID 601 17) populatn:) ; slSqr17
						((ScriptID 601 18) populatn:) ; slSqr18
						((ScriptID 601 19) populatn:) ; slSqr19
						((ScriptID 601 26) populatn:) ; slSqr26
						((ScriptID 601 27) populatn:) ; slSqr27
						((ScriptID 601 28) populatn:) ; slSqr28
					)
					(return 0)
				else
					(return 1)
				)
			)
			(3
				(if
					(or
						((ScriptID 601 7) populatn:) ; slSqr7
						((ScriptID 601 8) populatn:) ; slSqr8
						((ScriptID 601 9) populatn:) ; slSqr9
						((ScriptID 601 14) populatn:) ; slSqr14
						((ScriptID 601 15) populatn:) ; slSqr15
						((ScriptID 601 16) populatn:) ; slSqr16
						((ScriptID 601 29) populatn:) ; slSqr29
						((ScriptID 601 30) populatn:) ; slSqr30
						((ScriptID 601 31) populatn:) ; slSqr31
					)
					(return 0)
				else
					(return 1)
				)
			)
			(4
				(if
					(or
						((ScriptID 601 10) populatn:) ; slSqr10
						((ScriptID 601 11) populatn:) ; slSqr11
						((ScriptID 601 12) populatn:) ; slSqr12
						((ScriptID 601 13) populatn:) ; slSqr13
						((ScriptID 601 32) populatn:) ; slSqr32
						((ScriptID 601 33) populatn:) ; slSqr33
					)
					(return 0)
				else
					(return 1)
				)
			)
			(5
				(if
					(or
						((ScriptID 601 34) populatn:) ; slSqr34
						((ScriptID 601 35) populatn:) ; slSqr35
						((ScriptID 601 54) populatn:) ; slSqr54
						((ScriptID 601 55) populatn:) ; slSqr55
						((ScriptID 601 56) populatn:) ; slSqr56
						((ScriptID 601 57) populatn:) ; slSqr57
					)
					(return 0)
				else
					(return 1)
				)
			)
			(6
				(if
					(or
						((ScriptID 601 76) populatn:) ; slSqr76
						((ScriptID 601 77) populatn:) ; slSqr77
						((ScriptID 601 78) populatn:) ; slSqr78
						((ScriptID 601 79) populatn:) ; slSqr79
						((ScriptID 601 56) populatn:) ; slSqr56
						((ScriptID 601 57) populatn:) ; slSqr57
					)
					(return 0)
				else
					(return 1)
				)
			)
			(7
				(if
					(or
						((ScriptID 601 73) populatn:) ; slSqr73
						((ScriptID 601 74) populatn:) ; slSqr74
						((ScriptID 601 75) populatn:) ; slSqr75
						((ScriptID 601 80) populatn:) ; slSqr80
						((ScriptID 601 81) populatn:) ; slSqr81
						((ScriptID 601 82) populatn:) ; slSqr82
						((ScriptID 601 58) populatn:) ; slSqr58
						((ScriptID 601 59) populatn:) ; slSqr59
						((ScriptID 601 60) populatn:) ; slSqr60
					)
					(return 0)
				else
					(return 1)
				)
			)
			(8
				(if
					(or
						((ScriptID 601 70) populatn:) ; slSqr70
						((ScriptID 601 71) populatn:) ; slSqr71
						((ScriptID 601 72) populatn:) ; slSqr72
						((ScriptID 601 83) populatn:) ; slSqr83
						((ScriptID 601 84) populatn:) ; slSqr84
						((ScriptID 601 85) populatn:) ; slSqr85
						((ScriptID 601 61) populatn:) ; slSqr61
						((ScriptID 601 62) populatn:) ; slSqr62
						((ScriptID 601 63) populatn:) ; slSqr63
					)
					(return 0)
				else
					(return 1)
				)
			)
			(9
				(if
					(or
						((ScriptID 601 67) populatn:) ; slSqr67
						((ScriptID 601 68) populatn:) ; slSqr68
						((ScriptID 601 69) populatn:) ; slSqr69
						((ScriptID 601 86) populatn:) ; slSqr86
						((ScriptID 601 87) populatn:) ; slSqr87
						((ScriptID 601 88) populatn:) ; slSqr88
						((ScriptID 601 64) populatn:) ; slSqr64
						((ScriptID 601 65) populatn:) ; slSqr65
						((ScriptID 601 66) populatn:) ; slSqr66
					)
					(return 0)
				else
					(return 1)
				)
			)
			(10
				(if
					(or
						((ScriptID 601 42) populatn:) ; slSqr42
						((ScriptID 601 43) populatn:) ; slSqr43
						((ScriptID 601 44) populatn:) ; slSqr44
						((ScriptID 601 45) populatn:) ; slSqr45
						((ScriptID 601 46) populatn:) ; slSqr46
						((ScriptID 601 47) populatn:) ; slSqr47
						((ScriptID 601 64) populatn:) ; slSqr64
						((ScriptID 601 65) populatn:) ; slSqr65
						((ScriptID 601 66) populatn:) ; slSqr66
					)
					(return 0)
				else
					(return 1)
				)
			)
		)
	)
)

(instance sound3 of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
	)
)

(instance sound4 of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
	)
)

(instance sound5 of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
	)
)

(instance theTitle of View
	(properties
		x 64
		y 38
		view 650
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority ignoreActors:)
		(super init:)
	)
)

(instance upLeftFront of View
	(properties
		view 650
		loop 3
		priority 2
	)

	(method (init)
		(self
			setLoop: loop
			posn: (theTitle x:) (+ (theTitle y:) 16)
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)
)

(instance upRightFront of View
	(properties
		view 650
		loop 3
		priority 2
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (theTitle x:) 98) (+ (theTitle y:) 16)
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)
)

(instance lowLeftFront of View
	(properties
		view 650
		loop 3
		priority 2
	)

	(method (init)
		(self
			setLoop: loop
			posn: (theTitle x:) (+ (theTitle y:) 74)
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)
)

(instance lowRightFront of View
	(properties
		view 650
		loop 3
		priority 2
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (theTitle x:) 98) (+ (theTitle y:) 74)
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)
)

