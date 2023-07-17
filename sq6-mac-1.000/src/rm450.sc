;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use SQRoom)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm450 0
)

(local
	local0 = 9
)

(instance rm450 of SQRoom
	(properties
		noun 2
		picture 450
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 42 116 73 133 163 133 163 138 203 138 203 130 318 130 318 102 202 103 186 95 184 85 274 85 282 80 318 80 318 52 233 52 222 49 146 49 134 53 14 53 21 75 27 75 27 81 3 98 3 116
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 76 65 175 65 175 74 125 82 70 82
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 172 94 124 103 69 103 63 97 25 97 21 90 36 78 63 78 63 85 172 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 160 107 160 118 160 128 73 128 54 118 54 107
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 272 82 237 82 223 82 197 78 184 72 184 65 291 65 291 70
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 316 107 316 115 283 123 205 123 187 115 187 107
					yourself:
				)
		)
		(gEgo
			normalize:
			setScaler: Scaler 31 28 140 45
			posn: 184 51
			setHeading: 180
			init:
		)
		(if (!= gPrevRoomNum 440)
			(gGSound1 number: 123 flags: 1 loop: 1 play:)
		)
		(super init:)
		(gGame handsOff:)
		(Load rsVIEW 4501 953)
		(Load 140 452 453 44001) ; WAVE
		(workStation init:)
		(ship1 init: approachVerbs: 4) ; Do
		(ship2 init: approachVerbs: 4) ; Do
		(ship3 init: approachVerbs: 4) ; Do
		(ship4 init: approachVerbs: 4) ; Do
		(ship5 init: approachVerbs: 4) ; Do
		(ship6 init: approachVerbs: 4) ; Do
		(ship7 init: approachVerbs: 4) ; Do
		(ship8 init: approachVerbs: 4) ; Do
		(ship9 init: approachVerbs: 4) ; Do
		(towerSupports init: approachVerbs: 4) ; Do
		(leftTower init: approachVerbs: 4) ; Do
		(rightTower init: approachVerbs: 4) ; Do
		(walkway init: approachVerbs: 4) ; Do
		(if (== gPrevRoomNum 480)
			(shuttleDoor loop: 1 cel: 8 approachVerbs: 4 init:) ; Do
		else
			(shuttleDoor loop: 0 cel: 0 approachVerbs: 4 init:) ; Do
		)
		(comet init: hide: setScript: sRandomScript)
		(waxingGuy init: cycleSpeed: 10 setCycle: RandCycle)
		(workingGuy init: cycleSpeed: 10 setCycle: RandCycle)
		(if (== gPrevRoomNum 480)
			(gEgo posn: 238 103)
			(exitDoor init: approachVerbs: 4) ; Do
			(gCurRoom setScript: sEnterFromShuttle)
		else
			(gCurRoom setScript: sEnterFrom440)
		)
		(PalCycle 0 210 220 -1 5) ; Start
	)

	(method (dispose)
		(gEgo setScale: 0 normalize:)
		(if (!= gNewRoomNum 440)
			(gGSound1 fade:)
		)
		(super dispose:)
	)

	(method (notify)
		(gCurRoom setScript: sHandleAlarm)
	)
)

(instance sEnterFrom440 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(localSound number: 44001 play:)
				(exitDoor
					cel: (exitDoor lastCel:)
					init:
					approachVerbs: 4 ; Do
					setCycle: Beg self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHandleAlarm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(= cycles 1)
			)
			(2
				(localSound number: 452 play: self)
				(shuttleLights
					cel: 0
					cycleSpeed: 4
					init:
					setCycle: ForwardCounter 2 self
				)
			)
			(3)
			(4
				(shuttleLights dispose:)
				(if (IsFlag 49)
					(ClearFlag 49)
					(gMessager say: 0 0 1 0 self) ; "The shuttle's alarm is now activated."
				else
					(SetFlag 49)
					(gMessager say: 0 0 2 0 self) ; "The shuttle's alarm is now deactivated."
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRandomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 15 30))
			)
			(1
				(client show: cel: 0 setCycle: End self)
			)
			(2
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance sEnterFromShuttle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(localSound number: 454 play:)
				(shuttleDoor loop: 1 cel: 8 setCycle: Beg self)
			)
			(2
				(localSound number: 451 play:)
				(shuttleDoor loop: 0 cel: 9 setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToShuttle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 451) ; WAVE
				(gEgo setHeading: 0 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(localSound number: 451 play:)
				(shuttleDoor setCycle: End self)
			)
			(3
				(localSound number: 454 play:)
				(shuttleDoor loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance exitDoor of Prop
	(properties
		noun 19
		sightAngle 40
		approachX 184
		approachY 51
		x 179
		y 31
		view 4501
		signal 20513
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(localSound number: 44001 play:)
				(self setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 440)
	)
)

(instance shuttleDoor of Prop
	(properties
		noun 13
		approachX 238
		approachY 103
		x 239
		y 101
		view 450
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 49)
					(gGame handsOff:)
					(= gShuttleRoomNum 450)
					(self setScript: sExitToShuttle)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(ship7 doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance comet of Prop
	(properties
		y 13
		view 458
		signal 20513
	)
)

(instance waxingGuy of Prop
	(properties
		noun 21
		x 131
		y 124
		view 458
		loop 1
		signal 20513
	)
)

(instance workingGuy of Prop
	(properties
		noun 22
		x 125
		y 79
		view 458
		loop 2
		signal 20513
	)
)

(instance shuttleLights of Prop
	(properties
		x 207
		y 94
		view 452
	)
)

(instance ship1 of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 13
		approachY 96
		x 12
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 32 7 31 8 38 12 38 21 68 20 75 23 77 23 81 5 93 0 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship2 of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 140
		approachY 82
		x 140
		y 81
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 84 73 141 75 153 75 153 72 168 70 170 68 157 61 152 57 147 55 138 55 120 52 89 49 77 50 77 52 87 53 87 56 80 57 78 59 79 60 87 61 89 68
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship3 of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 140
		approachY 103
		x 140
		y 102
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 73 113 73 140 77 154 83 161 85 165 88 161 90 143 96 72 96 67 91 68 88 60 83 65 79 73 77 76 76 75 74
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship4 of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 135
		approachY 128
		x 135
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 72 93 77 89 108 89 130 96 156 109 151 114 138 120 129 120 130 125 110 123 79 123 72 119 60 103 68 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship5 of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 132
		approachY 133
		x 132
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 138 156 138 158 135 150 131 129 125 109 124 79 124 54 108 40 107
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship6 of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 203
		approachY 83
		x 203
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 67 190 63 197 56 204 56 208 58 213 58 219 54 225 53 236 53 242 53 244 48 247 54 263 54 270 51 286 57 279 63 269 59 270 63 270 73 223 72 212 68 207 75 202 75 195 72 191 70
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship7 of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 217
		approachY 103
		x 217
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 281 64 267 64 259 68 249 68 236 69 231 73 222 74 207 79 199 82 194 84 194 85 186 87 197 88 202 92 214 94 245 94 274 94 273 83 279 83 283 79 281 74 275 73
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship8 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 256
		approachY 128
		x 256
		y 127
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 313 110 302 111 292 117 226 117 203 115 192 107 205 101 220 97 249 96 275 93 290 95 295 96 297 102 310 102 315 105
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ship9 of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 223
		approachY 131
		x 223
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 117 300 117 293 115 274 115 274 119 254 119 242 114 232 114 232 120 224 121 217 124 208 132 217 138 292 138 306 130 319 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance workStation of Feature
	(properties
		noun 12
		sightAngle 40
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 111 50 111 47 107 47 100 57 100 64 105 76 112 74 117 71 120 67 122 53 114 61 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance towerSupports of Feature
	(properties
		noun 14
		sightAngle 40
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 295 95 294 95 294 38 285 36 285 85 284 85 284 36 283 36 288 27 293 27 295 28 313 28 317 37 316 38 315 94 314 94 314 36 295 36
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 28 94 28 8 31 0 58 0 59 3 59 85 58 85 58 6 51 12 51 95 50 95 50 12 35 12 29 6 29 94
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftTower of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 39
		approachY 96
		x 39
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 13 37 45 35 45 34 85 25 91 34 91 34 94 45 94 49 91 57 91 61 87 55 85 55 45 49 45 49 13
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightTower of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 306
		approachY 98
		x 306
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 0 293 29 289 38 289 85 283 87 287 91 295 91 300 95 311 95 311 92 318 91 309 84 309 43 307 27 307 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeTop of Feature ; UNUSED
	(properties
		noun 17
		sightAngle 40
		approachX 184
		approachY 48
		x 184
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 25 188 25 188 18 186 15 182 15 180 18
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeBottom of Feature ; UNUSED
	(properties
		noun 18
		sightAngle 40
		approachX 184
		approachY 48
		x 184
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 179 49 180 50 187 50 191 49 189 47 180 47
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance walkway of Feature
	(properties
		noun 20
		sightAngle 40
		approachX 184
		approachY 47
		x 184
		y 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 131 13 239 13 243 0 128 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance localSound of Sound
	(properties)
)

