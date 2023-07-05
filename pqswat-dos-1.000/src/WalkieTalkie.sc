;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64960)
(include sci.sh)
(use Main)
(use Array)
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
		whichFrame 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
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

	(method (doit &tmp temp0 temp1)
		(if (> started 0)
			(Robot 8 self) ; GetCue
			(if signal
				(= temp0 signal)
				(= signal 0)
				(cond
					((== -1 temp0)
						(if holdOnLastCel
							(= global423 (self setNowSeen:))
							(if gRobotDoVerb
								(gRobotDoVerb doVerb: 179)
							)
						)
						(self robotDone: disposeWhenDone)
					)
					(caller
						(caller cue: temp0)
					)
				)
			)
		)
	)

	(method (doneYet)
		(Robot 5) ; HasEnded
	)

	(method (doRobot param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp1 0)
		(= temp2 0)
		(= temp3 0)
		(= temp4 0)
		(= temp5 gEgo)
		(= temp6 -1)
		(= temp7 0)
		(= temp8 0)
		(for ((= temp9 1)) (< temp9 argc) ((++ temp9))
			(= [temp0 temp9] [param1 temp9])
		)
		(= temp0
			(if temp5
				(temp5 setRobot: self 1 param1)
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
		(if (not (or temp8 temp5))
			(= gAutoRobot temp0)
		)
		(temp0
			caller: temp4
			priority: temp6
			holdOnLastCel: temp7
			x: temp1
			y: temp2
			whichFrame: temp3
			mode: temp8
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
		(if gRobotDoVerb
			(gRobotDoVerb doVerb: 180)
		)
		(= global429 0)
		(= global420
			(= global421
				(= global422
					(= global423 (= global424 (= global425 (= global426 0))))
				)
			)
		)
	)

	(method (robotDone doDispose)
		(= completed 1)
		(= global429 0)
		(if (not holdOnLastCel)
			(Robot 7) ; Terminate
			(if gRobotDoVerb
				(gRobotDoVerb doVerb: 180)
			)
			(= global420
				(= global421
					(= global422 (= global423 (= global424 (= global426 0))))
				)
			)
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
				(= global425 (= caller 0))
			)
		)
	)

	(method (showFrame param1 param2 param3 param4 param5 param6 param7 &tmp [temp0 4])
		(if argc
			(= robot param1)
			(= whichFrame param2)
			(= x (if (> argc 2) param3 else 0))
			(= y (if (> argc 3) param4 else 0))
			(= priority (if (> argc 4) param5 else -1))
			(= plane (if (> argc 5) param6 else gThePlane))
			(= holdOnLastCel 1)
			(= client (= caller 0))
		)
		(= global420 robot)
		(= global427 plane)
		(= global425 caller)
		(= global428 client)
		(= global424 priority)
		(= global426 holdOnLastCel)
		(= global421 x)
		(= global422 y)
		(= param7 (IntArray new: 4))
		(= global423 (Max 0 whichFrame))
		(Robot 0 robot plane priority x y) ; Open
		(Robot 1 whichFrame) ; DisplayFrame
		(if gRobotDoVerb
			(self setNowSeen:)
			(gRobotDoVerb doVerb: 179)
		)
	)

	(method (start m &tmp [temp0 2])
		(if argc
			(= mode m)
		)
		(= global429 1)
		(if (and hideClient client)
			(if (client isNotHidden:)
				(client hide:)
			else
				(= hideClient 0)
			)
		)
		(self showFrame:)
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

	(method (setNowSeen param1 &tmp temp0 temp1)
		(= temp0
			(if (and argc param1)
				param1
			else
				(IntArray new: 4)
			)
		)
		(= temp1 (- (Robot 2 (temp0 data:)) 1)) ; FrameInfo
		(= nsLeft (temp0 at: 0))
		(= nsTop (temp0 at: 1))
		(= nsRight (temp0 at: 2))
		(= nsBottom (temp0 at: 3))
		(if (or (not argc) (not param1))
			(temp0 dispose:)
		)
		(return temp1)
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
			)
		)
	)

	(method (setPri param1)
		(Robot 12 param1) ; SetPriority
	)

	(method (pause param1)
		(if (!= started 0)
			(if (or (not argc) param1)
				(if (!= started -1)
					(Robot 10) ; Pause
				)
				(= started -1)
			else
				(if (!= started 1)
					(Robot 4) ; Play
				)
				(= started 1)
			)
		)
	)
)

