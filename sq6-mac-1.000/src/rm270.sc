;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use SQRoom)
(use Hover)
(use ExitFeature)
(use SQNarrator)
(use n666)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
	Nigel 1
	sForceFieldDeactvtd 2
)

(local
	local0 = 1
)

(instance rm270 of SQRoom
	(properties
		noun 1
		picture 270
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 7 110 7 122 50 126 102 128 154 128 154 110 212 110 280 123 318 123 318 116 275 116 211 106 130 106 90 103
					yourself:
				)
		)
		(super init:)
		(Load 140 272 273 21024) ; WAVE
		(Load rsVIEW 272 273 274 275 279)
		(Load 140 373) ; WAVE
		(gEgo
			posn: 330 124
			normalize: 1
			ignoreActors: 1
			setScaler: Scaler 78 78 141 98
			init:
		)
		(cond
			((not (IsFlag 56))
				(SetFlag 56)
				(nigel init: approachVerbs: 26 setScript: sNigelAtWork) ; ???
			)
			((IsFlag 440)
				(gEgo setMotion: MoveTo 305 116)
				(gGame handsOn:)
			)
			(else
				(gEgo setMotion: MoveTo 305 116)
				(nigel init: approachVerbs: 26 setCycle: RandCycle) ; ???
				(gGame handsOn:)
			)
		)
		(if (not (IsFlag 80))
			(forcefield init: approachVerbs: 4 3) ; Do, Walk
			(ffGenerator init: setCycle: Fwd)
		)
		(if (and (IsFlag 440) (not (IsFlag 441)))
			(belt init:)
		)
		(if (> (gGame detailLevel:) 2)
			(radar init: setCycle: Fwd)
			(panel init: setCycle: Fwd)
			(hotel init: setCycle: Fwd)
			(arrow init: setCycle: Fwd)
		)
		(discharge init: setCycle: Fwd)
		(game init: setCycle: Fwd)
		(chair init:)
		(city init: approachVerbs: 4) ; Do
		(poster1 init: approachVerbs: 4) ; Do
		(poster2 init: approachVerbs: 4) ; Do
		(RollerMachine init: approachVerbs: 4) ; Do
		(box1 init: approachVerbs: 4) ; Do
		(box2 init: approachVerbs: 4) ; Do
		(box3 init: approachVerbs: 4) ; Do
		(doorLights init: approachVerbs: 4) ; Do
		(controlBox init:)
		(desk init: approachVerbs: 4) ; Do
		(wallUnit init: approachVerbs: 4) ; Do
		(pipe init: approachVerbs: 4) ; Do
		(fDischarge init:)
		(terrace init:)
		(lamp init:)
		(if (not (IsFlag 442))
			(fForcefield init: approachVerbs: 4) ; Do
		)
		(exit260 init: gTheExitECursor approachVerbs: 7) ; ExitRight
		(PalCycle 0 158 160 -1 10) ; Start
		(PalCycle 0 206 207 -1 10) ; Start
		(PalCycle 0 216 223 -1 10) ; Start
	)

	(method (notify)
		(gTheIconBar setupExit: 0)
		((gCurRoom inset:) dispose:)
		(gEgo setScript: sRescueShip)
	)

	(method (doit)
		(cond
			((not (IsFlag 80))
				(if (and (fForcefield onMe: gEgo) local0)
					(= local0 0)
					(gEgo setScript: sRogerThrownBack)
				)
			)
			((IsFlag 80)
				(if (< (gEgo x:) 140)
					(SetFlag 184)
				else
					(ClearFlag 184)
				)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 80)
					(gMessager say: 1 4 4) ; "The room is no longer giving off that low-level hum."
				else
					(gMessager say: 1 4 3) ; "The room seems to be vibrating ever so slightly, the telltale residue of a local damping field."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sRogerThrownBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sound1 number: 373 loop: 0 play:)
				(forcefield view: 272 loop: 1 cel: 0 setCycle: End)
				(gEgo
					posn: 274 104
					view: 272
					setLoop: 0 1
					cel: 0
					setScaler: Scaler 100 100 141 98
					setCycle: End self
				)
			)
			(1
				(gEgo
					posn: 283 118
					view: 272
					loop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(= local0 1)
				(gEgo setScaler: Scaler 78 78 141 98 normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNigelAtWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 305 116 self)
				(nigel loop: 0 setCycle: End)
			)
			(1
				(gMessager say: 21 2 5 0 self) ; "Well, well, well, the worm is out of the hole, so ..."
			)
			(2
				(nigel loop: 0 cel: 0 setCycle: RandCycle)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNigelPoundsRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(nigel
					view: 273
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(nigel loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(nigel hide:)
				(gEgo
					posn: 285 117
					view: 274
					loop: 0
					cel: 0
					cycleSpeed: 10
					setScaler: Scaler 100 100 141 98
					setCycle: CT 4 1 self
				)
			)
			(3
				(sound1 number: 276 loop: 0 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(4
				(proc666_0 3 self)
			)
			(5
				(nigel show: view: 271 loop: 0 cel: 0 setCycle: RandCycle)
				(gEgo
					posn: 302 124
					normalize: 1
					setScaler: Scaler 78 78 141 98
				)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNigelStriptease of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 3 440 handsOff:)
				(gGSound1 stop:)
				(gGSound2 number: 270 flags: 1 loop: -1 play:)
				(gMessager say: 0 0 7 1) ; "Thinking it was the churlish moddie, he pops it in place."
				(gEgo put: 15) ; Burlesque_Moddie_4
				(nigel
					view: 273
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(nigel
					posn: 285 127
					view: 275
					loop: 0
					cel: 0
					setPri: 116
					setCycle: End self
				)
			)
			(2
				(belt init: approachVerbs: 4) ; Do
				(nigel view: 2750 cel: 0 loop: 0 setCycle: End self)
			)
			(3
				(nigel view: 2751 cel: 0 loop: 0 setCycle: End self)
			)
			(4
				(nigel cel: 5 setCycle: Beg self)
			)
			(5
				(nigel cel: 0 setCycle: End self)
			)
			(6
				(nigel cel: 0 loop: 1 setCycle: End self)
			)
			(7
				(nigel view: 2752 cel: 0 loop: 0 setCycle: End self)
			)
			(8
				(nigel cel: 0 loop: 1 setCycle: End self)
			)
			(9
				(nigel view: 2753 cel: 0 loop: 0 setCycle: End self)
			)
			(10
				(gGSound2 stop:)
				(gGSound1 number: 260 flags: 1 loop: -1 play:)
				(nigel dispose:)
				(gEgo normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRescueShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (> (gGame detailLevel:) 2)
					(discharge setCycle: End)
				)
				(SetFlag 159)
				(sound1 number: 272 loop: 0 play:)
				(rescueShip init: setCycle: End self)
			)
			(2
				(gEgo setMotion: PolyPath 148 110 self)
			)
			(3
				(DisposeScript 900)
				(gEgo setHeading: 270 self)
			)
			(4
				(if (> (gGame detailLevel:) 2)
					(PalCycle 0 200 205 -1 10) ; Start
				)
				(sound2 number: 273 loop: 1 play:)
				(rescueShip
					setLoop: 2 1
					setPri: 140
					cel: 0
					x: 16
					y: -40
					setMotion: MoveTo 16 20 self
				)
			)
			(5
				(rescueShip setMotion: DPath 32 44 24 55 16 41 self)
			)
			(6
				(rescueShip setMotion: Hover 8 40)
				(= cycles 1)
			)
			(7
				(nigel
					posn: 318 119
					setScaler: Scaler 78 78 141 98
					view: 276
					loop: 0
					cel: 0
					init:
				)
				(sound1 number: 923 loop: 0 play:)
				(gGSound1 number: 275 loop: -1 play:)
				(santiago init: cycleSpeed: 12 loop: 0 setCycle: End self)
				(if (> (gGame detailLevel:) 2)
					(dust init: setCycle: Fwd)
				)
			)
			(8
				(gMessager say: 0 0 10) ; "Hey! Here's your fish!"
				(nigel setCycle: End)
				(santiago loop: 1 setCycle: End self)
			)
			(9
				(gEgo setMotion: PolyPath 128 110 self)
			)
			(10
				(gEgo loop: 1 cel: 0 setCycle: CT 1 1 self)
			)
			(11
				(gEgo hide:)
				(santiago view: 279 loop: 0 cel: 0 setCycle: CT 9 1 self)
			)
			(12
				(sound1 number: 923 loop: 0 play:)
				(santiago loop: 0 cel: 10 setCycle: End self)
			)
			(13
				(santiago loop: 1 cel: 0 setCycle: End self)
			)
			(14
				(santiago view: 279 loop: 2 cel: 0 setCycle: End self)
			)
			(15
				(santiago dispose:)
				(gEgo put: 0 get: 28 setScale: 0) ; Actuator, Dead_Fish
				(gCurRoom newRoom: 420)
				(self dispose:)
			)
		)
	)
)

(instance sOffWorld of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(offWorld setCycle: Rev setMotion: MoveTo -60 54 self)
			)
			(1
				(offWorld dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerGetsChurlish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 437))
					(gEgo
						view: 2730
						cel: 0
						loop: 0
						cycleSpeed: 12
						setCycle: End self
					)
					(gMessager say: 8 4 1 0 self) ; "You poke and prod amongst the moddies until you find ..."
				else
					(gEgo
						view: 2730
						cel: 0
						loop: 0
						cycleSpeed: 12
						setCycle: CT 9 1 self
					)
					(gMessager say: 8 4 2 0 self) ; "You pick through the carton of moddies and find ..."
				)
			)
			(1)
			(2
				(if (not (IsFlag 437))
					(gEgo
						get: 20 ; Churlish_Moddie_1
						view: 2730
						cel: 0
						loop: 1
						setCycle: End self
					)
				else
					(gEgo view: 2730 cel: 1 loop: 1 setCycle: End self)
				)
			)
			(3
				(gEgo normalize: 7)
				(gGame points: 1 437 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sForceFieldDeactvtd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 3 442 handsOff:)
				(SetFlag 80)
				(gEgo cycleSpeed: 12 setHeading: 270 self)
			)
			(1
				(gEgo view: 2760 cel: 0 loop: 1 setCycle: CT 4 1 self)
			)
			(2
				(sound1 number: 372 loop: 0 play:)
				(forcefield view: 272 cel: 0 loop: 1 setCycle: End)
				(gEgo view: 2760 cel: 4 loop: 1 setCycle: End self)
			)
			(3
				(forcefield dispose:)
				(fForcefield dispose:)
				(ffGenerator dispose:)
				(gEgo normalize: 1)
				(gGame handsOn:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sEgoGetBelt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 313 127 self)
			)
			(1
				(gEgo setHeading: 330)
				(= cycles 1)
			)
			(2
				(gEgo
					get: 8 ; Belt_Da_Pga
					view: 2720
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(3
				(gGame points: 3 441)
				(belt dispose:)
				(gEgo get: 8 cel: 4 setCycle: End self) ; Belt_Da_Pga
			)
			(4
				(gEgo normalize: 7 setMotion: MoveTo 300 123 self)
			)
			(5
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nigel of Actor
	(properties
		noun 21
		sightAngle 315
		approachX 300
		approachY 130
		x 273
		y 125
		z 11
		view 271
	)

	(method (init)
		(self setPri: 91 signal: (| (nigel signal:) $5000))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; Churlish_Moddie_1
				(self setScript: sNigelPoundsRoger)
			)
			(77 ; Burlesque_Moddie_4
				(self setScript: sNigelStriptease)
			)
			(2 ; Talk
				(gMessager say: 21 2 6 0) ; "Go away."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance forcefield of Prop
	(properties
		noun 10
		sightAngle 270
		approachX 165
		approachY 105
		x 144
		y 99
		view 272
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0 setPri: 91)
	)
)

(instance santiago of Actor
	(properties
		x 96
		y 107
		view 278
	)
)

(instance ffGenerator of Prop
	(properties
		noun 10
		x 146
		y 98
		view 270
	)

	(method (init)
		(self setPri: 92)
		(super init: &rest)
	)
)

(instance radar of Prop
	(properties
		x 233
		y 76
		view 270
		loop 1
	)
)

(instance discharge of Prop
	(properties
		noun 12
		x 308
		y 34
		view 270
		loop 2
	)
)

(instance panel of Prop
	(properties
		x 283
		y 73
		view 270
		loop 3
	)
)

(instance game of Prop
	(properties
		x 305
		y 74
		view 270
		loop 4
	)
)

(instance offWorld of Actor
	(properties
		x 136
		y 54
		view 2700
		cycleSpeed 100
		xStep 1
		moveSpeed 4
	)
)

(instance hotel of Prop
	(properties
		x 40
		y 38
		view 2702
		cel 5
	)
)

(instance arrow of Prop
	(properties
		x 61
		y 40
		view 2702
		loop 1
	)
)

(instance rescueShip of Actor
	(properties
		y 41
		view 277
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 signal: (| (rescueShip signal:) $6000))
	)
)

(instance dust of Prop
	(properties
		y 140
		view 277
		loop 1
	)
)

(instance chair of View
	(properties
		x 277
		y 115
		view 2701
	)

	(method (init)
		(super init: &rest)
		(self setPri: 95)
	)
)

(instance belt of View
	(properties
		noun 14
		approachX 313
		approachY 127
		x 297
		y 125
		view 2701
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sEgoGetBelt)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fForcefield of Feature
	(properties
		noun 23
		sightAngle 270
		approachX 165
		approachY 105
		x 157
		y 101
		z 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 37 152 103 159 126 162 84 159 37
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(forcefield setScript: sRogerThrownBack)
			)
			(4 ; Do
				(if (IsFlag 80)
					(gMessager say: 10 4 4) ; "With the Damping Field deactivated, these lights are warm but otherwise create no strange tingly feelings of sudden death."
				else
					(forcefield setScript: sRogerThrownBack)
				)
			)
			(93 ; Actuator
				(if (not (IsFlag 80))
					(= local0 0)
					(gEgo setScript: sForceFieldDeactvtd)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlBox of Feature
	(properties
		noun 9
		sightAngle 40
		x 122
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 124 75 136 77 136 63 133 61 135 57 129 57 126 60 126 64 124 66
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 80)
					(gMessager say: 9 4 4) ; "Thank goodness. Now that you've got that damping field shut off, you can check out that Damping Field Controller Unit, so that maybe you can shut off that ... that ..."
				else
					(gMessager say: 9 4 3) ; "Yeah, you reach through that damping field and you'll draw back a dripping wad of demolecularized flesh. It does look pretty cool though. Maybe when we have more time we can come back and try it."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance city of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 56
		approachY 106
		x 56
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 0 105 50 99 102 96 111 18 114 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fDischarge of Feature
	(properties
		noun 15
		sightAngle 40
		x 308
		y 44
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 62 301 47 305 40 307 40 301 34 300 30 307 26 315 30 317 35 311 39 315 48 315 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lamp of Feature
	(properties
		noun 17
		sightAngle 40
		x 289
		y 54
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 281 54 290 48 297 54 292 59 297 61 283 61 286 58
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poster1 of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 242
		approachY 111
		x 242
		y 60
		z 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 29 235 34 249 28 241 14 231 16
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poster2 of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 242
		approachY 111
		x 242
		y 60
		z 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 37 247 37 250 71 230 78
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance RollerMachine of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 242
		approachY 111
		x 242
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 68 243 68 248 86 248 98 248 105 245 105 245 99 238 99 238 103 236 103 236 99 230 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance box1 of Feature
	(properties
		noun 6
		sightAngle 247
		approachX 248
		approachY 115
		x 241
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 114 236 113 249 116 249 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance box2 of Feature
	(properties
		noun 7
		sightAngle 180
		approachX 286
		approachY 123
		x 286
		y 124
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 268 121 280 117 294 121 294 124 280 123
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance box3 of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 310
		approachY 120
		x 296
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 288 102 289 106 289 110 295 114 304 112 304 104 298 102 297 100
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sRogerGetsChurlish)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLights of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 141
		approachY 106
		x 141
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 103 151 103 156 38 144 38
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 80)
					(gMessager say: 1 4 4) ; "The room is no longer giving off that low-level hum."
				else
					(gMessager say: 10 1) ; "The archway glows with the energy of a damping field."
				)
			)
			(4 ; Do
				(if (IsFlag 80)
					(gMessager say: 10 4 4) ; "With the Damping Field deactivated, these lights are warm but otherwise create no strange tingly feelings of sudden death."
				else
					(gMessager say: 10 4 3) ; "Yeah, you reach through that damping field and you'll draw back a dripping wad of demolecularized flesh. It does look pretty cool though. Maybe when we have more time we can come back and try it."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 275
		approachY 116
		x 278
		y 87
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 254 94 238 101 238 85 258 83 252 62 279 62 319 65 319 80 319 109 319 112 307 112 307 103 297 97 286 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wallUnit of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 275
		approachY 116
		x 275
		y 50
		z 64
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 31 266 38 268 38 268 62 290 63 290 30 286 30 286 28 269 28 269 31
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pipe of Feature
	(properties
		noun 13
		sightAngle 40
		approachX 275
		approachY 116
		x 275
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 258 39 258 43 264 43 264 61 268 61 268 39
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance terrace of Feature
	(properties
		noun 1
		sightAngle 40
		x 159
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 104 8 104 104 96 113 0 319 0 319 5 292 5 241 13 230 16 230 115 272 122 315 125 319 125 319 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 9) ; "Boy, this terrace is a nice change from the stink-laden confines of that apartment."
			)
			(4 ; Do
				(if (IsFlag 80)
					(gMessager say: 1 4 4) ; "The room is no longer giving off that low-level hum."
				else
					(gMessager say: 1 4 3) ; "The room seems to be vibrating ever so slightly, the telltale residue of a local damping field."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit260 of ExitFeature
	(properties
		sightAngle 180
		approachX 312
		approachY 122
		x 316
		y 100
		nextRoom 260
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 312 60 312 121 320 121 320 60
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; ExitRight
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 124 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super doVerb: 7)
	)
)

(instance Nigel of SmallTalker
	(properties)

	(method (init)
		(= client nigel)
		(if (IsFlag 159)
			(= talkView 276)
			(= showTalk (= prepMove (= talkLoop 0)))
			(super init:)
		else
			(= bodyView 271)
			(= bodyLoop 1)
			(= talkView 271)
			(= talkLoop 2)
			(= prepMove 1)
			(super init:)
		)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

(instance sound2 of Sound
	(properties
		flags 1
	)
)

