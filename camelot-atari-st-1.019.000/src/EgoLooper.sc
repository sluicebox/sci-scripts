;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 916)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class EgoLooper of Code
	(properties
		client 0
		endHeading 0
		curHeading 0
		turnDir 0
		oldCycler 0
		doingLooper 0
	)

	(method (dispose)
		(if oldCycler
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(= client 0)
		(super dispose:)
	)

	(method (doit param1 param2 &tmp temp0)
		(= client param1)
		(cond
			((& (client signal:) $0800)
				(return)
			)
			(
				(and
					doingLooper
					(gEgo cycler:)
					((gEgo cycler:) isKindOf: CT)
				)
				(= endHeading (umod param2 360))
				(if (== (client heading:) endHeading)
					(client setCycle: 0)
					(self cue:)
				)
				(return)
			)
			((!= oldCycler 0)
				(oldCycler dispose:)
				(= oldCycler 0)
			)
		)
		(= endHeading (umod param2 360))
		(= curHeading
			(switch (client loop:)
				(0 90)
				(1 270)
				(2 180)
				(else 360)
			)
		)
		(if (> (= temp0 (- endHeading curHeading)) 180)
			(-= temp0 360)
		)
		(if (< temp0 -180)
			(+= temp0 360)
		)
		(= turnDir
			(cond
				((> temp0 45) 90)
				((< temp0 -45) -90)
				(else 0)
			)
		)
		(if turnDir
			(= oldCycler (client cycler:))
			(= doingLooper 1)
			(self cue:)
		)
	)

	(method (cue)
		(if (<= (Abs (- curHeading endHeading)) 45)
			(if oldCycler
				(client setCycle: 0 cycler: oldCycler)
				(= oldCycler (= doingLooper 0))
			else
				(client setCycle: Walk)
			)
		else
			(+= curHeading turnDir)
			(= curHeading (umod curHeading 360))
			(if (and (== curHeading 0) (> endHeading 180))
				(= curHeading 360)
			)
			(DirLoop client curHeading)
			(client cel: 0 cycler: 0 setCycle: CT 1 1 self)
		)
	)
)

