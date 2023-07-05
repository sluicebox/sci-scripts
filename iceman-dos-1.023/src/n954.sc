;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 954)
(include sci.sh)
(use Main)
(use Interface)
(use Approach)
(use Sight)
(use Avoid)
(use Motion)
(use User)
(use System)

(public
	GoToIfSaid 0
	TurnIfSaid 1
)

(local
	local0
	local1
	local2
)

(procedure (GoToIfSaid obj event theTargetOrX theDistanceOrY optSpec &tmp motion returnValue)
	(switch
		(= returnValue
			(ISSc
				init: obj (if (and (>= argc 5) optSpec) optSpec else '*/*') 1 0
			)
		)
		(1
			(gEgo
				setMotion:
					(if (IsObject theTargetOrX) Approach else MoveTo)
					theTargetOrX
					theDistanceOrY
					ISSc
				setAvoider: Avoid
			)
		)
		(2
			(if (>= argc 6)
				(Print &rest)
			)
		)
	)
	(return returnValue)
)

(procedure (TurnIfSaid obj event optSpec &tmp theAngle)
	(if (not (User controls:))
		(return 0)
	)
	(= theAngle (GetAngle (gEgo x:) (gEgo y:) (obj x:) (obj y:)))
	(return
		(if
			(==
				1
				(ISSc
					init:
						obj
						(if (>= argc 3) optSpec else '*/*')
						(CantBeSeen
							obj
							gEgo
							(/ 360 (Max 4 (* (/ (NumLoops gEgo) 4) 4)))
						)
						1
				)
			)
			(gEgo heading: theAngle setMotion: 0)
			((gEgo looper:) doit: gEgo theAngle ISSc)
			1
		)
	)
)

(instance ISSc of Script
	(properties)

	(method (init obj spec otherTest turning)
		(if (and otherTest (not (if turning local0 else local1)) (Said spec))
			(if (User canControl:)
				(if (IsObject local2)
					(local2 dispose:)
				)
				(= local2 (gEgo avoider:))
				(gEgo avoider: 0)
				(if turning
					(= local0 obj)
				else
					(= local1 obj)
				)
				(User canControl: 0 canInput: 0)
				1
			else
				2
			)
		)
	)

	(method (cue &tmp evt)
		(User canControl: 1 canInput: 1)
		((= evt (User curEvent:)) type: evSAID)
		(Parse (User inputLineAddr:) evt)
		(gEgo setAvoider: local2)
		(= local2 0)
		(if local0
			(local0 handleEvent: evt)
			(= local0 0)
		else
			(local1 handleEvent: evt)
			(= local1 0)
		)
		(Said 'stand')
		(if (not (evt claimed:))
			(gRegions eachElementDo: #handleEvent evt 1)
			(gGame handleEvent: evt 1)
		)
		(evt dispose:)
	)
)

