;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 325)
(include sci.sh)
(use Main)
(use Feature)
(use System)

(public
	barrel 0
	stool 1
	chair1 2
	chair2 3
	chair3 4
	leftTable 5
	rightTable 6
	firePlace 7
	chandelier1 8
	chandelier2 9
	boarHead 10
	plates 11
	garlic1 12
	ashPot 13
	door2 14
	pillar1 15
	pillar2 16
	garlic2 17
	garlic3 18
	garlic4 19
)

(instance barrel of Feature
	(properties
		noun 2
		nsLeft 126
		nsTop 153
		nsRight 151
		nsBottom 178
		sightAngle 180
		x 138
		y 177
		z 12
	)
)

(instance stool of Feature
	(properties
		noun 19
		nsLeft 157
		nsTop 162
		nsRight 180
		nsBottom 176
		sightAngle 180
		x 168
		y 169
	)
)

(instance chair1 of Feature
	(properties
		noun 6
		nsLeft 62
		nsTop 126
		nsRight 76
		nsBottom 146
		sightAngle 180
		x 69
		y 136
	)
)

(instance chair2 of Feature
	(properties
		noun 6
		nsLeft 79
		nsTop 125
		nsRight 99
		nsBottom 169
		sightAngle 180
		x 89
		y 147
	)
)

(instance chair3 of Feature
	(properties
		noun 6
		nsLeft 121
		nsTop 125
		nsRight 137
		nsBottom 154
		sightAngle 180
		x 129
		y 139
	)
)

(instance leftTable of Feature
	(properties
		noun 14
		nsLeft 60
		nsTop 145
		nsRight 125
		nsBottom 163
		sightAngle 180
		x 92
		y 154
	)
)

(instance rightTable of Feature
	(properties
		noun 18
		nsLeft 142
		nsTop 147
		nsRight 220
		nsBottom 170
		sightAngle 180
		x 181
		y 158
	)
)

(instance firePlace of Feature
	(properties
		noun 10
		nsTop 114
		nsRight 26
		nsBottom 166
		sightAngle 180
		x 13
		y 140
	)
)

(instance chandelier1 of Feature
	(properties
		noun 7
		nsLeft 79
		nsTop 73
		nsRight 128
		nsBottom 92
		sightAngle 180
		x 103
		y 82
	)
)

(instance chandelier2 of Feature
	(properties
		noun 7
		nsLeft 91
		nsRight 188
		nsBottom 39
		sightAngle 180
		x 139
		y 19
	)
)

(instance boarHead of Feature
	(properties
		noun 4
		nsLeft 74
		nsTop 45
		nsRight 108
		nsBottom 74
		sightAngle 180
		x 91
		y 59
	)
)

(instance plates of Feature
	(properties
		noun 16
		nsTop 64
		nsRight 30
		nsBottom 94
		sightAngle 180
		x 15
		y 79
	)
)

(instance garlic1 of Feature
	(properties
		noun 11
		nsLeft 29
		nsTop 97
		nsRight 138
		nsBottom 111
		sightAngle 180
		x 83
		y 104
	)
)

(instance ashPot of Feature
	(properties
		noun 1
		nsLeft 24
		nsTop 143
		nsRight 44
		nsBottom 162
		sightAngle 180
		x 34
		y 152
	)
)

(instance door2 of Feature
	(properties
		noun 8
		nsLeft 211
		nsTop 24
		nsRight 231
		nsBottom 57
		sightAngle 180
		x 221
		y 40
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 42 28 4) ; theToolkit, theLockpick, Do
			(gMessager say: 22 6 22) ; "The room is totally empty."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pillar1 of Feature
	(properties
		noun 15
		nsLeft 138
		nsTop 93
		nsRight 161
		nsBottom 148
		sightAngle 180
		x 149
		y 120
	)
)

(instance pillar2 of Feature
	(properties
		noun 15
		nsLeft 225
		nsTop 61
		nsRight 261
		nsBottom 174
		sightAngle 180
		x 243
		y 160
		z 43
	)
)

(instance garlic2 of Feature
	(properties
		noun 11
		nsLeft 162
		nsTop 93
		nsRight 196
		nsBottom 112
		sightAngle 180
		approachX 183
		approachY 177
		x 179
		y 102
	)
)

(instance garlic3 of Feature
	(properties
		noun 11
		nsLeft 189
		nsTop 78
		nsRight 229
		nsBottom 96
		sightAngle 180
		approachX 216
		approachY 175
		x 209
		y 87
	)
)

(instance garlic4 of Feature
	(properties
		noun 11
		nsLeft 250
		nsTop 71
		nsRight 280
		nsBottom 103
		approachX 257
		approachY 175
		x 265
		y 287
		z 200
	)
)

