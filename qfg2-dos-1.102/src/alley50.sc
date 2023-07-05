;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 715)
(include sci.sh)
(use Alley)

(public
	alley50 0
	alley51 1
	alley52 2
	alley53 3
	alley54 4
	alley55 5
	alley56 6
	alley57 7
	alley58 8
	alley59 9
)

(instance alley50 of Alley
	(properties
		streetIndex 11
		topX 36
		botX 32
		topY 20
		botY 20
		topType 576
		botType 771
		topLoc -310
		botLoc 140
	)
)

(instance alley51 of Alley
	(properties
		streetIndex 18
		topX 48
		botX 44
		topY 20
		botY 20
		topType 771
		botType 576
		topLoc 52
		botLoc -315
	)
)

(instance alley52 of Alley
	(properties
		topX 48
		botX 48
		topY 24
		botY 18
		topType 770
		botType 770
		topLoc 99
		botLoc 53
	)

	(method (at x y)
		(if (== y 20)
			(= atLoc 51)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (>= y 20)
			(FindStreetName 18)
			(return)
		else
			(FindStreetName 19)
			(return)
		)
	)
)

(instance alley53 of Alley
	(properties
		streetIndex 19
		topX 56
		botX 48
		topY 18
		botY 18
		topType 770
		botType 769
		topLoc 54
		botLoc 52
	)
)

(instance alley54 of Alley
	(properties
		streetIndex 19
		topX 56
		botX 56
		topY 18
		botY 16
		topType 769
		botType 770
		topLoc 53
		botLoc 55
	)
)

(instance alley55 of Alley
	(properties
		streetIndex 19
		topX 60
		botX 56
		topY 16
		botY 16
		topType 771
		botType 769
		topLoc 56
		botLoc 54
	)
)

(instance alley56 of Alley
	(properties
		streetIndex 19
		topX 60
		botX 60
		topY 20
		botY 13
		topType 769
		botType 770
		topLoc 59
		botLoc 57
	)

	(method (at x y)
		(if (== y 16)
			(= atLoc 55)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley57 of Alley
	(properties
		streetIndex 19
		topX 70
		botX 60
		topY 13
		botY 13
		topType 128
		botType 769
		botLoc 56
	)

	(method (at x y)
		(if (== x 64)
			(= atLoc 58)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley58 of Alley
	(properties
		topX 64
		botX 64
		topY 18
		botY 13
		topType 128
		botType 771
		botLoc 57
	)
)

(instance alley59 of Alley
	(properties
		streetIndex 20
		topX 60
		botX 58
		topY 20
		botY 20
		topType 770
		botType 769
		topLoc 56
		botLoc 18
	)
)

