;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use n013)
(use RandCycle)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
)

(instance rm500 of Room
	(properties
		picture 500
		style 14
		exitStyle 13
	)

	(method (init)
		(gGame handsOff:)
		(ClearFlag 220)
		(= local0 gTheCursor)
		(gGame setCursor: myInvisCursor 1)
		(SetFlag 220)
		(super init:)
		(gGame handsOff:)
		(= gWaitCursor myInvisCursor)
		(Load rsMESSAGE 500)
		(cond
			((== gPrevRoomNum 510)
				(gCurRoom setScript: leaveGermany)
				(Load rsVIEW 502)
			)
			((== gPrevRoomNum 750)
				(Load rsVIEW 501)
				(gCurRoom setScript: arriveInGermany)
			)
			((== gPrevRoomNum 540)
				(gCurRoom setScript: endTheDay)
			)
			(else
				(PalVary 0 500 0) ; PalVaryStart
				(Load rsVIEW 375)
				(Load rsVIEW 505)
				(gCurRoom setScript: startTheDay)
			)
		)
		(if (== (gGame detailLevel:) 3)
			(if (DoSound sndGET_AUDIO_CAPABILITY)
				(Load 140 504) ; WAVE
			)
			(gGkSound2 number: 504 setLoop: -1 flags: 5 play:)
		)
	)

	(method (dispose)
		(gGkSound2 stop: flags: 1)
		(= gWaitCursor local0)
		(ClearFlag 220)
		(gGame setCursor: gWaitCursor 1)
		(DisposeScript 64941)
		(PalVary 3) ; PalVaryKill
		(super dispose:)
	)
)

(instance startTheDay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke init: setCycle: RandCycle)
				(townLights init:)
				(castleLights init:)
				(otherLights init: cycleSpeed: 1 setCycle: End)
				(leftSnow init:)
				(middleSnow init:)
				(rightSnow init:)
				(= cycles 4)
			)
			(1
				(PalVary 1 9 0) ; PalVaryReverse
				(= seconds 10)
			)
			(2
				(day init: setCycle: End self)
			)
			(3
				(eight init: setCycle: End self)
			)
			(4
				(gMessager say: 1 0 4 0 self) ; "Inside a hidden chamber where I had no right to be, I found the wheel at last or, could it be, the wheel found me...."
			)
			(5
				(ClearFlag 403)
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance arriveInGermany of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke init: setCycle: RandCycle)
				(leftSnow init:)
				(middleSnow init:)
				(rightSnow init:)
				(= seconds 3)
			)
			(1
				(car init: cycleSpeed: 10 setCycle: End self)
			)
			(2
				(car setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance leaveGermany of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(= cycles 1)
			)
			(1
				(smoke init: setCycle: RandCycle)
				(leftSnow init:)
				(middleSnow init:)
				(rightSnow init:)
				(= cycles 10)
			)
			(2
				(car
					view: 502
					setCel: 0
					setLoop: 0
					setPri: 160
					init:
					setCycle: End self
				)
			)
			(3
				(car view: 502 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(++ gDay)
				(gKeyDownHandler delete: self)
				(gCurRoom newRoom: 750)
			)
		)
	)
)

(instance endTheDay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke init: setCycle: RandCycle)
				(leftSnow init:)
				(middleSnow init:)
				(rightSnow init:)
				(= cycles 2)
			)
			(1
				(PalVary 0 500 10) ; PalVaryStart
				(castleLights init:)
				(= cycles 20)
			)
			(2
				(townLights init:)
				(= seconds 7)
			)
			(3
				(gCurRoom newRoom: 550)
			)
		)
	)
)

(instance car of Prop
	(properties
		x 216
		y 117
		view 501
	)
)

(instance castleLights of Prop
	(properties
		x 190
		y 69
		view 503
	)
)

(instance townLights of Prop
	(properties
		x 56
		y 139
		view 503
		loop 1
	)
)

(instance otherLights of Prop
	(properties
		x 56
		y 139
		view 503
		loop 2
	)
)

(instance smoke of Prop
	(properties
		x 38
		y 119
		view 500
	)
)

(instance leftSnow of Prop
	(properties
		x 55
		y 77
		view 505
	)

	(method (init)
		(super init:)
		(self setPri: 180 setCycle: Fwd)
	)
)

(instance middleSnow of Prop
	(properties
		x 166
		y 76
		view 505
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 180 setCycle: Fwd)
	)
)

(instance rightSnow of Prop
	(properties
		x 271
		y 78
		view 505
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 180 setCycle: Fwd)
	)
)

(instance day of Prop
	(properties
		x 61
		y 68
		view 375
	)

	(method (init)
		(self setPri: 199)
		(super init:)
	)
)

(instance eight of Prop
	(properties
		x 245
		y 40
		view 375
		loop 8
	)

	(method (init)
		(self setPri: 199)
		(super init:)
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

