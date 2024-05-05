;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13522)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm13v522 0
)

(local
	local0
)

(instance rm13v522 of ShiversRoom
	(properties
		picture 13910
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitPlaque init: 3)
		(spNarrative init:)
		(super init: &rest)
		(if (< 1000 gPrevRoomNum 13000) ; rm1v00, rm13v000
			(proc951_9 21303)
			(gSounds play: 21303 -1 0 0)
			(gSounds fade: 21303 18 10 8 0 0)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(proc951_1 9)
		(gSounds fade: 31350 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13523
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13523
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13520
	)

	(method (init)
		(self createPoly: 173 90 173 110 85 110 82 9 176 9 172 75 160 83 168 91)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 13524
	)

	(method (init)
		(self createPoly: 174 90 169 91 160 83 181 70 197 77)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 13522
	)

	(method (init)
		(self createPoly: 41 54 38 54 36 57 38 61 42 61 43 57 42 55)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 69)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 31350)
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
								{ You are about to enter the bowels of Mother Earth. Are there great civilizations that exist here, or just molten lava and rivers of fire? Are you__________adventurous enough to solve the mystery of the maze and venture into the subterranean world? }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 31350 0 82 self)
				else
					(gSounds play: 31350 0 82 self)
				)
			)
			(2
				(if (IsFlag 39)
					(gCurRoom eraseText:)
				)
				(spNarrative cel: 0)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

