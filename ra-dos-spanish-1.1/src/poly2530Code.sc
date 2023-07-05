;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2530)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2530Code 0
	pts2530 1
)

(local
	[local0 8] = [60 152 0 182 0 13 55 72]
	[local8 20] = [68 130 245 130 257 161 251 171 210 185 165 185 118 185 95 180 71 170 66 160]
	[local28 8] = [267 95 319 12 319 176 264 151]
	[local36 54] = [91 143 74 146 46 155 12 166 0 189 0 3 319 3 319 189 311 169 292 160 274 155 246 145 227 141 227 155 262 159 263 170 208 179 203 163 194 149 106 149 102 161 123 166 119 177 108 178 56 168 68 157 90 158]
	[local90 28] = [114 144 104 145 103 137 126 134 146 133 175 135 201 140 223 146 220 151 195 141 171 137 150 136 132 136 118 139]
)

(instance poly2530Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2530a init: yourself:) (poly2530b init: yourself:))
		(if (not (IsFlag 31))
			(param1 add: (poly2530c init: yourself:))
		)
	)
)

(instance poly2530a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size (if (IsFlag 31) 27 else 4))
		(= points (if (IsFlag 31) @local36 else @local0))
	)
)

(instance poly2530b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size (if (IsFlag 31) 14 else 10))
		(= points (if (IsFlag 31) @local90 else @local8))
	)
)

(instance poly2530c of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local28)
	)
)

(instance pts2530 of MuseumPoints
	(properties
		midPtX 290
		midPtY 175
		northPtX 100
		northPtY 160
		southPtX 230
		southPtY 150
	)
)

