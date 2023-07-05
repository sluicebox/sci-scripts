;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 713)
(include sci.sh)
(use Alley)

(public
	alley30 0
	alley31 1
	alley32 2
	alley33 3
	alley34 4
	alley35 5
	alley36 6
	alley37 7
	alley38 8
	alley39 9
)

(instance alley30 of Alley
	(properties
		streetIndex 8
		topX 82
		botX 80
		topY 12
		botY 12
		topType 770
		botType 769
		topLoc 1
		botLoc 31
	)
)

(instance alley31 of Alley
	(properties
		streetIndex 8
		topX 80
		botX 80
		topY 14
		botY 12
		topType 769
		botType 770
		topLoc 32
		botLoc 30
	)
)

(instance alley32 of Alley
	(properties
		streetIndex 8
		topX 80
		botX 76
		topY 14
		botY 14
		topType 770
		botType 769
		topLoc 31
		botLoc 33
	)
)

(instance alley33 of Alley
	(properties
		streetIndex 8
		topX 76
		botX 76
		topY 16
		botY 14
		topType 576
		botType 770
		topLoc -335
		botLoc 32
	)
)

(instance alley34 of Alley
	(properties
		streetIndex 18
		topX 72
		botX 70
		topY 20
		botY 20
		topType 576
		botType 769
		topLoc -335
		botLoc 80
	)
)

(instance alley35 of Alley
	(properties
		streetIndex 26
		topX 76
		botX 76
		topY 32
		botY 24
		topType 769
		botType 576
		topLoc 36
		botLoc -335
	)

	(method (at x y)
		(switch y
			(28
				(= atLoc 70)
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

(instance alley36 of Alley
	(properties
		streetIndex 26
		topX 76
		botX 72
		topY 32
		botY 32
		topType 770
		botType 769
		topLoc 35
		botLoc 37
	)
)

(instance alley37 of Alley
	(properties
		streetIndex 26
		topX 72
		botX 72
		topY 34
		botY 32
		topType 769
		botType 770
		topLoc 38
		botLoc 36
	)
)

(instance alley38 of Alley
	(properties
		streetIndex 26
		topX 72
		botX 68
		topY 34
		botY 34
		topType 770
		botType 769
		topLoc 37
		botLoc 39
	)
)

(instance alley39 of Alley
	(properties
		streetIndex 26
		topX 68
		botX 68
		topY 36
		botY 34
		topType 769
		botType 770
		topLoc 77
		botLoc 38
	)
)

