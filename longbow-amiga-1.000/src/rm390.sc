;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use n013)
(use Interface)
(use verseScript)
(use RTEyeCycle)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	[local0 4] = [1390 217 2 0]
	[local4 8] = [1390 0 2 1 2 1 2 0]
	[local12 4] = [1390 5 2 0]
	[local16 9] = [1390 6 2 1 2 1 2 2 0]
	[local25 4] = [1390 12 2 0]
	[local29 4] = [1390 13 2 0]
	[local33 4] = [1390 14 2 0]
	[local37 4] = [1390 15 2 0]
	[local41 4] = [1390 16 2 0]
	[local45 4] = [1390 17 2 0]
	[local49 4] = [1390 18 2 0]
	[local53 5] = [1390 19 1 2 0]
	[local58 5] = [1390 21 1 2 0]
	[local63 4] = [1390 23 1 0]
	[local67 4] = [1390 24 1 0]
	[local71 4] = [1390 25 2 0]
	[local75 8] = [1390 26 1 2 1 2 2 0]
	[local83 6] = [1390 31 1 2 2 0]
	[local89 5] = [1390 34 1 2 0]
	[local94 5] = [1390 36 1 2 0]
	[local99 7] = [1390 38 1 2 2 2 0]
	[local106 4] = [1390 42 2 0]
	[local110 5] = [1390 43 1 2 0]
	[local115 5] = [1390 45 1 2 0]
	[local120 6] = [1390 47 1 2 2 0]
	[local126 4] = [1390 50 2 0]
	[local130 5] = [1390 51 1 2 0]
	[local135 5] = [1390 53 1 2 0]
	[local140 7] = [1390 55 2 1 2 2 0]
	[local147 9] = [1390 59 1 2 1 2 1 2 0]
	[local156 5] = [1390 65 2 1 0]
	[local161 5] = [1390 67 1 2 0]
	[local166 11] = [1390 69 1 2 1 2 1 2 2 2 0]
	[local177 9] = [1390 77 1 1 2 1 2 2 0]
	[local186 4] = [1390 83 2 0]
	[local190 7] = [1390 84 1 2 1 2 0]
	[local197 7] = [1390 88 1 2 1 2 0]
	[local204 4] = [1390 92 2 0]
	[local208 11] = [1390 93 1 1 1 2 1 2 2 2 0]
	[local219 5] = [1390 101 2 2 0]
	[local224 5] = [1390 103 1 2 0]
	[local229 5] = [1390 105 1 2 0]
	[local234 3] = [1390 107 0]
	[local237 5] = [1390 108 2 1 0]
	[local242 4] = [1390 110 1 0]
	[local246 12] = [1390 111 1 2 1 2 2 0 1390 116 1 0]
	[local258 5] = [1390 117 1 2 0]
	[local263 7] = [1390 119 1 1 2 2 0]
	[local270 4] = [1390 123 2 0]
	[local274 5] = [1390 124 2 2 0]
	[local279 5] = [1390 126 2 2 0]
	[local284 4] = [1390 128 2 0]
	[local288 10] = [1390 129 2 1 2 1 2 1 2 0]
	[local298 4] = [1390 136 2 0]
	[local302 5] = [1390 137 2 2 0]
	[local307 6] = [1390 139 2 2 1 0]
	[local313 4] = [1390 142 2 0]
	[local317 8] = [1390 143 2 1 2 1 2 0]
	[local325 4] = [1390 148 1 0]
	[local329 4] = [1390 149 2 0]
	[local333 6] = [1390 150 1 2 2 0]
	[local339 4] = [1390 153 2 0]
	[local343 4] = [1390 154 2 0]
	[local347 7] = [1390 155 2 1 2 2 0]
	[local354 4] = [1390 159 2 0]
	[local358 5] = [1390 160 2 2 0]
	[local363 9] = [1390 162 1 2 1 2 2 2 0]
	[local372 5] = [1390 168 2 2 0]
	[local377 4] = [1390 170 2 0]
	[local381 5] = [1390 171 1 2 0]
	[local386 7] = [1390 173 2 1 2 2 0]
	[local393 5] = [1390 177 2 2 0]
	[local398 7] = [1390 179 2 1 2 2 0]
	[local405 4] = [1390 183 2 0]
	[local409 4] = [1390 184 2 0]
	[local413 4] = [1390 185 2 0]
	[local417 6] = [1390 186 1 2 2 0]
	[local423 4] = [1390 189 2 0]
	[local427 4] = [1390 190 2 0]
	[local431 5] = [1390 191 1 2 0]
	[local436 4] = [1390 193 2 0]
	[local440 6] = [1390 194 2 2 2 0]
	[local446 4] = [1390 197 2 0]
	[local450 4] = [1390 198 2 0]
	[local454 5] = [1390 199 1 2 0]
	[local459 4] = [1390 201 2 0]
	[local463 4] = [1390 202 2 0]
	[local467 4] = [1390 203 2 0]
	[local471 7] = [1390 204 1 2 2 2 0]
	[local478 5] = [1390 208 2 2 0]
	[local483 4] = [1390 210 2 0]
	[local487 5] = [1390 211 1 2 0]
	[local492 6] = [1390 213 2 1 2 0]
	[local498 9] = [-1 {Hubert} 19 0 0 0 0 0 0]
)

(procedure (localproc_0 param1 param2 param3 param4)
	(if (or (< argc 4) param4)
		(Print param1 param2 #title {***STUB:})
	)
	(if (and (>= argc 3) param3)
		(param3 cue:)
	)
)

(procedure (localproc_1 param1)
	(Converse 2 param1 999 1 @local498 0 &rest)
)

(instance MoveBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gEgo)
					(NormalEgo)
				)
				(client setHeading: 0 self)
			)
			(1
				(client
					setCycle: Rev
					setLoop:
					setMotion: MoveFwd (- register) self
				)
			)
			(2
				(if (== client gEgo)
					(NormalEgo)
				else
					(client setCycle: Walk setLoop: -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance rm390 of Rm
	(properties
		lookStr {I see no guards upon the battlements.__The Sheriff is lax.}
		picture 390
		style 100
		horizon 175
		south 260
	)

	(method (newRoom newRoomNumber)
		(switch newRoomNumber
			(570
				(SetFlag 81)
				(if (!= gDisguiseNum 5) ; abbey monk
					(Print 390 0) ; "***error: wrong disguise for going to dungeons, caught teleporting."
					(return)
				)
			)
		)
		(gRgnMusic fade: 0 20 12 1)
		(HandsOn)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(Load rsTEXT 1390)
		(switch gDisguiseNum
			(2 ; jewler (no rouge)
				(SetFlag 80)
			)
			(3 ; jewler (rouge)
				(SetFlag 63)
			)
		)
		(super init: &rest)
		(HandsOff)
		(AddToFeatures castle arch)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 113 189 0 189 0 0 319 0 319 189 206 189 179 179 148 179 115 189
					yourself:
				)
		)
		(Hubert init: stopUpd: approachVerbs: 3 4 5) ; Do, Inventory, Talk
		(gEgo posn: (+ (Hubert x:) 30) 185 init:)
		(NormalEgo (if (OneOf gPrevRoomNum 400 570) 2 else 3))
		(gRgnMusic number: 390 loop: -1 play:)
		(self setScript: roomInit)
	)
)

(instance roomInit of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(and (== gDisguiseNum 3) (IsFlag 80)) ; jewler (rouge)
						(and (== gDisguiseNum 2) (IsFlag 63)) ; jewler (no rouge)
					)
					(client setScript: BeardChanged)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance GilesAndRogerAppear of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Giles
					init:
					setPri: 9
					illegalBits: 0
					ignoreHorizon:
					setCycle: Walk
					setMotion: MoveTo 158 (Giles y:) self
				)
			)
			(1
				(Roger
					init:
					illegalBits: 0
					ignoreHorizon:
					setCycle: Walk
					setMotion: MoveTo 168 (Roger y:) self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance BeardChanged of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo Hubert self)
			)
			(1
				(localproc_1 (if (== gDisguiseNum 2) @local16 else @local4) self) ; jewler (no rouge)
			)
			(2
				(self setScript: GilesAndRogerAppear self register notKilled)
			)
			(3
				(localproc_1 (if (== gDisguiseNum 2) @local25 else @local12) self) ; jewler (no rouge)
			)
			(4
				(= gDeathNum (if (== gDisguiseNum 2) 39 else 7)) ; jewler (no rouge)
				(gCurRoom newRoom: 170) ; robinDeath
				(self dispose:)
			)
		)
	)
)

(instance Giles of Actor
	(properties
		x 120
		y 170
		view 755
	)
)

(instance Roger of Actor
	(properties
		x 200
		y 170
		view 755
	)
)

(instance castle of Feature
	(properties
		y 4
		description {*** the castle}
		lookStr {The castle is massively built in the Norman fashion.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 0 68 12 66 15 20 51 5 88 5 129 22 185 22 222 5 273 4 304 20 304 70 318 71 319 189 0 189
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance arch of Feature
	(properties
		y 49
		description {*** the arch}
		lookStr {I can glimpse one of the courtyards and inner buildings through this main gate.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 115 50 206 49 207 176 114 177
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance stopTresspasser of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(gEgo setMotion: 0)
				(if (== gDisguiseNum 1) ; beggar
					(self setScript: KickBeggar self)
				else
					(self cue:)
				)
			)
			(1
				(= notKilled 1)
				(localproc_1 (if (== gDisguiseNum 1) @local0 else @local37) self) ; beggar
			)
			(2
				(gEgo setScript: MoveBack self 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance Hubert of Actor
	(properties
		x 147
		y 175
		heading 180
		description {*** Hubert}
		approachX 184
		approachY 185
		lookStr {This Sheriff's man has the look of an experienced fighter.__I must be cautious.}
		view 392
	)

	(method (doit &tmp temp0 temp1)
		(if
			(and
				(not script)
				(= temp0 (gEgo mover:))
				(>= (+ y 6) (gEgo y:) (temp0 y:))
			)
			(self setScript: stopTresspasser)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Face gEgo self)
				(self
					setScript:
						(switch gDisguiseNum
							(1 BeggarTouchesHubert) ; beggar
							(else TryToTouchHubert)
						)
				)
			)
			(5 ; Talk
				(Face gEgo self)
				(switch gDisguiseNum
					(1 ; beggar
						(self setScript: BeggarTalkToHubert)
					)
					(4 ; yeoman
						(self setScript: PuckTalkToHubert)
					)
					(6 ; fens monk
						(self setScript: FensTalkToHubert)
					)
					(5 ; abbey monk
						(self setScript: AbbeyTalkToHubert)
					)
					(2 ; jewler (no rouge)
						(self setScript: JewelerTalkToHubert)
					)
					(3 ; jewler (rouge)
						(self setScript: JewelerTalkToHubert)
					)
					(else
						(Say 390 1) ; "***error, wrong disguise"
					)
				)
			)
			(10 ; Longbow
				(if (== gDisguiseNum 4) ; yeoman
					(Say [local234 0] [local234 1])
				)
			)
			(11 ; iconMap
				(gCurRoom newRoom: 260)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(switch gDisguiseNum
							(1 ; beggar
								(self setScript: BeggarBribesHubert)
							)
							(5 ; abbey monk
								(self setScript: AbbeyBribesHubert)
							)
							(6 ; fens monk
								(self setScript: FensBribesHubert)
							)
							(4 ; yeoman
								(self setScript: PuckBribesHubert)
							)
							(2 ; jewler (no rouge)
								(self setScript: JewelerBribesHubert)
							)
							(3 ; jewler (rouge)
								(self setScript: JewelerBribesHubert)
							)
						)
					)
					(2 ; halfHeart
						(cond
							((OneOf gDisguiseNum 5 6) ; abbey monk, fens monk
								(localproc_1 @local358) ; "You put that away, Brother. I'd be hard pressed to explain how I came by such a rich jewel."
							)
							((OneOf gDisguiseNum 2 3) ; jewler (no rouge), jewler (rouge)
								(self setScript: JewelerGivesEmeraldToHubert)
							)
						)
					)
					(3 ; slipper
						(self setScript: GiveSlipperToHubert)
					)
					(15 ; comb
						(if (and (== gDisguiseNum 1) (== gDay 3)) ; beggar
							(self setScript: GiveCombToHubert)
						)
					)
					(11 ; cask
						(if (IsFlag 31)
							(localproc_1 @local405) ; "Come back with that when I'm off duty and I'll be happy to help you empty it."
						else
							(localproc_1 @local409) ; "There's nothing more useless than an empty cask of ale."
						)
					)
					(14 ; amethyst
						(self setScript: GiveAmethystToHubert)
					)
					(12 ; puzzleBox
						(localproc_1 @local436) ; "That's of no interest to me."
					)
					(13 ; robes
						(localproc_1 @local459) ; "I don't want any of your monk trappings."
					)
					(5 ; pipe
						(localproc_1 @local463) ; "I've a penny whistle that's better than that."
					)
					(6 ; gems
						(self setScript: GiveAmethystToHubert)
					)
					(7 ; jewels
						(self setScript: GiveJewelsToHubert)
					)
					(8 ; rouge
						(localproc_1 @local492) ; "What's this for?"
					)
					(else
						(cond
							((OneOf invItem 10 18) ; fireRing, waterRing
								(self setScript: GiveRingToHubert)
							)
							((OneOf invItem 16 17) ; fulkScroll, handScroll
								(localproc_1 @local467) ; "What do you take me for, a clerk?"
							)
							(else
								(super doVerb: theVerb &rest)
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance GiveAmethystToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(cond
					((OneOf gDisguiseNum 5 6) ; abbey monk, fens monk
						(localproc_1 @local413 self) ; "What good's that to me? It won't buy me a mug of ale."
					)
					((OneOf gDisguiseNum 2 3) ; jewler (no rouge), jewler (rouge)
						(cond
							((not (IsFlag 145))
								(if (== register 1)
									(localproc_1 @local417 self) ; "I thought I might interest the Sheriff's wife in purchasing this stone. What think you? Is she in?"
								else
									(localproc_1 @local423 self) ; "I couldn't disturb the Sheriff's Lady Wife if that is all you have to show."
								)
							)
							((== register 1)
								(localproc_1 @local427 self) ; "There's no use showing me anything. I've orders never to let you set foot inside again."
							)
							(else
								(localproc_1 @local431 self) ; "Is there no way I may see the Sheriff again?"
							)
						)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance GiveJewelsToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					((not (OneOf gDisguiseNum 2 3)) ; jewler (no rouge), jewler (rouge)
						(self dispose:)
					)
					((not (IsFlag 145))
						(= register -1)
						(localproc_1 @local471 self) ; "Behold these splendiferous works of the jeweler's art. Are they not magnificent?"
					)
					((== register 1)
						(localproc_1 @local483 self) ; "There's no use showing me anything. I've orders never to let you set foot inside again."
					)
					(else
						(localproc_1 @local487 self) ; "Is there no way I may see the Sheriff again?"
					)
				)
			)
			(1
				(if (== register -1)
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 @local478 self) ; "Show this here gent to the Sheriff."
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
			)
			(5
				(HandsOn)
				(SetScore 10)
				(gCurRoom newRoom: 400)
				(self dispose:)
			)
		)
	)
)

(instance GiveRingToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					(
						(or
							(OneOf gDisguiseNum 6 5) ; fens monk, abbey monk
							(and (OneOf gDisguiseNum 2 3) (not (IsFlag 145))) ; jewler (no rouge), jewler (rouge)
						)
						(= register -1)
						(localproc_1 @local440 self) ; "Hmmm...this is a most unusual and precious ring."
					)
					((and (OneOf gDisguiseNum 2 3) (IsFlag 145)) ; jewler (no rouge), jewler (rouge)
						(if (== register 1)
							(localproc_1 @local450 self) ; "There's no use showing me anything. I've orders never to let you set foot inside again."
						else
							(localproc_1 @local454 self) ; "Is there no way I may see the Sheriff again?"
						)
					)
				)
			)
			(1
				(if (== register -1)
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(localproc_1 @local446 self) ; "Come along. You'll explain to the Sheriff how you came by this."
			)
			(3
				(= gDeathNum 8)
				(gCurRoom newRoom: 170) ; robinDeath
				(self dispose:)
			)
		)
	)
)

(instance JewelerGivesEmeraldToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					((not (IsFlag 145))
						(localproc_1 @local363 self) ; "What think you of this stone?"
					)
					((== register 1)
						(localproc_1 @local377 self) ; "There's no use showing me anything. I've orders never to let you set foot inside again."
					)
					(else
						(localproc_1 @local381 self) ; "Is there no way I may see the Sheriff again?"
					)
				)
			)
			(1
				(if (not (IsFlag 145))
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 @local372 self) ; "Show this here gent to the Sheriff."
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
			)
			(5
				(SetScore 10)
				(gCurRoom newRoom: 400)
				(self dispose:)
			)
		)
	)
)

(instance GiveCombToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 @local398 self) ; "Here now, this comb is of silver. How'd you come by this?"
			)
			(1
				(= gDeathNum 6)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance GiveSlipperToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(if (and (== gDisguiseNum 1) (== gDay 3)) ; beggar
					(if (== register 1)
						(localproc_1 @local386 self) ; "That's a fancy slipper. How'd a beggar like you come by that?"
					else
						(localproc_1 @local393 self) ; "If I thought you'd stolen that, I'd arrest you and you'd dangle from a rope."
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance AbbeyBribesHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					(
						(or
							(and (== gDay 5) (IsFlag 25))
							(and (== gDay 6) (not (IsFlag 25)))
						)
						(cond
							((IsFlag 81)
								(localproc_1 @local274 self) ; "It's no use giving me more money, Brother. I daren't let you return to the dungeons."
							)
							((not (gMoney doit:))
								(-- register)
								(self cue:)
							)
							((< (gMoney taken:) 3)
								(gMoney put:)
								(localproc_1 @local258 self) ; "I wonder if this gift would soften your heart, for I dearly desire to shrive the souls of those poor outlaws in your dungeon."
							)
							(else
								(= register -1)
								(localproc_1 @local263 self) ; "My son, I cannot bear the thought that any man, even those villainous outlaws the Sheriff plans to hang, should go to his death unshriven."
							)
						)
					)
					(
						(or
							(and (== gDay 6) (IsFlag 25))
							(OneOf gDay 7 8)
						)
						(localproc_1 @local279 self) ; "Keep your money, Brother."
					)
					((== gDay 9)
						(localproc_1 @local284 self) ; "Whatever you're trying to bribe me for, it won't do you any good, so keep your money."
					)
					(else
						(localproc_0 390 2 self) ; "error: wrong day for AbbeyBribesHubert"
					)
				)
			)
			(1
				(if (== register -1)
					(SetScore 50)
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 @local270 self) ; "Escort this monk to the dungeon and let him speak to the prisoners. But make it quick."
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
			)
			(5
				(gCurRoom newRoom: 570)
			)
		)
	)
)

(instance FensBribesHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					((and (== gDay 5) (not (IsFlag 25)))
						(cond
							((IsFlag 144)
								(localproc_1 @local302 self) ; "I'll be glad to take your money, but it won't get you through this gate again."
							)
							((not (gMoney doit:))
								(-- register)
								(self cue:)
							)
							(else
								(= register -1)
								(localproc_1 @local288 self) ; "What's this for?"
							)
						)
					)
					(
						(or
							(and (== gDay 6) (not (IsFlag 25)))
							(and (== gDay 6) (IsFlag 25))
							(OneOf gDay 7 8 9)
						)
						(if (== register 1)
							(localproc_1 @local307 self) ; "You can't see the Sheriff, so no amount of money can help if that's your need."
						else
							(localproc_1 @local313 self) ; "Bugger off, monk."
						)
					)
					(else
						(localproc_0 390 3 self) ; "error: wrong day for FensBribesHubert"
					)
				)
			)
			(1
				(if (== register -1)
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 @local298 self) ; "Escort this monk to the Sheriff."
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
			)
			(5
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance PuckBribesHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(switch gDay
					(8
						(cond
							((> register 1)
								(Say [local325 0] [local325 1] self)
							)
							((not (gMoney doit:))
								(-- register)
								(self cue:)
							)
							(else
								(localproc_1 @local317 self) ; "Eh, what's this for?"
							)
						)
					)
					(9
						(cond
							((IsFlag 146)
								(localproc_1 @local343 self) ; "Give it up, mate. No amount of money will get you into the Sheriff's room again."
							)
							((not (gMoney doit:))
								(-- register)
								(self cue:)
							)
							((< (gMoney taken:) 3)
								(gMoney put:)
								(localproc_1 @local329 self) ; "You'll have to do better than that if you want to get past me."
							)
							(else
								(= register -1)
								(localproc_1 @local333 self) ; "About that audience with the Sheriff- -?"
							)
						)
					)
					(else
						(localproc_0 390 4 self) ; "error: wrong day for PuckBribesHubert"
					)
				)
			)
			(1
				(if (== register -1)
					(SetScore 50)
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 @local339 self) ; "Escort this man to the Sheriff."
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
			)
			(5
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance JewelerBribesHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((not (gMoney doit:))
						(self cue:)
					)
					((== gDay 9)
						(if (not (IsFlag 145))
							(localproc_1 @local347 self) ; "What's this for?"
						else
							(gMoney put:)
							(localproc_1 @local354 self) ; "Doesn't matter what bribe you offer, the Sheriff's given strict orders to keep you out."
						)
					)
					(else
						(gMoney put:)
						(localproc_0 390 5 self) ; "error: wrong day for JewelerBribesHubert"
					)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance BeggarBribesHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(cond
					((> register 1)
						(Say 1390 116 self) ; "I'm playing the part of a beggar, not a fool."
					)
					((not (gMoney doit:))
						(self dispose:)
					)
					(else
						(HandsOff)
						(if (== register 1)
							(localproc_1 @local237 self) ; "What's this? You're giving ME money?"
						)
					)
				)
			)
			(1
				(if (> register 1)
					(HandsOn)
					(gMoney put:)
					(self dispose:)
				else
					(self setScript: KickBeggar self)
				)
			)
			(2
				(localproc_1 @local242 self) ; "Yeow!"
			)
			(3
				(localproc_1 @local246 self) ; "Curse ye! Wot'd ye do that for?"
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance BeggarTouchesHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: KickBeggar self)
			)
			(1
				(localproc_1 @local29 self) ; "That'll teach you to lay your filthy hands on me."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance KickBeggar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(Hubert loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gEgo view: 392 loop: 2 cel: 0 setCycle: End self)
				(if (>= -4 (- (Hubert x:) (gEgo x:)))
					(Hubert setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (>= -4 (- (Hubert x:) (gEgo x:)))
					(Hubert setCycle: Beg self)
				else
					(= cycles 1)
				)
				(Hubert loop: 0)
			)
			(3
				(Hubert stopUpd:)
				(localproc_1 @local67 self) ; "Youw!"
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo view: 392 loop: 2 setCycle: Beg self)
			)
			(6
				(NormalEgo 3)
				(gEgo setScript: MoveBack self 2)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance BeggarTalkToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(Face gEgo Hubert self)
			)
			(1
				(gEgo stopUpd:)
				(Hubert stopUpd:)
				(if (== register 1)
					(localproc_1 @local53 self) ; "Charity, good sir. Charity for the wretched and afflicted."
				else
					(localproc_1 @local63 self) ; "'ave pity--"
				)
			)
			(2
				(self setScript: KickBeggar self)
			)
			(3
				(if (== register 1)
					(localproc_1 @local58 self) ; "God curse ye for such cruelty!"
				else
					(localproc_1 @local71 self) ; "If you keep bothering me, you'll become right familiar with my boot."
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance TryToTouchHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(switch gDisguiseNum
					(4 ; yeoman
						(if (== register 1)
							(localproc_1 @local41 self) ; "Keep back, yeoman, or you might feel the wrong end of my spear tickling your ribs."
						else
							(localproc_1 @local45 self) ; "If you've no business here, move along."
						)
					)
					(5 ; abbey monk
						(localproc_1 @local33 self) ; "Stop where you are, Brother. I don't want to hurt you, but you can't enter without permission."
					)
					(6 ; fens monk
						(localproc_1 @local37 self) ; "Stand fast! You cannot enter without permission."
					)
					(else
						(if (OneOf gDisguiseNum 2 3) ; jewler (no rouge), jewler (rouge)
							(localproc_1 @local49 self) ; "I cannot admit you unless you have business within."
						)
					)
				)
			)
			(1
				(NormalEgo 3)
				(gEgo setScript: MoveBack self 2)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance PuckTalkToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(switch gDay
					(8
						(if (and (>= gRoomCount 42) (not (IsFlag 10)))
							(switch register
								(1
									(localproc_1 @local190 self) ; "I beg an audience with your Master, the Sheriff."
								)
								(2
									(localproc_1 @local197 self) ; "I have something else to offer the Sheriff, news that he will much want to hear."
								)
								(else
									(localproc_1 @local204 self) ; "You're growing to annoy me, yeoman. Move along."
								)
							)
						else
							(switch register
								(1
									(localproc_1 @local140 self) ; "State your business."
								)
								(2
									(localproc_1 @local147 self) ; "Sorry to bother you again, but what is the prize for the tournament?"
								)
								(else
									(localproc_1 @local156 self) ; "See here, why don't you quit bothering me and go to the Fair?"
								)
							)
						)
					)
					(9
						(if (IsFlag 10)
							(if (IsFlag 146)
								(localproc_1 @local204 self) ; "You're growing to annoy me, yeoman. Move along."
							else
								(switch register
									(1
										(localproc_1 @local161 self) ; "I wish an audience with the Sheriff."
									)
									(2
										(localproc_1 @local166 self) ; "Were you not at the tournament yesterday?"
									)
									(else
										(localproc_1 @local177 self) ; "My friend, I regret my hasty words to your Master at the tournament. Yet I come to do more than beg his forgiveness."
									)
								)
							)
						else
							(switch register
								(1
									(localproc_1 @local190 self) ; "I beg an audience with your Master, the Sheriff."
								)
								(2
									(localproc_1 @local197 self) ; "I have something else to offer the Sheriff, news that he will much want to hear."
								)
								(else
									(localproc_1 @local204 self) ; "You're growing to annoy me, yeoman. Move along."
								)
							)
						)
					)
					(else
						(localproc_0 390 6 self) ; "error: wrong day for PuckTalkToHubert"
					)
				)
			)
			(1
				(if (and (IsFlag 10) (>= register 3) (not (IsFlag 146)))
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(SetScore 75)
				(localproc_1 @local186 self) ; "Escort this man to the Sheriff."
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
			)
			(5
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance FensTalkToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					((and (== gDay 6) (IsFlag 25))
						(if (== register 1)
							(localproc_1 @local99 self) ; "I was wondering if I might..."
						else
							(localproc_1 @local106 self) ; "Move along, Brother. The Sheriff's in a foul mood."
						)
					)
					((== gDay 8)
						(localproc_1 @local115 self) ; "Is the Sheriff in?"
					)
					((and (== gDay 5) (not (IsFlag 25)))
						(if (and (== register 1) (not (IsFlag 144)))
							(localproc_1 @local120 self) ; "The Prior sent me to question your prisoners."
							(= register -1)
						else
							(localproc_1 @local130 self) ; "If I could see the Sheriff again--"
						)
					)
					(
						(or
							(OneOf gDay 7 9)
							(and (== gDay 6) (not (IsFlag 25)))
						)
						(localproc_1 @local135 self) ; "I wish to see the Sheriff."
					)
					(else
						(localproc_0 390 7 self) ; "error: wrong day for FensTalkToHubert"
					)
				)
			)
			(1
				(if (== register -1)
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 @local126 self) ; "Escort this monk to the Sheriff!"
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
			)
			(5
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance AbbeyTalkToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					(
						(or
							(and (== gDay 5) (IsFlag 25))
							(and (== gDay 6) (not (IsFlag 25)))
						)
						(cond
							((not (IsFlag 81))
								(if (and (== register 1) (not (IsFlag 17)))
									(SetFlag 17)
									(localproc_1 @local75 self) ; "Good sir, please allow me to administer to those poor souls in your dungeon."
								else
									(SetFlag 17)
									(localproc_1 @local83 self) ; "I ask you again to let me shrive those unfortunate souls in your dungeon before they are hung."
								)
							)
							((== register 1)
								(localproc_1 @local89 self) ; "My son, I had so little time with those unfortunate outlaws. May I go and pray over them at greater length?"
							)
							(else
								(localproc_1 @local94 self) ; "My son--"
							)
						)
					)
					((and (== gDay 6) (IsFlag 25))
						(if (== register 1)
							(localproc_1 @local99 self) ; "I was wondering if I might..."
						else
							(localproc_1 @local106 self) ; "Move along, Brother. The Sheriff's in a foul mood."
						)
					)
					((OneOf gDay 7 9)
						(localproc_1 @local110 self) ; "Is the Sheriff in?"
					)
					((== gDay 8)
						(localproc_1 @local115 self) ; "Is the Sheriff in?"
					)
					(else
						(localproc_0 390 8 self) ; "error: wrong day for AbbeyTalkToHubert"
					)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance JewelerTalkToHubert of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ register)
				(cond
					((not (IsFlag 145))
						(localproc_1 @local208 self) ; "Forthright man of military bearing,"
					)
					((== register 1)
						(localproc_1 @local224 self) ; "It would seem I acted unwisely in my first audience. If I could see the Sheriff again--"
					)
					(else
						(localproc_1 @local229 self) ; "Is there no way I may see the Sheriff again?"
					)
				)
			)
			(1
				(if (not (IsFlag 145))
					(self
						setScript: GilesAndRogerAppear self register notKilled
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(Hubert setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 @local219 self) ; "Show this here gent to the Sheriff."
			)
			(4
				(gEgo
					heading: 0
					setMotion: MoveFwd (* 2 (gEgo yStep:)) self
				)
				(SetScore 10)
				(gCurRoom newRoom: 400)
			)
		)
	)
)

