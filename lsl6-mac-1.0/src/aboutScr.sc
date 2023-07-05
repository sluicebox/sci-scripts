;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use System)

(public
	aboutScr 0
)

(instance aboutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Message msgGET 93 8 0 2 1 global186) ; "Shape Up or Slip Out!"
				(gMessager say: 8 0 0 0 self 93) ; ""Shape Up or Slip Out!" is an Up & Coming Production, Copyright 1993 by Sierra Publishing, a division of Sierra On-Line, Inc. Any resemblance to any characters, living or dead, means you need to find a better set of friends!"
			)
			(1
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 73)
	)
)

