;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30010)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Motion)
(use System)

(public
	rm30v010 0
)

(local
	local0
)

(instance rm30v010 of ShiversRoom
	(properties
		picture 30010
	)

	(method (init)
		(spNarrative init:)
		(pDoor init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 33050 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29460
	)

	(method (init)
		(self createPoly: 107 34 155 34 155 142 107 142 107 34)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 30011
	)

	(method (init)
		(self
			createPoly:
				173
				62
				170
				62
				169
				65
				171
				67
				173
				67
				175
				66
				176
				65
				176
				63
				174
				62
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 76)
		(self setScript: sNarrative)
	)
)

(instance pDoor of ShiversProp
	(properties
		priority 120
		fixPriority 1
		view 30010
		loop 1
		cycleSpeed 18
	)

	(method (doVerb)
		(if (not (IsFlag 43))
			(self cel: 0)
			(gSounds play: 13013 0 82 0)
			(self setCycle: End)
			(self createPoly: 1 1 1 1 1 1 1 1)
			(efExitForward init: 3)
			(SetFlag 43)
		)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 33050)
				(spNarrative cel: 0)
				(UpdateScreenItem spNarrative)
				(spNarrative cel: 1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ Man creates in order to improve his existence. However, many of man's early    inventions became lost. During the dark ages, an inventor whose creation seemed a little too ingenious, could be accused of collaborating with Satan and consequently burned at the stake--or worse. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 33050 0 90 0)
				else
					(gSounds play: 33050 0 90 0)
				)
			)
			(2
				(if (IsFlag 39)
					(gCurRoom eraseText:)
				)
				(spNarrative cel: 0)
				(self dispose:)
			)
		)
	)
)

