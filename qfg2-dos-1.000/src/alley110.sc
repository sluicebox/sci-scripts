;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 721)
(include sci.sh)
(use Alley)

(public
	alley110 0
	alley111 1
	alley112 2
	alley113 3
	alley114 4
	alley115 5
	alley116 6
	alley117 7
)

(instance alley110 of Alley
	(properties
		streetIndex 11
		topX 26
		botX 22
		topY 26
		botY 26
		topType 770
		botType 770
		topLoc 150
		botLoc 111
	)
)

(instance alley111 of Alley
	(properties
		streetIndex 11
		topX 22
		botX 22
		topY 26
		botY 22
		topType 770
		botType 769
		topLoc 110
		botLoc 112
	)
)

(instance alley112 of Alley
	(properties
		streetIndex 11
		topX 22
		botX 20
		topY 22
		botY 22
		topType 769
		botType 770
		topLoc 111
		botLoc 113
	)
)

(instance alley113 of Alley
	(properties
		topX 20
		botX 20
		topY 22
		botY 16
		topType 770
		botType 769
		topLoc 112
		botLoc 117
	)

	(method (at x y)
		(if (== y 18)
			(= atLoc 114)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (<= y 18)
			(FindStreetName 9)
			(return)
		else
			(FindStreetName 11)
			(return)
		)
	)
)

(instance alley114 of Alley
	(properties
		streetIndex 9
		topX 24
		botX 20
		topY 18
		botY 18
		topType 770
		botType 771
		topLoc 115
		botLoc 113
	)
)

(instance alley115 of Alley
	(properties
		streetIndex 9
		topX 24
		botX 24
		topY 18
		botY 16
		topType 769
		botType 770
		topLoc 114
		botLoc 116
	)
)

(instance alley116 of Alley
	(properties
		streetIndex 9
		topX 28
		botX 24
		topY 16
		botY 16
		topType 771
		botType 769
		topLoc 152
		botLoc 115
	)
)

(instance alley117 of Alley
	(properties
		streetIndex 9
		topX 20
		botX 16
		topY 16
		botY 16
		topType 769
		botType 771
		topLoc 113
		botLoc 106
	)
)

