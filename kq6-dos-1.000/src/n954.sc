;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 954)
(include sci.sh)
(use Main)
(use Print)
(use Approach)
(use Grooper)
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
	turnToWhom
	goToWhom
	oldLooper
	oldAvoider
)

(procedure (GoToIfSaid obj event theTargetOrX theDistanceOrY optSpec &tmp motion returnValue) ; UNUSED
	(switch
		(= returnValue
			(ISSc
				init:
					obj
					(if (and (>= argc 5) optSpec) optSpec else LOOKUP_ERROR)
					1
					0
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
				(Prints &rest)
			)
		)
	)
	(return returnValue)
)

(procedure (TurnIfSaid obj event optSpec &tmp theAngle) ; UNUSED
	(= theAngle (GetAngle (gEgo x:) (gEgo y:) (obj x:) (obj y:)))
	(return
		(if
			(==
				1
				(ISSc
					init:
						obj
						(if (>= argc 3) optSpec else LOOKUP_ERROR)
						(CantBeSeen
							obj
							gEgo
							(/ 360 (Max 4 (* (/ (NumLoops gEgo) 4) 4)))
						)
						1
				)
			)
			(if (IsObject oldLooper)
				(oldLooper dispose:)
			)
			(= oldLooper (gEgo looper:))
			(gEgo looper: 0 heading: theAngle setMotion: 0 setLoop: Grooper)
			((gEgo looper:) doit: gEgo theAngle ISSc)
			1
		)
	)
)

(instance ISSc of Script
	(properties)

	(method (init obj spec otherTest turning)
		(if (and otherTest (not (if turning turnToWhom else goToWhom)) (Said spec))
			(if (User canControl:)
				(if (IsObject oldAvoider)
					(oldAvoider dispose:)
				)
				(= oldAvoider (gEgo avoider:))
				(gEgo avoider: 0)
				(if turning
					(= turnToWhom obj)
				else
					(= goToWhom obj)
				)
				(User canControl: 0 canInput: 0)
				1
			else
				((User curEvent:) claimed: 0)
				2
			)
		)
	)

	(method (cue &tmp evt)
		(User canControl: 1 canInput: 1)
		((= evt (Event new:)) type: evSAID)
		(gEgo setAvoider: oldAvoider)
		(= oldAvoider 0)
		(if turnToWhom
			((gEgo looper:) dispose:)
			(gEgo looper: oldLooper)
			(= oldLooper 0)
			(turnToWhom handleEvent: evt)
			(= turnToWhom 0)
		else
			(goToWhom handleEvent: evt)
			(= goToWhom 0)
		)
		(if (not (evt claimed:))
			(gRegions eachElementDo: #handleEvent evt 1)
			(gGame handleEvent: evt 1)
		)
		(evt dispose:)
	)
)

