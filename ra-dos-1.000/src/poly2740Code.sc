;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2740)
(include sci.sh)
(use Polygon)
(use System)

(public
	poly2740Code 0
)

(local
	[local0 32] = [36 189 0 189 0 0 319 0 319 189 48 189 192 106 294 106 294 37 272 37 272 104 248 104 248 37 220 37 220 104 184 104]
)

(instance poly2740Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2740a init: yourself:))
	)
)

(instance poly2740a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 16)
		(= points @local0)
	)
)

