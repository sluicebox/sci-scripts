;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 481)
(include sci.sh)
(use Main)
(use Array)
(use Actor)
(use System)

(class TrackingProp of Prop
	(properties
		points -1
		cycles 0
		locked 0
		dynaPnts 0
		tracking 0
		wrap 1
		oneWay 0
		advanceKey -1
		retreatKey -1
		keyTrack 0
		delay 0
	)

	(method (init)
		(super init: &rest)
		(if (or (!= advanceKey -1) (!= retreatKey -1))
			(gKeyDownHandler add: self)
		)
	)

	(method (setPoints)
		(if (== points -1)
			(= points (IntArray new: 2))
			(= dynaPnts 1)
		)
		(points at: 0 &rest)
	)

	(method (lock param1)
		(= locked param1)
	)

	(method (nextCel param1 &tmp temp0 temp1 temp2 temp3)
		(cond
			(wrap
				(= temp1 (/ (= temp3 (NumCels self)) 2))
				(cond
					((> (= temp0 (- cel param1)) 0)
						(if (< (Abs temp0) temp1)
							(= temp2 -1)
						else
							(= temp2 1)
						)
					)
					((< (Abs temp0) temp1)
						(= temp2 1)
					)
					(else
						(= temp2 -1)
					)
				)
				(if (or (not oneWay) (== temp2 oneWay))
					(self setCel: (+ cel temp2))
					(cond
						((>= cel temp3)
							(self setCel: 0)
						)
						((< cel 0)
							(self setCel: (- temp3 1))
						)
					)
					(return temp2)
				)
			)
			((< param1 cel)
				(if (or (not oneWay) (== oneWay -1))
					(self setCel: (- cel 1))
				)
			)
			((or (not oneWay) (== oneWay 1))
				(self setCel: (+ cel 1))
			)
		)
		(return (UpdateScreenItem self))
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			(
				(and
					(gUser input:)
					(not tracking)
					(& (event type:) evKEYBOARD)
					(OneOf (event message:) advanceKey retreatKey)
					(not keyTrack)
				)
				(= keyTrack (if (== (event message:) advanceKey) 1 else -1))
				(= tracking 1)
				(global206 add: self)
				(= cycles delay)
				(self setCycle: 0)
				(event claimed: 1)
				(return)
			)
			((and keyTrack (& (event type:) evKEYUP))
				(= keyTrack (= tracking 0))
				(global206 delete: self)
				(self doMouseUp:)
				(event claimed: 1)
				(return)
			)
			(keyTrack
				(cond
					((== keyTrack 1)
						(if (!= cel (= temp1 (self lastCel:)))
							(self nextCel: temp1)
						)
					)
					(cel
						(self nextCel: 0)
					)
				)
			)
			((and tracking (& (event type:) evMOUSERELEASE))
				(= tracking 0)
				(global206 delete: self)
				(self doMouseUp:)
				(event claimed: 1)
				(return)
			)
			((and (self onMe: event) locked)
				(return)
			)
			(
				(and
					(== (gUser curVerb:) 5)
					(not tracking)
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
				)
				(global206 add: self)
				(= tracking 1)
				(= cycles delay)
				(event claimed: 1)
				(return)
			)
			(tracking
				(if
					(and
						(!= (= temp0 (self findClosest: event)) -1)
						(!= cel temp0)
					)
					(self nextCel: temp0)
				)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (doMouseUp))

	(method (timeElapsed)
		(return
			(if (<= (-- cycles) 0)
				(= cycles delay)
				1
			else
				0
			)
		)
	)

	(method (findClosest param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (points size:))
		(= temp4 -1)
		(for ((= temp3 0)) (< temp3 temp0) ((+= temp3 2))
			(= temp1 (points at: temp3))
			(= temp2 (points at: (+ temp3 1)))
			(= temp6
				(GetDistance (+ temp1 x) (+ temp2 y) (param1 x:) (param1 y:))
			)
			(if (or (== temp4 -1) (< temp6 temp5)) ; UNINIT
				(= temp4 temp3)
				(= temp5 temp6)
			)
		)
		(return
			(cond
				((== temp4 -1) temp4)
				(temp4
					(/ temp4 2)
				)
				(else 0)
			)
		)
	)

	(method (dispose)
		(if dynaPnts
			(points dispose:)
			(= points -1)
			(= dynaPnts 0)
		)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(if tracking
			(= tracking 0)
		)
		(super dispose: &rest)
	)
)

