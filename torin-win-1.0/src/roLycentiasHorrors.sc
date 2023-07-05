;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51300)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use Motion)
(use Actor)
(use System)

(public
	roLycentiasHorrors 0
)

(instance poTorin of Prop
	(properties
		x 313
		y 245
		view 51300
	)
)

(instance soHorror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin init: setCycle: CT 20 1 self)
				(gMessager say: 0 0 1 1 self) ; "Wha the..."
			)
			(1)
			(2
				(gMessager say: 0 0 1 2 self) ; "Boogle?"
				(poTorin setCycle: CT 37 1 self)
			)
			(3)
			(4
				(gMessager say: 0 0 1 3 self) ; "Mom."
			)
			(5
				(poTorin setCycle: CT 43 1 self)
			)
			(6
				(gMessager sayRange: 0 0 1 4 5 self) ; "Dad!"
				(poTorin setCycle: End self)
			)
			(7)
			(8
				(gCurRoom newRoom: 51400) ; roEnd
			)
		)
	)
)

(instance roLycentiasHorrors of TPRoom
	(properties
		picture 51300
	)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 226) ; oFlags
		(goMusic1 setMusic: 51300)
		(gGame handsOff:)
		(self setScript: soHorror)
	)
)

