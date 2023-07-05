;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
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
	rm58 0
	brauggiTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 7] = [0 2 8 -1 6 3 999]
	[local14 5] = [0 4 7 5 999]
	[local19 5]
	[local24 3] = [0 -1 999]
)

(instance unknown_58_0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 6 50 0 1 self) ; "The Giant (who does not seem pleased at your casting a spell in his presence) radiates a magical aura. The strongest magic centers on the glowing gem at his belt."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance giantBlocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (Random 4 8))
				(= local0 0)
				(swishSound init:)
				(giant setLoop: 1 cel: 1 cycleSpeed: 12 posn: 164 53 setPri: 12)
				(self cue:)
			)
			(1
				(swishSound play:)
				(giant setCycle: CT 4 1 self)
			)
			(2
				(= cycles (Random 10 20))
			)
			(3
				(swishSound play:)
				(giant setCycle: CT 0 1 self)
			)
			(4
				(= cycles (Random 10 20))
			)
			(5
				(if (!= (++ local0) local1)
					(self changeState: 1)
				else
					(= seconds (Random 5 15))
				)
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance rm58 of Rm
	(properties
		noun 6
		picture 58
		style 8
		west 57
	)

	(method (dispose)
		(SetFlag 48)
		(super dispose:)
	)

	(method (init)
		(= [local19 0] @local7)
		(= [local19 1] @local14)
		(= [local19 2] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 0 189 0 162 41 183 141 183 194 130 179 126 130 126 97 153 0 153
					yourself:
				)
		)
		(LoadMany rsSOUND 47 2009)
		(LoadMany rsVIEW 5 517 503)
		(if (not (= local4 (IsFlag 208)))
			(LoadMany rsVIEW 59 502 513 515)
			(LoadMany rsSOUND 48 2059 2065 2014)
		)
		(super init:)
		(unknown_58_13 init:)
		(cave init: setOnMeCheck: 26505)
		(yellowSnow init: setOnMeCheck: 26505)
		(sky init: setOnMeCheck: 26505)
		(moreSky init: setOnMeCheck: 26505)
		(snowRock init: setOnMeCheck: 26505)
		(log init: setOnMeCheck: 26505)
		(mountain init: setOnMeCheck: 26505)
		(snow init: setOnMeCheck: 26505)
		(snowyRocks init: setOnMeCheck: 26505)
		(gLongSong fade:)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(if local4
			(gLongSong number: 47)
			(gEgo posn: 1 158 init: setMotion: MoveTo 25 158)
			(HandsOn)
		else
			(gLongSong number: 48)
			(frostSound number: 2014 init:)
			(gEgo posn: 1 158 init: setScript: egoInit)
			(caveMouth init:)
			(giantTeller init: giant @local7 @local19 @local24)
		)
		(gLongSong loop: 1 play: self)
	)

	(method (cue)
		(switch local6
			(1
				(if (not (gCast contains: giant))
					(if (IsFlag 208)
						(gMessager say: 6 1 18) ; "Brauggi has departed on the long journey to his homeland."
					else
						(gMessager say: 6 1 19) ; "Brauggi has become impatient with your questions and gone elsewhere. You will have to return another time."
					)
				)
			)
			(2
				(if (not (gEgo has: 17)) ; magicGem
					(gMessager say: 2 1 9) ; "The gem glows like an aurora in the night sky."
				)
			)
			(else
				(gLongSong number: 47 loop: -1 play:)
			)
		)
		(= local6 0)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(= local6 1)
				(gMessager say: 6 1 0 0 self) ; "The mountains rise quickly from this point and are covered with snow. To the west, you can see that the snow has melted in most of the forest, but here it is still heavy."
			)
			(50 ; detectMagicSpell
				(if (CastSpell temp0) ; UNINIT
					(unknown_58_13 setScript: unknown_58_0)
				)
			)
			(77 ; triggerSpell or Pickup Inventory
				(giant setScript: giantMagic)
			)
			(78 ; dazzleSpell
				(giant setScript: giantMagic)
			)
			(80 ; calmSpell
				(giant setScript: giantMagic)
			)
			(81 ; flameDartSpell
				(giant setScript: giantMagic)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo view:) 5) (not (gEgo script:)))
			(gEgo setScript: egoRuns)
		)
	)
)

(instance cave of Feature
	(properties
		x 165
		y 51
		noun 1
		nsTop 57
		nsLeft 133
		nsBottom 99
		nsRight 197
		sightAngle 40
	)
)

(instance yellowSnow of Feature
	(properties
		x 77
		y 123
		noun 11
		nsTop 121
		nsLeft 71
		nsBottom 126
		nsRight 83
		sightAngle 40
	)
)

(instance sky of Feature
	(properties
		x 241
		y 93
		z 81
		noun 7
		nsTop 1
		nsLeft 215
		nsBottom 23
		nsRight 267
		sightAngle 40
	)
)

(instance moreSky of Feature
	(properties
		x 97
		y 113
		z 110
		noun 4
		nsLeft 80
		nsBottom 7
		nsRight 114
		sightAngle 40
	)
)

(instance snowRock of Feature
	(properties
		x 88
		y 116
		z 21
		noun 8
		nsTop 78
		nsLeft 56
		nsBottom 112
		nsRight 121
		sightAngle 40
	)
)

(instance log of Feature
	(properties
		x 237
		y 183
		z 19
		noun 3
		nsTop 151
		nsLeft 168
		nsBottom 177
		nsRight 307
		sightAngle 40
	)
)

(instance mountain of Feature
	(properties
		x 273
		y 108
		z 70
		noun 5
		nsTop 29
		nsLeft 230
		nsBottom 48
		nsRight 317
		sightAngle 40
	)
)

(instance snow of Feature
	(properties
		x 15
		y 112
		z 76
		noun 10
		nsTop 17
		nsBottom 56
		nsRight 31
		sightAngle 40
	)
)

(instance snowyRocks of Feature
	(properties
		x 273
		y 95
		noun 9
		nsTop 69
		nsLeft 232
		nsBottom 121
		nsRight 315
		sightAngle 40
	)
)

(instance legs of View
	(properties
		x 164
		y 114
		view 59
		loop 4
		priority 12
		signal 17
	)

	(method (doVerb theVerb)
		(giant doVerb: theVerb &rest)
	)
)

(instance unknown_58_13 of Prop
	(properties
		x 500
		y 500
		view 0
	)
)

(instance caveMouth of Prop
	(properties
		x 137
		y 36
		view 59
		loop 7
		priority 6
		signal 16
	)

	(method (doVerb theVerb)
		(cave doVerb: theVerb &rest)
	)
)

(instance giant of Actor
	(properties
		x 167
		y 100
		noun 2
		yStep 3
		view 59
		illegalBits 0
		xStep 5
	)

	(method (init)
		(super init: &rest)
	)
)

(instance giantTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1 0 0 gCurRoom) ; "From the blue color of his skin and his huge height, you can tell this is a Frost Giant."
				(return 1)
			)
			(4 ; Do
				(giant setScript: Challenge)
				(return 1)
			)
			(12 ; sword
				(= local5 1)
				(giant setScript: giantFights)
				(return 1)
			)
			(16 ; dagger
				(giant setScript: giantFights)
				(return 1)
			)
			(20 ; rock
				(= local3 1)
				(giant setScript: giantMagic)
				(return 1)
			)
			(32 ; fruit
				(giant setScript: giveFruit)
				(return 1)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(81 ; flameDartSpell
				(giant setScript: giantMagic)
				(return 1)
			)
			(else
				(if
					(OneOf
						theVerb
						34 ; acorn
						42 ; candelabra
						44 ; candleSticks
						46 ; cheetaurClaw
						16 ; dagger
						38 ; fairyDust
						21 ; flask
						36 ; flowers
						39 ; flyingWater
						32 ; fruit
						29 ; ghostOil
						37 ; greenFur
						22 ; healingPotion
						26 ; brassKey
						14 ; leather
						17 ; lockPick
						27 ; magicGem
						23 ; manaPotion
						31 ; mandrake
						30 ; magicMirror
						40 ; mushroom
						43 ; musicBox
						45 ; pearls
						53 ; paper
						11 ; rations
						28 ; ring
						20 ; rock
						35 ; seed
						15 ; shield
						10 ; silver
						24 ; staminaPotion
						12 ; sword
						18 ; thiefKit
						19 ; thiefLicense
						47 ; trollBeard
						41 ; vase
						33 ; vegetables
					)
					(gMessager say: 2 1 10) ; "The Giant looks at you in disgust. Apparently, you did not offer what he desires."
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance frostSound of Sound
	(properties
		number 2014
		priority 2
	)
)

(instance swishSound of Sound
	(properties
		number 2059
	)
)

(instance egoInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setPri: 14 setMotion: PolyPath 144 142 self)
			)
			(1
				(giant
					setPri: 14
					setLoop: 0
					init:
					actions: giantTeller
					hide:
					setScript: giantInit
				)
				(self cue:)
			)
			(2
				(Face client giant)
				(client setScript: 0)
			)
		)
	)
)

(instance giantInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(caveMouth setCycle: End self)
			)
			(1
				(= seconds 1)
			)
			(2
				(giant show: setCycle: End self)
			)
			(3
				(giant setCel: 3 setCycle: CT 7 1 self)
			)
			(4
				(caveMouth setCycle: Beg)
				(frostSound number: 2059 play:)
				(giant
					posn: 164 53
					setLoop: 1
					cycleSpeed: 18
					setPri: 13
					cel: 0
					setCycle: CT 3 1 self
				)
				(legs actions: giantTeller init:)
			)
			(5
				(frostSound play:)
				(giant setCel: 3 setCycle: CT 7 1 self)
			)
			(6
				(if (not (IsFlag 48))
					(gMessager say: 2 5 8 0 self) ; "Far from the frost field, fares forth this fighter, Hunger has hurled me hither from home."
				)
				(HandsOn)
			)
			(7
				(caveMouth dispose:)
				(client setScript: giantBlocks)
			)
		)
	)
)

(instance giantExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 6 0 11 1 self) ; "Brauggi strides off through the cave on his way back to his Northern home."
			)
			(1
				(legs dispose:)
				(giant
					setLoop: 3
					setCel: -1
					cel: 0
					posn: 172 112
					setCycle: 0
					cycleSpeed: 12
					setPri: 14
					illegalBits: 0
				)
				(caveMouth init: setCycle: End self)
			)
			(2
				(caveMouth stopUpd:)
				(giant setCycle: CT 2 1 self)
			)
			(3
				(giant setPri: (- (caveMouth priority:) 1) setCel: 3 hide:)
				(caveMouth setCycle: Beg self)
			)
			(4
				(giant dispose:)
				(caveMouth dispose:)
				(gLongSong number: 47 play:)
				(= local4 1)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance doneDeal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 6 0 0 0 self) ; "Fruit you have found, to fill all my food stores, Thus filled the bargain, my gem you have bought."
			)
			(1
				(gEgo get: 17 1) ; magicGem
				(SetFlag 208)
				(SolvePuzzle 679 8)
				(giant setScript: giantExits)
			)
		)
	)
)

(instance ShowOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(frostSound number: 2059 play:)
				(giant
					cycleSpeed: 12
					posn: (- (giant x:) 6) (+ (giant y:) 29)
					setLoop: 2
					cel: 0
					setCycle: End self
				)
			)
			(1
				(if (== gHowFast 0)
					(self cue:)
				else
					(giant setCycle: End self)
				)
			)
			(2
				(frostSound stop:)
				(client setScript: 0)
			)
		)
	)
)

(instance Challenge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: ShowOff self)
			)
			(1
				(gMessager say: 2 5 3 1 self) ; "Fiercer than frost's bite, my fury is fearless, My axe it is edged as is the ice."
			)
			(2
				(HandsOn)
				(giant setScript: giantBlocks)
			)
		)
	)
)

(instance WalkToGiant of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(if (< (gEgo y:) (+ (giant y:) 10))
					(gEgo setMotion: PolyPath 144 142 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo ignoreActors: 0 illegalBits: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giantFights of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(if (and (!= (gEgo x:) 163) (!= (gEgo y:) 127))
					(gEgo setMotion: MoveTo 163 127 self)
				else
					(self cue:)
				)
			)
			(1
				(self cue:)
			)
			(2
				(= temp0 (if local5 0 else 2))
				(gEgo
					view: 502
					setLoop: temp0
					cel: 0
					setCycle: End self
					illegalBits: 0
					ignoreActors:
				)
			)
			(3
				(if (== temp0 0) ; UNINIT
					(gEgo view: 501 setLoop: 0 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(if (== temp0 0) ; UNINIT
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(5
				(if (== temp0 0) ; UNINIT
					(gEgo view: 501 setLoop: 2 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(6
				(if (== temp0 0) ; UNINIT
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(7
				(if (== temp0 0) ; UNINIT
					(gEgo view: 501 setLoop: 4 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(8
				(if (== temp0 0) ; UNINIT
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(9
				(frostSound number: 2059 play:)
				(giant
					setLoop: 2
					cel: 0
					posn: (- (giant x:) 6) (+ (giant y:) 29)
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(10
				(gEgo
					view: 513
					posn: (gEgo x:) 144
					setLoop: 1
					setCel: -1
					cel: 0
					illegalBits: 0
				)
				(= temp2 (gEgo x:))
				(= temp3 (gEgo y:))
				(= temp4 144)
				(= temp5 142)
				(= temp6 (/ (- temp4 temp2) (- (gEgo lastCel:) 5)))
				(= temp7 (/ (- temp5 temp3) (- (gEgo lastCel:) 5)))
				(giant setCycle: End self)
				(gEgo xStep: temp6 yStep: temp7 setCycle: CT 5 1)
			)
			(11
				(frostSound play:)
				(if (IsFlag 213)
					(gEgo setCel: 5 setCycle: CT 8 1)
				)
				(giant setCycle: Beg self)
			)
			(12
				(frostSound stop:)
				(= ticks 120)
			)
			(13
				(if (or (IsFlag 213) (not (TakeDamage 20)))
					(EgoDead 86 87 3 0 59) ; "Next time, pick on someone your own size."
				else
					(SetFlag 213)
					(self cue:)
				)
			)
			(14
				(giant
					setLoop: 1
					setCel: -1
					posn: (+ (giant x:) 6) (- (giant y:) 29)
					cel: 0
					setPri: 11
					setCycle: End self
				)
			)
			(15
				(gEgo
					view: 515
					posn: 143 140
					setLoop: 1
					setCel: 5
					setCycle: CT 0 -1 self
				)
			)
			(16
				(NormalEgo)
				(gEgo loop: 3 posn: 144 142 setPri: 13 forceUpd:)
				(self setScript: ShowOff self)
			)
			(17
				(gMessager say: 6 0 0 4) ; "Courage you carry,  but skill it is scanty; Face not this foe  before fiercer you fight."
				(HandsOn)
				(giant setScript: giantBlocks)
				(self dispose:)
			)
		)
	)
)

(instance giveFruit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 22) ; fruit
					(+= global276 (gEgo use: 22 50)) ; fruit
					((gInventory at: 22) amount: 1) ; fruit
				)
				(HandsOff)
				(if (< (gEgo y:) (+ (giant y:) 10))
					(gEgo setMotion: PolyPath 144 142 self)
				else
					(self cue:)
				)
			)
			(1
				(if (gEgo has: 22) ; fruit
					(gEgo use: 22) ; fruit
					(cond
						((>= global276 50)
							(giant setScript: doneDeal)
						)
						((>= global276 40)
							(gMessager say: 6 0 12 1 self) ; "Your fruit definitely makes a generous pile in the Giant's cupped hands, but they're not full yet."
						)
						((== global276 0)
							(gMessager say: 6 0 15 1 self) ; "Oops. You're not carrying any fruit for the Frost Giant."
						)
						(else
							(gMessager say: 6 0 16 1 self) ; "Your meagre selection of fruit makes a paltry pile at the bottom of the Giant's cupped hands. You'll need to get quite a few more apples to fill THOSE hands!"
						)
					)
				else
					(gMessager say: 6 0 15 1 self) ; "Oops. You're not carrying any fruit for the Frost Giant."
				)
			)
			((HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giantMagic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(if (and (!= (gEgo x:) 163) (!= (gEgo y:) 133))
					(gEgo setMotion: MoveTo 163 133 self)
				else
					(self cue:)
				)
			)
			(1
				(if local3
					(gMessager say: 6 0 17 1 self) ; "As you start to throw..."
				else
					(gMessager say: 6 0 14 1 self) ; "As you begin to cast your spell..."
				)
			)
			(2
				(giant
					setLoop: 2
					posn: (- (giant x:) 6) (+ (giant y:) 29)
					setCel: 0
				)
				(= ticks 120)
			)
			(3
				(giant setCel: 1)
				(frostSound number: 2065 play: self)
				(= cycles 2)
			)
			(4
				(giant setCel: 2)
				(= cycles 2)
			)
			(5
				(giant setCel: 3 stopUpd:)
				(frostSound number: 2014 play:)
				(gEgo
					view: 513
					posn: (+ (gEgo x:) 20) (gEgo y:)
					setPri: 14
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(6
				(EgoDead 116 117 0 0 59) ; "In matters of magic, I am your master Seek not to slay me with Sendings so small."
			)
		)
	)
)

(instance egoRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: 0 setMotion: 0)
				(= ticks 10)
			)
			(1
				(gEgo
					illegalBits: 0
					ignoreActors:
					view: 5
					setPri: 14
					setCycle: Walk
				)
				(self cue:)
			)
			(2
				(frostSound number: 2009 play:)
				(gEgo
					view: 3
					setLoop: 0
					setCel: -1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(frostSound stop:)
				(= cycles 8)
			)
			(4
				(gEgo setLoop: 1 cel: 0 illegalBits: -32768)
				(self cue:)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gMessager say: 6 0 13 1 self) ; "Running on the ice is apparently not a very good idea."
				(EgoGait 0 0) ; walking
				(TakeDamage 2)
			)
			(7
				(HandsOn)
				(proc814_32 1)
				(NormalEgo)
				(gEgo setPri: 14)
				(self dispose:)
			)
		)
	)
)

(instance brauggiTalker of Talker
	(properties
		x 10
		y 10
		view 1059
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: brauggiBust brauggiEye brauggiMouth &rest)
	)
)

(instance brauggiBust of Prop
	(properties
		view 1059
		loop 1
	)
)

(instance brauggiMouth of Prop
	(properties
		nsTop 53
		nsLeft 38
		view 1059
		loop 2
	)
)

(instance brauggiEye of Prop
	(properties
		nsTop 29
		nsLeft 45
		view 1059
		loop 4
	)
)

