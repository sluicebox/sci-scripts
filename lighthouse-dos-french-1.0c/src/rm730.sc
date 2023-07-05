;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use LightRoom)
(use Actor)
(use System)

(public
	rm730 0
)

(instance rm730 of LightRoom
	(properties)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(gBackMusic setVol: 127)
		(self changeScene: 721 12)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(solar721 dispose:)
		(battLight723 dispose:)
		(sBattLight dispose:)
		(switch param1
			(720
				((ScriptID 1 5) ; exitDown
					newRoom: 770
					nsLeft: 218
					nsTop: 63
					nsRight: 470
					nsBottom: 275
				)
				((ScriptID 1 2) newPic: 721 12) ; exitBack
			)
			(721
				(if (and (IsFlag 188) (IsFlag 144))
					((ScriptID 1 1) newPic: 723 12) ; exitForward
					(solar721 loop: 1 x: 171 y: 130 init:)
				else
					((ScriptID 1 1) newPic: 722 12) ; exitForward
					(solar721 loop: 0 x: 143 y: 126 init:)
				)
				((ScriptID 1 2) newPic: 720 16) ; exitBack
			)
			(722
				((ScriptID 1 7) newPic: 721 12) ; exitBackUp
			)
			(723
				(battLight723 init:)
				(sBattLight init:)
				((ScriptID 1 7) newPic: 721 12) ; exitBackUp
			)
		)
	)
)

(instance solar721 of View
	(properties
		view 2721
	)
)

(instance battLight723 of View
	(properties
		x 172
		y 227
		view 2711
	)
)

(instance sBattLight of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(battLight723 hide:)
				(= ticks 30)
			)
			(1
				(battLight723 show:)
				(= ticks 90)
			)
			(2
				(self init:)
			)
		)
	)
)

