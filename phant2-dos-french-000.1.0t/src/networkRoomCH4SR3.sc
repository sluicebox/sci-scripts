;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3134)
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
	networkRoomCH4SR3 0
)

(local
	[local0 4] = [490 0 550 300]
	local4 = 5
)

(instance networkRoomCH4SR3 of P2Room
	(properties
		picture 150
		south 3114
		east 3114
		west 3114
	)

	(method (init)
		(Load 140 313) ; WAVE
		(curtis init:)
		(super init: &rest)
		(boxesFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(deskFeature init:)
		(gGame handsOn: 1)
	)
)

(instance boxesFeature of P2Feature
	(properties
		nextRoom 3144
	)
)

(instance deskFeature of P2Feature
	(properties
		nextRoom 3124
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
			(cFeat isHot: 1 whoDoit: cGo delVerb: 15 addVerb: 25)
		)
	)
)

(instance cGo of Code
	(properties)

	(method (doit)
		(if (== gVerb 25) ; hairpinI
			(= local4 5)
			(cFeat delVerb: 25 whoDoit: 0)
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

