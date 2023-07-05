;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Rev)
(use Actor)
(use System)

(public
	rm120 0
)

(local
	seenMsg
)

(instance rm120 of LLRoom
	(properties
		picture 120
	)

	(method (init)
		(LoadMany rsVIEW 120 1122 1123 124)
		(LoadMany rsSOUND 120)
		(HandsOff)
		(super init:)
		(Vinnie_a init: setPri: 10 addToPic:)
		(bossHand init: cycleSpeed: 6 setCel: (bossHand lastCel:) stopUpd:)
		(bossSmoke init: cycleSpeed: 24 stopUpd:)
		(bossRtBrow init: cycleSpeed: 24 stopUpd:)
		(bossLtBrow init: cycleSpeed: 24 stopUpd:)
		(gAddToPics doit:)
		(SetFFRoom 155)
		(gTheMusic number: 120 flags: 1 setLoop: -1 play:)
		(self setScript: sCartoon)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheMusic stop:)
	)
)

(instance slide of Prop
	(properties
		x 130
		y 80
		view 120
	)
)

(instance Vinnie_a of View
	(properties
		name {Vinnie}
		x 68
		y 65
		view 1122
		loop 1
	)
)

(instance Vinnie_b of Talker
	(properties
		name {Vinnie}
		x 1
		y 180
		nsTop 66
		nsLeft 67
		view 1122
		loop 3
		talkWidth 280
	)

	(method (init)
		(= mouth goon1Mouth)
		(super init: &rest)
	)
)

(instance goon1Mouth of Prop
	(properties
		nsTop 30
		nsLeft 24
		view 1122
		cycleSpeed 5
	)
)

(instance Bruno_a of Prop ; UNUSED
	(properties
		name {Bruno}
		x 283
		y 115
		view 1123
	)
)

(instance Bruno_b of Talker
	(properties
		name {Bruno}
		x 115
		y 180
		nsTop 95
		nsLeft 267
		view 1123
		loop 3
		talkWidth 200
	)

	(method (init)
		(= mouth goon2Mouth)
		(super init: &rest)
	)
)

(instance goon2Mouth of Prop
	(properties
		view 1123
		cycleSpeed 5
	)
)

(instance bossHand of Prop
	(properties
		x 156
		y 150
		view 124
		loop 4
	)
)

(instance bossSmoke of Prop
	(properties
		x 167
		y 91
		view 124
		loop 3
	)
)

(instance bossRtBrow of Prop
	(properties
		x 227
		y 57
		view 124
		loop 1
	)
)

(instance bossLtBrow of Prop
	(properties
		x 213
		y 57
		view 124
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(Say Vinnie_b 120 0 108 139 self) ; "As you know, ever since LPs came out back in the 50s, our recording industry subliminal message campaign, `Just Do Drugs,' has been a resounding success."
			)
			(2
				(= ticks 123)
			)
			(3
				(slide init: stopUpd:)
				(= cycles 2)
			)
			(4
				(Say Vinnie_b 120 1 108 139 self) ; "Drug sales have never been better, and prices remain firm as this slide shows."
			)
			(5
				(= ticks 60)
			)
			(6
				(Say Vinnie_b 120 2 108 139 self) ; "Discounting our disastrous push to quadraphonic, results have been most gratifying."
			)
			(7
				(= ticks 60)
			)
			(8
				(Vinnie_b talkWidth: 120)
				(Say Vinnie_b 120 3 108 139 self) ; "Now to you, Bruno."
			)
			(9
				(bossHand
					setCel: (bossHand lastCel:)
					startUpd:
					cycleSpeed: 18
					setCycle: Rev
				)
				(bossSmoke startUpd: setCycle: Rev)
				(= ticks 240)
			)
			(10
				(bossHand setCel: (bossHand lastCel:) stopUpd: setCycle: 0)
				(bossSmoke stopUpd: setCycle: 0)
				(bossRtBrow stopUpd: setCycle: 0)
				(bossLtBrow stopUpd: setCycle: 0)
				(= cycles 5)
			)
			(11
				(Say Bruno_b 120 4 108 139 self) ; "Thanks, Vinnie. Boss, as you know, our pornography division also enjoyed a period of explosive growth as this slide shows."
			)
			(12
				(= ticks 60)
			)
			(13
				(slide startUpd: cel: 1)
				(= cycles 2)
			)
			(14
				(Say Bruno_b 120 5 108 139 self) ; "Unfortunately, after a quarter century of positive ROI, recent results have been flaccid."
			)
			(15
				(= ticks 60)
			)
			(16
				(Say Bruno_b 120 6 108 139 self) ; "We attempted to counter this trend with a heavy investment in rap music, thinking teenagers' continuous exposure to pornographic lyrics would help sales of our wider product line."
			)
			(17
				(= ticks 60)
			)
			(18
				(Say Bruno_b 120 7 108 139 self) ; "But the result is obvious: painfully declining penetration!"
			)
			(19
				(= ticks 60)
			)
			(20
				(slide cel: 2)
				(bossHand startUpd: setCel: (bossHand lastCel:) setCycle: Rev)
				(bossSmoke startUpd: setCycle: Rev)
				(= ticks 240)
			)
			(21
				(bossHand setCel: (bossHand lastCel:) stopUpd: setCycle: 0)
				(bossSmoke stopUpd: setCycle: 0)
				(bossRtBrow stopUpd: setCycle: 0)
				(bossLtBrow stopUpd: setCycle: 0)
				(= cycles 5)
			)
			(22
				(Say Bruno_b 120 8 108 139 self) ; "Our market research failed to foresee the widespread growth of cable!"
			)
			(23
				(= ticks 60)
			)
			(24
				(Say Bruno_b 120 9 108 139 self) ; "Even when we forced through rapidly reduced VCR prices in the early 80s it just didn't help our X-rated movie sales--no one buys them!"
			)
			(25
				(= ticks 60)
			)
			(26
				(Say Bruno_b 120 10 108 139 self) ; "Why should they, when they can use their remote controls to flip through channel after channel of almost the same stuff in the comfort of their own homes?"
			)
			(27
				(= ticks 60)
			)
			(28
				(Say Bruno_b 120 11 108 139 self) ; "Now even the networks are getting into the act!"
			)
			(29
				(= ticks 60)
			)
			(30
				(gCurRoom newRoom: 130)
			)
		)
	)
)

