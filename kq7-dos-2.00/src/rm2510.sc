;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2510)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm2510 0
)

(local
	local0
)

(instance rm2510 of KQRoom
	(properties
		picture 2510
	)

	(method (init)
		(super init:)
		(gKqMusic1 number: 2460 setLoop: -1 loop: -1 play:)
		((ScriptID 7001 2) client: mBody) ; mathildeTalker
		(mBody init: setPri: 100)
		(mHands init: setPri: 200 setCycle: Fwd)
		(= local0 (gEgo x:))
		(gEgo x: 1000)
		(self setScript: sCartoon)
	)
)

(instance mBody of Prop
	(properties
		x 145
		y 139
		view 2481
		signal 26657
	)
)

(instance mHands of Prop
	(properties
		x 145
		y 139
		view 2481
		loop 1
		signal 26657
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gCurRoom newRoom: 2100)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOn:)
					(gGame handsOff: 1)
					(mHands setCycle: Fwd)
					(= ticks 240)
				)
				(1
					(gMessager say: 0 0 1 20 self 2450) ; "(VERY SUSPICIOUS AND CRANKY)A troll, huh?"
				)
				(2
					(= seconds 3)
				)
				(3
					(gKqMusic1 fade:)
					(= seconds 4)
				)
				(4
					(gEgo x: local0)
					(gCurRoom newRoom: 2100)
				)
			)
		)
	)
)

