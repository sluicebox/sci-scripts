;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2124)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Timer)
(use ExitFeature)
(use P2Fidget)
(use Rectangle)
(use PolyEdit)
(use Feature)
(use System)

(public
	livingRoomCH4SR2 0
)

(local
	[local0 4] = [363 204 389 222]
	[local4 4] = [231 8 311 186]
	[local8 4] = [312 8 389 186]
	local12
)

(instance livingRoomCH4SR2 of P2Room
	(properties
		picture 50
		style 0
		east 2134
	)

	(method (init)
		(if (not (IsFlag 518))
			(ClearFlag 1001)
			(allie init:)
			(allieFeat init:)
			(nakedCurtis init:)
			(AllieTimerCh4 whoDoit: allieCode)
			(= west 0)
			(= local12 (GetTime))
			(ass init:)
		else
			(if (IsFlag 505)
				(ClearFlag 1001)
				(jocNCurtis init:)
				(filler init:)
				(jocilynFeat init:)
			else
				(phoneFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
				(hallFeat init: [local4 0] [local4 1] [local4 2] [local4 3])
				(bedRoomFeat init: [local8 0] [local8 1] [local8 2] [local8 3])
				(hairPin init:)
				(wesBook init:)
				(fidget init:)
			)
			(= west 2114)
		)
		(super init: &rest)
		(if (and (not (IsFlag 518)) (not (gP2SongPlyr isPlaying:)))
			(gP2SongPlyr start: 2941)
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance phoneFeat of P2Feature
	(properties
		scene 2170
		doneFlag 556
	)

	(method (init)
		(super init: &rest)
		(self delVerb: 4)
		(self addVerb: 13)
	)
)

(instance hairPin of P2View
	(properties
		priority 500
		x 308
		y 320
		view 50
		loop 1
		nextRoom 2144
	)

	(method (init)
		(if (and (IsFlag 512) (not (IsFlag 514)))
			(super init: &rest)
			(self addTarget: (Rectangle new: 336 297 353 307))
		else
			(return 0)
		)
	)
)

(instance hallFeat of ExitFeature
	(properties
		nextRoom 2214
		exitDir 7
		exitScene 1501
	)
)

(instance bedRoomFeat of ExitFeature
	(properties
		nextRoom 2014
		exitDir 2
		exitScene 1580
	)
)

(instance fidget of P2Fidget
	(properties
		x 132
		y 281
		view 10500
		cycleSpeed 10
		wiggler 1
		delay 1
		zone1aLeft 12
		zone1aRight 17
		zone1bLeft 18
		zone1bRight 22
		zone2aLeft 0
		zone2aRight 4
		zone2bLeft 5
		zone2bRight 10
	)

	(method (init)
		(super init:)
		(curtisFeat init: left top right bottom)
		(self setPri: 1)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
		(self delVerb: 4)
		(self addVerb: 30 21 28)
		(= whoDoit itemsOnCurtisCode)
	)
)

(instance itemsOnCurtisCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(= global211 1)
				(proc63002_7 2420)
				(SetFlag 1001)
				(gEgo put: 20 get: 24) ; mailBundleI, thereseNoteI
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global211 1)
				(SetFlag 315)
				(proc63002_7 2145)
			)
		)
	)
)

(instance allie of P2Fidget
	(properties
		x 87
		y 315
		view 10506
		initStart 2
		initFinish 5
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance nakedCurtis of P2Fidget
	(properties
		x 187
		y 61
		view 10502
		initStart 2
		initFinish 5
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance allieFeat of P2Feature
	(properties)

	(method (init)
		(= whoDoit allieCode)
		(super init: 92 71 149 307)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (IsFlag 518)
			(self dispose:)
		)
	)
)

(instance allieCode of Code
	(properties)

	(method (doit)
		(switch (++ global231)
			(1
				(gP2SongPlyr fadeTo: 70)
				(proc63002_7 2200)
				(SetFlag 558)
				(gP2SongPlyr fadeTo: 100)
			)
			(2
				(proc63002_7 2210)
				(SetFlag 559)
			)
			(3
				(proc63002_7 2220)
				(SetFlag 560)
				(AllieTimerCh4 start: 3 10)
			)
			(4
				(AllieTimerCh4 dispose:)
				(gP2SongPlyr fadeOut: 0)
				(= global209 2240)
				(SetFlag 518)
				(ClearFlag 562)
				(gCurRoom newRoom: 2014) ; bedRoomCH4SR1
			)
		)
	)
)

(instance ass of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(if (IsFlag 404)
			(return 0)
		else
			(= whoDoit allieCode)
			(super init: 99 180 128 205)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (IsFlag 518)
			(self dispose:)
		)
	)

	(method (onMe)
		(if (super onMe: &rest)
			(if
				(and
					(>= (Abs (- (GetTime) local12)) 1200)
					(not (IsFlag 404))
				)
				(eggAMatic add: 2124 1 5)
				(gP2SoundFX play: 2814)
				(SetFlag 404)
				(= local12 (GetTime))
			)
		else
			(= local12 (GetTime))
		)
		(return (super onMe: &rest))
	)
)

(instance jocNCurtis of P2Fidget
	(properties
		x 469
		y 159
		view 10504
		initStart 2
		initFinish 5
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance filler of View
	(properties
		x 484
		y 306
		view 10504
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance jocilynFeat of P2Feature
	(properties)

	(method (init)
		(= whoDoit jocilynPresentCode)
		(super init: 470 151 579 302)
	)
)

(instance jocilynPresentCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 511))
			(proc63002_7 2260)
			(SetFlag 511)
		else
			(ClearFlag 505)
			(= global209 2280)
			(SetFlag 512)
			(ClearFlag 562)
			(gCurRoom newRoom: 2014) ; bedRoomCH4SR1
		)
	)
)

(instance wesBook of Feature
	(properties)

	(method (init)
		(super init: gThePlane 1 (proc63002_10 354 335 382 315 418 325 401 335))
	)

	(method (handleEvent event)
		(if
			(and
				(& (event modifiers:) emALT)
				(& (event modifiers:) emCTRL)
				(& (event type:) evMOUSEBUTTON)
			)
			(gCurRoom newRoom: 2171) ; bookRoom
			(event claimed: 1)
		)
		(event claimed:)
	)
)

