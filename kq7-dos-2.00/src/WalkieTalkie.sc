;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64960)
(include sci.sh)
(use Main)
(use System)

(class WalkieTalkie of Obj
	(properties
		robot 0
		x 0
		y 0
		priority -1
		plane 0
		mode 0
		client 0
		signal 0
		caller 0
		started 0
		completed 0
		holdOnLastCel 0
		disposeWhenDone 1
		hideClient 1
	)

	(method (init cl rb c)
		(if (and argc cl)
			(= client cl)
		)
		(if (> argc 1)
			(= robot rb)
			(if (> argc 2)
				(= caller c)
			)
		)
		(if (not plane)
			(= plane
				(if client
					(client plane:)
				else
					gThePlane
				)
			)
		)
		(= started (= completed (= signal 0)))
		(return self)
	)

	(method (dispose doDone)
		(if (and started (not completed) argc doDone)
			(self robotDone:)
		)
		(= started (= completed (= signal 0)))
		(if client
			(client robot: 0)
		)
		(if (== gAutoRobot self)
			(= gAutoRobot 0)
		)
		(if caller
			(caller cue: -1)
			(= caller 0)
		)
		(super dispose:)
	)

	(method (doit &tmp cueValue)
		(if started
			(Robot 8 self) ; GetCue
			(if signal
				(= cueValue signal)
				(= signal 0)
				(cond
					((== -1 cueValue)
						(self robotDone: disposeWhenDone)
					)
					(caller
						(caller cue: cueValue)
					)
				)
			)
		)
	)

	(method (doneYet)
		(Robot 5) ; HasEnded
	)

	(method (doRobot param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 0)
		(= temp2 0)
		(= temp3 0)
		(= temp4 gEgo)
		(= temp5 -1)
		(= temp6 0)
		(= temp7 0)
		(for ((= temp8 1)) (< temp8 argc) ((++ temp8))
			(= [temp0 temp8] [param1 temp8])
		)
		(= temp0
			(if temp4
				(temp4 setRobot: self 1 param1)
			else
				((if (& -info- $8000)
						(self new:)
					else
						self
					)
					init: 0 param1
				)
			)
		)
		(if (not (or temp7 temp4))
			(= gAutoRobot temp0)
		)
		(temp0
			caller: temp3
			priority: temp5
			holdOnLastCel: temp6
			x: temp1
			y: temp2
			mode: temp7
			start:
		)
	)

	(method (killRobot doICue who &tmp myObj theRobot)
		(if
			(= theRobot
				(if
					(= myObj
						(cond
							((> argc 1) who)
							(gAutoRobot 0)
							(else gEgo)
						)
					)
					(myObj robot:)
				else
					gAutoRobot
				)
			)
			(theRobot holdOnLastCel: 0)
			(if (not (and argc doICue))
				(theRobot caller: 0)
			)
			(if myObj
				(myObj setRobot: 0)
			else
				(theRobot dispose: 1)
			)
		else
			(Robot 7) ; Terminate
		)
	)

	(method (robotDone doDispose)
		(= completed 1)
		(if (not holdOnLastCel)
			(Robot 7) ; Terminate
		)
		(if (and hideClient client)
			(client show:)
		)
		(cond
			((and argc doDispose)
				(self dispose:)
			)
			(caller
				(caller cue: -1)
				(= caller 0)
			)
		)
	)

	(method (showFrame theNum theFrame theX theY pri whichPlane &tmp temp0 temp1)
		(= temp1 (if (> argc 4) pri else -1))
		(= temp0 (if (> argc 5) whichPlane else gThePlane))
		(Robot 0 theNum temp0 temp1 theX theY) ; Open
		(Robot 1 theFrame) ; DisplayFrame
	)

	(method (start m)
		(if argc
			(= mode m)
		)
		(if (and hideClient client)
			(if (client isNotHidden:)
				(client hide:)
			else
				(= hideClient 0)
			)
		)
		(Robot 0 robot plane priority x y) ; Open
		(Robot 1 0) ; DisplayFrame
		(Robot 4) ; Play
		(= started 1)
		(if mode
			(while (not (Robot 5)) ; HasEnded
				(FrameOut)
			)
			(self robotDone: disposeWhenDone)
		)
	)

	(method (terminate)
		(Robot 7) ; Terminate
	)
)

