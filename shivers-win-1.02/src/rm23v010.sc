;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23010)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm23v010 0
)

(local
	local0
)

(instance rm23v010 of ShiversRoom
	(properties
		picture 23010
	)

	(method (init)
		(spNarrative init:)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (< 1000 newRoomNumber 23000) ; rm1v00
			(gSounds fade: 22301 0 15 8 1 0)
			(gSounds fade: 22313 0 5 16 1 0)
		)
		(gSounds fade: 32350 0 2 40 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23760
	)

	(method (init)
		(self createPoly: 91 37 171 37 171 127 91 127 91 38)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 23010
	)

	(method (doVerb)
		(proc951_16 73)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 32350)
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
								{ No tribute pleases an angry god better than the blood sacrifice. Fortunately________for man, there are benevolent as well as vengeful gods. }
						)
					)
					(gCurRoom drawText: local0 0 9)
					(local0 data: 0 dispose:)
					(gSounds play: 32350 0 127 self)
				else
					(gSounds play: 32350 0 127 self)
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

