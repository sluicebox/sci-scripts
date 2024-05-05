;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19020)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Motion)
(use Actor)
(use System)

(public
	rm19v020 0
)

(local
	local0
	local1
)

(instance rm19v020 of ShiversRoom
	(properties
		picture 19020
	)

	(method (init)
		(= local1 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(if (and (proc951_11 8 19000) (== gPrevRoomNum 19010)) ; rm19v010
			(gSounds adjChainVol: 16)
			(gSounds fade: 21909 0 5 16 1 0)
			(gSounds playChain: -1 -5 21901 -1 -1 -5 21901 -1 -1 -5 21904 -1)
			(gSounds play: 21903 -1 48 0)
		)
		(spNarrative init: setPri: 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 3)
		(cond
			((== newRoomNumber 11240) ; rm11v240
				(gSounds fadeChain:)
			)
			(local1
				(SetFlag 43)
			)
		)
		(gSounds fade: 31950 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 68 143 72 133 69 39 77 26 89 14 107 7 134 2 160 7 180 15 191 28 199 40 197 135 208 143
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gSounds stop: 11901)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance pDoor of Prop
	(properties
		view 19020
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsDoor dispose:)
				(pDoor init: setPri: 25 1 cycleSpeed: 15 setCycle: End)
				(gSounds play: 11901 0 82 self)
			)
			(1
				(efExitForward init: 3)
				(gGame handsOn:)
				(= local1 1)
				(self dispose:)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11240
	)

	(method (init)
		(self
			createPoly: 68 143 72 133 69 39 77 26 89 14 107 7 134 2 160 7 180 15 191 28 199 40 197 135 208 143
		)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 19021
	)

	(method (init)
		(self createPoly: 58 60 64 60 64 65 57 65 57 60)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== local1 0)
			(self setScript: sNarrative)
		)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_9 31950)
				(gSounds stop: 31950)
				(spNarrative setPri: 10)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ You have stepped into the world of amazing plants. For centuries, plants have_________been used to beautify man's surroundings, for food, shelter, and to heal the sick. And like Socrates, who was executed by drinking poison hemlock, man has discovered, plants have a lethal side too. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 31950 0 98 self)
				else
					(gSounds play: 31950 0 98 self)
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

