;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 717)
(include sci.sh)
(use Alley)

(public
	alley70 0
	alley71 1
	alley72 2
	alley73 3
	alley74 4
	alley75 5
	alley76 6
	alley77 7
	alley78 8
	alley79 9
)

(instance alley70 of Alley
	(properties
		streetIndex 25
		topX 76
		botX 72
		topY 28
		botY 28
		topType 771
		botType 770
		topLoc 35
		botLoc 71
	)
)

(instance alley71 of Alley
	(properties
		streetIndex 25
		topX 72
		botX 72
		topY 28
		botY 26
		topType 770
		botType 769
		topLoc 70
		botLoc 72
	)
)

(instance alley72 of Alley
	(properties
		streetIndex 25
		topX 72
		botX 70
		topY 26
		botY 26
		topType 769
		botType 769
		topLoc 71
		botLoc 73
	)
)

(instance alley73 of Alley
	(properties
		streetIndex 25
		topX 70
		botX 70
		topY 30
		botY 26
		topType 769
		botType 770
		topLoc 74
		botLoc 72
	)
)

(instance alley74 of Alley
	(properties
		streetIndex 25
		topX 70
		botX 64
		topY 30
		botY 30
		topType 770
		botType 769
		topLoc 73
		botLoc 75
	)
)

(instance alley75 of Alley
	(properties
		topX 64
		botX 64
		topY 38
		botY 30
		topType 769
		botType 770
		topLoc 78
		botLoc 74
	)

	(method (at x y)
		(switch y
			(36
				(= atLoc 77)
				(= atType 258)
				(return)
			)
			(33
				(= atLoc 76)
				(= atType 257)
				(return)
			)
			(else
				(super at: x y)
				(return)
			)
		)
	)

	(method (streetName x y)
		(if (<= y 33)
			(FindStreetName 25)
			(return)
		else
			(FindStreetName 29)
			(return)
		)
	)
)

(instance alley76 of Alley
	(properties
		streetIndex 25
		topX 64
		botX 60
		topY 33
		botY 33
		topType 771
		botType 128
		topLoc 75
	)
)

(instance alley77 of Alley
	(properties
		streetIndex 26
		topX 68
		botX 64
		topY 36
		botY 36
		topType 770
		botType 771
		topLoc 39
		botLoc 75
	)
)

(instance alley78 of Alley
	(properties
		streetIndex 29
		topX 64
		botX 60
		topY 38
		botY 38
		topType 770
		botType 770
		topLoc 75
		botLoc 79
	)
)

(instance alley79 of Alley
	(properties
		streetIndex 29
		topX 60
		botX 60
		topY 38
		botY 36
		topType 770
		botType 769
		topLoc 78
		botLoc 90
	)
)

