;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	octoPlazaMap 0
)

(instance octoPlazaMap of AutoMapInset
	(properties
		picture 360
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(5301 ; NY_Octospider_Plaza_1
				(param1 posn: 393 220)
			)
			(5302 ; NY_Octospider_Plaza_2
				(param1 posn: 397 196)
			)
			(5303 ; NY_Octospider_Plaza_3
				(param1 posn: 362 193)
			)
			(5304 ; NY_Octospider_Plaza_4
				(param1 posn: 250 199)
			)
			(5305 ; NY_Octospider_Plaza_5
				(param1 posn: 292 136)
			)
			(5306 ; NY_Octospider_Plaza_6
				(param1 posn: 286 109)
			)
			(5307 ; NY_Octospider_Plaza_7
				(param1 posn: 260 110)
			)
			(5308 ; NY_Octospider_Plaza_8
				(param1 posn: 248 218)
			)
			(5309 ; NY_Octospider_Plaza_9
				(param1 posn: 208 215)
			)
			(5310 ; NY_Octospider_Plaza_10
				(param1 posn: 203 185)
			)
			(5311 ; NY_Octospider_Plaza_11
				(param1 posn: 214 163)
			)
			(5312 ; NY_Octospider_Plaza_12
				(param1 posn: 367 147)
			)
			(5313 ; NY_Octospider_Plaza_13
				(param1 posn: 388 138)
			)
			(5314 ; NY_Octospider_Plaza_14
				(param1 posn: 383 133)
			)
			(5315 ; NY_Octospider_Plaza_15
				(param1 posn: 229 164)
			)
			(5316 ; NY_Octospider_Plaza_16
				(param1 posn: 229 164)
			)
			(5317 ; NY_Octospider_Plaza_17
				(param1 posn: 229 164)
			)
			(5318 ; NY_Octospider_Plaza_18
				(param1 posn: 229 164)
			)
			(5319 ; NY_Octospider_Plaza_19
				(param1 posn: 229 164)
			)
			(5320 ; NY_Octospider_Plaza_20
				(param1 posn: 229 164)
			)
			(5321 ; NY_Octospider_Plaza_21
				(param1 posn: 229 164)
			)
			(5322 ; NY_Octospider_Plaza_22
				(param1 posn: 229 164)
			)
			(5323 ; NY_Octospider_Plaza_23
				(param1 posn: 229 164)
			)
			(5324 ; NY_Octospider_Plaza_24
				(param1 posn: 229 164)
			)
			(5325 ; NY_Octospider_Plaza_25
				(param1 posn: 248 223)
			)
			(5326 ; NY_Octospider_Plaza_26
				(param1 posn: 248 223)
			)
			(5327 ; NY_Octospider_Plaza_27
				(param1 posn: 307 103)
			)
			(5328 ; NYOctospiderPlaza28
				(param1 posn: 383 133)
			)
			(5329 ; NY_Octospider_Plaza_29
				(param1 posn: 247 229)
			)
			(5330 ; NY_Octospider_Plaza_30
				(param1 posn: 307 103)
			)
			(5331 ; NY_Octospider_Plaza_31
				(param1 posn: 247 229)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

