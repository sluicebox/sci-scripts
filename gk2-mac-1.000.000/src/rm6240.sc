;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6240)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm6240 0
)

(instance rm6240 of ExitRoom
	(properties
		modNum 600
		picture 6240
		south 620 ; woods5Rm
	)

	(method (init)
		(super init: &rest)
		(fOrangeMud init:)
		(fPawPrint init: createPoly: 203 87 256 63 297 83 291 141 235 156)
		(gGame handsOn:)
	)
)

(instance fOrangeMud of GKFeature
	(properties
		modNum 600
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				404
				15
				520
				22
				612
				156
				496
				165
				480
				245
				419
				265
				399
				319
				356
				304
				363
				331
				286
				333
				297
				291
				262
				220
				264
				193
				237
				157
				292
				141
				297
				82
				255
				63
				202
				86
				229
				150
				263
				191
				200
				207
				183
				250
				79
				244
				98
				204
				98
				167
				121
				158
				94
				129
				125
				129
				151
				101
				127
				69
				83
				61
				119
				33
				89
				0
				395
				0
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 3 62 0 1 0 600) ; "(HUNT LODGE WOODS, LOOK AT PRINT)There're traces of an orangish mud in the print."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fPawPrint of GKFeature
	(properties
		modNum 600
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 658)
					(gMessager say: 18 62 0 1 0 600) ; "(PICKUP, LOOK AT EITHER PRINT IN WOODS AFTER SEEING VON ZELL, SICKENED)I guess I know who made this print!"
				)
				((IsFlag 661)
					(gMessager say: 5 62 0 1 0 600) ; "(LOOK AT FIRST PAW PRINT IN WOODS SECOND TIME)It sure looks like the one at the farm to me."
				)
				(else
					(SetFlag 661)
					(if (IsFlag 662)
						(gMessager say: 4 62 0 1 0 600) ; "(LOOK AT SECOND PRINT IN WOODS)Another autograph by the same big son-of-a-bitch."
					else
						(PlayScene 680)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

