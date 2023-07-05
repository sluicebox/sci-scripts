;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use eRS)
(use EcoFeature)
(use EcoDialog)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	rm680 0
)

(local
	local0
	[local1 11] = [5 8 11 9 10 4 13 8 13 15 -1]
	local12 = 9
	local13
	local14
	local15
	local16
)

(procedure (localproc_0 param1 &tmp temp0)
	(= local14 1)
	(= local15 0)
	(= local16 param1)
)

(procedure (localproc_1 param1 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
		(Palette palSET_INTENSITY 33 255 temp0)
		(Wait param1)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp3 0)
	(= temp4 250)
	(= temp5 180)
	(while 1
		(if (== (= temp2 [local1 temp3]) -1)
			(break)
		)
		(= temp1 0)
		(while temp2
			(= temp0 (endingCredits new:))
			(temp0
				setLoop: local0
				setCel: temp1
				setMotion: MoveTo 159 -15
				init:
			)
			(++ temp1)
			(-- temp2)
			(while (> (temp0 y:) temp4)
				(= gGameTime (+ gTickOffset (GetTime)))
				(Animate (gCast elements:) 1)
			)
		)
		(while (> (temp0 y:) temp5)
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
		(LoadMany rsVIEW 681 959)
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
		(SetCursor 0 200)
		(if local14
			(Palette palSET_INTENSITY 0 255 (+= local15 local16))
			(if (>= local15 100)
				(= local14 0)
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
				(if local14
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
				(sparkle setCycle: CT End self)
				(pierwave setCycle: CT End self)
				(boatwave setCycle: CT End self)
				(stars setCycle: CT End self)
				(localproc_2)
			)
			(9
				(= seconds 10)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetCursor 957 0 8)
				(Message msgGET 0 1 0 0 35 @temp0) ; "Select:"
				(Message msgGET 0 1 0 0 36 @temp30) ; "Restore saved game"
				(Message msgGET 0 1 0 1 1 @temp60) ; "Restart game"
				(Message msgGET 0 1 0 0 7 @temp90) ; "Sorry, gotta Quit"
				(repeat
					(switch
						(proc821_3
							@temp0
							64
							-1
							40
							109
							78
							@temp30
							1
							109
							78
							@temp60
							2
							109
							78
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

(instance endingCredits of EcoActor
	(properties
		x 159
		y 330
		view 959
		priority 15
		signal 24592
		illegalBits 0
		moveSpeed 1
	)

	(method (doit)
		(super doit: &rest)
		(if (< y -10)
			(self dispose:)
			(if (and (== loop local12) (== cel local13))
				(sEndIt cue:)
			)
		)
	)
)

(instance dolphin of EcoProp
	(properties
		x 99
		y 79
		view 681
		signal 16384
		cycleSpeed 18
	)
)

(instance sparkle of EcoProp
	(properties
		x 42
		y 98
		view 681
		loop 2
		cel 1
		cycleSpeed 24
	)
)

(instance adamwave of EcoProp
	(properties
		x 184
		y 67
		view 681
		loop 3
	)
)

(instance pierwave of EcoProp
	(properties
		x 193
		y 173
		view 681
		loop 4
		cycleSpeed 18
	)
)

(instance boatwave of EcoProp
	(properties
		x 108
		y 189
		view 681
		loop 5
		cel 3
		cycleSpeed 18
	)
)

(instance stars of EcoProp
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

