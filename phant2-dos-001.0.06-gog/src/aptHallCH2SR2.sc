;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2222)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use Styler)
(use Feature)
(use System)

(public
	aptHallCH2SR2 0
)

(local
	[local0 4] = [222 56 334 298]
	[local4 4] = [399 39 507 327]
	[local8 4] = [98 117 114 112]
	local12
)

(instance aptHallCH2SR2 of P2Room
	(properties
		picture 80
		style 0
		south 2212
	)

	(method (init)
		(bedRoomFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
		(livingRoomFeat init: [local4 0] [local4 1] [local4 2] [local4 3])
		(head init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance bedRoomFeat of ExitFeature
	(properties
		nextRoom 2012
		exitDir 0
		exitScene 1503
	)
)

(instance livingRoomFeat of ExitFeature
	(properties
		nextRoom 2122
		exitDir 1
		exitScene 1502
	)

	(method (init)
		(if (not (Random 0 60))
			(= exitScene 1505)
		else
			(= exitScene 1502)
		)
		(super init: &rest)
	)
)

(instance head of Feature
	(properties)

	(method (init)
		(super init: gThePlane 600 361 101 393 134)
		(= local12 0)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(== gVerb 4) ; Do
					(& (event type:) evKEYBOARD)
					(or
						(== (event message:) [local8 local12])
						(== (+ (event message:) KEY_SPACE) [local8 local12])
					)
				)
				(if (== local12 3)
					(= local12 0)
					(if (& (event modifiers:) emSHIFT)
						(gTheCursor hide:)
						(eggAMatic add: 2221 2 3)
						(gP2SoundFX play: 2801)
						(while (!= (DoAudio audPOSITION 2801) -1)
							(ShakePlane gThePlane (Random 1 3) 1 (Random 5 15))
						)
						(gTheCursor show:)
					else
						(gTheCursor hide:)
						(eggAMatic add: 2221 1 2)
						(gP2SoundFX play: 2802)
						(while (!= (DoAudio audPOSITION 2802) -1)
							(ShakePlane gThePlane (Random 1 3) 1 (Random 1 4))
						)
						(gTheCursor show:)
					)
				else
					(++ local12)
				)
				(event claimed: 1)
			)
			((& (event type:) evKEYBOARD)
				(= local12 0)
			)
		)
		(event claimed:)
	)
)

(instance fidget of P2Fidget ; UNUSED
	(properties
		x 136
		y 339
		view 10800
		cycleSpeed 7
	)

	(method (init)
		(super init:)
		(curtisFeat init:)
		(self setPri: 10)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 145 18 288 303)
		(self delVerb: 4)
		(self addVerb: 30)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(curtisFeat delVerb: 30)
		(= global209 1930)
		(SetFlag 1001)
		(gEgo put: 20 get: 7) ; mailBundleI, bondageCardI
		(gCurRoom newRoom: 2122) ; livingRoomCH2SR2
	)
)

