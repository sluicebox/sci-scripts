;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 712)
(include sci.sh)
(use Alley)

(public
	alley20 0
	alley21 1
	alley22 2
	alley23 3
	alley24 4
	alley25 5
	alley26 6
	alley27 7
	alley28 8
	alley29 9
)

(instance alley20 of Alley
	(properties
		streetIndex 5
		topX 56
		botX 52
		topY 2
		botY 2
		topType 770
		botType 769
		topLoc 9
		botLoc 21
	)
)

(instance alley21 of Alley
	(properties
		streetIndex 5
		topX 52
		botX 52
		topY 6
		botY 2
		topType 769
		botType 770
		topLoc 22
		botLoc 20
	)
)

(instance alley22 of Alley
	(properties
		streetIndex 5
		topX 52
		botX 44
		topY 6
		botY 6
		topType 770
		botType 770
		topLoc 21
		botLoc 23
	)
)

(instance alley23 of Alley
	(properties
		streetIndex 5
		topX 44
		botX 44
		topY 6
		botY 4
		topType 770
		botType 769
		topLoc 22
		botLoc 24
	)
)

(instance alley24 of Alley
	(properties
		topX 44
		botX 32
		topY 4
		botY 4
		topType 769
		botType 770
		topLoc 23
		botLoc 26
	)

	(method (at x y)
		(if (== x 40)
			(= atLoc 25)
			(= atType 259)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x)
		(if (>= x 40)
			(FindStreetName 5)
			(return)
		else
			(FindStreetName 2)
			(return)
		)
	)
)

(instance alley25 of Alley
	(properties
		streetIndex 6
		topX 40
		botX 40
		topY 16
		topType 576
		botType 576
		topLoc -315
		botLoc -300
	)

	(method (at x y)
		(switch y
			(4
				(= atLoc 24)
				(= atType 259)
				(return)
			)
			(8
				(= atLoc 40)
				(= atType 257)
				(return)
			)
			(12
				(= atLoc 42)
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

(instance alley26 of Alley
	(properties
		streetIndex 2
		topX 32
		botX 32
		topY 4
		botY 2
		topType 770
		botType 769
		topLoc 24
		botLoc 27
	)
)

(instance alley27 of Alley
	(properties
		streetIndex 2
		topX 32
		botX 28
		topY 2
		botY 2
		topType 769
		botType 770
		topLoc 26
		botLoc 28
	)
)

(instance alley28 of Alley
	(properties
		streetIndex 2
		topX 28
		botX 28
		topY 2
		topType 770
		botType 769
		topLoc 27
		botLoc 29
	)
)

(instance alley29 of Alley
	(properties
		streetIndex 2
		topX 28
		botX 16
		topType 769
		botType 769
		topLoc 28
		botLoc 60
	)
)

