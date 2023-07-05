;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 725)
(include sci.sh)
(use Alley)

(public
	alley150 0
	alley151 1
	alley152 2
	alley153 3
	alley154 4
	alley155 5
	alley156 6
	alley157 7
	alley158 8
	alley159 9
)

(instance alley150 of Alley
	(properties
		topX 26
		botX 26
		topY 26
		botY 22
		topType 769
		botType 770
		topLoc 110
		botLoc 151
	)

	(method (at x y)
		(if (== y 24)
			(= atLoc 141)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (>= y 24)
			(FindStreetName 11)
			(return)
		else
			(FindStreetName 12)
			(return)
		)
	)
)

(instance alley151 of Alley
	(properties
		streetIndex 12
		topX 28
		botX 26
		topY 22
		botY 22
		topType 770
		botType 769
		topLoc 152
		botLoc 150
	)
)

(instance alley152 of Alley
	(properties
		streetIndex 12
		topX 28
		botX 28
		topY 22
		botY 7
		topType 769
		botType 769
		topLoc 151
		botLoc 153
	)

	(method (at x y)
		(if (== y 16)
			(= atLoc 116)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley153 of Alley
	(properties
		streetIndex 12
		topX 28
		botX 24
		topY 7
		botY 7
		topType 769
		botType 771
		topLoc 152
		botLoc 154
	)
)

(instance alley154 of Alley
	(properties
		topX 24
		botX 24
		topY 9
		botY 5
		topType 128
		botType 769
		botLoc 155
	)

	(method (at x y)
		(if (== y 7)
			(= atLoc 153)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (<= y 7)
			(FindStreetName 12)
			(return)
		else
			(FindStreetName 13)
			(return)
		)
	)
)

(instance alley155 of Alley
	(properties
		streetIndex 12
		topX 24
		botX 20
		topY 5
		botY 5
		topType 769
		botType 769
		topLoc 154
		botLoc 156
	)
)

(instance alley156 of Alley
	(properties
		streetIndex 12
		topX 20
		botX 20
		topY 10
		botY 5
		topType 770
		botType 770
		topLoc 157
		botLoc 155
	)
)

(instance alley157 of Alley
	(properties
		streetIndex 12
		topX 22
		botX 20
		topY 10
		botY 10
		topType 769
		botType 770
		topLoc 158
		botLoc 156
	)
)

(instance alley158 of Alley
	(properties
		streetIndex 12
		topX 22
		botX 22
		topY 12
		botY 10
		topType 769
		botType 769
		topLoc 159
		botLoc 157
	)
)

(instance alley159 of Alley
	(properties
		streetIndex 12
		topX 22
		botX 20
		topY 12
		botY 12
		topType 770
		botType 769
		topLoc 158
		botLoc -120
	)
)

