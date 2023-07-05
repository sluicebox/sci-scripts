;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use SoundSyncWave)
(use n954)
(use LoadMany)
(use RFeature)
(use Game)
(use Actor)

(public
	eastBeachRm 0
)

(instance eastBeachRm of Rm
	(properties
		picture 24
		east 16
		south 16
		west 13
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 24 703)
		(gEgo init:)
		(self setFeatures: rocks building setRegions: 301 300) ; Water, tahiti
		(wave init: gIceGlobalSound setPri: 3)
		((ScriptID 301) notify: 0 wave 189 139 4 45 145 4) ; Water
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(Print 24 0) ; "You see the end of a bungalow, the Tahitian beach, and rocks to the east."
			)
		)
	)
)

(instance rocks of Feature
	(properties
		y 70
		x 240
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/rock]>')
				(cond
					((Said 'look[<at]')
						(Print 24 1) ; "Rocks jutting into the ocean."
					)
					((Said 'climb')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance wave of SoundSyncWave
	(properties
		y 149
		x 117
		view 703
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/wave]>')
				(cond
					((Said 'look[<at]')
						(Print 24 2) ; "Gently lapping waves."
					)
					((Said 'swim')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance wave2 of SoundSyncWave ; UNUSED
	(properties
		y 120
		x 275
		view 24
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/wave]>')
				(cond
					((Said 'look[<at]')
						(Print 24 2) ; "Gently lapping waves."
					)
					((Said 'swim')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance building of RFeature
	(properties
		y 20
		x 28
		nsBottom 41
		nsRight 57
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building,room]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 24 3) ; "You see a bungalow."
					)
					((Said 'enter')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
			((Said 'look<in/shutter')
				(Print 24 4) ; "The reflection on the window prevents you from looking in."
			)
		)
	)
)

