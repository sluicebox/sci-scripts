;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use n078)
(use fileScr)
(use n082)
(use LarryRoom)
(use CycleBet)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
	local6
	local7
	local8
)

(instance rm310 of LarryRoom
	(properties
		noun 15
		picture 310
		horizon 0
		autoLoad 0
	)

	(method (init)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 14 132 14 155 90 168 99 136 134 130 175 130 202 137 211 148 283 156 283 139 312 126 304 105 283 106 235 92 224 98 224 109 99 110 99 99 84 93 53 103 20 99 6 109
					yourself:
				)
		)
		(gEgo init: normalize: 900 setScaler: Scaler 100 69 93 82)
		(if (!= gPrevRoomNum 340)
			(gGlobalSound1 number: 310 loop: -1 play: setVol: 127)
		)
		(enemaDoor init: approachVerbs: 4) ; Do
		(mensLockerDoor init: approachVerbs: 4) ; Do
		(girlsLockerDoor init: approachVerbs: 4) ; Do
		(lipoDoor init: approachVerbs: 4) ; Do
		(gary init: approachVerbs: 2 4 5 setScript: garyScr) ; Talk, Do, Take
		(switch gPrevRoomNum
			(320
				(gEgo x: 15 y: 94 loop: 8 cel: 4 heading: 135)
				(enemaDoor view: 312 cel: 5)
				(gCurRoom setScript: exitRm320)
			)
			(340
				(gEgo x: 83 y: 91 loop: 8 cel: 2 heading: 180)
				(mensLockerDoor view: 312 cel: 4)
				(gCurRoom setScript: mensLockerRoomDoorScr 0 1)
			)
			(330
				(gEgo x: 310 y: 101 loop: 8 cel: 5 heading: 225)
				(lipoDoor view: 316 cel: 5)
				(gCurRoom setScript: exitLipoRoom)
			)
			(else
				(gEgo x: 213 y: 190 loop: 8 cel: 3 heading: 360)
				(gCurRoom setScript: enterFromSouthScr)
			)
		)
		(switch global171
			(5
				(gammie init: posn: 241 170 setScript: gammieScr 0 0)
			)
			(6
				(gammie init: posn: 265 115 setScript: gammieScr 0 2)
			)
			(3
				(gammie init: posn: 241 200 setScript: gammieScr 0 3)
				(= global171 5)
			)
			(4
				(gammie init: posn: 241 200 setScript: gammieScr 0 1)
				(= global171 5)
			)
		)
		(brochure init: approachVerbs: 4 5) ; Do, Take
		(fountainWater init: setCycle: Fwd)
		(theSign init:)
		(desk init: approachVerbs: 4 5) ; Do, Take
		(towelRack init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(carpet init:)
		(rightLamp init:)
		(leftLamp init:)
		(upperLeftPlant init:)
		(lowerLeftPlant init:)
		(upperRightPlant init:)
		(lowerRightPlant init:)
		(statue init:)
		(fountain init: approachVerbs: 4 2 5 35) ; Do, Talk, Take, washcloth
		(rightPen init: approachVerbs: 4) ; Do
		(rightRegister init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(if (IsFlag 61)
			(= local0 1)
		else
			(helloTimer setReal: helloTimer (Random 20 40))
		)
	)

	(method (doit)
		(cond
			(script 0)
			((> (gEgo y:) 139)
				(self setScript: exitSouthScr)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(stenchTimer dispose: delete:)
		(helloTimer dispose: delete:)
		(flirtTimer dispose: delete:)
		(if (not (OneOf newRoomNumber 300 330 320 340))
			(gGlobalSound1 stop:)
		)
		(if (OneOf newRoomNumber 330 320 340)
			(gGlobalSound2 number: 0 stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance gammie of Actor
	(properties
		sightAngle 10
		x 239
		y 200
		view 203
		signal 24609
	)
)

(instance brochure of View
	(properties
		noun 1
		sightAngle 10
		approachX 226
		approachY 113
		x 207
		y 82
		priority 82
		fixPriority 1
		view 310
		signal 24609
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 71 214 71 214 85 200 85
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(if (gEgo has: 6) ; brochure
					(gMessager say: 1 5 4) ; "Deciding to conserve Earth's precious natural resources, you decide one of these brochures should be enough for anybody!"
				else
					(gCurRoom setScript: getBrochureScr)
				)
			)
			(4 ; Do
				(gCurRoom setScript: feelBrochureScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enemaDoor of Prop
	(properties
		noun 4
		sightAngle 10
		approachX 31
		approachY 99
		x 2
		y 96
		priority 96
		fixPriority 1
		view 313
		signal 26657
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (IsFlag 176)
				(gCurRoom setScript: enterRm320 0 1)
			else
				(gCurRoom setScript: enterRm320 0 0)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mensLockerDoor of Prop
	(properties
		noun 10
		sightAngle 10
		approachX 81
		approachY 94
		x 75
		y 90
		priority 90
		fixPriority 1
		view 313
		loop 1
		signal 26657
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: mensLockerRoomDoorScr 0 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance girlsLockerDoor of Prop
	(properties
		noun 7
		sightAngle 45
		approachX 232
		approachY 95
		x 222
		y 90
		priority 90
		fixPriority 1
		view 313
		loop 2
		signal 26657
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: tryGirlsLockerDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lipoDoor of Prop
	(properties
		noun 8
		sightAngle 10
		approachX 295
		approachY 106
		x 320
		y 109
		priority 100
		fixPriority 1
		view 313
		loop 3
		signal 26657
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: enterLipoRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fountainWater of Prop
	(properties
		noun 5
		sightAngle 10
		x 151
		y 140
		priority 200
		fixPriority 1
		view 313
		loop 4
		signal 26657
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Zipper
			(fountain doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance desk of Feature
	(properties
		noun 3
		sightAngle 10
		approachX 168
		approachY 110
		x 158
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 113 106 100 78 111 71 132 72 133 68 137 66 141 70 143 73 204 70 216 82 212 88 199 107 114 106
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance towelRack of Feature
	(properties
		noun 18
		sightAngle 10
		approachX 168
		approachY 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 117 69 108 27 162 30 209 30 200 71 118 69
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(= local6 4)
		(if (== theVerb 5) ; Take
			(cond
				((not (gEgo has: 22)) ; roomkey
					(gMessager say: 18 5 15) ; "Towels here are reserved for REGISTERED guests, not just any flake that wanders in from the parking lot."
				)
				((and (gEgo has: 38) (IsFlag 96)) ; towel
					(gMessager say: 18 5 10) ; "I'm stho sthorry, Misthter Laffer, but there isth a one-towel per custhtomer limit."
				)
				((gEgo has: 38) ; towel
					(gMessager say: 18 5 14) ; "I'm stho sthorry, Misthter Laffer, but there isth a one-towel per custhtomer limit."
				)
				(else
					(gCurRoom setScript: getTowel)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance carpet of Feature
	(properties
		noun 2
		sightAngle 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 95 73 91 107 92 112 104 198 105 207 89 253 91 298 104 302 108 273 102 265 104 268 107 290 111 269 111 272 116 285 114 283 121 296 117 283 128 308 123 296 138 194 138 194 129 169 120 166 109 142 120 122 123 106 131 104 139 10 139 0 124 0 120 22 126 9 115 33 118 22 111 43 115 36 108 22 106 45 102 39 99 11 103 15 97
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 5) ; Do, Take
			(gCurRoom setScript: carpetScr 0 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fountain of Feature
	(properties
		noun 5
		sightAngle 10
		approachX 184
		approachY 132
		approachDist 10
		x 148
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 104 139 105 131 118 125 144 120 143 131 150 135 155 132 152 130 153 120 184 126 195 133 195 139
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: fountainScr 0 theVerb)
			)
			(5 ; Take
				(gCurRoom setScript: fountainScr 0 theVerb)
			)
			(6 ; Zipper
				(gCurRoom setScript: pissInFountain)
			)
			(35 ; washcloth
				(gCurRoom setScript: wetCloth)
			)
			(37 ; washCloth [ chilled ]
				(gMessager say: 2 37 0 0 0 85) ; "If you re-wet your now-chilled washcloth, it won't be chilled any more."
			)
			(36 ; washCloth [ wet ]
				(gMessager say: 2 36 0 0 0 85) ; "Hey, you can never get a washcloth too wet!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftLamp of Feature
	(properties
		noun 9
		sightAngle 10
		x 44
		y 31
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 30 14 41 7 54 9 56 35 48 56 31 31
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightLamp of Feature
	(properties
		noun 14
		sightAngle 10
		x 292
		y 31
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 15 298 7 308 17 296 43 281 62 278 38
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPen of View
	(properties
		noun 11
		sightAngle 10
		x 172
		y 72
		priority 71
		fixPriority 1
		view 310
		loop 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 67 176 67 183 82 170 82
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightRegister of Feature
	(properties
		noun 13
		sightAngle 10
		approachX 184
		approachY 108
		x 188
		y 79
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 83 181 74 197 74 199 83
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((and (IsFlag 43) (== theVerb 4)) ; Do
				(= local6 4)
				(gMessager say: 13 4 10) ; "Oh, Sthir! You needn't sthign in again. I remember you... perfectly!"
			)
			((== theVerb 4) ; Do
				(gCurRoom setScript: signRegister 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upperLeftPlant of Feature
	(properties
		noun 12
		sightAngle 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 10 13 0 54 0 55 7 29 8 18 16 55 10 15 20 47 18 17 25 44 42 13 31 30 56 5 40 2 46
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lowerLeftPlant of Feature
	(properties
		noun 12
		sightAngle 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 53 14 50 16 55 6 57 17 60 10 66 6 63 2 94 23 87 8 96 30 90 40 91 38 95 12 99 7 102 40 98 38 103 24 106 42 112 38 114 23 111 25 117 14 113 8 114 19 124 4 121 4 127 10 139 4 138 0 135
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance upperRightPlant of Feature
	(properties
		noun 12
		sightAngle 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 296 0 306 11 285 6 297 13 288 21 279 16 281 25 274 25 276 31 270 37 264 28 264 35 259 35 258 14 256 37 252 39 243 24 249 6 242 18 239 15 244 5 223 11 220 8 245 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lowerRightPlant of Feature
	(properties
		noun 12
		sightAngle 10
		x 309
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 133 314 132 306 140 294 137 308 123 290 131 285 125 298 118 271 118 266 113 281 110 264 105 265 101 298 104 266 100 262 97 281 90 302 95 286 84 302 88 293 63 311 96 319 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance theSign of Feature
	(properties
		noun 16
		sightAngle 10
		x 153
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 20 79 12 83 13 100 0 212 0 227 11 239 12 245 21 240 33 235 33 233 42 220 47 204 39 206 34 180 27 172 32 160 28 150 32 142 27 120 28 111 30 108 41 95 46 86 41 87 37 76 35 71 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance statue of Feature
	(properties
		noun 17
		sightAngle 10
		x 148
		y 135
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 87 152 84 153 79 162 79 165 87 161 91 162 95 158 98 161 106 158 108 158 114 165 111 167 118 161 118 156 121 154 119 152 130 154 133 143 133 140 126 143 119 143 103 147 98
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gCurRoom setScript: fountainScr 0 theVerb)
			)
			((OneOf theVerb 5 2) ; Take, Talk
				(gCurRoom setScript: statueScr 0 theVerb)
			)
			((== theVerb 1) ; Look
				(gCurRoom setScript: lookStatueScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fountainScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo view: 901 setLoop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(= ticks 30)
			)
			(4
				(gMessager say: 5 register 0 0 self)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance feelBrochureScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 226 113 self)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager sayRange: 1 4 0 1 2 self) ; "Excuse me, sir. Do you mind if I fondle your brochure?"
			)
			(5
				(gEgo view: 901 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 1 4 0 6 self) ; "Rubbing your fingers across the brochure advertising La Costa Lotta's many fine services and features, you remark..."
			)
			(8
				(gMessager say: 1 4 0 7 self) ; "What an expensive feel!"
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(= cycles 2)
			)
			(11
				(gMessager say: 1 4 0 8 self) ; "Oh, no I'm not!"
			)
			(12
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBrochureScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 226 113 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 901 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(gMessager say: 1 5 0 0 self) ; "You never can tell when I might want to learn what other wonderful features are available here at lovely La Costa Lotta."
			)
			(5
				(= ticks 60)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 900 1 1 get: 6) ; brochure
				(gGame changeScore: 2 175 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance signRegister of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(SetFlag 43)
				(= local1 2)
				(gary cel: 0 setCycle: 0 setScript: 0)
				(gEgo setMotion: PolyPath 184 108 self)
			)
			(1
				(gEgo setHeading: 310 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if register
					(gMessager say: 13 4 0 0 self) ; "Shall I just sign my name here in the registry?"
				else
					(= cycles 2)
				)
			)
			(4
				(gEgo
					view: 314
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(5
				(rightPen hide:)
				(gEgo setCycle: End self)
			)
			(6
				(if (not (-- local1))
					(gEgo setCycle: CT 3 -1 self)
				else
					(-- state)
					(gEgo setCycle: CycleBet 7 10 3 self)
				)
			)
			(7
				(rightPen show:)
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo normalize: 900 7 1)
				(self setScript: getTowel self)
			)
			(9
				(gGame handsOn:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance statueScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 175 129 self)
			)
			(1
				(= ticks 10)
			)
			(2
				(if (!= (gEgo heading:) 270)
					(gEgo setHeading: 270 self)
				else
					(= cycles 2)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo view: 901 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(5
				(= ticks 30)
			)
			(6
				(if (== register 5)
					(gMessager say: 17 5 0 1 self) ; "(TRYING TO LIFT STATUE) Oof! Urgh! Hupppppp-aah!"
				else
					(gMessager say: 17 register 0 0 self)
				)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(if (OneOf register 4 2)
					(= state 11)
					(= ticks 30)
				else
					(gEgo view: 901 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
				)
			)
			(9
				(= cycles 2)
			)
			(10
				(gMessager say: 17 5 0 2 3 self) ; "The marble statue is far too heavy to lift."
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fountainWaterSfx of Sound ; UNUSED
	(properties
		flags 1
		loop -1
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance sfx2 of Sound ; UNUSED
	(properties
		flags 1
	)
)

(instance pissingSfx of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance doGaryScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 152])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 173 110 self)
			)
			(1
				(if (!= (gEgo heading:) 310)
					(gEgo setHeading: 310 self)
				else
					(= cycles 2)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					view: 908
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(4
				(sfx number: 1035 loop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(5
				(sfx number: 312 loop: 1 play: self)
			)
			(6
				(gMessager say: 6 6 0 0 self) ; "Oh, Sthweetie! I thought you'd never asthk!"
			)
			(7
				(gary setScript: 0 view: 310 setLoop: 2)
				(gGlobalSound1 number: 0 stop:)
				(gGlobalSound2 number: 0 stop:)
				(EgoDead 16 self)
			)
			(8
				(gGlobalSound1 number: 310 loop: -1 play: setVol: 127)
				(gary setScript: garyScr)
				(gEgo normalize: 900 7 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookStatueScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 17 1 0 1 self) ; "The figures of a beautifully-proportioned young couple embrace while water cascades down their naked bodies. Art like this really brings out your primal urges!"
			)
			(2
				(= seconds 3)
			)
			(3
				(gMessager say: 17 1 0 2 self) ; "(REVERB) Mommy! I gotta go bathroom!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mensLockerRoomDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(= state 5)
				else
					(gEgo loop: 8 cel: 3)
				)
				(= cycles 2)
			)
			(1
				(gEgo view: 901 setLoop: 6 cel: 0 setCycle: End self)
			)
			(2
				(sfx number: 1032 loop: 1 play: self)
			)
			(3
				(mensLockerDoor view: 312 setCycle: End self)
			)
			(4
				(gEgo
					view: 900
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 83 87 self
				)
			)
			(5
				(if (and (not (IsFlag 48)) local0)
					(-- state)
					(SetFlag 48)
					(gEgo setCycle: 0 cel: 4 setLoop: 3)
					(gMessager say: 6 2 10 0 self) ; "If you have any trouble in the locker room, justh sthqueal!"
					(gGlobalSound1 fade: 90 10 10 0)
				else
					(gGlobalSound1 setVol: 90)
					(gCurRoom newRoom: 340)
				)
			)
			(6
				(gGlobalSound1 fade: 127 10 10 0)
				(gEgo setLoop: 2 setCycle: Fwd setMotion: MoveTo 83 105 self)
			)
			(7
				(gEgo normalize: 900 2 1)
				(mensLockerDoor setCycle: Beg self)
			)
			(8
				(sfx number: 1033 loop: 1 play:)
				(mensLockerDoor view: 313)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitSouthScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 190 self)
				(gGlobalSound1 fade: 0 10 10 1)
			)
			(1
				(= ticks 120)
			)
			(2
				(= global180 (gEgo x:))
				(gGlobalSound1 number: 0 stop:)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance garyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(if (not (Random 0 1))
					(gary view: 311 setLoop: 1 cel: 0 setCycle: End self)
					(= register (Random 2 5))
				else
					(= state 3)
					(gary view: 311 setLoop: 2 cel: 0 setCycle: End self)
				)
			)
			(2
				(= ticks (Random 5 10))
			)
			(3
				(if (not (-- register))
					(= cycles 2)
				else
					(= state 1)
					(gary cel: 2 setCycle: End self)
				)
			)
			(4
				(gary cel: 0)
				(self init:)
			)
		)
	)
)

(instance carpetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< (gEgo heading:) 181)
					(gEgo setHeading: 45 self)
				else
					(gEgo setHeading: 270 self)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 901
					setLoop: (if (== (gEgo heading:) 45) 4 else 5)
					cel: 0
					setCycle: 0
				)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gMessager say: 2 register 0 0 self)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 900 1 1 ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wetCloth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo view: 901 setLoop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(= ticks 60)
			)
			(4
				(gGame changeScore: 6 250)
				(= global185 6)
				((gInventory at: 39) cue:) ; washcloth
				(gMessager say: 2 35 0 0 self 85) ; "You wet the washcloth in the water."
			)
			(5
				(= ticks 60)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRm320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					(register
						(gEgo
							view: 901
							setLoop: 1
							cel: 0
							setCycle: CT 3 1 self
						)
					)
					((and (> (gEgo heading:) 225) (< (gEgo heading:) 290))
						(= state 4)
						(= cycles 2)
					)
					(else
						(= state 4)
						(gEgo setHeading: 270 self)
					)
				)
			)
			(1
				(sfx number: 1034 loop: 1 play:)
				(= ticks 120)
			)
			(2
				(gMessager say: 4 4 11 0 self) ; "Evidently Rosie is on break. She's locked her door."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
			(5
				(gary setScript: 0 view: 310 setLoop: 2)
				(= cycles 2)
			)
			(6
				(gEgo view: 901 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(7
				(sfx number: 1032 loop: 1 play: self)
			)
			(8
				(enemaDoor view: 312 setCycle: End self)
			)
			(9
				(gEgo
					normalize: 900 1 1
					setLoop: 7
					setCycle: Fwd
					setMotion: MoveTo 16 96 self
				)
				(gGlobalSound1 fade: 30 10 10 1)
			)
			(10
				(gEgo setCycle: 0)
				(gGlobalSound1 number: 0 stop:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance tryGirlsLockerDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(gEgo setHeading: 270)
				(= ticks 30)
			)
			(1
				(gMessager say: 7 4 0 1 self) ; "Oh, don't go in there!"
			)
			(2
				(= ticks 30)
			)
			(3
				(gMessager say: 7 4 0 2 self) ; "Anyway, why would you want to? There'sth nothing insthide but women changing clothesth."
			)
			(4
				(= ticks 30)
			)
			(5
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitLipoRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(gEgo
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 293 113 self
				)
			)
			(1
				(gEgo normalize: 900 5 1)
				(lipoDoor setCycle: Beg self)
			)
			(2
				(sfx number: 1033 loop: 1 play:)
				(lipoDoor view: 313)
				(if (and (not (IsFlag 42)) (IsFlag 188))
					(SetFlag 42)
				)
				(if (and (== global171 9) (not (IsFlag 94)))
					(SetFlag 94)
					(gEgo setHeading: 270 self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(= local6 4)
				(gMessager say: 0 0 2 0 self) ; "I told you stho! Sthhe's justht not good enough for you, my little manhandler!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveGaryKey of Script
	(properties)

	(method (changeState newState &tmp [temp0 152])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(gEgo setMotion: PolyPath 173 110 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(if (!= (gEgo heading:) 310)
					(gEgo setHeading: 310 self)
				else
					(= cycles 2)
				)
			)
			(3
				(= ticks 90)
			)
			(4
				(gMessager say: 6 7 0 0 self) ; "Why, thank you, Honey! You can count on me!"
			)
			(5
				(EgoDead 16 self)
			)
			(6
				(gGlobalSound1 number: 310 loop: -1 play: setVol: 127)
				(gEgo normalize: 900 7 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gary of Prop
	(properties
		noun 6
		sightAngle 10
		approachX 168
		approachY 110
		x 148
		y 74
		priority 74
		fixPriority 1
		view 311
		loop 1
		signal 26657
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(= local6 4)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: talkToGary)
			)
			(6 ; Zipper
				(gCurRoom setScript: doGaryScr)
			)
			(7 ; roomkey
				(gCurRoom setScript: giveGaryKey)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (OneOf local6 3 1)) (== (gEgo view:) 909))
			(= local6 2)
			(flirtTimer setReal: flirtTimer 2)
		)
	)
)

(instance gammieScr of Script
	(properties)

	(method (dispose)
		(if global205
			(proc79_7)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(gammie
							setCycle: Walk
							ignoreActors: 0
							setMotion: MoveTo 265 115 self
						)
					)
					(3
						(= register 0)
						(= seconds 6)
						(-- state)
					)
					(else
						(= register 0)
						(= seconds 3)
						(-- state)
					)
				)
				(if (not global205)
					(proc79_8 2)
				)
			)
			(1
				(gammie setMotion: MoveTo 307 109 self)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90)
				)
			)
			(2
				(sfx number: 1032 loop: 1 play:)
				(gammie
					setLoop: 4
					cel: 3
					setCycle: 0
					setPri: (+ (lipoDoor priority:) 1)
					ignoreActors: 1
				)
				(lipoDoor view: 316 setCycle: End self)
				(= global171 6)
			)
			(3
				(gammie x: 308 y: 104 setPri: (- (lipoDoor priority:) 1))
				(= ticks 10)
				(gEgo setHeading: 45)
			)
			(4
				(lipoDoor setCycle: Beg self)
			)
			(5
				(sfx number: 1033 loop: 1 play:)
				(lipoDoor view: 313)
				(= global171 7)
				(gGame handsOn:)
				(gammie dispose:)
			)
		)
	)
)

(instance enterFromSouthScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 213 135 self)
			)
			(2
				(if (not (gammie script:))
					(gGame handsOn:)
					(gEgo normalize: 900 3 1)
				else
					(gEgo setHeading: 90)
				)
				(= global180 0)
				(if (and (IsFlag 55) (not (IsFlag 107)))
					(stenchTimer setReal: stenchTimer 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance stenchTimer of Timer
	(properties)

	(method (cue)
		(cond
			((OneOf local6 4 3 1))
			((not (proc79_14))
				(= local6 4)
				(gMessager say: 0 0 16) ; "Ooooh, my! New perfume?"
				(SetFlag 107)
			)
			(else
				(self setReal: self 3)
			)
		)
	)
)

(instance helloTimer of Timer
	(properties)

	(method (cue)
		(cond
			((OneOf local6 4 3))
			((== local6 1)
				(gGame handsOn:)
				(= local6 4)
			)
			((not (proc79_14))
				(gGame handsOff:)
				(cond
					((< (gEgo x:) 132)
						(gEgo setHeading: 45)
					)
					((> (gEgo x:) 173)
						(gEgo setHeading: 310)
					)
					(else
						(gEgo setHeading: 360)
					)
				)
				(gMessager sayRange: 1 4 0 3 5 self) ; "Hi, big boy! New around here?"
				(= local6 1)
			)
			(else
				(self setReal: self 3)
			)
		)
	)
)

(instance getTowel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(= cycles 2)
			)
			(1
				(= local8 (gEgo cycleSpeed:))
				(if (not (IsFlag 43))
					(gMessager say: 18 5 0 0 self) ; "I'm sthorry, Sthir! Guests are not allowed to justht help themselves to towelsth."
				else
					(gEgo normalize: 900 7 1 loop: 8 cel: 7)
					(++ state)
					(= cycles 2)
				)
			)
			(2
				(= next signRegister)
				(self dispose:)
			)
			(3
				(gary setLoop: 3 setCel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(4
				(gEgo setMotion: PolyPath 148 110 self)
			)
			(5
				(gEgo setHeading: 360 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gEgo
					view: 314
					setLoop: 1
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(8
				(gary cel: 0 setLoop: 1 setScript: garyScr)
				(= ticks 90)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo cycleSpeed: local8 get: 38 normalize: 900 3 1) ; towel
				(gGame handsOn: changeScore: 3 233)
				(if (not local0)
					(= local0 1)
					(SetFlag 61)
				)
				(self dispose:)
			)
		)
	)
)

(instance talkToGary of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(= cycles 2)
			)
			(1
				(if (not (gEgo has: 22)) ; roomkey
					(if (not local0)
						(= local0 1)
						(gMessager say: 6 2 12 0 self) ; "Hello."
					else
						(gMessager say: 6 2 13 0 self) ; "So I go left to find the front desk?"
					)
				else
					(switch (++ local0)
						(1
							(SetFlag 61)
							(gMessager say: 6 2 6 0 self) ; "Excuse me, sir. Is this where I get my spa towel?"
						)
						(2
							(gMessager say: 6 2 7 0 self) ; "It doesn't seem like there are enough customers here to warrant a full-time towel attendant."
						)
						(else
							(gMessager say: 6 2 8 0 self) ; "Did I mention I want you in the worsth way possthible?"
						)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flirtTimer of Timer
	(properties)

	(method (cue)
		(cond
			((OneOf local6 4 1))
			((== local6 3)
				(= local6 4)
				(gGame handsOn:)
			)
			((not (proc79_14))
				(gGame handsOff:)
				(gMessager say: 6 2 5 (Random 1 2) self)
				(= local6 3)
			)
			(else
				(self setReal: self 2)
			)
		)
	)
)

(instance exitRm320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(= cycles 2)
			)
			(1
				(gEgo setLoop: 4 setCycle: Fwd setMotion: MoveTo 28 109 self)
			)
			(2
				(gEgo normalize: 900 4 1)
				(enemaDoor setCycle: Beg self)
			)
			(3
				(sfx number: 1033 loop: 1 play:)
				(enemaDoor view: 313)
				(if (and (not (IsFlag 44)) (IsFlag 176))
					(SetFlag 44)
					(gEgo setHeading: 90 self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(= ticks 90)
			)
			(5
				(= local6 4)
				(gMessager say: 0 0 1 0 self) ; "What did she say?!"
			)
			(6
				(= cycles 2)
			)
			(7
				(gGame handsOn:)
				(= cycles 2)
				(proc78_0)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance enterLipoRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (== global100 2) (IsFlag 42))
					(gEgo view: 901 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
				else
					(= state 4)
					(= cycles 2)
				)
			)
			(1
				(sfx number: 1034 loop: 1 play:)
				(= ticks 120)
			)
			(2
				(gMessager say: 8 4 9 0 self) ; "The door to the Cellulite Drainage Salon is locked. Did you remember to pull out that little button in the knob when you left?"
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 900 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
			(5
				(if (== global171 7)
					(gEgo setHeading: 270)
					(gMessager say: 7 4 0 1 self) ; "Oh, don't go in there!"
				else
					(= state 9)
					(= cycles 2)
				)
			)
			(6
				(gMessager say: 0 0 3 1 self) ; "What doesth SHE have, that I don't have?!"
			)
			(7
				(gMessager say: 0 0 3 2 self) ; "I can think of at least TWO things!"
			)
			(8
				(gEgo setHeading: 90 self)
			)
			(9
				(= cycles 2)
			)
			(10
				(gEgo view: 901 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(11
				(sfx number: 1032 loop: 1 play: self)
				(lipoDoor view: 316 setCycle: End self)
			)
			(12)
			(13
				(gEgo
					view: 900
					setLoop: 6
					setCycle: Fwd
					setMotion: MoveTo 309 106 self
				)
			)
			(14
				(gEgo
					setPri: (- (lipoDoor priority:) 1)
					setMotion: MoveTo 319 99 self
				)
				(gGlobalSound1 fade: 30 10 10 1)
			)
			(15
				(gEgo hide:)
				(gGlobalSound1 number: 0 loop: 1 stop:)
				(= cycles 2)
			)
			(16
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance pissInFountain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 4)
				(proc79_11 351 1030 1035)
				(if (and (!= (gEgo x:) 203) (!= (gEgo y:) 138))
					(gEgo setMotion: PolyPath 203 138 self)
				else
					(= cycles 2)
				)
			)
			(1
				(if (!= (gEgo heading:) 310)
					(gEgo setHeading: 310 self)
				else
					(= cycles 2)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (not global205)
					(proc79_8 18)
				)
				(gEgo
					view: 908
					setLoop: 1 1
					cel: 0
					cycleSpeed: 4
					setCycle: CT 3 1 self
				)
			)
			(4
				(gEgo setCycle: CT 6 1 self)
				(sfx number: 1035 loop: 1 play:)
			)
			(5
				(if (== (++ local4) 1)
					(gMessager say: 5 6 0 0 self) ; "You never could resist the sound of running water!"
				else
					(self cue:)
				)
				(= local5 3)
			)
			(6
				(if (== local4 1)
					(gEgo setLoop: 3 1 cycleSpeed: 6 setCycle: Fwd)
					(pissingSfx number: 1030 loop: -1 play:)
					(= seconds 8)
				else
					(self cue:)
				)
			)
			(7
				(pissingSfx number: 0 stop:)
				(gEgo setLoop: 5 1 setCycle: 0 cel: 0)
				(= ticks 5)
			)
			(8
				(sfx number: 351 loop: 1 play:)
				(gEgo cel: 1)
				(= ticks 5)
			)
			(9
				(gEgo cel: 2)
				(= ticks 5)
			)
			(10
				(gEgo cel: 3)
				(if (-- local5)
					(= state 6)
				)
				(= ticks 60)
			)
			(11
				(if (> local4 1)
					(gMessager say: 12 6 25 1 self 630) ; "(Guess I didn't have to go!)"
				else
					(self cue:)
				)
			)
			(12
				(gEgo setLoop: 5 1 cel: 2 setCycle: End self)
				(sfx number: 1035 loop: 1 play:)
			)
			(13
				(gMessager say: 6 2 5 (Random 1 2) self)
			)
			(14
				(proc79_12 351 1030 1035)
				(gGame handsOn:)
				(gEgo normalize: 900 7 1 edgeHit: 0)
				(self dispose:)
			)
		)
	)
)

