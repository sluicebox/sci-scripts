;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 718)
(include sci.sh)
(use Alley)

(public
	alley80 0
	alley81 1
	alley82 2
	alley83 3
	alley84 4
	alley85 5
	alley86 6
	alley87 7
	alley88 8
	alley89 9
)

(instance alley80 of Alley
	(properties
		streetIndex 18
		topX 70
		botX 70
		topY 24
		botY 20
		topType 769
		botType 770
		topLoc 81
		botLoc 34
	)
)

(instance alley81 of Alley
	(properties
		streetIndex 18
		topX 70
		botX 66
		topY 24
		botY 24
		topType 770
		botType 770
		topLoc 80
		botLoc 82
	)
)

(instance alley82 of Alley
	(properties
		streetIndex 18
		topX 66
		botX 66
		topY 24
		botY 22
		topType 770
		botType 769
		topLoc 81
		botLoc 83
	)
)

(instance alley83 of Alley
	(properties
		streetIndex 18
		topX 66
		botX 62
		topY 22
		botY 22
		topType 769
		botType 769
		topLoc 82
		botLoc 84
	)
)

(instance alley84 of Alley
	(properties
		streetIndex 18
		topX 62
		botX 62
		topY 24
		botY 22
		topType 769
		botType 770
		topLoc 85
		botLoc 83
	)
)

(instance alley85 of Alley
	(properties
		streetIndex 18
		topX 62
		botX 60
		topY 24
		botY 24
		topType 770
		botType 769
		topLoc 84
		botLoc 86
	)
)

(instance alley86 of Alley
	(properties
		streetIndex 18
		topX 60
		botX 60
		topY 28
		botY 24
		topType 769
		botType 770
		topLoc 87
		botLoc 85
	)
)

(instance alley87 of Alley
	(properties
		streetIndex 18
		topX 60
		botX 54
		topY 28
		botY 28
		topType 770
		botType 770
		topLoc 86
		botLoc 88
	)
)

(instance alley88 of Alley
	(properties
		topX 54
		botX 54
		topY 28
		botY 22
		topType 770
		botType 770
		topLoc 87
		botLoc 19
	)

	(method (at x y)
		(if (== y 26)
			(= atLoc 89)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (>= y 26)
			(FindStreetName 18)
			(return)
		else
			(FindStreetName 20)
			(return)
		)
	)
)

(instance alley89 of Alley
	(properties
		streetIndex 18
		topX 54
		botX 52
		topY 26
		botY 26
		topType 771
		botType 770
		topLoc 88
		botLoc 98
	)
)

