;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 968)
(include sci.sh)
(use Motion)
(use System)

(public
	SmoothLooper 0
)

(class SmoothLooper of Code
	(properties
		nextLoop 0
		client 0
		oldCycler 0
		oldMover 0
		newMover 0
		oldCycleSpeed 0
		cycleSpeed 0
		inProgress 0
		vNormal 0
		vChangeDir 0
	)

	(method (doit cl theHeading &tmp theLoop changedTheLoop)
		(if (& (cl signal:) $0800)
			(return)
		)
		(= changedTheLoop 0)
		(if inProgress
			(if newMover
				(newMover dispose:)
			)
			(= newMover (cl mover:))
			(cl mover: 0)
			(return)
		else
			(if (not vNormal)
				(= vNormal (cl view:))
			)
			(= client cl)
			(= inProgress 1)
		)
		(if (and (> (client loop:) 3) (== (client view:) vNormal))
			(if inProgress
				(if (IsObject oldMover)
					(oldMover dispose:)
				)
			else
				(client view: vNormal)
				(DirLoop client theHeading)
			)
		)
		(switch (= theLoop (client loop:))
			(3
				(cond
					((or (<= theHeading 45) (> theHeading 315)))
					((<= theHeading 135)
						(= theLoop 4)
						(= nextLoop 0)
						(= changedTheLoop 1)
					)
					((<= theHeading 225)
						(= theLoop 4)
						(= nextLoop 16)
						(= changedTheLoop 1)
					)
					((<= theHeading 315)
						(= theLoop 5)
						(= changedTheLoop (= nextLoop 1))
					)
				)
			)
			(0
				(cond
					((or (<= theHeading 45) (> theHeading 315))
						(= theLoop 6)
						(= nextLoop 3)
						(= changedTheLoop 1)
					)
					((<= theHeading 135))
					((<= theHeading 225)
						(= theLoop 0)
						(= nextLoop 2)
						(= changedTheLoop 1)
					)
					((<= theHeading 315)
						(= theLoop 6)
						(= nextLoop 21)
						(= changedTheLoop 1)
					)
				)
			)
			(1
				(cond
					((or (<= theHeading 45) (> theHeading 315))
						(= theLoop 7)
						(= nextLoop 3)
						(= changedTheLoop 1)
					)
					((<= theHeading 135)
						(= theLoop 1)
						(= nextLoop 18)
						(= changedTheLoop 1)
					)
					((<= theHeading 225)
						(= theLoop 1)
						(= nextLoop 2)
						(= changedTheLoop 1)
					)
					(else
						(<= theHeading 315)
					)
				)
			)
			(2
				(cond
					((or (<= theHeading 45) (> theHeading 315))
						(= theLoop 3)
						(= nextLoop 23)
						(= changedTheLoop 1)
					)
					((<= theHeading 135)
						(= theLoop 2)
						(= nextLoop 0)
						(= changedTheLoop 1)
					)
					((<= theHeading 225))
					((<= theHeading 315)
						(= theLoop 3)
						(= changedTheLoop (= nextLoop 1))
					)
				)
			)
		)
		(if changedTheLoop
			(= oldCycler (client cycler:))
			(= oldMover (client mover:))
			(= oldCycleSpeed (client cycleSpeed:))
			(client
				view: vChangeDir
				cycleSpeed: cycleSpeed
				mover: 0
				cycler: 0
				loop: theLoop
				cel: 0
				setCycle: End self
			)
		else
			(= inProgress 0)
		)
	)

	(method (cue &tmp [temp0 2])
		(if (< nextLoop 15)
			(client
				view: vNormal
				loop: nextLoop
				mover: oldMover
				cycler: oldCycler
				cycleSpeed: oldCycleSpeed
			)
			(= inProgress (= oldCycler (= oldMover 0)))
			(if newMover
				(client setMotion: newMover)
				(= newMover 0)
			)
		else
			(-= nextLoop 16)
			(client loop: nextLoop cel: 0 setCycle: End self)
			(= nextLoop
				(switch nextLoop
					(0 2)
					(5 1)
					(2 0)
					(7 3)
				)
			)
		)
	)

	(method (dispose)
		(if oldMover
			(oldMover dispose:)
		)
		(if newMover
			(newMover dispose:)
		)
		(if oldCycler
			(oldCycler dispose:)
		)
		(= inProgress (= oldMover (= newMover (= oldCycler 0))))
		(client view: vNormal looper: 0)
		(DirLoop client (client heading:))
		(super dispose:)
	)
)

