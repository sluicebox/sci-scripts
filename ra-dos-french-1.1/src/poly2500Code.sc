;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2500)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2500Code 0
	pts2500 1
)

(local
	[local0 32] = [97 136 92 165 31 165 27 170 52 170 40 189 0 189 0 0 319 0 319 189 269 181 247 184 217 177 217 172 168 164 108 163]
	[local32 8] = [149 174 160 181 132 181 122 174]
	[local40 8] = [126 165 131 170 106 170 102 165]
)

(instance poly2500Code of Code
	(properties)

	(method (doit param1)
		(param1
			add:
				(poly2500a init: yourself:)
				(poly2500c init: yourself:)
				(poly2500d init: yourself:)
		)
	)
)

(instance poly2500a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 16)
		(= points @local0)
	)
)

(instance poly2500c of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local32)
	)
)

(instance poly2500d of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local40)
	)
)

(instance pts2500 of MuseumPoints
	(properties
		midPtX 170
		midPtY 175
		northPtX 97
		northPtY 150
		southPtX 170
		southPtY 250
	)
)

