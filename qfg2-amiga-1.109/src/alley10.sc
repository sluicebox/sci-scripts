;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 711)
(include sci.sh)
(use Alley)

(public
	alley10 0
	alley11 1
	alley12 2
	alley14 4
	alley15 5
	alley16 6
	alley17 7
	alley18 8
	alley19 9
)

(instance alley10 of Alley
	(properties
		streetIndex 7
		topX 64
		botX 64
		topY 4
		topType 770
		botType 771
		topLoc 11
		botLoc 8
	)
)

(instance alley11 of Alley
	(properties
		streetIndex 7
		topX 66
		botX 64
		topY 4
		botY 4
		topType 769
		botType 770
		topLoc 12
		botLoc 10
	)
)

(instance alley12 of Alley
	(properties
		streetIndex 7
		topX 66
		botX 66
		topY 10
		botY 4
		topType 769
		botType 769
		topLoc 14
		botLoc 11
	)

	(method (at x y)
		(switch y
			(7
				(= atLoc -269)
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

(instance alley14 of Alley
	(properties
		streetIndex 7
		topX 66
		botX 62
		topY 10
		botY 10
		topType 770
		botType 770
		topLoc 12
		botLoc 15
	)
)

(instance alley15 of Alley
	(properties
		streetIndex 7
		topX 62
		botX 62
		topY 10
		botY 8
		topType 770
		botType 769
		topLoc 14
		botLoc 16
	)
)

(instance alley16 of Alley
	(properties
		streetIndex 7
		topX 62
		botX 60
		topY 8
		botY 8
		topType 769
		botType 770
		topLoc 15
		botLoc 17
	)
)

(instance alley17 of Alley
	(properties
		streetIndex 7
		topX 60
		botX 60
		topY 8
		botY 6
		topType 770
		botType 128
		topLoc 16
	)
)

(instance alley18 of Alley
	(properties
		streetIndex 20
		topX 58
		botX 58
		topY 22
		botY 20
		topType 769
		botType 770
		topLoc 19
		botLoc 59
	)
)

(instance alley19 of Alley
	(properties
		streetIndex 20
		topX 58
		botX 54
		topY 22
		botY 22
		topType 770
		botType 769
		topLoc 18
		botLoc 88
	)
)

