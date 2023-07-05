;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use Print)
(use Talker)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm450 0
	genTalker 15
	pTalker 19
)

(instance rm450 of Rm
	(properties
		picture 84
		style 10
	)

	(method (init)
		(gEgo view: 0 init: hide: stopUpd:)
		(switch gPrevRoomNum
			(420
				(gCurRoom setScript: sInitRoom)
			)
			(else
				(gCurRoom setScript: sInitRoom)
			)
		)
		(super init:)
		(gGame handsOff:)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sInitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pHead init:)
				(pArm init:)
				(= cycles 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(pHead setLoop: 0 cycleSpeed: 15 setCycle: CT 2 1 self)
			)
			(3
				(gMessager say: 1 0 0 0 self) ; "|c4|Aargh!"
			)
			(4
				(= seconds 2)
			)
			(5
				(pArm cel: 1)
				(= seconds 1)
			)
			(6
				(gMessager say: 1 0 1 0 self) ; "Bad soup... secret path... over the ridge! Arrrgh!"
			)
			(7
				(pArm cel: 0)
				(pHead cel: 3)
				(= seconds 2)
			)
			(8
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance pHead of Actor
	(properties
		x 143
		y 70
		view 460
	)
)

(instance pArm of Actor
	(properties
		x 118
		y 153
		view 460
		loop 1
	)
)

(instance pTalker of Talker
	(properties
		x 134
		y 36
		view 460
		cel 2
		talkWidth 200
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp0 talkWidth)
		((= temp1 (gSystemWindow new:)) color: color back: back)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= saveCursor gTheCursor)
			(gGame setCursor: 996)
		else
			(= saveCursor 0)
		)
		(if showTitle
			(Print addTitle: name)
		)
		(Print
			window: temp1
			posn: x y
			font: font
			width: temp0
			addText: param1
			modeless: 1
			init:
		)
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 120 tailY: 36 xOffset: -5 isBottom: 1)
		(self cel: 2 loop: 0)
		(super init: 0 pEyes pMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance pEyes of Actor
	(properties
		nsTop 11
		nsLeft 31
		view 460
		loop 2
		cel 1
		priority 6
		signal 16
	)
)

(instance pMouth of Actor
	(properties
		nsTop 34
		nsLeft 30
		view 460
		loop 3
		cel 4
		priority 6
		signal 16400
	)
)

(instance genTalker of Narrator
	(properties
		talkWidth 200
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(switch global122
			(19
				(gSystemWindow tailX: 160 tailY: 180 xOffset: 0 isBottom: 1)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

