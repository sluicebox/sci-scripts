;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23800)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm23v800 0
)

(local
	local0
)

(instance rm23v800 of ShiversRoom
	(properties
		picture 23800
	)

	(method (init)
		(spNarrative init:)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(if (< 1000 gPrevRoomNum 23000) ; rm1v00
			(proc951_7 22301)
			(proc951_9 22301)
			(gSounds play: 22301 -1 0 0)
			(gSounds fade: 22301 82 5 8 0 0)
		)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 32350 0 2 40 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23760
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23760
	)

	(method (init)
		(self
			createPoly: 263 0 238 0 238 79 250 79 250 101 238 101 238 143 263 143 263 0
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23030
	)

	(method (init)
		(self createPoly: 43 2 222 2 222 143 43 143 43 2)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 23690
		cel 1
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
				(spNarrative cel: 1)
				(UpdateScreenItem spNarrative)
				(spNarrative cel: 0)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ No tribute pleases an angry god better than the blood sacrifice. Fortunately        for man, there are benevolent as well as vengeful gods. }
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
				(spNarrative cel: 1)
				(self dispose:)
			)
		)
	)
)

