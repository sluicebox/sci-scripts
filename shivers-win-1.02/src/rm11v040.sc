;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11040)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Motion)
(use Actor)
(use System)

(public
	rm11v040 0
)

(local
	local0
	local1
)

(instance rm11v040 of ShiversRoom
	(properties
		picture 11040
	)

	(method (init)
		(= local0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spNarrative init:)
		(hsDoor init:)
		(pDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 31150 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(cond
			((< 1000 newRoomNumber 11000) ; rm1v00
				(gSounds stop: 21101)
				(gSounds stop: 21103)
				(gSounds stop: 21902)
				(gSounds stopChain:)
			)
			(local0
				(SetFlag 43)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9600
	)

	(method (init)
		(self createPoly: 89 140 89 24 202 24 202 139)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 11040
		loop 1
	)

	(method (init)
		(self createPoly: 223 73 233 73 233 84 222 84)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 67)
		(self setScript: sNarrative)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 89 140 89 24 202 24 202 139)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance pDoor of Prop
	(properties
		x 2
		y -8
		priority 10
		fixPriority 1
		view 11040
		cycleSpeed 15
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 11105)
				(proc951_7 11104)
				(= cycles 1)
			)
			(1
				(gSounds play: 11104 0 32 self)
				(pDoor init: setPri: 25 1 setCycle: End)
				(hsDoor dispose:)
			)
			(2
				(efExitForward init: 3)
				(= local0 1)
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
				(gSounds stop: 31150)
				(spNarrative cel: 0)
				(UpdateScreenItem spNarrative)
				(spNarrative cel: 1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(proc951_9 31150)
				(if (IsFlag 39)
					(= local1
						(Str
							format:
								{ From a 60 ft. giant squid that can pull a small fishing boat into the depths of the sea, to the two inch poison-dart frog that carries enough poison to kill 1,500 people, nothing is stranger than the animal kingdom. Is it any wonder that the ancients worshipped and feared these strange beasts? }
						)
					)
					(gCurRoom drawText: local1 0 0)
					(local1 data: 0 dispose:)
					(gSounds play: 31150 0 122 0)
				else
					(gSounds play: 31150 0 122 0)
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

