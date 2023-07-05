;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 919)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(procedure (getNext cLoop cDir &tmp newLoop)
	(cond
		((> (= newLoop (+ cLoop cDir)) 7)
			(= newLoop 0)
		)
		((< newLoop 0)
			(= newLoop 7)
		)
	)
	(return newLoop)
)

(procedure (transform l)
	(return
		(switch l
			(1 4)
			(3 6)
			(else l)
		)
	)
)

(class TurnLooper of Code
	(properties
		client 0
		inited 0
		turningDir 0
		oldCycler 0
		viewNormal 0
		viewChange 0
		finalLoop 0
		currentLoop 0
		TLHandsOff 0
		TLUserInput 0
		TLUserControl 0
	)

	(method (dispose)
		(if client
			(client view: viewNormal moveSpeed: 0 setCycle: 0)
		)
		(if oldCycler
			(oldCycler dispose:)
		)
		(super dispose:)
	)

	(method (doit obj finalHeading &tmp loopDiff)
		(if (not inited)
			(= inited 1)
			(= client obj)
			(= viewNormal (client view:))
		)
		(if (== turningDir 0)
			(= currentLoop (transform (client loop:)))
			(DirLoop client finalHeading)
			(= finalLoop (transform (client loop:)))
			(if (!= currentLoop finalLoop)
				(= turningDir
					(if
						(or
							(== (= loopDiff (- finalLoop currentLoop)) 2)
							(== loopDiff -6)
						)
						1
					else
						-1
					)
				)
				(= oldCycler (client cycler:))
				(client view: viewChange cycler: 0 moveSpeed: 200 cel: 0)
				(if (== client gEgo)
					(= TLHandsOff global80)
					(= TLUserControl (User controls:))
					(= TLUserInput (User canInput:))
					(= global80 1)
					(User canInput: 0 controls: 0)
				)
				(self cue:)
			)
		)
	)

	(method (cue &tmp realLoop)
		(if (== currentLoop finalLoop)
			(client
				view: viewNormal
				cycler: oldCycler
				moveSpeed: 0
				loop:
					(switch finalLoop
						(0 0)
						(2 2)
						(4 1)
						(6 3)
					)
			)
			(= turningDir (= oldCycler 0))
			(if (== client gEgo)
				(User controls: TLUserControl)
				(User canInput: TLUserInput)
				(= global80 TLHandsOff)
			)
		else
			(= currentLoop (getNext currentLoop turningDir))
			(if (mod currentLoop 2)
				(= realLoop (/ currentLoop 2))
				(client loop: realLoop)
				(if
					(or
						(and (== turningDir 1) (== (mod realLoop 2) 0))
						(and (== turningDir -1) (mod realLoop 2))
					)
					(client setCel: 0 setCycle: End self)
				else
					(client setCel: 255 setCycle: Beg self)
				)
			else
				(self cue:)
			)
		)
	)
)

