;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use n007)
(use Teller)
(use n813)
(use n814)
(use Extra)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm40 0
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
	local14
	[local15 8] = [0 -21 15 -13 19 14 -17 999]
	[local23 3] = [0 18 999]
	[local26 5] = [0 12 16 20 999]
	[local31 3] = [0 11 999]
	[local34 7]
	[local41 5] = [0 -21 -13 -17 999]
)

(procedure (localproc_0)
	(gMessager say: 8 0 0 1) ; "Haven't you got anything better to do than hang around here? Come back some other time."
)

(instance rakeMusic of Sound
	(properties
		number 77
		priority 1
		loop -1
	)
)

(instance rm40 of Rm
	(properties
		noun 8
		picture 40
		horizon 60
	)

	(method (init &tmp temp0 temp1 temp2)
		(= [local34 0] @local15)
		(= [local34 1] @local23)
		(= [local34 2] @local26)
		(= [local34 3] @local31)
		(= [local34 4] 999)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 189 0 189 0 166 33 165 56 178 184 179 236 162 94 141 145 116 145 105 88 140 67 130 59 112 0 108 0 0
					yourself:
				)
		)
		(self style: 8)
		(super init: &rest)
		(= local13 0)
		(= local9 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(= local10 (gEgo cycleSpeed:))
		(= local11 (gEgo moveSpeed:))
		(walls init: setOnMeCheck: 1 8)
		(towers init: setOnMeCheck: 1 16)
		(waggon init: setOnMeCheck: 1 32)
		(houses init: setOnMeCheck: 1 128)
		(waterBarrel init: setOnMeCheck: 1 256)
		(mounts init: setOnMeCheck: 1 512)
		(sky init: setOnMeCheck: 1 1024)
		(fence init: setOnMeCheck: 1 2048)
		(grain init: setOnMeCheck: 1 64)
		(stableTeller init: stableMan @local15 @local34 @local41)
		(stableMan
			setLoop: 0
			cel: 0
			actions: stableTeller
			approachVerbs: 2 ; Talk
			posn: 234 82
			init:
			stopUpd:
		)
		(horse
			posn: (Random 53 70) (Random 98 103)
			setPri: 5
			init:
			stopUpd:
			setScript: horseEats
		)
		(horseHead posn: (+ (horse x:) 8) (- (horse y:) 23) setPri: 6 init:)
		(horseTail posn: (- (horse x:) 13) (- (horse y:) 12) setPri: 6 init:)
		(= temp1 (if (IsFlag 217) 2 else 0))
		(= temp2 (if gNight 32 else 25))
		(if (or (== (gLongSong prevSignal:) -1) (!= (gLongSong number:) temp2))
			(gLongSong stop:)
			(gLongSong number: temp2 loop: -1 priority: 0 play:)
		)
		(if (== gNight 0)
			(manure1 setPri: 4 setCel: temp1 ignoreActors: init: stopUpd:)
			(manure2 setPri: 4 setCel: temp1 ignoreActors: init: stopUpd:)
			(manure3 setPri: 4 setCel: temp1 ignoreActors: init: stopUpd:)
		)
		(= temp0 (gEgo y:))
		(switch gPrevRoomNum
			(999
				(= local4 1)
				(gEgo posn: 148 132 init: setScript: sleepyIntro)
			)
			(39
				(NormalEgo)
				(gEgo
					cel: (gEgo cel:)
					loop: (gEgo loop:)
					posn: 15 temp0
					init:
				)
			)
			(41
				(NormalEgo)
				(gEgo posn: 2 120 init: setMotion: PolyPath 25 130)
				(HandsOn)
			)
			(else
				(NormalEgo)
				(gEgo posn: 33 128 init:)
				(HandsOn)
			)
		)
	)

	(method (cue)
		(gMessager say: 8 0 0 9) ; "You lookin' for some work?"
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== (gEgo edgeHit:) 4) (not (gEgo script:)))
			(gEgo setScript: headWest)
		)
		(if
			(and
				(== local2 0)
				(== gNight 0)
				(!= gPrevRoomNum 999)
				(or (== (gEgo onControl: 1) 4) (== (gEgo onControl: 1) 2))
				(not (== (stableMan script:) intro))
				(not (gEgo script:))
				(not local4)
			)
			(= local4 1)
			(gEgo setMotion: 0)
			(stableMan setScript: intro)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((== (gEgo onControl: 1) 2)
						(gMessager say: 8 1 8) ; "It doesn't look like the stableman spends much of his time cleaning."
					)
					((IsFlag 217)
						(gMessager say: 8 1 2) ; "The stable looks much better since you cleaned it."
					)
					(else
						(gMessager say: 8 1 1) ; "The castle's stable looks like it holds about six horses. It could use some cleaning up. To the northwest you can see the castle's central keep."
					)
				)
			)
			(52 ; Sleep
				(cond
					((< 750 gClock 2550)
						(gMessager say: 8 52 9) ; "It's too early in the day; come back later."
					)
					((not (== (gEgo onControl: 1) 2))
						(gMessager say: 8 52 8) ; "It would be more comfortable to sleep on clean hay in the stable."
					)
					((not (IsFlag 217))
						(gMessager say: 8 52 2) ; "Hey you! It's bad enough you hang around here all day, but I sure ain't gonna let you sleep here before you've worked enough to earn it!"
					)
					((gEgo script:)
						(gMessager say: 8 52 10) ; "Wait a minute."
					)
					(else
						(gEgo setScript: sleeper)
					)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 8 81) ; "The stable area is too flammable to use that spell here."
			)
			(78 ; dazzleSpell
				(gMessager say: 8 78) ; "You don't need to dazzle anything here. The horses wouldn't like it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local9)
		(super dispose:)
	)
)

(instance walls of Feature
	(properties
		noun 13
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 13 1) ; "There is solid wall of rock protecting this place."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance towers of Feature
	(properties
		noun 11
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 11 1) ; "The castle towers overlook the entire valley."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance waggon of Feature
	(properties
		noun 12
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 12 1) ; "The horses have plenty of hay to eat."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance grain of Feature
	(properties
		noun 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 2 1) ; "The horses have plenty of grain to keep them eating well."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance houses of Feature
	(properties
		noun 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 5 1) ; "The officers have nicer places than the enscripted men (those who program scripts)."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance waterBarrel of Feature
	(properties
		noun 14
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 14 1) ; "This holds drinking water for the horses."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance mounts of Feature
	(properties
		noun 7
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 7 1) ; "The majestic mountains stand in stark contrast to the squalor of the castle."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance sky of Feature
	(properties
		noun 9
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 9 1) ; "The sky goes on forever when it's this clear."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance fence of Feature
	(properties
		noun 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 1 1) ; "There is a fenced corral next to the stable building."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance manure1 of View
	(properties
		x 48
		y 132
		noun 6
		view 140
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 217)
					(gMessager say: 6 1 2) ; "You have raked the manure and covered the stable floor with new straw."
				else
					(gMessager say: 6 1 1) ; "In the stable, the manure is beginning to pile up."
				)
			)
			(else
				(gCurRoom doVerb: &rest)
			)
		)
	)
)

(instance manure2 of View
	(properties
		x 63
		y 143
		view 140
		loop 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gCurRoom doVerb: theVerb &rest)
		else
			(manure1 doVerb: theVerb &rest)
		)
	)
)

(instance manure3 of View
	(properties
		x 93
		y 143
		view 140
		loop 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gCurRoom doVerb: theVerb &rest)
		else
			(manure1 doVerb: theVerb &rest)
		)
	)
)

(instance theHourGlass of View
	(properties
		x 5
		y 10
		view 40
		loop 1
	)

	(method (init)
		(glass setPri: 3 setCel: 0 init: stopUpd:)
		(sand setPri: 1 init: setCycle: Fwd startUpd:)
		(super init:)
	)

	(method (dispose)
		(glass dispose:)
		(sand dispose:)
		(rm40 setScript: 0)
		(super dispose:)
	)
)

(instance glass of Prop
	(properties
		view 40
	)

	(method (init)
		(self x: (+ (theHourGlass x:) 9) y: (+ (theHourGlass y:) 10))
		(super init:)
	)
)

(instance sand of Prop
	(properties
		view 40
		loop 2
	)

	(method (init)
		(self x: (+ (theHourGlass x:) 17) y: (+ (theHourGlass y:) 20))
		(super init:)
	)
)

(instance horse of Prop
	(properties
		noun 4
		view 40
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1) ; "The Baron was once known for his many fine and noble steeds. Only a few aging animals remain in his stable."
			)
			(4 ; Do
				(gMessager say: 4 4) ; "The Baron's horses aren't for sale."
			)
			(2 ; Talk
				(gMessager say: 4 2) ; "Neigh!"
			)
			(32 ; fruit
				(gMessager say: 4 32) ; "The horse happily munches on the apple."
			)
			(33 ; vegetables
				(gMessager say: 4 32) ; "The horse happily munches on the apple."
			)
			(36 ; flowers
				(gMessager say: 4 32) ; "The horse happily munches on the apple."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance horseHead of Extra
	(properties
		noun 3
		view 40
		loop 6
		cycleSpeed 3
		cycleType 1
		minPause 50
		maxPause 110
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1) ; "The Baron was once known for his many fine and noble steeds. Only a few aging animals remain in his stable."
			)
			(4 ; Do
				(gMessager say: 4 4) ; "The Baron's horses aren't for sale."
			)
			(2 ; Talk
				(gMessager say: 4 2) ; "Neigh!"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance horseTail of Extra
	(properties
		noun 4
		view 40
		loop 5
		cycleSpeed 12
		cycleType 1
		minPause 60
		maxPause 100
		minCycles 1
		maxCycles 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1) ; "The Baron was once known for his many fine and noble steeds. Only a few aging animals remain in his stable."
			)
			(4 ; Do
				(gMessager say: 4 4) ; "The Baron's horses aren't for sale."
			)
			(2 ; Talk
				(gMessager say: 4 2) ; "Neigh!"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance aDustCloud of Actor
	(properties
		view 40
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb &rest)
	)
)

(instance stableMan of Actor
	(properties
		noun 10
		approachX 209
		approachY 170
		view 42
	)

	(method (init)
		(super init:)
	)
)

(instance stableTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local2
					(gMessager say: 10 1 23) ; "A low-looking lout. HE could use some cleaning up."
				else
					(gMessager say: 10 1 22) ; "He's not standing where you can see him."
				)
			)
			(2 ; Talk
				(if (> local13 5)
					(gMessager say: 10 57 23) ; "Don't tire me out with a bunch of questions. Can't you see what a hard life I have?"
					(= local13 0)
				else
					(++ local13)
					(super doVerb: theVerb &rest)
				)
			)
			(81 ; flameDartSpell
				(EgoDead 90 91 0 3 39) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(20 ; rock
				(EgoDead 90 91 0 3 39) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(16 ; dagger
				(EgoDead 90 91 0 3 39) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(12 ; sword
				(EgoDead 90 91 0 3 39) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(else
				(super doVerb: &rest)
			)
		)
		(return 1)
	)
)

(instance horseEats of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(= seconds (Random 10 30))
			)
			(1
				(horseHead hide:)
				(horseTail hide:)
				(horse setLoop: 7 cel: 0 setCycle: End self)
			)
			(2
				(++ local0)
				(if (> (gEgo distanceTo: horse) 50)
					(horse loop: 8 setCycle: Fwd)
					(= ticks (Random 20 36))
				else
					(self cue:)
				)
			)
			(3
				(horse setCycle: 0)
				(= ticks (Random 72 150))
			)
			(4
				(if (< local0 (Random 3 6))
					(self changeState: 2)
				else
					(self cue:)
				)
			)
			(5
				(horse setLoop: 7 cel: 3 setCycle: Beg self)
			)
			(6
				(horse setLoop: 1 cel: 1 stopUpd:)
				(horseHead show:)
				(horseTail show:)
				(self changeState: 0)
			)
		)
	)
)

(instance sandsOfTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
				(theHourGlass setPri: 2 init: stopUpd:)
				(= ticks 220)
			)
			(1
				(++ local1)
				(glass setCel: (+ (glass cel:) 1))
				(= ticks 220)
			)
			(2
				(if (> local1 6)
					(glass setCel: 8)
					(sand setCycle: 0)
					(= ticks 60)
				else
					(self changeState: 1)
				)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance goToWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local10 (gEgo cycleSpeed:))
				(= local11 (gEgo moveSpeed:))
				(if (== gEgoGait 1) ; running
					(= local14 1)
				)
				(EgoGait 0 0) ; walking
				(if (== (gEgo onControl: 1) 2)
					(self cue:)
				else
					(stableMan setCycle: Beg self)
				)
			)
			(1
				(if (== (gEgo onControl: 1) 2)
					(self cue:)
				else
					(stableMan
						posn: 150 130
						setLoop: 1
						cel: 0
						setCycle: Walk
						setMotion: MoveTo 234 82 self
					)
				)
			)
			(2
				(stableMan stopUpd:)
				(if (== (gEgo onControl: 1) 2)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 114 128 self)
				)
			)
			(3
				(self cue:)
			)
			(4
				(SolvePuzzle 662 5)
				(ClearFlag 217)
				(client setScript: egoRakes)
			)
		)
	)
)

(instance egoRakes of Script
	(properties)

	(method (init)
		(SetFlag 217)
		(super init: &rest)
		(gLongSong fade: 127 20 1 1)
		(rakeMusic init: play:)
		(gLongSong stop:)
	)

	(method (doit)
		(cond
			(
				(and
					(== (gEgo cel:) 1)
					(or (== (self state:) 0) (== (self state:) 4))
				)
				(= local5 1)
			)
			((and local5 (== (gEgo cel:) 2))
				(= local5 0)
				(aDustCloud
					posn:
						(if local6
							(- (gEgo x:) (Random 15 30))
						else
							(+ (gEgo x:) (Random 15 30))
						)
						(gEgo y:)
					setScript: aDustScript
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not local7)
					(rm40 setScript: sandsOfTime)
				)
				(gGame setCursor: gWaitCursor)
				(gEgo
					view: 140
					setLoop: 0
					cel: 0
					setStep: 1 1
					setPri: 8
					illegalBits: 0
					cycleSpeed: (if local7 4 else 0)
					moveSpeed: (if local7 6 else 0)
					setCycle: Fwd
					setMotion: PolyPath 80 125 self
				)
				(aDustCloud
					setLoop: 9
					setPri: 9
					setStep: 6 4
					cel: 0
					cycleSpeed: 1
					ignoreActors:
					posn: 0 1000
					init:
				)
			)
			(1
				(gEgo setLoop: 2 cycleSpeed: 6 setCycle: Fwd)
				(if local7
					(= ticks 180)
				else
					(= ticks 60)
				)
			)
			(2
				(if local7
					(gMessager say: 8 0 4 1) ; "I DON'T PAY YOU TO REST! GET TO WORK! NOW!!!"
					(gEgo setLoop: 3 cycleSpeed: 6 setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(self cue:)
			)
			(4
				(if local7
				)
				(= local6 1)
				(gEgo
					setLoop: 1
					cel: 0
					cycleSpeed: (if local7 4 else 0)
					setCycle: Fwd
					setMotion: PolyPath 114 128 self
				)
			)
			(5
				(= ticks 18)
			)
			(6
				(= local6 0)
				(if local7
					(= local7 0)
					(manure3 setCel: 2)
					(NormalEgo)
					(gGame setCursor: gWaitCursor)
					(rakeMusic fade: 127 20 1 1)
					(UseStamina 25)
					(gLongSong number: (if gNight 32 else 25) init: play:)
					(client setScript: endRake)
				else
					(= local7 1)
					(manure1 setCel: 2)
					(manure2 setCel: 2)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance endRake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(AdvanceTime 3)
				(gEgo
					cycleSpeed: local10
					moveSpeed: local11
					setMotion: PolyPath 100 142 self
				)
			)
			(1
				(gEgo view: 140 setLoop: 5 cel: 0 setCycle: End self)
			)
			(2
				(NormalEgo)
				(gGame setCursor: gWaitCursor)
				(gEgo x: (- (gEgo x:) 2) loop: 2)
				(SkillUsed 0 25) ; strength
				(SkillUsed 3 40) ; vitality
				(rakeMusic stop:)
				(client setScript: getPaid)
			)
		)
	)
)

(instance getPaid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stableMan
					posn: 286 94
					setLoop: 0
					cel: 0
					show:
					setCycle: Walk
					setMotion: MoveTo 234 143 self
				)
				(= local3 1)
			)
			(1
				(stableMan posn: 225 128 setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 8 0 0 2) ; "OK. C'mon over here."
				(theHourGlass dispose:)
				(= ticks 56)
			)
			(3
				(gEgo setStep: 3 2 setMotion: PolyPath 205 161 self)
			)
			(4
				(NormalEgo)
				(gGame setCursor: gWaitCursor)
				(gEgo setMotion: PolyPath 209 156 self)
			)
			(5
				(stableMan setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(gEgo get: 0 5) ; silver
				(gMessager say: 8 0 0 3) ; "The stableman hands you some coins and says, "Now you're five silvers richer.""
				(self cue:)
			)
			(7
				(stableMan setCycle: Beg)
				(gEgo setMotion: PolyPath 208 155 self)
			)
			(8
				(= local2 1)
				(Face gEgo stableMan)
				(if local14
					(EgoGait 1 0) ; running
				)
				(gEgo moveSpeed: local11 cycleSpeed: local10)
				(gGame setCursor: 940)
				(= cycles 1)
			)
			(9
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sleeper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(horse setScript: 0)
				(horseTail setCycle: 0)
				(horseHead setCycle: 0)
				(gMessager say: 8 0 0 4 self) ; "You curl up on some clean hay and get some rest."
			)
			(1
				(if (== gNight 0)
					(FixTime 20)
				)
				(= cycles 1)
			)
			(2
				(if (== gNight 1)
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo hide:)
				(= cycles 5)
			)
			(4
				(gMessager say: 8 0 7 1 self) ; "Z-Z-Z-Z-Z-Z-Z-Z-Z-Z..."
			)
			(5
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 400 8)
				(= seconds 2)
			)
			(6
				(EgoSleeps 5 0)
				(= seconds 1)
			)
			(7
				(PalVary pvUNINIT)
				(= gNight 0)
				(= cycles 1)
			)
			(8
				(if (== gNight 0)
					(horse loop: 1 cel: 1 setCycle: 0 show:)
					(horseHead show:)
					(horseTail show:)
					(manure1 setCel: 0 show:)
					(manure2 setCel: 0 show:)
					(manure3 setCel: 0 show:)
					(gEgo show:)
					(client setScript: sleepyIntro)
				else
					(= cycles 1)
				)
			)
			(9
				(= gPrevRoomNum 999)
				(= gCurRoomNum 999)
				(NormalEgo)
				(= cycles 1)
			)
			(10
				(HandsOn)
				(gCurRoom newRoom: 40)
			)
		)
	)
)

(instance sleepyIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom drawPic: 40 100)
				(= seconds 1)
			)
			(1
				(gGame setCursor: gWaitCursor)
				(= seconds 1)
			)
			(2
				(gMessager say: 8 0 0 6 self) ; "It IS a rude awakening, however."
			)
			(3
				(gMessager say: 8 0 5 1 self) ; "WHAT DO YOU THINK THIS IS, A REST HOME??? GET TO WORK! NOW!!!"
			)
			(4
				(horse setScript: horseEats)
				(client setScript: goToWork)
			)
		)
	)
)

(instance aDustScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client
					setMotion:
						PolyPath
						(if local6
							(+ (gEgo x:) (Random 70 130))
						else
							(- (gEgo x:) (Random 70 130))
						)
						(- (+ (gEgo y:) 10) (Random 0 25))
					setCycle: End self
				)
			)
			(1
				(client posn: 0 1000 setMotion: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance intro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo onControl: 1) 4)
					(gEgo setMotion: 0)
					(stableMan
						posn: 234 82
						setLoop: 0
						setCel: 0
						setCycle: Walk
						setMotion: MoveTo 155 130 self
					)
					(= local3 1)
				else
					(self cue:)
				)
			)
			(1
				(if (== (gEgo onControl: 1) 4)
					(stableMan
						setLoop: 2
						cel: 0
						posn: 146 115
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(2
				(cond
					((IsFlag 217)
						(if (and (== gTimeOfDay 4) (== (gEgo onControl: 1) 2))
							(client setScript: 0)
						else
							(localproc_0)
							(HandsOff)
							(self changeState: 5)
						)
					)
					((IsFlag 229)
						(gMessager say: 8 0 0 7) ; "I see you're back. Need some work?"
						(HandsOff)
						(gGame setCursor: 999 1)
						(= ticks 60)
					)
					(else
						(SetFlag 229)
						(HandsOff)
						(if (== (gEgo onControl: 1) 2)
							(gMessager say: 8 0 0 8 gCurRoom) ; "Someone approaches you."
							(= seconds 3)
						else
							(gMessager say: 8 0 0 9 self) ; "You lookin' for some work?"
						)
					)
				)
			)
			(3
				(= seconds 1)
			)
			(4
				(gGame setCursor: 999 1)
				(switch
					(Print
						addButton: 0 8 0 3 1 0 25 40 ; "No"
						addButton: 1 8 0 6 1 0 5 40 ; "Yes"
						init:
					)
					(0
						(gMessager say: 8 0 0 12 self) ; "Too bad! I could use some help."
					)
					(1
						(if (== (gEgo onControl: 1) 2)
							(gMessager say: 8 0 0 10) ; "Good! Take a rake."
						else
							(gMessager say: 8 0 0 11) ; "Good! Come in here and take a rake."
						)
						(gGame setCursor: gWaitCursor 1)
						(gEgo setScript: goToWork)
					)
				)
			)
			(5
				(gGame setCursor: gWaitCursor 1)
				(HandsOn)
				(if (== (gEgo onControl: 1) 2)
					(self cue:)
				else
					(stableMan setCycle: Beg self)
				)
			)
			(6
				(if (== (gEgo onControl: 1) 2)
					(self cue:)
				else
					(stableMan
						posn: 150 130
						setLoop: 1
						cel: 0
						setCycle: Walk
						setMotion: MoveTo 234 82 self
					)
				)
			)
			(7
				(stableMan stopUpd:)
				(if (not (gEgo script:))
					(HandsOn)
				)
				(= local3 0)
				(client setScript: 0)
			)
		)
	)
)

(instance headWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(= ticks 30)
			)
			(1
				(if (> (gEgo y:) 125)
					(gEgo setMotion: PolyPath -15 (gEgo y:) self)
				else
					(gEgo setMotion: PolyPath -15 (- (gEgo y:) 15) self)
				)
			)
			(2
				(HandsOn)
				(if (> (gEgo y:) 125)
					(gCurRoom newRoom: 39)
				else
					(gCurRoom newRoom: 41)
				)
			)
		)
	)
)

