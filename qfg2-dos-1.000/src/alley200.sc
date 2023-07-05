;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Alley)

(public
	alley200 0
	alley201 1
	alley202 2
	alley203 3
	alley204 4
	alley205 5
	alley206 6
	alley207 7
	alley208 8
	alley209 9
)

(instance alley200 of Alley
	(properties
		streetIndex 44
		topX 42
		botX 42
		topY 128
		botY 112
		topType 576
		botType 576
		topLoc -380
		botLoc -390
	)

	(method (at x y)
		(cond
			((== y 124)
				(= atLoc 201)
				(= atType 259)
				(return)
			)
			((== y 124)
				(= atLoc 201)
				(= atType 257)
				(return)
			)
			((== y 120)
				(= atLoc -429)
				(= atType 258)
				(return)
			)
			((== y 116)
				(= atLoc 210)
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

(instance alley201 of Alley
	(properties
		topX 44
		botX 38
		topY 124
		botY 124
		topType 4096
		botType 770
		botLoc 202
	)

	(method (at x y)
		(if (== x 42)
			(= atLoc 200)
			(= atType 259)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x)
		(if (> x 42)
			(FindStreetName 45)
			(return)
		else
			(FindStreetName 34)
			(return)
		)
	)
)

(instance alley202 of Alley
	(properties
		streetIndex 34
		topX 38
		botX 38
		topY 124
		botY 122
		topType 770
		botType 769
		topLoc 201
		botLoc 203
	)
)

(instance alley203 of Alley
	(properties
		streetIndex 34
		topX 38
		botX 30
		topY 122
		botY 122
		topType 769
		botType 769
		topLoc 202
		botLoc 204
	)
)

(instance alley204 of Alley
	(properties
		streetIndex 34
		topX 30
		botX 30
		topY 126
		botY 122
		topType 769
		botType 770
		topLoc 205
		botLoc 203
	)
)

(instance alley205 of Alley
	(properties
		streetIndex 34
		topX 30
		botX 26
		topY 126
		botY 126
		topType 770
		botType 769
		topLoc 204
		botLoc 206
	)
)

(instance alley206 of Alley
	(properties
		streetIndex 34
		topX 26
		botX 26
		topY 128
		botY 126
		topType 769
		botType 770
		topLoc 207
		botLoc 205
	)
)

(instance alley207 of Alley
	(properties
		streetIndex 34
		topX 26
		botX 10
		topY 128
		botY 128
		topType 770
		botType 770
		topLoc 206
		botLoc 208
	)

	(method (at x y)
		(if (== x 18)
			(= atLoc 250)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley208 of Alley
	(properties
		streetIndex 34
		topX 10
		botX 10
		topY 128
		botY 124
		topType 770
		botType 769
		topLoc 207
		botLoc 209
	)
)

(instance alley209 of Alley
	(properties
		streetIndex 34
		topX 10
		botX 6
		topY 124
		botY 124
		topType 769
		botType 770
		topLoc 208
		botLoc 258
	)
)

