;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use Inset)
(use User)
(use Actor)
(use System)

(public
	lookAtLocker 0
)

(instance lookAtLocker of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 341)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 0 3)
				(gCurRoom setInset: locker self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance putGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(lockerDoor setCel: 2)
				(SetScore 167 2)
				(gEgo put: 0) ; Service_Revolver
				(= seconds 2)
			)
			(1
				(locker dispose:)
			)
		)
	)
)

(instance getGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(lockerDoor setCel: 1)
				(gEgo get: 0) ; Service_Revolver
				(= seconds 2)
			)
			(1
				(locker dispose:)
			)
		)
	)
)

(instance locker of Inset
	(properties
		view 286
		x 19
		y 34
		priority 15
		disposeNotOnMe 1
		noun 6
	)

	(method (init)
		(super init: &rest)
		(lockerDoor init:)
	)

	(method (dispose)
		(HandsOff)
		(super dispose: &rest)
	)
)

(instance lockerDoor of Prop
	(properties
		z 100
		noun 6
		view 286
		loop 1
		priority 15
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (+ (locker x:) 6) (+ (locker y:) 4 z))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch cel
					(2
						(locker setScript: getGun)
					)
					(1
						(self setCel: 0)
					)
					(0
						(if (or (IsFlag 85) (gEgo has: 0)) ; Service_Revolver
							(self setCel: 1)
						else
							(self setCel: 2)
						)
					)
				)
			)
			(9 ; Service_Revolver
				(locker setScript: putGun)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

