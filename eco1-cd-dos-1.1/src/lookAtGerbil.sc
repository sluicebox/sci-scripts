;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use RangeOsc)
(use n819)
(use EcoFeature)
(use Talker)
(use Motion)
(use System)

(public
	lookAtGerbil 0
)

(local
	[local0 42] = [148 94 12 158 95 12 169 97 12 180 98 12 189 95 12 198 93 12 209 92 12 209 92 0 198 93 0 189 95 0 180 98 0 169 97 0 158 95 0 148 94 0]
	local42
)

(instance lookAtGerbil of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 64)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 7)
				(Load rsVIEW 408)
				(if (and (not (IsFlag 69)) (== register -1))
					((ScriptID 2 1) init: 2 0 0 15 1 self) ; Adam, "Oh, man, I forgot to give him the water."
				else
					(= ticks 3)
				)
			)
			(1
				(cageView init:)
				(gerbil init:)
				(if (IsFlag 69)
					(waterBottleView init: stopUpd:)
					(gerbil
						setLoop: 5
						cel: 0
						posn: 163 66
						z: 0
						cycleSpeed: 4
						setCycle: Fwd
					)
					(cageView stopUpd:)
				else
					(cageView setScript: RattleCage)
				)
				(= seconds 3)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0)
				((ScriptID 400 3) stopUpd:) ; seaGull
				((ScriptID 400 7) stopUpd:) ; cageProp
				(cageView stopUpd:)
				(switch register
					(-1
						(cageView doVerb: 1)
					)
					(-2
						(cageView doVerb: 4)
					)
					(else
						(cageView doVerb: register)
					)
				)
			)
			(3
				(HandsOff)
				(gLongSong2 stop: flags: 0)
				(gLongSong pause: 0)
				(cageView hide:)
				(if (cageView script:)
					((cageView script:) dispose:)
				)
				(gerbil hide: setCycle: 0)
				(if (IsFlag 69)
					(waterBottleView hide:)
					((ScriptID 400 7) setCycle: 0 stopUpd:) ; cageProp
				)
				((ScriptID 400 3) startUpd:) ; seaGull
				(= cycles 3)
			)
			(4
				(cageView dispose: delete:)
				(gerbil dispose: delete:)
				(if (IsFlag 69)
					(waterBottleView dispose: delete:)
				)
				(= cycles 3)
			)
			(5
				(= cycles 3)
			)
			(6
				(HandsOn)
				(gTheIconBar enable: 7)
				(UnLoad 128 408)
				(self dispose:)
			)
		)
	)
)

(instance RattleCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gerbil setLoop: 1 cel: 0 posn: 121 175 cycleSpeed: 4)
				(= ticks 3)
			)
			(1
				(if (gerbil cel:)
					(gerbil setCycle: Beg self)
				else
					(gerbil setCycle: End self)
				)
			)
			(2
				(= state 0)
				(gSoundEffects number: 403 loop: 1 play: self)
			)
		)
	)
)

(instance cageView of EcoProp
	(properties
		x 151
		y 168
		z 100
		view 408
		priority 12
		signal 16400
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
				(gUser controls:)
				(gUser input:)
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
				(if (IsFlag 69)
					(EcoNarrator posn: 10 140 init: 3 0 0 65) ; "The gerbil is really getting that heart rate up!"
				else
					(EcoNarrator posn: 10 140 init: 3 0 0 10) ; "Adam's gerbil lives in this cage."
				)
			)
			(4 ; Do
				(if (IsFlag 69)
					(EcoNarrator posn: 10 140 init: 3 0 0 64) ; "Adam shouldn't interfere with the gerbil's aerobic workout."
				else
					(EcoNarrator posn: 10 140 init: 3 0 0 56)
				)
			)
			(44 ; Inventory
				(cond
					((== temp0 23)
						(self setScript: waterGerbil)
					)
					((IsFlag 69)
						(EcoNarrator posn: 10 140 init: 3 0 0 64) ; "Adam shouldn't interfere with the gerbil's aerobic workout."
					)
					(else
						(EcoNarrator posn: 10 140 init: 3 0 0 82)
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance waterBottleView of EcoProp
	(properties
		x 194
		y 162
		z 100
		view 408
		cel 1
		priority 13
		signal 16400
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

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			((ScriptID 2 1) init: 2 0 0 33 1 0) ; Adam
		else
			(cageView doVerb: theVerb &rest)
		)
	)
)

(instance gerbil of EcoProp
	(properties
		x 121
		y 175
		z 100
		view 408
		loop 1
		priority 13
		signal 16400
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
				(if (IsFlag 69)
					(EcoNarrator posn: 10 140 init: 3 0 0 65) ; "The gerbil is really getting that heart rate up!"
				else
					(EcoNarrator posn: 10 140 init: 3 0 0 10) ; "Adam's gerbil lives in this cage."
				)
			)
			(4 ; Do
				(if (IsFlag 69)
					(EcoNarrator posn: 10 140 init: 3 0 0 64) ; "Adam shouldn't interfere with the gerbil's aerobic workout."
				else
					(EcoNarrator posn: 10 140 init: 3 0 0 56)
				)
			)
			(44 ; Inventory
				(if (== temp0 23)
					(cageView setScript: waterGerbil)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance curtain of EcoProp
	(properties
		x 164
		y 58
		view 419
		priority 14
		signal 16400
	)
)

(instance waterGerbil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong pause:)
				(SetFlag 69)
				(SetScore 5 216)
				(HandsOff)
				(waterBottleView init: stopUpd:)
				(gEgo put: 14 400) ; waterBottle
				(= seconds 3)
			)
			(1
				(EcoNarrator posn: 10 140 init: 3 0 0 93 self 400)
			)
			(2
				(gLongSong2 number: 401 loop: -1 flags: 1 play:)
				(gerbil setLoop: 2 cel: 0 posn: 121 175 setCycle: CT 5 1 self)
			)
			(3
				(gerbil setCycle: RangeOsc 3 5 10 self)
			)
			(4
				(gerbil setCycle: End self)
			)
			(5
				(cageView startUpd:)
				(curtain init: setCycle: End)
				(= seconds 3)
			)
			(6
				(gerbil loop: 3 cel: 0 posn: 141 94 z: 0)
				(curtain setCycle: Beg self)
			)
			(7
				(curtain setCycle: 0 dispose: delete:)
				(UnLoad 128 419)
				(gerbil setPri: 15 setCycle: CT 8 1 self)
			)
			(8
				(cageView stopUpd:)
				(gerbil setCycle: RangeOsc 3 8 9 self)
			)
			(9
				(gerbil cel: 10 setCycle: CT 11 1 self)
			)
			(10
				(gerbil setCycle: RangeOsc 5 11 13 self)
			)
			(11
				(gerbil setLoop: 4 posn: 141 94 setCycle: End self)
			)
			(12
				(= register 0)
				(gerbil setCycle: Beg self)
			)
			(13
				(gerbil
					cel: [local0 (+ (* register 3) 2)]
					posn:
						[local0 (+ (* register 3) 0)]
						[local0 (+ (* register 3) 1)]
				)
				(if (gerbil cel:)
					(gerbil setCycle: Beg self)
				else
					(gerbil setCycle: End self)
				)
			)
			(14
				(-= state 2)
				(if (== (++ register) 14)
					(if (not local42)
						(= local42 1)
						((ScriptID 2 1) init: 2 0 0 32 1 self) ; Adam, "I guess that hits the spot, huh?"
						(HandsOn)
						(gTheIconBar disable: 0)
						(gTheIconBar curIcon: (gTheIconBar at: 2))
						(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					else
						(= ticks 3)
					)
					(= register 0)
				else
					(= ticks 3)
				)
			)
		)
	)
)

