;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room68 0
)

(local
	local0
	local1
	local2
)

(instance Room68 of Rm
	(properties
		picture 68
		style 16
		south 17
	)

	(method (init)
		(Load rsVIEW 533)
		(Load rsVIEW 536)
		(super init:)
		(self setRegions: 603) ; regHauntedHouse
		(if (== global134 4)
			(Load rsVIEW 206)
			(Load rsVIEW 204)
		)
		((View new:) view: 536 loop: 7 cel: 0 posn: 77 109 setPri: 8 addToPic:)
		(if gNight
			((Prop new:)
				view: 536
				loop: 4
				posn: 79 98
				setPri: 11
				init:
				setCycle: Fwd
			)
		)
		(= gIndoors 1)
		((= local0 (Prop new:))
			isExtra: 1
			view: 533
			loop: 0
			posn: 223 131
			init:
			setPri: 11
			cycleSpeed: 4
			setCycle: Fwd
		)
		(gEgo
			view: 4
			setLoop: -1
			setCycle: Walk
			illegalBits: -32768
			setStep: 4 2
		)
		(switch gPrevRoomNum
			(67
				(gEgo posn: 56 165 loop: 0 init: baseSetter: (ScriptID 0 1)) ; smallBase
			)
			(64
				(gEgo posn: 262 167 loop: 1 init: baseSetter: (ScriptID 0 1)) ; smallBase
			)
			(62
				(gEgo posn: 97 79 loop: 2 init: baseSetter: 0)
			)
			(60
				(gEgo posn: 198 81 loop: 2 init: baseSetter: 0)
			)
			(17
				(gEgo posn: 153 182 loop: 3 init: baseSetter: (ScriptID 0 1)) ; smallBase
			)
		)
		((= local1 (Act new:))
			illegalBits: 0
			ignoreActors: 1
			setScript: mirrorTricks
		)
		(if (and (< 0 global134 255) (== global133 gCurRoomNum))
			(Notify 603 -1)
		)
	)

	(method (doit)
		(if (& (gEgo onControl: 0) $0040)
			(gEgo loop: 2 baseSetter: 0)
			(RedrawCast)
			(gCurRoom newRoom: 17)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gEgo loop: 1 baseSetter: 0)
			(RedrawCast)
			(gCurRoom newRoom: 67)
		)
		(if (& (gEgo onControl: 0) $0010)
			(gEgo loop: 3 baseSetter: 0)
			(RedrawCast)
			(gCurRoom newRoom: 60)
		)
		(if (& (gEgo onControl: 0) $0008)
			(gEgo loop: 3 baseSetter: 0)
			(RedrawCast)
			(gCurRoom newRoom: 62)
		)
		(if (& (gEgo onControl: 0) $0004)
			(gEgo loop: 0 baseSetter: 0)
			(RedrawCast)
			(gCurRoom newRoom: 64)
		)
		(if (and (& (gEgo onControl: 0) $0400) (not local2))
			(= local2 1)
			(gEgo setScript: moveOnTheStairs)
			(moveOnTheStairs changeState: 1)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 17)
			((ScriptID 603) keep: 0) ; regHauntedHouse
			(= global189 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					(
						(or
							(Said 'look[<around][/!*]')
							(Said 'look[<around]/room')
						)
						(Print 68 0) ; "This is the entry room of the old house. Downstairs, you see two open doorways, and upstairs, you see an additional two doorways. The room is cobwebbed and dusty, with wallpaper peeling from the walls."
					)
					(
						(or
							(Said 'is<how<time')
							(Said 'is<how/time')
							(Said 'read/time')
							(Said 'read/clock')
							(Said '[!*]/time')
							(Said 'look/time')
						)
						(Print
							(Format ; "The time is:  %u:%02u %s"
								@global300
								68
								1
								(if (mod global160 12)
									(mod global160 12)
								else
									12
								)
								global159
								(if (and (> global160 11) (< global160 24))
									{P.M.}
								else
									{A.M.}
								)
							)
							#title
							{TAMIR TIME}
							#at
							-1
							30
							#font
							gSmallFont
						)
					)
					((Said 'look>')
						(cond
							((Said '<behind/painting')
								(Print 68 2) ; "There is nothing behind the portraits."
							)
							((Said '/painting')
								(Print 68 3) ; "You notice two interesting portraits above the downstairs doorways. One, of a middle-aged woman, and the other, of a young man. You wonder who they are."
							)
							((Said '/mirror')
								(if (gEgo inRect: 161 154 195 189)
									(gEgo loop: 3)
									(Print 68 4) ; "You look in the broken mirror and see the reflection of a poor, but beautiful, peasant girl."
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((Said '/chandelier')
								(Print 68 5) ; "The lamp is old and dusty."
							)
							((Said '/stair')
								(Print 68 6) ; "The stairs lead up to the second story."
							)
							((Said '<in/clock')
								(Print 68 7) ; "There is nothing of interest inside the grandfather clock."
							)
							((Said '/clock')
								(Print 68 8) ; "An old grandfather clock sits in the corner. With each swing of its pendulum, time relentlessly marches on..."
							)
							((Said '/door')
								(Print 68 9) ; "Doors lead in all directions."
							)
							((Said '/wall')
								(Print 68 10) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 68 11) ; "There is nothing of interest on the floor."
							)
							((Said '/carpet')
								(Print 68 12) ; "A tattered rug lies on the floor."
							)
							((Said '/table')
								(Print 68 13) ; "A once-beautiful, marble-topped table rests below the broken mirror."
							)
						)
					)
					((Said 'wind/clock')
						(Print 68 14) ; "You can't. You don't know how."
					)
					((Said 'get/clock')
						(Print 68 15) ; "It's too heavy to move."
					)
					((Said 'open/clock')
						(Print 68 7) ; "There is nothing of interest inside the grandfather clock."
					)
					((Said 'get/carpet')
						(Print 68 16) ; "You don't need it."
					)
					((Said 'get/painting')
						(Print 68 17) ; "The portraits are too high, you could never reach them. Besides, they're not important."
					)
				)
			)
		)
	)
)

(instance mirrorTricks of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(client view: (gEgo view:) setPri: 0 init: hide:)
	)

	(method (doit)
		(if (gEgo inRect: 161 154 195 191)
			(client
				show:
				loop:
					(switch (gEgo loop:)
						(0 0)
						(1 1)
						(2 3)
						(3 2)
					)
				cel: (gEgo cel:)
				posn: (gEgo x:) (- 160 (/ (- (gEgo y:) 160) 3))
				setCycle: Walk
			)
		else
			(client hide:)
		)
	)
)

(instance moveOnTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(if (> (gEgo y:) 100)
					(gEgo illegalBits: 0 setMotion: MoveTo 196 81 self)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 99 137 self)
				)
				(gEgo setStep: 3 3)
			)
			(2
				(= local2 0)
				(NormalEgo)
				(HandsOn)
				(= global189 1)
				(gEgo setScript: 0)
				(if (< (gEgo y:) 130)
					(gEgo baseSetter: 0)
				else
					(gEgo baseSetter: (ScriptID 0 1)) ; smallBase
				)
			)
		)
	)
)

