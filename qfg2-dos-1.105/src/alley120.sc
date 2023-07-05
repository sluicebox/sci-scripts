;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 722)
(include sci.sh)
(use Alley)

(public
	alley120 0
	alley121 1
	alley122 2
	alley123 3
	alley124 4
	alley125 5
	alley126 6
	alley127 7
	alley129 9
)

(instance alley120 of Alley
	(properties
		streetIndex 29
		topX 54
		botX 54
		topY 36
		botY 34
		topType 770
		botType 769
		topLoc 90
		botLoc 121
	)
)

(instance alley121 of Alley
	(properties
		streetIndex 29
		topX 54
		botX 42
		topY 34
		botY 34
		topType 769
		botType 770
		topLoc 120
		botLoc 122
	)

	(method (at x y)
		(if (== x 48)
			(= atLoc 124)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley122 of Alley
	(properties
		topX 42
		botX 42
		topY 34
		botY 30
		topType 770
		botType 770
		topLoc 121
		botLoc 123
	)

	(method (at x y)
		(if (== y 32)
			(= atLoc 149)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (<= y 32)
			(FindStreetName 24)
			(return)
		else
			(FindStreetName 29)
			(return)
		)
	)
)

(instance alley123 of Alley
	(properties
		streetIndex 24
		topX 44
		botX 42
		topY 30
		botY 30
		topType 770
		botType 769
		topLoc 97
		botLoc 122
	)
)

(instance alley124 of Alley
	(properties
		streetIndex 32
		topX 48
		botX 48
		topY 38
		botY 34
		topType 769
		botType 771
		topLoc 125
		botLoc 121
	)
)

(instance alley125 of Alley
	(properties
		streetIndex 32
		topX 48
		botX 42
		topY 38
		botY 38
		topType 770
		botType 770
		topLoc 124
		botLoc 126
	)
)

(instance alley126 of Alley
	(properties
		streetIndex 32
		topX 42
		botX 42
		topY 38
		botY 36
		topType 770
		botType 769
		topLoc 125
		botLoc 127
	)
)

(instance alley127 of Alley
	(properties
		streetIndex 32
		topX 42
		botX 34
		topY 36
		botY 36
		topType 769
		botType 770
		topLoc 126
		botLoc 129
	)

	(method (at x y)
		(cond
			((== x 36)
				(= atLoc 130)
				(= atType 257)
				(return)
			)
			((== x 40)
				(= atLoc -229)
				(= atType 257)
				(return)
			)
			(else
				(super at: x y)
				(return)
			)
		)
	)
)

(instance alley129 of Alley
	(properties
		streetIndex 32
		topX 34
		botX 34
		topY 36
		botY 34
		topType 770
		botType 128
		topLoc 127
	)
)

