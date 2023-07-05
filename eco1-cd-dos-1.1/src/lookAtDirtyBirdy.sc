;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use Talker)
(use PolyPath)
(use StopWalk)
(use Motion)
(use System)

(public
	lookAtDirtyBirdy 0
	lookAtCleanBirdy 3
)

(instance lookAtDirtyBirdy of Script
	(properties)

	(method (dispose)
		(ClearFlag 149)
		(super dispose: &rest)
		(DisposeScript 66)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 149)
				(SetFlag 125)
				(gEgo setMotion: PolyPath 211 123 self)
				((ScriptID 400 1) setScript: 0) ; father
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				((ScriptID 400 1) setHeading: 90 self) ; father
			)
			(3
				(if (IsFlag 126)
					(if (>= register 0)
						(= ticks 3)
					else
						(EcoNarrator posn: -1 140 init: 3 0 0 18 self) ; "Adam's dad found a seagull coated with oil."
					)
				else
					((ScriptID 2 1) init: 2 0 0 3 1 self) ; Adam, "Sure. What's up?"
				)
			)
			(4
				(if (or (IsFlag 126) (>= register 0))
					(+= state 2)
					(= ticks 1)
				else
					((ScriptID 400 9) init: 1 0 0 8 0 self) ; Father, "I found another bird this morning. These oil spills - they make me so mad I can't see straight."
					(SetFlag 126)
				)
			)
			(5
				((ScriptID 400 9) init: 1 0 0 9 0 self) ; Father, "Anyhow, let's see what we can do about it."
			)
			(6
				((ScriptID 400 9) init: 1 0 0 10 1 self) ; Father, "Take a closer look, then get a rag ready."
			)
			(7
				(ClearFlag 33)
				(bird init:)
				(if (not (gEgo has: 33)) ; rag
					(tRag init:)
				)
				(if (and (not (gEgo has: 18)) (!= global232 2)) ; dishSoap
					(detergent init:)
				)
				(= cycles 6)
			)
			(8
				(HandsOn)
				(gTheIconBar disable: 0)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(cond
					((== register -1)
						(bird doVerb: 1)
					)
					((== register -2)
						(bird doVerb: 4)
					)
					((== register -3)
						(bird doVerb: 2)
					)
					(else
						(bird doVerb: 44 register)
					)
				)
			)
			(9
				(HandsOff)
				(bird hide:)
				(if (not (gEgo has: 33)) ; rag
					(tRag dispose:)
				)
				(if (not (gEgo has: 18)) ; dishSoap
					(detergent dispose: delete:)
				)
				(= cycles 3)
			)
			(10
				(bird dispose: delete:)
				(= cycles 3)
			)
			(11
				(gEgo startUpd:)
				((ScriptID 400 1) startUpd:) ; father
				(if (or (gEgo has: 18) (== global232 2)) ; dishSoap
					((ScriptID 400 5) startUpd: hide:) ; dishSoap
				)
				(if (gEgo has: 33) ; rag
					((ScriptID 400 4) startUpd: hide:) ; rag
				)
				(= ticks 3)
			)
			(12
				(if (or (gEgo has: 18) (== global232 2)) ; dishSoap
					((ScriptID 400 5) dispose: delete:) ; dishSoap
				)
				(if (gEgo has: 33) ; rag
					((ScriptID 400 4) dispose: delete:) ; rag
				)
				(= ticks 3)
			)
			(13
				(SetFlag 33)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtCleanBirdy of Script
	(properties)

	(method (dispose)
		(ClearFlag 149)
		(super dispose: &rest)
		(DisposeScript 66)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 149)
				(gEgo setMotion: PolyPath 211 123 self)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 0)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gEgo setHeading: 270 self)
			)
			(2
				(bird init:)
				(auxBird init:)
				(beak init: setCycle: Fwd)
				(eye init: setCycle: Fwd)
				(= seconds 2)
			)
			(3
				(cond
					((== register -1)
						(bird doVerb: 1)
					)
					((== register -2)
						(bird doVerb: 4)
					)
					((== register -3)
						(bird doVerb: 2)
					)
					(else
						(bird doVerb: register)
					)
				)
			)
			(4
				(bird hide:)
				(auxBird hide:)
				(beak hide:)
				(eye hide:)
				(= cycles 3)
			)
			(5
				(bird dispose: delete:)
				(auxBird dispose: delete:)
				(beak dispose: delete:)
				(eye dispose: delete:)
				(= cycles 3)
			)
			(6
				(gEgo startUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cleanBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo put: 33) ; rag
				(bird hide:)
				(= cycles 3)
			)
			(1
				(bird dispose: delete:)
				(SetScore 5 203)
				(= global232 3)
				(= cycles 3)
			)
			(2
				((ScriptID 400 9) init: 1 0 0 13 1 self) ; Father, "Great! Hold on a sec!"
			)
			(3
				(ClearFlag 33)
				((ScriptID 400 1) setScript: 0) ; father
				(gEgo setMotion: PolyPath 182 113 self)
			)
			(4
				((ScriptID 400 1) ; father
					view: 411
					setLoop: (ScriptID 400 2) ; stopGroop
					setCycle: StopWalk 410
					cycleSpeed: 10
					moveSpeed: 10
					setStep: 6 4
					ignoreActors: 1
					setMotion: PolyPath 198 126 self
				)
			)
			(5
				((ScriptID 400 1) setHeading: 315 self) ; father
			)
			(6
				(gEgo view: 407 loop: 0 cel: 0 posn: 182 111)
				((ScriptID 400 3) setCel: 2) ; seaGull
				((ScriptID 400 1) ; father
					view: 407
					loop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: End
				)
				(= seconds 3)
			)
			(7
				((ScriptID 400 1) loop: 2 cel: 0 posn: 198 126 setCycle: Fwd) ; father
				((ScriptID 400 9) init: 1 0 0 14 1 self) ; Father, "Easy now, pal!"
			)
			(8
				(= seconds 3)
			)
			(9
				((ScriptID 400 9) init: 1 0 0 15 1 self) ; Father, "Try to apply the soap with the grain of the feathers. That'll get most of the oil without breaking them."
			)
			(10
				((ScriptID 2 1) init: 2 0 0 4 1 self) ; Adam, "Gross...Will the bird die?"
			)
			(11
				((ScriptID 400 9) init: 1 0 0 27 0 self) ; Father, "He might. Depends how much of a shock he's had. We're going to do all we can."
			)
			(12
				((ScriptID 400 9) init: 1 0 0 17 1 self) ; Father, "Why don't you finish up?"
			)
			(13
				(gEgo hide:)
				((ScriptID 400 1) view: 407 loop: 3 cel: 0 setCycle: End self) ; father
			)
			(14
				(gEgo show: view: 407 loop: 4 cel: 0 cycleSpeed: 20)
				((ScriptID 400 1) ; father
					view: 411
					setLoop: (ScriptID 400 2) ; stopGroop
					setCycle: StopWalk 410
					cycleSpeed: 10
					moveSpeed: 10
					setStep: 6 4
					posn: 198 126
					loop: 7
					heading: 315
				)
				(self setScript: rubBird self)
			)
			(15
				(gEgo loop: 6 cel: 0 posn: 182 111)
				(= seconds 3)
			)
			(16
				((ScriptID 2 1) init: 2 0 0 5 1 self) ; Adam, "Should I take him outside and let him go?"
			)
			(17
				((ScriptID 400 9) init: 1 0 0 18 0 self) ; Father, "Not just yet. The soap removes his natural oils, too, and that's what makes him float. He'd be shark bait until they build up again."
			)
			(18
				((ScriptID 400 9) init: 1 0 0 19 1 self) ; Father, "We'll take care of him and hope for the best."
			)
			(19
				((ScriptID 2 1) init: 2 0 0 6 1 self) ; Adam, "I wish there was something more we could do."
			)
			(20
				((ScriptID 400 9) init: 1 0 0 20 1 self) ; Father, "Me, too. I feel like all we do is clean up after the fact. And it doesn't work too well."
			)
			(21
				(gEgo loop: 7 cel: 0 setCycle: End self)
			)
			(22
				((ScriptID 400 3) setCel: 0) ; seaGull
				(SetFlag 10)
				(NormalEgo 2)
				(= seconds 1)
			)
			(23
				((ScriptID 400 1) setMotion: PolyPath 159 118 self) ; father
			)
			(24
				((ScriptID 400 1) setHeading: 90 self) ; father
			)
			(25
				((ScriptID 400 9) init: 1 0 0 21 1 self) ; Father, "Even this fertilizer solution I'm working on for cleaning up the surface depends on too many factors, such as water temperature, current, stuff like that."
			)
			(26
				(gEgo posn: 182 113 setMotion: PolyPath 189 118 self)
			)
			(27
				(gEgo setHeading: 270 self)
			)
			(28
				(gEgo view: 427 posn: 178 117 ignoreActors: 1 cel: 0 loop: 4)
				((ScriptID 400 6) startUpd: dispose:) ; beaker
				(gEgo get: 13) ; beaker
				((ScriptID 400 1) ; father
					view: 427
					loop: 3
					cel: 0
					posn: 178 117
					ignoreActors: 1
					setCycle: CT 3 1 self
				)
			)
			(29
				(gEgo setCycle: CT 4 1 self)
			)
			(30
				(gEgo setCycle: End)
				((ScriptID 400 1) setCycle: End self) ; father
			)
			(31
				(SetScore 2 208)
				((ScriptID 400 9) init: 1 0 0 22 0 self) ; Father, "I think this mix is better. It might even work on the coral a little bit. Try it out if you want."
			)
			(32
				((ScriptID 400 9) init: 1 0 0 23 1 self) ; Father, "Blast! I'm late again! All these meetings are getting to me."
			)
			(33
				(NormalEgo 1)
				(gEgo posn: 189 118)
				((ScriptID 400 1) ; father
					view: 411
					setLoop: (ScriptID 400 2) ; stopGroop
					setCycle: StopWalk 410
					cycleSpeed: 10
					moveSpeed: 10
					setStep: 6 4
					posn: 159 118
					loop: 0
					heading: 90
					setMotion: PolyPath 133 150 self
				)
			)
			(34
				((ScriptID 400 1) setHeading: 45 self) ; father
			)
			(35
				((ScriptID 400 9) init: 1 0 0 24 1 self) ; Father, "So, do you want to go outside or stay here and maybe work with the dolphin? He's not recovering well from being entangled in that driftnet. He could use some encouragement!"
			)
			(36
				((ScriptID 2 1) init: 2 0 0 7 1 self) ; Adam, "Wow, could I work with the dolphin?"
			)
			(37
				((ScriptID 400 9) init: 1 0 0 25 0 self) ; Father, "Yeah, go ahead. Just look at my instructions on the blackboard in the treatment room first, though. We have to make sure we're all doing the same thing with him."
			)
			(38
				((ScriptID 400 9) init: 1 0 0 26 1 self) ; Father, "Gotta run! Committees!"
			)
			(39
				((ScriptID 400 1) setMotion: MoveTo -16 225 self) ; father
			)
			(40
				((ScriptID 400 1) dispose:) ; father
				(HandsOff)
				(lookAtDirtyBirdy cue:)
				(self dispose:)
			)
		)
	)
)

(instance getRag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo get: 33) ; rag
				(tRag dispose:)
				((ScriptID 400 4) startUpd: hide:) ; rag
				(= cycles 6)
			)
			(1
				(EcoNarrator posn: -1 140 init: 3 0 0 72 self 400) ; "Adam takes the clean rag."
			)
			(2
				((ScriptID 400 4) dispose: delete:) ; rag
				(SetScore 2 200)
				(HandsOn)
				(gTheIconBar disable: 0)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(self dispose:)
			)
		)
	)
)

(instance getDetergent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo get: 18) ; dishSoap
				(detergent dispose: delete:)
				((ScriptID 400 5) startUpd: hide:) ; dishSoap
				(= cycles 6)
			)
			(1
				(EcoNarrator posn: -1 140 init: 3 0 0 73 self 400)
			)
			(2
				((ScriptID 400 5) dispose: delete:) ; dishSoap
				(SetScore 2 201)
				(HandsOn)
				(gTheIconBar disable: 0)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(self dispose:)
			)
		)
	)
)

(instance rubBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (++ register) 27)
					(= state -1)
				)
				(gSoundEffects number: 402 loop: 1 play:)
				(gEgo cel: (mod register 15))
				(= cycles 5)
			)
			(1
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance beak of EcoProp
	(properties
		z 100
		view 404
		loop 5
		priority 14
		signal 16401
		cycleSpeed 20
	)

	(method (init)
		(self posn: (+ (auxBird x:) 19) (+ (auxBird y:) -1))
		(super init: &rest)
	)

	(method (doVerb)
		(bird doVerb: &rest)
	)
)

(instance eye of EcoProp
	(properties
		z 100
		view 404
		loop 4
		priority 15
		signal 16401
		cycleSpeed 30
	)

	(method (init)
		(self posn: (+ (auxBird x:) 18) (+ (auxBird y:) -2))
		(super init: &rest)
	)

	(method (doVerb)
		(bird doVerb: &rest)
	)
)

(instance bird of EcoProp
	(properties
		x 100
		y 153
		z 100
		view 404
		priority 14
		signal 20497
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
			(4 ; Do
				(if (IsFlag 10)
					(EcoNarrator posn: -1 140 init: 3 0 0 51)
				else
					(EcoNarrator posn: -1 140 init: 3 0 0 4) ; "Touching the bird would upset it more."
				)
			)
			(1 ; Look
				(if (IsFlag 10)
					(EcoNarrator posn: -1 140 init: 3 0 0 19) ; "Adam will take care of the bird until its natural oils coat its feathers. Then the bird will be able to float again."
				else
					(EcoNarrator posn: -1 140 init: 3 0 0 1) ; "The seagull is covered with oil and shivering miserably."
				)
			)
			(2 ; Talk
				((ScriptID 2 1) init: 2 0 0 35 1) ; Adam, "Poor guy. You'll get better. Don't worry."
			)
			(44 ; Inventory
				(switch temp0
					(42
						(cond
							((IsFlag 10)
								(EcoNarrator posn: -1 140 init: 3 0 0 51)
							)
							((== global232 2)
								(gEgo setScript: cleanBird)
							)
							(else
								((ScriptID 400 9) init: 1 0 0 28 1) ; Father, "The rag's too dry. Better put some soap on it."
							)
						)
					)
					(27
						(EcoNarrator posn: -1 140 init: 3 0 0 88)
					)
					(else
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance auxBird of EcoProp
	(properties
		z 100
		view 404
		loop 1
		priority 15
		signal 16401
		lookStr 23
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self posn: (+ (bird x:) 30) (+ (bird y:) 26))
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(bird doVerb: &rest)
	)
)

(instance tRag of EcoProp
	(properties
		x 109
		y 207
		z 100
		view 404
		loop 3
		priority 15
		signal 16401
		lookStr 21
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
		(switch theVerb
			(1 ; Look
				(EcoNarrator posn: -1 140 init: 3 0 0 lookStr self)
			)
			(4 ; Do
				(bird setScript: getRag)
			)
			(else
				(super doVerb: theVerb temp0 &rest) ; UNINIT
			)
		)
	)
)

(instance detergent of EcoProp
	(properties
		x 132
		y 204
		z 100
		view 404
		loop 2
		priority 15
		signal 16401
		lookStr 20
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
				(EcoNarrator posn: -1 140 init: 3 0 0 lookStr self)
			)
			(4 ; Do
				(bird setScript: getDetergent)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

