;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6002)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm6002 0
)

(instance rm6002 of KQRoom
	(properties
		picture 6015
	)

	(method (init)
		(gGame handsOff:)
		(SetFlag 21)
		(super init: &rest)
		(Load rsMESSAGE 6000)
		(levanter init:)
		(val init:)
		((ScriptID 7001 8) client: levanter view: 6015 loop: 1) ; levanterTalker
		((ScriptID 13 0) client: val view: 6015 loop: 0) ; aEgoTalker
		(volcano init: setCycle: Fwd)
		(if (!= (gKqMusic1 number:) 6250)
			(gKqMusic1
				stop:
				number: 6250
				setLoop: -1
				play:
				setVol: 0
				fade: 127 5 5 0
			)
		)
		(gCurRoom setScript: idleChatter)
	)
)

(instance idleChatter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager sayRange: 0 0 1 6 7 self 6000) ; "(AMUSED)I am Levanter, King of the Winds. Who are you, little one?"
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 6010)
				(self dispose:)
			)
		)
	)
)

(instance levanter of Prop
	(properties
		x 255
		y 54
		view 6015
		loop 1
	)
)

(instance val of Prop
	(properties
		x 37
		y 66
		view 6015
	)
)

(instance volcano of Prop
	(properties
		x 119
		y 28
		view 6015
		loop 2
	)
)

