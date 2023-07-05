;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use EcoFeature)
(use Talker)
(use PolyPath)
(use Motion)
(use System)

(public
	lookAtCabinet 0
)

(local
	local0
)

(instance lookAtCabinet of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 67)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 7)
				(Load rsVIEW 389)
				(gEgo setMotion: PolyPath 135 74 self)
			)
			(1
				((ScriptID gCurRoomNum 3) stopUpd:)
				(cabinetDoor init:)
				(emptyCabinet init:)
				(if (not (gEgo has: 17)) ; scubaGear
					(smallGear init:)
				)
				(gSoundEffects number: 387 loop: 1 play:)
				(cabinetDoor cel: 1 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(cabinetView init: stopUpd:)
				(if (not (gEgo has: 17)) ; scubaGear
					(swimGloves init: stopUpd:)
					(lungs init: stopUpd:)
					(swimMask init: stopUpd:)
					(fins init: stopUpd:)
					(redThing init: stopUpd:)
				)
				(= cycles 6)
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 0)
				(gEgo stopUpd:)
				(cabinetDoor stopUpd:)
				(cabinetView stopUpd:)
				(smallGear stopUpd:)
				(emptyCabinet stopUpd:)
			)
			(5
				(HandsOff)
				(if (not (gEgo has: 17)) ; scubaGear
					(swimGloves startUpd: hide:)
					(lungs startUpd: hide:)
					(swimMask startUpd: hide:)
					(fins startUpd: hide:)
					(redThing startUpd: hide:)
				)
				(cabinetView startUpd: hide:)
				(= cycles 1)
			)
			(6
				(cabinetView dispose: delete:)
				(if (not (gEgo has: 17)) ; scubaGear
					(swimGloves dispose: delete:)
					(lungs dispose: delete:)
					(swimMask dispose: delete:)
					(fins dispose: delete:)
					(redThing dispose: delete:)
				)
				(= cycles 1)
			)
			(7
				(cabinetDoor startUpd: setCycle: Beg self)
			)
			(8
				(gSoundEffects number: 387 loop: 1 play:)
				(cabinetDoor startUpd: hide:)
				(emptyCabinet startUpd: hide:)
				(if (not (gEgo has: 17)) ; scubaGear
					(smallGear hide:)
				)
				(= cycles 2)
			)
			(9
				(cabinetDoor dispose: delete:)
				(emptyCabinet dispose: delete:)
				(if (not (gEgo has: 17)) ; scubaGear
					(smallGear dispose: delete:)
				)
				(= cycles 2)
			)
			(10
				(if (and (gEgo has: 17) (== gCurRoomNum 381)) ; scubaGear
					((ScriptID 2 1) init: 2 0 0 22 1 self 380) ; Adam, "Okay, now I'm ready! I've got everything!"
				else
					(= ticks 3)
				)
			)
			(11
				(if (and (gEgo has: 17) (== gCurRoomNum 381)) ; scubaGear
					((ScriptID 2 0) init: 1 0 0 23 1 self 380) ; Delphineus, "Hurry up, then! I have the worst feeling we don't have much time."
				else
					(= ticks 3)
				)
			)
			(12
				(= seconds 1)
			)
			(13
				((ScriptID gCurRoomNum 3) startUpd:)
				(UnLoad 128 389)
				(= cycles 1)
			)
			(14
				(HandsOn)
				(gTheIconBar enable: 7)
				(gEgo startUpd:)
				(self dispose:)
			)
		)
	)
)

(instance cabinetDoor of EcoProp
	(properties
		x 147
		y 56
		view 380
		loop 1
		priority 3
		signal 16400
	)
)

(instance getItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 10 223)
				(gEgo get: 29 get: 19 get: 17) ; transmitter, airTanks, scubaGear
				(redThing startUpd: hide:)
				(= seconds 1)
			)
			(1
				(swimMask startUpd: hide:)
				(= seconds 1)
			)
			(2
				(lungs startUpd: hide:)
				(= seconds 1)
			)
			(3
				(fins startUpd: hide:)
				(= seconds 1)
			)
			(4
				(swimGloves startUpd: hide:)
				(= seconds 1)
			)
			(5
				(smallGear startUpd: hide:)
				(= seconds 1)
			)
			(6
				(EcoNarrator init: 5 0 0 89 self 380)
			)
			(7
				(redThing startUpd: dispose: delete:)
				(swimMask startUpd: dispose: delete:)
				(lungs startUpd: dispose: delete:)
				(fins startUpd: dispose: delete:)
				(swimGloves startUpd: dispose: delete:)
				(smallGear startUpd: dispose: delete:)
				((gCurRoom script:) cue:)
				(self dispose:)
			)
		)
	)
)

(instance cabinetView of EcoProp
	(properties
		x 150
		y 152
		z 50
		view 389
		priority 12
		signal 16400
		lookStr 62
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(not script)
				(!= (event type:) evVERB)
				(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not (event modifiers:))
			)
			(event claimed: 1)
			((gCurRoom script:) cue:)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance swimMask of EcoView
	(properties
		x 129
		y 178
		z 100
		view 389
		loop 1
		priority 14
		signal 16400
		lookStr 51
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4 ; Do
				(= local0 0)
				(cabinetView setScript: getItem)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance swimGloves of EcoView
	(properties
		x 128
		y 198
		z 100
		view 389
		loop 2
		priority 15
		signal 16400
		lookStr 50
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4 ; Do
				(= local0 0)
				(cabinetView setScript: getItem)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance lungs of EcoView
	(properties
		x 136
		y 177
		z 100
		view 389
		loop 4
		priority 13
		signal 16400
		lookStr 49
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4 ; Do
				(= local0 0)
				(cabinetView setScript: getItem)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance redThing of EcoView
	(properties
		x 147
		y 208
		z 100
		view 389
		loop 3
		priority 15
		signal 16400
		lookStr 52
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4 ; Do
				(= local0 29)
				(cabinetView setScript: getItem)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance fins of EcoView
	(properties
		x 165
		y 182
		z 100
		view 389
		loop 5
		priority 12
		signal 16400
		lookStr 48
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4 ; Do
				(= local0 0)
				(cabinetView setScript: getItem)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance emptyCabinet of EcoView
	(properties
		x 132
		y 48
		view 389
		loop 6
	)
)

(instance smallGear of EcoView
	(properties
		x 141
		y 51
		view 389
		loop 6
		cel 1
	)
)

