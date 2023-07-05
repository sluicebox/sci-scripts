;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 723)
(include sci.sh)
(use Main)
(use Alley)

(public
	alley130 0
	alley131 1
	alley132 2
	alley133 3
	alley134 4
	alley135 5
	alley136 6
	alley137 7
	alley138 8
	alley139 9
)

(instance alley130 of Alley
	(properties
		streetIndex 31
		topX 36
		botX 36
		topY 38
		botY 36
		topType 769
		botType 771
		topLoc 131
		botLoc 127
	)
)

(instance alley131 of Alley
	(properties
		streetIndex 31
		topX 36
		botX 32
		topY 38
		botY 38
		topType 770
		botType 770
		topLoc 130
		botLoc 132
	)
)

(instance alley132 of Alley
	(properties
		streetIndex 31
		topX 32
		botX 32
		topY 38
		botY 36
		topType 770
		botType 769
		topLoc 131
		botLoc 133
	)
)

(instance alley133 of Alley
	(properties
		streetIndex 31
		topX 32
		botX 28
		topY 36
		botY 36
		topType 769
		botType 769
		topLoc 132
		botLoc 134
	)
)

(instance alley134 of Alley
	(properties
		streetIndex 31
		topX 28
		botX 28
		topY 38
		botY 36
		topType 769
		botType 770
		topLoc 135
		botLoc 133
	)
)

(instance alley135 of Alley
	(properties
		streetIndex 31
		topX 28
		botX 24
		topY 38
		botY 38
		topType 770
		botType 770
		topLoc 134
		botLoc 136
	)
)

(instance alley136 of Alley
	(properties
		streetIndex 31
		topX 24
		botX 24
		topY 38
		botY 36
		topType 770
		botType 771
		topLoc 135
		botLoc 165
	)
)

(instance alley137 of Alley
	(properties
		streetIndex 22
		topX 23
		botX 20
		topY 28
		botY 28
		topType 128
		botType 769
		botLoc 138
	)
)

(instance alley138 of Alley
	(properties
		streetIndex 22
		topX 20
		botX 20
		topY 30
		botY 28
		topType 769
		botType 770
		topLoc 139
		botLoc -271
	)

	(method (at theX theY)
		(if (!= gOrigHeroType 0)
			(= botLoc 137)
		)
		(super at: theX theY)
	)
)

(instance alley139 of Alley
	(properties
		streetIndex 22
		topX 20
		botX 14
		topY 30
		botY 30
		topType 770
		botType 769
		topLoc 138
		botLoc 170
	)
)

