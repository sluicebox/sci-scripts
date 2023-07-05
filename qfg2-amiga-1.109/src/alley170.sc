;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 727)
(include sci.sh)
(use Alley)

(public
	alley170 0
	alley171 1
	alley172 2
	alley173 3
	alley174 4
	alley175 5
	alley176 6
	alley177 7
	alley178 8
)

(instance alley170 of Alley
	(properties
		topX 14
		botX 14
		topY 34
		botY 30
		topType 770
		botType 770
		topLoc 169
		botLoc 139
	)

	(method (at x y)
		(if (== y 32)
			(= atLoc 171)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)

	(method (streetName x y)
		(if (<= y 32)
			(FindStreetName 22)
			(return)
		else
			(FindStreetName 27)
			(return)
		)
	)
)

(instance alley171 of Alley
	(properties
		streetIndex 22
		topX 14
		botX 8
		topY 32
		botY 32
		topType 771
		botType 770
		topLoc 170
		botLoc 172
	)
)

(instance alley172 of Alley
	(properties
		streetIndex 22
		topX 8
		botX 8
		topY 32
		botY 28
		topType 770
		botType 771
		topLoc 171
		botLoc 173
	)
)

(instance alley173 of Alley
	(properties
		streetIndex 21
		topX 12
		botX 4
		topY 28
		botY 28
		topType 770
		botType 770
		topLoc 174
		botLoc 178
	)

	(method (at x y)
		(if (== x 8)
			(= atLoc 172)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley174 of Alley
	(properties
		streetIndex 21
		topX 12
		botX 12
		topY 28
		botY 24
		topType 769
		botType 770
		topLoc 173
		botLoc 175
	)
)

(instance alley175 of Alley
	(properties
		streetIndex 21
		topX 14
		botX 12
		topY 24
		botY 24
		topType 769
		botType 769
		topLoc 176
		botLoc 174
	)
)

(instance alley176 of Alley
	(properties
		streetIndex 21
		topX 14
		botX 14
		topY 26
		botY 24
		topType 770
		botType 769
		topLoc 177
		botLoc 175
	)
)

(instance alley177 of Alley
	(properties
		streetIndex 21
		topX 18
		botX 14
		topY 26
		botY 26
		topType 128
		botType 770
		botLoc 176
	)
)

(instance alley178 of Alley
	(properties
		streetIndex 21
		topX 4
		botX 4
		topY 28
		botY 24
		topType 770
		botType 576
		topLoc 173
		botLoc -320
	)
)

