;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2010)
(include sci.sh)
(use Main)
(use Styler)
(use Str)
(use Flags)
(use Ego_64988)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm1 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12 = 4
	local13
	local14
	local15
	local16
	local17
	[local18 4]
	local22
	local23
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 1)) (< temp0 local12) ((++ temp0))
		((ship new:) x: (* temp0 10) init:)
	)
)

(instance killPhotons of Code
	(properties)

	(method (doit param1)
		(if (param1 isMemberOf: Photon)
			(param1 dispose:)
		)
	)
)

(class rm1 of Room
	(properties
		picture 2011
		style 9
	)

	(method (init &tmp temp0)
		(if (DoSound sndGET_AUDIO_CAPABILITY)
			(if (ResCheck 140 1033) ; WAVE
				(Load 140 1033) ; WAVE
			)
			(if (ResCheck 140 1034) ; WAVE
				(Load 140 1034) ; WAVE
			)
			(if (ResCheck 140 1035) ; WAVE
				(Load 140 1035) ; WAVE
			)
			(if (ResCheck 140 1036) ; WAVE
				(Load 140 1036) ; WAVE
			)
			(if (ResCheck 140 1037) ; WAVE
				(Load 140 1037) ; WAVE
			)
			(if (ResCheck 140 1038) ; WAVE
				(Load 140 1038) ; WAVE
			)
			(if (ResCheck 140 1039) ; WAVE
				(Load 140 1039) ; WAVE
			)
		)
		(if (not global166)
			((ScriptID 2011) init:) ; doScore
		)
		(gThePlane setRect: 0 0 319 189 1)
		((gTheIconBar plane:) priority: -1)
		(super init: &rest)
		((= local16 (List new:)) add:)
		((= local17 (List new:)) add:)
		(stroidFlags init:)
		(gTheIconBar disable:)
		(= local2 gSound1)
		(= local3 gSound2)
		(= local6 gSound3)
		(= local4 gSound5)
		(= local5 gSound6)
		(= local7 stroidsMusic)
		(= local10 ScoreKeeper)
		(scoreList init:)
		(local10 doit: 0)
		(gGlobalSound0 number: 1032 loop: -1 flags: 5 play:)
		(for ((= temp0 0)) (< temp0 (+ local13 1)) ((++ temp0))
			((Asteroid new:)
				x:
					(switch (Random 0 1)
						(0
							(Random 0 100)
						)
						(1
							(Random 240 320)
						)
					)
				y:
					(switch (Random 0 1)
						(0
							(Random 0 50)
						)
						(1
							(Random 150 200)
						)
					)
				xStep:
					(switch (Random 0 1)
						(0 1)
						(1 -1)
					)
				yStep:
					(switch (Random 0 1)
						(0 1)
						(1 -1)
					)
				setMotion: WrapMotion
				setSpeed: 6
				ignoreActors: 1
				init:
			)
		)
		(myEgo
			posn: 160 100
			xStep: 0
			yStep: 0
			heading: 0
			cycleSpeed: 1
			moveSpeed: 4
			view: 2010
			loop: 0
			cel: 0
			ignoreActors: 1
			setCycle: Fwd
			setMotion: WrapMotion
			init:
			setCycle: 0
		)
		(enemyShip1
			ignoreActors: 1
			init:
			setLoop: 1 1
			hide:
			setScript: enemy1Script
		)
		(enemyShip2
			ignoreActors: 1
			init:
			setLoop: 0 1
			hide:
			setScript: enemy2Script
		)
		(= local1 0)
		(= local11 0)
		(localproc_0)
		(User canControl: 1)
		(gTheCursor hide:)
		(gCast eachElementDo: #show)
	)

	(method (newShipSameStroids)
		(self setScript: newShipSameStroidsScript)
	)

	(method (doit &tmp [temp0 2])
		(super doit:)
		(if
			(and
				(!= script nextLevel)
				(!= script credits)
				(not (local17 size:))
				(not (stroidFlags test: 0))
				(not (stroidFlags test: 1))
				(not (myEgo script:))
			)
			(self setScript: nextLevel)
		)
	)

	(method (dispose)
		(scoreList dispose:)
		(local16 dispose:)
		(local17 dispose:)
		(gThePlane setRect: 0 0 319 153 1)
		((gTheIconBar plane:) priority: 1)
		(gTheIconBar enable:)
		(self drawPic: 0 1)
		(FrameOut)
		(super dispose:)
	)
)

(class StroidPointSound of Sound
	(properties)

	(method (check)
		(super check: &rest)
		(if (== prevSignal -1)
			(self dispose:)
		)
	)
)

(instance gSound1 of Sound
	(properties
		flags 5
		number 1035
	)

	(method (play param1)
		(= number param1)
		(super play:)
	)
)

(instance gSound2 of Sound
	(properties
		flags 5
		number 2101
	)
)

(instance gSound3 of Sound
	(properties
		flags 5
		number 1033
	)
)

(instance gSound5 of Sound
	(properties
		flags 5
		number 1039
		loop -1
	)
)

(instance gSound6 of Sound
	(properties
		flags 5
		number 1034
	)
)

(instance stroidsMusic of Sound
	(properties
		flags 5
		number 2200
		loop -1
	)
)

(class stroidsEgo of Ego
	(properties)

	(method (gotHit))
)

(instance myEgo of stroidsEgo
	(properties
		priority 10
		fixPriority 1
		view 2010
		signal 8193
	)

	(method (init)
		(super init:)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (gUser canControl:)
			(switch (event type:)
				(evKEYBOARD
					(switch (event message:)
						(KEY_SPACE
							(if (< local22 6)
								(++ local22)
								(= temp2 (Photon new:))
								(temp2
									x: (self x:)
									y: (self y:)
									heading: (self loop:)
									owner: self
									ignoreActors: 1
									setMotion: PhotonForward temp2 10
									init:
								)
								(local5 play:)
							)
							(event claimed: 1)
							(return)
						)
						(KEY_i
							(switch loop
								(0
									(= temp0 xStep)
									(= temp1 (- yStep 2))
								)
								(1
									(= temp0 (+ xStep 1))
									(= temp1 (- yStep 2))
								)
								(2
									(= temp0 (+ xStep 2))
									(= temp1 (- yStep 2))
								)
								(3
									(= temp0 (+ xStep 2))
									(= temp1 (- yStep 1))
								)
								(4
									(= temp0 (+ xStep 2))
									(= temp1 yStep)
								)
								(5
									(= temp0 (+ xStep 2))
									(= temp1 (+ yStep 1))
								)
								(6
									(= temp0 (+ xStep 2))
									(= temp1 (+ yStep 2))
								)
								(7
									(= temp0 (+ xStep 1))
									(= temp1 (+ yStep 2))
								)
								(8
									(= temp0 xStep)
									(= temp1 (+ yStep 2))
								)
								(9
									(= temp0 (- xStep 1))
									(= temp1 (+ yStep 2))
								)
								(10
									(= temp0 (- xStep 2))
									(= temp1 (+ yStep 2))
								)
								(11
									(= temp0 (- xStep 2))
									(= temp1 (+ yStep 1))
								)
								(12
									(= temp0 (- xStep 2))
									(= temp1 yStep)
								)
								(13
									(= temp0 (- xStep 2))
									(= temp1 (- yStep 1))
								)
								(14
									(= temp0 (- xStep 2))
									(= temp1 (- yStep 2))
								)
								(15
									(= temp0 (- xStep 1))
									(= temp1 (- yStep 2))
								)
							)
							(if (and (< temp0 16) (> temp0 -16))
								(= xStep temp0)
							)
							(if (and (< temp1 16) (> temp1 -16))
								(= yStep temp1)
							)
							(self view: 2011 setCel: 0 setCycle: End)
							(local4 loop: 1 play:)
							(event claimed: 1)
							(return)
						)
						(KEY_I
							(switch loop
								(0
									(= temp0 xStep)
									(= temp1 (- yStep 2))
								)
								(1
									(= temp0 (+ xStep 1))
									(= temp1 (- yStep 2))
								)
								(2
									(= temp0 (+ xStep 2))
									(= temp1 (- yStep 2))
								)
								(3
									(= temp0 (+ xStep 2))
									(= temp1 (- yStep 1))
								)
								(4
									(= temp0 (+ xStep 2))
									(= temp1 yStep)
								)
								(5
									(= temp0 (+ xStep 2))
									(= temp1 (+ yStep 1))
								)
								(6
									(= temp0 (+ xStep 2))
									(= temp1 (+ yStep 2))
								)
								(7
									(= temp0 (+ xStep 1))
									(= temp1 (+ yStep 2))
								)
								(8
									(= temp0 xStep)
									(= temp1 (+ yStep 2))
								)
								(9
									(= temp0 (- xStep 1))
									(= temp1 (+ yStep 2))
								)
								(10
									(= temp0 (- xStep 2))
									(= temp1 (+ yStep 2))
								)
								(11
									(= temp0 (- xStep 2))
									(= temp1 (+ yStep 1))
								)
								(12
									(= temp0 (- xStep 2))
									(= temp1 yStep)
								)
								(13
									(= temp0 (- xStep 2))
									(= temp1 (- yStep 1))
								)
								(14
									(= temp0 (- xStep 2))
									(= temp1 (- yStep 2))
								)
								(15
									(= temp0 (- xStep 1))
									(= temp1 (- yStep 2))
								)
							)
							(if (and (< temp0 16) (> temp0 -16))
								(= xStep temp0)
							)
							(if (and (< temp1 16) (> temp1 -16))
								(= yStep temp1)
							)
							(self view: 2011 setCel: 0 setCycle: End)
							(local4 loop: 1 play:)
							(event claimed: 1)
							(return)
						)
						(KEY_J
							(self setLoop: (if (> loop 0) (-- loop) else 15) 1)
							(= heading loop)
						)
						(KEY_j
							(self setLoop: (if (> loop 0) (-- loop) else 15) 1)
							(= heading loop)
						)
						(KEY_K
							(self setLoop: (if (< loop 15) (++ loop) else 0) 1)
							(= heading loop)
						)
						(KEY_k
							(self setLoop: (if (< loop 15) (++ loop) else 0) 1)
							(= heading loop)
						)
						(KEY_Q
							(if (not script)
								(User canControl: 0)
								(local2 play: 1035)
								(self setScript: deathScript)
							)
						)
						(KEY_q
							(if (not script)
								(User canControl: 0)
								(local2 play: 1035)
								(self setScript: deathScript)
							)
						)
						(KEY_RETURN
							(self setScript: hyperScript)
							(event claimed: 1)
							(return)
						)
					)
				)
				(else
					(super handleEvent: event)
					(return)
				)
			)
		)
		(event claimed: 1)
	)

	(method (doit &tmp temp0)
		(if script 0)
		(super doit:)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (gotHit)
		(if (not script)
			(User canControl: 0)
			(local2 play: 1035)
			(self setScript: deathScript)
		)
	)
)

(instance nextLevel of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= ticks 100)
			)
			(1
				(Styler
					plane: (gCurRoom plane:)
					back: 0
					style: 10
					doit:
					back: -1
				)
				(local4 stop:)
				(local7 fade:)
				(= cycles 2)
			)
			(2
				(++ local13)
				(gCurRoom picture: (+ (gCurRoom picture:) 1))
				(if (> (gCurRoom picture:) 2020)
					(gCurRoom picture: 2011)
				)
				(gCurRoom drawPic: (gCurRoom picture:))
				(if (> (++ local14) 2203)
					(= local14 2200)
				)
				(gCast eachElementDo: #perform killPhotons)
				(for ((= temp0 0)) (< temp0 (+ local13 1)) ((++ temp0))
					((Asteroid new:)
						x:
							(switch (Random 0 1)
								(0
									(Random 0 100)
								)
								(1
									(Random 240 320)
								)
							)
						y:
							(switch (Random 0 1)
								(0
									(Random 0 50)
								)
								(1
									(Random 150 200)
								)
							)
						xStep:
							(switch (Random 0 1)
								(0 1)
								(1 -1)
							)
						yStep:
							(switch (Random 0 1)
								(0 1)
								(1 -1)
							)
						setMotion: WrapMotion
						setSpeed: 6
						ignoreActors: 1
						init:
					)
				)
				(myEgo
					posn: 160 94
					xStep: 0
					yStep: 0
					heading: 0
					cycleSpeed: 1
					moveSpeed: 4
					view: 2010
					loop: 0
					cel: 0
					ignoreActors: 1
					setCycle: 0
				)
				(= cycles 2)
			)
			(3
				(User canControl: 1)
				(self dispose:)
			)
		)
	)
)

(instance hyperScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= local11 0)
				(= local1 0)
				(local4 stop:)
				(myEgo
					ignoreActors: 1
					setCycle: 0
					view: 2010
					setCel: 0
					xStep: 0
					yStep: 0
					hide:
				)
				(local4 number: 1038 loop: 0 play: self)
			)
			(1
				(local4 number: 1039 loop: -1)
				(myEgo x: (Random 20 300) y: (Random 20 190) show:)
				(= cycles 2)
			)
			(2
				(User canControl: 1)
				(self dispose:)
			)
		)
	)
)

(class StroidsActor of Actor
	(properties
		fixPriority 1
		signal 8193
		edgePoly 0
	)

	(method (doit &tmp temp0 temp1 [temp2 5] temp7 temp8)
		(= temp7 cel)
		(= temp8 loop)
		(if script
			(script doit:)
		)
		(if (& signal $0001)
			(if mover
				(mover doit:)
			)
			(if cycler
				(cycler doit:)
			)
		)
		(if
			(and
				(or (!= x xLast) (!= y yLast) (!= cel temp7) (!= loop temp8))
				(self isNotHidden:)
			)
			(UpdateScreenItem self)
			(= xLast x)
			(= yLast y)
			(if (= temp1 (self cantBeHere:))
				(self gotHit: temp1)
				(if (gCast contains: temp1)
					(temp1 gotHit:)
				)
			)
		)
	)

	(method (cantBeHere &tmp [temp0 15])
		(return 0)
	)

	(method (gotHit))
)

(class Photon of StroidsActor
	(properties
		view 2012
		moveSpeed 3
		owner 0
	)

	(method (cue)
		(self dispose:)
	)

	(method (motionCue &tmp temp0)
		(= temp0 self)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
		(if (and (gCast contains: temp0) cycler (cycler completed:))
			(cycler motionCue:)
		)
	)

	(method (gotHit param1)
		(if (not cycler)
			(if (== owner myEgo)
				(cond
					((param1 isMemberOf: Asteroid)
						(local10 doit: (* (param1 loop:) 10))
					)
					((== param1 enemyShip1)
						(local10 doit: 100)
					)
					((== param1 enemyShip2)
						(local10 doit: 250)
					)
				)
			)
			(self ignoreActors: 1 cel: 1 setMotion: 0 setCycle: End self)
		)
	)

	(method (cantBeHere &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(cond
			(cycler
				(return 0)
			)
			((!= owner myEgo)
				(if (and (myEgo isNotHidden:) (OnMe x y myEgo 1))
					(= temp3 myEgo)
				)
			)
			((and (enemyShip1 isNotHidden:) (OnMe x y enemyShip1 1))
				(= temp3 enemyShip1)
			)
			((and (enemyShip2 isNotHidden:) (OnMe x y enemyShip2 1))
				(= temp3 enemyShip2)
			)
			(else
				(= temp0 0)
				(= temp2 (local17 size:))
				(while (< temp0 temp2)
					(= temp1 (local17 at: temp0))
					(++ temp0)
					(if
						(and
							(< (Abs (- x (temp1 x:))) 15)
							(< (Abs (- y (temp1 y:))) 15)
							(OnMe x y temp1 1)
						)
						(= temp3 temp1)
						(break)
					)
				)
			)
		)
		(return temp3)
	)

	(method (dispose)
		(-- local22)
		(super dispose:)
	)
)

(class Asteroid of StroidsActor
	(properties
		view 2013
		loop 1
		splitState 0
		splitMove 16
		maxState 0
	)

	(method (init)
		(= priority loop)
		(super init:)
		(= maxState (- (self lastLoop:) 2))
		(local17 add: self)
		(self setCycle: Fwd)
	)

	(method (dispose)
		(local17 delete: self)
		(super dispose:)
	)

	(method (gotHit &tmp temp0)
		(local2 play: 1036)
		(if (> splitState maxState)
			(self dispose:)
		else
			(++ splitState)
			(++ loop)
			((self new:)
				xStep: (if (= temp0 (- 5 (Random 0 10))) temp0 else 1)
				yStep: (if (= temp0 (- 5 (Random 0 10))) temp0 else 1)
				mover: 0
				cycler: 0
				ignoreActors: 1
				setMotion: WrapMotion
				init:
				setSpeed: (Random 4 6)
			)
			(= xStep (if (= temp0 (- 5 (Random 0 10))) temp0 else 1))
			(= yStep (if (= temp0 (- 5 (Random 0 10))) temp0 else 1))
		)
	)

	(method (cantBeHere &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 4] temp11)
		(= temp0 0)
		(cond
			((and (myEgo isNotHidden:) (ObjectIntersect myEgo self))
				(= temp0 myEgo)
			)
			((and (enemyShip1 isNotHidden:) (ObjectIntersect enemyShip1 self))
				(= temp0 enemyShip1)
			)
			((and (enemyShip2 isNotHidden:) (ObjectIntersect enemyShip2 self))
				(= temp0 enemyShip2)
			)
		)
		(if temp0
			(SetNowSeen self)
			(SetNowSeen temp0)
			(= temp3 (Min (temp0 nsRight:) nsRight))
			(= temp4 (Min (temp0 nsBottom:) nsBottom))
			(= temp5 (Max (temp0 nsLeft:) nsLeft))
			(= temp6 (Max (temp0 nsTop:) nsTop))
			(= temp2 (>> (+ temp4 temp6) $0001))
			(= temp11 0)
			(if (not (and (temp0 cycler:) ((temp0 cycler:) isKindOf: End)))
				(for ((= temp1 temp5)) (<= temp1 temp3) ((++ temp1))
					(if
						(and
							(OnMe temp1 temp2 self 1)
							(OnMe temp1 temp2 temp0 1)
						)
						(= temp11 1)
						(break)
					)
				)
				(if (not temp11)
					(= temp1 (>> (+ temp3 temp5) $0001))
					(for ((= temp2 temp6)) (<= temp2 temp4) ((++ temp2))
						(if
							(and
								(OnMe temp1 temp2 self 1)
								(OnMe temp1 temp2 temp0 1)
							)
							(= temp11 1)
							(break)
						)
					)
				)
			)
			(if (not temp11)
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(class WrapMotion of Obj
	(properties
		client 0
		caller 0
		b-moveCnt 0
		xLast 0
		yLast 0
		completed 0
	)

	(method (init param1 param2 &tmp temp0)
		(= caller 0)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= caller param2)
			)
		)
		(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
		(if (= temp0 (client cycler:))
			(temp0 cycleCnt: b-moveCnt)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(client x: (= temp0 (+ (client x:) (client xStep:))))
			(client y: (= temp1 (+ (client y:) (client yStep:))))
			(cond
				((< temp0 -15)
					(client x: 335 y: (+ temp1 (Random 1 5)))
				)
				((> temp0 335)
					(client x: -15 y: (+ temp1 (Random 1 5)))
				)
				((< temp1 -15)
					(client y: 215 x: (+ temp0 (Random 1 5)))
				)
				((> temp1 215)
					(client y: -15 x: (+ temp0 (Random 1 5)))
				)
			)
		)
	)

	(method (moveDone)
		(= completed 1)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed caller)
			(caller cue:)
		)
		(self dispose:)
	)
)

(class PhotonForward of WrapMotion
	(properties
		xDist 0
		yDist 0
	)

	(method (init param1 param2 param3)
		(switch (param1 heading:)
			(0
				(param1 xStep: 0 yStep: -8 y: (- (param1 y:) param3))
			)
			(1
				(param1
					xStep: 2
					yStep: -6
					x: (+ (param1 x:) (/ param3 2))
					y: (- (param1 y:) param3)
				)
			)
			(2
				(param1
					xStep: 4
					yStep: -4
					x: (+ (param1 x:) param3)
					y: (- (param1 y:) param3)
				)
			)
			(3
				(param1
					xStep: 6
					yStep: -2
					x: (+ (param1 x:) param3)
					y: (- (param1 y:) (/ param3 2))
				)
			)
			(4
				(param1 xStep: 8 yStep: 0 x: (+ (param1 x:) param3))
			)
			(5
				(param1
					xStep: 6
					yStep: 2
					x: (+ (param1 x:) param3)
					y: (+ (param1 y:) (/ param3 2))
				)
			)
			(6
				(param1
					xStep: 4
					yStep: 4
					x: (+ (param1 x:) param3)
					y: (+ (param1 y:) param3)
				)
			)
			(7
				(param1
					xStep: 2
					yStep: 6
					x: (+ (param1 x:) (/ param3 2))
					y: (+ (param1 y:) param3)
				)
			)
			(8
				(param1 xStep: 0 yStep: 8 y: (+ (param1 y:) param3))
			)
			(9
				(param1
					xStep: -2
					yStep: 6
					x: (- (param1 x:) (/ param3 2))
					y: (+ (param1 y:) param3)
				)
			)
			(10
				(param1
					xStep: -4
					yStep: 4
					x: (- (param1 x:) param3)
					y: (+ (param1 y:) param3)
				)
			)
			(11
				(param1
					xStep: -6
					yStep: 2
					x: (- (param1 x:) param3)
					y: (+ (param1 y:) (/ param3 2))
				)
			)
			(12
				(param1 xStep: -8 yStep: 0 x: (- (param1 x:) param3))
			)
			(13
				(param1
					xStep: -6
					yStep: -2
					x: (- (param1 x:) param3)
					y: (- (param1 y:) (/ param3 2))
				)
			)
			(14
				(param1
					xStep: -4
					yStep: -4
					x: (- (param1 x:) param3)
					y: (- (param1 y:) param3)
				)
			)
			(15
				(param1
					xStep: -2
					yStep: -6
					x: (- (param1 x:) (/ param3 2))
					y: (- (param1 y:) param3)
				)
			)
		)
		(super init: param1 param2)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(client x: (= temp0 (+ (client x:) (= temp2 (client xStep:)))))
		(client y: (= temp1 (+ (client y:) (= temp3 (client yStep:)))))
		(if (or (< temp1 0) (< temp0 0) (> temp1 199) (> temp0 319))
			(self moveDone:)
			(return)
		)
	)
)

(class StroidsView of View
	(properties)

	(method (inRect param1 param2 param3 param4)
		(return (and (<= param1 x) (<= x param3) (<= param2 y) (<= y param4)))
	)
)

(instance ship of StroidsView
	(properties
		x 10
		y 10
		priority 100
		view 2015
	)

	(method (init)
		(self ignoreActors: 1)
		(local16 addToFront: self)
		(super init:)
	)

	(method (dispose)
		(local16 delete: self)
		(super dispose:)
	)
)

(instance enemyShip1 of StroidsActor
	(properties
		x -20
		y 100
		view 2017
		loop 1
	)

	(method (cue)
		(local3 stop:)
		(self
			setCycle: 0
			x: -20
			y: 100
			setLoop: 1 1
			cel: 0
			setScript: enemy1Script
		)
	)

	(method (cantBeHere &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp6 0)
		(if (and (myEgo isNotHidden:) (ObjectIntersect myEgo self))
			(= temp6 myEgo)
			(if (not (and (temp6 cycler:) ((temp6 cycler:) isKindOf: End)))
				(SetNowSeen self)
				(SetNowSeen temp6)
				(= temp2 (Min (temp6 nsRight:) nsRight))
				(= temp3 (Min (temp6 nsBottom:) nsBottom))
				(= temp4 (Max (temp6 nsLeft:) nsLeft))
				(= temp5 (Max (temp6 nsTop:) nsTop))
				(= temp1 (>> (+ temp3 temp5) $0001))
				(= temp7 0)
				(for ((= temp0 temp4)) (<= temp0 temp2) ((++ temp0))
					(if
						(and
							(OnMe temp0 temp1 self 1)
							(OnMe temp0 temp1 temp6 1)
						)
						(= temp7 1)
						(break)
					)
				)
				(if (not temp7)
					(= temp0 (>> (+ temp2 temp4) $0001))
					(for ((= temp1 temp5)) (<= temp1 temp3) ((++ temp1))
						(if
							(and
								(OnMe temp0 temp1 self 1)
								(OnMe temp0 temp1 temp6 1)
							)
							(= temp7 1)
							(break)
						)
					)
				)
			)
			(if (not temp7)
				(= temp6 0)
			)
		)
		(return temp6)
	)

	(method (gotHit)
		(stroidFlags clear: 0)
		(if (and cycler (cycler isKindOf: Fwd))
			(self
				ignoreActors: 1
				cel: 0
				setLoop: 3 1
				setMotion: 0
				setScript: 0
				setCycle: End self
			)
		)
		(local2 play: 1037)
	)

	(method (dispose)
		(stroidFlags clear: 0)
		(local3 stop:)
		(super dispose:)
	)
)

(instance enemyShip2 of StroidsActor
	(properties
		x 340
		y 100
		view 2017
	)

	(method (cantBeHere &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp6 0)
		(if (and (myEgo isNotHidden:) (ObjectIntersect myEgo self))
			(= temp6 myEgo)
			(if (not (and (temp6 cycler:) ((temp6 cycler:) isKindOf: End)))
				(SetNowSeen self)
				(SetNowSeen temp6)
				(= temp2 (Min (temp6 nsRight:) nsRight))
				(= temp3 (Min (temp6 nsBottom:) nsBottom))
				(= temp4 (Max (temp6 nsLeft:) nsLeft))
				(= temp5 (Max (temp6 nsTop:) nsTop))
				(= temp1 (>> (+ temp3 temp5) $0001))
				(= temp7 0)
				(for ((= temp0 temp4)) (<= temp0 temp2) ((++ temp0))
					(if
						(and
							(OnMe temp0 temp1 self 1)
							(OnMe temp0 temp1 temp6 1)
						)
						(= temp7 1)
						(break)
					)
				)
				(if (not temp7)
					(= temp0 (>> (+ temp2 temp4) $0001))
					(for ((= temp1 temp5)) (<= temp1 temp3) ((++ temp1))
						(if
							(and
								(OnMe temp0 temp1 self 1)
								(OnMe temp0 temp1 temp6 1)
							)
							(= temp7 1)
							(break)
						)
					)
				)
			)
			(if (not temp7)
				(= temp6 0)
			)
		)
		(return temp6)
	)

	(method (cue)
		(local3 stop:)
		(self
			setCycle: 0
			x: 360
			y: 100
			setLoop: 0 1
			cel: 0
			setScript: enemy2Script
		)
	)

	(method (gotHit)
		(stroidFlags clear: 1)
		(if (and cycler (cycler isKindOf: Fwd))
			(self
				ignoreActors: 1
				cel: 0
				setLoop: 2 1
				setMotion: 0
				setScript: 0
				setCycle: End self
			)
		)
		(local2 play: 1037)
	)

	(method (dispose)
		(stroidFlags clear: 1)
		(local3 stop:)
		(super dispose:)
	)
)

(instance scoreList of List
	(properties)

	(method (init)
		(super init:)
		(onesView init:)
		(tensView init:)
		(hundredsView init:)
		(oneKView init:)
		(tenKView init:)
		(hundredKView init:)
		(self
			addToFront: onesView
			addToFront: tensView
			addToFront: hundredsView
			addToFront: oneKView
			addToFront: tenKView
			addToFront: hundredKView
		)
	)
)

(class ScoreKeeper of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= temp2 (Str newWith: 20 {}))
		(= temp1 local9)
		(+= local9 param1)
		(if (and (< local12 20) (> (/ local9 1000) (/ temp1 1000)))
			((StroidPointSound new:) flags: 1 number: 2103 play:)
			(++ local12)
			((ship new:) x: (* 10 (- local12 1)) init:)
		)
		(temp2 format: {%6d} local9)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			((scoreList at: temp0)
				cel:
					(if (== (temp2 at: temp0) 32)
						10
					else
						(- (temp2 at: temp0) 48)
					)
			)
		)
	)
)

(instance onesView of StroidsView
	(properties
		x 310
		y 10
		priority 100
		fixPriority 1
		view 2016
		signal 16384
	)
)

(instance tensView of StroidsView
	(properties
		x 300
		y 10
		priority 100
		fixPriority 1
		view 2016
		signal 16384
	)
)

(instance hundredsView of StroidsView
	(properties
		x 290
		y 10
		priority 100
		fixPriority 1
		view 2016
		signal 16384
	)
)

(instance oneKView of StroidsView
	(properties
		x 280
		y 10
		priority 100
		fixPriority 1
		view 2016
		signal 16384
	)
)

(instance tenKView of StroidsView
	(properties
		x 270
		y 10
		priority 100
		fixPriority 1
		view 2016
		signal 16384
	)
)

(instance hundredKView of StroidsView
	(properties
		x 260
		y 10
		priority 100
		fixPriority 1
		view 2016
		signal 16384
	)
)

(instance enemy1Script of Script
	(properties)

	(method (init param1)
		(= seconds (= cycles (= ticks 0)))
		(super init: param1)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 20 40))
			)
			(1
				(if (stroidFlags test: 1)
					(-- state)
					(= seconds 3)
				else
					(stroidFlags set: 0)
					(self cue:)
				)
			)
			(2
				(local3 number: 2101 play:)
				(enemyShip1
					show:
					setCycle: Fwd
					setMotion: MoveTo (Random 45 80) (Random 50 150)
				)
				(= local0 6)
				(= cycles 20)
			)
			(3
				(if (< local22 6)
					(++ local22)
					(= temp0 (Photon new:))
					(temp0
						x: (enemyShip1 x:)
						y: (enemyShip1 y:)
						owner: enemyShip1
						heading: (- (Random 1 16) 1)
						setMotion: PhotonForward temp0 15
						ignoreActors: 1
						init:
					)
					(local6 play:)
				)
				(cond
					((not (-- local0))
						(self cue:)
					)
					((== local0 2)
						(enemyShip1 setMotion: MoveTo -25 (Random 75 125) self)
					)
				)
				(-- state)
				(= seconds 1)
			)
			(4
				(if (not (enemyShip1 mover:))
					(= seconds 0)
					(self cue:)
				)
			)
			(5
				(local3 stop:)
				(enemyShip1 ignoreActors: 1 setCycle: 0 setMotion: 0 hide:)
				(stroidFlags clear: 0)
				(= cycles 1)
			)
			(6
				(if (not (enemyShip2 script:))
					(enemyShip2 setScript: enemy2Script)
				)
				(enemyShip1 setScript: enemy1Script)
			)
		)
	)
)

(instance enemy2Script of Script
	(properties)

	(method (init param1)
		(= seconds (= cycles (= ticks 0)))
		(super init: param1)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 40 60))
			)
			(1
				(if (stroidFlags test: 0)
					(-- state)
					(= seconds 3)
				else
					(stroidFlags set: 1)
					(self cue:)
				)
			)
			(2
				(local3 number: 2102 play:)
				(enemyShip2
					show:
					setCycle: Fwd
					setMotion: MoveTo (Random 250 290) (Random 50 150)
				)
				(= local0 8)
				(= cycles 20)
			)
			(3
				(if (< local22 6)
					(++ local22)
					(= temp0 (Photon new:))
					(temp0
						x: (enemyShip2 x:)
						y: (enemyShip2 y:)
						owner: enemyShip2
						heading: (- (Random 1 16) 1)
						setMotion: PhotonForward temp0 10
						ignoreActors: 1
						init:
					)
					(local6 play:)
				)
				(cond
					((== (-- local0) 0)
						(self cue:)
					)
					((== local0 1)
						(enemyShip2 setMotion: MoveTo 335 (Random 75 125) self)
					)
				)
				(-- state)
				(= ticks 30)
			)
			(4
				(if (not (enemyShip2 mover:))
					(= seconds 0)
					(self cue:)
				)
			)
			(5
				(local3 stop:)
				(enemyShip2 ignoreActors: 1 setCycle: 0 setMotion: 0 hide:)
				(stroidFlags clear: 1)
				(= cycles 1)
			)
			(6
				(if (not (enemyShip1 script:))
					(enemyShip1 setScript: enemy1Script)
				)
				(enemyShip2 setScript: enemy2Script)
			)
		)
	)
)

(instance newShipSameStroidsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myEgo x: 0)
				(self cue:)
			)
			(1
				(if (gCast firstTrue: #inRect 120 54 200 134)
					(-- state)
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(2
				(myEgo
					posn: 160 94
					xStep: 0
					yStep: 0
					heading: 0
					cycleSpeed: 1
					moveSpeed: 4
					view: 2010
					loop: 0
					cel: 0
					setMotion: WrapMotion
					show:
				)
				(= local1 0)
				(= local11 0)
				(User canControl: 1)
				(self dispose:)
			)
		)
	)
)

(instance deathScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local4 stop:)
				(myEgo
					ignoreActors: 1
					view: 2014
					cycleSpeed: 10
					setMotion: 0
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(myEgo hide:)
				(= seconds 5)
			)
			(2
				(if (-- local12)
					((local16 at: 0) dispose:)
					(gCurRoom newShipSameStroids:)
					(self dispose:)
				else
					(gCurRoom setScript: credits)
				)
			)
		)
	)
)

(instance credits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Styler
					plane: (gCurRoom plane:)
					back: 0
					style: 10
					doit:
					back: -1
				)
				(= cycles 2)
			)
			(1
				((ScriptID 2011) doit: local9) ; doScore
				(self cue:)
			)
			(2
				(= gNewRoomNum 910)
			)
		)
	)
)

(instance startMusicScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(local7 number: local14 play:)
				(self dispose:)
			)
		)
	)
)

(instance stroidFlags of Flags
	(properties
		size 25
	)
)

