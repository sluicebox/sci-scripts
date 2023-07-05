;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20050)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm20v050 0
)

(local
	local0
)

(instance rm20v050 of ShiversRoom
	(properties
		picture 20050
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20040
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20060
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 20000
	)

	(method (init)
		(self
			createPoly: 149 83 143 82 141 85 141 92 148 92 151 88 151 83 150 83
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 32050)
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
								{ Much of what we know about early man comes from burial sites--but not without a price. Eternal life was the sustaining ideology for many ancient cultures and they went to great lengths to prevent their dead from being violated. Venture on if you will, but beware the curse of the tomb. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 32050 0 122 self)
				else
					(gSounds play: 32050 0 122 self)
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

