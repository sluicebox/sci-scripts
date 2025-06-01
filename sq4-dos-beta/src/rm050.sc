;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
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
)

(instance rm050 of SQRoom
	(properties
		picture 50
		style 30
		horizon 37
		north 35
		south 65
		west 45
		vanishingX 2
		vanishingY -25
	)

	(method (init)
		(LoadMany rsVIEW 50)
		(LoadMany rsSOUND 131 808 809 103 123)
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
					init: 319 135 319 189 291 189 284 185 278 170 290 165 292 161 253 161 233 146 232 136
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
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705) ; bunny
		(theHole init:)
		(theLiquid init:)
		(theSupports init:)
		(theSmallSupports init:)
		(theRedBldg init:)
		(theArea init:)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((or (& temp0 $0004) (& temp0 $0008) (& temp0 $0010))
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (== script fallScript) (== (gEgo edgeHit:) EDGE_BOTTOM)) 0)
			((and (== (gEgo edgeHit:) EDGE_TOP) (!= script exitScript))
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
			((and (== (gEgo edgeHit:) EDGE_TOP) (not (script register:)))
				(super newRoom: newRoomNumber)
			)
			((and (== (gEgo edgeHit:) EDGE_BOTTOM) (< (gEgo x:) 133))
				(= newRoomNumber 60)
				(super newRoom: 60)
			)
			(else
				(gLongSong fade: 0 10 10 1)
				(super newRoom: newRoomNumber)
			)
		)
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
				(gEgo view: 50 normal: 0 loop: 0 cel: 0 cycleSpeed: 1)
				(= cycles 5)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(= cycles 5)
			)
			(5
				(gEgo setCycle: CT 5 1 self)
				(grateSnd number: 809 loop: 1 vol: 25 play:)
				(theGrate hide:)
				(= cycles 7)
			)
			(6
				(grateSnd play:)
				(gEgo setCycle: CT 4 -1)
				(= cycles 3)
			)
			(7
				(grateSnd number: 808 loop: 1 vol: 127 play:)
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
				(gEgo hide:)
				(theGrate show:)
				(= cycles 2)
			)
			(11
				(if (gEgo has: 2) ; bomb
					(= seconds 2)
				else
					(gCurRoom newRoom: 70)
				)
			)
			(12
				(gLongSong number: 103 init: loop: 1 playBed:)
				(theGrate yStep: 20 setMotion: MoveTo (- (theGrate x:) 40) -100)
				(gEgo
					x: 83
					y: 89
					show:
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
			(13
				(theGrate
					yStep: 20
					setMotion: MoveTo (- (theGrate x:) 10) 101 self
				)
			)
			(14
				(grateSnd number: 809 loop: 1 play:)
				(theGrate setMotion: JumpTo (- (theGrate x:) 20) 111 self)
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
				(Print 50 0) ; "Given another opportunity in this thing we loosely refer to as life, I think UNSTABLE ORDNANCE would be low on your list of fun things to carry."
				(EgoDead 50 1) ; "Anyway, we hope you'll get yourself together and rejoin us. Isn't this a blast?"
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
				(Print 50 2) ; "Serious damage to important body parts, particularly those vital organs normally well-protected by the skeletal structure of the chest, pretty much screws-up any future plans you might have had for living. Bummer, eh?"
				(EgoDead 50 3) ; "Oh, well. Just think proudly of your accomplishmen... On second thought, just think - it happens to even IMPORTANT people!"
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
		sightAngle 45
		lookStr {This grate has a fair amount of crud, gunk, and sludge built up around the edges. You can see through the grate but can't make anything out.}
		view 50
		loop 2
		priority 4
		signal 30736
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
		sightAngle 45
		onMeCheck 2
		lookStr {The grate is anchored securely by bolts with mildly corroded heads.}
	)
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
		lookStr {A battered and boarded storefront shows the wear and tear a little war can inflict.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 50 4) ; "The building is closed-up with welded metal panels enhancing non-access."
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
		lookStr {A large void indicates the absence of any dense matter.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
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
		lookStr {A fluid-looking mass lying in the gutter is actually crystalized toxic run-off.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
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
			(4) ; Do
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

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are at the eastern boundary of a clearing in this ruined city. Passage to the east is stopped by a great void in the landscape.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4) ; Do
			(6 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
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

