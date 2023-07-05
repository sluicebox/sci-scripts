;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20040)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Motion)
(use System)

(public
	rm20v040 0
)

(local
	local0
	local1
)

(instance rm20v040 of ShiversRoom
	(properties
		picture 20040
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(spNarrative init:)
		(spDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 9560) ; rm9v56
				(gSounds fade: 22001 0 4 10 1 0)
				(gSounds stop: 32050)
			)
			(local0
				(gSounds play: 12020 0 82 0)
			)
		)
		(if (!= newRoomNumber 9560) ; rm9v56
			(gSounds fade: 32050 0 15 8 1 0)
		)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9560
	)

	(method (init)
		(self createPoly: 79 18 183 18 182 134 81 134 79 19)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20010
	)

	(method (init)
		(self createPoly: 264 0 209 0 209 142 260 142 263 142 263 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20020
	)

	(method (init)
		(self createPoly: 0 0 47 0 47 142 0 142 0 1)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 30
		fixPriority 1
		view 20041
	)

	(method (init)
		(self createPoly: 73 66 79 66 79 71 73 71 73 67)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 70)
		(self setScript: sNarrative)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 20040
		cycleSpeed 27
	)

	(method (init)
		(self createPoly: 79 18 183 18 182 134 81 134 79 19)
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		(self setScript: sOpenDoor)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12019 0 82 0)
				(spDoor setCycle: End)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(efExitForward init: 3)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
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
				(gSounds stop: 32050)
				(spNarrative cel: 0)
				(UpdateScreenItem spNarrative)
				(spNarrative cel: 1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local1
						(Str
							format:
								{ Much of what we know about early man comes from burial sites--but not         without a price. Eternal life was the sustaining ideology for many ancient cultures and they went to great lengths to prevent their dead from being violated. Venture on if you will, but beware the curse of the tomb. }
						)
					)
					(gCurRoom drawText: local1 0 0)
					(local1 data: 0 dispose:)
					(gSounds play: 32050 0 98 self)
				else
					(gSounds play: 32050 0 98 self)
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

