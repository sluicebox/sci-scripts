;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 207)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	closeGates 0
	walkThruGates 1
)

(instance guard1 of Prop
	(properties
		y 148
		x 106
		view 154
		loop 2
	)
)

(instance guard2 of Prop
	(properties
		y 148
		x 175
		view 154
		loop 1
	)
)

(instance guardWindow of SysWindow
	(properties
		color 7
		back 1
		title { Guards }
		brLeft 30
		brBottom 100
		brRight 290
	)
)

(instance closeGates of Script
	(properties)

	(method (dispose)
		(guard1 dispose: delete:)
		(guard2 dispose: delete:)
		(super dispose:)
		(DisposeScript 207)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard1 init:)
				(guard2 init:)
				(gEgo setLoop: 2 setMotion: MoveTo 130 130 self)
			)
			(1
				(guard1 cel: 1)
				(guard2 cel: 1)
				(gEgo setMotion: MoveTo 137 136 self)
			)
			(2
				(Print 207 0 #font 4 #window guardWindow) ; "You cannot go this way. There is a thief loose in the bazaar and many merchants are complaining. The Jaffa Gate will be locked while we search for him."
				(Print 207 1 #font 4 #window guardWindow) ; "We do not know who he is, but when we find him, he is a dead man. Now move along, before we begin to suspect that YOU may be the thief."
				(gEgo setLoop: 3 setMotion: MoveTo 119 120 self)
			)
			(3
				(SetFlag 223)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance walkThruGates of Script
	(properties)

	(method (dispose)
		(guard1 dispose: delete:)
		(guard2 dispose: delete:)
		(super dispose:)
		(DisposeScript 207)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard1 cel: 1 init:)
				(guard2 cel: 1 init:)
				(gEgo setMotion: MoveTo 142 154 self)
			)
			(1
				(gEgo loop: 3)
				(gTObj talkCue: self)
				(Talk 207 2 207 3) ; "You may enter, stranger, but you may not leave until we have finished searching the city for thieves."
			)
			(2
				(gEgo setMotion: MoveTo 142 136 self)
			)
			(3
				(guard1 cel: 1)
				(guard2 cel: 1)
				(gCurRoom leaveRoom: 56 124 117)
			)
		)
	)
)

