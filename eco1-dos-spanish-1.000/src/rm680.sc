;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use eRS)
(use Language)
(use n940)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm680 0
)

(local
	local0
	[local1 13] = [2 3 2 3 8 8 5 2 9 4 4 2 -1]
	local14 = 11
	local15 = 1
	local16
	local17
	local18
)

(procedure (localproc_0 param1 &tmp temp0)
	(= local16 1)
	(= local17 0)
	(= local18 param1)
)

(procedure (localproc_1 param1 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
		(Palette palSET_INTENSITY 33 255 temp0)
		(Wait param1)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp3 0)
	(= temp4 305)
	(= temp5 280)
	(while 1
		(if (== (= temp2 [local1 temp3]) -1)
			(break)
		)
		(= temp1 0)
		(while temp2
			(= temp0 (endingCredits new:))
			(if (== temp1 0)
				(temp0
					view: (proc0_6 1959 2959 3959 4959 959)
					setLoop: local0
					setCel: temp1
					setMotion: MoveTo 159 -15
					init:
				)
			else
				(temp0
					view: 959
					setLoop: local0
					setCel: temp1
					setMotion: MoveTo 159 -15
					init:
				)
			)
			(++ temp1)
			(-- temp2)
			(while (> (temp0 y:) temp4)
				(= gGameTime (+ gTickOffset (GetTime)))
				(Animate (gCast elements:) 1)
			)
		)
		(while
			(if (< local0 10)
				(> (temp0 y:) 140)
			else
				(> (temp0 y:) temp5)
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(Animate (gCast elements:) 1)
		)
		(++ temp3)
		(++ local0)
	)
)

(instance rm680 of EcoRoom
	(properties
		picture 680
		style 7
	)

	(method (init)
		(LoadMany rsVIEW 681 (proc0_6 1959 2959 3959 4959 959))
		(LoadMany rsSOUND 382 385 383 917 398)
		(super init: &rest)
		(adamwave init: setCycle: Fwd)
		(sparkle init: setCycle: Fwd)
		(pierwave init: setCycle: Fwd)
		(boatwave init: setCycle: Fwd)
		(stars init: setCycle: Fwd)
		(HandsOff)
		(SetCursor 957 0 9)
		(self setScript: sEndIt)
	)

	(method (doit)
		(SetCursor 957 0 9)
		(MoveCursor 0 200)
		(if local16
			(Palette palSET_INTENSITY 0 255 (+= local17 local18))
			(if (>= local17 100)
				(= local16 0)
			)
		)
		(super doit: &rest)
	)
)

(instance sEndIt of Script
	(properties)

	(method (changeState newState &tmp [temp0 30] [temp30 30] [temp60 30] [temp90 30])
		(switch (= state newState)
			(0
				(localproc_0 1)
				(= ticks 300)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 120)
			)
			(2
				(if local16
					(-- state)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(3
				(gSoundEffects number: 917 loop: 1 play:)
				(dolphin init: setLoop: 0 setCel: 0 setCycle: CT 9 1 self)
			)
			(4
				(sfx number: 382 loop: 1 play:)
				(dolphin setCycle: End self)
			)
			(5
				(sfx number: 385 loop: 1 play:)
				(dolphin setLoop: 1 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(6
				(gSoundEffects number: 398 loop: 1 play:)
				(= ticks 30)
			)
			(7
				(gLongSong number: 383 loop: -1 play:)
				(dolphin dispose:)
				(= ticks 180)
			)
			(8
				(localproc_2)
			)
			(9
				(= ticks 180)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetCursor 957 0 7)
				(proc932_8 98 0 35 @temp0)
				(proc932_8 98 0 36 @temp30)
				(proc932_8 98 0 37 @temp60)
				(proc932_8 98 0 7 @temp90)
				(repeat
					(switch
						(PrintD
							@temp0
							67
							-1
							40
							106
							81
							@temp30
							1
							106
							81
							@temp60
							2
							106
							81
							@temp90
							3
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart:)
						)
						(3
							(gLongSong fade: 0 10 4 1)
							(localproc_1 8)
							(Wait 0)
							(Wait 300)
							(= gQuit 1)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance endingCredits of Actor
	(properties
		x 159
		y 330
		priority 15
		signal 24592
		illegalBits 0
		moveSpeed 3
	)

	(method (doit)
		(super doit: &rest)
		(if (< y -10)
			(self dispose:)
			(if (and (== loop local14) (== cel local15))
				(sEndIt cue:)
			)
		)
	)
)

(instance dolphin of Prop
	(properties
		x 99
		y 79
		view 681
		signal 16384
		cycleSpeed 18
	)
)

(instance sparkle of Prop
	(properties
		x 42
		y 98
		view 681
		loop 2
		cel 1
		cycleSpeed 24
	)
)

(instance adamwave of Prop
	(properties
		x 184
		y 67
		view 681
		loop 3
	)
)

(instance pierwave of Prop
	(properties
		x 193
		y 173
		view 681
		loop 4
		cycleSpeed 18
	)
)

(instance boatwave of Prop
	(properties
		x 108
		y 189
		view 681
		loop 5
		cel 3
		cycleSpeed 18
	)
)

(instance stars of Prop
	(properties
		x 163
		y 26
		view 681
		loop 6
		cel 3
		cycleSpeed 24
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 382
	)
)

