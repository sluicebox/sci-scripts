;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)
(use System)

(public
	Delphineus 0
	Adam 1
)

(instance Delphineus of Talker
	(properties
		nsTop 16
		nsLeft 20
		view 841
		loop 3
		viewInPrint 1
		charNum 4
		keepWindow 1
	)

	(method (init)
		(super init: dBust dEyes dMouth &rest)
	)
)

(instance dBust of Prop
	(properties
		view 841
	)
)

(instance dEyes of Prop
	(properties
		nsTop 4
		nsLeft 22
		view 841
		loop 2
		cycleSpeed 30
	)
)

(instance dMouth of Prop
	(properties
		nsTop 7
		nsLeft 20
		view 841
		loop 1
		cycleSpeed 10
	)
)

(instance Adam of Talker
	(properties
		nsTop 134
		nsLeft 20
		view 813
		viewInPrint 1
		charNum 3
		keepWindow 1
	)

	(method (init)
		(if (OneOf gCurRoomNum 380 400 381)
			(= view 813)
			(aMouth nsLeft: 8 nsTop: 15)
		else
			(= view 824)
			(aMouth nsLeft: 6 nsTop: 14)
		)
		(aBust view: view)
		(aEyes view: view)
		(aMouth view: view)
		(super init: aBust aEyes aMouth &rest)
	)
)

(instance aBust of Prop
	(properties
		view 813
		cel 1
		priority 12
		signal 16400
	)
)

(instance aMouth of Prop
	(properties
		nsTop 21
		nsLeft 14
		view 813
		loop 1
		cel 7
		priority 13
		signal 16400
	)
)

(instance aEyes of Prop
	(properties
		nsTop 8
		view 813
		loop 2
		priority 14
		signal 16400
		cycleSpeed 60
	)
)

