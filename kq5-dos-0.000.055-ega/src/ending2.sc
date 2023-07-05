;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	ending2 0
)

(instance ending2 of Rm
	(properties
		picture 217
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 751)
		(eyes init:)
		(eyelid init:)
		(mouth init: setCycle: RandCycle)
		(self setScript: cartoon)
	)

	(method (dispose)
		(DisposeScript 751)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(PrintDC 121 0 #at 10 135 #width 291 #dispose) ; "While you and Cedric were gone, I did some asking around, and found out that YOUR son, Alexander, had the dubious distinction, if you may, of turning Mordack's brother, Mannanan, into a cat some time back."
				(= seconds 20)
			)
			(1
				(cls)
				(PrintDC 121 1 #at 10 145 #width 291 #dispose) ; "Obviously, this deed angered Mordack who could do nothing about it since this particular spell could only be undone by the actual perpetrator...your son."
				(= seconds 12)
			)
			(2
				(cls)
				(PrintDC 121 2 #at 10 135 #width 291 #dispose) ; "It doesn't take a great genius to figure out that Mordack took your family and castle in revenge and to try to `persuade' Alexander to restore Mannanan back to his old self."
				(= seconds 16)
			)
			(3
				(cls)
				(PrintDC 121 3 #at 10 135 #width 291 #dispose) ; "I DID discover, as now I see, that your castle and family were miniaturized and imprisoned inside a glass bottle. I did some research and found the spell for turning everything back to normal. Now watch!"
				(= seconds 17)
			)
			(4
				(eyelid setScript: 0)
				(if (not (== (eyelid cel:) 0))
					(eyelid setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(5
				(gCurRoom newRoom: 120) ; ending
			)
		)
	)
)

(instance eyesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyes cel: 0)
				(= seconds (Random 3 7))
			)
			(1
				(eyes cel: (+ (eyes cel:) 1))
				(if (NumCels eyes)
					(= state -1)
				else
					(-- state)
				)
				(= seconds (Random 2 5))
			)
		)
	)
)

(instance bodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (client cycler:)
					(= state 2)
					(= cycles 1)
				else
					(client setCycle: End self)
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance eyes of Prop
	(properties
		y 79
		x 213
		view 932
		loop 1
		priority 5
		signal 16
	)

	(method (init)
		(super init:)
		(self setScript: eyesScript)
	)
)

(instance eyelid of Prop
	(properties
		y 79
		x 213
		view 932
		priority 6
		signal 16
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(switch (Random 1 60)
				(1
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance mouth of Prop
	(properties
		y 90
		x 212
		view 932
		loop 2
		priority 5
		signal 16
		cycleSpeed 2
	)
)

(instance hand of Prop ; UNUSED
	(properties
		y 158
		x 164
		view 932
		loop 3
		priority 11
		signal 16
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (not (self script:))
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

