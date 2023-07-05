;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 734)
(include sci.sh)
(use Alley)

(public
	alley240 0
	alley241 1
	alley242 2
	alley243 3
	alley244 4
	alley245 5
	alley246 6
	alley247 7
	alley248 8
	alley249 9
)

(instance alley240 of Alley
	(properties
		streetIndex 40
		topX 12
		botX 12
		topY 108
		botY 104
		topType 769
		botType 770
		topLoc 241
		botLoc 239
	)
)

(instance alley241 of Alley
	(properties
		streetIndex 40
		topX 12
		botX 10
		topY 108
		botY 108
		topType 770
		botType 576
		topLoc 240
		botLoc -460
	)
)

(instance alley242 of Alley
	(properties
		streetIndex 35
		topX 6
		botX 6
		topY 114
		botY 112
		topType 769
		botType 576
		topLoc 243
		botLoc -460
	)
)

(instance alley243 of Alley
	(properties
		streetIndex 35
		topX 6
		botX 2
		topY 114
		botY 114
		topType 770
		botType 769
		topLoc 242
		botLoc 244
	)
)

(instance alley244 of Alley
	(properties
		streetIndex 35
		topX 2
		botX 2
		topY 116
		botY 114
		topType 769
		botType 770
		topLoc 245
		botLoc 243
	)
)

(instance alley245 of Alley
	(properties
		streetIndex 35
		topX 2
		topY 116
		botY 116
		topType 770
		botType 769
		topLoc 244
		botLoc 246
	)
)

(instance alley246 of Alley
	(properties
		streetIndex 35
		topY 120
		botY 116
		topType 128
		botType 770
		botLoc 245
	)

	(method (at x y)
		(if (== y 118)
			(= atLoc 247)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley247 of Alley
	(properties
		streetIndex 34
		topX 4
		topY 118
		botY 118
		topType 769
		botType 771
		topLoc 248
		botLoc 246
	)
)

(instance alley248 of Alley
	(properties
		streetIndex 34
		topX 4
		botX 4
		topY 120
		botY 118
		topType 770
		botType 769
		topLoc 249
		botLoc 247
	)
)

(instance alley249 of Alley
	(properties
		streetIndex 34
		topX 6
		botX 4
		topY 120
		botY 120
		topType 769
		botType 770
		topLoc 258
		botLoc 248
	)
)

