;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room54 0
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance explosion of Sound
	(properties)
)

(instance Room54 of Rm
	(properties
		picture 54
	)

	(method (init)
		(= south gPrevRoomNum)
		(Load rsPIC 540)
		(Load rsVIEW 79)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(Load rsSOUND 33)
		(super init:)
		(NormalEgo)
		(gEgo init:)
		(lightning view: 69 loop: 8 cel: 0 posn: 99 75 setScript: flash init:)
		(= global104 0)
		(gEgo posn: 157 188 view: 0 loop: 3)
		(gCurRoom setScript: Actions)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 988)
		(if (not gHandsOff)
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((or (Said '/area') (Said '/around') (Said '[<around][/!*]'))
					(Print 54 0) ; "You see a flat expanse of desert and mountains to the north."
				)
				((Said '/butte,toe')
					(Print 54 1) ; "A range of craggy peaks appear on the horizon to the north. Occasionally, one is struck by lightning."
				)
				((or (Said '/cloud,air') (Said '<up'))
					(Print 54 2) ; "The sky is alive with electrical activity as large ominous clouds make their way across the darkened sky."
				)
				((Said '/desert')
					(Print 54 3) ; "It seems like this entire planet is one vast expanse of desert. About all you see is sand and rocks."
				)
				((Said '/dirt,dirt')
					(Print 54 4) ; "The ground beneath your feet is composed of an unusually colored sand. Other than it's bizzare coloration, you have no other interest in it. However... as you expectorate a mouthful of the wind blown sand you briefly reminisce about your adventure on Kerona (SQ I )."
				)
				((Said '/lightning')
					(Print 54 5) ; "You notice flashes of lightning to the north. You hope it doesn't move this way."
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (and (== state 0) (or (!= (gEgo x:) 157) (<= (gEgo y:) 185)))
			(= seconds 0)
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(HandsOff)
				(explosion number: 33 priority: 34 play:)
				(gCurRoom overlay: 540 5)
				(gEgo
					view: 79
					loop: 1
					cel: 255
					cycleSpeed: 1
					setCycle: End self
				)
				(= cycles 1)
			)
			(2
				(ShakeScreen 8)
				(gCurRoom drawPic: 54 4)
			)
			(3
				(= seconds 7)
			)
			(4
				(EgoDead 901 0 11 18)
			)
		)
	)
)

(instance flash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(lightning cel: 255 setCycle: End self)
			)
			(2
				(lightning cel: 0)
				(= seconds (Random 2 5))
			)
			(3
				(thunder priority: 2 number: (Random 31 32) play: self)
			)
			(4
				(= state -1)
			)
		)
	)
)

