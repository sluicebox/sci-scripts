;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24380)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm24v380 0
)

(instance rm24v380 of ShiversRoom
	(properties
		picture 24380
		invView 1
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitPlaque init: 3)
		(hsStage init:)
		(if (IsFlag 88)
			(= picture 24385)
			(spCurtain view: 24386 cel: 0 init:)
			(self initRoom: 124 141 59 78)
			(psOnStage init:)
		else
			(vFront init:)
		)
		(super init: &rest)
		(if (and (IsFlag 66) (IsFlag 84) (== gPrevRoomNum 24440)) ; rm24v440
			(spSpider init:)
			(spCrank init:)
			(gCurRoom setScript: sDoSpider)
		)
	)
)

(instance psOnStage of PotSpot
	(properties
		nsLeft 124
		nsTop 59
		nsRight 141
		nsBottom 78
	)
)

(instance spSpider of ShiversProp
	(properties
		priority 40
		fixPriority 1
		view 24380
	)
)

(instance spCurtain of ShiversProp
	(properties
		priority 30
		fixPriority 1
		view 24386
	)
)

(instance vFront of View
	(properties
		priority 38
		fixPriority 1
		view 24387
	)
)

(instance vBack of View
	(properties
		priority 10
		fixPriority 1
		view 24387
		loop 1
	)
)

(instance spCrank of ShiversProp
	(properties
		priority 39
		fixPriority 1
		view 24383
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24400
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24410
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 24840
	)

	(method (init)
		(self createPoly: 45 103 36 86 64 83 71 99)
		(super init: &rest)
	)
)

(instance hsStage of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				82
				117
				82
				88
				88
				82
				88
				32
				82
				28
				82
				12
				182
				12
				182
				28
				177
				33
				177
				83
				183
				88
				183
				117
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 88)
			(gCurRoom setScript: sCloseCurtain)
		else
			(gCurRoom newRoom: 24440) ; rm24v440
		)
	)
)

(instance efExitCloseUp of ExitFeature ; UNUSED
	(properties
		nextRoom 24440
	)

	(method (init)
		(self
			createPoly:
				74
				21
				74
				35
				86
				42
				87
				92
				76
				101
				76
				128
				184
				128
				184
				102
				173
				92
				174
				42
				186
				37
				186
				22
				75
				22
		)
		(super init: &rest)
	)
)

(instance sCloseCurtain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12423 0 82 0)
				(ClearFlag 88)
				(spSpider hide: dispose:)
				(gCurRoom drawPic: 24385)
				(spCurtain view: 24386 cel: 0 init:)
				(spCurtain setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 24440) ; rm24v440
				(self dispose:)
			)
		)
	)
)

(instance sDoSpider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 84)
				(if (not (IsFlag 91))
					(SetFlag 91)
					(proc951_15 6750)
				)
				(gSounds fade: 22401 0 1 30 1 self)
			)
			(1
				(proc951_9 22405)
				(gSounds play: 22405 0 82 0)
				(spCrank setCycle: Fwd)
				(spSpider view: 24380 cel: 0 setCycle: End self)
			)
			(2
				(spSpider view: 24381 cel: 0 setCycle: End self)
			)
			(3
				(spSpider view: 24382 cel: 0 setCycle: End self)
			)
			(4
				(SetFlag 88)
				(gCurRoom initRoom: 124 141 59 80)
				(psOnStage init:)
				(spSpider view: 24384 cel: 0 setCycle: End self)
			)
			(5
				(spCrank setCycle: 0)
				(gSounds fade: 22405 0 1 30 1 self)
			)
			(6
				(vFront hide: dispose:)
				(vBack init:)
				(gSounds play: 12415 0 82 0)
				(spSpider view: 24384 cel: 0 loop: 1 setCycle: End self)
			)
			(7
				(proc951_9 22401)
				(gSounds play: 22401 -1 0 0)
				(gSounds fade: 22401 98 1 30 0 0)
				(= cycles 1)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

