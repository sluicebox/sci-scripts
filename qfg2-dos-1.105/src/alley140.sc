;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 724)
(include sci.sh)
(use Alley)

(public
	alley140 0
	alley141 1
	alley142 2
	alley143 3
	alley144 4
	alley145 5
	alley146 6
	alley147 7
	alley148 8
	alley149 9
)

(instance alley140 of Alley
	(properties
		topX 32
		botX 32
		topY 24
		botY 12
		topType 769
		botType 128
		topLoc 141
	)

	(method (at x y)
		(if (== y 20)
			(= atLoc 50)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (>= y 20)
			(FindStreetName 11)
			(return)
		else
			(FindStreetName 14)
			(return)
		)
	)
)

(instance alley141 of Alley
	(properties
		streetIndex 11
		topX 32
		botX 26
		topY 24
		botY 24
		topType 770
		botType 771
		topLoc 140
		botLoc 150
	)

	(method (at x y)
		(if (== x 30)
			(= atLoc 142)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley142 of Alley
	(properties
		streetIndex 23
		topX 30
		botX 30
		topY 28
		botY 24
		topType 770
		botType 771
		topLoc 143
		botLoc 141
	)
)

(instance alley143 of Alley
	(properties
		streetIndex 23
		topX 32
		botX 30
		topY 28
		botY 28
		topType 769
		botType 770
		topLoc 144
		botLoc 142
	)
)

(instance alley144 of Alley
	(properties
		topX 32
		botX 32
		topY 32
		botY 28
		topType 769
		botType 769
		topLoc 160
		botLoc 143
	)

	(method (at x y)
		(if (== y 30)
			(= atLoc 145)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (>= y 30)
			(FindStreetName 28)
			(return)
		else
			(FindStreetName 23)
			(return)
		)
	)
)

(instance alley145 of Alley
	(properties
		streetIndex 28
		topX 36
		botX 32
		topY 30
		botY 30
		topType 771
		botType 771
		topLoc 146
		botLoc 144
	)
)

(instance alley146 of Alley
	(properties
		streetIndex 24
		topX 36
		botX 36
		topY 32
		botY 28
		topType 770
		botType 770
		topLoc 149
		botLoc 147
	)

	(method (at x y)
		(if (== y 30)
			(= atLoc 145)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley147 of Alley
	(properties
		streetIndex 24
		topX 40
		botX 36
		topY 28
		botY 28
		topType 770
		botType 769
		topLoc 148
		botLoc 146
	)
)

(instance alley148 of Alley
	(properties
		streetIndex 24
		topX 40
		botX 40
		topY 28
		botY 24
		topType 769
		botType 576
		topLoc 147
		botLoc -310
	)
)

(instance alley149 of Alley
	(properties
		streetIndex 24
		topX 42
		botX 36
		topY 32
		botY 32
		topType 771
		botType 770
		topLoc 122
		botLoc 146
	)
)

