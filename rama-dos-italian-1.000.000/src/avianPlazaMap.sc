;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 358)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	avianPlazaMap 0
)

(instance avianPlazaMap of AutoMapInset
	(properties
		picture 358
	)

	(method (init)
		(super init: &rest)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(5001 ; NYAvian1
				(param1 posn: 196 223)
			)
			(5002 ; NYAvian2
				(param1 posn: 251 184)
			)
			(5003 ; NYAvian3
				(param1 posn: 197 175)
			)
			(5004 ; NYAvian4
				(param1 posn: 250 151)
			)
			(5005 ; NYAvian5
				(param1 posn: 230 128)
			)
			(5006 ; NYAvian6
				(param1 posn: 267 121)
			)
			(5007 ; NYAvian7
				(param1 posn: 316 177)
			)
			(5008 ; NYAvian8
				(param1 posn: 370 198)
			)
			(5009 ; NYAvian9
				(param1 posn: 331 224)
			)
			(5010 ; NYAvian10
				(param1 posn: 340 243)
			)
			(5011 ; NYAvian11
				(param1 posn: 265 173)
			)
			(5012 ; NYAvian12
				(param1 posn: 273 168)
			)
			(5013 ; NYAvian13
				(param1 posn: 273 168)
			)
			(5014 ; NYAvian14
				(param1 posn: 273 168)
			)
			(5015 ; NYAvian15
				(param1 posn: 347 242)
			)
			(5016 ; NYAvian16
				(param1 posn: 347 242)
			)
			(5017 ; NYAvian17
				(param1 posn: 377 162)
			)
			(5018 ; NYAvian18
				(param1 posn: 377 162)
			)
			(5020 ; NYAvian20
				(param1 posn: 370 198)
			)
			(5021 ; NYAvian21
				(param1 posn: 398 170)
			)
			(5022 ; NYAvian22
				(param1 posn: 399 158)
			)
			(5023 ; NYAvian23
				(param1 posn: 383 173)
			)
			(5024 ; NYAvian24
				(param1 posn: 400 173)
			)
			(5025 ; NYAvian25
				(param1 posn: 400 173)
			)
			(5026 ; NYAvian26
				(param1 posn: 400 173)
			)
			(5027 ; NYAvian27
				(param1 posn: 221 142)
			)
			(5028 ; NYAvian28
				(param1 posn: 373 173)
			)
			(5029 ; NYAvianTetra
				(param1 posn: 280 162)
			)
			(5030 ; NYAvianTetraCU
				(param1 posn: 280 162)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

