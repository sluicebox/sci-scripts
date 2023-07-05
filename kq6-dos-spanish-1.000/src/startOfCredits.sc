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
	local0
	[local1 200]
	[local201 200]
	local401
	local402
	local403
	[local404 34] = [3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 99 99 17 18 19 20 21 22 23 24 0 0]
	local438
	local439
	[local440 4]
)

(instance findSize of Code
	(properties)

	(method (doit param1)
		(TextSize @local440 param1 2207 315)
		(return (- (/ (- 180 (- [local440 2] [local440 0])) 2) 10))
	)
)

(instance startOfCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Graph grGET_COLOURS) 256)
					(= local439 0)
				else
					(= local439 1)
				)
				(gGlobalSound loop: 1 number: 111 play:)
				(kq init:)
				(= cycles 2)
			)
			(1
				(if local439
					(= seconds 2)
				else
					(fadeThePic doit: 0 self)
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(if local439
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
				(Display 107 0 dsRESTOREPIXELS local401)
				(Display 107 0 dsRESTOREPIXELS local402)
				(switch [local404 local403]
					(0
						(self dispose:)
					)
					(99
						(+= local403 2)
						(= local0 1)
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(++ local438)
				(Message msgGET 94 local0 0 0 [local404 local403] @local1)
				(= temp1 (findSize doit: @local1))
				(++ local403)
				(= local401
					(Display
						@local1
						dsCOLOR
						7
						dsCOORD
						10
						temp1
						dsWIDTH
						300
						dsFONT
						3110
						dsALIGN
						alCENTER
						dsSAVEPIXELS
					)
				)
				(Message msgGET 94 local0 0 0 [local404 local403] @local201)
				(++ local403)
				(= local402
					(Display
						@local201
						dsCOLOR
						7
						dsCOORD
						10
						(+ temp1 15)
						dsWIDTH
						300
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
				(if local439
					(= seconds 2)
				else
					(fadeThePic doit: 0 self)
				)
			)
			(3
				(= seconds 4)
			)
			(4
				(if local439
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

