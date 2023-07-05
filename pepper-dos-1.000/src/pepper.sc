;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 895)
(include sci.sh)
(use Main)
(use StopWalk)
(use Grooper)
(use Ego)
(use System)

(public
	pepper 0
	lockjaw 1
)

(instance pepperStopWalk of StopWalk
	(properties)
)

(instance lockjawStopWalk of StopWalk
	(properties)
)

(instance pepperStopGroop of Grooper
	(properties)

	(method (init param1)
		(= client param1)
		(super init: &rest)
	)

	(method (dispose)
		(= client 0)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(OneOf ((ScriptID 895 0) view:) 800 790) ; pepper
				(== (client loop:) (- (NumLoops client) 1))
				(not (& (client signal:) $0800))
			)
			(client loop: (client cel:))
		)
		(super doit: &rest)
	)
)

(instance lockjawStopGroop of Grooper
	(properties)

	(method (init param1)
		(= client param1)
		(super init: &rest)
	)

	(method (dispose)
		(= client 0)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(== ((ScriptID 895 1) view:) 807) ; lockjaw
				(== (client loop:) (- (NumLoops client) 1))
				(not (& (client signal:) $0800))
			)
			(client loop: (client cel:))
		)
		(super doit: &rest)
	)
)

(class ego of Ego
	(properties
		sightAngle 40
		normal 0
	)

	(method (init param1 param2)
		(super init: &rest)
		(self normalize:)
	)

	(method (doit)
		(super doit: &rest)
	)

	(method (normalize param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
		(= temp0 view)
		(= temp1 8)
		(= temp2 x)
		(= temp3 y)
		(cond
			(argc
				(= temp0 param1)
				(if (> argc 1)
					(= temp1 param2)
					(if (> argc 2)
						(= temp2 param3)
						(if (> argc 3)
							(= temp3 param4)
						)
					)
				)
			)
			((== self (ScriptID 895 0)) ; pepper
				(if (IsFlag 10)
					(= temp0 790)
				else
					(= temp0 800)
				)
			)
			(else
				(= temp0 807)
			)
		)
		(self
			view: temp0
			setLoop: -1
			setLoop:
				(if (== self (ScriptID 895 0)) ; pepper
					pepperStopGroop
				else
					lockjawStopGroop
				)
			setMotion: 0
			setCycle:
				(if (== self (ScriptID 895 0)) ; pepper
					pepperStopWalk
				else
					lockjawStopWalk
				)
				-1
			setStep: 3 2
			illegalBits: 0
			ignoreHorizon:
			ignoreActors: 0
			setSpeed: global197
			posn: temp2 temp3
			loop: temp1
			signal: (| signal $1000)
			setLoop: -1
			setPri: -1
			state: (|= state $0002)
			forceUpd:
		)
	)

	(method (put)
		(super put: &rest)
		(gTheIconBar curIcon: (gTheIconBar walkIconItem:))
	)

	(method (handleEvent event)
		(if (& (event type:) $0040) ; direction
			(return 0)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance pepper of ego
	(properties
		x 160
		y 100
		noun 31
		modNum 0
		view 800
	)
)

(instance lockjaw of ego
	(properties
		x 160
		y 100
		noun 23
		modNum 0
		view 807
	)

	(method (init)
		(self setScript: (ScriptID 838 0)) ; LockjawStuff
		(super init: &rest)
	)
)

