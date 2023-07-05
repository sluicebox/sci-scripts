;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Alley)

(public
	alley100 0
	alley101 1
	alley102 2
	alley103 3
	alley104 4
	alley105 5
	alley106 6
	alley107 7
	alley108 8
	alley109 9
)

(instance alley100 of Alley
	(properties
		streetIndex 1
		topX 2
		botX 2
		topY 14
		botY 8
		topType 770
		botType 128
		topLoc 101
	)

	(method (at x y)
		(switch y
			(10
				(= atLoc 67)
				(= atType 258)
				(return)
			)
			(else
				(super at: x y)
				(return)
			)
		)
	)
)

(instance alley101 of Alley
	(properties
		streetIndex 1
		topX 4
		botX 2
		topY 14
		botY 14
		topType 769
		botType 770
		topLoc 102
		botLoc 100
	)
)

(instance alley102 of Alley
	(properties
		streetIndex 1
		topX 4
		botX 4
		topY 16
		botY 14
		topType 576
		botType 769
		topLoc -320
		botLoc 101
	)
)

(instance alley103 of Alley
	(properties
		streetIndex 9
		topX 12
		botX 8
		topY 20
		botY 20
		topType 770
		botType 576
		topLoc 104
		botLoc -330
	)
)

(instance alley104 of Alley
	(properties
		streetIndex 9
		topX 12
		botX 12
		topY 20
		botY 18
		topType 769
		botType 770
		topLoc 103
		botLoc 105
	)
)

(instance alley105 of Alley
	(properties
		streetIndex 9
		topX 16
		botX 12
		topY 18
		botY 18
		topType 770
		botType 769
		topLoc 106
		botLoc 104
	)
)

(instance alley106 of Alley
	(properties
		topX 16
		botX 16
		topY 18
		botY 8
		topType 769
		botType 771
		topLoc 105
		botLoc 63
	)

	(method (at x y)
		(switch y
			(12
				(= atLoc 107)
				(= atType 257)
				(return)
			)
			(16
				(= atLoc 117)
				(= atType 258)
				(return)
			)
			(else
				(super at: x y)
				(return)
			)
		)
	)

	(method (streetName x y)
		(if (>= y 16)
			(FindStreetName 9)
			(return)
		else
			(FindStreetName 4)
			(return)
		)
	)
)

(instance alley107 of Alley
	(properties
		streetIndex 10
		topX 16
		botX 13
		topY 12
		botY 12
		topType 771
		botType 769
		topLoc 106
		botLoc 108
	)
)

(instance alley108 of Alley
	(properties
		streetIndex 10
		topX 13
		botX 13
		topY 14
		botY 12
		topType 769
		botType 770
		topLoc 109
		botLoc 107
	)
)

(instance alley109 of Alley
	(properties
		streetIndex 10
		topX 13
		botX 11
		topY 14
		botY 14
		topType 770
		botType 128
		topLoc 108
	)
)

