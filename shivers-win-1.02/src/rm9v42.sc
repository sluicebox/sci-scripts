;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9420)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm9v42 0
)

(instance rm9v42 of ShiversRoom
	(properties
		picture 9420
		invView 2
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== global186 1)
			(efExitForward init:)
		)
		(if (IsFlag 79)
			(spDoor init:)
			(vDoorBack init:)
		)
		(if (and (IsFlag 42) (or (== gPrevRoomNum 9850) (< 9000 gPrevRoomNum 9440))) ; rm9v850, rm9v44
			(PrintDebug {fade to 26})
			(gSounds fade: 10908 26 15 8 0 0)
		)
		(super init: &rest)
	)
)

(instance psInSlide of PotSpot
	(properties
		nsLeft 151
		nsTop 90
		nsRight 197
		nsBottom 132
	)
)

(instance vDoorBack of View
	(properties
		priority 20
		fixPriority 1
		view 9420
		loop 1
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 30
		fixPriority 1
		view 9420
	)

	(method (init)
		(if (== gPrevRoomNum 936) ; slideRm
			(= cel (self lastCel:))
			(gCurRoom initRoom: 151 196 90 132)
			(psInSlide init:)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== cel (self lastCel:))
			(self setScript: sDoorClose)
		else
			(self setScript: sDoorOpen)
		)
	)
)

(instance sDoorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom initRoom: 151 196 90 132)
				(psInSlide init:)
				(gSounds stop: 10930)
				(gSounds play: 10929 0 82 0)
				(spDoor setCycle: End self)
			)
			(1
				(SetFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 10929)
				(gSounds play: 10930 0 82 0)
				(spDoor setCycle: Beg self)
			)
			(1
				(psInSlide dispose:)
				(if (!= global106 0)
					(gShiversRoomItem dispose:)
				)
				(= cycles 1)
			)
			(2
				(ClearFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9410
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9410
	)

	(method (init)
		(self createPoly: 71 60 185 55 178 132 82 145 71 60)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
			)
			(event claimed: 1)
			(hsDialogArea init:)
			(vDialog init:)
		)
	)
)

(instance hsDialogArea of HotSpot
	(properties
		nsRight 266
		nsBottom 143
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(vDialog dispose:)
		(self dispose:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance vDialog of View
	(properties
		x 60
		y 110
		priority 250
		fixPriority 1
		view 921
		cel 6
	)
)

