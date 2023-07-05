;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2720)
(include sci.sh)
(use Main)
(use Polygon)
(use System)

(public
	poly2720Code 0
)

(local
	[local0 30] = [3 173 30 173 54 187 315 186 315 167 303 172 235 159 253 142 207 140 189 153 154 161 99 161 43 148 30 142 4 148]
	[local30 38] = [3 173 30 173 54 187 315 186 315 167 303 172 294 181 253 185 252 176 267 166 235 159 253 142 207 140 189 153 154 161 99 161 43 148 30 142 4 148]
	[local68 36] = [3 173 30 173 54 187 315 186 309 174 283 172 273 180 245 172 250 164 235 160 253 142 207 140 189 153 154 161 99 161 43 148 30 142 4 148]
)

(instance poly2720Code of Code
	(properties)

	(method (doit param1)
		(cond
			((IsFlag 65)
				(param1 add: (poly2720b init: yourself:))
			)
			((IsFlag 121)
				(param1 add: (poly2720c init: yourself:))
			)
			(else
				(param1 add: (poly2720a init: yourself:))
			)
		)
	)
)

(instance poly2720a of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 15)
		(= points @local0)
	)
)

(instance poly2720b of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 19)
		(= points @local30)
	)
)

(instance poly2720c of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 18)
		(= points @local68)
	)
)

