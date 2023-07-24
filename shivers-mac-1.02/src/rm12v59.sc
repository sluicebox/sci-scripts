;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12590)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm12v59 0
)

(instance rm12v59 of ShiversRoom
	(properties
		picture 12590
	)

	(method (init)
		(proc951_16 31)
		(efBack init: 8)
		(spButton init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 21211 0 5 16 1 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 12330
	)

	(method (init)
		(if (== gPrevRoomNum 12400) ; rm12v40
			(self nextRoom: 12400)
		)
		(self
			createPoly: 0 0 0 143 220 143 220 112 249 112 249 142 263 142 263 0 0 0
		)
		(super init: &rest)
	)
)

(instance hsSirensNotes of HotSpot
	(properties
		nsRight 320
		nsBottom 200
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(vSirenNotes dispose:)
		(efBack init: 8)
		(self dispose:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance vSirenNotes of View
	(properties
		x 32
		y 25
		priority 25
		fixPriority 1
		view 12591
	)
)

(instance spButton of ShiversProp
	(properties
		view 12590
	)

	(method (init)
		(self
			createPoly: 230 120 237 119 241 120 245 122 246 125 247 129 247 132 245 136 240 138 233 138 227 136 224 131 224 126 226 123 230 120
			setPri: 127 1
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sButtonPressed)
	)
)

(instance sButtonPressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 39)
					(hsSirensNotes init:)
					(efBack dispose:)
					(vSirenNotes init:)
				)
				(spButton setCycle: End self)
				(gSounds play: 11208 0 75 0)
				(gGame handsOff:)
			)
			(1
				(gSounds play: 21211 0 50 0)
				(spButton setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

