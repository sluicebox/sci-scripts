;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6434)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use BorderWindow)
(use Jump)
(use System)

(public
	blBackCH4SR3 0
)

(local
	local0 = 1
	local1
	[local2 4] = [1 2 4 3]
	local6
	local7
	local8
	local9 = 1
)

(procedure (localproc_0)
	(piece1 setCel: (localproc_3 (piece1 cel:)))
	(piece2 setCel: (localproc_3 (piece2 cel:)))
	(piece3 setCel: (localproc_3 (piece3 cel:)))
	(piece4 setCel: (localproc_3 (piece4 cel:)))
	(switch local0
		(1
			(piece1 setCel: (localproc_3 0))
			(= local6 (piece1 cel:))
		)
		(2
			(piece2 setCel: (localproc_3 0))
			(= local6 (piece2 cel:))
		)
		(3
			(piece3 setCel: (localproc_3 0))
			(= local6 (piece3 cel:))
		)
		(4
			(piece4 setCel: (localproc_3 0))
			(= local6 (piece4 cel:))
		)
	)
	(UpdateScreenItem piece1)
	(UpdateScreenItem piece2)
	(UpdateScreenItem piece3)
	(UpdateScreenItem piece4)
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 1)
	(if (< (piece1 x:) 209)
		(if (> (+ (piece1 x:) param1) 209)
			(piece1 x: 209)
		else
			(piece1 x: (+ (piece1 x:) param1))
		)
		(= temp0 0)
	)
	(if (< (piece1 y:) 166)
		(if (> (+ (piece1 y:) param1) 166)
			(piece1 y: 166)
		else
			(piece1 y: (+ (piece1 y:) param1))
		)
		(= temp0 0)
	)
	(if (> (piece2 x:) 314)
		(if (< (- (piece2 x:) param1) 314)
			(piece2 x: 314)
		else
			(piece2 x: (- (piece2 x:) param1))
		)
		(= temp0 0)
	)
	(if (< (piece2 y:) 166)
		(if (> (+ (piece1 y:) param1) 166)
			(piece2 y: 166)
		else
			(piece2 y: (+ (piece2 y:) param1))
		)
		(= temp0 0)
	)
	(if (> (piece3 x:) 314)
		(if (< (- (piece3 x:) param1) 314)
			(piece3 x: 314)
		else
			(piece3 x: (- (piece3 x:) param1))
		)
		(= temp0 0)
	)
	(if (> (piece3 y:) 271)
		(if (< (- (piece3 y:) param1) 271)
			(piece3 y: 271)
		else
			(piece3 y: (- (piece3 y:) param1))
		)
		(= temp0 0)
	)
	(if (< (piece4 x:) 209)
		(if (> (+ (piece4 x:) param1) 209)
			(piece4 x: 209)
		else
			(piece4 x: (+ (piece4 x:) param1))
		)
		(= temp0 0)
	)
	(if (> (piece4 y:) 271)
		(if (< (- (piece4 y:) param1) 271)
			(piece4 y: 271)
		else
			(piece4 y: (- (piece4 y:) param1))
		)
		(= temp0 0)
	)
	(UpdateScreenItem piece1)
	(UpdateScreenItem piece2)
	(UpdateScreenItem piece3)
	(UpdateScreenItem piece4)
	(return temp0)
)

(procedure (localproc_2 param1 &tmp temp0)
	(= temp0 1)
	(if (> (piece1 x:) 187)
		(if (< (- (piece1 x:) param1) 187)
			(piece1 x: 187)
		else
			(piece1 x: (- (piece1 x:) param1))
		)
		(= temp0 0)
	)
	(if (> (piece1 y:) 146)
		(if (< (- (piece1 y:) param1) 146)
			(piece1 y: 146)
		else
			(piece1 y: (- (piece1 y:) param1))
		)
		(= temp0 0)
	)
	(if (< (piece2 x:) 339)
		(if (> (+ (piece2 x:) param1) 339)
			(piece2 x: 339)
		else
			(piece2 x: (+ (piece2 x:) param1))
		)
		(= temp0 0)
	)
	(if (> (piece2 y:) 146)
		(if (< (- (piece2 y:) param1) 146)
			(piece2 y: 146)
		else
			(piece2 y: (- (piece2 y:) param1))
		)
		(= temp0 0)
	)
	(if (< (piece3 x:) 339)
		(if (> (+ (piece3 x:) param1) 339)
			(piece3 x: 339)
		else
			(piece3 x: (+ (piece3 x:) param1))
		)
		(= temp0 0)
	)
	(if (< (piece3 y:) 296)
		(if (> (+ (piece3 y:) param1) 296)
			(piece3 y: 296)
		else
			(piece3 y: (+ (piece3 y:) param1))
		)
		(= temp0 0)
	)
	(if (> (piece4 x:) 187)
		(if (< (- (piece4 x:) param1) 187)
			(piece4 x: 187)
		else
			(piece4 x: (- (piece4 x:) param1))
		)
		(= temp0 0)
	)
	(if (< (piece4 y:) 296)
		(if (> (+ (piece1 y:) param1) 296)
			(piece4 y: 296)
		else
			(piece4 y: (+ (piece4 y:) param1))
		)
		(= temp0 0)
	)
	(UpdateScreenItem piece1)
	(UpdateScreenItem piece2)
	(UpdateScreenItem piece3)
	(UpdateScreenItem piece4)
	(return temp0)
)

(procedure (localproc_3 param1 &tmp temp0)
	(switch param1
		(0
			(return (Random 1 3))
		)
		(1
			(if (== (= temp0 (Random 1 3)) 1)
				(return 0)
			else
				(return temp0)
			)
		)
		(2
			(if (== (= temp0 (Random 0 2)) 2)
				(return 3)
			else
				(return temp0)
			)
		)
		(3
			(return (Random 0 2))
		)
		(else
			(return (Random 0 3))
		)
	)
)

(procedure (localproc_4 param1) ; UNUSED
	(switch param1
		(1
			(return piece1)
		)
		(2
			(return piece2)
		)
		(3
			(return piece3)
		)
		(4
			(return piece4)
		)
	)
)

(instance blBackCH4SR3 of CloseupRoom
	(properties
		picture 831
	)

	(method (init &tmp temp0)
		(Load 140 6801) ; WAVE
		(Load 140 6802) ; WAVE
		(Load 140 6803) ; WAVE
		(ClearFlag 1001)
		(= local7 0)
		(= local8 0)
		(= local9 1)
		(= exitRoom 6424)
		(super init: &rest)
		(= local0 (Random 1 4))
		(= local1 1)
		(piece1 init:)
		(piece2 init:)
		(piece4 init:)
		(piece3 init:)
		(mergeFeat init:)
		(gGame handsOn: 1)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if (== newRoomNumber 6424) ; blBackCH4SR2
			(SetFlag 1001)
		)
	)

	(method (dispose)
		(= global246 (piece1 cel:))
		(= global247 (piece2 cel:))
		(= global248 (piece3 cel:))
		(= global249 (piece4 cel:))
		(UnLoad 140 6801)
		(UnLoad 140 6802)
		(UnLoad 140 6803)
		(moveScript dispose:)
		(super dispose: &rest)
	)
)

(instance solvedCode of Code
	(properties)

	(method (doit)
		(= global209 8196)
		(SetFlag 555)
		(gCurRoom newRoom: 6454) ; blBackCH4SR5
	)
)

(instance mergeFeat of P2Feature
	(properties)

	(method (init)
		(super init: (proc63002_10 275 168 313 131 351 168 313 208))
		(= whoDoit mergeCode)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gGame handsOff:)
			(event claimed:)
			(return)
		)
	)
)

(instance mergeCode of Code
	(properties)

	(method (doit)
		(moveScript init:)
	)
)

(instance piece1 of Prop
	(properties
		x 187
		y 146
		view 831
	)

	(method (init)
		(= cel global246)
		(= scratch 1)
		(super init: &rest)
		(self setPri: 10)
		(if (== local0 1)
			(= local6 (self cel:))
		)
		(piece1Feat init: left top right bottom)
	)
)

(instance piece2 of Prop
	(properties
		x 339
		y 146
		view 831
		loop 1
	)

	(method (init)
		(= cel global247)
		(= scratch 2)
		(super init: &rest)
		(self setPri: 10)
		(if (== local0 2)
			(= local6 (self cel:))
		)
		(piece2Feat init: left top right bottom)
	)
)

(instance piece3 of Prop
	(properties
		x 339
		y 296
		view 831
		loop 2
	)

	(method (init)
		(= cel global248)
		(= scratch 3)
		(super init: &rest)
		(self setPri: 10)
		(if (== local0 3)
			(= local6 (self cel:))
		)
		(piece3Feat init: left top right bottom)
	)
)

(instance piece4 of Prop
	(properties
		x 187
		y 296
		view 831
		loop 3
	)

	(method (init)
		(= cel global249)
		(= scratch 4)
		(super init: &rest)
		(self setPri: 10)
		(if (== local0 4)
			(= local6 (self cel:))
		)
		(piece4Feat init: left top right bottom)
	)
)

(instance piece1Feat of P2Feature
	(properties)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(advanceCel doit: piece1)
			(event claimed:)
			(return)
		)
	)
)

(instance piece2Feat of P2Feature
	(properties)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(advanceCel doit: piece2)
			(event claimed:)
			(return)
		)
	)
)

(instance piece3Feat of P2Feature
	(properties)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(advanceCel doit: piece3)
			(event claimed:)
			(return)
		)
	)
)

(instance piece4Feat of P2Feature
	(properties)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(advanceCel doit: piece4)
			(event claimed:)
			(return)
		)
	)
)

(instance advanceCel of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(gP2SoundFX play: 6801)
		(if (not local7)
			(= local7 1)
			(if (== (param1 scratch:) local0)
				(= local8 1)
			else
				(= local8 0)
			)
		)
		(if (not (checkTable doit: param1))
			(localproc_0)
			(= local8 0)
			(= local7 0)
			(= local9 1)
			(return 0)
		)
		(if (== (= temp0 (param1 cel:)) 3)
			(param1 setCel: 0)
		else
			(param1 setCel: (++ temp0))
		)
		(return
			(switch param1
				(piece1
					(= temp1 1)
					(if (== local0 1)
						(= local6 (piece1 cel:))
					)
				)
				(piece2
					(= temp1 2)
					(if (== local0 2)
						(= local6 (piece2 cel:))
					)
				)
				(piece3
					(= temp1 3)
					(if (== local0 3)
						(= local6 (piece3 cel:))
					)
				)
				(piece4
					(= temp1 4)
					(if (== local0 4)
						(= local6 (piece4 cel:))
					)
				)
			)
		)
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gP2SoundFX play: 6802)
				(= ticks 1)
			)
			(1
				(if (not (localproc_1 3))
					(= ticks 2)
					(-= state 1)
				else
					(if
						(and
							(== (piece1 cel:) 0)
							(== (piece2 cel:) 0)
							(== (piece3 cel:) 0)
							(== (piece4 cel:) 0)
						)
						(gP2SoundFX play: 6803)
					)
					(= seconds 2)
				)
			)
			(2
				(if
					(and
						(== (piece1 cel:) 0)
						(== (piece2 cel:) 0)
						(== (piece3 cel:) 0)
						(== (piece4 cel:) 0)
					)
					(self dispose:)
					(solvedCode doit:)
				else
					(= ticks 1)
				)
			)
			(3
				(gP2SoundFX play: 6802)
				(= ticks 1)
			)
			(4
				(if (not (localproc_2 3))
					(-= state 1)
				)
				(= ticks 1)
			)
			(5
				(gGame handsOn:)
				(= ticks 1)
			)
		)
	)
)

(instance checkTable of Code
	(properties)

	(method (doit param1 &tmp [temp0 3] temp3)
		(if (== local0 (param1 scratch:))
			(if local8
				(= temp3 (param1 cel:))
				(switch local9
					(2
						(+= temp3 1)
					)
					(3
						(+= temp3 2)
					)
				)
				(if (> (++ local9) 3)
					(= local9 1)
				)
				(if (> temp3 3)
					(-= temp3 4)
				)
				(param1 cel: temp3)
				(return 1)
			else
				(return 0)
			)
		else
			(return 1)
		)
	)
)

