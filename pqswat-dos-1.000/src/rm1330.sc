;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1330)
(include sci.sh)
(use Main)
(use PQRoom)
(use Osc)
(use Motion)
(use Actor)
(use System)

(public
	rm1330 0
)

(instance rm1330 of PQRoom
	(properties
		picture 1330
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= global415 0)
		)
		(super init: &rest)
		(militiaGuys init: setPri: 285 setCycle: Osc -1)
		(if global415
			(gCurRoom setScript: telloForeGround)
		else
			(gCurRoom setScript: telloBackGround)
		)
	)
)

(instance telloForeGround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 13003 10314)
				(Load rsVIEW 13300 13302 13304)
				(= seconds 3)
			)
			(1
				(militiaGuys setCycle: 0)
				(carmike view: 13304 posn: 449 274 init: setCycle: End self)
			)
			(2
				(tello
					view: 13300
					posn: 609 232
					init:
					setPri: 400
					setCycle: End self
				)
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 13003 setLoop: 0 play: self)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gBackMusic number: 6007 setLoop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance telloBackGround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 13003 10314)
				(Load rsVIEW 13301 13302 13303)
				(= seconds 3)
			)
			(1
				(militiaGuys setCycle: 0)
				(carmike view: 13303 posn: 645 405 init: setCycle: End self)
			)
			(2
				(tello view: 13301 posn: 469 272 init: setCycle: End self)
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 13003 setLoop: 0 play: self)
			)
			(4
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance militiaGuys of Prop
	(properties
		x 351
		y 360
		view 13302
	)
)

(instance tello of Prop
	(properties)
)

(instance carmike of Prop
	(properties)
)

