;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
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
			((== (gEgo edgeHit:) EDGE_TOP)
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== (gEgo edgeHit:) EDGE_BOTTOM)
				(< (gEgo x:) 133)
				(!= (gCurRoom script:) (ScriptID 701 3)) ; cyborgScreams
				(!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
			)
			(super newRoom: 60)
		else
			(if (== newRoomNumber 70)
				(gLongSong fade: 0 10 10 1)
				(Lock rsSOUND 116 0)
				(Lock rsVIEW 105 0)
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
				(gEgo view: 50 normal: 0 loop: 0 cel: 0 cycleSpeed: 12)
				(= cycles 5)
			)
			(3
				(gEgo setCycle: CT 4 1 self)
			)
			(4
				(grateSnd number: 809 loop: 1 play: setVol: 127)
				(= cycles 1)
			)
			(5
				(theGrate hide:)
				(gEgo setCycle: CT 5 1 self)
			)
			(6
				(grateSnd play:)
				(gEgo setCycle: CT 4 -1)
				(= cycles 3)
			)
			(7
				(grateSnd number: 808 loop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(8
				(gEgo
					loop: 1
					cel: 0
					x: (+ (gEgo x:) 35)
					y: (- (gEgo y:) 1)
					setCycle: CT 5 1 self
				)
			)
			(9
				(gEgo setCycle: End self)
			)
			(10
				(grateSnd number: 809 play:)
				(gEgo x: 500)
				(theGrate show:)
				(= seconds 3)
			)
			(11
				(if (gEgo has: 2) ; bomb
					(= ticks 60)
				else
					(gCurRoom newRoom: 70)
				)
			)
			(12
				(gLongSong number: 103 setVol: 127 loop: 1 playBed:)
				(theGrate yStep: 20 setMotion: MoveTo (- (theGrate x:) 40) -100)
				(explosion
					x: 83
					y: 89
					view: 66
					loop: 0
					cel: 0
					init:
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
			(13
				(theGrate
					setPri: 15
					yStep: 20
					setMotion: MoveTo (- (theGrate x:) 10) 101 self
				)
			)
			(14
				(grateSnd number: 809 loop: 1 play:)
				(theGrate
					setPri: -1
					setMotion: JumpTo (- (theGrate x:) 20) 111 self
				)
			)
			(15
				(grateSnd number: 123 play:)
				(theGrate setMotion: JumpTo (- (theGrate x:) 5) 113 self)
			)
			(16
				(grateSnd play:)
				(= seconds 3)
			)
			(17
				(gNarrator say: 1 self) ; "I would think that something identifiable as UNSTABLE ORDNANCE would be low on your list of fun and healthy things to carry."
			)
			(18
				(EgoDead 6 4) ; "We hope you'll get yourself together and rejoin us. Isn't this a blast?"
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
				(gLongSong number: 131 loop: 1 setVol: 127 play:)
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
				(gLongSong number: 147 loop: 1 setVol: 127 play:)
				(gNarrator say: 2) ; "Serious damage to important body parts, pretty much screws up any future plans you might have had for living. Bummer!"
				(EgoDead 0 8) ; "Oh, well. Just think proudly of your accomplishment... On second thought, just think - it even happens to IMPORTANT people!"
			)
		)
	)
)

(instance theGrate of Sq4Actor
	(properties
		x 84
		y 91
		heading 170
		sightAngle 40
		view 50
		loop 2
		signal 26640
		lookStr 3 ; "This grate has crud, gunk, and sludge built up around the edges. You can see through the grate but can't make anything out."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(HandsOff)
					(gCurRoom setScript: grateScript)
				)
			)
			(6 ; Smell
				(gNarrator say: 4) ; "The cool, rank smell of a sewer wafts up from underground."
			)
			(7 ; Taste
				(gNarrator say: 5) ; "Okay, you taste grate and find it less filling."
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

(instance otherGrate of Sq4Feature
	(properties
		x 10
		y 66
		nsBottom 200
		nsRight 320
		sightAngle 40
		lookStr 6 ; "The grate is anchored securely by bolts with mildly corroded heads."
	)

	(method (init)
		(super init:)
		(self onMeCheck: otherGratePoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 7) ; "The bolted down grate won't budge."
			)
			(6 ; Smell
				(gNarrator say: 4) ; "The cool, rank smell of a sewer wafts up from underground."
			)
			(7 ; Taste
				(gNarrator say: 5) ; "Okay, you taste grate and find it less filling."
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

(instance theRedBldg of Sq4Feature
	(properties
		x 294
		y 143
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 1024
		lookStr 8 ; "A battered and boarded storefront shows the wear and tear a little war can inflict."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 9) ; "The building is closed up with welded metal panels."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theHole of Sq4Feature
	(properties
		x 249
		y 76
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 28
		lookStr 10 ; "A large void indicates the absence of any dense matter."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 11) ; "As is so often the case with voids, there is nothing to smell."
			)
			(7 ; Taste
				(gNarrator say: 12) ; "As is so often the case with voids, there is nothing to taste."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theLiquid of Sq4Feature
	(properties
		x 116
		y 174
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 64
		lookStr 13 ; "A fluid-looking mass lying in the gutter is actually crystalized toxic run-off."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 14) ; "It would serve no purpose."
			)
			(6 ; Smell
				(gNarrator say: 15) ; "It's probably the most nauseating thing to smell in the whole family of smells."
			)
			(7 ; Taste
				(gNarrator say: 16) ; "It's definitely the most nauseating thing to taste in the whole non-liquid liquid family of tastes."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSupports of Sq4Feature
	(properties
		x 154
		y 149
		sightAngle 45
		lookStr 17 ; "Huge supports miraculously still do just that to these buildings."
	)

	(method (init)
		(super init:)
		(self onMeCheck: supportPoly)
	)
)

(instance supportPoly of Polygon
	(properties)
)

(instance theSmallSupports of Sq4Feature
	(properties
		x 10
		y 10
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 8192
		lookStr 17 ; "Huge supports miraculously still do just that to these buildings."
	)
)

(instance street1 of Sq4Feature
	(properties
		sightAngle 40
	)

	(method (init)
		(super init:)
		(self onMeCheck: street1Poly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 18) ; "You're probably getting bored with these street descriptions so, in an effort to decrease the message tedium to some degree, I won't go into some long description about the grates or the sizeable void to the east. Happy adventuring!"
			)
			(6 ; Smell
				(gNarrator say: 19) ; "After being away for so long, you'd forgotten how rancid the streets of Xenon smell."
			)
			(7 ; Taste
				(gNarrator say: 20) ; "The artificial taste of the Xenon road makes you long for the all-natural flavor of unpaved country lanes."
			)
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
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

(instance street2 of Sq4Feature
	(properties
		y 1
	)

	(method (init)
		(super init:)
		(self onMeCheck: street2Poly)
	)

	(method (doVerb theVerb)
		(street1 doVerb: theVerb)
	)
)

(instance street2Poly of Polygon
	(properties)
)

(instance sidewalk1 of Sq4Feature
	(properties
		y 2
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk1Poly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 21) ; "You are at the eastern boundary of a clearing in this ruined city. Passage to the east is impossible due to a great void in the landscape."
			)
			(6 ; Smell
				(gNarrator say: 22) ; "You smell the sidewalk, and it smells back."
			)
			(7 ; Taste
				(gNarrator say: 23) ; "You give the sidewalk a lick and accidentally step on a crack. Somewhere, your mother screams out in agony, her spinal cord snapped cleanly in half. Of course, she probably deserved it for the way she threw away those magazines she found in your room that time back in junior high. Those things cost you a lot of good lunch money!"
			)
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
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

(instance sidewalk2 of Sq4Feature
	(properties
		y 2
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk2Poly)
	)

	(method (doVerb theVerb)
		(sidewalk1 doVerb: theVerb)
	)
)

(instance sidewalk2Poly of Polygon
	(properties)
)

(instance sidewalk3 of Sq4Feature
	(properties
		y 2
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk3Poly)
	)

	(method (doVerb theVerb)
		(sidewalk1 doVerb: theVerb)
	)
)

(instance sidewalk3Poly of Polygon
	(properties)
)

(instance theArea of Sq4Feature
	(properties
		y 1
		nsBottom 200
		nsRight 320
		lookStr 21 ; "You are at the eastern boundary of a clearing in this ruined city. Passage to the east is impossible due to a great void in the landscape."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance explosion of Sq4Prop
	(properties)
)

(instance armBit of Sq4Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		signal 26624
	)
)

(instance legBit of Sq4Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		cel 1
		signal 26624
	)
)

(instance headBit of Sq4Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		cel 2
		signal 26624
	)
)

(instance grateSnd of Sound
	(properties
		number 808
		priority 15
	)
)

