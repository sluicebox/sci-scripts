;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use n098)
(use Array)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm110 0
)

(local
	[local0 9] = [112 114 115 116 117 118 119 120 121]
)

(instance rm110 of LarryRoom
	(properties
		picture 110
		noControls 1
	)

	(method (init)
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(if (!= gPrevRoomNum 100)
			(SetCursor 98 0 0)
			(gGlobalSound2 number: 0 stop:)
		)
		(misc
			view: 110
			setLoop: 0
			cel: 0
			x: 84
			y: 131
			setPri: 131
			cycleSpeed: 0
			init:
		)
		(self setScript: cartoonScr)
	)

	(method (handleEvent event)
		(if (event type:)
			(if (< (script state:) 23)
				(event claimed: 1)
				(proc98_0)
			else
				(proc79_5)
				(gCast eachElementDo: #dispose)
				(gThePlane drawPic: -2)
				(Palette 2 0 255 100) ; PalIntensity
				(event claimed: 1)
				(proc98_0)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance misc of Prop
	(properties
		view 98
	)
)

(instance cartoonScr of Script
	(properties)

	(method (dispose)
		(sfx number: 0 dispose:)
		(proc79_12 121 444 385)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (<= temp0 8) ((++ temp0))
					(Load rsVIEW [local0 temp0])
				)
				(proc79_11 121 444 385)
				(= cycles 2)
			)
			(1
				(gGlobalSound1 number: 120 loop: -1 play:)
				(= seconds 5)
			)
			(2
				(sfx number: 121 loop: 1 play: self)
				(misc setCycle: End self)
			)
			(3)
			(4
				(SetScroll gThePlane 0 -20 111 0 1 0)
				(misc view: 114 x: 2 y: 2)
				(= seconds 2)
			)
			(5
				(misc view: 115)
				(= ticks 20)
			)
			(6
				(misc view: 116)
				(= ticks 20)
			)
			(7
				(misc view: 115)
				(= ticks 20)
			)
			(8
				(misc view: 114)
				(= ticks 20)
			)
			(9
				(misc view: 115)
				(= ticks 20)
			)
			(10
				(misc view: 116)
				(= ticks 20)
			)
			(11
				(misc view: 115)
				(= ticks 20)
			)
			(12
				(misc view: 114)
				(= ticks 20)
			)
			(13
				(misc view: 115)
				(= ticks 20)
			)
			(14
				(misc view: 116)
				(= ticks 20)
			)
			(15
				(misc view: 117)
				(= register 7)
				(= ticks 20)
			)
			(16
				(if (-- register)
					(-- state)
				)
				(if (== (misc view:) 117)
					(misc view: 118)
				else
					(misc view: 117)
				)
				(= ticks 2)
			)
			(17
				(misc view: 118)
				(= ticks 20)
			)
			(18
				(misc view: 119)
				(= ticks 10)
			)
			(19
				(misc view: 120)
				(= ticks 10)
			)
			(20
				(misc view: 121)
				(= ticks 30)
			)
			(21
				(sfx number: 444 loop: 1 play:)
				(= cycles 4)
			)
			(22
				(ShakeScreen 3 ssUPDOWN)
				(= ticks 40)
			)
			(23
				(sfx2 number: 385 loop: 1 play:)
				(= ticks 120)
			)
			(24
				(if (> gHowFast 3)
					(misc cycleSpeed: 8)
				else
					(misc cycleSpeed: 4)
				)
				(misc view: 112 x: 76 y: 43 cel: 0 setCycle: Fwd)
				(SetScroll gThePlane 0 -20 112 0 0 0)
				(= temp1 (ByteArray new: 30))
				(Message msgGET 110 0 0 1 1 (temp1 data:)) ; "\04 1994 Sierra On-Line, Inc."
				(proc79_4 (temp1 data:) 75 0 100 160 318 900)
				(temp1 dispose:)
				(= seconds 6)
				(= register 100)
			)
			(25
				(proc79_5)
				(= cycles 2)
			)
			(26
				(if (> (-= register 4) -1)
					(-- state)
					(Palette 2 0 255 register) ; PalIntensity
				else
					(sfx2 number: 0 stop:)
					(sfx number: 0 stop:)
				)
				(if (> gHowFast 3)
					(= ticks 4)
				else
					(= ticks 2)
				)
			)
			(27
				(Palette 2 0 255 0) ; PalIntensity
				(gCurRoom newRoom: 120)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance sfx2 of Sound
	(properties
		flags 5
	)
)

