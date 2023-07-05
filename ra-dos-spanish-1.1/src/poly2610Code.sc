;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2610)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2610Code 0
	pts2610 1
)

(local
	[local0 66] = [0 0 319 0 319 189 157 189 164 170 316 170 316 157 316 144 311 155 302 154 297 157 263 158 244 157 202 130 197 122 185 122 185 103 178 103 178 122 169 122 127 153 117 158 93 159 64 155 66 145 99 132 78 132 24 147 2 157 57 175 65 178 65 189 0 189]
	[local66 70] = [0 0 319 0 319 189 157 189 164 170 316 170 316 157 316 144 311 155 302 154 297 157 263 158 217 158 212 149 230 148 202 130 197 122 185 122 185 103 178 103 178 122 169 122 127 153 117 158 93 159 64 155 66 145 99 132 78 132 24 147 2 157 57 175 65 178 65 189 0 189]
)

(instance poly2610Code of Code
	(properties)

	(method (doit param1)
		(if (IsFlag 20)
			(param1 add: (poly2610b init: yourself:))
		else
			(param1 add: (poly2610 init: yourself:))
		)
	)
)

(instance poly2610 of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 33)
		(= points @local0)
	)
)

(instance poly2610b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 35)
		(= points @local66)
	)
)

(instance pts2610 of MuseumPoints
	(properties
		midPtX 80
		midPtY 175
		northPtX 1180
		northPtY 125
		southPtX 80
		southPtY 250
		eastPtX 1300
		eastPtY 157
	)
)

