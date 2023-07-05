;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1010)
(include sci.sh)
(use Main)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	rm1010 0
)

(instance rm1010 of PQRoom
	(properties
		picture 1010
	)

	(method (init)
		(super init: &rest)
		(self setScript: showDeployment)
	)

	(method (dispose)
		(Lock rsAUDIO 10302 0)
		(gBackMusic fade: 0 2 21 1)
		(super dispose: &rest)
	)
)

(instance showDeployment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wixell init:)
				(me init: setCycle: End)
				(= ticks 30)
			)
			(1
				(saunders init: setPri: 300 setCycle: End self)
			)
			(2
				(SetFlag 78)
				(gCurRoom newRoom: 1501)
			)
		)
	)
)

(instance me of Prop
	(properties
		x 47
		y 308
		view 10102
	)
)

(instance saunders of Prop
	(properties
		x 42
		y 271
		view 10101
	)
)

(instance wixell of Prop
	(properties
		x 138
		y 357
		view 10103
	)
)

