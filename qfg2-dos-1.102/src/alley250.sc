;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 735)
(include sci.sh)
(use Alley)

(public
	alley250 0
	alley251 1
	alley252 2
	alley253 3
	alley254 4
	alley255 5
	alley256 6
	alley257 7
	alley258 8
)

(instance alley250 of Alley
	(properties
		streetIndex 36
		topX 18
		botX 18
		topY 128
		botY 124
		topType 771
		botType 769
		topLoc 207
		botLoc 251
	)
)

(instance alley251 of Alley
	(properties
		streetIndex 36
		topX 18
		botX 16
		topY 124
		botY 124
		topType 769
		botType 770
		topLoc 250
		botLoc 252
	)
)

(instance alley252 of Alley
	(properties
		streetIndex 36
		topX 16
		botX 16
		topY 124
		botY 118
		topType 770
		botType 770
		topLoc 251
		botLoc 254
	)

	(method (at x y)
		(if (== y 120)
			(= atLoc 253)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley253 of Alley
	(properties
		streetIndex 37
		topX 16
		botX 14
		topY 120
		botY 120
		topType 771
		botType 128
		topLoc 252
	)
)

(instance alley254 of Alley
	(properties
		streetIndex 36
		topX 20
		botX 16
		topY 118
		botY 118
		topType 769
		botType 769
		topLoc 255
		botLoc 252
	)
)

(instance alley255 of Alley
	(properties
		streetIndex 36
		topX 20
		botX 20
		topY 120
		botY 118
		topType 770
		botType 769
		topLoc 256
		botLoc 254
	)
)

(instance alley256 of Alley
	(properties
		streetIndex 36
		topX 22
		botX 20
		topY 120
		botY 120
		topType 769
		botType 770
		topLoc 257
		botLoc 255
	)
)

(instance alley257 of Alley
	(properties
		streetIndex 36
		topX 22
		botX 22
		topY 122
		botY 120
		topType 128
		botType 769
		botLoc 256
	)
)

(instance alley258 of Alley
	(properties
		streetIndex 34
		topX 6
		botX 6
		topY 124
		botY 120
		topType 770
		botType 769
		topLoc 209
		botLoc 249
	)
)

