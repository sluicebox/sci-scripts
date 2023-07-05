;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1040)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1040 0
)

(instance rm1040 of PQRoom
	(properties
		picture 1040
	)

	(method (init)
		(Load rsVIEW 10 25 31 32 10401 10402)
		(Load rsAUDIO 51 1050 10303 10314 21003)
		(if (!= 10303 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(gBackMusic number: 10303 loop: -1 play:)
			(Lock rsAUDIO 10303 1)
		)
		(ClearFlag 12)
		(super init:)
		(door init:)
		(self setScript: enterRoom)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 10400 0 147 0 0 -1 1)
			)
			(1
				(badGuy init: setCycle: CT 23 1 self)
			)
			(2)
			(3
				(proc4_5)
				(badGuy dispose:)
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(sound1 number: 1050 setLoop: 1 play: self)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance door of View
	(properties
		x 269
		y 162
		view 10402
	)
)

(instance badGuy of Prop
	(properties
		x 369
		y 138
		view 10401
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== cel 1) (not (sound1 handle:)) (not (gunShot handle:)))
				(gunShot number: 51 play:)
				(sound1 number: 21003 play:)
			)
			((and (not (gunShot3 handle:)) (== cel 14))
				(gunShot3 number: 51 play:)
			)
			((and (not (gunShot2 handle:)) (== cel 19))
				(gunShot2 number: 51 play:)
			)
		)
	)
)

(instance sound1 of Sound
	(properties)
)

(instance gunShot of Sound
	(properties)
)

(instance gunShot2 of Sound
	(properties)
)

(instance gunShot3 of Sound
	(properties)
)

