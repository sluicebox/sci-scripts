;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Array)
(use System)

(class RobotPlayer of Obj
	(properties
		caller 0
		plane 0
		priority -1
		x 0
		y 0
		nsBottom -1
		nsLeft -1
		nsRight -1
		nsTop -1
		number 0
		cycler 0
		paused 0
		curFrame 0
		frameRate 0
		playDir 0
		startFrame 0
		maxFrame 0
		timeHolder 0
		updateTime 0
		end 0
		updCntr 0
		tickCntr 0
		loopMe 0
		targetFrame -1
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0)
		(if (> argc 3)
			(self priority: param5)
		else
			(= param5 -1)
		)
		(= number param1)
		(= x param3)
		(= y param4)
		(= curFrame param2)
		(Robot 0 param1 gThePlane param5 param3 param4) ; Open
		(Robot 1 param2) ; DisplayFrame
		(= temp0 (IntArray new: 14))
		(= end (= maxFrame (- (Robot 2 (temp0 data:)) 1))) ; FrameInfo
		(temp0 dispose:)
		(= global208 self)
	)

	(method (pause param1)
		(if param1
			cycler
			(self paused: 1)
		else
			cycler
			(self paused: 0)
		)
	)

	(method (start param1 param2 param3)
		(= cycler 1)
		(= playDir param1)
		(= frameRate param2)
		(= timeHolder (= updateTime 0))
		(= end maxFrame)
		(if (> argc 2)
			(= loopMe param3)
		else
			(= loopMe 0)
		)
		(gTheDoits add: self)
	)

	(method (stop &tmp temp0)
		(gTheDoits delete: self)
		(= cycler
			(= loopMe
				(= startFrame
					(= tickCntr (= updCntr (= updateTime (= timeHolder 0))))
				)
			)
		)
		(= end (= targetFrame -1))
		(if caller
			(= temp0 caller)
			(= caller 0)
			(temp0 cue:)
		)
	)

	(method (playRange param1 param2 param3 param4 param5)
		(= startFrame (= curFrame param1))
		(if (>= param2 end)
			(= end param2)
		)
		(= cycler 1)
		(= playDir param3)
		(= frameRate param4)
		(if (> argc 4)
			(= loopMe param5)
		else
			(= loopMe 0)
		)
		(gTheDoits add: self)
	)

	(method (cycleTo param1 param2 param3)
		(= end maxFrame)
		(= targetFrame param1)
		(= cycler 1)
		(= playDir param2)
		(= frameRate param3)
		(gTheDoits add: self)
	)

	(method (doit)
		(if (not timeHolder)
			(= timeHolder gGameTime)
		)
		(if (not updateTime)
			(= updateTime (/ 60 frameRate))
		)
		(if (self paused:)
			(return 1)
		)
		(return
			(if (>= (Abs (- gGameTime timeHolder)) updateTime)
				(cond
					((== playDir 1)
						(cond
							((< curFrame end)
								(++ curFrame)
								(Robot 1 curFrame x y) ; DisplayFrame
								(if (== curFrame targetFrame)
									(FrameOut)
									(return (self stop:))
								)
							)
							(loopMe
								(cond
									((!= targetFrame -1)
										(cond
											((== curFrame targetFrame)
												(return (self stop:))
											)
											((>= curFrame end)
												(= curFrame startFrame)
												(if (== curFrame targetFrame)
													(Robot 1 curFrame x y) ; DisplayFrame
													(FrameOut)
													(return (self stop:))
												)
											)
										)
									)
									((>= curFrame end)
										(= curFrame startFrame)
										(if (== curFrame targetFrame)
											(Robot 1 curFrame x y) ; DisplayFrame
											(FrameOut)
											(return (self stop:))
										)
									)
								)
								(Robot 1 curFrame x y) ; DisplayFrame
							)
							(else
								(self stop:)
							)
						)
					)
					((> curFrame 0)
						(-- curFrame)
						(Robot 1 curFrame x y) ; DisplayFrame
						(if (== curFrame targetFrame)
							(FrameOut)
							(return (self stop:))
						)
					)
					(loopMe
						(cond
							((!= targetFrame -1)
								(cond
									((== curFrame targetFrame)
										(return (self stop:))
									)
									((<= curFrame startFrame)
										(= curFrame end)
										(if (== curFrame targetFrame)
											(Robot 1 curFrame x y) ; DisplayFrame
											(FrameOut)
											(return (self stop:))
										)
									)
								)
							)
							((<= curFrame startFrame)
								(= curFrame end)
								(if (== curFrame targetFrame)
									(Robot 1 curFrame x y) ; DisplayFrame
									(FrameOut)
									(return (self stop:))
								)
							)
						)
						(Robot 1 curFrame x y) ; DisplayFrame
					)
					(else
						(self stop:)
					)
				)
				(= timeHolder 0)
				(FrameOut)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(self setNowSeen:)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evVERB) (self onMe: event))
				(self doVerb: (event message:))
				(= temp0 (event claimed: 1))
			)
		)
		(return temp0)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(if
				(or
					(not (or nsLeft nsRight nsTop nsBottom))
					(and (<= nsLeft temp0 nsRight) (<= nsTop temp1 nsBottom))
				)
				1
			else
				0
			)
		)
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(gDoVerbCode doit: theVerb self)
	)

	(method (setNowSeen &tmp temp0)
		(= temp0 (IntArray new: 4))
		(Robot 2 (temp0 data:)) ; FrameInfo
		(= nsLeft (temp0 at: 0))
		(= nsTop (temp0 at: 1))
		(= nsRight (temp0 at: 2))
		(= nsBottom (temp0 at: 3))
		(temp0 dispose:)
	)

	(method (dispose)
		(self stop:)
		(= global208 0)
		(Robot 7) ; Terminate
		(DisposeClone self)
	)
)

