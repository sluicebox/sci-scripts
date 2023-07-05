;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use EcoFeature)
(use Talker)
(use System)

(public
	Delphineus 0
	Adam 1
)

(instance Delphineus of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 841
		charNum 4
		keepWindow 1
	)

	(method (init)
		(dMouth nsLeft: 26 nsTop: 12)
		(dEyes nsLeft: 28 nsTop: 9)
		(super init: dBust dEyes dMouth &rest)
	)
)

(instance dBust of EcoProp
	(properties
		view 841
	)
)

(instance dEyes of EcoProp
	(properties
		nsTop 9
		nsLeft 28
		view 841
		loop 2
		cycleSpeed 30
	)
)

(instance dMouth of EcoProp
	(properties
		nsTop 12
		nsLeft 26
		view 841
		loop 1
		cycleSpeed 10
	)
)

(instance Adam of EcoTalker
	(properties
		nsTop 105
		nsLeft 5
		view 813
		charNum 3
		keepWindow 1
	)

	(method (init)
		(if (OneOf gCurRoomNum 380 400 381)
			(= nsTop 125)
			(= view 813)
			(aMouth nsLeft: 12 nsTop: 19)
			(aEyes nsLeft: 4 nsTop: 12)
		else
			(= view 824)
			(aMouth nsLeft: 10 nsTop: 18)
			(aEyes nsLeft: 4 nsTop: 12)
		)
		(aBust view: view)
		(aEyes view: view)
		(aMouth view: view)
		(super init: aBust aEyes aMouth &rest)
	)
)

(instance aBust of EcoProp
	(properties
		nsTop 5
		nsLeft 5
		view 813
		cel 1
		priority 12
		signal 16400
	)
)

(instance aMouth of EcoProp
	(properties
		nsTop 19
		nsLeft 12
		view 813
		loop 1
		cel 7
		priority 13
		signal 16400
	)
)

(instance aEyes of EcoProp
	(properties
		nsTop 12
		nsLeft 4
		view 813
		loop 2
		priority 14
		signal 16400
		cycleSpeed 60
	)
)

