;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22020)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm22v020 0
)

(local
	local0
)

(instance rm22v020 of ShiversRoom
	(properties
		picture 22020
	)

	(method (init)
		(if (== gPrevRoomNum 21440) ; rm21v440
			(proc951_9 22201)
			(gSounds play: 22201 -1 0 0)
			(gSounds fade: 22201 74 5 16 0 0)
			(gSounds play: 12207 0 82 0)
		)
		(if (IsFlag 22)
			(self picture: 22021)
		)
		(spNarrative init:)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 2)
		(proc951_1 5)
		(gSounds fade: 32250 0 8 15 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22050
	)

	(method (init)
		(self
			createPoly: 82 142 83 71 91 36 97 24 109 7 115 3 128 0 144 0 149 2 153 4 159 12 164 25 167 37 169 46 172 74 177 113 177 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22030
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22030
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 22020
	)

	(method (init)
		(self createPoly: 233 72 233 79 226 79 226 72 233 72)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 72)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 32250)
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
								{ You are now in the world of the shaman or witch doctor, whose purpose is to           act as intermediary for gods and men. The shaman acts as doctor, frightening evil spirits away from the sick or officiating in the practice of human sacrifice to pacify angry gods. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 32250 0 98 self)
				else
					(gSounds play: 32250 0 98 self)
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

