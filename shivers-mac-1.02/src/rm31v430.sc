;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31430)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Motion)
(use System)

(public
	rm31v430 0
)

(local
	local0
)

(instance rm31v430 of ShiversRoom
	(properties
		picture 31430
	)

	(method (init)
		(ClearFlag 43)
		(if (IsFlag 65)
			(spDoor init:)
		)
		(efExitPuzzle init: 3)
		(efExitRightHigh init: 6)
		(efExitRightLow init: 6)
		(efExitLeft init: 7)
		(efExitPlaque init: 3)
		(spNarrative init:)
		(super init: &rest)
		(if (== gPrevRoomNum 31090) ; rm31v090
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom)
		(gSounds fade: 33150 0 15 8 1 0)
		(if (IsFlag 43)
			(gSounds play: 13119 0 82 0)
			(ClearFlag 43)
		)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31410
	)

	(method (init)
		(self createPoly: 83 86 178 86 178 142 82 142 82 86)
		(super init: &rest)
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 31090
	)

	(method (init)
		(self createPoly: 165 84 91 84 91 47 173 47 173 83)
		(super init: &rest)
	)
)

(instance efExitRightHigh of ExitFeature
	(properties
		nextRoom 31070
	)

	(method (init)
		(self createPoly: 240 0 240 80 262 80 262 0 240 0)
		(super init: &rest)
	)
)

(instance efExitRightLow of ExitFeature
	(properties
		nextRoom 31070
	)

	(method (init)
		(self createPoly: 240 96 240 144 262 144 262 96 240 96)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31070
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 31080
	)

	(method (init)
		(self
			createPoly: 17 83 17 122 21 124 18 143 52 143 47 124 59 119 57 82 39 80 17 82
		)
		(super init: &rest)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 1
		fixPriority 1
		view 31430
	)

	(method (doVerb)
		(gSounds play: 13115 0 82 0)
		(SetFlag 43)
		(self setCycle: End createPoly: -1 -1 -1 -1 -1 -1)
		(efExitForward init: 3)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 31431
	)

	(method (init)
		(self createPoly: 255 82 262 88 257 95 249 89 255 82)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 77)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 33150)
				(spNarrative setCel: 1 setPri: 10)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ The world's greatest mysteries are merely puzzles waiting to be solved. The puzzle room is Professor Windlenot's favorite exhibit. If you can solve the last_______puzzle here, you will have discovered the museum's most precious secrets. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 33150 0 127 self)
				else
					(gSounds play: 33150 0 127 self)
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

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 23108 0 1 30 1 self)
			)
			(1
				(proc951_10 23108)
				(= cycles 1)
			)
			(2
				(proc951_9 23101)
				(gSounds play: 23101 -1 8 0)
				(gSounds fade: 23101 90 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

