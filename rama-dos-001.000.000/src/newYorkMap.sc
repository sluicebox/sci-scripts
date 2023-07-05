;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 357)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	newYorkMap 0
)

(instance newYorkMap of AutoMapInset
	(properties
		picture 357
	)

	(method (init)
		(Load rsVIEW 357)
		(super init: &rest)
	)

	(method (initItems)
		(portPath init: insetCast)
		(avianPlaza init: insetCast)
		(avianExit init: insetCast)
		(northSouth1 init: insetCast)
		(northSouth2 init: insetCast)
		(northSouth3 init: insetCast)
		(northSouth4 init: insetCast)
		(northSouth5 init: insetCast)
		(northSouth6 init: insetCast)
		(eastWest1 init: insetCast)
		(eastWest2 init: insetCast)
		(eastWest3 init: insetCast)
		(eastWest4 init: insetCast)
		(eastWest5 init: insetCast)
		(octoPlaza init: insetCast)
		(humanPlaza init: insetCast)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(5700 ; NYPort
				(param1 posn: 115 258)
			)
			(5701 ; NYPort2
				(param1 posn: 115 258)
			)
			(5500 ; NYMazeA
				(param1 posn: 133 247)
			)
			(5501 ; NYMazeB
				(param1 posn: 180 220)
			)
			(5502 ; NYMazeC
				(param1 posn: 212 174)
			)
			(5503 ; NYMazeD
				(param1 posn: 220 170)
			)
			(5504 ; NYMazeE
				(param1 posn: 230 167)
			)
			(5505 ; NYMazeF
				(param1 posn: 221 160)
			)
			(5506 ; NYMazeG
				(param1 posn: 248 185)
			)
			(5507 ; NYMazeH
				(param1 posn: 245 148)
			)
			(5508 ; NYMazeI
				(param1 posn: 255 141)
			)
			(5509 ; NYMazeJ
				(param1 posn: 308 111)
			)
			(5510 ; NYMazeK
				(param1 posn: 357 82)
			)
			(5511 ; NYMazeL
				(param1 posn: 403 90)
			)
			(5512 ; NYMazeM
				(param1 posn: 396 95)
			)
			(5513 ; NYMazeN
				(param1 posn: 388 99)
			)
			(5514 ; NYMazeO
				(param1 posn: 378 104)
			)
			(5515 ; NYMazeP
				(param1 posn: 397 120)
			)
			(5516 ; NYMazeQ
				(param1 posn: 362 142)
			)
			(5517 ; NYMazeR
				(param1 posn: 320 169)
			)
			(5518 ; NYMazeS
				(param1 posn: 299 150)
			)
			(5519 ; NYMazeT
				(param1 posn: 308 176)
			)
			(5520 ; NYMazeU
				(param1 posn: 266 203)
			)
			(5521 ; NYMazeW
				(param1 posn: 392 62)
			)
			(5522 ; NYMazeX
				(param1 posn: 406 69)
			)
			(5523 ; NYMazeY
				(param1 posn: 420 63)
			)
			(5524 ; NYMazeZ
				(param1 posn: 392 79)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

(instance portPath of AutoMapProp
	(properties
		x 122
		y 259
		view 357
		testFlag 267
	)
)

(instance avianPlaza of AutoMapProp
	(properties
		x 202
		y 202
		cel 1
		view 357
		testFlag 268
	)
)

(instance avianExit of AutoMapProp
	(properties
		x 211
		y 168
		cel 2
		view 357
		testFlag 269
	)
)

(instance northSouth1 of AutoMapProp
	(properties
		x 242
		y 176
		cel 3
		view 357
		testFlag 270
	)
)

(instance eastWest5 of AutoMapProp
	(properties
		x 317
		y 102
		cel 4
		view 357
		testFlag 271
	)
)

(instance northSouth5 of AutoMapProp
	(properties
		x 401
		y 62
		cel 5
		view 357
		testFlag 272
	)
)

(instance eastWest4 of AutoMapProp
	(properties
		x 410
		y 65
		cel 6
		view 357
		testFlag 273
	)
)

(instance northSouth6 of AutoMapProp
	(properties
		x 426
		y 61
		cel 7
		view 357
		testFlag 274
	)
)

(instance humanPlaza of AutoMapProp
	(properties
		x 441
		y 73
		cel 8
		view 357
		testFlag 275
	)
)

(instance northSouth4 of AutoMapProp
	(properties
		x 397
		y 82
		cel 9
		view 357
		testFlag 282
	)
)

(instance eastWest3 of AutoMapProp
	(properties
		x 393
		y 93
		cel 10
		view 357
		testFlag 281
	)
)

(instance northSouth3 of AutoMapProp
	(properties
		x 389
		y 110
		cel 11
		view 357
		testFlag 280
	)
)

(instance eastWest1 of AutoMapProp
	(properties
		x 336
		y 156
		cel 12
		view 357
		testFlag 276
	)
)

(instance northSouth2 of AutoMapProp
	(properties
		x 309
		y 156
		cel 13
		view 357
		testFlag 277
	)
)

(instance eastWest2 of AutoMapProp
	(properties
		x 309
		y 141
		cel 14
		view 357
		testFlag 278
	)
)

(instance octoPlaza of AutoMapProp
	(properties
		x 329
		y 129
		cel 15
		view 357
		testFlag 279
	)
)

