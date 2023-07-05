;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24400)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm24v400 0
)

(local
	local0
)

(instance rm24v400 of ShiversRoom
	(properties
		picture 24400
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(spNarrative init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 32450 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24760
	)

	(method (init)
		(self createPoly: 112 132 111 58 159 58 159 134 112 134 112 132)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24390
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24380
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 24400
	)

	(method (init)
		(self
			createPoly:
				167
				93
				169
				91
				171
				91
				174
				94
				174
				95
				172
				97
				170
				97
				168
				97
				167
				95
				167
				94
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 74)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc951_9 32450)
				(gGame handsOff:)
				(gSounds stop: 32450)
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
								{ Plato first coined the word 'Mythologia' or the telling of stories. Fictional or     historical, myths are a universal creation. They attempt to explain the unexplainable --the world, god, monsters, man's very existence itself, and death. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 32450 0 98 self)
				else
					(gSounds play: 32450 0 98 self)
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

