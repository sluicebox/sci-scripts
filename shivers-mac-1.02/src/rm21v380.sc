;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21380)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm21v380 0
)

(local
	local0
)

(instance rm21v380 of ShiversRoom
	(properties
		picture 21380
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spNarrative init: setPri: 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(gSounds fade: 32150 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21270
	)

	(method (init)
		(self createPoly: 64 140 64 0 0 0 0 140 64 140)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21300
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 21380
	)

	(method (init)
		(self createPoly: 146 36 148 33 152 32 155 36 153 40 147 40 146 37)
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
				(spNarrative setPri: 1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ Death comes uneasily to the mind of man. Burial customs throughout the world arise from the belief that the survivors can secure life after death for______the deceased. You will find here, that man has conceived of many ways to honor the dead. }
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
				(spNarrative setPri: 0)
				(self dispose:)
			)
		)
	)
)

