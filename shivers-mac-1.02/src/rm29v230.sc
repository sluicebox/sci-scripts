;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29230)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm29v230 0
)

(local
	local0
)

(instance rm29v230 of ShiversRoom
	(properties
		picture 29230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(spNarrative init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 32950 0 15 8 1 0)
		(gSounds fade: 32951 0 15 8 1 0)
		(gSounds fade: 32952 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29450
	)

	(method (init)
		(self
			createPoly: 107 143 111 70 116 57 130 45 147 45 155 48 163 55 166 62 169 75 172 143 107 143
		)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 29230
	)

	(method (init)
		(self createPoly: 86 95 89 94 91 94 93 96 91 99 88 99 86 96)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 75)
		(self setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 32950)
				(gSounds stop: 32951)
				(gSounds stop: 32952)
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
								{ Since 1947, when American pilot Kenneth Arnold described what he saw as______"they flew like a saucer would if you skipped it across the water," man has reported thousands of UFOs. Hysteria? }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 32951 0 127 self)
				else
					(gSounds play: 32950 0 127 self)
					(+= state 2)
				)
			)
			(2
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ Then why do we find flying saucers creeping into prehistoric cave paintings 7,000 years old, and giant Nazca markings in the deserts of Peru that can only be seen from thousands of feet in the air? As you investigate further, you'll discover--we are not alone. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 32952 0 127 self)
				)
			)
			(3
				(if (IsFlag 39)
					(gCurRoom eraseText:)
				)
				(spNarrative cel: 0)
				(self dispose:)
			)
		)
	)
)

