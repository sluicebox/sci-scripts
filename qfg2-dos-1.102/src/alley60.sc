;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 716)
(include sci.sh)
(use Alley)

(public
	alley60 0
	alley61 1
	alley62 2
	alley63 3
	alley64 4
	alley65 5
	alley66 6
	alley67 7
	alley68 8
)

(instance alley60 of Alley
	(properties
		streetIndex 2
		topX 16
		botX 16
		topY 4
		topType 770
		botType 770
		topLoc 61
		botLoc 29
	)
)

(instance alley61 of Alley
	(properties
		streetIndex 2
		topX 18
		botX 16
		topY 4
		botY 4
		topType 769
		botType 770
		topLoc 62
		botLoc 60
	)
)

(instance alley62 of Alley
	(properties
		streetIndex 2
		topX 18
		botX 18
		topY 8
		botY 4
		topType 769
		botType 769
		topLoc 63
		botLoc 61
	)
)

(instance alley63 of Alley
	(properties
		streetIndex 2
		topX 18
		botX 14
		topY 8
		botY 8
		topType 770
		botType 770
		topLoc 62
		botLoc 64
	)

	(method (at x y)
		(if (== x 16)
			(= atLoc 106)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley64 of Alley
	(properties
		streetIndex 2
		topX 14
		botX 14
		topY 8
		botY 6
		topType 770
		botType 769
		topLoc 63
		botLoc 65
	)
)

(instance alley65 of Alley
	(properties
		streetIndex 2
		topX 14
		botX 10
		topY 6
		botY 6
		topType 769
		botType 769
		topLoc 64
		botLoc 66
	)
)

(instance alley66 of Alley
	(properties
		streetIndex 2
		topX 10
		botX 10
		topY 10
		botY 6
		topType 769
		botType 770
		topLoc 67
		botLoc 65
	)
)

(instance alley67 of Alley
	(properties
		streetIndex 2
		topX 10
		botX 2
		topY 10
		botY 10
		topType 770
		botType 771
		topLoc 66
		botLoc 100
	)

	(method (at x y)
		(if (== x 6)
			(= atLoc 68)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley68 of Alley
	(properties
		streetIndex 3
		topX 6
		botX 6
		topY 10
		botY 4
		topType 771
		botType 128
		topLoc 67
	)
)

