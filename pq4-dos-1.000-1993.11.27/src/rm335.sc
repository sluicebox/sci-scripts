;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Game)
(use System)

(public
	rm335 0
)

(instance rm335 of Room
	(properties
		noun 3
		picture 335
	)

	(method (init)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 189 158 259 176 306 172 293 168 218 158
					yourself:
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(340
				(gEgo posn: 209 160 setHeading: 315)
			)
			(else
				(gEgo posn: 264 166 setHeading: 270)
			)
		)
		(gEgo normalize: 9120 init:)
		(man init: approachVerbs: 4 2) ; Do, Talk
		(door init: approachVerbs: 4) ; Do
		(records init:)
		(rightCounter init:)
		(leftCounter init:)
		(rightRegister init:)
		(leftRegister init:)
		(leftPic init:)
		(middlePic init:)
		(rightPic init:)
		(theWindow init:)
		(raginLogo init:)
		(gGame handsOn:)
		(if (!= gPrevRoomNum 340)
			((ScriptID 40 0) doit:) ; sndCode
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 340)
			((ScriptID 40 0) dispose:) ; sndCode
		)
		(super newRoom: newRoomNumber)
	)
)

(instance records of Feature
	(properties
		noun 4
		sightAngle 40
		x 111
		y 150
	)

	(method (init)
		(self
			createPoly:
				0
				153
				0
				113
				40
				110
				41
				101
				79
				100
				115
				106
				115
				100
				142
				100
				166
				102
				167
				109
				206
				120
				208
				135
				228
				143
				229
				153
		)
		(super init: &rest)
	)
)

(instance rightCounter of Feature
	(properties
		noun 5
		sightAngle 40
		x 196
		y 110
	)

	(method (init)
		(self
			createPoly:
				230
				96
				229
				144
				209
				135
				207
				119
				168
				109
				167
				101
				141
				100
				206
				93
		)
		(super init: &rest)
	)
)

(instance leftCounter of Feature
	(properties
		noun 5
		sightAngle 40
		x 28
		y 106
	)

	(method (init)
		(self
			createPoly: 42 100 40 110 14 110 14 87 23 87 22 93 29 97 57 97 68 99
		)
		(super init: &rest)
	)
)

(instance rightRegister of Feature
	(properties
		noun 6
		sightAngle 40
		x 144
		y 96
	)

	(method (init)
		(self
			createPoly: 151 99 121 99 122 93 126 88 134 87 139 82 160 81 163 97
		)
		(super init: &rest)
	)
)

(instance leftRegister of Feature
	(properties
		noun 6
		sightAngle 40
		x 39
		y 91
	)

	(method (init)
		(self createPoly: 22 93 22 72 32 71 38 76 57 87 56 95)
		(super init: &rest)
	)
)

(instance leftPic of Feature
	(properties
		noun 7
		sightAngle 40
		x 27
		y 69
	)

	(method (init)
		(self createPoly: 42 37 43 72 12 71 12 37)
		(super init: &rest)
	)
)

(instance middlePic of Feature
	(properties
		noun 7
		sightAngle 40
		x 64
		y 73
	)

	(method (init)
		(self createPoly: 82 44 82 75 48 75 48 42)
		(super init: &rest)
	)
)

(instance rightPic of Feature
	(properties
		noun 7
		sightAngle 40
		x 132
		y 58
	)

	(method (init)
		(self createPoly: 143 28 142 60 122 60 123 27)
		(super init: &rest)
	)
)

(instance theWindow of Feature
	(properties
		noun 8
		sightAngle 40
		x 200
		y 73
	)

	(method (init)
		(self
			createPoly:
				158
				10
				255
				10
				252
				152
				229
				146
				231
				96
				148
				99
				147
				24
				159
				23
		)
		(super init: &rest)
	)
)

(instance man of Feature
	(properties
		noun 1
		sightAngle 40
		approachX 225
		approachY 152
		approachDist 84
		x 168
		y 93
	)

	(method (init)
		(self
			createPoly:
				144
				81
				145
				72
				157
				64
				161
				53
				165
				53
				172
				59
				168
				70
				180
				85
				203
				94
				202
				97
				164
				97
				162
				80
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 2 4 27) ; Talk, Do, badge
			(if (== theVerb 27) ; badge
				(gPqFlags set: 122)
			)
			(gCurRoom newRoom: 340)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance raginLogo of Feature
	(properties
		noun 9
		sightAngle 40
		x 89
		y 35
	)

	(method (init)
		(self
			createPoly:
				98
				16
				106
				19
				112
				19
				112
				30
				106
				30
				94
				37
				81
				38
				75
				33
				67
				34
				68
				23
				75
				23
				86
				16
				93
				16
		)
		(super init: &rest)
	)
)

(instance door of Feature
	(properties
		heading 190
		noun 2
		nsLeft 256
		nsTop 18
		nsRight 307
		nsBottom 152
		sightAngle 40
		approachX 280
		approachY 166
		approachDist 75
		x 281
		y 85
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 310)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

