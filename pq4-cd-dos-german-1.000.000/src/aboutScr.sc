;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use TransPlane)
(use n045)
(use Str)
(use Print)
(use System)

(public
	aboutScr 0
)

(local
	local0
	local1
	local2
)

(instance aboutScr of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 ((gUser curEvent:) new:))
		(cond
			((temp0 claimed:))
			((or (< register 0) (!= state 2)))
			((and (== (temp0 type:) 4) (== (temp0 message:) 27))
				(= register -2)
			)
			((& (temp0 modifiers:) $000b)
				(= register -2)
			)
			((and (== state 2) (not (Print dialog:)) ticks (temp0 type:))
				(= register -2)
			)
		)
		(temp0 dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not (gCurRoom picture:)) (== gCurRoomNum 3)) ; titleScreen
					(PalCycle 4) ; Off
					(PalVary 3) ; PalVaryKill
				)
				(proc45_1)
				(= register -1)
				(= cycles 2)
			)
			(1
				(if (== register -1)
					(gGame handsOff:)
				)
				(= local0 (Str newWith: 100 {}))
				(++ register)
				(cond
					((not register)
						(Message msgGET 8 2 0 1 1 (local0 data:)) ; "Police Quest Open Season  August 12, 1994 version %s"
					)
					((<= register 28)
						(Message msgGET 8 2 0 0 register (local0 data:))
					)
				)
				(= local1 (local0 size:))
				(Print
					x: -1
					y: -1
					font: 4
					fore: 28
					back: 0
					mode: 1
					modeless: 1
					shadowText: 1
					plane: TransPlane
				)
				(if (not register)
					(Print margin: 10 addTextF: (local0 data:) gVersion)
				else
					(Print
						margin: 5
						addIcon: 6969 0 0 10 10
						addText: (local0 data:) 20 0
					)
				)
				(= cycles 2)
			)
			(2
				(if (Print dialog:)
					((Print dialog:) setSize:)
				)
				(Print init: self)
				(local0 dispose:)
			)
			(3
				(if (and (>= register 0) (<= register 27))
					(-= state 3)
				)
				(= ticks 20)
			)
			(4
				(proc45_2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

