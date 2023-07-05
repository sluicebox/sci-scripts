;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27090)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm27v090 0
)

(local
	local0
	local1
	[local2 2]
	local4
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(if (or ((local4 at: temp0) cel:) (!= ((local4 at: temp0) pos:) temp0))
			(return 0)
		)
	)
	(return 1)
)

(instance rm27v090 of ShiversRoom
	(properties
		picture 27090
	)

	(method (init &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6 temp7)
		(= local4 (IntArray newWith: 12))
		(= local1 -1)
		(= local0 -1)
		(spButton init:)
		(= temp2 (+ 5 (* (Random 0 1) 2)))
		(= temp1 (Random 0 11))
		(= temp6 0)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(= temp3 (mod (+ temp1 (* temp0 temp2)) 12))
			(= temp7 (Random 0 2))
			(+= temp6 temp7)
			(local4
				at:
					temp0
					((saTile new:)
						loop: temp0
						setPos: temp3
						cel: temp7
						init:
						yourself:
					)
			)
		)
		(while (mod temp6 4)
			(= temp7 (Random 0 11))
			((local4 at: temp7) cel: (mod (+ ((local4 at: temp7) cel:) 1) 4))
			(++ temp6)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 237
		nsBottom 114
		nextRoom 27092
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27091
	)
)

(instance spButton of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 27093
		loop 13
	)

	(method (doVerb)
		(if (and (>= local1 0) (>= local0 0))
			(gCurRoom setScript: sSpin)
		)
	)
)

(class saTile of Actor
	(properties
		priority 10
		fixPriority 1
		view 27093
		signal 18433
		pos 0
	)

	(method (init)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (setPos param1 &tmp temp0 temp1)
		(= temp0 (/ (= pos param1) 4))
		(= temp1 (mod param1 4))
		(= x (+ 25 (* temp1 50)))
		(= y (+ 9 (* temp0 41)))
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(!= global184 1)
				(not (self mover:))
				(not (self cycler:))
			)
			(event claimed: 1)
			(self doVerb:)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb &tmp temp0 temp1)
		(if (>= local0 0)
			(= temp0 ((local4 at: local1) x:))
			(= temp1 ((local4 at: local1) y:))
			((local4 at: local1)
				setMotion: MoveTo (- temp0 2) (+ temp1 2)
				setPri: 10 1
			)
			(spButton loop: 13)
			(= temp0 ((local4 at: local0) x:))
			(= temp1 ((local4 at: local0) y:))
			((local4 at: local0)
				setMotion: MoveTo (- temp0 2) (+ temp1 2)
				setPri: 10 1
			)
			(= local1 -1)
			(= local0 -1)
			(gSounds play: 12712 0 82 0)
			(if (localproc_0)
				(gCurRoom setScript: sIsDone)
			)
		else
			(= local0 local1)
			(cond
				((== (= local1 loop) local0)
					(= local1 -1)
					(= local0 -1)
					(gSounds play: 12712 0 82 0)
					(self setMotion: MoveTo (- x 2) (+ y 2) setPri: 10 1)
				)
				((!= local0 -1)
					(gCurRoom setScript: sSwap)
				)
				(else
					(gSounds play: 12709 0 82 0)
					(self setMotion: MoveTo (+ x 2) (- y 2) setPri: 125 1)
				)
			)
		)
	)
)

(instance sSwap of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spButton loop: 12)
				(= temp0 ((local4 at: local1) x:))
				(= temp1 ((local4 at: local1) y:))
				(gSounds stop: 12709)
				((local4 at: local1)
					setMotion: MoveTo (+ temp0 2) (- temp1 2) self
					setPri: 125 1
				)
				(gSounds play: 12709 0 82 0)
			)
			(1
				(= temp2 ((local4 at: local0) pos:))
				(= temp4 (/ ((local4 at: local1) pos:) 4))
				(= temp5 (mod ((local4 at: local1) pos:) 4))
				(= temp0 (+ 25 (* temp5 50)))
				(= temp1 (+ 9 (* temp4 41)))
				((local4 at: local0)
					pos: ((local4 at: local1) pos:)
					setPri: 100 1
					setMotion: JumpTo temp0 (- temp1 5) self
				)
				(= temp4 (/ temp2 4))
				(= temp5 (mod temp2 4))
				(= temp0 (+ 25 (* temp5 50)))
				(= temp1 (+ 9 (* temp4 41)))
				((local4 at: local1)
					pos: temp2
					setMotion: JumpTo temp0 (- temp1 5) self
				)
				(gSounds play: 12712 0 82 0)
			)
			(2)
			(3
				(= temp4 (/ ((local4 at: local0) pos:) 4))
				(= temp5 (mod ((local4 at: local0) pos:) 4))
				(= temp0 (+ 25 (* temp5 50)))
				(= temp1 (+ 9 (* temp4 41)))
				((local4 at: local0)
					setPos: ((local4 at: local0) pos:)
					posn: (+ temp0 2) (- temp1 2)
					setMotion: 0
				)
				(= temp4 (/ ((local4 at: local1) pos:) 4))
				(= temp5 (mod ((local4 at: local1) pos:) 4))
				(= temp0 (+ 25 (* temp5 50)))
				(= temp1 (+ 9 (* temp4 41)))
				((local4 at: local1)
					setPos: ((local4 at: local1) pos:)
					posn: (+ temp0 2) (- temp1 2)
					setMotion: 0
				)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSpin of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spButton setCycle: End)
				(= temp0 ((local4 at: local0) cel:))
				(= temp1 ((local4 at: local1) cel:))
				((local4 at: local0) cel: (mod (++ temp0) 4))
				((local4 at: local1) cel: (mod (++ temp1) 4))
				(gSounds play: 12711 0 82 self)
			)
			(1
				(gGame handsOn:)
				(spButton cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sIsDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12713 0 82 self)
			)
			(1
				(SetFlag 26)
				(proc951_15 6750)
				(gCurRoom newRoom: 27092) ; rm27v092
			)
		)
	)
)

