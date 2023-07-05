;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 125)
(include sci.sh)
(use Main)
(use n804)
(use n819)
(use Talker)
(use Feature)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	INSET 0
	Shell 1
	getTrident 2
)

(instance INSET of View
	(properties
		x 218
		y 141
		view 122
		priority 4
		signal 4113
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
		(if (not (gEgo has: 12)) ; trident
			((ScriptID 120 1) ; trident
				view: 122
				loop: 1
				cel: 0
				posn: 203 44
				setPri: 5
				approachX: 182
				approachY: 65
			)
		)
		(Shell init: stopUpd:)
		(gEgo posn: 214 110 heading: 0 loop: 3 setPri: (+ priority 3))
		(poseidonF init:)
		(Animate (gCast elements:) 0)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (gCurRoom script:))
				(gEgo mover:)
				(not (gEgo inRect: nsLeft nsTop nsRight nsBottom))
			)
			(gCurRoom setScript: disposeTrident)
		)
	)

	(method (dispose)
		(HandsOff)
		(self hide:)
		(Shell dispose: delete:)
		(if (not (gEgo has: 12)) ; trident
			((ScriptID 120 1) ; trident
				view: 120
				loop: 5
				cel: 0
				posn: 217 44
				setPri: 3
				stopUpd:
				approachVerbs: 2 ; Look
				approachX: 213
				approachY: 77
			)
		)
		(poseidonF dispose:)
		(NormalEgo 3)
		(gEgo
			ignoreHorizon:
			cel: 0
			heading: 0
			posn: ((ScriptID 120 2) approachX:) ((ScriptID 120 2) approachY:) ; TridentStatue, TridentStatue
			setPri: 7
		)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(if (gCurRoom script:)
			(gCurRoom setScript: 0)
		)
		(Animate (gCast elements:) 0)
		(super dispose:)
		(self delete:)
		(HandsOn)
		(= global115 0)
		(DisposeScript 125)
	)

	(method (handleEvent event)
		(if
			(and
				(!= (event type:) evVERB)
				(not
					(OneOf
						(event message:)
						KEY_TAB
						KEY_CONTROL
						KEY_F1
						KEY_F2
						KEY_F5
						KEY_F7
						KEY_F9
					)
				)
				(not (self onMe: event))
				(not (event modifiers:))
				(not (gCurRoom script:))
			)
			(event claimed: 1)
			(self dispose:)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 45 142 init: 3 0 0 43)
			)
			(4 ; Inventory
				(switch invItem
					(11 ; conchShell
						(gCurRoom setScript: putConchInHands)
					)
					(12 ; trident
						(Narrator posn: 45 142 init: 3 0 0 97)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poseidonF of Feature
	(properties
		x 204
		y 43
		nsTop 38
		nsLeft 198
		nsBottom 49
		nsRight 211
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((!= ((Inv at: 12) owner:) 120) ; trident
						(Narrator posn: 45 142 init: 3 0 0 98)
					)
					((== ((Inv at: 11) owner:) 120) ; conchShell
						(Narrator posn: 45 142 init: 3 0 0 99)
					)
					(else
						(Narrator posn: 45 142 store: 42 init: 3 0 0 41)
					)
				)
			)
			(5 ; Talk
				(gCurRoom setScript: talkOnPoseidon)
			)
			(3 ; Do
				(Narrator posn: 45 142 init: 3 0 0 46)
			)
			(4 ; Inventory
				(switch invItem
					(11 ; conchShell
						(Narrator posn: 45 142 init: 3 0 0 95)
					)
					(12 ; trident
						(Narrator posn: 45 142 init: 3 0 0 97)
					)
					(else
						(Narrator posn: 45 142 init: 3 0 0 91)
					)
				)
			)
			(10 ; Recycle
				(Narrator posn: 45 142 init: 3 0 0 92)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (onMe param1)
		(return
			(or
				(InRect 198 38 211 49 param1)
				(InRect 169 49 256 54 param1)
				(InRect 189 53 214 87 param1)
				(InRect 184 87 192 106 param1)
			)
		)
	)
)

(instance Shell of Prop
	(properties
		x 227
		y 89
		lookStr 44
		view 122
		cel 1
		priority 5
		signal 16400
	)

	(method (onMe param1)
		(return
			(or
				(InRect 214 84 243 116 param1)
				(InRect nsLeft nsTop nsRight nsBottom param1)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			loop: (* (== ((Inv at: 11) owner:) 120) 2) ; conchShell
			cel: (!= ((Inv at: 11) owner:) 120) ; conchShell
			approachX: 259
			approachY: 60
			approachVerbs: 4 ; Inventory
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== ((Inv at: 11) owner:) 120) ; conchShell
					(Narrator posn: 45 142 init: 4 0 0 7) ; "The bronze servant is now holding the conch shell, completing the statue."
				else
					(Narrator posn: 45 142 init: 3 0 0 44)
				)
			)
			(4 ; Inventory
				(if (== ((Inv at: 11) owner:) 120) ; conchShell
					(Narrator posn: 45 142 init: 4 0 0 4) ; "The servant is content with the conch shell and has no interest in anything else Adam might be carrying."
				else
					(switch invItem
						(11 ; conchShell
							(gCurRoom setScript: putConchInHands)
						)
						(22 ; hermetShell
							(Narrator posn: 45 142 init: 3 0 0 94)
						)
						(else
							(Narrator posn: 45 142 init: 3 0 0 93)
						)
					)
				)
			)
			(5 ; Talk
				(if (== ((Inv at: 11) owner:) 120) ; conchShell
					(Narrator posn: 45 142 init: 3 0 0 49)
				else
					(gCurRoom setScript: talkOnPoseidon 0 1)
				)
			)
			(3 ; Do
				(Narrator posn: 45 142 init: 3 0 0 47)
			)
			(10 ; Recycle
				(Narrator posn: 45 142 init: 4 0 0 1) ; "Adam doesn't need to throw the servant away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance disposeTrident of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(HandsOn)
				(INSET dispose:)
			)
		)
	)
)

(instance putConchInHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (Shell approachX:) (Shell approachY:) self
				)
			)
			(1
				(Face gEgo Shell self)
			)
			(2
				(Narrator posn: 45 142 init: 3 0 0 56 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 122
					setLoop: 4
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(4
				(Shell loop: 2 cel: 0 cycleSpeed: 18)
				(gEgo cel: 4 setCycle: End self)
			)
			(5
				(SetScore 10 252)
				(gEgo put: 11 120) ; conchShell
				(Shell setCycle: End self)
			)
			(6
				(gSoundEffects number: 646 loop: 1 flags: 1 play: self)
			)
			(7
				(Narrator posn: 45 142 init: 3 0 0 86 self)
			)
			(8
				(Shell setCycle: Beg self)
				((ScriptID 120 1) x: (+ ((ScriptID 120 1) x:) 1) forceUpd:) ; trident, trident
			)
			(9
				(gSoundEffects flags: 0)
				(Narrator posn: 45 142 init: 3 0 0 27 self) ; "Poseidon has loosened his grip on the trident!"
			)
			(10
				(NormalEgo 1)
				(gEgo ignoreHorizon: setPri: 7)
				(Shell stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getTrident of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 182 65 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				((ScriptID 120 1) hide:) ; trident
				(gEgo
					setCycle: 0
					view: 122
					setLoop: 3
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(if (== ((Inv at: 11) owner:) 120) ; conchShell
					(gSoundEffects number: 124 loop: 1 play:)
					(gEgo setCycle: End self)
				else
					(Narrator posn: 45 142 init: 3 0 0 26 self) ; "Adam pulls and pulls at the bronze trident, but Poseidon has it firmly in his grasp and is not ready to let go of it."
				)
			)
			(4
				(if (== ((Inv at: 11) owner:) 120) ; conchShell
					(SetScore 5 253)
					(gEgo get: 12) ; trident
					((ScriptID 120 1) dispose:) ; trident
					(Narrator posn: 45 142 init: 3 0 0 28 self) ; "Adam pulls on the bronze trident and it slides easily from Poseidon's fist!"
				else
					(gEgo setCycle: Beg self)
				)
			)
			(5
				(NormalEgo 3)
				(gEgo
					ignoreHorizon:
					cel: 0
					heading: 0
					posn:
						((ScriptID 120 2) approachX:) ; TridentStatue
						((ScriptID 120 2) approachY:) ; TridentStatue
					setPri: 7
				)
				(HandsOn)
				(if (not (gEgo has: 12)) ; trident
					((ScriptID 120 1) show:) ; trident
					(self dispose:)
					(INSET dispose:)
				else
					(INSET dispose:)
				)
			)
		)
	)
)

(instance talkOnPoseidon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 2 0 0 (+ 8 register) 1 self) ; Adam
			)
			(1
				(Narrator posn: 45 142 init: 3 0 0 (+ 48 register) self)
			)
			(2
				(= register 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

