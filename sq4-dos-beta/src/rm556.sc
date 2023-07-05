;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 556)
(include sci.sh)
(use Main)
(use SQRoom)
(use ForwardCounter)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm556 0
)

(local
	local0
)

(procedure (localproc_0)
	(Display 556 0 dsRESTOREPIXELS local0)
)

(class mdlScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local0 (OneOf ((User curEvent:) type:) evMOUSEBUTTON evKEYBOARD))
			(proc0_12 local0)
			(= local0 (= seconds 0))
			(= cycles 1)
		)
	)
)

(instance rm556 of SQRoom
	(properties
		picture 556
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(150
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init:)
				(self setScript: holoScript)
			)
			(555
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init: setCel: 4)
				(self setScript: finaleScript)
			)
			(else
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init:)
				(self setScript: holoScript)
			)
		)
	)
)

(instance holoScript of mdlScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogerHead setCycle: ForwardCounter 5)
				(= local0
					(proc0_12
						{"** You did so get all your good looks from me!"}
						67
						2
						2
						28
						global140
						29
						global129
						30
						1
						70
						315
					)
				)
			)
			(2
				(rogerJrHead setCycle: ForwardCounter 5)
				(= local0
					(proc0_12
						{"** I did not, I look like mom, see I'll show you."}
						67
						2
						2
						28
						global150
						29
						global129
						30
						1
						70
						315
					)
				)
				(= seconds 15)
			)
			(4
				(rogerJrArm setCycle: End self)
			)
			(5
				(gCurRoom newRoom: 555)
			)
			(else
				(localproc_0)
				(= cycles 1)
			)
		)
	)
)

(instance finaleScript of mdlScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rogerJrArm setLoop: 5 setCel: 0 setCycle: End self)
			)
			(1
				(rogerJrHead setCycle: ForwardCounter 5)
				(= local0
					(proc0_12
						{"** I'd hurl every time I looked in the mirror if I looked like you!"}
						67
						2
						2
						28
						global150
						29
						global129
						30
						1
						70
						315
					)
				)
				(= seconds 15)
			)
			(3
				(rogerHead setCycle: ForwardCounter 5)
				(= local0
					(proc0_12
						{"** I bet your just jealous that I'm such a famous hero."}
						67
						2
						2
						28
						global140
						29
						global129
						30
						1
						70
						315
					)
				)
				(= seconds 15)
			)
			(5
				(rogerJrHead setCycle: ForwardCounter 2)
				(= local0
					(proc0_12
						{"** O.K., I'll bet a thousand buckazoids that I'm not, you wad of vark crap!"}
						67
						2
						2
						28
						global150
						29
						global129
						30
						1
						70
						315
					)
				)
				(= seconds 15)
			)
			(7
				(rogerJrArm setLoop: 6 setCel: 0 setCycle: End)
				(rogerArm init: setCycle: End)
				(= cycles 2)
			)
			(8
				(rogerJrArm dispose:)
				(= cycles 5)
			)
			(9
				(gCurRoom newRoom: 540)
			)
			(else
				(localproc_0)
				(= cycles 1)
			)
		)
	)
)

(instance rogerHead of Prop
	(properties
		x 198
		y 67
		view 555
	)
)

(instance rogerJrHead of Prop
	(properties
		x 113
		y 66
		view 555
		loop 1
	)
)

(instance rogerJrArm of Prop
	(properties
		x 114
		y 73
		view 555
		loop 4
		priority 5
		signal 16400
	)
)

(instance rogerArm of Prop
	(properties
		x 189
		y 85
		view 555
		loop 7
		priority 4
		signal 16400
	)
)

