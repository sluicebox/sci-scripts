;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 332)
(include sci.sh)
(use Main)
(use Teller)
(use buy)
(use n814)
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
	rm332 0
	chiefThiefTalker 1
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
	local10
	local11
	local12
	local13
	[local14 11] = [{Mighty careless of you to walk right in front of that knife!__Or did the Chief Thief hit you on purpose?__Or did you just discover an obscure bug in the program???__Maybe you'll never really know. } {You can't believe the Chief Thief's reflexes as he instantly reacts to your intention to pull a fast one.__A dagger flies like lightning and.... } {Trouble with sharp, pointy objects} {These guys are MEAN!} 250 40 75 30 25 100 35]
	[local25 7] = [0 -42 -34 35 -45 -44 999]
	[local32 4] = [0 41 -29 999]
	[local36 7] = [0 43 38 30 -32 37 999]
	[local43 4] = [0 39 36 999]
	[local47 3] = [0 -31 999]
	[local50 3] = [0 40 999]
	[local53 3] = [0 -28 999]
	[local56 3] = [0 -33 999]
	[local59 4] = [0 26 27 999]
	[local63 3] = [0 25 999]
	[local66 15]
	[local81 11] = [0 -42 -34 -45 -44 -29 -32 -31 -28 -33 999]
	[local92 5] = [0 -2 -6 1 999]
	[local97 3] = [0 4 999]
	[local100 4] = [0 5 3 999]
	[local104 5]
	[local109 4] = [0 -2 -6 999]
)

(procedure (localproc_0)
	(gMessager say: 7) ; "I don't have time to talk to unlicensed scum. Pay your guild license fee, and then we can talk. Why don't you do something constructive like stealing Otto's yo-yo?"
)

(procedure (localproc_1)
	(if local4
		(return 0)
	else
		(knifeScript changeState: 1)
		(return 1)
	)
)

(class Knife of View
	(properties
		noun 13
	)
)

(instance rm332 of Rm
	(properties
		noun 18
		picture 332
		style 5
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 99)
		(super dispose:)
	)

	(method (cue)
		(switch local12
			(1
				(gMessager say: 4 1 8) ; "Our very special items are reserved for our guild members. No scabs allowed."
			)
			(2
				(gMessager say: 4 1 7) ; "We sell lockpicks and thief toolkits here."
			)
		)
	)

	(method (init)
		(= [local66 0] @local25)
		(= [local66 1] @local32)
		(= [local66 2] @local36)
		(= [local66 3] @local43)
		(= [local66 4] @local47)
		(= [local66 5] @local50)
		(= [local66 6] @local53)
		(= [local66 7] @local56)
		(= [local66 8] @local63)
		(= [local66 9] @local59)
		(= [local66 10] 999)
		(= [local104 0] @local92)
		(= [local104 1] @local97)
		(= [local104 2] @local100)
		(= [local104 3] 999)
		(= local0 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 80 123 84 130 142 130 147 174 61 174 63 152 56 148 51 116 14 155 0 179 192 180 179 158 284 158 189 111 146 111 133 123
					yourself:
				)
		)
		(LoadMany rsVIEW 332 338 509 503)
		(LoadMany rsSOUND (SoundFX 31) (SoundFX 29) (SoundFX 30))
		(super init:)
		(SolvePuzzle 638 5 2)
		(dagMusic number: (SoundFX 31) init:)
		(SL enable:)
		(= local5 100)
		(= local6 7)
		(= gPerspective 70)
		(gFeatures
			add:
				onBoard
				onLadder
				onLightFixture1
				onLightFixture2
				onBoxes
				onTrap
				onDaggers
				onPottery
				onOneKnife
				onCrock
				onTable
			eachElementDo: #init
		)
		(onDoor init: approachVerbs: 4 1 10) ; Do, Look, silver
		(onTrunk init:)
		(onBarrels init:)
		(onCeiling init:)
		(chair init: actions: chiefTeller stopUpd: ignoreActors:)
		(chairArm
			init:
			ignoreActors:
			actions: chiefTeller
			setPri: (+ (chiefThief priority:) 1)
			stopUpd:
		)
		(fire1 init: setCycle: Fwd)
		(fire2 init: setCycle: Fwd)
		(borisTeller init: borisThief @local92 @local104 @local109)
		(chiefTeller init: chiefThief @local25 @local66 @local81)
		(chiefThief approachVerbs: 4 10 actions: chiefTeller init:) ; Do, silver
		(crusher init: ignoreActors: 1 stopUpd:)
		(crusherHead init: ignoreActors: 1 setCycle: Fwd)
		(crusherFoot init: ignoreActors: 1 setCycle: Fwd cycleSpeed: 18)
		(knife
			ignoreActors:
			init:
			setPri: 13
			setLoop: 7
			setCycle: Fwd
			stopUpd:
			hide:
			setScript: knifeScript
		)
		(if (== gPrevRoomNum 340)
			(gLongSong fade: 127 20 5 0)
			(gEgo
				view: 4
				posn: 160 160
				loop: 3
				cel: 0
				ignoreActors:
				setCycle: Walk
				init:
			)
			(NormalEgo)
			(chiefThief setScript: chiefBored)
		else
			(gLongSong number: 8 loop: -1 init: play:)
			(gEgo
				view: 4
				setLoop: 3
				cel: 0
				posn: 227 156
				ignoreActors:
				init:
			)
			(self setScript: rm332EntranceScript)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 18 1 0) ; "The floor is surprisingly clean compared to the bar above. The plaster is chipping in several places. This place gives you the creeps."
			)
			(4 ; Do
				(gMessager say: 18 4 0) ; "You're probably wondering if there is any honor among thieves."
			)
			(16 ; dagger
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(12 ; sword
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(20 ; rock
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(52 ; Sleep
				(HandsOff)
				(gEgo setScript: throwEgoOut)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(cond
			(local4
				(if
					(<=
						(= local5
							(GetDistance
								(gEgo x:)
								(- (gEgo y:) 30)
								(knife x:)
								(knife y:)
								gPerspective
							)
						)
						local6
					)
					(gEgo setScript: deathScript)
				)
			)
			((and local9 (not local3) (== (knifeScript state:) 0))
				(= local3 1)
				(localproc_1)
			)
		)
		(cond
			(
				(and
					(not (borisThief script:))
					(not local1)
					(gEgo inRect: 139 109 212 127)
				)
				(= local1 1)
				(borisThief setScript: heComes)
			)
			(
				(and
					local1
					(not (borisThief script:))
					(not (gEgo inRect: 139 109 212 127))
				)
				(= local1 0)
				(borisThief setScript: heGoes)
			)
		)
		(super doit:)
	)
)

(instance onBoard of Feature
	(properties
		x 86
		y 55
		noun 3
		nsTop 55
		nsLeft 64
		nsBottom 92
		nsRight 108
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1 0 1) ; "It looks a bit like a dart board, only bigger."
				(if (> local8 5)
					(gMessager say: 3 1 0 2) ; "There sure are a lot of daggers in the board. You wonder where the Chief Thief keeps them all."
				)
			)
			(4 ; Do
				(gMessager say: 3 4) ; "The game is called Dag-Nab-It. You take turns with the Chief Thief throwing daggers at the board. Each player gets three turns, and throws three daggers in each turn."
				(if
					(and
						(gEgo has: 6) ; dagger
						(or (>= (gEgo has: 0) 5) (>= (gEgo has: 38) 1)) ; silver, gold
					)
					(gCurRoom setScript: goToDagnabit)
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onDoor of Feature
	(properties
		x 166
		y 80
		noun 11
		nsTop 61
		nsLeft 143
		nsBottom 108
		nsRight 190
		sightAngle 40
		approachX 157
		approachY 116
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1) ; "The opening in the door has a wire grate on it, but there is space below it where objects can be passed through. The mysterious-looking man on the other side is Boris, the cashier and fence for the Guild."
			)
			(4 ; Do
				(gEgo setScript: toTheDoorScript)
			)
			(17 ; lockPick
				(gMessager say: 11 17) ; "Picking locks in the Thieves' Guild is a singularly stupid idea."
			)
			(18 ; thiefKit
				(gMessager say: 11 17) ; "Picking locks in the Thieves' Guild is a singularly stupid idea."
			)
			(16 ; dagger
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onLadder of Feature
	(properties
		x 261
		y 78
		noun 14
		nsTop 9
		nsLeft 252
		nsBottom 147
		nsRight 271
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 14 1) ; "The ladder to the tavern is very sturdy. It has to be to support Crusher's weight."
			)
			(4 ; Do
				(gEgo setScript: leaveRoomScript)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onLightFixture1 of Feature
	(properties
		x 22
		y 113
		noun 15
		nsTop 88
		nsLeft 12
		nsBottom 138
		nsRight 32
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 15 1) ; "It's a prelude to the modern electric bulb, a marked improvement over darkness."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onLightFixture2 of Feature
	(properties
		x 295
		y 134
		noun 15
		nsTop 110
		nsLeft 284
		nsBottom 158
		nsRight 306
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 15 1) ; "It's a prelude to the modern electric bulb, a marked improvement over darkness."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onCeiling of Feature
	(properties
		x 180
		y 38
		noun 6
		nsBottom 38
		nsRight 319
		sightAngle 40
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 6 1) ; "You can tell where the bar is by the seep marks from spilled beer."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onTrunk of Feature
	(properties
		x 218
		y 105
		noun 22
		nsTop 105
		nsLeft 202
		nsBottom 137
		nsRight 252
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 22 1) ; "Don't open the lid! Who knows what will jump out?!"
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onBarrels of Feature
	(properties
		x 218
		y 137
		noun 2
		nsTop 137
		nsLeft 166
		nsBottom 179
		nsRight 319
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 2 1) ; "The barrels are large enough to hide several unlucky adventurers. Let's hope you're not that unlucky."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onBoxes of Feature
	(properties
		x 83
		y 171
		noun 5
		nsTop 164
		nsBottom 178
		nsRight 167
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 5 1) ; "The boxes must be used to store what the thieves are lucky enough to steal in this town."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onTrap of Feature
	(properties
		x 251
		y 4
		noun 21
		nsLeft 246
		nsBottom 8
		nsRight 257
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 21 1) ; "The trapdoor allows access to the bar above."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onDaggers of Feature
	(properties
		x 232
		y 124
		z 65
		noun 10
		nsTop 45
		nsLeft 213
		nsBottom 73
		nsRight 251
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 10 1) ; "The daggers are nicely made, and apparently designed for throwing. Besides the Chief Thief's seemingly endless collection, there are two matched sets with differently-colored hilts for playing Dag-Nab-It."
			)
			(4 ; Do
				(gMessager say: 10 4) ; "Stealing from a dagger-throwing thief?  That's a dangerous -- and stupid -- idea!"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onPottery of Feature
	(properties
		x 232
		y 154
		noun 17
		nsTop 80
		nsLeft 217
		nsBottom 104
		nsRight 248
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 17 1) ; "Even thieves get thirsty."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onTable of Feature
	(properties
		x 108
		y 119
		noun 19
		nsTop 119
		nsLeft 76
		nsBottom 156
		nsRight 140
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 19 1) ; "The table is as rough as the man sitting next to it."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onOneKnife of Feature
	(properties
		x 82
		y 125
		noun 16
		nsTop 121
		nsLeft 79
		nsBottom 129
		nsRight 85
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 16 1) ; "A dagger is strategically located on the table."
			)
			(4 ; Do
				(gMessager say: 16 4) ; "Stealing from a dagger-throwing thief?  That's a dangerous -- and stupid -- idea!"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onCrock of Feature
	(properties
		x 122
		y 122
		noun 8
		nsTop 116
		nsLeft 108
		nsBottom 129
		nsRight 137
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 8 1) ; "It looks like yesterday's unfinished dinner."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance onWindow of Feature ; UNUSED
	(properties
		x 173
		y 81
		z 30
		noun 23
		nsTop 70
		nsLeft 164
		nsBottom 86
		nsRight 182
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 23 1) ; "The barred window lets in the foul stench from the alley."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance chairArm of View
	(properties
		x 76
		y 148
		noun 7
		view 332
		loop 3
		cel 1
		priority 10
	)

	(method (doVerb theVerb)
		(chiefThief doVerb: theVerb &rest)
	)
)

(instance chair of View
	(properties
		x 72
		y 148
		noun 7
		view 332
		loop 3
		priority 5
		signal 16
	)

	(method (doVerb theVerb)
		(chiefThief doVerb: theVerb &rest)
	)
)

(instance crusher of Prop
	(properties
		x 124
		y 119
		noun 9
		view 332
		loop 3
		cel 2
		priority 7
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1) ; "Crusher is our personnel manager."
			)
			(4 ; Do
				(gMessager say: 9 4) ; "Crusher is his usual, amiable self, "every bit the Goon"."
			)
			(2 ; Talk
				(gMessager say: 9 2) ; "Crusher ignores you."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance fire1 of Prop
	(properties
		x 31
		y 96
		noun 15
		view 332
		loop 8
		cel 6
	)

	(method (doVerb theVerb)
		(onLightFixture1 doVerb: theVerb &rest)
	)
)

(instance fire2 of Prop
	(properties
		x 306
		y 110
		noun 15
		view 332
		loop 9
		cel 2
	)

	(method (doVerb theVerb)
		(onLightFixture1 doVerb: theVerb &rest)
	)
)

(instance crusherHead of Prop
	(properties
		x 116
		y 75
		noun 9
		view 332
		loop 4
		priority 8
		signal 16
		cycleSpeed 36
	)

	(method (doVerb theVerb)
		(crusher doVerb: theVerb &rest)
	)
)

(instance crusherFoot of Prop
	(properties
		x 127
		y 117
		noun 9
		view 332
		loop 13
		cel 1
		signal 16384
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(crusher doVerb: theVerb &rest)
	)
)

(instance knife of Actor
	(properties
		x 91
		y 124
		noun 13
		yStep 7
		view 332
		loop 7
		cycleSpeed 1
		illegalBits 0
		xStep 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 13 1) ; "The knife the Chief Thief threw."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance chiefThief of Actor
	(properties
		x 91
		y 145
		noun 7
		view 332
		loop 5
		priority 10
		signal 16400
		illegalBits 0
	)

	(method (init)
		(= global451 1332)
		(PalVary pvCHANGE_TARGET 1332)
		(AssertPalette 332)
		(super init:)
	)
)

(instance borisThief of Actor
	(properties
		x 182
		y 87
		noun 4
		approachX 157
		approachY 116
		view 332
		loop 12
	)
)

(instance chiefTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1) ; "From his expensive clothes to his carefully trimmed mustache, there is an air of sophistication about this villian."
			)
			(2 ; Talk
				(if (not (gEgo has: 9)) ; thiefLicense
					(gEgo setScript: getTheLicense)
				else
					(Face gEgo chiefThief)
					(super doVerb: theVerb &rest)
				)
			)
			(10 ; silver
				(if
					(and
						(gEgo has: 6) ; dagger
						(or (>= (gEgo has: 0) 5) (>= (gEgo has: 38) 1)) ; silver, gold
					)
					(gLongSong fade: 63 20 5 0)
					(gCurRoom newRoom: 340)
				else
					(gMessager say: 7 4) ; "If you can't pay, don't play."
				)
			)
			(16 ; dagger
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(12 ; sword
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(20 ; rock
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance borisTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1 0 1 gCurRoom) ; "You can call me 'Boris'. I'm the Chief Financial Officer for the Guild."
				(if (not (gEgo has: 9)) ; thiefLicense
					(= local12 1)
				else
					(= local12 2)
				)
			)
			(4 ; Do
				(cond
					((not (gEgo has: 9)) ; thiefLicense
						(gMessager say: 4 4 8) ; "We buy only from our members."
					)
					(
						(or
							(IsFlag 131)
							(IsFlag 133)
							(IsFlag 179)
							(IsFlag 181)
							(IsFlag 182)
						)
						(gMessager say: 4 4 9) ; "That doesn't look like something we can resell."
					)
					(else
						(gMessager say: 4 4 7) ; "You can't fence something you don't have."
					)
				)
			)
			(2 ; Talk
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 4 2 8) ; "A Thief's license will cost you 25 silvers. You will need a license to use any of our services."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(10 ; silver
				((= gList (List new:))
					add:
						((Clone Ware) name: {License} price: {25})
						((Clone Ware) name: {Lock Pick} price: {15})
						((Clone Ware) name: {Tool Kit} price: {100})
				)
				(switch ((ScriptID 551 0) doit:) ; buy
					(-1
						(gMessager say: 4 10 12) ; "I'm sorry, but you don't seem to have enough silver. Come back when you qualify."
					)
					(1
						(if (gEgo has: 9) ; thiefLicense
							(gMessager say: 4 10 11) ; "Don't bother. You've already paid, stupid."
							(= local13 1)
							(gEgo setScript: cueItScript)
						else
							(gMessager say: 4 10 10) ; "Welcome to the Thieves' Guild Union, Local 1313."
							(SolvePuzzle 639 3 2)
							(= local13 2)
							(gEgo setScript: cueItScript)
						)
					)
					(2
						(if (not (gEgo has: 7)) ; lockPick
							(= global175 10)
						)
						(gMessager say: 4 10 13) ; "There you are."
						(= local13 3)
						(gEgo setScript: cueItScript)
					)
					(3
						(if (not (gEgo has: 8)) ; thiefKit
							(= global175 35)
							(SolvePuzzle 640 3 2)
						)
						(gMessager say: 4 10 13) ; "There you are."
						(= local13 4)
						(gEgo setScript: cueItScript)
					)
				)
				(return 1)
			)
			(45 ; pearls
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 4 45 8) ; "We buy only from our members."
				else
					(gMessager say: 4 45 7) ; "Let's see now... deducting the Guild cut, and allowing for resale markup, that comes to... 500 silvers. Here you are."
					(SolvePuzzle 641 3 2)
					(= local13 5)
					(gEgo setScript: cueItScript)
				)
			)
			(16 ; dagger
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(41 ; vase
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 4 41 8) ; "We buy only from our members."
				else
					(gMessager say: 4 41 7) ; "Let's see now... deducting the Guild cut, and allowing for resale markup, that comes to... 40 silvers. Here you are."
					(SolvePuzzle 641 3 2)
					(= local13 6)
					(gEgo setScript: cueItScript)
				)
			)
			(43 ; musicBox
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 4 43 8) ; "We buy only from our members."
				else
					(gMessager say: 4 43 7) ; "Let's see now... deducting the Guild cut, and allowing for resale markup, that comes to... 90 silvers. Here you are."
					(SolvePuzzle 641 3 2)
					(= local13 7)
					(gEgo setScript: cueItScript)
				)
			)
			(44 ; candleSticks
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 4 44 8) ; "We buy only from our members."
				else
					(gMessager say: 4 44 7) ; "Let's see now... deducting the Guild cut, and allowing for resale markup, that comes to... 100 silvers. Here you are."
					(SolvePuzzle 641 3 2)
					(= local13 8)
					(gEgo setScript: cueItScript)
				)
			)
			(42 ; candelabra
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 4 42 8) ; "We buy only from our members."
				else
					(gMessager say: 4 42 7) ; "Let's see now... deducting the Guild cut, and allowing for resale markup, that comes to... 150 silvers. Here you are."
					(SolvePuzzle 641 3 2)
					(= local13 9)
					(gEgo setScript: cueItScript)
				)
			)
			(28 ; ring
				(gMessager say: 18 28) ; "That ring belongs to the Healer. You better give it to her before she gets mad."
			)
			(12 ; sword
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(20 ; rock
				(HandsOff)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance rm332EntranceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 120)
			)
			(1
				(if (not (IsFlag 99))
					(crusherFoot setCycle: 0)
					(crusherHead setCycle: 0)
					(gMessager say: 18 0 46 0 self) ; "This dark, seedy place is less than you expected of a Thieves' Guild. You feel uneasy about the sinister mood here."
				else
					(= ticks 120)
				)
			)
			(2
				(crusherFoot setCycle: Fwd)
				(crusherHead setCycle: Fwd)
				(= ticks 30)
			)
			(3
				(NormalEgo)
				(gGame setCursor: gWaitCursor)
				(gEgo
					view: 0
					loop: 0
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 155 157 self
				)
			)
			(4
				(if (IsFlag 99)
					(self changeState: 40)
					(= ticks 1)
				else
					(self cue:)
				)
			)
			(5
				(knife hide:)
				(gMessager say: 7 0 22) ; "Beginners! Why do they keep giving me beginners?"
				(gEgo view: 4 setLoop: 3)
				(chiefThief setLoop: 2 setCycle: End self)
			)
			(6
				(chiefThief
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 210 136 self
				)
			)
			(7
				(chiefThief setLoop: 1 setMotion: MoveTo 180 136 self)
				(gMessager say: 7 0 24) ; "I tell you, Crusher, that a thief of my stature and abilities should be stuck in a Po-Dunk town besieged by brigands who aren't even Union Members is the height of injustice!"
			)
			(8
				(chiefThief setLoop: 1 setMotion: MoveTo 150 136 self)
			)
			(9
				(chiefThief setLoop: 0 setMotion: MoveTo 190 136 self)
			)
			(10
				(chiefThief setLoop: 1 setMotion: MoveTo 100 136 self)
			)
			(11
				(chiefThief setLoop: 0 setMotion: MoveTo 94 136 self)
			)
			(12
				(chiefThief setLoop: 2 posn: 91 145 cel: 9 setCycle: Beg self)
			)
			(13
				(chiefThief setLoop: 5 setCel: 0)
				(= seconds 3)
			)
			(14
				(gMessager say: 7 0 23) ; "It will cost you 25 silvers to work in town. Just pay Boris at the door. If you don't have the cash, go steal some."
				(SetFlag 99)
				(self cue:)
			)
			(15
				(localproc_1)
				(self changeState: 40)
			)
			(40
				(gEgo setPri: -1)
				(NormalEgo)
				(HandsOn)
				(chiefThief setScript: chiefBored)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Walk setMotion: PolyPath 240 150 self)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32762)
				(self cue:)
			)
			(2
				(gCurRoom newRoom: 331)
			)
		)
	)
)

(instance throwEgoOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 3 0 4)
				(HandsOff)
				(gEgo
					setMotion: PolyPath (crusher x:) (+ (crusher y:) 30) self
				)
			)
			(1
				(crusherHead hide: dispose:)
				(crusher view: 338 loop: 0 setCycle: End self)
			)
			(2
				(crusher cel: 2)
				(= cycles 3)
			)
			(3
				(crusher setCycle: End self)
			)
			(4
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32761)
				(self cue:)
			)
			(5
				(SetFlag 117)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance chiefBored of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 12))
			)
			(1
				(localproc_1)
				(self changeState: 0)
			)
		)
	)
)

(instance knifeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(knife posn: 91 124 cel: 0)
				(chiefThief setLoop: 5 cel: 0)
			)
			(1
				(knife show:)
				(chiefThief setLoop: 5 cel: 0 setCycle: End)
				(= cycles 1)
			)
			(2
				(= local4 1)
				(dagMusic number: (SoundFX 31) play:)
				(if local9
					(knife setMotion: MoveTo (gEgo x:) (- (gEgo y:) 30))
				else
					(knife setMotion: MoveTo 91 95)
				)
				(= cycles 12)
			)
			(3
				(knife setMotion: MoveTo 91 124 self)
			)
			(4
				(chiefThief loop: 6 cel: 0 posn: 91 145)
				(knife hide:)
				(= seconds 2)
			)
			(5
				(chiefThief setCycle: End)
				(if local9
					(knife
						show:
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 30) self
					)
				else
					(knife
						show:
						setMotion: MoveTo (Random 80 95) (Random 67 85) self
					)
				)
			)
			(6
				(dagMusic stop:)
				(dagMusic
					number:
						(if (Random 0 1)
							(SoundFX 30)
						else
							(SoundFX 29)
						)
					play:
				)
				(= local4 0)
				(if (< local10 12)
					(++ local0)
					((= local2 (Knife new:))
						view: 332
						loop: 7
						cel: 1
						posn: (knife x:) (knife y:)
						init:
						stopUpd:
					)
					(++ local10)
				)
				(knife hide:)
				(= cycles 2)
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance toTheDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 157 116 self)
			)
			(1
				(gMessager say: 18 0 47) ; "The door is locked, and Boris won't let you in."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance deathScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(knife setMotion: 0 hide:)
				(gEgo
					view: 503
					posn: (+ (gEgo x:) 5) (gEgo y:)
					setLoop: 0
					cel: 0
					setCycle: CT 5 1
				)
				(= cycles 15)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(EgoDead 47 48 0 0 800) ; "You can't believe the Chief Thief's reflexes as he instantly reacts to your intention to pull a fast one. A dagger flies like lightning and..."
			)
		)
	)
)

(instance uhOh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo chiefThief self)
			)
			(1
				(= seconds 2)
			)
			(2
				(EgoDead 47 48 0 0 800) ; "You can't believe the Chief Thief's reflexes as he instantly reacts to your intention to pull a fast one. A dagger flies like lightning and..."
			)
		)
	)
)

(instance heComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(borisThief
					approachVerbs: 4 10 ; Do, silver
					init:
					loop: 12
					cel: 0
					setCycle: End self
				)
			)
			(1
				(borisThief setLoop: 10 setCel: 0)
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance heGoes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(borisThief loop: 11 cel: 0 setCycle: End self)
			)
			(1
				(borisThief dispose: delete:)
				(self dispose:)
			)
		)
	)
)

(instance getTheLicense of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo chiefThief)
				(= seconds 3)
			)
			(1
				(localproc_0)
				(self cue:)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToDagnabit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
			)
			(1
				(gLongSong fade: 63 20 5 0)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance cueItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(switch local13
					(1
						(gEgo get: 0 25) ; silver
					)
					(2
						(gEgo get: 9) ; thiefLicense
					)
					(3
						(gEgo get: 7) ; lockPick
					)
					(4
						(gEgo get: 8) ; thiefKit
					)
					(5
						(gEgo get: 38 50) ; gold
						(gEgo use: 35) ; pearls
					)
					(6
						(gEgo use: 31) ; vase
						(gEgo get: 38 4) ; gold
					)
					(7
						(gEgo use: 33) ; musicBox
						(gEgo get: 38 9) ; gold
					)
					(8
						(gEgo use: 34) ; candleSticks
						(gEgo get: 38 10) ; gold
					)
					(9
						(gEgo use: 32) ; candelabra
						(gEgo get: 38 15) ; gold
					)
				)
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance dagMusic of Sound
	(properties
		number 31
	)
)

(instance chiefThiefTalker of Talker
	(properties
		x 10
		y 10
		view 1332
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2332)
		(PalVary pvCHANGE_TARGET 2332)
		(AssertPalette 1332)
		(= font gUserFont)
		(super init: chiefThiefBust chiefThiefEye chiefThiefMouth &rest)
	)
)

(instance chiefThiefBust of Prop
	(properties
		view 1332
	)
)

(instance chiefThiefMouth of Prop
	(properties
		nsTop 45
		nsLeft 41
		view 1332
		loop 1
	)
)

(instance chiefThiefEye of Prop
	(properties
		nsTop 14
		nsLeft 41
		view 1332
		loop 2
	)
)

