;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Gaza)
(use n128)
(use eRoom)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	Rm47 0
	theCobra 1
	sentry 2
	waitForStrike 3
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4]
	[local9 4] = [228 232 221 215]
	[local13 4] = [145 143 141 146]
	[local17 8]
	[local25 8]
	[local33 8] = [191 138 182 161 285 269 222 244]
	[local41 8] = [91 123 89 102 107 96 85 99]
	[local49 8] = [0 2 4 6 5 7 3 1]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(= [local17 temp0] (aCobra new:))
		([local17 temp0]
			setLoop: [local49 temp0]
			cel: 0
			posn: [local33 temp0] [local41 temp0]
			init:
		)
	)
	([local17 2] setPri: 4)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(= [local25 temp0] (aCobraScript new:))
		([local17 temp0] setScript: [local25 temp0])
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 global114) ((++ temp0))
		(= [local5 temp0] (aDeadSnake new:))
		([local5 temp0]
			posn: [local9 temp0] [local13 temp0]
			ignoreActors: 1
			init:
			stopUpd:
		)
	)
)

(instance aCobra of Prop
	(properties
		view 247
		cycleSpeed 1
	)
)

(instance aCobraScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				(= cycles (Random 10 40))
			)
			(1
				(client setCycle: 0)
				(= cycles (Random 20 50))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance aDeadSnake of View
	(properties
		view 149
		loop 9
	)
)

(instance theCobra of Act
	(properties
		yStep 4
		view 147
		xStep 6
	)
)

(instance sentry of Act
	(properties
		y 160
		x 300
		view 147
		loop 1
		signal 16384
		cycleSpeed 1
		illegalBits 0
	)
)

(instance Rm47 of eRoom
	(properties
		picture 47
	)

	(method (dispose)
		(ClearFlag 82)
		(super dispose:)
	)

	(method (init)
		(self
			style:
				(switch global103
					(0 100)
					(1 15)
					(2 17)
				)
		)
		(Load rsVIEW 147)
		(Load rsVIEW 149)
		(Load rsVIEW 247)
		(Load rsVIEW 23)
		(super init:)
		(SetFlag 82)
		(proc0_13 65)
		(gAddToPics doit:)
		(self setRegions: 107) ; Gaza
		(gRegMusic stop:)
		(gRmMusic number: 69 loop: -1 priority: 1 play:)
		(localproc_0)
		(if global114
			(= local4 1)
			(localproc_2)
		)
		(= global136 1)
		(gEgo init:)
		(self enterRoom: 196 235 196 182)
		(if (IsFlag 20)
			(self muleEnterRoom: 250 230 250 175)
		)
		(sentry init: setScript: (ScriptID 192 0)) ; slitherIn
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((> (gEgo y:) 185)
					(gRmMusic fade:)
					(if global124
						(= global137 100)
					)
					(self leaveRoom: 46 (gEgo x:) 235)
				)
				((and (gEgo inRect: 88 140 95 144) (not (gEgo script:)))
					(gEgo setScript: behindRockBite)
				)
				((and (< (gEgo y:) 140) (not local2))
					(= local2 1)
					(gEgo setMotion: 0)
					(Print 47 0) ; "This valley is filled with cobras!  Turn back, Arthur. You will never pass through here alive."
				)
				((and (not local1) (== (sentry script:) waitForStrike))
					(= local1 1)
					(localproc_1)
				)
				((not local0)
					(= local0 1)
					(HandsOff)
				)
			)
		)
		(if (and (<= (gEgo y:) 130) (not (theCobra script:)))
			(theCobra setScript: (ScriptID 187 0)) ; getBit
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((Said 'get,capture,eat,hit,stab,kill/adder')
				(Print 47 1) ; "There are too many cobras to do that without being fatally bitten."
			)
			((Said 'get,pick,eat/plant,aloe')
				(Print 47 2) ; "To do that, you would have to get through the cobras. I can think of no earthly reason to take such a risk."
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(Print 47 3) ; "Do not trifle with cobras."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/desert,canyon')
							(Said '//desert,canyon')
						)
						(Print 47 4) ; "The cliffs converge into a narrow valley, but this portion of it is filled with cobras. And they have no intention of letting you pass."
					)
					((or (Said '/ass') (Said '//ass'))
						(cond
							((== global206 46)
								(Print 47 5) ; "Your mule is smarter than you. She refuses to come near the cobras."
							)
							((>= global202 2)
								(Print 47 6) ; "You no longer have your mule."
							)
						)
					)
					((MouseClaimed sentry event)
						(if (or (== (sentry loop:) 4) (== (sentry loop:) 5))
							(Print 47 7) ; "The snake lies where you killed it."
						else
							(Print 47 8) ; "Beware, Arthur. This cobra watches you with malign intent."
						)
					)
					(
						(or
							(Said '/plant,aloe')
							(Said '//plant,aloe')
							(OnButton event 77 48 94 61)
							(OnButton event 173 72 185 82)
							(OnButton event 110 85 150 116)
						)
						(Print 47 9) ; "There are some aloe vera plants growing here."
					)
					((OnButton event 173 5 209 23)
						(Print 47 10) ; "You dare not look long at the glaring sky, unbroken by any cloud, where the sun burns as mercilessly as a demon's eye."
					)
					(
						(or
							(Said '/cliff,mesa,terrain')
							(Said '//cliff,mesa,terrain')
							(OnButton event 0 0 319 80)
						)
						(Print 47 11) ; "The cliffs have drawn together to form this narrow valley, but it is impossible to tell whether the valley continues or closes up ahead."
					)
					(
						(or
							(Said '/adder,reptile<dead')
							(Said '//adder,reptile<dead')
							(Said '/body')
							(Said '//body')
						)
						(if global114
							(Print 47 12) ; "Aye, it is dead and not pleasant to look upon."
						else
							(Print 47 13) ; "The snakes are alive and well, which you will not be if you get too close to them."
						)
					)
					(
						(or
							(Said '/adder,reptile')
							(Said '//adder,reptile')
							(MouseClaimed [local17 0] event)
							(MouseClaimed [local17 1] event)
							(MouseClaimed [local17 2] event)
							(MouseClaimed [local17 3] event)
							(MouseClaimed [local17 4] event)
							(MouseClaimed [local17 5] event)
							(MouseClaimed [local17 6] event)
							(MouseClaimed [local17 7] event)
						)
						(Print 47 14) ; "These snakes are desert cobras and are utterly lethal. Stay well clear of them."
					)
					(
						(or
							(OnButton event 213 105 247 137)
							(OnButton event 278 133 310 189)
							(OnButton event 7 76 74 185)
							(OnButton event 74 102 120 185)
							(OnButton event 121 147 167 185)
						)
						(proc107_2)
					)
					((and local4 (MouseClaimed [local5 0] event))
						(Print 47 12) ; "Aye, it is dead and not pleasant to look upon."
					)
				)
			)
			((Said 'draw/blade')
				(event claimed: 1)
			)
			((Said '*/adder')
				(Print 47 15) ; "A rather novel idea, Arthur, but entirely foolish."
			)
		)
	)
)

(instance waitForStrike of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(>= state 4)
					(or
						(gEgo inRect: 204 147 215 155)
						(gEgo inRect: 242 147 248 158)
						(gEgo inRect: 206 136 215 146)
						(gEgo inRect: 241 138 256 142)
						(gEgo inRect: 216 142 242 150)
					)
				)
				(client setScript: biteEgo)
			)
			(
				(and
					(== global125 4)
					(== (gEgo cel:) (if (> (gEgo loop:) 1) 2 else 5))
					(or
						(and
							(gEgo inRect: 174 138 194 148)
							(== (gEgo loop:) 0)
						)
						(and
							(gEgo inRect: 254 138 278 148)
							(== (gEgo loop:) 1)
						)
						(and
							(gEgo inRect: 245 142 265 151)
							(== (gEgo loop:) 3)
						)
					)
					(>= state 4)
				)
				(client setScript: dontTreadOnMe)
			)
			((and (< (gEgo x:) (sentry x:)) local3)
				(= local3 0)
				(sentry loop: (+ (sentry loop:) 1))
			)
			((and (> (gEgo x:) (sentry x:)) (not local3))
				(= local3 1)
				(sentry loop: (- (sentry loop:) 1))
			)
			((and (< state 3) (< (gEgo distanceTo: sentry) 40))
				(= cycles (= seconds 0))
				(self changeState: 3)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1)
				(= cycles 5)
			)
			(1
				(client cel: 0)
				(= seconds (Random 2 5))
			)
			(2
				(self changeState: 0)
			)
			(3
				(HandsOff)
				(gEgo setMotion: 0)
				(sentry setCycle: End self)
			)
			(4
				(Print 47 16) ; "Arthur, beware! The cobra prepares to strike."
				(HandsOn)
			)
		)
	)
)

(instance dontTreadOnMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sentry setLoop: (if local3 4 else 5) cel: 0 setCycle: End self)
			)
			(1
				(if (< global114 4)
					(++ global114)
				)
				(Print 47 17) ; "With quick reflexes, you were able to kill the lone cobra, but there are many more. One of them is bound to strike you."
				(client setScript: 0)
			)
		)
	)
)

(instance biteEgo of Script
	(properties)

	(method (doit)
		(if (and (== (gSFX prevSignal:) -1) (== state 2))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSFX number: 75 loop: 1 priority: 5 play:)
				(gRmMusic stop:)
				(gRegMusic stop:)
				(sentry
					setLoop:
						(cond
							((gEgo inRect: 204 147 215 155) 3)
							((gEgo inRect: 242 147 248 158) 2)
							((gEgo inRect: 206 136 215 146) 7)
							((gEgo inRect: 241 138 256 142) 6)
							((gEgo inRect: 216 142 242 150) 8)
						)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(if (> (gEgo loop:) 1)
					(gEgo loop: (if local3 0 else 1))
				)
				(gEgo view: 23 cel: 0 illegalBits: 0 setCycle: End)
				(sentry setCycle: Beg)
				(= cycles 15)
			)
			(2
				(Print 47 18 #dispose) ; "Did I not warn you? This valley may truly be called a dead end, especially for you."
			)
			(3
				(clr)
				(EgoDead)
			)
		)
	)
)

(instance behindRockBite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSFX number: 75 loop: 1 priority: 5 play:)
				(gEgo view: 23 loop: 0 cel: 0 illegalBits: 0 setCycle: End)
				(= cycles 15)
			)
			(1
				(Print 47 18 #dispose) ; "Did I not warn you? This valley may truly be called a dead end, especially for you."
				(= cycles 25)
			)
			(2
				(clr)
				(EgoDead)
			)
		)
	)
)

