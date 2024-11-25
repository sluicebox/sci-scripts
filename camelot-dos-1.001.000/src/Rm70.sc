;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use MoveForward)
(use n128)
(use bitingRat)
(use trappedByDoors)
(use RatBlink)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm70 0
)

(synonyms
	(galahad man friend knight)
)

(local
	local0
	local1
)

(instance galahadWindow of SysWindow
	(properties
		color 14
		back 4
		title {Galahad}
		brTop 20
		brLeft 150
		brBottom 100
	)
)

(instance leftDoor of Act
	(properties
		y 33
		x 34
		yStep 8
		view 170
		priority 1
		signal 16400
		illegalBits 0
	)
)

(instance bone of View
	(properties
		y 181
		x 280
		view 267
		cel 3
	)
)

(instance fragments of PV
	(properties
		y 178
		x 33
		view 267
		cel 4
		signal 16384
	)
)

(instance bottomBlock of Blk
	(properties
		top 195
		left -10
		bottom 210
		right 330
	)
)

(instance leftBlock of Blk
	(properties
		left -10
		bottom 210
		right -5
	)
)

(instance galahad of Prop
	(properties
		y 161
		x 232
		view 373
		loop 5
		priority 10
		signal 16400
	)
)

(instance galahadHead of Prop
	(properties
		y 161
		x 212
		z 31
		view 373
		loop 3
		priority 10
		signal 16400
	)
)

(instance Rm70 of Rm
	(properties
		picture 70
	)

	(method (init)
		(super init:)
		(= global112 1)
		(if (and (gEgo has: 10) (not (IsFlag 173))) ; lamb | dove
			(PutItem 10) ; lamb | dove
			(= local0 1)
		)
		(self setRegions: 125 174) ; Catacombs, RatBlink
		(gEgo
			posn: 30 154
			loop: 0
			setMotion: MoveForward 35
			observeBlocks: bottomBlock leftBlock
		)
		(galahad init:)
		(galahadHead init:)
		(if (and (not (IsFlag 173)) (not (IsItemAt 5))) ; sleeve | elixir
			(galahad setScript: galahadTwitch)
		)
		(gTObj tWindow: galahadWindow)
		(if (IsFlag 189)
			(bone init: stopUpd:)
		)
		(cond
			((or (gEgo has: 10) local0) ; lamb | dove
				(gEgo get: 10) ; lamb | dove
				(gCurRoom setScript: closeDoor)
			)
			((not (IsFlag 169))
				(gCurRoom setScript: attackingRat)
			)
		)
		(RatBlink
			addEyes: 112 133 9
			addEyes: 187 105 9
			addEyes: 234 102 9
			addEyes: 304 155 9
			addEyes: 39 81 9
		)
		(SetFlag 177)
		(gAddToPics add: fragments)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			((or global80 (IsFlag 172)) 0)
			((& (gEgo onControl:) $0020)
				(if (not (IsItemAt 5)) ; sleeve | elixir
					(SetFlag 173)
				)
				(gEgo setMotion: LeaveRoom 67 1 25)
			)
		)
		(if global172
			(galahadCountdown doit:)
		)
		(if (IsFlag 179)
			(if global124
				(DisposeScript 912)
			)
			(RatBite gotoX1: 91 gotoY1: 149 gotoX2: 13 gotoY2: 143)
			(cond
				((< (gEgo x:) 43)
					(RatBite
						midPointX: 0
						offControlsY: (gEgo y:)
						offControlsX: (+ (gEgo x:) 33)
					)
					((ScriptID 172 0) posn: -45 119 init:) ; bitingRat
				)
				((< (gEgo x:) 74)
					(RatBite midPointX: 66 spread: 0)
					((ScriptID 172 0) y: 125 init:) ; bitingRat
				)
				((< (gEgo x:) 151)
					(RatBite midPointX: 110 optCel: 0)
					((ScriptID 172 0) y: 127 init:) ; bitingRat
				)
				((< (gEgo x:) 215)
					(RatBite
						midPointX: 186
						offControlsX: 171
						offControlsY: 149
						optCel: 2
					)
					((ScriptID 172 0) y: 117 init:) ; bitingRat
				)
				(else
					(RatBite
						midPointX: 308
						offControlsX: 266
						offControlsY: 177
						spread: 10
					)
					((ScriptID 172 0) y: 150 init:) ; bitingRat
				)
			)
		)
	)

	(method (handleEvent event)
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
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said 'look<below,behind/bier,galahad,shield')
						(Print 70 0) ; "There is nothing worth seeing there."
					)
					(
						(or
							(Said 'look[<!*][/room,catacomb]')
							(Said '//room,catacomb')
							(Said 'look<around')
							(Said 'look<at/room,catacomb')
						)
						(if (IsFlag 173)
							(Print 70 1) ; "Galahad's body lies upon the bier in what is now his own tomb as well."
						else
							(Print 70 2) ; "Galahad lies upon a bier within this chamber, surrounded by those long dead."
						)
					)
					(
						(or
							(Said '/galahad')
							(Said '//galahad')
							(OnButton event 193 135 255 161)
						)
						(cond
							((IsFlag 206)
								(Print 70 3) ; "He is in a healing trance"
							)
							((not (IsFlag 173))
								(Print 70 4) ; "He is still alive, but deep in a fevered coma. He has been bitten and could die at any moment."
							)
							((gEgo has: 5) ; sleeve | elixir
								(Print 70 5) ; "Galahad has died because you failed to save him, though you had the means. His death is a black stain upon your soul."
							)
							(else
								(Print 70 6) ; "Galahad is dead. Had you heeded the warnings of Fatima and the heirophant, this may have been averted."
							)
						)
					)
					(
						(or
							(Said '/bier,fur')
							(Said '//bier,fur')
							(OnButton event 192 132 261 160)
						)
						(Print 70 7) ; "The low stone bier is covered by an old lion skin."
					)
					((or (Said '/shield') (Said '//shield'))
						(Print 70 8) ; "Galahad's shield rests where he dropped it at the foot of the bier."
					)
					(
						(or
							(Said '/blade')
							(Said '//blade')
							(OnButton event 262 118 268 158)
						)
						(Print 70 9) ; "It is Galahad's sword."
					)
					((Said '//gift')
						(if (IsItemAt 5) ; sleeve | elixir
							(Print 70 10) ; "I do not know what gift Galahad wanted you to bring to Aphrodite, nor how you would do this. You will have to search for the answer to this riddle yourself."
						else
							(Print 70 11) ; "I do not know what "gift" you mean."
						)
					)
					(
						(or
							(and (not (gEgo has: 9)) (Said '/bone')) ; herbs | bone
							(Said '//bone')
							(and
								(gCast contains: bone)
								(MouseClaimed bone event)
							)
						)
						(Print 70 12) ; "There are a great many bones around, as might be expected in catacombs."
					)
					(
						(or
							(Said '[<at,!*]/body')
							(Said '//body')
							(OnButton event 25 70 62 92)
							(OnButton event 81 97 140 106)
							(OnButton event 63 114 140 136)
							(OnButton event 160 98 209 110)
							(OnButton event 163 119 190 133)
							(OnButton event 220 96 261 106)
							(OnButton event 221 116 258 143)
							(OnButton event 285 83 311 108)
							(OnButton event 286 143 311 155)
							(OnButton event 8 125 25 154)
						)
						(Print 70 13) ; "Most of these mummies must be quite old, for they look dry and brittle, and smell of dust and decay."
					)
				)
			)
			((Said 'get/bone')
				(cond
					((gEgo has: 9) ; herbs | bone
						(event claimed: 0)
					)
					((gCast contains: bone)
						(if (< (gEgo distanceTo: bone) 40)
							(proc173_4 bone 189)
						else
							(NotClose) ; "Perhaps you should move closer."
						)
					)
				)
			)
			((or (Said 'talk[/galahad]') (Said 'greet'))
				(cond
					((IsFlag 173)
						(Print 70 14) ; "He will not answer. He is dead."
					)
					((IsFlag 206)
						(Print 70 15) ; "He is in a healing trance and cannot answer."
					)
					(else
						(Print 70 16) ; "He is in no condition to answer you."
					)
				)
			)
			((Said 'get/blade')
				(Print 70 17) ; "You have Excaliber. It is the only weapon you need."
			)
			((Said 'get/shield')
				(Print 70 18) ; "You have your own fine shield. It would be absurd to carry two."
			)
			((Said 'get/bier')
				(Print 70 19) ; "It is made of stone and not going anywhere."
			)
			((Said 'get/fur')
				(Print 70 20) ; "It is old and deteriorating and of no use to you."
			)
			((and (gEgo has: 5) (Said 'divide/elixer')) ; sleeve | elixir
				(Print 70 21) ; "As the hierophant warned you, there is only enough for one use."
			)
			((Said 'give,pour/elixer')
				(cond
					((not (gEgo has: 5)) ; sleeve | elixir
						(Print 70 22) ; "If only you had not been such a fool and done as Fatima and the hierophant advised. Galahad is dead and you must bear the responsibility."
					)
					((IsFlag 173)
						(Print 70 23) ; "It is too late. Had you acted in time, he would have lived. His death weighs heavily upon your soul."
					)
					(else
						(SetScore 0 2 50)
						(gEgo setScript: giveElixir)
					)
				)
			)
			((Said 'get,carry,move/galahad')
				(if (IsFlag 173)
					(Print 70 24) ; "This will serve as his tomb. Let him lie."
				else
					(Print 70 25) ; "He is just as well off here as anywhere. Better not to move him."
				)
			)
			((Said 'help,bandage,save,deliver/galahad')
				(cond
					((IsFlag 173)
						(Print 70 26) ; "All hope is gone. Galahad is dead."
					)
					((gEgo has: 5) ; sleeve | elixir
						(Print 70 27) ; "You have the means to save his life, if you have the courage to make the sacrifice."
					)
					((IsItemAt 5) ; sleeve | elixir
						(Print 70 28) ; "Galahad will live and revive eventually. Now you must go on. Your own life is at stake."
					)
					(else
						(Print 70 29) ; "Alas, if you had but heeded the warnings of Fatima and the hierophant, perhaps you would have had a chance."
					)
				)
			)
			((Said 'kill,attack,annihilate/galahad')
				(if global171
					(Print 70 30) ; "The rat's poison must be affecting your mind. You are babbling nonsense."
				else
					(Print 70 31) ; "That is utter madness, to even think such a thing."
				)
			)
			((Said 'kiss,hug/galahad')
				(Print 70 32) ; "Ahem...do try to restrain yourself."
			)
			((Said 'drink/elixer')
				(cond
					((not (gEgo has: 5)) ; sleeve | elixir
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((IsFlag 173)
						(Print 70 33) ; "The elixir burns like fire through your veins. You are healed. The poison is gone, but at the cost of Galahad's life."
					)
					((not local1)
						(= local1 1)
						(Print 70 34) ; "Wait! Here lies Sir Galahad, purest of your knights. He has also been bitten and is at death's very door."
						(Print 70 35) ; "If you do not give him the elixir, he will die. He could die at any moment! A terrible choice is before you."
						(Print 70 36) ; "If you drink the elixir, you let Galahad die. If you give Galahad the elixir, your one chance is to find the Grail before your own time runs out."
						(Print 70 37) ; "Only the healing powers of the Grail may be able to save you. If not, at least Galahad would remain alive to carry on the mission."
					)
					(else
						(gEgo setScript: DrinkThatElixir)
					)
				)
			)
			((Said 'give>')
				(cond
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((IsFlag 173)
						(event claimed: 1)
						(Print 70 38) ; "It is of no use to a dead man."
					)
					((IsFlag 206)
						(event claimed: 1)
						(Print 70 39) ; "He is in a healing trance, unable to hear, speak or move."
					)
					((Said '/apple<golden')
						(Print 70 40) ; "He cannot use it now. You had best keep it."
					)
					((Said '/apple<green')
						(Print 70 41) ; "He is unable to eat it and you may yet have need of it."
					)
					((Said '/lodestone')
						(Print 70 42) ; "I would not part with it just yet. You may well need it."
					)
					(else
						(event claimed: 1)
						(Print 70 43) ; "That would not help him."
					)
				)
			)
			((Said 'make/sacrifice')
				(Print 70 44) ; "Truly, you are noble. But you must make the clear the nature of the sacrifice you intend."
			)
		)
	)
)

(instance galahadTwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
			)
			(1
				(galahadHead setLoop: (Random 3 4) setCel: 0)
				(= seconds (Random 1 4))
			)
			(2
				(galahadHead setCel: 1)
				(= seconds (Random 1 5))
			)
			(3
				(galahadHead setLoop: 3 setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance giveElixir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (gEgo illegalBits:))
				(gEgo illegalBits: 0 ignoreActors:)
				(= global172 0)
				(galahad setScript: 0)
				(= cycles 1)
			)
			(1
				(if (> (gEgo x:) 210)
					(-- state)
					(gEgo setMotion: MoveTo 210 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo 192 157 self)
				)
			)
			(2
				(galahadHead hide:)
				(gEgo
					view: 373
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(SetFlag 206)
				(PutItem 5) ; sleeve | elixir
				(= seconds 3)
			)
			(4
				(gEgo
					view: 0
					loop: 0
					illegalBits: register
					cycleSpeed: 0
					ignoreActors: 0
				)
				(galahadHead hide:)
				(galahad setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(5
				(galahadHead setLoop: 2 posn: 218 161 33 show:)
				(gTObj actor: galahadHead tLoop: 2 cSpeed: 2 talkCue: self)
				(Talk 70 45 70 46) ; "Arthur....my king. I knew....you would....come."
			)
			(6
				(galahadHead hide:)
				(galahad setCycle: End self)
			)
			(7
				(galahadHead setLoop: 3 posn: 212 161 31 show:)
				(galahad setLoop: 5)
				(= seconds 2)
			)
			(8
				(Print 70 47) ; "He has lapsed into a healing coma. By the time he is healed, you will be dead of the rat's poison."
				(Print 70 48) ; "You have but one chance--to find the Grail! Only its healing powers may yet save you....if you can find it in time."
				(Print 70 49) ; "Do not despair or regret your choice. You have done the good and noble deed and saved Galahad, who served you so faithfully."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance attackingRat of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (not global80))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 80 152 self)
			)
			(1
				(SetFlag 182)
				(RatBite
					gotoX1: 54
					gotoY1: 160
					gotoX2: 15
					gotoY2: 148
					midPointX: 0
					offControlsX: 82
					offControlsY: 152
					optCel: 3
				)
				(gEgo illegalBits: $c000)
				((ScriptID 172 0) posn: 9 96 init:) ; bitingRat
			)
			(2
				(ClearFlag 182)
				(Print 70 50) ; "Alas! A rat has bitten you! There was nothing you could do to avoid it."
				(Print 70 51) ; "The hierophant warned that even one bite was lethal and death inevitable, though it may be slow in coming."
				(Print 70 52) ; "And it appears that Galahad has fallen prey to the rats, for there he lies upon a bier, unaware even of your presence."
				(= global172 60)
				(SetFlag 169)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 2)
				(== (gSFX number:) (proc0_20 87))
				(== (gSFX prevSignal:) 10)
			)
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND (proc0_20 84))
				(Load rsSOUND (proc0_20 87))
				(Load rsPIC 112)
				(gEgo setMotion: MoveTo 55 152 self)
			)
			(1
				(leftDoor
					setLoop: 0
					init:
					setMotion: MoveTo (leftDoor x:) 96 self
				)
				(gEgo setMotion: MoveTo 62 152)
				(gRegMusic stop:)
				(gSFX number: (proc0_20 84) loop: 1 play:)
			)
			(2
				(gSFX stop: number: (proc0_20 87) loop: 1 play:)
				(if (not local0)
					(client setScript: 0)
				else
					(gEgo illegalBits: $c070)
				)
			)
			(3
				(Print 70 53) ; "Nay, you chose wrongly! Now you are trapped within this room. By the time Galahad recovers, he will find you dead."
				(gCurRoom style: 8 drawPic: 112)
				(gCast eachElementDo: #hide)
				(EgoDead 70 54) ; "I cannot bear to remain and watch. At least you die knowing that Galahad will live to carry on the mission, for the Goddess has sworn to release him. Farewell, Arthur."
			)
		)
	)
)

(instance DrinkThatElixir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PutItem 5) ; sleeve | elixir
				(Print 70 55) ; "Never have I felt such contempt for you as I do at this moment. You have chosen your own life over that of Galahad and now he is dead."
				(SetFlag 310)
				(self setScript: (ScriptID 195 0) self) ; DrinkElix
			)
			(1
				(ClearFlag 310)
				(Print 70 56) ; "The elixir burns through your body, purging the poison. You are healed in body, but your soul is forever tainted."
			)
		)
	)
)

(instance galahadCountdown of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (!= (= temp0 (GetTime 1)) lastSeconds) ; SysTime12
			(= lastSeconds temp0)
			(switch (-- global172)
				(1
					(Print 70 57) ; "Galahad is dead. You have failed to save one of your greatest and purest knights. This is a grievous failure on your part."
					(SetFlag 173)
					(galahad setScript: 0)
				)
				(15
					(Print 70 58) ; "Arthur, Galahad grows much worse! I fear he is about to die!"
				)
			)
		)
	)
)

