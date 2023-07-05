;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 375)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use eRS)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Motion)
(use Actor)
(use System)

(public
	rm375 0
)

(local
	[local0 10] = [0 0 206 0 183 28 85 76 0 82]
	local10 = 65
)

(instance rm375 of SQRoom
	(properties
		picture 375
		style 10
		east 380
		south 370
		west 370
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(cond
			((and (!= gPrevRoomNum 376) (not (IsFlag 9)))
				(gLongSong2 number: 19 loop: -1 flags: 1 playBed: 0)
			)
			((IsFlag 9)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
		)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 49)
					(= temp1 237)
				else
					(= temp0 -16)
					(= temp1 181)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 333)
					(= temp1 78)
				else
					(= temp0 327)
					(= temp1 -8)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(else
				(gLongSong number: 405 loop: -1 vol: 95 flags: 1 play:)
				(self setScript: fromStoreScript 0 (> (gEgo x:) 160))
			)
		)
		(light1 init: setCycle: Fwd)
		(light2 init: setCycle: Fwd)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 149 0 63 51 114 47 125 44 128
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 298 0 224 39 216 39 208 38 106 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 123 28 150 74 118 91 84 49
					yourself:
				)
		)
		(signPoly points: @local0 size: 5)
		(gEgo init: setPri: -1)
		(self
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 319 121 319 189 185 189 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 21 319 66 215 117 174 95
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 185 132 116 170 140 72 189
					yourself:
				)
		)
		(self setRegions: 700) ; mall
		(gFeatures addToFront: store bush1 bush2 eachElementDo: #init doit:)
	)

	(method (doit &tmp temp0)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) local10 0)) 0)
				(= temp0 0)
			)
			((> temp0 300)
				(= temp0 300)
			)
		)
		(gLongSong2 vol: (- 127 (/ temp0 3)) changeState:)
		(cond
			(script 0)
			((== (gEgo edgeHit:) 2)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((or (== (gEgo edgeHit:) 4) (== (gEgo edgeHit:) 3))
				(if (StepOn gEgo 4)
					(gEgo
						edgeHit: EDGE_NONE
						setMotion: 0
						posn: (+ (gEgo x:) 3) (- (gEgo y:) 4)
					)
				else
					(HandsOff)
					((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
					(self setScript: (ScriptID 700 2) 0 west) ; exS
				)
			)
			((StepOn gEgo 8)
				(gCurRoom newRoom: 376)
			)
			((StepOn gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1) ; mall
				(proc700_5 0)
				(gLongSong fade: 127 10 5 0)
			)
			((StepOn gEgo 2)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2) ; mall
				(proc700_5 0)
				(gLongSong fade: 95 10 5 0)
			)
			((or (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2)
				(proc700_5 1)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance fromStoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: (if register 149 else 70)
					y: (if register 43 else 82)
					setHeading: 135
					setMotion: MoveFwd 20 self
				)
			)
			(1
				(proc700_5 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		yStep 1
		xOff 3
		yOff 1
		xTweak 1
		yTweak 1
		key 225
		head 63
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		yStep 1
		xOff 1
		yOff 1
		xTweak 1
		yTweak 1
		key 45
		head 242
		xDir -1
		yDir 1
	)
)

(instance door of PicView ; UNUSED
	(properties
		x 21
		y 82
		description {door}
		sightAngle 90
		view 375
		loop 2
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 375 0) ; "This store seems to be closed. A security door blocks the entrance."
			)
			(3 ; Do
				(Print 375 1) ; "It's locked down tight. You can't open it."
			)
			(11 ; Smell
				(Print 375 2) ; "It smells like the kind of place where unwashed teen-agers stand around smoking, sweating and performing other unmentionable teen-age acts."
			)
			(10 ; Taste
				(Print 375 3) ; "It tastes like it smells."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		x 30
		y 110
		description {sign}
		view 375
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 375 4) ; "These lights are hypnotic. Maybe they're some of those "subliminal optic stimulators" you've read about. As you gaze into their glare, you become very hungry for sushi."
			)
			(11 ; Smell
				(Print 375 2) ; "It smells like the kind of place where unwashed teen-agers stand around smoking, sweating and performing other unmentionable teen-age acts."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance signPoly of Polygon
	(properties)
)

(instance light2 of Prop
	(properties
		x 214
		y 20
		description {sign}
		view 375
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 375 4) ; "These lights are hypnotic. Maybe they're some of those "subliminal optic stimulators" you've read about. As you gaze into their glare, you become very hungry for sushi."
			)
			(11 ; Smell
				(Print 375 2) ; "It smells like the kind of place where unwashed teen-agers stand around smoking, sweating and performing other unmentionable teen-age acts."
			)
			(10 ; Taste
				(Print 375 3) ; "It tastes like it smells."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance store of Feature
	(properties
		description {Arcade}
	)

	(method (onMe param1)
		(return
			(<= 49 (/ (* 100 (- 145 (param1 y:))) (Max 1 (param1 x:))))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 375 5) ; "Ah! An arcade!. It's "Buckazoid Bill's Arcade and Sushi Bar.""
			)
			(11 ; Smell
				(Print 375 2) ; "It smells like the kind of place where unwashed teen-agers stand around smoking, sweating and performing other unmentionable teen-age acts."
			)
			(10 ; Taste
				(Print 375 3) ; "It tastes like it smells."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Feature
	(properties
		x 68
		y 145
		nsTop 129
		nsLeft 62
		nsBottom 153
		nsRight 84
		description {fabricated flora}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 375 6) ; "This is a fine example of the wonders of fabricated flora."
			)
			(11 ; Smell
				(Print 375 7) ; "There's a fresh woodsy scent coming from the plants."
			)
			(10 ; Taste
				(Print 375 8) ; "Urp...somebody's dumped their potpourri on these plants."
			)
			(3 ; Do
				(Print 375 9) ; "Get some taste! These are phoney mall plants!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Feature
	(properties
		x 260
		y 45
		nsTop 31
		nsLeft 254
		nsBottom 57
		nsRight 276
		description {fabricated flora}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 375 6) ; "This is a fine example of the wonders of fabricated flora."
			)
			(11 ; Smell
				(Print 375 7) ; "There's a fresh woodsy scent coming from the plants."
			)
			(10 ; Taste
				(Print 375 8) ; "Urp...somebody's dumped their potpourri on these plants."
			)
			(3 ; Do
				(Print 375 9) ; "Get some taste! These are phoney mall plants!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

