;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12600)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm12v600 0
)

(instance rm12v600 of ShiversRoom
	(properties
		picture 12600
	)

	(method (init)
		(super init: &rest)
		(efBack init: 8)
		(efExitRight init: 1)
		(spLatitude init:)
		(spLongitude init:)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 12150
	)

	(method (init)
		(if (> 1000 gPrevRoomNum) ; rm1v00
			(= nextRoom gPrevRoomNum)
		)
		(self
			createPoly:
				0
				1
				0
				142
				237
				142
				237
				0
				0
				0
				65
				38
				51
				68
				53
				90
				78
				116
				99
				125
				112
				128
				154
				128
				196
				93
				196
				39
				158
				11
				95
				9
				65
				38
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12130
	)
)

(instance spBimini of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 12130
		loop 1
		cycleSpeed 30
	)
)

(instance spLatitude of ShiversProp
	(properties
		view 12600
	)

	(method (init)
		(self setPri: 10 1 cel: 19)
		(if (IsFlag 10)
			(= cel 0)
		)
		(super init:)
	)

	(method (doVerb &tmp temp0)
		(cond
			((< (= temp0 (- gMouseX 27)) 110)
				(gSounds stop: 11202)
				(= cel (mod (+ cel 23) 24))
				(gSounds play: 11202 0 75 0)
			)
			((> temp0 138)
				(gSounds stop: 11202)
				(= cel (mod (+ cel 1) 24))
				(gSounds play: 11202 0 75 0)
			)
		)
		(UpdateScreenItem self)
		(if (and (== (spLatitude cel:) 0) (== (spLongitude cel:) 11))
			(gGame handsOff:)
			(gCurRoom setScript: sPuzzleDone)
		)
	)
)

(instance spLongitude of ShiversProp
	(properties
		view 12600
		loop 1
	)

	(method (init)
		(self setPri: 10 1 cel: 9)
		(if (IsFlag 10)
			(= cel 11)
		)
		(super init:)
	)

	(method (doVerb &tmp temp0)
		(cond
			((and (< (= temp0 (- gMouseY 7)) 60) (< cel 18))
				(gSounds stop: 11202)
				(++ cel)
				(gSounds play: 11202 0 75 0)
			)
			((and (> temp0 80) (> cel 0))
				(gSounds stop: 11202)
				(-- cel)
				(gSounds play: 11202 0 75 0)
			)
		)
		(UpdateScreenItem self)
		(if
			(and
				(== (spLatitude cel:) 0)
				(== (spLongitude cel:) 11)
				(not (IsFlag 10))
			)
			(gGame handsOff:)
			(gCurRoom setScript: sPuzzleDone)
		)
	)
)

(instance glowGlobe of Prop
	(properties
		view 12601
	)
)

(instance glowBeam of Prop
	(properties
		view 12601
		loop 1
	)
)

(instance sPuzzleDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(glowGlobe init: setPri: 5 1 setCycle: Fwd cycleSpeed: 15)
				(gSounds stop: 11211)
				(gSounds play: 11211 0 75 self)
			)
			(1
				(glowGlobe setCycle: End)
				(gSounds stop: 11203)
				(gSounds play: 11203 0 75 self)
				(glowBeam init: setPri: 8 1 setCycle: Fwd cycleSpeed: 5)
			)
			(2
				(glowGlobe setCycle: Beg self)
				(glowBeam dispose:)
			)
			(3
				(glowGlobe dispose:)
				(if (not (IsFlag 10))
					(spLongitude dispose:)
					(spLatitude dispose:)
				)
				(= seconds 1)
			)
			(4
				(if (not (IsFlag 10))
					(gCurRoom drawPic: 12130)
					(if (IsFlag 9)
						((View new:) view: 12130 cel: 1 setPri: 25 1 init:)
					)
				)
				(= cycles 1)
			)
			(5
				(if (not (IsFlag 10))
					(spBimini init:)
					(gSounds play: 11204 0 75 0)
					(spBimini setCycle: End)
				)
				(= seconds 4)
			)
			(6
				(if (not (IsFlag 10))
					(proc951_15 6750)
					(gGame handsOn:)
					(SetFlag 10)
					(gCurRoom newRoom: 12130) ; rm12v13
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

