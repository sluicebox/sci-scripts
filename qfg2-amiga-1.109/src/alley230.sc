;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 733)
(include sci.sh)
(use Alley)

(public
	alley230 0
	alley231 1
	alley232 2
	alley233 3
	alley234 4
	alley235 5
	alley236 6
	alley237 7
	alley238 8
	alley239 9
)

(instance alley230 of Alley
	(properties
		streetIndex 40
		topX 30
		botX 30
		topY 104
		botY 102
		topType 770
		botType 769
		topLoc 229
		botLoc 231
	)
)

(instance alley231 of Alley
	(properties
		streetIndex 40
		topX 30
		botX 28
		topY 102
		botY 102
		topType 769
		botType 771
		topLoc 230
		botLoc 232
	)
)

(instance alley232 of Alley
	(properties
		topX 28
		botX 28
		topY 106
		botY 100
		topType 769
		botType 769
		topLoc 228
		botLoc 233
	)

	(method (at x y)
		(if (== y 102)
			(= atLoc 231)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (> y 102)
			(FindStreetName 41)
			(return)
		else
			(FindStreetName 40)
			(return)
		)
	)
)

(instance alley233 of Alley
	(properties
		streetIndex 40
		topX 28
		botX 22
		topY 100
		botY 100
		topType 769
		botType 769
		topLoc 232
		botLoc 234
	)
)

(instance alley234 of Alley
	(properties
		streetIndex 40
		topX 22
		botX 22
		topY 104
		botY 100
		topType 769
		botType 770
		topLoc 235
		botLoc 233
	)
)

(instance alley235 of Alley
	(properties
		streetIndex 40
		topX 22
		botX 20
		topY 104
		botY 104
		topType 770
		botType 769
		topLoc 234
		botLoc 236
	)
)

(instance alley236 of Alley
	(properties
		streetIndex 40
		topX 20
		botX 20
		topY 106
		botY 104
		topType 769
		botType 770
		topLoc 237
		botLoc 235
	)
)

(instance alley237 of Alley
	(properties
		streetIndex 40
		topX 20
		botX 16
		topY 106
		botY 106
		topType 770
		botType 770
		topLoc 236
		botLoc 238
	)
)

(instance alley238 of Alley
	(properties
		streetIndex 40
		topX 16
		botX 16
		topY 106
		botY 104
		topType 770
		botType 769
		topLoc 237
		botLoc 239
	)
)

(instance alley239 of Alley
	(properties
		streetIndex 40
		topX 16
		botX 12
		topY 104
		botY 104
		topType 769
		botType 769
		topLoc 238
		botLoc 240
	)
)

