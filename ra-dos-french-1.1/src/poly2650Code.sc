;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2650)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2650Code 0
	pts2650 1
)

(local
	[local0 22] = [0 0 319 0 319 138 179 101 61 115 59 111 49 111 42 122 58 122 56 189 0 189]
	[local22 10] = [96 155 78 120 170 109 208 132 99 159]
	[local32 16] = [208 184 192 170 222 157 229 163 244 161 237 168 244 176 215 188]
	[local48 8] = [171 146 182 155 164 163 155 154]
)

(instance poly2650Code of Code
	(properties)

	(method (doit param1)
		(param1
			add:
				(poly2650a init: yourself:)
				(poly2650b init: yourself:)
				(poly2650c init: yourself:)
				(poly2650d init: yourself:)
		)
	)
)

(instance poly2650a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 11)
		(= points @local0)
	)
)

(instance poly2650b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 5)
		(= points @local22)
	)
)

(instance poly2650c of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 8)
		(= points @local32)
	)
)

(instance poly2650d of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local48)
	)
)

(instance pts2650 of MuseumPoints
	(properties
		midPtX 125
		midPtY 165
		southPtX 125
		southPtY 250
	)
)

