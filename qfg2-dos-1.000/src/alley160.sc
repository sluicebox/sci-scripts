;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 726)
(include sci.sh)
(use Alley)

(public
	alley160 0
	alley161 1
	alley162 2
	alley163 3
	alley164 4
	alley165 5
	alley166 6
	alley167 7
	alley168 8
	alley169 9
)

(instance alley160 of Alley
	(properties
		streetIndex 28
		topX 32
		botX 28
		topY 32
		botY 32
		topType 770
		botType 771
		topLoc 144
		botLoc 162
	)
)

(instance alley161 of Alley
	(properties
		streetIndex 27
		topX 28
		botX 26
		topY 30
		botY 30
		topType 769
		botType 128
		topLoc 162
	)
)

(instance alley162 of Alley
	(properties
		streetIndex 27
		topX 28
		botX 28
		topY 34
		botY 30
		topType 769
		botType 769
		topLoc 163
		botLoc 161
	)

	(method (at x y)
		(if (== y 32)
			(= atLoc 160)
			(= atType 258)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley163 of Alley
	(properties
		streetIndex 27
		topX 28
		botX 26
		topY 34
		botY 34
		topType 770
		botType 769
		topLoc 162
		botLoc 164
	)
)

(instance alley164 of Alley
	(properties
		streetIndex 27
		topX 26
		botX 26
		topY 36
		botY 34
		topType 769
		botType 770
		topLoc 165
		botLoc 163
	)
)

(instance alley165 of Alley
	(properties
		streetIndex 27
		topX 26
		botX 22
		topY 36
		botY 36
		topType 770
		botType 770
		topLoc 164
		botLoc 166
	)

	(method (at x y)
		(if (== x 24)
			(= atLoc 136)
			(= atType 257)
			(return)
		else
			(super at: x y)
			(return)
		)
	)
)

(instance alley166 of Alley
	(properties
		streetIndex 27
		topX 22
		botX 22
		topY 36
		botY 32
		topType 770
		botType 769
		topLoc 165
		botLoc 167
	)
)

(instance alley167 of Alley
	(properties
		streetIndex 27
		topX 22
		botX 18
		topY 32
		botY 32
		topType 769
		botType 769
		topLoc 166
		botLoc 168
	)
)

(instance alley168 of Alley
	(properties
		streetIndex 27
		topX 18
		botX 18
		topY 34
		botY 32
		topType 769
		botType 770
		topLoc 169
		botLoc 167
	)
)

(instance alley169 of Alley
	(properties
		streetIndex 27
		topX 18
		botX 14
		topY 34
		botY 34
		topType 770
		botType 770
		topLoc 168
		botLoc 170
	)
)

