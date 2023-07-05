;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use LoadMany)
(use Wander)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm96 0
	trap1 1
	trap2 2
	trap3 3
	trap4 4
	yorick 5
	head 6
	door3 7
	door7 8
	door11 9
	door12 10
	door13 11
	behindDoor7 12
	behindDoor11 13
	chain 14
	arrow 15
	effect 16
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
)

(procedure (localproc_0)
	(if (IsFlag 259)
		(HighPrint 96 0) ; "It looks like the talking is over."
	else
		(HighPrint 96 1) ; "No more talking, my friend. Let's have fun!"
	)
)

(procedure (localproc_1 &tmp temp0)
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
					(self setScript: (ScriptID 229 0)) ; throwIt
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
				(arrow setScript: (ScriptID 231 1)) ; takeADive
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'cast')
				(if (gEgo script:)
					(HighPrint 96 2) ; "Now??"
				else
					(HighPrint 96 3) ; ""ME" sees you preparing your spell and..."
					(arrow setScript: (ScriptID 231 1)) ; takeADive
				)
			)
			((Said 'throw>')
				(cond
					((gEgo script:)
						(HighPrint 96 4) ; "You're too busy."
						(event claimed: 1)
					)
					((Said '/dagger,boulder')
						(HighPrint 96 5) ; ""ME" sees you preparing to throw and..."
						(arrow setScript: (ScriptID 231 1)) ; takeADive
					)
					(else
						(HighPrint 96 6) ; "Why would you want to throw that?"
						(event claimed: 1)
					)
				)
			)
			((Said 'talk>')
				(cond
					((IsFlag 267)
						(localproc_0)
						(event claimed: 1)
					)
					((Said '/yorick')
						(if (not (IsFlag 268))
							(SolvePuzzle 708 2)
							(SetFlag 268)
							(HighPrint 96 7) ; "You know me? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
						else
							(HighPrint 96 8) ; "Be more specific, my friend."
						)
					)
					((Said '/man,warlock,mage,bandit')
						(HighPrint 96 9) ; "Talking is a speciality of those who know not what they talk about."
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
								(HighPrint 96 10) ; "You know Elsa? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
								(HighPrint 96 11) ; "After you have explained what you know about Elsa, Yorick speaks:"
							)
							(HighPrint 96 12) ; "It's about time that someone else helped Elsa before it's too late! Toro and I are the only friends she's got here."
							(HighPrint 96 13) ; "She's a lot like her dad, though. She organized these brigands and changed them from mere thugs to major raiders!"
							(HighPrint 96 14) ; "She plans to move the entire band away from the valley as soon as the snow clears. If that happens, I know she will never be disenchanted."
						)
						((Said '//enchantment,disenchantment,spell,curse')
							(if (not (IsFlag 268))
								(SetFlag 268)
								(HighPrint 96 15) ; "You know about the enchantment? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
							)
							(HighPrint 96 16) ; "Elsa doesn't know who she really is. That's part of the enchantment."
							(HighPrint 96 17) ; "When Elsa was left with some brigands ten years ago, all her memories were taken away from her."
							(HighPrint 96 18) ; "I borrowed a Magic Mirror from a friend to try to break the spell, but it only works when spells are cast directly at you."
							(HighPrint 96 19) ; "If you're going to be the big Hero, I hope you brought a Dispel Potion or something."
						)
						((Said '//yorick')
							(if (not (IsFlag 268))
								(SetFlag 268)
								(HighPrint 96 7) ; "You know me? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
							)
							(HighPrint 96 20) ; "Alas, poor Yorick! I know me well."
							(HighPrint 96 21) ; "Ten years ago, I swore I would find Elsa no matter what. It took me two years to find her, here with the brigands, and I've posed as her warlock ever since."
							(HighPrint 96 22) ; "I couldn't break the spell on her, nor could I leave her to grow up into an attractive woman surrounded by rogues and scoundrels."
							(HighPrint 96 23) ; "Someone had to defend her honor!"
						)
						((Said '//me')
							(HighPrint 96 24) ; "Can't you see that I am he? I try to inspire (before they expire) a sense of awe and majesty in those that enter here."
							(HighPrint 96 25) ; "After all, I am the Brigand Warlock. One has to keep up one's appearances, or appear to keep up with one's peers."
						)
						((Said '//warlock,caravan')
							(HighPrint 96 26) ; "Everybody needs to know a few magic tricks to get by these days. You'd be surprised how effective Sleeping Powder is for taking out the guards of a caravan."
						)
						((Said '//powder,banana,trick')
							(HighPrint 96 27) ; "You snooze, you lose. And my banana trick has appeal of its own."
						)
						((Said '//jester')
							(HighPrint 96 28) ; "For thirty years I was the Court Jester. Now I jest enjoy watching other people take the pratfalls."
						)
						((Said '//leader[<bandit,your,about]')
							(HighPrint 96 29) ; "I'll protect the Brigand Leader with everything I've got. That's no laughing matter as I get madder."
						)
						((Said '//potion<disenchant')
							(if (not (IsFlag 268))
								(SetFlag 268)
								(HighPrint 96 15) ; "You know about the enchantment? Then perhaps you have come to help. Perhaps you are able to take the child from the band."
							)
							(HighPrint 96 30) ; "The true Dispel Potion will break an enchantment. You must splash the potion on Elsa as soon as you can, or she'll skewer you for sure. She's more than a match for old "Swordy Lordy" now!"
						)
						((Said '//potion')
							(= local9 0)
							(HighPrint 96 31) ; "Of which potion do you speak?"
						)
						((Said '//swordy,lordy')
							(HighPrint 96 32) ; "You must know the "Blade Braggart". He used to show off in the castle courtyard all the time."
							(HighPrint 96 33) ; "Elsa once asked if "Rapier Ruler" would teach her to use the sword, and the "Sword Bore" told her he would not waste his talent on females."
							(HighPrint 96 34) ; "She came to me in tears. After all, she was only nine at the time."
							(HighPrint 96 35) ; "She can teach old "Weapon Windbag" a thing or two now! Her arm is true, and she's truly disarming."
						)
						((Said '//done,door')
							(HighPrint 96 36) ; "There are plenty of doors. You wouldn't want me to spoil your fun, now!"
							(HighPrint 96 37) ; "Either you'll figure it out in the end, or you'll end it before you're out."
						)
						((Said '//room,maze,path,aisle')
							(HighPrint 96 38) ; "This room is my way of keeping the brigands from bothering the Leader about raises, since it tends to raze the brigands."
							(HighPrint 96 39) ; "I designed it myself! This place has people rolling in the aisles."
						)
						((Said '//leer,(mirror[<magic,leer,about])')
							(HighPrint 96 40) ; "Ah yes, the "Mirror with the Leer", as Erasmus calls it (or was it Fenrus?). It reflects a spell back on the caster of the spell."
							(HighPrint 96 41) ; "The Warlock ruminates: "Now where did I put that mirror... was it on the desk in Elsa's office?""
						)
						((Said '//bull,toro,bull')
							(HighPrint 96 42) ; "Toro is the minotaur that guards this fortress. Elsa found him when he was just a calf, and he's kowtowed to her ever since."
							(HighPrint 96 43) ; "He guarantees that the brigands won't give Elsa any bull.""
						)
						((Said '//castle')
							(HighPrint 96 44) ; "This fort is the brigand's palace. It has been well-constructed."
						)
						((Said '//baron,(dad[<leader,elsa,about])')
							(HighPrint 96 45) ; "Would he be surprised to see his little girl now!"
						)
						((Said '//*')
							(= local9 0)
							(if (IsFlag 268)
								(HighPrint 96 46) ; "If you have business to do, then get busy doing your business."
							else
								(switch (Random 0 3)
									(0
										(HighPrint 96 47) ; "Can't you see that's nothing to me? You'd better flee."
									)
									(1
										(HighPrint 96 48) ; "The brigands will come to spoil your fun. You'll be undone."
									)
									(2
										(HighPrint 96 49) ; "The brigands tend to hold a grudge, and they won't begrudge to tend to you."
									)
									(3
										(HighPrint 96 50) ; "If you have any famous last statements, you'd better say the secret word, or you'll lament your last state."
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
					(self setScript: (ScriptID 228 1)) ; goTo6
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
			(gEgo
				setPri: (+ (gEgo priority:) 1)
				setScript: (ScriptID 234 0) ; fallSideways
			)
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
			(self setScript: (ScriptID 225 0)) ; fallUpscreen
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
		(LoadMany rsVIEW 297 298 96 296 536 537 517 538 516)
		(LoadMany rsSCRIPT 969 991 972 970 225 226 227 228 229 230 231 232 233 234)
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
		(localproc_1)
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
		(gEgo posn: 43 198 init: setScript: (ScriptID 230 0)) ; talksAlot
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
					(trap1 setScript: (ScriptID 234 1)) ; trapFall
				)
				(512
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(trap2 setScript: (ScriptID 234 1)) ; trapFall
				)
				(64
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(gEgo setPri: (+ (gEgo priority:) 1))
					(trap3 setScript: (ScriptID 234 1)) ; trapFall
				)
				(128
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(trap3 setScript: (ScriptID 234 1)) ; trapFall
				)
				(2048
					(SetFlag 256)
					(if local6
						(= local5 1)
					)
					(trap4 setScript: (ScriptID 234 1)) ; trapFall
				)
				(4
					(if local6
						(= local5 1)
					)
					(gEgo setScript: (ScriptID 225 0)) ; fallUpscreen
				)
				(2
					(if local6
						(= local5 1)
					)
					(gEgo setScript: (ScriptID 225 1)) ; fallDownscreen
				)
				(16
					(SetFlag 258)
					(if local6
						(= local5 1)
					)
					(if (> (gEgo y:) 107)
						(gEgo setScript: (ScriptID 234 0)) ; fallSideways
					else
						(gEgo setScript: (ScriptID 225 1)) ; fallDownscreen
					)
				)
				(8
					(if local6
						(= local5 1)
					)
					(if (> (gEgo y:) 107)
						(gEgo setScript: (ScriptID 234 0)) ; fallSideways
					else
						(gEgo setScript: (ScriptID 225 1)) ; fallDownscreen
					)
				)
				(else
					(ClearFlag 257)
				)
			)
		)
		(if (and (not (IsFlag 263)) (not (IsFlag 257)))
			(cond
				((== (gEgo edgeHit:) 2)
					(if (not (IsFlag 260))
						(SetFlag 263)
						(gEgo setScript: (ScriptID 228 0)) ; goTo2
					)
				)
				((and (== (gEgo edgeHit:) 4) (< (gEgo y:) 150))
					(SetFlag 263)
					(if (< (gEgo y:) 100)
						(gEgo setPri: -1 setScript: (ScriptID 228 3)) ; goTo15
					else
						(if local6
							(= local5 1)
						)
						(gEgo setScript: (ScriptID 228 2)) ; goTo12
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
					(Said 'look/chandelier,firefly,fly,bowl,globe')
					(MouseClaimed globe event 3)
				)
				(HighPrint 96 51) ; "It IS! It's a bowl of fireflies, used as a light source. What won't they think of next?"
			)
			(
				(or
					(Said 'look/man,yorick,warlock,bandit,me')
					(and (MouseClaimed head event 3) (not (MouseClaimed arrow event 3)))
					(MouseClaimed yorick event 3)
				)
				(HighPrint 96 52) ; "It's "ME"."
			)
			((or (MouseClaimed arrow event 3) (MouseClaimed MESign event 3))
				(HighPrint 96 53) ; "The arrow points to "ME"."
			)
			((MouseClaimed Door1 event 3)
				(HighPrint 96 54) ; "It's an entrance...or is it an exit?"
			)
			((MouseClaimed Door6 event 3)
				(HighPrint 96 55) ; "It's an exit...or is it an entrance?"
			)
			((MouseClaimed Door2 event 3)
				(HighPrint 96 56) ; "The attic exit?"
			)
			((MouseClaimed doorSign event 3)
				(HighPrint 96 57) ; "The arrow points to a door. Who could've guessed?"
			)
			((MouseClaimed secretSign event 3)
				(HighPrint 96 58) ; "The arrow points to a door. How secret is that?"
			)
			((or (Said 'look/entrance,done') (MouseClaimed exitSign event 3))
				(HighPrint 96 59) ; "A sign points to a door. The egress?"
			)
			((MouseClaimed door11 event 3)
				(HighPrint 96 60) ; "It's another door!"
			)
			((MouseClaimed door7 event 3)
				(HighPrint 96 61) ; "It looks like a picture of an upside-down door painted on the wall."
			)
			((or (Said 'look/button') (MouseClaimed littleButton event 3))
				(HighPrint 96 62) ; "Engraved on the button are the words: "PUSH ME"."
			)
			((or (Said 'look/box') (MouseClaimed door3 event 3))
				(HighPrint 96 63) ; "It's a box of some sort...or so the sign says. There is a button next to the box."
			)
			((MouseClaimed door12 event 3)
				(HighPrint 96 64) ; "A pet door? It's shorter than you are."
			)
			((MouseClaimed littleSign event 3)
				(if (and (== (gEgo onControl: 1) 256) (> (gEgo x:) 100))
					(door13 setScript: (ScriptID 227 0)) ; happyFace
				else
					(HighPrint 96 65) ; "It's a sign, but you'll have to be closer to read it."
				)
			)
			((or (Said 'look/ladder') (MouseClaimed trap4 event 3))
				(HighPrint 96 66) ; "Stairs lead up to the platform on which "ME" is located."
			)
			((or (Said 'look/face[<happy]') (MouseClaimed door13 event 3))
				(HighPrint 96 67) ; "Have a nice day!"
			)
			((or (Said 'look/dot[<polka]') (MouseClaimed polkaDots event 3))
				(HighPrint 96 68) ; "It reminds you of a tie you once received as a present on All-Fools Day."
			)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,read/sign')
						(if
							(and
								(== (gEgo onControl: 1) 256)
								(> (gEgo x:) 100)
							)
							(door13 setScript: (ScriptID 227 0)) ; happyFace
						else
							(HighPrint 96 69) ; "DOOR" "SECRET ENTRANCE" "EXIT" "ME" "BOX"
						)
					)
					((Said 'look>')
						(cond
							((or (Said '<up') (Said '/ceiling,ladder'))
								(HighPrint 96 70) ; "There appear to be stairs leading up (?) to nowhere. There is also what looks like a bowl full of fireflies."
							)
							(
								(or
									(Said '<down')
									(Said '/ground,floor,pit,aisle')
								)
								(HighPrint 96 71) ; "There is a deep pit with a walkway winding above it."
							)
							((Said '/wall')
								(HighPrint 96 72) ; "Wow!"
							)
							((Said '/chain,rope,handle')
								(HighPrint 96 73) ; "In the "upstairs" doorway, there is a chain with a handle attached."
							)
							((Said '/arrow')
								(HighPrint 96 74) ; "The arrows point to various orifices."
							)
						)
					)
					((Said 'get/me/leader')
						(HighPrint 96 75) ; "Take yourself there."
					)
					((Said 'rest')
						(HighPrint 96 76) ; "With the Brigands pounding at the door, you decide not to rest until you're safe."
					)
					((Said 'cast')
						(HighPrint 96 77) ; "Your magic has no effect. It must be something about this room."
					)
					((Said 'throw')
						(HighPrint 96 78) ; "It would serve no purpose."
					)
					((Said 'nap')
						(EgoDead 96 79 82 800 0 0 80 {He who hesitates...}) ; "You curl up for a nice little nap. The brigands break down the door. You wake up dead."
					)
					((Said 'force/button,door,box')
						(if (gEgo inRect: 31 107 86 125)
							(SetFlag 257)
							(door3 setScript: (ScriptID 230 1)) ; knockout
						else
							(HighPrint 96 80) ; "Get closer."
						)
					)
					((Said 'pull[/chain,rope,handle]')
						(if (== (gEgo onControl: 1) 8192)
							(= local6 1)
							(= local5 200)
							(door11 setScript: (ScriptID 231 0)) ; pullChain
						else
							(HighPrint 96 81) ; "You can't do that from where you're standing."
						)
					)
					((Said 'open,unbar,unlock[/door]')
						(cond
							((gEgo inRect: 10 150 120 189)
								(HighPrint 96 82) ; "You dare not unbar the door. You hear hordes of brigands massing beyond it."
							)
							((== (gEgo onControl: 1) 4096)
								(if (IsFlag 264)
									(gEgo setScript: (ScriptID 232 1)) ; finalExit
								else
									(User canInput: 0)
									(door7 setScript: (ScriptID 232 0)) ; doorFall
								)
							)
							((== (gEgo onControl: 1) 1024)
								(door11 setScript: (ScriptID 233 0)) ; brickWall
							)
							(else
								(HighPrint 96 83) ; "You can't do it."
							)
						)
					)
					((Said 'unlock')
						(HighPrint 96 84) ; "Nothing is locked."
					)
				)
			)
		)
	)
)

