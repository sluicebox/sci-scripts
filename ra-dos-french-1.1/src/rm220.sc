;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Conversation)
(use Talker)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm220 0
	Laura220 2
	Sam220 3
)

(local
	[local0 65] = [-1 1 0 0 1 0 0 0 -1 1 0 0 2 0 0 0 -1 1 0 0 3 0 0 0 -1 1 0 0 4 0 0 0 -1 1 0 0 5 0 0 0 -1 1 0 0 6 0 0 0 -1 1 0 0 7 0 0 0 -1 1 0 0 8 0 0 0 0]
	[local65 49] = [-1 1 0 0 9 0 0 0 -1 1 0 0 10 0 0 0 -1 1 0 0 11 0 0 0 -1 1 0 0 12 0 0 0 -1 1 0 0 13 0 0 0 -1 1 0 0 14 0 0 0 0]
)

(instance rm220 of LBRoom
	(properties
		picture 220
	)

	(method (init)
		(LoadMany rsVIEW 221 220 1220 1221)
		(Load rsSOUND 220)
		(Load rsPIC 225)
		(self setRegions: 92) ; intro
		(super init:)
		(WrapMusic dispose:)
		(gGameMusic1 number: 220 loop: -1 flags: 1 play:)
		(fan init: setCycle: Fwd)
		(shadowL init: setScript: sLeftShadow)
		(shadowR init: setScript: sRightShadow)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo get: -1 2) ; notebook
				(myConv load: @local0 init: self) ; "I really want to thank you for hiring me, Mr. Augustini."
			)
			(2
				(gCurRoom setInset: inLauraPeeks)
				(= seconds 5)
			)
			(3
				(gEgo hide:)
				(gCurRoom setInset: 0)
				(= cycles 1)
			)
			(4
				(myConv load: @local65 init: self) ; "I can do it, Mr. Augustini. Just give me a chance."
			)
			(5
				(gGameMusic1 fade: self)
			)
			(6
				(gCurRoom newRoom: 26) ; actBreak
			)
		)
	)
)

(instance sRightShadow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shadowR setLoop: 1 setMotion: MoveTo 180 84 self)
			)
			(1
				(= seconds (Random 3 6))
			)
			(2
				(shadowR posn: -20 89)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sLeftShadow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(shadowL setLoop: 0 setMotion: MoveTo -30 89 self)
			)
			(2
				(shadowL posn: 175 85)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance shadowL of Actor
	(properties
		x 175
		y 84
		view 221
		priority 4
		signal 16400
	)
)

(instance shadowR of Actor
	(properties
		x -20
		y 89
		view 221
		loop 1
		priority 4
		signal 16400
	)
)

(instance fan of Prop
	(properties
		x 10
		y 177
		view 220
	)
)

(instance inLauraPeeks of Inset
	(properties
		picture 225
		hideTheCast 1
	)
)

(instance myConv of Conversation
	(properties)
)

(instance Sam220 of Talker
	(properties
		x 0
		y 0
		view 1220
		loop 3
		disposeWhenDone 0
		talkWidth 200
		modeless 1
		back 15
		textX 10
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 samEyes samMouth &rest)
	)
)

(instance samMouth of Prop
	(properties
		nsTop 63
		nsLeft 247
		view 1220
	)
)

(instance samEyes of Prop
	(properties
		nsTop 58
		nsLeft 251
		view 1220
		loop 2
	)
)

(instance Laura220 of Talker
	(properties
		x 0
		y 0
		view 1221
		loop 3
		priority 14
		signal 16
		disposeWhenDone 0
		talkWidth 150
		modeless 1
		back 15
		textX 139
		textY 104
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 lMouth &rest)
	)
)

(instance lMouth of Prop
	(properties
		nsTop 100
		nsLeft 117
		view 1221
		priority 7
		signal 16
	)
)

