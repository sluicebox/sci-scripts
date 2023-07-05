;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 603)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	LogoRoom 0
)

(local
	local0
)

(instance LogoRoom of Rm
	(properties
		picture 1
		style 10
	)

	(method (init)
		(SetPort 0 0 200 320 0 0)
		(gTheIconBar disable:)
		(gGame setCursor: 999 0)
		(SetFlag 359)
		(Palette palSET_INTENSITY 0 254 0)
		(super init:)
		(self setScript: logoScript)
		(glint init:)
		(glint2 init:)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (OneOf (event message:) KEY_ESCAPE KEY_RETURN))
			(if script
				(logoScript changeState: 8)
			)
			(event claimed: 1)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (== (mod (++ local0) 3) 0)
			(Palette palANIMATE 95 218 -1)
		)
		(super doit:)
	)
)

(instance glint of Prop
	(properties
		x 134
		y 34
		view 988
		cycleSpeed 2
	)
)

(instance glint2 of Prop
	(properties
		x 60
		y 155
		view 988
		loop 1
		cycleSpeed 2
	)
)

(instance logoSound of Sound
	(properties
		number 100
	)
)

(instance logoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(logoSound number: 100 loop: 1 flags: 0 play: self)
			)
			(2)
			(3
				(glint setCycle: End self)
			)
			(4
				(glint dispose:)
			)
			(5
				(glint2 setCycle: End self)
			)
			(6
				(glint2 dispose:)
			)
			(7
				(= ticks 60)
			)
			(8
				(logoSound stop:)
				(SetPort 0 0 190 320 10 0)
				(gCurRoom newRoom: 9) ; notice2Room
				(self dispose:)
			)
		)
	)
)

