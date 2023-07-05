;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 822)
(include sci.sh)
(use Main)
(use KQ6Print)
(use n913)
(use RandCycle)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	boyGhostScript 0
	boyGhost 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(if ((ScriptID 820 4) cycler:) ; flame
		((ScriptID 820 4) setCycle: 0 stopUpd:) ; flame
		((ScriptID 820 5) setCycle: 0 stopUpd:) ; wallReflection
	)
)

(procedure (localproc_1)
	(if (not ((ScriptID 820 4) cycler:)) ; flame
		((ScriptID 820 4) startUpd: setCycle: Fwd) ; flame
		((ScriptID 820 5) startUpd: setCycle: RandCycle) ; wallReflection
	)
)

(instance boyGhostScript of Script
	(properties)

	(method (dispose)
		(gGame handsOn:)
		(super dispose:)
		(boyGhost delete:)
		(DisposeScript 822)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 763)
				(= cycles 5)
			)
			(1
				(gGame handsOff:)
				(boyGhost
					view: 763
					setLoop: 0
					cel: 7
					x: 260
					y: 118
					cycleSpeed: 10
					show:
					setCycle: End self
				)
			)
			(2
				(boyGhost setLoop: 1 cel: 7 posn: 258 117)
				(self setScript: cryBaby self)
			)
			(3
				(if (gEgo has: 17) ; handkerchief
					(gGame handsOn:)
				else
					(= state 5)
					(= cycles 1)
				)
			)
			(4
				(gGame handsOff:)
				(gMessager say: 6 2 16 1 self) ; "What's the matter, little boy?"
			)
			(5
				(localproc_1)
				(cryBaby
					next: (showNonHanky register: 1 caller: self yourself:)
				)
			)
			(6
				(if (or local0 (gEgo has: 17)) ; handkerchief
					(localproc_0)
					(= state 7)
					(if local0
						(= cycles 3)
					else
						(gGame handsOn:)
					)
				else
					(self setScript: noHanky self)
				)
			)
			(7
				(gCurRoom setScript: (ScriptID 820 1)) ; noWayOut
			)
			(8
				(gGame handsOff:)
				((ScriptID 80 0) setFlag: #rFlag1 32768) ; rgCastle
				(gMessager say: 6 50 0 1 self) ; "You must be the son of the spirit I met in the Realm of the Dead. She gave me this handkerchief, and asked me to tell you that she's waiting for you there."
			)
			(9
				(localproc_1)
				(if (== script cryBaby)
					(cryBaby next: (showNonHanky caller: self yourself:))
				else
					(= cycles 1)
				)
			)
			(10
				(gEgo
					normal: 0
					setScale: 0
					view: 763
					setLoop: 7
					cel: 0
					setCycle: End self
				)
			)
			(11
				(boyGhost setCycle: End self)
			)
			(12
				(boyGhost setLoop: 3 cel: 0 posn: 229 70 setCycle: Fwd)
				(= seconds 5)
			)
			(13
				(localproc_0)
				(= cycles 4)
			)
			(14
				((ScriptID 820 2) ; roomConv
					add: -1 6 50 0 2 ; "It's Mama's! It even smells like her! I can feel her now! I know where to go!"
					add: -1 6 50 0 3 ; "Wait! Before you go, is there anything you can tell me about the castle?"
					add: -1 6 50 0 4 ; "I like to play in secret places. In the basement, behind the man of steel, is a door. Nobody except me knows it's there anymore."
					init: self
				)
			)
			(15
				(localproc_1)
				(boyGhost setCycle: Beg self)
			)
			(16
				(boyGhost setLoop: 4 cel: 0 posn: 155 88 setCycle: CT 10 1 self)
			)
			(17
				(gEgo reset: 0)
				(boyGhost setCycle: End self)
			)
			(18
				(boyGhost setLoop: 5 cel: 0 posn: 229 88 setCycle: End self)
			)
			(19
				(boyGhost hide:)
				(= seconds 2)
			)
			(20
				(boyGhost
					setLoop: 6
					setPri: (- (gEgo priority:) 1)
					cel: 0
					posn: 85 151
					show:
					setCycle: End self
				)
			)
			(21
				(gMessager say: 6 50 0 5 self) ; "Farewell!"
			)
			(22
				(gGlobalSound fadeTo: 824 -1)
				(boyGhost setCycle: 0 setMotion: 0 dispose:)
			)
		)
	)
)

(instance showNonHanky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_1)
				(if (and (== (boyGhost loop:) 1) (boyGhost cel:))
					(boyGhost setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(boyGhost setLoop: 2 cel: 0 posn: 241 96 setCycle: CT 4 1 self)
			)
			(2
				(if register
					(localproc_0)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(3
				(if register
					((ScriptID 820 2) ; roomConv
						add: -1 6 2 16 2 ; "I'm lost! I can't find my mother!"
						add: -1 6 2 16 3 ; "I don't know why she would just leave me here! I've been alone ever so long!"
						init: self
					)
				else
					(= ticks 1)
				)
			)
			(4
				(if register
					(localproc_1)
				)
				(if local0
					(self dispose:)
				else
					(= seconds 3)
				)
			)
			(5
				(boyGhost setCycle: CT 0 -1 self)
			)
			(6
				(boyGhost setLoop: 1 cel: 0 posn: 258 117)
				(= local1 0)
				(if (not register)
					(gGame handsOn:)
					(client setScript: cryBaby)
				else
					(= register 0)
					(client setScript: cryBaby 0 1)
				)
			)
		)
	)
)

(instance cryBaby of Script
	(properties)

	(method (init)
		(= local2 30)
		(super init: &rest)
	)

	(method (doit)
		(= local3 (GetTime 1)) ; SysTime12
		(if (and (not local1) (!= local4 local3) (== gCurRoomNum gNewRoomNum))
			(= local4 local3)
			(if (< local2 30)
				(++ local2)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(if (not next)
			(switch (= state newState)
				(0
					(boyGhost view: 763 setLoop: 1 x: 258 y: 117)
					(if (boyGhost cel:)
						(boyGhost setCycle: Beg self)
					else
						(= cycles 1)
					)
				)
				(1
					(cond
						((== register -32768)
							(gMessager say: 6 0 0 2 self oneOnly: 0) ; "Mother! Mother come back for me!"
						)
						(register
							(gMessager say: 6 2 16 4 self) ; "Mother? Mother, where are you?"
						)
						((not local1)
							(gMessager say: 1 0 4 0 self) ; "Mother? Mother, where ARE you?"
						)
						(else
							(= ticks 1)
						)
					)
					(= register 0)
				)
				(2
					(localproc_1)
					(if (and (not local1) (== local2 30))
						(= local2 0)
					)
					(if caller
						(caller cue:)
						(= caller 0)
					)
					(boyGhost setCycle: End self)
				)
				(3
					(boyGhost setCycle: CT 2 -1 self)
				)
				(4
					(if (and (not local1) (== local2 30))
						(= state -1)
						(= cycles 1)
					else
						(= state 1)
						(= cycles (Random 1 15))
					)
				)
			)
		else
			(self dispose:)
		)
	)
)

(instance noHanky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KQ6Print posn: -1 10 say: 0 1 0 5 1 init: self) ; "MOTHER! MOTHER! WHERE ARE YOU?"
			)
			(1
				(self setScript: justCryToMama self 2)
			)
			(2
				(localproc_0)
				(= cycles 2)
			)
			(3
				((ScriptID 820 2) ; roomConv
					add: -1 1 0 5 3 -1 10 ; "Psst! Little boy! Be quiet!"
					add: -1 1 0 5 4 -1 10 ; "WAA! MOTHER, WAA!"
					init: self
				)
			)
			(4
				(localproc_1)
				(self setScript: justCryToMama self 5)
			)
			(5
				(Face gEgo (ScriptID 820 3) self) ; dungeonDoor
			)
			(6
				(localproc_0)
				(= cycles 4)
			)
			(7
				(gMessager say: 1 0 5 6 self) ; "I tell you, I heard somethin'. I'm checking it out."
			)
			(8
				(gMessager say: 1 0 5 7 self) ; "You and your ghosts! There's nothin' in there, I say!"
			)
			(9
				(localproc_1)
				(boyGhost setLoop: 0 cel: 7 x: 260 y: 118 setCycle: Beg self)
			)
			(10
				(if (<= (gEgo x:) ((ScriptID 820 3) approachX:)) ; dungeonDoor
					(gEgo
						setMotion:
							PolyPath
							((ScriptID 820 3) approachX:) ; dungeonDoor
							((ScriptID 820 3) approachY:) ; dungeonDoor
							self
					)
				else
					(++ state)
					(= cycles 1)
				)
			)
			(11
				(Face gEgo (ScriptID 820 3) self) ; dungeonDoor
			)
			(12
				(gEgo setPri: 9)
				(gGlobalSound4 number: 821 loop: 1 play:)
				((ScriptID 820 3) setPri: 10 setCycle: End self) ; dungeonDoor
			)
			(13
				(localproc_0)
				((ScriptID 820 3) stopUpd:) ; dungeonDoor
				(= cycles 4)
			)
			(14
				(gMessager say: 1 0 5 8 self) ; "Um...hi."
			)
			(15
				(gGlobalSound4 stop:)
				((ScriptID 820 2) ; roomConv
					add: -1 1 0 5 9 ; "I don't believe this! It's an intruder, and he's already put himself in the dungeon!"
					add: -1 1 0 5 10 ; "Bones! Some humans can be really dumb! Well, shut the door then. Let's lock him in and go tell the vizier."
					add: -1 1 0 5 11 ; "Right. <titter>. Thanks for savin' us some work, human!"
					add: -1 1 0 5 12 ; "Let's post extra guards, though. That wailin' made me nervous."
					add: -1 1 0 5 13 ; "Right. We'll get Scratch to guard the hall and watch the door. HE's not afraid of no ghosts!"
					init: self
				)
			)
			(16
				(localproc_1)
				((ScriptID 820 3) setCycle: Beg self) ; dungeonDoor
				(gGlobalSound4 number: 822 loop: 1 play:)
			)
			(17
				(gGlobalSound4 stop:)
				(self dispose:)
			)
		)
	)
)

(instance justCryToMama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boyGhost view: 763 setLoop: 1 x: 258 y: 117)
				(if (boyGhost cel:)
					(boyGhost setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(KQ6Print posn: -1 10 say: 0 1 0 5 register init: self)
			)
			(2
				(boyGhost setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance boyGhost of Actor
	(properties
		x 260
		y 118
		noun 6
		approachX 98
		approachY 149
		view 763
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self hide: setScript: boyGhostScript approachVerbs: 50) ; handkerchief
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (== (boyGhostScript state:) 3)
					(= local1 1)
					(boyGhostScript cue:)
				else
					(localproc_0)
					(gMessager say: noun theVerb 17) ; "Is there anything I can do?"
					(localproc_1)
				)
			)
			(50 ; handkerchief
				(localproc_0)
				(= local0 1)
				(gEgo put: 17 820) ; handkerchief
				(gGame givePoints: 3)
				(= local1 1)
				(if (== (boyGhostScript state:) 3)
					(boyGhostScript cue:)
				else
					(boyGhostScript changeState: 8)
				)
			)
			(else
				(if (== (gKq6ApproachCode doit: theVerb) -32768)
					(localproc_0)
					(gMessager say: noun 0 0 1) ; "Would this comfort you, sad spirit?"
					(= local1 1)
					(if (!= (script script:) showNonHanky)
						((script script:) register: -32768 next: showNonHanky)
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

