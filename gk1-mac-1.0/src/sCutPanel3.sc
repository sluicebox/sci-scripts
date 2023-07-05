;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 893)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	sCutPanel3 0
)

(instance sCutPanel3 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 99 0)
				(= cycles 2)
			)
			(1
				(Palette 2 0 255 100) ; PalIntensity
				(gCurRoom drawPic: 660 0)
				(= cycles 2)
			)
			(2
				(gMessager say: 9 12 28 2 self 900) ; "NO! You WILL betray her! Witch-hunter!"
			)
			(3
				(v2 init:)
				(slip init:)
				(= cycles 2)
			)
			(4
				(slip setCycle: End self)
				(gMessager say: 9 12 28 3 self 900) ; "I...won't...let...you...kill her!"
			)
			(5 0)
			(6
				(v3 init:)
				(fall init:)
				(myEyes init: posn: 187 50 setScript: myBlink)
				(gMessager say: 9 12 28 4 self 900) ; "Gabriel! You didn't betray me!"
			)
			(7
				(gMessager say: 9 12 28 5 self 900) ; "I've got you!"
			)
			(8
				(gMessager say: 9 12 28 6 self 900) ; "It's no good. It has to end...with me."
			)
			(9
				(gMessager say: 9 12 28 7 self 900) ; "NO! Don't let go! DAMN IT, DON'T YOU LET GO!"
			)
			(10
				(myEyes setCel: 0 setLoop: 0)
				(gMessager say: 9 12 28 8 self 900) ; "Good-bye. My love."
			)
			(11
				(gMessager say: 9 12 28 9 self 900) ; "NO!!!"
				(myEyes dispose:)
				(fall view: 661 posn: 255 85 setCycle: End self)
			)
			(12 0)
			(13
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
				)
				(v2 dispose:)
				(v3 dispose:)
				(slip dispose:)
				(fall dispose:)
				(= cycles 2)
			)
			(14
				(gCurRoom drawPic: 99 0)
				(self dispose:)
				(DisposeScript 893)
			)
		)
	)
)

(instance myBlink of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(myEyes setCel: (if (Random 0 9) 1 else 0))
				(-- state)
				(= ticks 10)
			)
		)
	)
)

(instance v2 of View
	(properties
		x 64
		y 22
		view 660
	)
)

(instance v3 of View
	(properties
		x 187
		y 22
		view 660
		loop 1
	)
)

(instance fall of Prop
	(properties
		x 187
		y 22
		view 663
		loop 1
		cycleSpeed 12
	)
)

(instance myEyes of Prop
	(properties
		x 187
		y 50
		view 666
		loop 1
		cycleSpeed 12
	)
)

(instance slip of Prop
	(properties
		x 64
		y 22
		priority 23
		fixPriority 1
		view 662
		signal 16417
		cycleSpeed 12
	)
)

