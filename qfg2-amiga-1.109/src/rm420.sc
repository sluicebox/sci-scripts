;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use n001)
(use TopWindow)
(use Talker)
(use Interface)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	[talkStr 200]
	leftArmAtEnd
	rightArmAtEnd
)

(procedure (BackPrint theText)
	(Print theText &rest #at 184 140 #width 135)
)

(procedure (MyLowPrint theText)
	(Print theText &rest #at -1 180 #width 310)
)

(instance rm420 of Rm
	(properties
		picture 420
		style 16
	)

	(method (init)
		(Load rsVIEW 420 421 425)
		(Load rsSOUND 420)
		(super init: &rest)
		(egoHead init:)
		(adAvis init:)
		(rightArm init:)
		(leftArm init:)
		(leftflame cel: 1 init:)
		(rightflame init:)
		(HandsOff)
		(gCSound number: 420 loop: -1 priority: 5 playBed:)
		(self setScript: talkToEgo)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance talkToEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BackPrint 420 0) ; "You find you cannot move. The man before you has a low, pleasant voice, and eyes like a snake."
				(= cycles 3)
			)
			(1
				(Say
					adAvis
					self
					(Format @talkStr 420 1 @gUserName) ; "%s, I am your friend."
					420
					2
					420
					3
					420
					4
				)
				(adAvis cycleSpeed: 2 setScript: gesture setCycle: RandCycle -1)
			)
			(2
				(BackPrint 420 5) ; "You try to struggle, but your body will not obey."
				(BackPrint 420 6) ; "You cannot even close your eyes, but you try to avoid his gaze. There is something about his eyes, though..."
				(= cycles 3)
			)
			(3
				(Say
					adAvis
					self
					(Format @talkStr 420 1 @gUserName) ; "%s, I am your friend."
					420
					7
					420
					8
					420
					9
				)
			)
			(4
				(BackPrint 420 10) ; "You look at his eyes, and cannot look away. They seem to glow. His words seem to whirl around your head."
				(= cycles 3)
			)
			(5
				(Say
					adAvis
					self
					(Format @talkStr 420 1 @gUserName) ; "%s, I am your friend."
					420
					11
					420
					12
					420
					13
				)
			)
			(6
				(BackPrint 420 14) ; "You find yourself relaxing. You are with a friend. His eyes are gentle, and his smile warms you."
				(= cycles 3)
			)
			(7
				(Say adAvis self (Format @talkStr 420 15 @gUserName) 420 16) ; "%s, you know me. I am your friend, Ad Avis, who helped you escape from the dungeons of Raseir."
			)
			(8
				(BackPrint 420 17) ; "You find yourself nodding at this humble, gentle man."
				(= cycles 3)
			)
			(9
				(Say adAvis self 420 18 420 19 420 20) ; "To end the evil reign of Khaveen and restore our friend the Emir Arus, together we must go out into the desert."
			)
			(10
				(BackPrint 420 21) ; "Yes, you know this is something you've got to do, but you frown as you try to remember something you once heard about Iblis."
				(= cycles 3)
			)
			(11
				(Say adAvis self 420 22 420 23) ; "You remember the statue of Iblis, don't you? It has remarkable powers, and can break any spell it touches."
			)
			(12
				(MyLowPrint 420 24) ; "He puts his arm on your shoulders and you smile. Here is a man of great wisdom that you have trusted and respected, and he needs your help."
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 1)
			)
			(13
				(Print 420 25) ; "Together you will save the Emir. You and Ad Avis will get the statue of Iblis."
				(gCurRoom newRoom: 550)
				(self dispose:)
			)
		)
	)
)

(instance gesture of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state (Random 0 1))
				(= seconds (Random 2 4))
			)
			(1
				(= state -1)
				(if leftArmAtEnd
					(= leftArmAtEnd 0)
					(leftArm setCycle: Beg self)
				else
					(= leftArmAtEnd 1)
					(leftArm setCycle: End self)
				)
			)
			(2
				(= state -1)
				(if rightArmAtEnd
					(= rightArmAtEnd 0)
					(rightArm setCycle: Beg self)
				else
					(= rightArmAtEnd 1)
					(rightArm setCycle: End self)
				)
			)
		)
	)
)

(instance leftflame of Prop
	(properties
		x 41
		y 28
		view 420
		cel 1
	)
)

(instance rightflame of Prop
	(properties
		x 281
		y 31
		view 420
		loop 1
		cel 2
	)
)

(instance egoHead of Actor
	(properties
		x 220
		y 96
		view 421
	)
)

(instance adAvis of Talker
	(properties
		x 118
		y 92
		description {Ad Avis}
		view 425
		cel 4
		tLoop -1
		color 15
		back 5
	)

	(method (init)
		(super init: &rest)
		(= tWindow BotWindow)
	)
)

(instance leftArm of Prop
	(properties
		x 156
		y 115
		view 425
		loop 4
		cel 2
		cycleSpeed 2
	)
)

(instance rightArm of Prop
	(properties
		x 84
		y 124
		view 425
		loop 3
		cycleSpeed 2
	)
)

(instance rightArm2 of Prop ; UNUSED
	(properties
		x 58
		y 173
		view 425
		loop 2
		cel 4
		signal 16384
	)
)

