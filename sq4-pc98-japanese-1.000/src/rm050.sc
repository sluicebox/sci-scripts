;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm050 0
	grateScript 1
)

(local
	[local0 26] = [108 0 140 69 139 88 121 145 147 170 182 164 161 98 160 76 271 0 190 0 158 40 153 37 145 0]
	[local26 30] = [0 42 45 38 32 11 41 0 72 0 115 30 122 31 136 62 136 66 140 69 140 73 69 84 55 84 32 78 0 51]
	[local56 6] = [251 59 170 70 229 29]
	[local62 38] = [141 189 109 157 109 143 122 137 120 145 147 170 183 165 172 129 238 118 240 120 226 126 244 137 244 144 255 153 272 157 293 154 288 173 295 185 304 189]
	[local100 26] = [0 51 31 78 55 83 72 84 139 73 140 87 123 136 111 141 104 150 94 157 94 165 117 189 0 189]
	[local126 16] = [249 60 223 85 252 92 236 118 173 128 162 98 161 78 170 70]
	[local142 10] = [0 56 5 56 21 70 9 71 0 62]
)

(instance rm050 of SQRoom
	(properties
		picture 50
		style 10
		horizon 37
		north 35
		south 65
		west 45
		vanishingX 2
		vanishingY -25
	)

	(method (init)
		(LoadMany rsVIEW 50)
		(LoadMany rsSOUND 131 808 809 103 123 147)
		(if (gEgo has: 2) ; bomb
			(Load rsVIEW 66)
			(Load rsSCRIPT 991)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 106 140 166 140 200 165 140 176
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 25 60 25 72 40 0 49 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 40 111 40 67 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 91 319 189 291 189 284 185 278 170 286 164 286 159 250 158 233 146 232 136 248 136 255 106
					yourself:
				)
		)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript)
			)
			(south
				(gEgo x: 255)
			)
			(else
				(gEgo x: 100 y: 160)
			)
		)
		(gEgo init:)
		(theGrate init:)
		(otherGrate init:)
		(grateSnd init:)
		(supportPoly points: @local0 size: 13)
		(sidewalk1Poly points: @local26 size: 15)
		(sidewalk2Poly points: @local56 size: 3)
		(sidewalk3Poly points: @local62 size: 19)
		(street1Poly points: @local100 size: 13)
		(street2Poly points: @local126 size: 8)
		(otherGratePoly points: @local142 size: 4)
		(self setRegions: 701) ; street
		(super init:)
		(self setRegions: 705) ; bunny
		(theHole init:)
		(theLiquid init:)
		(theSupports init:)
		(theSmallSupports init:)
		(theRedBldg init:)
		(street1 init:)
		(street2 init:)
		(sidewalk1 init:)
		(sidewalk2 init:)
		(sidewalk3 init:)
		(theArea init:)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			((gCurRoom script:) 0)
			(
				(or
					(& temp0 $0004)
					(& temp0 $0008)
					(& temp0 $0010)
					(& temp0 $0002)
					(& temp0 $4000)
				)
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== (gEgo edgeHit:) 3)
				(< (gEgo x:) 133)
				(!= (gCurRoom script:) (ScriptID 701 3)) ; cyborgScreams
				(!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
			)
			(super newRoom: 60)
		else
			(if (== newRoomNumber 70)
				(gLongSong fade: 0 10 10 1)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 50 -1 setMotion: MoveTo 85 47 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 15 -10 self)
			)
			(1
				(= register 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance grateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 68 85 self)
			)
			(1
				(gEgo setMotion: MoveTo 68 87 self)
			)
			(2
				(if (not (gEgo has: 2)) ; bomb
					(SetScore 42 5)
				)
				(gEgo view: 50 normal: 0 loop: 0 cel: 0 cycleSpeed: 1)
				(= cycles 5)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(= cycles 3)
			)
			(5
				(grateSnd number: 809 loop: 1 vol: 25 play:)
				(= cycles 2)
			)
			(6
				(gEgo setCycle: CT 5 1 self)
				(theGrate hide:)
				(= cycles 7)
			)
			(7
				(grateSnd play:)
				(gEgo setCycle: CT 4 -1)
				(= cycles 3)
			)
			(8
				(grateSnd number: 808 loop: 1 vol: 127 play:)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo
					loop: 1
					cel: 0
					x: (+ (gEgo x:) 35)
					y: (- (gEgo y:) 1)
					setCycle: CT 5 1 self
				)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(grateSnd number: 809 play:)
				(gEgo x: 500)
				(theGrate show:)
				(= cycles 5)
			)
			(12
				(if (gEgo has: 2) ; bomb
					(= seconds 2)
				else
					(gCurRoom newRoom: 70)
				)
			)
			(13
				(gLongSong number: 103 vol: 127 loop: 1 playBed:)
				(theGrate yStep: 20 setMotion: MoveTo (- (theGrate x:) 40) -100)
				(explosion
					init:
					x: 83
					y: 89
					view: 66
					loop: 0
					cel: 0
					setCycle: End
					ignoreActors: 1
				)
				(armBit
					init:
					setMotion: JumpTo (- (armBit x:) 15) (+ (armBit y:) 30)
				)
				(legBit
					init:
					setMotion: JumpTo (- (armBit x:) 15) (- (armBit y:) 30)
				)
				(headBit
					init:
					setMotion: JumpTo (+ (armBit x:) 30) (+ (armBit y:) 10)
				)
				(= seconds 5)
			)
			(14
				(theGrate
					yStep: 20
					setMotion: MoveTo (- (theGrate x:) 10) 101 self
				)
			)
			(15
				(grateSnd number: 809 loop: 1 play:)
				(theGrate setMotion: JumpTo (- (theGrate x:) 20) 111 self)
			)
			(16
				(grateSnd number: 123 play:)
				(theGrate setMotion: JumpTo (- (theGrate x:) 5) 113 self)
			)
			(17
				(grateSnd play:)
				(= seconds 3)
			)
			(18
				(Print 50 0) ; "Given another opportunity in this thing we loosely refer to as life, I think UNSTABLE ORDNANCE would be low on your list of fun things to carry."
				(EgoDead 6 4)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((& register $0008)
						(gEgo setPri: 0)
					)
					((& register $0010)
						(gEgo setPri: 1)
					)
					((& register $0004)
						(gEgo setPri: 2)
					)
					((& register $0002)
						(gEgo setPri: 3)
					)
					((& register $4000)
						(gEgo setPri: 4)
					)
				)
				(gEgo
					x: (+ (gEgo x:) 8)
					y: (+ (gEgo y:) 12)
					setLoop: (gEgo loop:)
				)
				(gLongSong number: 131 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(1
				(gEgo
					yStep: 20
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 250) self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(gLongSong fade: 0 1 2 1)
				(= seconds 1)
			)
			(4
				(gLongSong number: 147 loop: 1 vol: 127 play:)
				(Print 50 1) ; "Serious damage to important body parts, particularly those vital organs normally well-protected by the skeletal structure of the chest, pretty much screws up any future plans you might have had for living. Bummer, eh?"
				(EgoDead 0 8)
			)
		)
	)
)

(instance theGrate of Actor
	(properties
		x 84
		y 91
		heading 170
		description {grate}
		sightAngle 40
		view 50
		loop 2
		signal 30736
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 50 2) ; "This grate has a fair amount of crud, gunk, and sludge built up around the edges. You can see through the grate but can't make anything out."
			)
			(3 ; Do
				(if (gCurRoom script:)
					0
				else
					(HandsOff)
					(gCurRoom setScript: grateScript)
				)
			)
			(11 ; Smell
				(Print 50 3) ; "The cool, rank smell of a sewer wafts up from underground."
			)
			(10 ; Taste
				(Print 50 4) ; "Okay, you taste grate and find it less filling."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 0)
		)
	)
)

(instance otherGrate of Feature
	(properties
		x 10
		y 66
		nsBottom 200
		nsRight 320
		description {grate}
		sightAngle 40
	)

	(method (init)
		(super init:)
		(self onMeCheck: otherGratePoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 50 5) ; "The grate is anchored securely by bolts with mildly corroded heads."
			)
			(3 ; Do
				(Print 50 6) ; "The bolted down grate won't budge."
			)
			(11 ; Smell
				(Print 50 3) ; "The cool, rank smell of a sewer wafts up from underground."
			)
			(10 ; Taste
				(Print 50 4) ; "Okay, you taste grate and find it less filling."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherGratePoly of Polygon
	(properties)
)

(instance theRedBldg of Feature
	(properties
		x 294
		y 143
		nsBottom 200
		nsRight 320
		description {red building}
		sightAngle 45
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 50 7) ; "A battered and boarded storefront shows the wear and tear a little war can inflict."
			)
			(3 ; Do
				(Print 50 8) ; "The building is closed up with welded metal panels enhancing non-access."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theHole of Feature
	(properties
		x 249
		y 76
		nsBottom 200
		nsRight 320
		description {hole}
		sightAngle 45
		onMeCheck 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 50 9) ; "A large void indicates the absence of any dense matter."
			)
			(11 ; Smell
				(Print 50 10) ; "As is so often the case with voids, there is nothing to smell."
			)
			(10 ; Taste
				(Print 50 11) ; "As is so often the case with voids, there is nothing to taste."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theLiquid of Feature
	(properties
		x 116
		y 174
		nsBottom 200
		nsRight 320
		description {crystalized liquid}
		sightAngle 45
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 50 12) ; "A fluid-looking mass lying in the gutter is actually crystalized toxic run-off."
			)
			(3 ; Do
				(Print 50 13) ; "It would serve no purpose."
			)
			(11 ; Smell
				(Print 50 14) ; "It's probably the most nauseating thing to smell in the whole non-liquid liquid family of smells."
			)
			(10 ; Taste
				(Print 50 15) ; "It's definitely the most nauseating thing to taste in the whole non-liquid liquid family of tastes."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSupports of Feature
	(properties
		x 154
		y 149
		description {supports}
		sightAngle 45
		lookStr {Huge supports miraculously still do just that to these buildings.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: supportPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance supportPoly of Polygon
	(properties)
)

(instance theSmallSupports of Feature
	(properties
		x 10
		y 10
		nsBottom 200
		nsRight 320
		description {supports}
		sightAngle 45
		onMeCheck 8192
		lookStr {Huge supports miraculously still do just that to these buildings.}
	)
)

(instance street1 of Feature
	(properties
		description {street}
		sightAngle 40
	)

	(method (init)
		(super init:)
		(self onMeCheck: street1Poly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 50 16) ; "I'll bet you're getting bored with these street descriptions so, in an effort to decrease the message tedium to some degree, I won't go into some long description about the grates or the sizeable void to the east. Happy adventuring!"
			)
			(11 ; Smell
				(Print 50 17) ; "After being away for so long, you'd forgotten how rancid the streets of Xenon smell."
			)
			(10 ; Taste
				(Print 50 18) ; "The artificial taste of the Xenon road makes you long for the all-natural flavor of unpaved country lanes."
			)
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance street1Poly of Polygon
	(properties)
)

(instance street2 of Feature
	(properties
		description {street}
	)

	(method (init)
		(super init:)
		(self onMeCheck: street2Poly)
	)

	(method (doVerb theVerb invItem)
		(street1 doVerb: theVerb invItem)
	)
)

(instance street2Poly of Polygon
	(properties)
)

(instance sidewalk1 of Feature
	(properties
		description {sidewalk}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk1Poly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 50 19) ; "You are at the eastern boundary of a clearing in this ruined city. Passage to the east is stopped by a great void in the landscape."
			)
			(11 ; Smell
				(Print 50 20) ; "You smell the sidewalk, and it smells back."
			)
			(10 ; Taste
				(Print 50 21) ; "You give the sidewalk a lick and accidentally step on a crack. Somewhere, your mother screams out in agony, her spinal cord snapped cleanly in half. Of course, she probably deserved it for the way she spazzed-out and threw away those magazines she found in your room that time back in junior high. Those things cost you a lot of good lunch money!"
			)
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalk1Poly of Polygon
	(properties)
)

(instance sidewalk2 of Feature
	(properties
		description {sidewalk}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk2Poly)
	)

	(method (doVerb theVerb invItem)
		(sidewalk1 doVerb: theVerb invItem)
	)
)

(instance sidewalk2Poly of Polygon
	(properties)
)

(instance sidewalk3 of Feature
	(properties
		description {sidewalk}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk3Poly)
	)

	(method (doVerb theVerb invItem)
		(sidewalk1 doVerb: theVerb invItem)
	)
)

(instance sidewalk3Poly of Polygon
	(properties)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 50 22) ; "You are at the eastern boundary of a clearing in this ruined city. Passage to the east is stopped by a great void in the landscape."
			)
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance explosion of Prop
	(properties)
)

(instance armBit of Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		signal 30720
	)
)

(instance legBit of Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		cel 1
		signal 30720
	)
)

(instance headBit of Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		cel 2
		signal 30720
	)
)

(instance grateSnd of Sound
	(properties
		number 808
		priority 15
	)
)

