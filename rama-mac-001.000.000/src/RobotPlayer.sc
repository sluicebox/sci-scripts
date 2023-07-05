;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4050)
(include sci.sh)
(use Main)
(use n1111)
(use WalkieTalkie)
(use Sound)
(use Actor)
(use System)

(class RobotPlayer of Obj
	(properties
		startRobot 0
		robot 0
		endRobot 0
		curRobot 0
		robotX 0
		robotY 0
		startSnd 0
		loopSnd 0
		endSnd 0
		currentFrame 0
		maxFrame 0
		client 0
		looping 0
		showLastFrame 0
		state 0
	)

	(method (init param1 param2 &tmp temp0)
		(if argc
			(= looping param1)
			(if (>= argc 2)
				(= showLastFrame param2)
			else
				(= showLastFrame 0)
			)
		else
			(= looping 0)
		)
		(if startRobot
			(= state 1)
			(= temp0 startSnd)
			(= curRobot startRobot)
		else
			(= state 2)
			(= temp0 loopSnd)
			(= curRobot robot)
		)
		(robotSound init: number: temp0 setLoop: 1)
		(= currentFrame 0)
	)

	(method (setUpLoop)
		(proc1111_6)
		(= state 2)
		(= curRobot robot)
		(= looping 1)
		(robotSound init: number: loopSnd setLoop: 1)
	)

	(method (isPlaying)
		(return (> state 0))
	)

	(method (cue)
		(= currentFrame 0)
		(switch state
			(1
				(= state 2)
				(robotSound stop: number: loopSnd setLoop: 1)
				(= curRobot robot)
				(self play:)
			)
			(2
				(if (not looping)
					(if (robotSound number:)
						(robotSound stop: number: endSnd setLoop: 1)
					)
					(= state 3)
					(if endRobot
						(= curRobot endRobot)
						(self play:)
					else
						(self cue:)
					)
				else
					(self play:)
				)
			)
			(3
				(robotSound dispose:)
				(= state 0)
				(if showLastFrame
					(= currentFrame (Robot 11)) ; FrameNum
					(self showFrame:)
				else
					(proc1111_6)
					(= currentFrame (= curRobot 0))
				)
				(if client
					(client cue:)
				)
			)
		)
	)

	(method (showFrame)
		(cond
			((>= currentFrame maxFrame)
				(= currentFrame maxFrame)
			)
			((<= currentFrame 0)
				(= currentFrame 0)
			)
		)
		(if robot
			(proc1111_6)
			(WalkieTalkie
				showFrame: curRobot currentFrame robotX robotY -1 global116
			)
			(= global107 curRobot)
		)
	)

	(method (play param1)
		(if argc
			(= client param1)
		)
		(if (and (robotSound number:) (!= (robotSound loop:) -1))
			(robotSound setLoop: -1 play:)
		)
		(WalkieTalkie plane: global116)
		(proc1111_7 curRobot robotX robotY currentFrame 0 -1 1 self)
	)

	(method (stop param1 param2)
		(if (and argc param1)
			(= client param1)
		)
		(= looping 0)
		(if (and (>= argc 2) param2)
			(self cue:)
		)
	)
)

(class SpinningGlobe of Obj
	(properties
		robot 0
		maxFrame 0
		robotX 0
		robotY 0
		currentFrame 0
		spinning 0
		looping 0
		client 0
		plane 0
	)

	(method (notDone)
		(return (or spinning (< 0 currentFrame maxFrame)))
	)

	(method (cue param1)
		(if looping
			(if (== param1 -1)
				(= currentFrame maxFrame)
				(self spin: 1)
			)
		else
			(= currentFrame maxFrame)
			(proc1111_6)
			((global116 theFtrs:) delete: self)
			(if client
				(client cue:)
			)
			(= spinning 0)
		)
	)

	(method (spin param1)
		(if (and argc param1)
			((global116 theFtrs:) addToFront: self)
			(= looping 1)
		else
			(= looping 0)
		)
		(= spinning 1)
		(if (>= currentFrame maxFrame)
			(= currentFrame 0)
		)
		(WalkieTalkie plane: global116)
		(proc1111_7 robot robotX robotY currentFrame 0 -1 1 self)
	)

	(method (stop param1 param2)
		(if (and argc param1)
			(= looping 0)
			(if (and (not spinning) (self notDone:))
				(self spin: 0)
			)
			(if (>= argc 2)
				(= client param2)
			)
		else
			(= currentFrame (Robot 11)) ; FrameNum
			(= spinning 0)
			(cond
				((>= currentFrame maxFrame)
					(= currentFrame maxFrame)
				)
				((<= currentFrame 0)
					(= currentFrame 0)
				)
			)
			(self showFrame:)
		)
	)

	(method (showFrame)
		(if robot
			(proc1111_6)
			(WalkieTalkie
				showFrame: robot currentFrame robotX robotY -1 global116
			)
			(= global107 robot)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(class ExhibitButton of View
	(properties
		downCel 1
		upCel 0
		downLoop 0
		active 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117 &rest)
		(self setHotspot: 1)
	)

	(method (depress)
		(self cel: downCel)
		(buttonSound play:)
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (up)
		(self cel: upCel)
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(event localize: global116)
		(cond
			((and (== cel downCel) (not (self onMe: event)))
				(self up:)
				(event globalize:)
				(return)
			)
			((and (not (event type:)) (self onMe: event))
				(self doVerb: 1)
				(event claimed: 1)
				(return)
			)
			((and (& (event type:) evMOUSEBUTTON) (self onMe: event))
				(self doVerb: 2)
				(self depress:)
				(event claimed: 1)
				(return)
			)
			((and (& (event type:) evMOUSERELEASE) (== cel downCel))
				(self up:)
				(event claimed: 1)
				(return)
			)
			(else
				(event globalize:)
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(if (buttonSound handle:)
			(buttonSound stop:)
		)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonSound of Sound
	(properties
		flags 5
		number 4003
	)
)

(instance robotSound of Sound
	(properties
		flags 5
	)
)

