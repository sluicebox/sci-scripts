;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm50 0
)

(local
	local0
	[local1 48] = [0 0 0 3 118 34 3 130 41 4 139 50 5 149 57 6 155 65 7 162 72 8 168 78 9 173 84 10 178 89 11 183 92 12 186 95 13 190 98 14 193 100 15 196 102 -1 -1 -1]
)

(instance rm50 of Rm
	(properties
		picture 50
	)

	(method (init)
		(gEgo normal: 0 posn: 92 60 init: hide:)
		(hatch init: hide:)
		(super init:)
		(HandsOff)
		(gLongSong number: 501 loop: -1 play:)
		(ship init:)
		(flames init:)
		(self setScript: shipArrives)
	)
)

(instance floatAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 3
					cel: 0
					posn: 76 17
					setCycle: Fwd
					moveSpeed: 5
					cycleSpeed: 9
					setStep: 3 3
					setMotion: MoveTo -25 27 self
				)
			)
			(1
				(gCurRoom drawPic: 16 -32759)
				(ship dispose:)
				(hatch dispose:)
				(= seconds 1)
			)
			(2
				(gEgo posn: 360 27 setMotion: MoveTo -40 50)
				(= seconds 5)
			)
			(3
				(EgoDead 948 0 0 50 0) ; "You drift endlessly through space wishing you had worn a jetpack to maneuver with. A you drift away never to be seen again the only thing you can think of to say is "Mommy!""
			)
		)
	)
)

(instance shipArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship setStep: 6 6 setMotion: MoveTo 228 180 self)
				(gLongSong2 number: 533 loop: -1 play:)
				(flames cycleSpeed: 4 setCycle: RandCycle)
			)
			(1
				(flames setCycle: Beg)
				(ship setStep: 4 4 setMotion: MoveTo 176 150 self)
			)
			(2
				(gLongSong2 pause:)
				(flames dispose:)
				(ship setStep: 2 2 setMotion: MoveTo 117 112 self)
			)
			(3
				(ship setCel: 1)
				(hatch show: setCycle: End self)
			)
			(4
				(if (gEgo has: 11) ; Jetpack
					(Print 50 1) ; "As you exit the ship, you carefully slide the jetpack on your back."
				else
					(Print 50 2) ; "As you undo your seatbelts and exit the escape pod. You can feel yourself just start to uncontrollably drifting away."
				)
				(= cycles 24)
			)
			(5
				(gEgo
					show:
					view: 33
					setLoop: (if (gEgo has: 11) 0 else 2) ; Jetpack
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(6
				(if (gEgo has: 11) ; Jetpack
					(= cycles 30)
				else
					(client setScript: floatAway)
				)
			)
			(7
				(gSoundEffects number: 502 loop: 1 play: hold: 1 fade:)
				(gEgo
					posn: 105 25
					loop: 1
					cel: 0
					cycleSpeed: 5
					setCycle: CT 2 1 self
				)
			)
			(8
				(if (!= [local1 (+= local0 3)] -1)
					(-- state)
					(gEgo
						cel: [local1 local0]
						x: [local1 (+ local0 1)]
						y: [local1 (+ local0 2)]
					)
				)
				(= cycles 2)
			)
			(9
				(gEgo
					setLoop: (gEgo loop:)
					setCel: (gEgo cel:)
					setMotion: MoveTo 205 103 self
				)
			)
			(10
				(gEgo hide:)
				(gSoundEffects stop:)
				(hatch setCycle: Beg self)
			)
			(11
				(hatch dispose:)
				(gLongSong2 pause: 0)
				(flames init: cycleSpeed: 2 setCycle: Osc)
				(ship setCel: 0 setStep: 2 2 setMotion: MoveTo 70 88 self)
			)
			(12
				(ship setStep: 4 4 setMotion: MoveTo 30 64 self)
			)
			(13
				(ship setStep: 7 7 setMotion: MoveTo -36 22 self)
			)
			(14
				(ship dispose:)
				(gLongSong2 stop:)
				(flames dispose:)
				(= cycles 3)
			)
			(15
				(gEgo setLoop: -1 setCel: -1)
				(gCurRoom newRoom: 51)
			)
		)
	)
)

(instance star0 of Prop ; UNUSED
	(properties
		x 59
		y 144
		view 150
		loop 3
		cel 2
		signal 24592
		cycleSpeed 2
	)
)

(instance star1 of Prop ; UNUSED
	(properties
		x 267
		y 26
		view 150
		loop 3
		cel 1
		signal 24592
		cycleSpeed 4
	)
)

(instance star2 of Prop ; UNUSED
	(properties
		x 293
		y 17
		view 150
		loop 3
		cel 1
		signal 24592
		cycleSpeed 6
	)
)

(instance hatch of Prop
	(properties
		x 94
		y 94
		view 150
		loop 1
		priority 10
		signal 24592
		cycleSpeed 8
	)
)

(instance flames of Prop
	(properties
		x 307
		y 223
		view 150
		loop 2
		priority 3
		signal 22544
		cycleSpeed 2
	)

	(method (doit)
		(= x (ship x:))
		(= y (ship y:))
		(super doit: &rest)
	)
)

(instance ship of Actor
	(properties
		x 307
		y 223
		view 150
		priority 3
		signal 22544
		moveSpeed 1
	)
)

