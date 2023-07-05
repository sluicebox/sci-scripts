;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 441)
(include sci.sh)
(use Main)
(use n913)
(use Print)
(use Conversation)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	proc441_0 0
	proc441_1 1
	proc441_2 2
	minoTrigger 3
	minotaur 4
)

(local
	local0
	local1
	local2
)

(procedure (proc441_0 param1)
	(gGame handsOff:)
	(= local0 9)
	((ScriptID 30 0) setScript: 0) ; rLab
	(if (not local2)
		(= local2 1)
		(gCurRoom setScript: minoTrigger 0 param1)
	)
)

(procedure (proc441_1)
	(minotaur init:)
	(celeste init:)
	(= local0 8)
	(= local1 6)
)

(procedure (proc441_2)
	(gCurRoom setScript: stepInFurther)
)

(instance myConv of Conversation
	(properties)
)

(instance minotaur of Actor
	(properties
		x 114
		y 147
		noun 4
		yStep 3
		view 4445
		signal 16384
		cycleSpeed 18
		xStep 5
	)

	(method (cue)
		(if (not ((ScriptID 30 0) seenByMino:)) ; rLab
			(proc441_0 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 4 2 local0 0 self 440)
			)
			(5 ; Do
				(if ((ScriptID 30 0) seenByMino:) ; rLab
					(gCurRoom setScript: minotaurCharging 0 5)
				else
					(gCurRoom setScript: handToHand)
				)
			)
			(72 ; scarf
				(if (== (gCurRoom script:) minoTrigger)
					((ScriptID 30 0) scarfOnMino: 1) ; rLab
					(gEgo view: 441 normal: 0 setLoop: 0 cel: 0)
					(UnLoad 128 900)
					(minotaur cycleSpeed: 6 setCycle: Fwd)
					(minoTrigger state: 19 register: 72 cue:)
					(gGame handsOff:)
					(gGame givePoints: 3)
				else
					(gMessager say: 4 0 8 1 self 440) ; "Alexander steps forward, determined to use anything at hand to save the girl. But before he can do anything...."
				)
			)
			(1 ; Look
				(gMessager say: 4 1 0 1 0 440) ; "The minotaur is a huge, monstrous beast with cloven hooves and the head of a bull."
			)
			(else
				(if (not ((ScriptID 30 0) seenByMino:)) ; rLab
					(gMessager say: 4 0 8 1 self 440) ; "Alexander steps forward, determined to use anything at hand to save the girl. But before he can do anything...."
				else
					(gMessager say: 4 0 9 1 self 440) ; "That would have little effect on the rampaging minotaur!"
				)
			)
		)
	)

	(method (init)
		(self setCycle: RandCycle)
		(super init:)
	)
)

(instance celeste of Actor
	(properties
		x 103
		y 124
		noun 5
		view 4421
		cycleSpeed 24
	)

	(method (init)
		(self setCycle: RandCycle)
		(super init:)
	)

	(method (cue)
		(if (not ((ScriptID 30 0) seenByMino:)) ; rLab
			(proc441_0 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 local0 1 0 440)
			)
			(2 ; Talk
				(gMessager say: 5 2 local0 0 self 440)
			)
			(5 ; Do
				(gMessager say: 5 5 local0 1 self 440)
			)
			(else
				(gMessager say: 5 0 local1 1 0 440)
			)
		)
	)
)

(instance stepInFurther of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myConv add: 440 2 3 8 1 add: 440 2 3 8 2 init: self) ; "Alexander steps further into the room.", "The movement catches Lady Celeste's eye. She screams for help."
			)
			(1
				(proc441_0 0)
			)
		)
	)
)

(instance handToHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myConv add: 440 4 5 8 1 add: 440 4 5 8 2 init: self) ; "Alexander prepares to take on the minotaur with his bare hands. He steps forward bravely....", "And is spotted by Lady Celeste!"
			)
			(1
				(proc441_0 5)
			)
		)
	)
)

(instance minoTrigger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 111 174 self)
			)
			(1
				(gEgo setHeading: 0)
				(= cycles 8)
			)
			(2
				(gMessager say: 1 0 3 1 self 440) ; "You there! Human! Help me! HELP!"
			)
			(3
				((ScriptID 30 0) seenByMino: 1) ; rLab
				(minotaur view: 443 setCycle: 0 setLoop: 1 cel: 0 posn: 110 148)
				(UnLoad 128 444)
				(= cycles 2)
			)
			(4
				(gGlobalSound number: 441 setLoop: -1 play:)
				(gGlobalSound4 number: 433 setLoop: 1 play: self)
				(minotaur setLoop: 2 cel: 5 posn: 90 151)
			)
			(5
				(myConv add: 440 1 0 3 2 add: 440 1 0 3 3 init: self) ; "<GROWL> Who dares enter my lair?", "I ask you to release your captive or suffer the consequences!"
			)
			(6
				(gGlobalSound4 number: 433 setLoop: 1 play:)
				(= cycles 4)
			)
			(7
				(myConv add: 440 1 0 3 4 add: 440 1 0 3 5 init: self) ; "<GRRRROAAARR!> Never! You die, human!", "As the minotaur advances in attack, Alexander slowly backs away...."
			)
			(8
				(minotaur
					view: 443
					setLoop: 2
					setCycle: Walk
					illegalBits: 0
					cycleSpeed: 3
					setMotion: MoveTo 59 177 self
				)
				(= cycles 4)
			)
			(9
				(self setScript: backup self)
			)
			(10
				(minotaur setLoop: 0)
				(= cycles 2)
			)
			(11
				(minotaur view: 4441)
				(UnLoad 128 443)
				(= ticks 5)
			)
			(12)
			(13
				(gEgo setLoop: 2 setMotion: MoveTo 145 151 self)
			)
			(14
				(gEgo setHeading: 210)
				(= ticks 6)
			)
			(15
				(gMessager say: 1 0 3 6 self 440) ; "Until he can back away no more!"
			)
			(16
				(gEgo
					view: 441
					normal: 0
					setLoop: 1
					x: (+ (gEgo x:) 10)
					y: (+ (gEgo y:) 5)
					cel: 0
				)
				(UnLoad 128 900)
				(= ticks 6)
			)
			(17
				(minotaur cycleSpeed: 6 setCycle: Fwd)
				(= ticks 8)
			)
			(18
				(if ((ScriptID 30 0) scarfOnMino:) ; rLab
					(self cue:)
				else
					(gMessager say: 1 0 3 7 self 440) ; "Now where to, <GROWL> little man?"
				)
			)
			(19
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(= seconds 2)
			)
			(20
				(= cycles 8)
			)
			(21
				(if ((ScriptID 30 0) scarfOnMino:) ; rLab
					(gMessager say: 4 38 11 1 self 440) ; "Alexander, his back inches from the fiery pit, tempts the minotaur with the red queen's scarf."
				else
					(self cue:)
				)
			)
			(22
				(cond
					((== register 5)
						(gMessager say: 4 5 9 1 self 440) ; "Alexander prepares to take on the minotaur with his bare hands."
					)
					(((ScriptID 30 0) scarfOnMino:) ; rLab
						(gMessager say: 4 38 11 2 self 440) ; "Look here, you bully! Nice, bright red!"
					)
					(else
						(self cue:)
					)
				)
			)
			(23
				(= seconds 2)
			)
			(24
				(if ((ScriptID 30 0) scarfOnMino:) ; rLab
					(gMessager say: 4 38 11 3 self 440) ; "<SNORT!> RRRRRED!"
				else
					(self cue:)
				)
			)
			(25
				(= seconds 2)
			)
			(26
				(gGlobalSound4 number: 433 setLoop: 1 play:)
				(= cycles 4)
			)
			(27
				(if ((ScriptID 30 0) scarfOnMino:) ; rLab
					(gMessager say: 4 38 11 4 self 440) ; "!!!Do sound effect: "GRROAARRRRrrrrrrr...!""
				else
					(= ticks 8)
				)
			)
			(28
				(gMessager say: 1 0 5 1 self 440) ; "Now you die!"
			)
			(29
				(client setScript: minotaurCharging 0 register)
			)
		)
	)
)

(instance minotaurCharging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(= cycles 12)
			)
			(1
				(if ((ScriptID 30 0) scarfOnMino:) ; rLab
					(gEgo view: 441 setLoop: 0)
					(UnLoad 128 900)
				)
				(if (== register 5)
					(gMessager say: 4 5 9 1 self 440) ; "Alexander prepares to take on the minotaur with his bare hands."
				else
					(self cue:)
				)
			)
			(2
				(gGlobalSound4 number: 433 setLoop: 1 play:)
				(minotaur view: 4441 cel: 7 setPri: 14)
				(= ticks 2)
			)
			(3
				(minotaur
					view: 4442
					cel: 1
					posn: (+ (minotaur x:) 7) (- (minotaur y:) 6)
				)
				(UnLoad 128 4441)
				(= ticks 2)
			)
			(4
				(minotaur cel: 2 posn: (+ (minotaur x:) 19) (- (minotaur y:) 9))
				(= ticks 2)
			)
			(5
				(minotaur cel: 3 posn: (+ (minotaur x:) 18) (+ (minotaur y:) 5))
				(= ticks 2)
			)
			(6
				(minotaur cel: 4 posn: (+ (minotaur x:) 8) (minotaur y:))
				(= ticks 2)
			)
			(7
				(minotaur cel: 5 posn: (+ (minotaur x:) 13) (- (minotaur y:) 8))
				(= ticks 2)
			)
			(8
				(if ((ScriptID 30 0) scarfOnMino:) ; rLab
					(gEgo cel: 0 setScript: 0 setCycle: End)
					(minotaur cel: 6 posn: (+ (minotaur x:) 14) (minotaur y:))
					(= ticks 2)
				else
					(gCurRoom setScript: hornSwaggled 0 register)
				)
			)
			(9
				(celeste setCycle: 0 stopUpd:)
				(gGlobalSound number: 442 setLoop: 1 play: self)
				(gGlobalSound4 number: 433 setLoop: 1 play:)
				(minotaur
					view: 4444
					cel: 0
					cycleSpeed: 1
					posn: (+ (minotaur x:) 22) (+ (minotaur y:) 1)
					setCycle: End self
				)
				(UnLoad 128 4442)
			)
			(10)
			(11
				(gEgo reset: 0 posn: (- (gEgo x:) 28) (- (gEgo y:) 5))
				((gCurRoom obstacles:) dispose:)
				(= ticks 6)
			)
			(12
				(if ((ScriptID 30 0) scarfOnMino:) ; rLab
					(gMessager say: 4 38 11 5 self 440) ; "The minotaur drops from sight amidst the consuming flames. Slowly, his scream fades as well."
				else
					(self cue:)
				)
			)
			(13
				(gGlobalSound number: 443 setLoop: -1 play:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 178 157 208 157 241 151 239 157 319 157 319 0 0 0 0 181 43 181 86 151 75 151 83 148 125 145 128 151 168 147
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 185 296 185 265 173 248 163 319 163 319 186 0 189
							yourself:
						)
				)
				(= local1 7)
				(SetFlag 1)
				(minotaur dispose:)
				(gCurRoom setScript: freeCeleste)
			)
		)
	)
)

(instance hornSwaggled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 1
					posn: (+ (gEgo x:) 10) (gEgo y:)
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
				(minotaur
					view: 4443
					cel: 4
					cycleSpeed: 0
					setCycle: 0
					posn: (+ (minotaur x:) 10) (+ (minotaur y:) 3)
				)
				(UnLoad 128 4442)
				(gGlobalSound number: 402 setLoop: 1 play:)
			)
			(1
				(if (== register 5)
					(gMessager say: 4 5 9 2 self 440) ; "Hand-to-hand combat with a minotaur is, apparently, not a great idea."
				else
					(gMessager say: 1 0 5 2 self 440) ; "!!!Do sound effect: "Urk!""
				)
			)
			(2
				(gEgo setCycle: End self)
				(minotaur setCycle: End self)
			)
			(3)
			(4
				(Print addText: 4 5 9 3 posn: -1 10 modeless: 1 init:) ; "AAAIIEEE!!"
				(gGlobalSound4 number: 442 setLoop: 1 play: self)
				(minotaur view: 443 setLoop: 0 cel: 0)
				(UnLoad 128 4443)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(EgoDead 25) ; "There's something to be said for taking the bull by the horns, Alexander!"
			)
		)
	)
)

(instance egoTwin of Actor
	(properties
		view 900
		signal 16384
		illegalBits 0
	)
)

(instance backup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(egoTwin
					setLoop: 3
					cel: 1
					posn: 111 174
					setScale: Scaler 100 99 190 0
					init:
				)
				(= ticks 8)
			)
			(1
				(egoTwin cel: 3)
				(= ticks 8)
			)
			(2
				(egoTwin setLoop: 7 cel: 1 posn: 109 172)
				(= ticks 8)
			)
			(3
				(egoTwin cel: 0 posn: 116 174)
				(= ticks 8)
			)
			(4
				(egoTwin setLoop: 1 cel: 4 posn: 118 174)
				(= ticks 8)
			)
			(5
				(egoTwin cel: 5 posn: 128 177)
				(= ticks 8)
			)
			(6
				(egoTwin setLoop: 5 cel: 2 posn: 132 176)
				(= ticks 8)
			)
			(7
				(egoTwin cel: 4 posn: 133 176)
				(= ticks 8)
			)
			(8
				(egoTwin cel: 5 posn: 137 174)
				(= ticks 8)
			)
			(9
				(egoTwin cel: 0 posn: 140 173)
				(= ticks 8)
			)
			(10
				(egoTwin setLoop: 2 cel: 2 posn: 144 171)
				(= ticks 8)
			)
			(11
				(gEgo
					setLoop: (egoTwin loop:)
					cel: (egoTwin cel:)
					x: (egoTwin x:)
					y: (egoTwin y:)
					show:
				)
				(egoTwin dispose:)
				(self dispose:)
			)
		)
	)
)

(instance freeCeleste of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 118 149 self)
			)
			(1
				(= ticks 4)
			)
			(2
				(myConv
					add: 440 4 38 11 6 ; "(VOICE SHAKY) Have you been harmed, Lady Celeste? Are you all right?"
					add: 440 4 38 11 7 ; "(NEUTRAL, COOL VOICE)No, I am not all right! I assume you do not intend to leave me tied up on this vile monstrosity!"
					add: 440 4 38 11 8 ; "(BLUSHING) Er, of course not. Sorry."
					add: 440 4 38 11 9 ; "Let's see. If you'll give me a moment, I'll have these untied in no time."
					add: 440 4 38 11 10 ; "<sigh> I can't wait that long. Look, I wear a small dagger just inside my belt. It should be enough to cut the rope."
					init: self
				)
			)
			(3
				(gEgo
					view: 441
					normal: 0
					setLoop: 2
					cycleSpeed: 12
					posn: 110 150
					setCycle: End self
				)
			)
			(4
				(gMessager say: 4 38 11 11 self 440) ; "Oh. All right, I...I've got it, Lady Celeste. Here we go."
			)
			(5
				(gGlobalSound4 number: 445 setLoop: -1 play:)
				(gEgo setLoop: 3 setCycle: Fwd)
				(= seconds 5)
			)
			(6
				(gGlobalSound4 stop:)
				(celeste
					view: 4421
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: CT 2 1
				)
				(gEgo
					posn: 119 149
					reset: 1
					get: 8 ; dagger
					setMotion:
						MoveTo
						(- (gEgo x:) 20)
						(+ (gEgo y:) 12)
						self
				)
			)
			(7
				(gEgo setHeading: 45)
				(= seconds 1)
			)
			(8
				(gEgo setHeading: 90)
				(celeste setCycle: End self)
			)
			(9
				(myConv
					add: 440 4 38 11 12 ; "Thank you. You may keep the dagger as a gift for saving my life."
					add: 440 4 38 11 13 ; "That's very generous...."
					add: 440 4 38 11 14 ; "Forget it! Do you mind if we just get out of here now?"
					init: self
				)
			)
			(10
				(celeste
					view: 364
					setLoop: 2
					setCycle: Walk
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					posn: (celeste x:) (+ (celeste y:) 20)
					setMotion: MoveTo 105 154 self
				)
				(UnLoad 128 4421)
			)
			(11
				(celeste setLoop: 0 setMotion: PolyPath 165 165 self)
			)
			(12
				(celeste setMotion: PolyPath 255 160 self)
			)
			(13
				(gGlobalSound fade: 0 6 6)
				(celeste setMotion: PolyPath 340 160 self)
				(gEgo setMotion: PolyPath 300 160 self)
			)
			(14)
			(15
				(NextAct)
				(gEgo put: 41 440) ; scarf
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gCurRoom newRoom: 340)
			)
		)
	)
)

