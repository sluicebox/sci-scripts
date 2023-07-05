;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 311)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm311 0
	wolfgangTalker 1
)

(local
	[local0 7] = [0 -33 -45 -26 -53 -51 999]
	[local7 6] = [0 15 -42 -20 -58 999]
	[local13 3] = [0 40 999]
	[local16 7] = [0 19 52 -27 -17 21 999]
	[local23 6] = [0 44 29 61 -56 999]
	[local29 3] = [0 -47 999]
	[local32 9] = [0 57 59 46 31 41 38 49 999]
	[local41 8] = [0 37 30 -54 18 22 -39 999]
	[local49 5] = [0 48 35 23 999]
	[local54 3] = [0 62 999]
	[local57 3] = [0 36 999]
	[local60 8] = [0 28 -16 43 60 25 -50 999]
	[local68 3] = [0 55 999]
	[local71 3] = [0 34 999]
	[local74 3] = [0 24 999]
	[local77 3] = [0 32 999]
	[local80 3] = [0 32 999]
	[local83 19]
	[local102 520] = [0 -33 -45 -26 -53 -51 -42 -56 -20 -27 -17 -58 -16 -50 -39 -54 -47 999 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	local622
	local623
	local624
	local625
	local626
	local627
	local628
	local629
	local630
)

(procedure (localproc_0)
	(gMessager say: 12) ; "This Adventurer's Guild Hall reminds you of the one in your home town. The traditional Moose head and other stuffed monsters (Saurus, Troll, Gryphon, Dragon, Cheetaur, and the terrible Antwerp) adorn the walls."
)

(instance rm311 of Rm
	(properties
		noun 12
		picture 311
		style 2
		east 310
	)

	(method (init)
		(= [local83 0] @local0)
		(= [local83 1] @local7)
		(= [local83 2] @local13)
		(= [local83 3] @local16)
		(= [local83 4] @local23)
		(= [local83 5] @local29)
		(= [local83 6] @local32)
		(= [local83 7] @local41)
		(= [local83 8] @local49)
		(= [local83 9] @local54)
		(= [local83 10] @local57)
		(= [local83 11] @local60)
		(= [local83 12] @local68)
		(= [local83 13] @local71)
		(= [local83 14] @local74)
		(= [local83 15] @local77)
		(= [local83 16] @local80)
		(= [local83 17] 999)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 143 145 113 114 121 106 139 80 148 43 129 3 139 3 185 319 185 319 189 0 189 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 200 158 173 173 86 158 123 144
					yourself:
				)
		)
		(LoadMany rsVIEW 311 312)
		(= local628 0)
		(if gNight
			(aWindow init:)
		)
		(book init:)
		(desk init: approachVerbs: 4) ; Do
		(noteSign init:)
		(theWindow init:)
		(smallWindow init:)
		(gFeatures
			add:
				gryphon
				wood
				armor
				saurusHead
				mooseHead
				antwerpHead
				cheetaurHead
				trollHead
				dragonHead
				painting
				wallOfStuff
			eachElementDo: #init
		)
		(super init: &rest)
		(self setRegions: 801) ; Town
		(theCandles init: setCycle: Fwd)
		(chair init: setPri: 5)
		(masterTeller init: master @local0 @local83 @local102)
		(master
			init:
			actions: masterTeller
			setLoop: 2
			setPri: 6
			posn: 76 137
			setScript: sMaster
		)
		(theFire init: setCycle: Fwd)
		(snore init:)
		(NormalEgo)
		(if (== gPrevRoomNum 318)
			(gEgo init: posn: 164 119 loop: 3)
			(HandsOn)
		else
			(gLongSong number: 110 loop: -1 init: play:)
			(gEgo init: setLoop: 1 posn: 276 148)
			(NormalEgo)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12) ; "This Adventurer's Guild Hall reminds you of the one in your home town. The traditional Moose head and other stuffed monsters (Saurus, Troll, Gryphon, Dragon, Cheetaur, and the terrible Antwerp) adorn the walls."
			)
			(4 ; Do
				(gMessager say: 12 4) ; "There is nothing here that you need, and the Guild Master may be more aware than he seems."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(gEgo inRect: 64 120 126 162)
					(== local625 0)
					(== (master script:) sMaster)
				)
				(master setScript: upAndAtIm)
			)
			((and (not (gEgo inRect: 64 120 126 162)) (== local625 1))
				(masterHead ignoreActors: posn: 101 104 show:)
				(master setScript: sMaster)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 91)
		(super dispose:)
	)
)

(instance smallWindow of Feature
	(properties
		x 81
		y 92
		noun 14
		nsTop 82
		nsLeft 77
		nsBottom 89
		nsRight 86
		sightAngle 40
		approachX 119
		approachY 119
	)
)

(instance gryphon of Feature
	(properties
		x 116
		y 103
		z 65
		noun 9
		nsTop 23
		nsLeft 101
		nsBottom 54
		nsRight 131
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1) ; "This crossbreed of eagle and lion could have torn a man apart when it was alive."
			)
			(4 ; Do
				(gMessager say: 12 4 7) ; "The Guild Hall would be barren if you took the trophies. Besides, they're out of reach."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wood of Feature
	(properties
		x 289
		y 123
		noun 19
		nsTop 114
		nsLeft 269
		nsBottom 133
		nsRight 309
		sightAngle 40
	)
)

(instance desk of Feature
	(properties
		x 148
		y 148
		noun 6
		nsTop 130
		nsLeft 98
		nsBottom 167
		nsRight 198
		sightAngle 40
		approachX 149
		approachY 167
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch (Random 1 2)
					(1
						(gMessager say: 6 1 5) ; "On the table is an old but ornate leather-bound book. There is also a quill pen in the ink bottle."
					)
					(2
						(gMessager say: 6 1 6) ; "The table holds a pen, an inkwell, and the Adventurer's Guild Registration and Log Book."
					)
				)
			)
			(4 ; Do
				(gMessager say: 6 4) ; "The table is formed from fine fir wood. There's nothing you need here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book of Feature
	(properties
		x 163
		y 243
		z 100
		heading 360
		noun 3
		onMeCheck 2
		approachX 149
		approachY 167
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: signTheBook)
			)
			(1 ; Look
				(gEgo setScript: youGotPoints)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance noteSign of Feature
	(properties
		x 164
		y 110
		z 27
		nsTop 72
		nsLeft 151
		nsBottom 94
		nsRight 178
		sightAngle 40
		approachX 164
		approachY 119
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(gEgo setScript: goToBoard)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance armor of Feature
	(properties
		x 126
		y 90
		noun 2
		nsTop 71
		nsLeft 118
		nsBottom 109
		nsRight 135
		sightAngle 40
	)
)

(instance antwerpHead of Feature
	(properties
		x 295
		y 127
		z 67
		noun 1
		nsTop 48
		nsLeft 286
		nsBottom 72
		nsRight 305
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 12 4 7) ; "The Guild Hall would be barren if you took the trophies. Besides, they're out of reach."
			)
			(1 ; Look
				(gMessager say: 1 1) ; "This is certainly a weird one! You've never seen anything quite like it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		x 58
		y 90
		z 60
		noun 17
		nsTop 23
		nsLeft 58
		nsBottom 94
		nsRight 93
		sightAngle 40
		approachX 119
		approachY 119
	)
)

(instance saurusHead of Feature
	(properties
		x 52
		y 124
		z 54
		noun 13
		nsTop 62
		nsLeft 44
		nsBottom 79
		nsRight 61
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 13 1) ; "You never saw a purple Saurus before you came to Spielburg, but it looks like a really stupid monster."
			)
			(4 ; Do
				(gMessager say: 12 4 7) ; "The Guild Hall would be barren if you took the trophies. Besides, they're out of reach."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mooseHead of Feature
	(properties
		x 54
		y 122
		z 86
		noun 10
		nsTop 24
		nsLeft 42
		nsBottom 48
		nsRight 66
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 12 4 7) ; "The Guild Hall would be barren if you took the trophies. Besides, they're out of reach."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trollHead of Feature
	(properties
		x 199
		y 115
		z 78
		noun 15
		nsTop 29
		nsLeft 191
		nsBottom 46
		nsRight 207
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 15 1) ; "It looks like it must have been a particularly nasty Troll. You wouldn't want to meet him in a dark forest."
			)
			(4 ; Do
				(gMessager say: 12 4 7) ; "The Guild Hall would be barren if you took the trophies. Besides, they're out of reach."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dragonHead of Feature
	(properties
		x 223
		y 115
		z 92
		noun 7
		nsTop 7
		nsLeft 205
		nsBottom 39
		nsRight 241
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1) ; "Even in death, this monster remains awesome."
			)
			(4 ; Do
				(gMessager say: 12 4 7) ; "The Guild Hall would be barren if you took the trophies. Besides, they're out of reach."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cheetaurHead of Feature
	(properties
		x 267
		y 120
		z 83
		noun 5
		nsTop 26
		nsLeft 259
		nsBottom 48
		nsRight 275
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1) ; "The head is like a panther's, but with a strong human-like quality. It is still rather frightening."
			)
			(4 ; Do
				(gMessager say: 12 4 7) ; "The Guild Hall would be barren if you took the trophies. Besides, they're out of reach."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance painting of Feature
	(properties
		x 13
		y 130
		z 67
		noun 11
		nsTop 26
		nsBottom 100
		nsRight 27
		sightAngle 40
	)
)

(instance wallOfStuff of Feature
	(properties
		x 159
		y 33
		noun 16
		nsTop 33
		nsBottom 94
		nsRight 319
		sightAngle 40
	)
)

(instance aWindow of View
	(properties
		x 53
		y 97
		noun 17
		approachX 119
		approachY 119
		view 311
		loop 5
	)
)

(instance chair of View
	(properties
		x 83
		y 130
		noun 18
		view 312
		loop 4
		cel 1
	)

	(method (doVerb)
		(master doVerb: &rest)
	)
)

(instance theFire of Prop
	(properties
		x 239
		y 121
		noun 8
		view 311
		loop 1
		cycleSpeed 8
	)
)

(instance theCandles of Prop
	(properties
		x 157
		y 47
		noun 4
		view 311
		loop 4
		cycleSpeed 12
	)
)

(instance masterHead of Prop
	(properties
		x 98
		y 104
		noun 18
		view 312
		loop 5
		priority 7
		signal 16400
	)

	(method (doVerb)
		(master doVerb: &rest)
	)
)

(instance master of Prop
	(properties
		noun 18
		view 312
	)

	(method (init &tmp temp0)
		(= global451 1311)
		(PalVary pvCHANGE_TARGET 1311)
		(AssertPalette 311)
		(super init:)
		(self posn: 76 137 ignoreActors: startUpd:)
		(masterHead init:)
	)
)

(instance masterTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 18 1) ; "It looks like this old Guild Master doesn't do too much adventuring any more. Still, he looks like he was plenty tough in his day, and he probably has many a tale to tell."
			)
			(4 ; Do
				(HandsOff)
				(gEgo setScript: goToMaster)
			)
			(2 ; Talk
				(if (not (gEgo inRect: 64 120 126 162))
					(gMessager say: 18 2 63) ; "The guildmaster appears to be hard of hearing. Perhaps you should get closer."
				else
					(if (not local627)
						(switch (Random 0 4)
							(0
								(gMessager say: 18 2 64) ; "Ach, I was so busy I did not notice you come into the Adventurer's Guild Hall. Welcome, welcome, it is so seldom we have new adventurers here. Most people think this valley is cursed."
							)
							(1
								(gMessager say: 18 2 65) ; "Hrrmph! Ahem! Yes, as I was saying... Where were we?"
							)
							(2
								(gMessager say: 18 2 66) ; "Oh, what a glorious day it was! I... Oh, hello there."
							)
							(3
								(gMessager say: 18 2 67) ; "Then she turned around and I was staring into the biggest... Oh, it's you, my friend."
							)
							(4
								(gMessager say: 18 2 68) ; "It was just yesterday that I drew my sword and started out... Or was that the day before? No, then last week... Why, What was I talking about?"
							)
						)
					else
						(SolvePuzzle 725 1)
						(super doVerb: theVerb)
					)
					(= local627 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance sMaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local622 5)
				(= local625 0)
				(masterHead setLoop: 5 setCel: 0 ignoreActors:)
				(master setLoop: 1 setCel: 0)
				(= ticks (Random 30 90))
			)
			(1
				(if (not (IsFlag 91))
					(SetFlag 91)
					(localproc_0)
				)
				(masterHead cel: 1)
				(= ticks 6)
			)
			(2
				(masterHead cel: 2)
				(= ticks 6)
			)
			(3
				(snore play:)
				(masterHead cel: 3)
				(= ticks 6)
			)
			(4
				(masterHead cel: 1)
				(= ticks 6)
			)
			(5
				(masterHead cel: 0)
				(-- local622)
				(= ticks 6)
			)
			(6
				(if (> local622 0)
					(self changeState: 4)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance upAndAtIm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 18 0 13 1 self) ; "ZZZZZZZZZZZZZZZZ."
			)
			(1
				(if (and (== (gEgo x:) 70) (== (gEgo y:) 145))
					(self changeState: 3)
				else
					(gEgo
						ignoreControl: -32768
						setMotion: PolyPath 50 145 self
					)
				)
			)
			(2
				(gEgo setMotion: PolyPath 70 145 self)
			)
			(3
				(masterHead hide:)
				(master
					setLoop: 2
					cel: 0
					posn: 80 135
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(4
				(master setCycle: CT 4 -1 self)
			)
			(5
				(master setLoop: 3 cel: 0 posn: 80 137)
				(self cue:)
			)
			(6
				(HandsOn)
				(if local624
					(switch (Random 21 25)
						(21
							(gMessager say: 18 0 8 1 self) ; "Welcome back! It is good to see you again. So many adventurers never return. Someday, you and I will go on an adventure together."
						)
						(22
							(gMessager say: 18 0 9 1 self) ; "Hrrmph! Ahem! Yes, as I was saying... Where were we?"
						)
						(23
							(gMessager say: 18 0 10 1 self) ; "Oh, what a glorious day it was! I... Oh, hello there!"
						)
						(24
							(gMessager say: 18 0 11 1 self) ; "You fiendish witch! I will have you... Oh, it's you, my friend!"
						)
						(25
							(gMessager say: 18 0 12 1 self) ; "Oh, Barnard, bravest of the brave, you cannot be gone from us so soon... What? What? You're still here, my fellow adventurer?"
						)
					)
				else
					(= local624 1)
					(gMessager say: 18 0 14 1 self) ; "Ach! I was so busy I didn't notice you come in. Welcome, welcome! It is so seldom that we have new adventurers here. Most people think this valley is cursed!"
				)
				(= local625 1)
				(= local623 (Random 2 6))
			)
			(7
				(master setCycle: End self)
			)
			(8
				(master setCycle: Beg self)
			)
			(9
				(if (> local623 0)
					(-- local623)
					(self changeState: 7)
				else
					(= ticks (Random 30 60))
				)
			)
			(10
				(= local623 (Random 2 6))
				(self changeState: 7)
			)
			(11
				(= local625 0)
				(master
					setLoop: 2
					cel: 6
					posn: 80 135
					ignoreActors:
					setCycle: Beg self
				)
			)
			(12
				(master setLoop: 1 cel: 0 posn: 76 137 setScript: sMaster)
				(masterHead ignoreActors: posn: 101 104 show:)
				(self start: 0 dispose:)
			)
		)
	)
)

(instance signTheBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(HandsOff)
				(self cue:)
			)
			(1
				(gEgo setMotion: PolyPath 149 167 self)
			)
			(2
				(gEgo setHeading: 360)
				(= ticks 120)
			)
			(3
				(if (IsFlag 127)
					(gMessager say: 3 4 1 1 self) ; "But you've already done that!"
				else
					(gMessager say: 3 4 0 1 self) ; "You sign your name into the Adventurer's Log Book with a flourish."
				)
			)
			(4
				(SolvePuzzle 724 1)
				(SetFlag 127)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance youGotPoints of Script
	(properties)

	(method (changeState newState &tmp [temp0 300] [temp300 350])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (not (IsFlag 127)) (not local629))
					(= local629 1)
					(= local628 1)
				)
				(SolvePuzzle 723 4)
				(= ticks 60)
			)
			(1
				(gEgo setMotion: PolyPath 149 167 self)
			)
			(2
				(gEgo setHeading: 360)
				(= ticks 120)
			)
			(3
				(switch (++ local628)
					(1
						(Message msgGET 311 3 1 1 1 @temp0) ; "The writing on this page is very recent. It says "I, %s, have come to Spielburg to become a hero.""
						(Print
							font: gUserFont
							mode: 1
							width: 260
							addTextF: @temp300 @temp0 @global428
							init:
						)
						(HandsOn)
						(self dispose:)
					)
					(2
						(gMessager say: 3 1 2) ; "This entry was made several years ago. It says: 'Baronet Barnard von Spielburg killed a Troll near the Flying Falls on this 23rd day of Octember'."
						(HandsOn)
						(self dispose:)
					)
					(3
						(gMessager say: 3 1 3) ; "The other pages record the exploits of the great adventurers of Spielburg's past. The names Wolfgang Abenteuer and Baron Stefan von Spielburg appear most often."
						(HandsOn)
						(self dispose:)
					)
					(else
						(gMessager say: 3 1 4) ; "The remaining pages are blank, awaiting further tales of adventure."
						(HandsOn)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance goToBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreControl: -32768
					ignoreActors:
					setMotion: PolyPath 164 119 self
				)
			)
			(1
				(SolvePuzzle 726 6)
				(= seconds 1)
			)
			(2
				(gCurRoom newRoom: 318)
			)
		)
	)
)

(instance goToMaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (gEgo x:) 70) (== (gEgo y:) 145))
					(self changeState: 2)
				else
					(gEgo
						ignoreControl: -32768
						setMotion: PolyPath 50 145 self
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 70 145 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wolfgangTalker of Talker
	(properties
		x 10
		y 10
		view 1311
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2311)
		(PalVary pvCHANGE_TARGET 2311)
		(AssertPalette 1311)
		(= font gUserFont)
		(super init: wolfgangBust wolfgangEye wolfgangMouth &rest)
	)
)

(instance wolfgangBust of Prop
	(properties
		view 1311
	)
)

(instance wolfgangMouth of Prop
	(properties
		nsTop 40
		nsLeft 45
		view 1311
		loop 1
	)
)

(instance wolfgangEye of Prop
	(properties
		nsTop 17
		nsLeft 42
		view 1311
		loop 2
	)
)

(instance snore of Sound
	(properties
		number 112
	)
)

