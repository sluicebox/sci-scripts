;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32070)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm32v070 0
)

(local
	local0
)

(instance rm32v070 of ShiversRoom
	(properties
		picture 32070
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(spNarrative init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 33250 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32076
	)

	(method (init)
		(self createPoly: 158 141 158 43 83 43 83 142 158 142)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 32071
	)

	(method (init)
		(self createPoly: 38 89 45 89 45 99 36 99 36 89 38 89)
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
				(gSounds stop: 33250)
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
								{ Man has taken it upon himself to penalize his fellow man for every conceivable offense, many trivial. Historically, singing insulting songs in Rome, injuring a cat in Egypt, and even selling bad beer in Babylon could_____________bring the death penalty. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 33250 0 98 self)
				else
					(gSounds play: 33250 0 98 self)
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

