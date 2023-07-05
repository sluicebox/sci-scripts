;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 731)
(include sci.sh)
(use Alley)

(public
	alley210 0
	alley211 1
	alley212 2
	alley213 3
	alley214 4
	alley215 5
	alley216 6
	alley217 7
	alley218 8
	alley219 9
)

(instance alley210 of Alley
	(properties
		streetIndex 43
		topX 42
		botX 38
		topY 116
		botY 116
		topType 771
		botType 769
		topLoc 200
		botLoc 211
	)
)

(instance alley211 of Alley
	(properties
		streetIndex 43
		topX 38
		botX 38
		topY 118
		botY 116
		topType 769
		botType 770
		topLoc 212
		botLoc 210
	)
)

(instance alley212 of Alley
	(properties
		streetIndex 43
		topX 38
		botX 30
		topY 118
		botY 118
		topType 770
		botType 128
		topLoc 211
	)

	(method (at x y)
		(if (== x 34)
			(= atLoc 213)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley213 of Alley
	(properties
		streetIndex 42
		topX 34
		botX 34
		topY 118
		botY 114
		topType 771
		botType 769
		topLoc 212
		botLoc 214
	)
)

(instance alley214 of Alley
	(properties
		streetIndex 42
		topX 34
		botX 28
		topY 114
		botY 114
		topType 769
		botType 769
		topLoc 213
		botLoc 215
	)
)

(instance alley215 of Alley
	(properties
		streetIndex 42
		topX 28
		botX 28
		topY 116
		botY 114
		topType 769
		botType 770
		topLoc 216
		botLoc 214
	)
)

(instance alley216 of Alley
	(properties
		streetIndex 42
		topX 28
		botX 26
		topY 116
		botY 116
		topType 770
		botType 769
		topLoc 215
		botLoc 217
	)
)

(instance alley217 of Alley
	(properties
		streetIndex 42
		topX 26
		botX 26
		topY 119
		botY 116
		topType 128
		botType 770
		botLoc 216
	)
)

(instance alley218 of Alley
	(properties
		streetIndex 40
		topX 38
		botX 34
		topY 108
		botY 108
		topType 576
		botType 771
		topLoc -390
		botLoc 219
	)
)

(instance alley219 of Alley
	(properties
		topX 34
		botX 34
		topY 110
		botY 104
		topType 769
		botType 769
		topLoc 220
		botLoc 229
	)

	(method (at x y)
		(if (== y 108)
			(= atLoc 218)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (> y 108)
			(FindStreetName 39)
			(return)
		else
			(FindStreetName 40)
			(return)
		)
	)
)

