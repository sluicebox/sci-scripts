;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6012)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm6012 0
)

(instance rm6012 of KQRoom
	(properties
		picture 6020
	)

	(method (init)
		(gGame handsOff:)
		(SetFlag 21)
		(super init: &rest)
		(Load rsMESSAGE 6000)
		(val init:)
		(oberon init:)
		(titania init:)
		(volcano init: setCycle: Fwd)
		((ScriptID 13 0) client: val view: 6020 loop: 2) ; aEgoTalker
		((ScriptID 7001 9) ; oberonTalker
			client: oberon
			view: (oberon view:)
			loop: (oberon loop:)
		)
		((ScriptID 7001 10) ; titaniaTalker
			client: titania
			view: (titania view:)
			loop: (titania loop:)
		)
		(gCurRoom setScript: moreChatter)
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
	)
)

(instance moreChatter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager sayRange: 0 0 1 11 14 self 6000) ; "(INTENSE, VERY CONCERNED)Malicia has ignited the volcano? Are you sure of this?"
			)
			(2
				(gCurRoom newRoom: 6010)
				(self dispose:)
			)
		)
	)
)

(instance val of Prop
	(properties
		x 269
		y 74
		view 6020
		loop 2
	)
)

(instance titania of Prop
	(properties
		x 24
		y 56
		view 6020
		loop 1
	)
)

(instance oberon of Prop
	(properties
		x 68
		y 53
		view 6020
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

