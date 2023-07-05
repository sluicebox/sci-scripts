;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 719)
(include sci.sh)
(use Alley)

(public
	alley90 0
	alley91 1
	alley92 2
	alley93 3
	alley94 4
	alley95 5
	alley96 6
	alley97 7
	alley98 8
	alley99 9
)

(instance alley90 of Alley
	(properties
		streetIndex 29
		topX 60
		botX 54
		topY 36
		botY 36
		topType 769
		botType 770
		topLoc 79
		botLoc 120
	)

	(method (at x y)
		(if (== x 56)
			(= atLoc 91)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley91 of Alley
	(properties
		streetIndex 24
		topX 56
		botX 56
		topY 36
		botY 30
		topType 771
		botType 769
		topLoc 90
		botLoc 92
	)

	(method (at x y)
		(if (== y 32)
			(= atLoc -199)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley92 of Alley
	(properties
		streetIndex 24
		topX 56
		botX 50
		topY 30
		botY 30
		topType 769
		botType 770
		topLoc 91
		botLoc 93
	)
)

(instance alley93 of Alley
	(properties
		streetIndex 24
		topX 50
		botX 50
		topY 30
		botY 28
		topType 770
		botType 769
		topLoc 92
		botLoc 94
	)
)

(instance alley94 of Alley
	(properties
		streetIndex 24
		topX 50
		botX 46
		topY 28
		botY 28
		topType 769
		botType 770
		topLoc 93
		botLoc 95
	)
)

(instance alley95 of Alley
	(properties
		streetIndex 24
		topX 46
		botX 46
		topY 28
		botY 26
		topType 770
		botType 769
		topLoc 94
		botLoc 96
	)
)

(instance alley96 of Alley
	(properties
		streetIndex 24
		topX 46
		botX 44
		topY 26
		botY 26
		topType 769
		botType 769
		topLoc 95
		botLoc 97
	)
)

(instance alley97 of Alley
	(properties
		streetIndex 24
		topX 44
		botX 44
		topY 30
		botY 26
		topType 769
		botType 770
		topLoc 123
		botLoc 96
	)
)

(instance alley98 of Alley
	(properties
		streetIndex 18
		topX 52
		botX 52
		topY 26
		botY 24
		topType 770
		botType 769
		topLoc 89
		botLoc 99
	)
)

(instance alley99 of Alley
	(properties
		streetIndex 18
		topX 52
		botX 48
		topY 24
		botY 24
		topType 769
		botType 770
		topLoc 98
		botLoc 52
	)
)

