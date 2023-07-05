;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 732)
(include sci.sh)
(use Alley)

(public
	alley220 0
	alley221 1
	alley222 2
	alley223 3
	alley224 4
	alley225 5
	alley226 6
	alley227 7
	alley228 8
	alley229 9
)

(instance alley220 of Alley
	(properties
		streetIndex 39
		topX 34
		botX 26
		topY 110
		botY 110
		topType 770
		botType 769
		topLoc 219
		botLoc 221
	)
)

(instance alley221 of Alley
	(properties
		streetIndex 39
		topX 26
		botX 26
		topY 112
		botY 110
		topType 769
		botType 770
		topLoc 222
		botLoc 220
	)
)

(instance alley222 of Alley
	(properties
		streetIndex 39
		topX 26
		botX 22
		topY 112
		botY 112
		topType 770
		botType 771
		topLoc 221
		botLoc 223
	)
)

(instance alley223 of Alley
	(properties
		topX 22
		botX 22
		topY 114
		botY 108
		topType 769
		botType 770
		topLoc 224
		botLoc 226
	)

	(method (at x y)
		(if (== y 112)
			(= atLoc 222)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (>= y 112)
			(FindStreetName 39)
			(return)
		else
			(FindStreetName 41)
			(return)
		)
	)
)

(instance alley224 of Alley
	(properties
		streetIndex 39
		topX 22
		botX 12
		topY 114
		botY 114
		topType 770
		botType 128
		topLoc 223
	)

	(method (at x y)
		(if (== x 18)
			(= atLoc 225)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley225 of Alley
	(properties
		streetIndex 38
		topX 18
		botX 18
		topY 114
		botY 110
		topType 771
		botType 128
		topLoc 224
	)
)

(instance alley226 of Alley
	(properties
		streetIndex 41
		topX 24
		botX 22
		topY 108
		botY 108
		topType 770
		botType 769
		topLoc 227
		botLoc 223
	)
)

(instance alley227 of Alley
	(properties
		streetIndex 41
		topX 24
		botX 24
		topY 108
		botY 106
		topType 769
		botType 770
		topLoc 226
		botLoc 228
	)
)

(instance alley228 of Alley
	(properties
		streetIndex 41
		topX 28
		botX 24
		topY 106
		botY 106
		topType 770
		botType 769
		topLoc 232
		botLoc 227
	)
)

(instance alley229 of Alley
	(properties
		streetIndex 40
		topX 34
		botX 30
		topY 104
		botY 104
		topType 769
		botType 770
		topLoc 219
		botLoc 230
	)
)

