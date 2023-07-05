;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32010)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm32v010 0
)

(local
	local0
)

(instance rm32v010 of ShiversRoom
	(properties
		picture 32010
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(spNarrative init:)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 30430) ; rm30v430
				(gCurRoom setScript: sEnter)
			)
			((IsFlag 43)
				(gSounds play: 13014 0 82 0)
				(ClearFlag 43)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(gSounds fade: 33250 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32076
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32076
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32030
	)

	(method (init)
		(self
			createPoly:
				86
				110
				104
				88
				104
				66
				76
				41
				55
				41
				35
				47
				20
				65
				18
				76
				23
				91
				32
				105
				34
				110
				86
				110
		)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 32010
	)

	(method (init)
		(self createPoly: 226 90 219 90 219 97 225 97 227 94 226 91)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 78)
		(self setScript: sNarrative)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 23001 0 15 8 1 self)
				(gSounds play: 13014 0 82 0)
				(ClearFlag 43)
			)
			(1
				(gGame handsOn:)
				(proc951_9 23201)
				(gSounds play: 23201 -1 82 0)
				(self dispose:)
			)
		)
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
								{ Man has taken it upon himself to penalize his fellow man for every conceivable offense, many trivial. Historically, singing insulting songs in Rome, injuring a cat in Egypt, and even selling bad beer in Babylon could        bring the death penalty. }
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

