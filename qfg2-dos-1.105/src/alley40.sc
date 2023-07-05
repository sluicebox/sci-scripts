;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 714)
(include sci.sh)
(use Alley)

(public
	alley40 0
	alley41 1
	alley42 2
	alley43 3
	alley44 4
	alley45 5
	alley46 6
	alley47 7
	alley48 8
	alley49 9
)

(instance alley40 of Alley
	(properties
		streetIndex 15
		topX 40
		botX 36
		topY 8
		botY 8
		topType 771
		botType 769
		topLoc 25
		botLoc 41
	)
)

(instance alley41 of Alley
	(properties
		streetIndex 15
		topX 36
		botX 36
		topY 10
		botY 8
		topType 128
		botType 770
		botLoc 40
	)
)

(instance alley42 of Alley
	(properties
		streetIndex 16
		topX 44
		botX 40
		topY 12
		botY 12
		topType 770
		botType 771
		topLoc 43
		botLoc 25
	)
)

(instance alley43 of Alley
	(properties
		streetIndex 16
		topX 44
		botX 44
		topY 12
		botY 10
		topType 769
		botType 770
		topLoc 42
		botLoc 44
	)
)

(instance alley44 of Alley
	(properties
		streetIndex 16
		topX 52
		botX 44
		topY 10
		botY 10
		topType 128
		botType 769
		botLoc 43
	)

	(method (at x y)
		(if (== x 48)
			(= atLoc 45)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley45 of Alley
	(properties
		streetIndex 17
		topX 48
		botX 48
		topY 14
		botY 10
		topType 770
		botType 771
		topLoc 46
		botLoc 44
	)
)

(instance alley46 of Alley
	(properties
		streetIndex 17
		topX 54
		botX 48
		topY 14
		botY 14
		topType 770
		botType 770
		topLoc 47
		botLoc 45
	)
)

(instance alley47 of Alley
	(properties
		streetIndex 17
		topX 54
		botX 54
		topY 14
		botY 12
		topType 769
		botType 770
		topLoc 46
		botLoc 48
	)
)

(instance alley48 of Alley
	(properties
		streetIndex 17
		topX 56
		botX 54
		topY 12
		botY 12
		topType 770
		botType 769
		topLoc 49
		botLoc 47
	)
)

(instance alley49 of Alley
	(properties
		streetIndex 17
		topX 56
		botX 56
		topY 12
		botY 9
		topType 769
		botType 128
		topLoc 48
	)
)

