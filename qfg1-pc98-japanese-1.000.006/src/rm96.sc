;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use FileSelector)
(use LoadMany)
(use Rev)
(use Wander)
(use Chase)
(use RFeature)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm96 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 6]
	[local16 6] = [160 164 160 167 151 155]
	[local22 6] = [14 21 9 12 13 21]
	local28
	[local29 3] = [-9 -2 3]
	[local32 3] = [-17 -16 -16]
	[local35 3] = [8 9 9]
	[local38 5] = [-18 -16 -3 1 6]
	[local43 5] = [-31 -29 -28 -27 -29]
	[local48 5] = [-1 1 2 3 1]
	local53
)

(procedure (localproc_0)
	(if (IsFlag 259)
		(HighPrint 96 0) ; "It looks like the talking is over."
	else
		(HighPrint 96 1) ; "No more talking, my friend. Let's have fun!"
	)
)

(procedure (localproc_1)
	(switch (++ global114)
		(1
			(HighPrint 96 2) ; "You feel disoriented."
		)
		(2
			(HighPrint 96 3) ; "How does he DO this?"
		)
		(3
			(HighPrint 96 4) ; "There's an ECHO IN HERE...Echo In Here ...echo in here..."
		)
		(4
			(HighPrint 96 5) ; "M. C. Escher would LOVE this place."
		)
		(5
			(HighPrint 96 6) ; "OK, enough fooling around!"
		)
		(6
			(HighPrint 96 7) ; "This is getting old!"
		)
		(7
			(HighPrint 96 8) ; "A person COULD get used to this."
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= [local10 temp0] (Clone aFly))
		([local10 temp0]
			ignoreActors:
			posn: [local16 temp0] [local22 temp0]
			init:
			setLoop: 9
			setPri: 15
		)
		(if (< gHowFast 2)
			([local10 temp0] stopUpd: addToPic:)
		else
			([local10 temp0] setCycle: Fwd setMotion: Wander)
		)
	)
)

(instance roomMusic of Sound
	(properties
		number 82
		priority 1
		loop -1
	)
)

(instance effect of Sound
	(properties
		number 86
		priority 3
	)
)

(instance isScript of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #script)
			(param1 script:)
		)
	)
)

(instance Door1 of RFeature
	(properties
		nsTop 64
		nsLeft 2
		nsBottom 132
		nsRight 12
	)
)

(instance Door2 of RFeature
	(properties
		nsTop 24
		nsLeft 36
		nsBottom 76
		nsRight 50
	)
)

(instance Door6 of RFeature
	(properties
		nsTop 62
		nsLeft 65
		nsBottom 102
		nsRight 84
	)
)

(instance polkaDots of RFeature
	(properties
		nsTop 53
		nsLeft 243
		nsBottom 133
		nsRight 319
	)
)

(instance littleButton of RFeature
	(properties
		nsTop 91
		nsLeft 55
		nsBottom 97
		nsRight 59
	)
)

(instance littleSign of RFeature
	(properties
		nsTop 93
		nsLeft 265
		nsBottom 101
		nsRight 275
	)
)

(instance doorSign of RPicView
	(properties
		y 46
		x 13
		view 96
		loop 7
		priority 14
	)

	(method (init)
		(= view (LangSwitch 96 92))
		(super init: &rest)
	)
)

(instance MESign of RPicView
	(properties
		y 53
		x 161
		view 96
		loop 7
		cel 1
		priority 14
	)

	(method (init)
		(= view (LangSwitch 96 92))
		(super init: &rest)
	)
)

(instance yorick of Prop
	(properties
		y 95
		x 161
		view 297
	)

	(method (doit)
		(cond
			((> local4 1)
				(-- local4)
			)
			((== local4 1)
				(= local4 local3)
				(if
					(and
						(IsFlag 267)
						(not (gCast firstTrue: #perform isScript))
						(not (IsFlag 263))
						(not global104)
						(< (gEgo x:) 295)
						(!= (gEgo onControl: 1) 16384)
						(!= (gEgo onControl: 1) 8192)
						(not local2)
					)
					(SetFlag 265)
					(self setScript: throwIt)
				)
			)
		)
		(if (IsFlag 259)
			(cond
				(
					(<
						(= local1
							(GetAngle
								(yorick x:)
								(yorick y:)
								(gEgo x:)
								(gEgo y:)
							)
						)
						112
					)
					(if (!= (yorick cel:) 4)
						(yorick setCel: 4)
					)
				)
				((< local1 145)
					(if (!= (yorick cel:) 3)
						(yorick setCel: 3)
					)
				)
				((< local1 220)
					(if (!= (yorick cel:) 2)
						(yorick setCel: 2)
					)
				)
				((< local1 253)
					(if (!= (yorick cel:) 1)
						(yorick setCel: 1)
					)
				)
				((!= (yorick cel:) 0)
					(yorick setCel: 0)
				)
			)
		)
		(cond
			((and (IsFlag 268) (not local7) (not local8))
				(SolvePuzzle 709 8)
				(= local7 1)
				(head dispose:)
				(self view: 298 setLoop: 0 setCel: 0)
			)
			((and local7 (gEgo mover:))
				(NormalEgo)
				(= local7 0)
				(= local8 1)
				(arrow setScript: takeADive)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'cast')
				(if (gEgo script:)
					(HighPrint 96 9) ; "Now??"
				else
					(HighPrint 96 10) ; ""ME" sees you preparing your spell and..."
					(arrow setScript: takeADive)
				)
			)
			((Said 'throw>')
				(cond
					((gEgo script:)
						(HighPrint 96 11) ; "You're too busy."
						(event claimed: 1)
					)
					((Said '/dagger,boulder')
						(HighPrint 96 12) ; ""ME" sees you preparing to throw and..."
						(arrow setScript: takeADive)
					)
					(else
						(HighPrint 96 13) ; "Why would you want to throw that?"
						(event claimed: 1)
					)
				)
			)
			((Said 'talk,talk>')
				(cond
					((IsFlag 267)
						(localproc_0)
						(event claimed: 1)
					)
					((Said '/yorick')
						(if (not (IsFlag 268))
							(SolvePuzzle 708 2)
							(SetFlag 268)
							(HighPrint 96 14) ; "You know me? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
						else
							(HighPrint 96 15) ; "Be more specific, my friend."
						)
					)
					((Said '/man,warlock,mage,bandit')
						(HighPrint 96 16) ; "Talking is a speciality of those who know not what they talk about."
					)
				)
			)
			((Said 'ask>')
				(if (IsFlag 267)
					(localproc_0)
					(event claimed: 1)
				else
					(= local9 1)
					(cond
						((Said '//elsa')
							(if (not (IsFlag 268))
								(SetFlag 268)
								(HighPrint 96 17) ; "You know Elsa? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
								(HighPrint 96 18) ; "After you have explained what you know about Elsa, Yorick speaks:"
							)
							(HighPrint 96 19) ; "It's about time that someone else helped Elsa before it's too late! Toro and I are the only friends she's got here."
							(HighPrint 96 20) ; "She's a lot like her dad, though. She organized these brigands and changed them from mere thugs to major raiders!"
							(HighPrint 96 21) ; "She plans to move the entire band away from the valley as soon as the snow clears. If that happens, I know she will never be disenchanted."
						)
						((Said '//enchantment,disenchantment,spell,curse,curse')
							(if (not (IsFlag 268))
								(SetFlag 268)
								(HighPrint 96 22) ; "You know about the enchantment? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
							)
							(HighPrint 96 23) ; "Elsa doesn't know who she really is. That's part of the enchantment."
							(HighPrint 96 24) ; "When Elsa was left with some brigands ten years ago, all her memories were taken away from her."
							(HighPrint 96 25) ; "I borrowed a Magic Mirror from a friend to try to break the spell, but it only works when spells are cast directly at you."
							(HighPrint 96 26) ; "If you're going to be the big Hero, I hope you brought a Dispel Potion or something."
						)
						((Said '//yorick')
							(if (not (IsFlag 268))
								(SetFlag 268)
								(HighPrint 96 27) ; "You know me? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
							)
							(HighPrint 96 28) ; "Alas, poor Yorick! I know me well."
							(HighPrint 96 29) ; "Ten years ago, I swore I would find Elsa no matter what. It took me two years to find her, here with the brigands, and I've posed as her warlock ever since."
							(HighPrint 96 30) ; "I couldn't break the spell on her, nor could I leave her to grow up into an attractive woman surrounded by rogues and scoundrels."
							(HighPrint 96 31) ; "Someone had to defend her honor!"
						)
						((Said '//me')
							(HighPrint 96 32) ; "Can't you see that I am he? I try to inspire (before they expire) a sense of awe and majesty in those that enter here."
							(HighPrint 96 33) ; "After all, I am the Brigand Warlock. One has to keep up one's appearances, or appear to keep up with one's peers."
						)
						((Said '//warlock,caravan')
							(HighPrint 96 34) ; "Everybody needs to know a few magic tricks to get by these days. You'd be surprised how effective Sleeping Powder is for taking out the guards of a caravan."
						)
						((Said '//powder,banana,trick')
							(HighPrint 96 35) ; "You snooze, you lose. And my banana trick has appeal of its own."
						)
						((Said '//jester')
							(HighPrint 96 36) ; "For thirty years I was the Court Jester. Now I jest enjoy watching other people take the pratfalls."
						)
						((Said '//leader[<bandit,your,about]')
							(HighPrint 96 37) ; "I'll protect the Brigand Leader with everything I've got. That's no laughing matter as I get madder."
						)
						((Said '//potion<disenchant,disenchant')
							(if (not (IsFlag 268))
								(SetFlag 268)
								(HighPrint 96 22) ; "You know about the enchantment? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
							)
							(HighPrint 96 38) ; "The true Dispel Potion will break an enchantment. You must splash the potion on Elsa as soon as you can, or she'll skewer you for sure. She's more than a match for old "Swordy Lordy" now!"
						)
						((Said '//potion')
							(= local9 0)
							(HighPrint 96 39) ; "Of which potion do you speak?"
						)
						((Said '//swordy,lordy')
							(HighPrint 96 40) ; "You must know the "Blade Braggart". He used to show off in the castle courtyard all the time."
							(HighPrint 96 41) ; "Elsa once asked if "Rapier Ruler" would teach her to use the sword, and the "Sword Bore" told her he would not waste his talent on females."
							(HighPrint 96 42) ; "She came to me in tears. After all, she was only nine at the time."
							(HighPrint 96 43) ; "She can teach old "Weapon Windbag" a thing or two now! Her arm is true, and she's truly disarming."
						)
						((Said '//done,done,door')
							(HighPrint 96 44) ; "There are plenty of doors. You wouldn't want me to spoil your fun, now!"
							(HighPrint 96 45) ; "Either you'll figure it out in the end, or you'll end it before you're out."
						)
						((Said '//room,maze,path,aisle')
							(HighPrint 96 46) ; "This room is my way of keeping the brigands from bothering the Leader about raises, since it tends to raze the brigands."
							(HighPrint 96 47) ; "I designed it myself! This place has people rolling in the aisles."
						)
						((Said '//leer,(mirror[<magic,leer,about])')
							(HighPrint 96 48) ; "Ah yes, the "Mirror with the Leer", as Erasmus calls it (or was it Fenrus?). It reflects a spell back on the caster of the spell."
							(HighPrint 96 49) ; "The Warlock ruminates: "Now where did I put that mirror... was it on the desk in Elsa's office?""
						)
						((Said '//bull,toro,bull')
							(HighPrint 96 50) ; "Toro is the minotaur that guards this fortress. Elsa found him when he was just a calf, and he's kowtowed to her ever since."
							(HighPrint 96 51) ; "He guarantees that the brigands won't give Elsa any bull.""
						)
						((Said '//castle')
							(HighPrint 96 52) ; "This fort is the brigand's palace. It has been well-constructed."
						)
						((Said '//baron,(dad[<leader,elsa,about])')
							(HighPrint 96 53) ; "Would he be surprised to see his little girl now!"
						)
						((Said '//*')
							(= local9 0)
							(if (IsFlag 268)
								(HighPrint 96 54) ; "If you have business to do, then get busy doing your business."
							else
								(switch (Random 0 3)
									(0
										(HighPrint 96 55) ; "Can't you see that's nothing to me? You'd better flee."
									)
									(1
										(HighPrint 96 56) ; "The brigands will come to spoil your fun. You'll be undone."
									)
									(2
										(HighPrint 96 57) ; "The brigands tend to hold a grudge, and they won't begrudge to tend to you."
									)
									(3
										(HighPrint 96 58) ; "If you have any famous last statements, you'd better say the secret word, or you'll lament your last state."
									)
								)
							)
						)
					)
					(if local9
						(SolvePuzzle 708 2)
					)
				)
			)
		)
	)
)

(instance head of Prop
	(properties
		y 76
		x 161
		view 297
		loop 6
		cel 1
	)

	(method (doit)
		(= local1 (GetAngle (yorick x:) (yorick y:) (gEgo x:) (gEgo y:)))
		(if (and (== (head loop:) 6) (!= (head cel:) 3))
			(cond
				((< local1 135)
					(if (!= (head cel:) 2)
						(head setCel: 2)
					)
				)
				((< local1 225)
					(if (!= (head cel:) 1)
						(head setCel: 1)
					)
				)
				((!= (head cel:) 0)
					(head setCel: 0)
				)
			)
		)
		(super doit:)
	)
)

(instance secretSign of RPicView
	(properties
		y 48
		x 282
		view 96
		loop 7
		cel 2
	)

	(method (init)
		(= view (LangSwitch 96 92))
		(super init: &rest)
	)
)

(instance exitSign of RPicView
	(properties
		y 52
		x 70
		view 96
		loop 7
		cel 3
		priority 7
	)

	(method (init)
		(= view (LangSwitch 96 92))
		(super init: &rest)
	)
)

(instance behindDoor11 of View
	(properties
		y 94
		x 215
		view 96
		loop 7
		cel 4
	)
)

(instance door11 of Prop
	(properties
		y 94
		x 225
		view 96
	)

	(method (doit)
		(cond
			((> local5 1)
				(if (== (gEgo onControl: 1) 1024)
					(= local5 0)
					(self setScript: goTo6)
				else
					(-- local5)
				)
			)
			((== local5 1)
				(= local5 0)
				(= local6 0)
				(self setCycle: Beg)
			)
		)
		(super doit:)
	)
)

(instance behindDoor7 of Prop
	(properties
		y 96
		x 95
		view 96
		loop 2
	)
)

(instance door7 of Prop
	(properties
		y 95
		x 93
		view 96
		loop 1
	)
)

(instance arrow of Prop
	(properties
		y 76
		x 160
		view 96
		loop 3
	)
)

(instance door3 of Prop
	(properties
		y 108
		x 36
		view 96
		loop 4
	)
)

(instance door13 of Prop
	(properties
		y 68
		x 253
		view 96
		loop 5
	)

	(method (doit)
		(if (and (IsFlag 269) (not script))
			(ClearFlag 269)
			(SetFlag 257)
			(gEgo setPri: (+ (gEgo priority:) 1) setScript: fallSideways)
		)
		(super doit:)
	)
)

(instance door12 of Prop
	(properties
		y 105
		x 242
		view 96
		loop 6
		cel 2
	)
)

(instance globe of Prop
	(properties
		y 26
		x 161
		view 96
		loop 8
	)
)

(instance chain of View
	(properties
		y 48
		x 45
		view 96
		loop 7
		cel 6
	)
)

(instance trap1 of Prop
	(properties
		y 110
		x 57
		view 296
	)
)

(instance trap2 of Prop
	(properties
		y 150
		x 269
		view 296
		loop 1
	)
)

(instance trap3 of Prop
	(properties
		y 138
		x 160
		view 296
		loop 2
	)
)

(instance trap4 of Prop
	(properties
		y 115
		x 159
		view 296
		loop 3
	)

	(method (doit)
		(if (and (IsFlag 270) (not script))
			(ClearFlag 270)
			(self setScript: fallUpscreen)
		)
		(super doit:)
	)
)

(instance aFly of Act
	(properties
		view 96
		loop 9
	)
)

(instance rm96 of Rm
	(properties
		picture 96
		style 2
	)

	(method (dispose)
		(SetFlag 86)
		(= global114 0)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 297 298 296 536 537 517 538 516 (LangSwitch 96 92))
		(LoadMany rsSCRIPT 969 991 972 970)
		(LoadMany
			rsSOUND
			82
			(SoundFX 86)
			(SoundFX 85)
			(SoundFX 84)
			(SoundFX 83)
			(SoundFX 87)
		)
		(gContMusic stop:)
		(super init: &rest)
		(gMouseHandler add: self)
		(SolvePuzzle 707 8)
		(SL enable:)
		(gAddToPics
			add: doorSign MESign secretSign exitSign
			eachElementDo: #init
			doit:
		)
		(= local4 (= local3 50))
		(roomMusic init: play:)
		(effect init:)
		(localproc_2)
		(= global114 0)
		(yorick init: stopUpd:)
		(head setPri: 7 init:)
		(trap1 ignoreActors: setPri: 7 init: stopUpd:)
		(trap2 ignoreActors: setPri: 10 init: stopUpd:)
		(trap3 ignoreActors: setPri: 9 init: stopUpd:)
		(trap4 ignoreActors: setPri: 7 init: stopUpd:)
		(chain ignoreActors: setPri: 7 init: stopUpd:)
		(door11 ignoreActors: cycleSpeed: 1 setPri: 6 init: stopUpd:)
		(door7 ignoreActors: cycleSpeed: 1 setPri: 5 init: stopUpd:)
		(door3 ignoreActors: cycleSpeed: 1 setPri: 7 init: stopUpd:)
		(door12 ignoreActors: cycleSpeed: 1 setPri: 5 init: stopUpd:)
		(door13 ignoreActors: cycleSpeed: 1 setPri: 8 init: stopUpd:)
		(arrow ignoreActors: cycleSpeed: 1 setPri: 4 init: stopUpd:)
		(if (< gHowFast 2)
			(globe init: stopUpd: addToPic:)
		else
			(globe init: cycleSpeed: 2 setCycle: Fwd)
		)
		(EgoGait 0 0) ; walking
		(NormalEgo)
		(gEgo posn: 43 198 init: setScript: talksAlot)
	)

	(method (doit)
		(if
			(and
				(!= (gEgo onControl: 1) 1)
				(not (IsFlag 257))
				(not (IsFlag 260))
				(not (IsFlag 271))
			)
			(SetFlag 257)
			(switch (gEgo onControl: 1)
				(32
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(trap1 setScript: trapFall)
				)
				(512
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(trap2 setScript: trapFall)
				)
				(64
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(gEgo setPri: (+ (gEgo priority:) 1))
					(trap3 setScript: trapFall)
				)
				(128
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(trap3 setScript: trapFall)
				)
				(2048
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(trap4 setScript: trapFall)
				)
				(4
					(if local6
						(= local5 1)
					)
					(gEgo setScript: fallUpscreen)
				)
				(2
					(if local6
						(= local5 1)
					)
					(gEgo setScript: fallDownscreen)
				)
				(16
					(SetFlag 258)
					(if local6
						(= local5 1)
					)
					(if (> (gEgo y:) 107)
						(gEgo setScript: fallSideways)
					else
						(gEgo setScript: fallDownscreen)
					)
				)
				(8
					(if local6
						(= local5 1)
					)
					(if (> (gEgo y:) 107)
						(gEgo setScript: fallSideways)
					else
						(gEgo setScript: fallDownscreen)
					)
				)
				(else
					(ClearFlag 257)
				)
			)
		)
		(if (and (not (IsFlag 263)) (not (IsFlag 257)))
			(cond
				((== (gEgo edgeHit:) EDGE_RIGHT)
					(if (not (IsFlag 260))
						(SetFlag 263)
						(gEgo setScript: goTo2)
					)
				)
				((and (== (gEgo edgeHit:) EDGE_LEFT) (< (gEgo y:) 150))
					(SetFlag 263)
					(if (< (gEgo y:) 100)
						(gEgo setPri: -1 setScript: goTo15)
					else
						(if local6
							(= local5 1)
						)
						(gEgo setScript: goTo12)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said
						'look,look/chandelier,chandelier,firefly,fly,fly,bowl,globe'
					)
					(MouseClaimed globe event 3)
				)
				(HighPrint 96 59) ; "It IS! It's a bowl of fireflies, used as a light source. What won't they think of next?"
			)
			(
				(or
					(Said 'look,look/man,yorick,warlock,bandit,me')
					(and (MouseClaimed head event 3) (not (MouseClaimed arrow event 3)))
					(MouseClaimed yorick event 3)
				)
				(HighPrint 96 60) ; "It's "ME"."
			)
			((or (MouseClaimed arrow event 3) (MouseClaimed MESign event 3))
				(HighPrint 96 61) ; "The arrow points to "ME"."
			)
			((MouseClaimed Door1 event 3)
				(HighPrint 96 62) ; "It's an entrance...or is it an exit?"
			)
			((MouseClaimed Door6 event 3)
				(HighPrint 96 63) ; "It's an exit...or is it an entrance?"
			)
			((MouseClaimed Door2 event 3)
				(HighPrint 96 64) ; "The attic exit?"
			)
			((MouseClaimed doorSign event 3)
				(HighPrint 96 65) ; "The arrow points to a door. Who could've guessed?"
			)
			((MouseClaimed secretSign event 3)
				(HighPrint 96 66) ; "The arrow points to a door. How secret is that?"
			)
			(
				(or
					(Said 'look,look/entrance,done,done')
					(MouseClaimed exitSign event 3)
				)
				(HighPrint 96 67) ; "A sign points to a door. The egress?"
			)
			((MouseClaimed door11 event 3)
				(HighPrint 96 68) ; "It's another door!"
			)
			((MouseClaimed door7 event 3)
				(HighPrint 96 69) ; "It looks like a picture of an upside-down door painted on the wall."
			)
			((or (Said 'look,look/button') (MouseClaimed littleButton event 3))
				(HighPrint 96 70) ; "Engraved on the button are the words: "PUSH ME"."
			)
			((or (Said 'look,look/box') (MouseClaimed door3 event 3))
				(HighPrint 96 71) ; "It's a box of some sort...or so the sign says. There is a button next to the box."
			)
			((MouseClaimed door12 event 3)
				(HighPrint 96 72) ; "A pet door? It's shorter than you are."
			)
			((MouseClaimed littleSign event 3)
				(if (and (== (gEgo onControl: 1) 256) (> (gEgo x:) 100))
					(door13 setScript: happyFace)
				else
					(HighPrint 96 73) ; "It's a sign, but you'll have to be closer to read it."
				)
			)
			((or (Said 'look,look/ladder') (MouseClaimed trap4 event 3))
				(HighPrint 96 74) ; "Stairs lead up to the platform on which "ME" is located."
			)
			((or (Said 'look,look/face[<happy]') (MouseClaimed door13 event 3))
				(HighPrint 96 75) ; "Have a nice day!"
			)
			((or (Said 'look,look/dot[<polka]') (MouseClaimed polkaDots event 3))
				(HighPrint 96 76) ; "It reminds you of a tie you once received as a present on All-Fools Day."
			)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look,read/sign,sign')
						(if
							(and
								(== (gEgo onControl: 1) 256)
								(> (gEgo x:) 100)
							)
							(door13 setScript: happyFace)
						else
							(HighPrint 96 77) ; "DOOR" "SECRET ENTRANCE" "EXIT" "ME" "BOX"
						)
					)
					((Said 'look,look>')
						(cond
							((or (Said '<up') (Said '/ceiling,ladder'))
								(HighPrint 96 78) ; "There appear to be stairs leading up (?) to nowhere. There is also what looks like a bowl full of fireflies."
							)
							(
								(or
									(Said '<down')
									(Said '/ground,floor,pit,aisle')
								)
								(HighPrint 96 79) ; "There is a deep pit with a walkway winding above it."
							)
							((Said '/wall')
								(HighPrint 96 80) ; "Wow!"
							)
							((Said '/chain,rope,handle')
								(HighPrint 96 81) ; "In the "upstairs" doorway, there is a chain with a handle attached."
							)
							((Said '/arrow')
								(HighPrint 96 82) ; "The arrows point to various orifices."
							)
						)
					)
					((Said 'get/me/leader')
						(HighPrint 96 83) ; "Take yourself there."
					)
					(
						(and
							(not (and gNight (Said 'japaneserestorsleep>')))
							(Said 'rest,rest')
						)
						(HighPrint 96 84) ; "With the Brigands pounding at the door, you decide not to rest until you're safe."
					)
					((Said 'cast')
						(HighPrint 96 85) ; "Your magic has no effect. It must be something about this room."
					)
					((Said 'throw')
						(HighPrint 96 86) ; "It would serve no purpose."
					)
					((Said 'nap,nap')
						(EgoDead ; "You curl up for a nice little nap. The brigands break down the door. You wake up dead."
							96
							87
							82
							800
							0
							0
							80
							{He who hesitates...}
						)
					)
					((Said 'force/button,door,box')
						(if (gEgo inRect: 31 107 86 125)
							(SetFlag 257)
							(door3 setScript: knockOut)
						else
							(HighPrint 96 88) ; "Get closer."
						)
					)
					((Said 'pull[/chain,rope,handle]')
						(if (== (gEgo onControl: 1) 8192)
							(= local6 1)
							(= local5 200)
							(door11 setScript: pullChain)
						else
							(HighPrint 96 89) ; "You can't do that from where you're standing."
						)
					)
					((Said 'open,open,open,unbar,unlock[/door]')
						(cond
							((gEgo inRect: 10 150 120 189)
								(HighPrint 96 90) ; "You dare not unbar the door. You hear hordes of brigands massing beyond it."
							)
							((== (gEgo onControl: 1) 4096)
								(if (IsFlag 264)
									(gEgo setScript: finalExit)
								else
									(User canInput: 0)
									(door7 setScript: doorFall)
								)
							)
							((== (gEgo onControl: 1) 1024)
								(door11 setScript: brickWall)
							)
							(else
								(HighPrint 96 91) ; "You can't do it."
							)
						)
					)
					((Said 'unlock')
						(HighPrint 96 92) ; "Nothing is locked."
					)
				)
			)
		)
	)
)

(instance fallUpscreen of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 259))
					(head setCel: 3)
					(yorick setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				)
				(gEgo view: 536 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(effect number: (SoundFX 9) loop: 1 priority: 2 play:)
				(gEgo
					setPri: (- (gEgo priority:) 1)
					yStep: 6
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead ; "You're mad as heck, and you're not going to take it anymore. As a matter of fact, you CAN'T take it anymore. Restore your strength and health and try again."
						96
						93
						80
						{You're the Fall Guy again.}
						82
						517
						2
						5
					)
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: rollOut)
						(if (== client trap4)
							(client setPri: (+ (client priority:) 1))
						)
						(client setCel: 0 setScript: 0)
					else
						(gEgo setScript: rollOut)
					)
				)
			)
		)
	)
)

(instance fallDownscreen of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 259))
					(head setCel: 3)
					(yorick setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				)
				(gEgo view: 537 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(effect number: (SoundFX 9) loop: 1 priority: 2 play:)
				(gEgo
					setPri: (+ (gEgo priority:) 1)
					yStep: 12
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Start over, and remember to keep up your strength and health."
						96
						94
						80
						{You're the Fall Guy again.}
						82
						517
						2
						5
					)
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: rollOut)
						(client setCel: 0 setScript: 0)
					else
						(gEgo setScript: rollOut)
					)
				)
			)
		)
	)
)

(instance rollOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(effect stop:)
				(if (Said 'stop,grab,stand,stand,halt,no')
					(if (< state 6)
						(= cycles 0)
						(self changeState: 6)
					else
						(event claimed: 1)
					)
				else
					(effect play:)
				)
				(if (Said 'cast')
					(HighPrint 96 95) ; "NOT NOW!!"
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 264)
					(door7 setCycle: Beg)
				)
				(if (not (IsFlag 259))
					(yorick setLoop: 4 setCycle: Fwd)
				)
				(door11 setCycle: End self)
			)
			(1
				(effect number: (SoundFX 83) loop: 1 priority: 2 play:)
				(gEgo edgeHit: EDGE_NONE)
				(gEgo
					view: 296
					setLoop: 4
					setPri: 3
					illegalBits: 0
					posn: 190 63
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 6 4
					setCycle: Fwd
					setMotion: MoveTo 213 78 self
				)
			)
			(2
				(if (IsFlag 264)
					(ClearFlag 264)
					(door7 stopUpd:)
					(behindDoor7 dispose:)
				)
				(User canInput: 1)
				(if (not (IsFlag 259))
					(yorick setLoop: 3)
				)
				(gEgo setPri: 11 setMotion: MoveTo 268 114 self)
			)
			(3
				(User canInput: 0)
				(door11 setCycle: Beg)
				(gEgo setMotion: MoveTo 294 129 self)
			)
			(4
				(effect number: (SoundFX 9) loop: 1 priority: 2 play:)
				(trap2 setCel: 1)
				(if (not (IsFlag 259))
					(yorick setLoop: 4)
				)
				(gEgo yStep: 20 setMotion: MoveTo 325 200)
				(= cycles 20)
			)
			(5
				(if (not (TakeDamage 5))
					(EgoDead ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Keep up your strength and health and try again."
						96
						96
						80
						{You're the Fall Guy again}
						82
						517
						2
						5
					)
				else
					(trap2 setCel: 0)
					(self changeState: 0)
				)
			)
			(6
				(effect number: (SoundFX 87) loop: -1 priority: 2 play:)
				(gEgo
					setLoop: 5
					cel: 0
					setStep: 3 2
					setMotion: MoveTo 278 119 self
					cycleSpeed: 2
					setCycle: CT 2 1
				)
				(door11 setCycle: Beg)
			)
			(7
				(effect stop:)
				(gEgo y: (+ (gEgo y:) 14) setCel: 3)
				(= cycles 15)
			)
			(8
				(gEgo setCel: 4)
				(door11 stopUpd:)
				(if (not (IsFlag 259))
					(yorick setLoop: 0 cel: 0 setCycle: 0 stopUpd:)
					(head setCel: 1)
				)
				(= cycles 4)
			)
			(9
				(HandsOn)
				(gEgo setLoop: 1)
				(NormalEgo)
				(ClearFlag 260)
				(self dispose:)
			)
		)
	)
)

(instance ball of Act
	(properties
		y 78
		x 267
		view 96
		loop 7
		cel 5
	)
)

(instance happyFace of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 247 119 self)
			)
			(1
				(gEgo view: 296 setLoop: 6 setCel: 0)
				(HighPrint 96 97) ; "It's a little sign that reads: "Do not read this sign under any circumstances.""
				(= cycles 3)
			)
			(2
				(door13 setCycle: End self)
			)
			(3
				(door13 hide:)
				(ball
					illegalBits: 0
					ignoreActors:
					setPri: 8
					setLoop: 7
					setCel: 5
					init:
				)
				(= cycles 2)
			)
			(4
				(effect number: (SoundFX 86) loop: 1 priority: 2 play:)
				(ball posn: 261 85)
				(gEgo setCel: 1)
				(= cycles 2)
			)
			(5
				(effect stop:)
				(gEgo
					moveSpeed: 2
					setMotion: MoveTo 249 123
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
				(ball setMotion: JumpTo 195 189)
				(if (not (IsFlag 259))
					(head setCel: 3)
					(yorick setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				)
			)
			(6
				(door13 show: cycleSpeed: 0 setCycle: Beg)
				(gEgo setCycle: End self)
			)
			(7
				(SetFlag 258)
				(ball dispose:)
				(= cycles 2)
			)
			(8
				(door13 stopUpd:)
				(SetFlag 269)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(localproc_1)
				(= cycles 10)
			)
			(2
				(gEgo
					setPri: 7
					illegalBits: 0
					posn: 22 73
					setMotion: MoveTo 37 73 self
				)
			)
			(3
				(HandsOn)
				(gEgo illegalBits: $8000)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo6 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setMotion: MoveTo 215 97 self
				)
			)
			(1
				(gEgo setPri: 3 setMotion: MoveTo 194 83 self)
			)
			(2
				(door11 setCycle: Beg self)
			)
			(3
				(localproc_1)
				(NormalEgo)
				(door11 stopUpd:)
				(gEgo posn: 49 102 setMotion: MoveTo 87 102 self)
			)
			(4
				(HandsOn)
				(User canInput: 1)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo12 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
				)
			)
			(1
				(localproc_1)
				(door12 setCycle: Beg self)
			)
			(2
				(gEgo
					view: 296
					setLoop: 8
					cel: 0
					posn: 265 102
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 234 102 self
				)
			)
			(3
				(gEgo setLoop: 9 setCel: 0 posn: 231 101)
				(= cycles 3)
			)
			(4
				(gEgo setLoop: 1)
				(NormalEgo)
				(door12 setCycle: End self)
			)
			(5
				(HandsOn)
				(SetFlag 267)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo15 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(localproc_1)
				(gEgo posn: 325 129 setMotion: MoveTo 281 129 self)
			)
			(2
				(if (IsFlag 259)
					(SetFlag 267)
				)
				(NormalEgo)
				(HandsOn)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance poof of Prop
	(properties
		view 297
		loop 7
	)
)

(instance thingThrown of Act
	(properties
		z 30
		yStep 10
		view 297
		xStep 15
	)
)

(instance throwIt of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(not local28)
				(or
					(IsFlag 257)
					(== (gEgo onControl: 1) 16384)
					(door11 script:)
				)
			)
			(= local28 1)
			(= cycles 0)
			(self changeState: 7)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 271)
				(User canInput: 0)
				(if (IsFlag 259)
					(switch (yorick cel:)
						(0
							(poof
								posn:
									(+ (yorick x:) [local38 0])
									(+ (yorick y:) [local43 0])
							)
						)
						(1
							(poof
								posn:
									(+ (yorick x:) [local38 1])
									(+ (yorick y:) [local43 1])
							)
						)
						(2
							(poof
								posn:
									(+ (yorick x:) [local38 2])
									(+ (yorick y:) [local43 2])
							)
						)
						(3
							(poof
								posn:
									(+ (yorick x:) [local38 3])
									(+ (yorick y:) [local43 3])
							)
						)
						(4
							(poof
								posn:
									(+ (yorick x:) [local38 4])
									(+ (yorick y:) [local43 4])
							)
						)
					)
				else
					(yorick setLoop: 2 setCel: (head cel:) stopUpd:)
					(head setCel: 3)
					(switch (yorick cel:)
						(0
							(poof
								posn:
									(+ (yorick x:) [local29 0])
									(+ (yorick y:) [local32 0])
							)
						)
						(1
							(poof
								posn:
									(+ (yorick x:) [local29 1])
									(+ (yorick y:) [local32 1])
							)
						)
						(2
							(poof
								posn:
									(+ (yorick x:) [local29 2])
									(+ (yorick y:) [local32 2])
							)
						)
					)
				)
				(poof
					setPri: (+ (yorick priority:) 2)
					ignoreActors:
					init:
					setCycle: CT 3 1 self
				)
			)
			(1
				(if (IsFlag 259)
					(switch (yorick cel:)
						(0
							(thingThrown
								posn:
									(+ (yorick x:) [local38 0])
									(+ (yorick y:) [local48 0])
							)
						)
						(1
							(thingThrown
								posn:
									(+ (yorick x:) [local38 1])
									(+ (yorick y:) [local48 1])
							)
						)
						(2
							(thingThrown
								posn:
									(+ (yorick x:) [local38 2])
									(+ (yorick y:) [local48 2])
							)
						)
						(3
							(thingThrown
								posn:
									(+ (yorick x:) [local38 3])
									(+ (yorick y:) [local48 3])
							)
						)
						(4
							(thingThrown
								posn:
									(+ (yorick x:) [local38 4])
									(+ (yorick y:) [local48 4])
							)
						)
					)
				else
					(switch (yorick cel:)
						(0
							(thingThrown
								posn:
									(+ (yorick x:) [local29 0])
									(+ (yorick y:) [local35 0])
							)
						)
						(1
							(thingThrown
								posn:
									(+ (yorick x:) [local29 1])
									(+ (yorick y:) [local35 1])
							)
						)
						(2
							(thingThrown
								posn:
									(+ (yorick x:) [local29 2])
									(+ (yorick y:) [local35 2])
							)
						)
					)
				)
				(thingThrown
					setLoop: 8
					setCel: (Random 0 5)
					setPri: (gEgo priority:)
					ignoreActors:
					illegalBits: 0
					init:
					setMotion: Chase gEgo 20 self
				)
				(poof setCycle: End)
			)
			(2
				(HandsOff)
				(thingThrown
					setPri: (- (gEgo priority:) 1)
					setMotion: Chase gEgo 0 self
				)
			)
			(3
				(SetFlag 260)
				(gEgo
					view: 296
					loop:
						(if (or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
							7
						else
							6
						)
					cel: 1
				)
				(effect number: (SoundFX 86) loop: 1 priority: 2 play:)
				(TakeDamage 1)
				(cond
					((> (gEgo x:) (yorick x:))
						(if (and (< (gEgo x:) 313) (< (gEgo y:) 186))
							(gEgo
								posn: (+ (gEgo x:) 6) (+ (gEgo y:) 3)
							)
						)
					)
					((and (> (gEgo x:) 6) (< (gEgo y:) 186))
						(gEgo posn: (- (gEgo x:) 6) (+ (gEgo y:) 3))
					)
				)
				(if (not (IsFlag 259))
					(head setCel: 1)
					(yorick setLoop: 0 setCel: 0 stopUpd:)
				)
				(poof dispose:)
				(= cycles 1)
			)
			(4
				(if (> (gEgo x:) (yorick x:))
					(thingThrown
						setPri:
							(cond
								((> (gEgo y:) 138) 11)
								((> (gEgo y:) 115) 8)
								(else 7)
							)
						setMotion:
							JumpTo
							(- (gEgo x:) (Random 30 60))
							210
							self
					)
				else
					(thingThrown
						setMotion:
							JumpTo
							(+ (gEgo x:) (Random 30 60))
							210
							self
					)
				)
			)
			(5
				(thingThrown dispose:)
				(HandsOn)
				(ClearFlag 260)
				(NormalEgo)
				(LookAt gEgo yorick)
				(User canInput: 1)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(ClearFlag 271)
				(client setScript: 0)
			)
			(7
				(if (and (not (IsFlag 259)) (IsFlag 257))
					(head setCel: 3)
					(yorick setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				)
				(poof dispose:)
				(thingThrown dispose:)
				(User canInput: 1)
				(= cycles 2)
			)
			(8
				(HandsOn)
				(ClearFlag 271)
				(client setScript: 0)
			)
		)
	)
)

(instance talksAlot of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 43 188 self)
			)
			(1
				(gEgo loop: 2)
				(= cycles 2)
			)
			(2
				(HighPrint 96 98) ; "You bar the door behind you."
				(gEgo setMotion: MoveTo 43 179 self)
			)
			(3
				(gEgo illegalBits: $8000)
				(HighPrint 96 99) ; "You behold a most fascinating place."
				(HighPrint 96 100) ; "The person labeled "ME" speaks:"
				(HighPrint 96 101) ; "Abandon mope, all ye who enter here!"
				(HighPrint 96 102) ; "Job hunting, or just sight-seeing?"
				(HighPrint 96 103) ; "I foresee a brilliant future for you in the fall."
				(HighPrint 96 104) ; "If you've got something to say, then speak fast or forever hold your pieces."
				(HighPrint 96 105) ; "State your case before I case your estate!"
				(self cue:)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance knockOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 73 117 self)
			)
			(1
				(gEgo view: 296 setLoop: 7 setCel: 0)
				(= cycles 8)
			)
			(2
				(door3 setPri: (+ (gEgo priority:) 1) setCel: 1)
				(= cycles 2)
			)
			(3
				(door3 setPri: (- (door3 priority:) 1) setCel: 2)
				(gEgo setCel: 1)
				(= cycles 2)
				(if (not (IsFlag 259))
					(head setCel: 3)
					(yorick setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				)
			)
			(4
				(effect number: (SoundFX 85) loop: 1 priority: 2 play:)
				(door3 setCel: 3)
				(gEgo posn: 91 111 setCel: 2)
				(= cycles 2)
			)
			(5
				(door3 setCel: 4)
				(gEgo posn: 109 107 setCel: 3)
				(= cycles 2)
			)
			(6
				(door3 setCel: 5)
				(gEgo setPri: 7 posn: 126 119 setCel: 4)
				(= cycles 2)
			)
			(7
				(door3 setCel: 0 stopUpd:)
				(gEgo posn: 137 137)
				(= cycles 2)
			)
			(8
				(gEgo posn: 152 161)
				(= cycles 2)
			)
			(9
				(gEgo posn: 160 189)
				(if (not (TakeDamage 5))
					(EgoDead ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Keep up your strength and health and try again."
						96
						96
						80
						{You're the Fall Guy again}
						82
						517
						2
						5
					)
				else
					(= cycles 10)
				)
			)
			(10
				(ClearFlag 258)
				(ClearFlag 257)
				(SetFlag 260)
				(gEgo setScript: rollOut)
				(client setScript: 0)
			)
		)
	)
)

(instance pullChain of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 298 posn: 34 73 setLoop: 2 setCel: 0)
				(= cycles 3)
			)
			(1
				(gEgo setCel: 1)
				(chain setCel: 7)
				(= cycles 3)
			)
			(2
				(gEgo setCel: 0)
				(chain setCel: 6)
				(= cycles 3)
			)
			(3
				(gEgo setCel: 1)
				(chain setCel: 7)
				(= cycles 3)
			)
			(4
				(NormalEgo)
				(gEgo setPri: 7 loop: 0)
				(chain setCel: 6)
				(if (not (IsFlag 259))
					(SetFlag 259)
					(head dispose:)
					(yorick setLoop: 5)
				)
				(if (not (client cel:))
					(client setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance takeADive of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCycle: End self)
			)
			(1
				(if (not (IsFlag 259))
					(head dispose:)
				)
				(if (IsFlag 268)
					(HighPrint 96 106) ; "Elsa is right next door. I'll go set up the secret exit for your escape."
				)
				(yorick view: 298 setLoop: 1 setCel: 0)
				(= cycles 2)
			)
			(2
				(yorick setCel: 1)
				(= cycles 1)
			)
			(3
				(yorick setCel: 2)
				(= cycles 1)
			)
			(4
				(yorick setCel: 3 y: (- (yorick y:) 10))
				(= cycles 1)
			)
			(5
				(yorick setCel: 4 y: (- (yorick y:) 14))
				(= cycles 1)
			)
			(6
				(yorick dispose:)
				(client setCycle: Beg self)
			)
			(7
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance doorFall of Script
	(properties)

	(method (dispose)
		(gEgo illegalBits: (& (gEgo illegalBits:) $ffff))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: (| (gEgo illegalBits:) $0028))
				(++ local53)
				(door7 posn: (- (door7 x:) 1) (door7 y:))
				(= cycles 1)
			)
			(1
				(door7 posn: (+ (door7 x:) 1) (door7 y:))
				(= cycles 1)
			)
			(2
				(if (< local53 7)
					(self changeState: 0)
				else
					(= local53 0)
					(self cue:)
				)
			)
			(3
				(behindDoor7 ignoreActors: setPri: 4 init: stopUpd:)
				(cond
					(
						(and
							(== (gEgo onControl: 1) 4096)
							(not (gEgo script:))
						)
						(HandsOff)
						(gEgo hide:)
						(door7 setLoop: 7 setCel: 8)
						(= cycles 1)
					)
					((trap1 script:)
						(door7 setCel: 0 stopUpd:)
						(behindDoor7 delete:)
						(client setScript: 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(door7
					setLoop: 1
					cel: (if (== (gEgo onControl: 1) 4096) 2 else 0)
					setCycle: End self
				)
			)
			(5
				(effect number: (SoundFX 84) loop: 1 priority: 2 play:)
				(if
					(and
						(== (gEgo onControl: 1) 4096)
						(not (gEgo script:))
					)
					(= cycles 15)
				else
					(self changeState: 12)
				)
			)
			(6
				(if (TakeDamage 10)
					(if (== (gEgo onControl: 1) 4096)
						(door7 setCycle: CT 2 -1 self)
					else
						(door7 setCycle: CT 1 -1 self)
					)
				else
					(EgoDead ; "This time the joke fell flat. That was a truly dirty trick. Too bad you won't have a chance to get even...or will you?"
						96
						107
						82
						516
						5
						8
						80
						{This way to the Egress}
					)
				)
			)
			(7
				(if (== (gEgo onControl: 1) 4096)
					(door7 setLoop: 7 setCel: 8)
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(8
				(door7 setLoop: 1 setCel: 0)
				(gEgo
					view: 538
					setLoop: 0
					cel: 0
					illegalBits: 0
					posn: 106 95
					show:
				)
				(behindDoor7 dispose:)
				(= cycles 5)
			)
			(9
				(gEgo setCycle: End setMotion: MoveTo 97 (+ (gEgo y:) 6))
				(= cycles 15)
			)
			(10
				(gEgo
					view: 503
					setLoop: 4
					cel: 0
					x: (- (gEgo x:) 4)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(11
				(HighPrint 96 108) ; "What a miserable experience!"
				(self cue:)
			)
			(12
				(gEgo setLoop: 2)
				(if (not (gEgo script:))
					(NormalEgo)
				)
				(= cycles 3)
			)
			(13
				(door7 stopUpd:)
				(if (!= (door7 cel:) 0)
					(SetFlag 264)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance finalExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 257)
				(behindDoor7 setCel: 1)
				(= cycles 2)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 109 98 self)
			)
			(2
				(gEgo setPri: 3 setMotion: MoveTo 118 92 self)
			)
			(3
				(ClearFlag 257)
				(gCurRoom newRoom: 97)
			)
		)
	)
)

(instance brickWall of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo y:) 103)
					(gEgo
						setLoop: 3
						setCycle: Rev
						setMotion: MoveTo (+ (gEgo x:) 5) 103 self
					)
				else
					(self cue:)
				)
			)
			(1
				(NormalEgo)
				(behindDoor11 init:)
				(door11 setCycle: End self)
			)
			(2
				(HighPrint 96 109) ; "Oops! You thought this door led SOMEWHERE!"
				(= cycles 4)
			)
			(3
				(door11 setCycle: Beg self)
			)
			(4
				(behindDoor11 dispose:)
				(door11 stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance fallSideways of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 259))
					(head setCel: 3)
					(yorick setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				)
				(gEgo
					view: 517
					setLoop: (if (IsFlag 258) 3 else 2)
					x:
						(if (IsFlag 258)
							(- (gEgo x:) 10)
						else
							(+ (gEgo x:) 10)
						)
					cel: 0
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
				(if (== client trap3)
					(gEgo setMotion: MoveTo (+ (gEgo x:) 12) (gEgo y:))
				)
			)
			(1
				(effect number: (SoundFX 9) loop: 1 priority: 2 play:)
				(gEgo
					setPri: (- (gEgo priority:) 1)
					yStep: 10
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Keep up your strength and health and try again."
						96
						96
						80
						{You're the Fall Guy again}
						82
						517
						2
						5
					)
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: rollOut)
						(client setCel: 0 setScript: 0)
					else
						(gEgo setScript: rollOut)
					)
				)
			)
		)
	)
)

(instance trapFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCel: 1)
				(if (!= client trap3)
					(client setPri: (- (client priority:) 1))
				)
				(= cycles 1)
			)
			(1
				(if (== client trap4)
					(SetFlag 270)
					(self dispose:)
				else
					(client setScript: fallSideways)
				)
			)
		)
	)
)

