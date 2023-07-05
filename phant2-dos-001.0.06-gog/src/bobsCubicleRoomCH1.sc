;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4301)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	bobsCubicleRoomCH1 0
)

(instance bobsCubicleRoomCH1 of P2Room
	(properties
		picture 260
		south 3341
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(= global241 60)
		(if (not (IsFlag 70))
			(bobProp init: setPri: 1)
			(bobFeature init: whoDoit: bobCode)
		else
			(= picture 261)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance bobProp of P2Fidget
	(properties
		x 186
		y 338
		view 12600
		initStart 0
		initFinish 0
		cycleStart 7
	)

	(method (handleEvent)
		(bobFeature handleEvent: &rest)
	)
)

(instance bobFeature of P2Feature
	(properties
		priority 2
	)

	(method (onMe)
		(return (bobProp onMe: &rest))
	)

	(method (init)
		(if (super init: &rest)
			(if (not (IsFlag 53))
				(self addVerb: 10)
			)
			(if (not (bobUsesDo doit:))
				(self delVerb: 4)
			)
		)
	)
)

(instance bobCode of Code
	(properties)

	(method (doit)
		(cond
			((== gVerb 10) ; xmasPhotoI
				(if (not (SetFlag 53))
					(proc63002_7 3810)
				)
				(bobFeature delVerb: 10)
			)
			((IsFlag 54)
				(cond
					((IsFlag 55)
						(if (not (SetFlag 56))
							(proc63002_7 3800)
							(setTalkBob doit:)
						)
					)
					((not (SetFlag 57))
						(proc63002_7 3790)
						(setTalkBob doit:)
					)
				)
			)
			((not (SetFlag 58))
				(proc63002_7 3760)
				(setTalkBob doit:)
			)
			((not (SetFlag 59))
				(proc63002_7 3780)
			)
		)
		(if (not (bobUsesDo doit:))
			(bobFeature delVerb: 4)
		)
	)
)

(instance bobUsesDo of Code
	(properties)

	(method (doit)
		(if
			(or
				(and
					(IsFlag 54)
					(or
						(proc63002_4 55 56)
						(and (not (IsFlag 55)) (IsFlag 57))
					)
				)
				(and (not (IsFlag 54)) (proc63002_4 58 59))
			)
			(return 0)
		else
			(return 1)
		)
	)
)

(instance setTalkBob of Code
	(properties)

	(method (doit)
		(Load rsSCRIPT 4391)
		(Lock rsSCRIPT 4391 1)
		((ScriptID 4391) init:) ; justTalkedToBob
	)
)

