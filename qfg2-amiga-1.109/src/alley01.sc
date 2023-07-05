;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use Alley)

(public
	alley01 1
	alley02 2
	alley03 3
	alley04 4
	alley05 5
	alley06 6
	alley07 7
	alley08 8
	alley09 9
)

(instance alley01 of Alley
	(properties
		streetIndex 8
		topX 82
		botX 82
		topY 12
		botY 6
		topType 769
		botType 769
		topLoc 30
		botLoc -200
	)

	(method (at x y)
		(switch y
			(6
				(if (<= 0 gTimeODay 4)
					(super at: x y)
					(return)
				else
					(= atLoc 0)
					(= atType 513)
					(return)
				)
			)
			(9
				(= atLoc 2)
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

(instance alley02 of Alley
	(properties
		streetIndex 5
		topX 82
		botX 78
		topY 9
		botY 9
		topType 771
		botType 770
		topLoc 1
		botLoc 3
	)
)

(instance alley03 of Alley
	(properties
		streetIndex 5
		topX 78
		botX 78
		topY 9
		botY 7
		topType 770
		botType 769
		topLoc 2
		botLoc 4
	)
)

(instance alley04 of Alley
	(properties
		streetIndex 5
		topX 78
		botX 76
		topY 7
		botY 7
		topType 769
		botType 770
		topLoc 3
		botLoc 5
	)
)

(instance alley05 of Alley
	(properties
		streetIndex 5
		topX 76
		botX 76
		topY 7
		botY 3
		topType 770
		botType 769
		topLoc 4
		botLoc 6
	)
)

(instance alley06 of Alley
	(properties
		streetIndex 5
		topX 76
		botX 72
		topY 3
		botY 3
		topType 769
		botType 770
		topLoc 5
		botLoc 7
	)
)

(instance alley07 of Alley
	(properties
		streetIndex 5
		topX 72
		botX 72
		topY 3
		topType 770
		botType 769
		topLoc 6
		botLoc 8
	)
)

(instance alley08 of Alley
	(properties
		streetIndex 5
		topX 72
		botX 56
		topType 769
		botType 769
		topLoc 7
		botLoc 9
	)

	(method (at x y)
		(switch x
			(64
				(= atLoc 10)
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

(instance alley09 of Alley
	(properties
		streetIndex 5
		topX 56
		botX 56
		topY 2
		topType 769
		botType 770
		topLoc 20
		botLoc 8
	)
)

