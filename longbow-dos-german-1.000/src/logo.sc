;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	logo 0
)

(local
	local0
	local1
)

(instance logo of Rm
	(properties
		picture 106
	)

	(method (init)
		(HandsOff)
		(gTheIconBar disable:)
		(gCurRoom drawPic: 803)
		(super init:)
		(glint init:)
		(glint2 init:)
		(gGame setCursor: 5 1)
		(gRgnMusic number: 1 loop: 1 play: flags: (& (gRgnMusic flags:) $fffe))
		(if (IsFlag 0)
			(= local0 10)
			(= local1 1)
			(SetPort 0 0 200 320 0 0)
		else
			(= local0 -32762)
			(= local1 0)
		)
		(gCurRoom setScript: animScript)
	)

	(method (dispose)
		(gRgnMusic flags: (| (gRgnMusic flags:) $0001))
		(gTheIconBar enable:)
		(super dispose: &rest)
	)
)

(instance animScript of Script
	(properties)

	(method (doit)
		(if local1
			(Palette palANIMATE 95 218 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 0 254 0)
				(gCurRoom drawPic: 106 local0)
				(= cycles 1)
			)
			(1
				(if (== (gRgnMusic prevSignal:) 20)
					(glint setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(2
				(if (== (gRgnMusic prevSignal:) 30)
					(glint dispose:)
					(glint2 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(== (glint2 cel:) (glint2 lastCel:))
						(== (gRgnMusic prevSignal:) -1)
					)
					(glint2 dispose:)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(= ticks 60)
			)
			(5
				(gCurRoom newRoom: 96 local0) ; cred
				(SetPort 0 0 190 320 10 0)
				(self dispose:)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 146
		y 37
		view 999
		cycleSpeed 2
	)
)

(instance glint2 of Prop
	(properties
		x 60
		y 155
		view 999
		loop 1
		cycleSpeed 2
	)
)

