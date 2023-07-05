;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50700)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use Talker)
(use Motion)
(use Actor)

(public
	roTenebrousLS 0
)

(instance poFlower of Prop
	(properties
		x 150
		y 260
		view 50701
		loop 5
	)
)

(instance poTorin of Prop
	(properties
		view 50701
	)
)

(instance toTorin of Talker
	(properties
		x 184
		y 263
		view 50701
		loop 4
		priority 500
	)
)

(instance oCrunch of TPSound
	(properties)
)

(instance soPlayMovie of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 50601 50603)
				(goSound1 playSound: 50601)
				(poTorin loop: 0 cel: 2 posn: 184 263 init: setCycle: Beg self)
				(poFlower setPri: 500 init:)
			)
			(1
				(= ticks 120)
			)
			(2
				(= gtTorin toTorin)
				(gMessager say: 0 0 1 1 self 50600) ; "(SHOW BIZZY) Thank you. Thank you very much!"
			)
			(3
				(= gtTorin 0)
				(poTorin setCycle: CT 4 1 self)
			)
			(4
				(poFlower setPri: 260)
				(oCrunch playSound: 50603)
				(poTorin setCycle: CT 5 1 self)
			)
			(5
				(= ticks (poTorin cycleSpeed:))
			)
			(6
				(poTorin cel: 6 doit:)
				(poFlower cel: 1 doit:)
				(poTorin setCycle: CT 7 1 self)
			)
			(7
				(= ticks 90)
			)
			(8
				(poTorin setCycle: End self)
			)
			(9
				(gMessager say: 0 0 1 3 self 50600) ; "(SOFTLY EMBARRASSED) Oops."
				(poTorin loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(10)
			(11
				(poTorin cycleSpeed: 3 setCycle: End self)
			)
			(12
				(poTorin loop: 2 cel: 0 setCycle: CT 8 1 self)
			)
			(13
				(poTorin dispose:)
				(gEgo posn: 174 257 init: normalize: setLoop: 6 1)
				(= ticks 120)
			)
			(14
				(gEgo setMotion: MoveTo 194 238 self)
			)
			(15
				(gEgo setPri: 1 setMotion: MoveTo 294 425 self)
			)
			(16
				(gCurRoom newRoom: 50800) ; roTenebrousMS
			)
		)
	)
)

(instance roTenebrousLS of TPRoom
	(properties
		picture 50700
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 50400)
		(gCurRoom setScript: soPlayMovie)
	)

	(method (gimme))
)

