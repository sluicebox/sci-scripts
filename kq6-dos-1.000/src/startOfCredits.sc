;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 107)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	startOfCredits 0
	openingCredits 1
	fadeThePic 2
)

(local
	[local0 200]
	[local200 200]
	local400
	local401
	local402
	[local403 24] = [3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 0 0]
	local427
	local428
	[local429 4]
)

(instance findSize of Code
	(properties)

	(method (doit param1)
		(TextSize @local429 param1 2207 315)
		(return (- (/ (- 180 (- [local429 2] [local429 0])) 2) 10))
	)
)

(instance startOfCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Graph grGET_COLOURS) 256)
					(= local428 0)
				else
					(= local428 1)
				)
				(gGlobalSound loop: 1 number: 111 play:)
				(kq init:)
				(= cycles 2)
			)
			(1
				(if local428
					(= seconds 2)
				else
					(fadeThePic doit: 0 self)
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(if local428
					(= seconds 2)
				else
					(fadeThePic doit: 1 self)
				)
			)
			(4
				(kq dispose:)
				(self setScript: openingCredits self)
			)
			(5
				(if (== (gGlobalSound prevSignal:) -1)
					(self cue:)
				else
					(gGlobalSound client: self)
				)
			)
			(6
				(= cycles 4)
			)
			(7
				(self dispose:)
				(DisposeScript 107)
			)
		)
	)
)

(instance openingCredits of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Display 107 0 dsRESTOREPIXELS local400)
				(Display 107 0 dsRESTOREPIXELS local401)
				(if (== [local403 local402] 0)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(1
				(++ local427)
				(Message msgGET 94 0 0 0 [local403 local402] @local0)
				(= temp1 (findSize doit: @local0))
				(++ local402)
				(= local400
					(Display
						@local0
						dsCOLOR
						7
						dsCOORD
						60
						temp1
						dsWIDTH
						200
						dsFONT
						3110
						dsALIGN
						alCENTER
						dsSAVEPIXELS
					)
				)
				(Message msgGET 94 0 0 0 [local403 local402] @local200)
				(++ local402)
				(= local401
					(Display
						@local200
						dsCOLOR
						7
						dsCOORD
						60
						(+ temp1 15)
						dsWIDTH
						200
						dsFONT
						2207
						dsALIGN
						alCENTER
						dsSAVEPIXELS
					)
				)
				(= cycles 1)
			)
			(2
				(if local428
					(= seconds 2)
				else
					(fadeThePic doit: 0 self)
				)
			)
			(3
				(= seconds 4)
			)
			(4
				(if local428
					(= seconds 2)
				else
					(fadeThePic doit: 1 self)
				)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance kq of Actor
	(properties
		x 156
		y 89
		view 1092
		priority 14
		signal 16
	)
)

(instance fadeThePic of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 1)
			(for ((= temp0 100)) (> temp0 0) ((-- temp0))
				(Palette palSET_INTENSITY 0 231 temp0)
				(for ((= temp1 0)) (< temp1 10) ((++ temp1))
				)
			)
		else
			(for ((= temp0 0)) (< temp0 100) ((++ temp0))
				(Palette palSET_INTENSITY 0 231 temp0)
				(for ((= temp1 0)) (< temp1 10) ((++ temp1))
				)
			)
		)
		(= temp2 param2)
		(= param2 0)
		(temp2 cue:)
	)
)

