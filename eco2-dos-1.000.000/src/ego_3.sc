;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use StopWalk)
(use Grooper)
(use Ego_988)
(use Inventory)

(class ego of Ego
	(properties
		noun 1
		modNum 4
		sightAngle 180
		view 0
	)

	(method (init)
		(super init:)
		(self
			signal: (| signal $1000)
			setCycle: 0
			state: (| (self state:) $0002)
		)
	)

	(method (normalize param1 param2 &tmp temp0)
		(if argc
			(= view param1)
			(if (> argc 1)
				(= loop param2)
			)
		)
		(= temp0
			(switch loop
				(6 45)
				(0 90)
				(4 135)
				(2 180)
				(5 225)
				(1 270)
				(7 315)
			)
		)
		(self
			heading: temp0
			setLoop: -1
			setLoop: (ScriptID 0 8) ; stopGroop
			setCel: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			setStep: 3 2
			z: 0
			illegalBits: -32768
			ignoreActors: 0
			setSpeed: global136
		)
	)

	(method (showInv &tmp temp0)
		(if (Inv firstTrue: #ownedBy gEgo)
			(Inv showSelf: gEgo)
		else
			(gMessager say: 1 0 0 1 0 99) ; "Adam isn't carrying anything."
		)
	)

	(method (put)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 5))
			(proc0_10 0)
		)
		(super put: &rest)
	)

	(method (setMotion param1 &tmp temp0)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if param1
			(self startUpd:)
			(= mover
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(mover init: self &rest)
		else
			(= mover 0)
			(if
				(and
					(>= argc 2)
					looper
					(looper isKindOf: Grooper)
					(IsObject (= temp0 (looper oldMover:)))
				)
				(temp0 dispose:)
				(looper oldMover: 0)
			)
		)
	)
)

