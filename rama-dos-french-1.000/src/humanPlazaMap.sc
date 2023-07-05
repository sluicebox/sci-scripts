;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 362)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	humanPlazaMap 0
)

(instance humanPlazaMap of AutoMapInset
	(properties
		picture 362
	)

	(method (init)
		(super init: &rest)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(5202 ; humanPlazaRm2
				(param1 posn: 266 246)
			)
			(5203 ; humanPlazaRm3
				(param1 posn: 295 160)
			)
			(5204 ; humanPlazaRm4
				(param1 posn: 222 132)
			)
			(5205 ; humanPlazaRm5
				(param1 posn: 367 163)
			)
			(5206 ; humanPlazaRm6
				(param1 posn: 340 227)
			)
			(5207 ; humanPlazaRm7
				(param1 posn: 216 149)
			)
			(5208 ; humanPlazaRm8
				(param1 posn: 208 155)
			)
			(5209 ; humanPlazaRm9
				(param1 posn: 199 162)
			)
			(5210 ; NY_Human_Plaza_10
				(param1 posn: 377 182)
			)
			(5211 ; NY_Human_Plaza_11
				(param1 posn: 367 149)
			)
			(5212 ; humanPlazaRm12
				(param1 posn: 365 246)
			)
			(5213 ; NY_Human_Plaza_13
				(param1 posn: 373 241)
			)
			(5214 ; NY_Human_Plaza_14
				(param1 posn: 373 241)
			)
			(5215 ; NY_Human_Plaza_15
				(param1 posn: 199 162)
			)
			(5401 ; NY_Subway_1
				(param1 posn: 363 134)
			)
			(5402 ; NY_Subway_2
				(param1 posn: 360 127)
			)
			(5403 ; NY_Subway_3
				(param1 posn: 359 124)
			)
			(5404 ; NY_Subway_4
				(switch ((ScriptID 201 0) whichSubPuz:) ; newYorkRegion
					(1
						(param1 posn: 264 108)
					)
					(2
						(param1 posn: 368 47)
					)
					(3
						(param1 posn: 427 92)
					)
				)
			)
			(5405 ; NY_Subway_5
				(param1 posn: 272 104)
			)
			(5406 ; NY_Subway_6
				(param1 posn: 277 101)
			)
			(5408 ; NY_Subway_8
				(param1 posn: 365 51)
			)
			(5409 ; NY_Subway_9
				(param1 posn: 363 55)
			)
			(5411 ; NY_Subway_11
				(param1 posn: 417 92)
			)
			(5412 ; NY_Subway_12
				(param1 posn: 411 92)
			)
			(5413 ; NY_Subway_13
				(param1 posn: 282 58)
			)
			(5414 ; NY_Subway_14
				(param1 posn: 282 58)
			)
			(5415 ; NY_Subway_15
				(param1 posn: 187 167)
			)
			(5416 ; NY_Subway_16
				(param1 posn: 282 58)
			)
			(5417 ; NY_Subway_17
				(param1 posn: 289 62)
			)
			(5418 ; NY_Subway_18
				(param1 posn: 187 167)
			)
			(5419 ; puzzleIconCU
				(switch ((ScriptID 201 0) whichSubPuz:) ; newYorkRegion
					(1
						(param1 posn: 264 108)
					)
					(2
						(param1 posn: 368 47)
					)
					(3
						(param1 posn: 427 92)
					)
				)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

