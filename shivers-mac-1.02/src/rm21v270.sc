;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21270)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm21v270 0
)

(local
	local0
)

(instance rm21v270 of ShiversRoom
	(properties
		picture 21270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(spNarrative init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 32150 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21330
	)

	(method (init)
		(self
			createPoly: 78 141 77 130 60 130 60 117 44 116 44 102 26 102 26 1 0 1 0 142 78 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21260
	)

	(method (init)
		(self createPoly: 75 0 78 85 93 132 155 132 169 89 171 0 76 0)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 21270
	)

	(method (init)
		(self
			createPoly: 224 81 217 81 216 85 216 89 217 90 226 90 227 86 227 84 225 81
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 71)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 32150)
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
								{ Death comes uneasily to the mind of man. Burial customs throughout the world arise from the belief that the survivors can secure secure life after death for the deceased. You will find here, that man has conceived of many ways to honor the dead. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 32150 0 82 self)
				else
					(gSounds play: 32150 0 82 self)
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

