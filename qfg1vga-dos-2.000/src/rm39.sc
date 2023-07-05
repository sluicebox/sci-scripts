;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use SkilledActor)
(use Teller)
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
	rm39 0
	swordMusic 1
	theMaster 2
	comeBackLittleEgo 3
	masterTalker 4
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 6] = [0 -42 -34 -32 41 999]
	[local12 6] = [0 40 39 16 35 999]
	[local18 6] = [0 40 38 16 31 999]
	[local24 6] = [0 29 28 33 36 999]
	[local30 6]
	[local36 5] = [0 -42 -34 -32 999]
)

(procedure (localproc_0)
	(gMessager say: 8 0 15) ; "Pity. I'm in the mood for some good combat practice."
)

(procedure (localproc_1)
	(if (not [gEgoStats 6]) ; parry
		(gMessager say: 8 0 14) ; "I am a skilled teacher as well as a skilled fighter."
	else
		(= local3 0)
		(if (HaveMoney 10)
			(if (or (not (gEgo has: 2)) (not (gEgo has: 5))) ; sword, shield
				(gMessager say: 8 0 7) ; "The weapon master lends you the necessary items and then..."
			else
				(gMessager say: 8 0 18) ; "You pay the Weapon Master's price and then..."
			)
			(= global246 gDay)
			(SolvePuzzle 607 3 0)
			((ScriptID 39 0) setScript: (ScriptID 222 2)) ; rm39, startFight
		else
			(gMessager say: 8 0 11 1 theMaster) ; "That's easy to say, but you don't HAVE a gold coin. You make your apologies to the Weapon Master."
		)
	)
)

(class WeaponMaster of SkilledActor
	(properties
		strength 40
		intell 45
		agil 45
		vit 35
		luck 45
		weap 50
		parry 50
		dodge 40
		armorValue 3
		shieldValue 3
		weapValue 5
		warriorX 187
		warriorY 135
		endFight 0
	)

	(method (getHit)
		(if fightLeft
			(self x: (+ (self x:) 2))
			((self opponent:) x: (+ ((self opponent:) x:) 2))
		else
			(self x: (- (self x:) 2))
			((self opponent:) x: (- ((self opponent:) x:) 2))
		)
	)

	(method (gotBeat param1)
		(self endFight: 1)
		(self setScript: param1)
	)
)

(instance swordMusic of Sound
	(properties)
)

(instance rm39 of Rm
	(properties
		noun 8
		picture 39
		horizon 100
	)

	(method (dispose)
		(= global451 0)
		(= gUseSortedFeatures local0)
		(if (>= gClock 3000)
			(ClearFlag 239)
		)
		(LoadMany 0 130 212 222 223 224 220 218 216 217)
		(super dispose:)
	)

	(method (cue)
		(if local5
			(= local5 0)
			(if (< 750 gClock 2550)
				(FixTime 21)
			)
			(gCurRoom setScript: goTo37)
		else
			(SolvePuzzle 607 3 0)
			((ScriptID 39 0) setScript: (ScriptID 222 2)) ; rm39, startFight
		)
	)

	(method (init &tmp temp0 temp1)
		(= [local30 0] @local6)
		(= [local30 1] @local12)
		(= [local30 2] @local18)
		(= [local30 3] @local24)
		(= [local30 4] 999)
		(Load rsVIEW 39)
		(if (and (< 0 gTimeOfDay 4) (not (IsFlag 249)) (!= global246 gDay))
			(LoadMany rsSCRIPT 212 222 223 224 217 220 218 216)
			(LoadMany rsVIEW 639 638 501 503 514)
		)
		(switch gPrevRoomNum
			(38
				(self style: 12)
			)
			(40
				(self style: 11)
			)
			(41
				(self style: 4)
			)
			(else
				(self style: 5)
			)
		)
		(super init: &rest)
		(= local0 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(SolvePuzzle 660 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 108 94 98 91 113 74 118 76 135 40 141 28 122 0 119
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 119 300 120 269 106 238 107 208 90 319 95
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 62 189 64 172 104 171 137 189
					yourself:
				)
		)
		(= temp0 (gEgo y:))
		(= global103 (gEgo x:))
		(= global111 0)
		(switch gPrevRoomNum
			(38
				(NormalEgo)
				(gEgo posn: 15 temp0 init:)
			)
			(40
				(NormalEgo)
				(gEgo posn: 304 temp0 init:)
			)
			(41
				(NormalEgo)
				(cond
					((< global103 100)
						(= global103 100)
					)
					((> global103 215)
						(= global103 215)
					)
				)
				(gEgo
					posn: global103 102
					init:
					setMotion: MoveTo global103 107
				)
			)
			(else
				(NormalEgo)
				(gEgo setScript: egoEnters init:)
			)
		)
		(if (not gNight)
			(rightGuard init: setPri: 2 stopUpd:)
			(leftGuard init: setPri: 2 stopUpd:)
		)
		(self setFeatures: castle barrels waggon curbLeft curbRite wall court)
		(if (and (< 0 gTimeOfDay 4) (not (IsFlag 249)) (!= global246 gDay))
			(cond
				((IsFlag 239)
					(masterTeller init: (ScriptID 39 2) @local6 @local30 @local36) ; theMaster
					((ScriptID 39 2) actions: masterTeller init:) ; theMaster
					(self setScript: (ScriptID 222 1)) ; intro2
				)
				((> (Random 0 100) 50)
					(masterTeller init: (ScriptID 39 2) @local6 @local30 @local36) ; theMaster
					((ScriptID 39 2) actions: masterTeller setCycle: Walk init:) ; theMaster
					(SetFlag 239)
					(self setScript: (ScriptID 222 0)) ; intro
				)
			)
			(if [gEgoStats 6] ; parry
				(= local4 1)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((gEgo script:))
			((gEgo edgeHit:)
				(gEgo setScript: egoExits)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 59) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(20 ; rock
				(gMessager say: 8 59) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(16 ; dagger
				(gMessager say: 8 59) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(52 ; Sleep
				(if gNight
					(= local5 1)
					(gMessager say: 8 52 27 0 gCurRoom) ; "You barely get to sleep when you hear the guards searching the castle grounds for bums. You decide it's time to make like a tree and leave."
				else
					(gMessager say: 8 52 26) ; "There are too many guards around."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance castle of Feature
	(properties
		x 150
		y 30
		noun 2
		nsTop 1
		nsLeft 1
		nsBottom 50
		nsRight 250
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(rm39 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance barrels of Feature
	(properties
		x 21
		y 109
		noun 1
		nsTop 101
		nsLeft 3
		nsBottom 114
		nsRight 34
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(rm39 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance waggon of Feature
	(properties
		x 27
		y 110
		noun 10
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(rm39 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance curbLeft of Feature
	(properties
		x 59
		y 110
		noun 4
		nsTop 113
		nsLeft 43
		nsBottom 132
		nsRight 76
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(rm39 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance curbRite of Feature
	(properties
		x 263
		y 93
		noun 5
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(rm39 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wall of Feature
	(properties
		x 52
		y 181
		noun 11
		nsTop 175
		nsLeft 81
		nsBottom 187
		nsRight 101
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(rm39 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance court of Feature
	(properties
		x 185
		y 132
		noun 3
		nsTop 120
		nsLeft 123
		nsBottom 146
		nsRight 251
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; Sleep
			(rm39 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rightGuard of View
	(properties
		x 164
		y 60
		noun 7
		view 39
		loop 1
		priority 15
		signal 16
	)
)

(instance leftGuard of View
	(properties
		x 141
		y 61
		noun 6
		view 39
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(rightGuard doVerb: theVerb)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 175 240 setMotion: MoveTo 160 180 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch (gEgo edgeHit:)
					(1
						(HandsOn)
						(gCurRoom newRoom: 41)
					)
					(3
						(gEgo setMotion: MoveTo (+ (gEgo x:) 15) 240 self)
					)
					(4
						(gEgo setMotion: PolyPath -20 (gEgo y:) self)
					)
					(2
						(gEgo setMotion: PolyPath 337 (gEgo y:) self)
					)
				)
			)
			(1
				(HandsOn)
				(switch (gEgo edgeHit:)
					(3
						(if gNight
							(gCurRoom setScript: goTo37)
						else
							(gCurRoom newRoom: 37)
						)
					)
					(4
						(gCurRoom newRoom: 38)
					)
					(2
						(gCurRoom newRoom: 40)
					)
				)
			)
		)
	)
)

(instance comeBackLittleEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 62 8 0 self) ; "If you are addressing me, sir, you must respect me enough to address me to my face!"
			)
			(1
				(HandsOff)
				(theMaster view: 639 cel: 0)
				(if (< (gEgo x:) ((ScriptID 39 2) x:)) ; theMaster
					(theMaster loop: 5)
				else
					(theMaster loop: 4)
				)
				(gEgo
					ignoreActors:
					setMotion:
						MoveTo
						(if (< (gEgo x:) ((ScriptID 39 2) x:)) ; theMaster
							(- (theMaster x:) 40)
						else
							(+ (theMaster x:) 40)
						)
						(theMaster y:)
						self
				)
			)
			(2
				(Face gEgo theMaster)
				(= local1 1)
				(gEgo ignoreActors: 0)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance goTo37 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if gNight
					(if (< [gEgoStats 11] 10) ; climbing
						(gMessager say: 8 0 12 1 self) ; "The gates are closed for the night."
					else
						(gMessager say: 8 0 4 1 self) ; "After making sure no guards are looking, you climb over the wall."
					)
				else
					(self cue:)
				)
			)
			(1
				(if (< [gEgoStats 11] 10) ; climbing
					(gEgo setMotion: PolyPath (gEgo x:) 172 self)
				else
					(gCurRoom newRoom: 37)
				)
			)
			(2
				(HandsOn)
				(gEgo setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance teacherTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (not [gEgoStats 6]) ; parry
					(gMessager say: 8 0 14) ; "I am a skilled teacher as well as a skilled fighter."
				else
					(SetFlag 321)
					(gMessager say: 8 0 16) ; "I am a skilled teacher as well as a skilled fighter."
					(= global111 130)
					(= local3 1)
				)
				(= seconds 5)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance theMaster of WeaponMaster
	(properties
		noun 9
		view 639
	)

	(method (init)
		(= global451 1639)
		(PalVary pvCHANGE_TARGET 1639)
		(AssertPalette 639)
		(super init:)
	)

	(method (cue)
		(localproc_0)
	)

	(method (doit)
		(cond
			((> global111 1)
				(-- global111)
			)
			((and (== global111 1) local3)
				(= global111 0)
				(= local3 0)
				(localproc_0)
			)
		)
		(super doit:)
	)
)

(instance masterTeller of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(if (== (= temp0 (super showDialog:)) -34)
			(gCurRoom setScript: teacherTalk)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (not (< (gEgo distanceTo: (ScriptID 39 2)) 45)) ; theMaster
					(rm39 setScript: comeBackLittleEgo)
				else
					(SolvePuzzle 661 1)
					(super doVerb: theVerb &rest)
				)
			)
			(10 ; silver
				(localproc_1)
			)
			(16 ; dagger
				(gCurRoom setScript: teacherTalk)
			)
			(12 ; sword
				(gCurRoom setScript: teacherTalk)
			)
			(20 ; rock
				(gMessager say: 8 59) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(81 ; flameDartSpell
				(gMessager say: 8 59) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance masterTalker of Talker
	(properties
		x 10
		y 10
		view 1039
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2039)
		(PalVary pvCHANGE_TARGET 2039)
		(AssertPalette 1039)
		(= font gUserFont)
		(super init: masterBust masterEyes masterTalkerMouth &rest)
	)
)

(instance masterBust of Prop
	(properties
		view 1039
	)
)

(instance masterTalkerMouth of Prop
	(properties
		nsTop 46
		nsLeft 54
		view 1039
		loop 1
	)
)

(instance masterEyes of Prop
	(properties
		nsTop 26
		nsLeft 57
		view 1039
		loop 2
	)
)

