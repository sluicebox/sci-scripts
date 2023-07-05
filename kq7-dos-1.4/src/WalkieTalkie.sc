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
		caller 0
		started 0
		completed 0
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
		(= started (= completed 0))
	)

	(method (start m)
		(if argc
			(= mode m)
		)
		(if (and hideClient client)
			(client hide:)
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

	(method (doit)
		(if (and started (Robot 5)) ; HasEnded
			(self robotDone: disposeWhenDone)
		)
	)

	(method (terminate)
		(Robot 7) ; Terminate
	)

	(method (doneYet)
		(Robot 5) ; HasEnded
	)

	(method (robotDone doDispose)
		(= completed 1)
		(Robot 7) ; Terminate
		(if (and hideClient client)
			(client show:)
		)
		(cond
			((and argc doDispose)
				(self dispose:)
			)
			(caller
				(caller cue: robot)
				(= caller 0)
			)
		)
	)

	(method (dispose doDone)
		(if (and started (not completed) argc doDone)
			(self robotDone:)
		)
		(= started (= completed 0))
		(if client
			(client robot: 0)
		)
		(if (== gAutoRobot self)
			(= gAutoRobot 0)
		)
		(if caller
			(caller cue: robot)
			(= caller 0)
		)
		(super dispose:)
	)
)

