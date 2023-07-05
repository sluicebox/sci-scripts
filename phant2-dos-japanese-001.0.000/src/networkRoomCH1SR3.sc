;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3131)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)
(use System)

(public
	networkRoomCH1SR3 0
)

(local
	[local0 4] = [490 0 550 300]
	local4 = 5
)

(instance networkRoomCH1SR3 of P2Room
	(properties
		picture 150
		south 3111
		east 3111
		west 3111
	)

	(method (init &tmp temp0)
		(Load 140 313) ; WAVE
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(= temp0 0)
		(if
			(and
				(OneOf gPrevRoomNum 3011 3061) ; mainHallRoomCH1SR1, mainHallRoomCH1SR6
				(SetFlag 27)
				(IsFlag 34)
				(IsFlag 36)
			)
			(or
				(SetFlag 28)
				(SetFlag 24)
				(and
					(= global211 1)
					(= global212 1)
					(= temp0 6220)
					(or (= global209 0) 1)
				)
			)
		)
		(curtis init:)
		(super init: &rest)
		(if temp0
			(proc63002_7 3321 temp0)
		)
		(boxesFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(deskFeature init:)
		(gGame handsOn: 1)
	)
)

(instance boxesFeature of P2Feature
	(properties
		nextRoom 3141
		exitDir 1
	)
)

(instance deskFeature of P2Feature
	(properties
		nextRoom 3121
	)

	(method (init)
		(super init: (proc63002_10 0 190 100 200 108 306 0 306))
	)
)

(instance curtis of P2Fidget
	(properties
		x 205
		y 325
		view 11500
		initStart 0
		initFinish 1
		cycleStart 8
		cycleFinish 12
	)

	(method (init)
		(cFeat init: self)
		(super init: &rest)
	)
)

(instance cFeat of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self delVerb: 4 addVerb: 15)
		(= whoDoit cCount)
	)

	(method (dispose)
		(= target 0)
		(super dispose: &rest)
	)
)

(instance cCount of Code
	(properties)

	(method (doit)
		(if (and (== gVerb 15) (not (-- local4))) ; screwdriverI
			(cFeat isHot: 1 whoDoit: cGo delVerb: 15 addVerb: 5)
		)
	)
)

(instance cGo of Code
	(properties)

	(method (doit)
		(if (== gVerb 5) ; walletI
			(= local4 5)
			(cFeat delVerb: 5 whoDoit: 0)
			(boing state: -1 cue:)
			(eggAMatic add: gCurRoomNum 1 5)
		)
	)
)

(instance boing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(curtis setScript: (sCurtFall new:) self)
			)
			(1
				(curtis setScript: (sCurtBoingLeft new:) self)
			)
			(2
				(curtis setScript: (sCurtBoingRight new:) self)
			)
			(3
				(curtis setScript: (sCurtBackToCtr new:) self)
			)
			(4
				(curtis setScript: (sCurtRise new:) self)
			)
			(5
				(cFeat addVerb: 15 whoDoit: cCount)
				(self dispose:)
			)
		)
	)
)

(instance sCurtFall of Script
	(properties)

	(method (cue)
		(if (>= (curtis y:) 635)
			(self dispose:)
		else
			(curtis posn: 205 (+ (curtis y:) 5))
			(= cycles 1)
		)
	)
)

(instance sCurtBoingLeft of Script
	(properties)

	(method (cue &tmp temp0 temp1)
		(if (!= state -1)
			(= temp0 (curtis y:))
			(= temp1 (curtis x:))
			(if (<= (curtis x:) 15)
				(self dispose:)
			else
				(-= temp1 5)
				(switch state
					(1
						(if (<= (-= temp0 25) 450)
							(++ state)
						)
					)
					(2
						(if (>= (+= temp0 25) 635)
							(-- state)
							(gP2SoundFX play: 313)
						)
					)
				)
				(= cycles 1)
				(curtis posn: temp1 temp0)
			)
		else
			(= seconds 2)
			(= state 1)
		)
	)
)

(instance sCurtBoingRight of Script
	(properties)

	(method (cue &tmp temp0 temp1)
		(= state (Abs state))
		(= temp0 (curtis y:))
		(= temp1 (curtis x:))
		(if (>= (curtis x:) 630)
			(self dispose:)
		else
			(+= temp1 5)
			(switch state
				(0
					(if (<= (-= temp0 25) 450)
						(++ state)
					)
				)
				(1
					(if (>= (+= temp0 25) 635)
						(-- state)
						(gP2SoundFX play: 313)
					)
				)
			)
			(= cycles 1)
			(curtis posn: temp1 temp0)
		)
	)
)

(instance sCurtBackToCtr of Script
	(properties)

	(method (cue &tmp temp0 temp1)
		(= state (Abs state))
		(if (< state 2)
			(= temp0 (curtis y:))
			(= temp1 (curtis x:))
			(if (<= (curtis x:) 205)
				(= seconds (= state 2))
			else
				(-= temp1 5)
				(switch state
					(0
						(if (<= (-= temp0 25) 450)
							(++ state)
						)
					)
					(1
						(if (>= (+= temp0 25) 635)
							(-- state)
							(gP2SoundFX play: 313)
						)
					)
				)
				(= cycles 1)
				(curtis posn: temp1 temp0)
			)
		else
			(self dispose:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(cycles
				(if (not (-- cycles))
					(self cue:)
				)
			)
			(seconds
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= lastSeconds temp0)
					(if (<= (-= seconds (- temp0 lastSeconds)) 0)
						(= seconds 0)
						(= lastSeconds temp0)
						(self cue:)
					else
						(= lastSeconds temp0)
					)
				)
			)
			(ticks
				(if (<= (-= ticks (- gGameTime lastTicks)) 0)
					(= ticks 0)
					(= lastTicks gGameTime)
					(self cue:)
				else
					(= lastTicks gGameTime)
				)
			)
		)
	)
)

(instance sCurtRise of Script
	(properties)

	(method (cue)
		(if (<= (curtis y:) 325)
			(curtis posn: 205 325)
			(self dispose:)
		else
			(curtis posn: 205 (- (curtis y:) (Random 5 15)))
			(= cycles 1)
		)
	)
)

